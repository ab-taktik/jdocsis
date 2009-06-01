/****************************************************************************
 *                                                                          *
 *  jdocsis - TLV_GenericTLV.java                                           *
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

import java.util.regex.Pattern;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

// TODO: Handle textual OID
// ========================
public class TLV_GenericTLV extends TLV
{
   byte[] tlvValue = null;

   public TLV_GenericTLV()
   {
      super();
      this.tlvCode = 0;
      this.tlvLength = 0;
      this.tlvName = "GenericTLV";
      this.parentTLV = new int[] {0};
   }

   public boolean processNode(CommonTree node) throws NullPointerException
   {
      super.processNode(node);

      this.tlvInit = false;
      this.tlvCode = 0;
      this.tlvLength = 0;
      this.tlvValue = null;

      // ID_GENERICTLV^          TLV_CODE T_INT TLV_LENGTH T_INT TLV_VALUE T_HEXSTR S_SEMICOLON!;


      // Validate all parser tokens
      if(this.node.getChildCount() != 6)
      {
         System.err.println("WARNING: Invalid entry at pos: " + node.getLine() + ":" + node.getCharPositionInLine());
         System.err.println("  Entry is ignored!");
         return false;
      }

      for(int i = 0; i < this.node.getChildCount(); i++)
      {
         Token token = ((CommonTree)this.node.getChild(i)).getToken();

         if(Pattern.matches("^<missing [A-Z0-9]*_[A-Z0-9]*>$", token.getText()))
         {
            System.err.println("WARNING: Invalid entry at pos: " + token.getLine() + ":" + token.getCharPositionInLine());
            System.err.println("  Entry is ignored!");
            return false;
         }
      }

      if(!((CommonTree)this.node.getChild(0)).getToken().getText().equals("TlvCode") ||
         !((CommonTree)this.node.getChild(2)).getToken().getText().equals("TlvLength") ||
         !((CommonTree)this.node.getChild(4)).getToken().getText().equals("TlvValue"))
      {
         System.err.println("WARNING: Invalid entry at pos: " + node.getLine() + ":" + node.getCharPositionInLine());
         System.err.println("  Entry is ignored!");
         return false;
      }

      short  code    = Short.parseShort(((CommonTree)this.node.getChild(1)).getToken().getText());
      short  len     = Short.parseShort(((CommonTree)this.node.getChild(3)).getToken().getText());
      String valStr  = ((CommonTree)this.node.getChild(5)).getToken().getText();

      if(!Pattern.matches("0x([0-9a-fA-F]{2})*", valStr))
      {
         System.err.println("WARNING: Invalid entry at pos: " + node.getLine() + ":" + node.getCharPositionInLine());
         System.err.println(valStr + " is not a valid hexadecimal string.");
         System.err.println("  Entry is ignored!");
         return false;
      }

      /* Remove the hex prefix (0x) characters */
      valStr = valStr.substring(2);

      if(valStr.length()/2 < 0 || valStr.length()/2 > 254)
      {
         System.err.println("WARNING: Invalid entry at pos: " + node.getLine() + ":" + node.getCharPositionInLine());
         System.err.println("Size for string \"" + valStr + "\" (" + valStr.length()/2 + ") is out of range. (min = 0, max = 254)");
         System.err.println("  Entry is ignored!");
         return false;
      }

      if(valStr.length()/2 != len)
      {
         System.err.println("WARNING: Conflicting values between TlvLength value and length of TlvValue at pos: " + node.getLine() + ":" + node.getCharPositionInLine());
         System.err.println("  Entry is ignored!");
         return false;
      }

      this.tlvValue = new byte[valStr.length()/2];
      for(int i = 0; i < valStr.length()/2; i++)
      {
         String tmp = Character.toString(valStr.charAt(2*i)) + Character.toString(valStr.charAt(2*i+1));
         tlvValue[i] = (byte)Short.parseShort(tmp, 16);
      }
      this.tlvLength = this.tlvValue.length;
      this.tlvCode = code;
      this.tlvInit = true;
      return true;
   }


   public String getHexStr()
   {
      String res = "0x";
      if(this.tlvInit)
      {
         for(int i = 0; i < tlvLength; i++)
         {
           res += String.format("%02x", this.tlvValue[i]);
         }

         return res;
      }
      else
         return "";
   }

   public String toString()
   {
      if(this.tlvInit)
         return super.toString() + ", Value = " + getHexStr();
      else
         return "TLV " + tlvCode + " - !!! Value NOT initialized !!!";
   }

   public byte[] getEncoding()
   {
      if(!this.tlvInit)
         return null;

      byte[] tmp = new byte[this.tlvValue.length+2];
      tmp[0] = getTlvCode();
      tmp[1] = (byte)this.tlvLength;
      for(short i = 0; i < tlvValue.length; i++)
         tmp[i + 2] = tlvValue[i];

      return tmp;
   }

}