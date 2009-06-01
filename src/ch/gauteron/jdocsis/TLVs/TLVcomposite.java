/****************************************************************************
 *                                                                          *
 *  jdocsis - TLVcomposite.java                                             *
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

package ch.gauteron.jdocsis.TLVs;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import ch.gauteron.jdocsis.encoder.Lexer2TLVMapper;

public abstract class TLVcomposite extends TLV
{
   int expectedLexerType = 0;

   public boolean processNode(CommonTree node) throws NullPointerException
   {
      super.processNode(node);

      CommonTree child = (CommonTree)this.node.getChild(0);

      Token token = child.getToken();

      parseChildren();
      // TODO: Compute tlvLength
      return true;
   }

   void parseChildren()
   {
      this.tlvInit = false;
      this.tlvLength = 0;
      if(this.node == null)
         return;

      Lexer2TLVMapper mapper = new Lexer2TLVMapper();

      for(int i = 0; i < this.node.getChildCount(); i++)
      {
         CommonTree child = (CommonTree)this.node.getChild(i);
         int typ = child.getType();
         if(mapper.getClassName(typ) != null)
         {
            TLV o = mapper.instanciateClass(typ);
            o.setParent(this);
            if(o != null)
               if(o.processNode((CommonTree)child))
               {
                 this.children.add(o);
                 this.tlvLength += o.getTLVLength();
              }
         }
         else
            System.out.println(child.getType() + ": " + child.getText());
      }
      this.tlvInit = true;
   }

   public String toString()
   {
      String res = "TLV " + this.getTlvCodeString() + " (" + this.tlvName + "), Length = " + this.tlvLength;
      for(int i = 0; i < this.children.size(); i++)
      {
         res += "\n" + ((TLV)this.children.get(i)).toString();
      }


      return res;
   }

   public byte[] getEncoding()
   {
      byte[] buffer = new byte[255];
      short pos = 0;

      for(int i = 0; i < this.children.size(); i++)
      {
         byte[] res = ((TLV)this.children.get(i)).getEncoding();
         int len = res.length;
         if(pos + len <= buffer.length)
            for(short j = 0; j < len; j++)
               buffer[pos + j] = res[j];
         pos += len;
      }

      if(pos > 255)
         return null;   // TODO: Throw an exception

      byte[] res = new byte[pos+2];
      res[0] = (byte)tlvCode;
      res[1] = (byte)pos;
      for(int i = 0; i < pos; i++)
         res[i + 2] = buffer[i];

      return res;
   }
}

