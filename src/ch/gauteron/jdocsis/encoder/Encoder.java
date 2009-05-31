/****************************************************************************
 *                                                                          *
 *  jdocsis - Encoder.java                                                  *
 *                                                                          *
 *  Copyright (C) 2009, Yann Gauteron <yann.gauteron@gauteron.ch>           *
 *  All rights reserved.                                                    *
 *                                                                          *
 *  Redistribution and use in source and binary forms, with or without      *
 *  modification, are permitted provided that the following conditions are  *
 *  met:                                                                    *
 *    1. Redistributions of source code must retain the above copyright     *
 *       notice, this list of conditions and the following disclaimer.      *
 *    2. Redistributions in binary form must reproduce the above copyright  *
 *       notice, this list of conditions and the following disclaimer in    *
 *       the documentation and/or other materials provided with the         *
 *       distribution.                                                      *
 *                                                                          *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS     *
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT       *
 *  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR   *
 *  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT    *
 *  HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,  *
 *  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT        *
 *  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,   *
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY   *
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT     *
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE   *
 *  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.    *
 *                                                                          *
 ****************************************************************************/

package ch.gauteron.jdocsis.encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.antlr.runtime.tree.CommonTree;

import ch.gauteron.jdocsis.TLVs.TLV;
import ch.gauteron.jdocsis.TLVs.TLV_CMMIC;
import ch.gauteron.jdocsis.TLVs.TLV_CMTSMIC;
import ch.gauteron.jdocsis.TLVs.TLV_EndOfDataMkr;

/*
 * TODO: Improve management of errors, exceptions, ...
 */

public class Encoder
{
   public final static short TYPE_DOCSIS      = 100;
   public final static short TYPE_PACKETCABLE = 200;

   private ArrayList<TLV> tlvs = new ArrayList<TLV>();
   private short configType = TYPE_DOCSIS;
   private String secret = null;


   public Encoder()
   {
      this(TYPE_DOCSIS, null);
   }

   public Encoder(String secret)
   {
      this(TYPE_DOCSIS, secret);
   }

   public Encoder(short configType, String secret)
   {
      this.configType = configType;
      this.secret = secret;
   }

   public boolean parseASTTree(CommonTree tree) throws NullPointerException
   {
      boolean result = true;

      if(tree == null)
         throw new NullPointerException("tree argument provided to DocsisConfig.parseASTTree() is null.");

      for(int i = 0; i < tree.getChildCount(); i++)
      {
         int lexType = tree.getChild(i).getType();
         if(Lexer2TLVMapper.getClassName(lexType) == null)
         {
            System.err.println("WARNING: " + tree.getChild(i).getText() + " (" + lexType + ") is an unsupported lexer type");

            System.err.println("  Ignored and continuing!");
            result = false;
            break;
         }
         TLV tlv = Lexer2TLVMapper.instanciateClass(lexType);
         if(tlv == null)
         {
            System.err.println("WARNING: Impossible to instanciate a class for " + tree.getChild(i).getText() + "(" + lexType + ")");
            System.err.println("  Ignored and continuing!");
            result = false;
            break;
         }
         tlv.processNode((CommonTree)tree.getChild(i));
         tlvs.add(tlv);
      }

      return result;
   }

   public int getTlvCount()
   {
      return tlvs.size();
   }

   public byte[] getEncoding()
   {
      if(tlvs.size() == 0)
         return null;

      ByteArrayOutputStream os = new ByteArrayOutputStream();

      try
      {
         for(int i = 0; i < tlvs.size(); i++)
         {
            TLV tlv = tlvs.get(i);
            byte[] encod = tlv.getEncoding();
            os.write(encod);
         }
      }
      catch(IOException e) // TODO: Perform a more precise exception handling!
      {
         System.err.println("ERROR: I/O error");
         System.err.println(e);
         System.exit(300);
      }

      byte[] tlvEncoding = os.toByteArray(); // We backup the generated encoding for further processing
      ArrayList<TLV> tlvMIC = (ArrayList<TLV>)tlvs.clone();

      TLV cmMIC = new TLV_CMMIC(tlvEncoding);
      try
      {
         os.write(cmMIC.getEncoding());
      }
      catch(IOException e)
      {
         System.err.println("ERROR: I/O error");
         System.err.println(e);
         System.exit(300);
      }
      tlvMIC.add(cmMIC);

      TLV cmtsMIC = new TLV_CMTSMIC(tlvMIC, this.secret);
      try
      {
         os.write(cmtsMIC.getEncoding());
      }
      catch(IOException e)
      {
         System.err.println("ERROR: I/O error");
         System.err.println(e);
         System.exit(300);
      }


      // Add EndOfDataMkr before making the MD5
      TLV eod = new TLV_EndOfDataMkr();
      try
      {
         os.write(eod.getEncoding());
      }
      catch(IOException e)
      {
         System.err.println("ERROR: I/O error");
         System.err.println(e);
         System.exit(300);
      }


      return os.toByteArray();
   }
}
