/****************************************************************************
 *                                                                          *
 *  jdocsis - TLVhexstr.java                                                *
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

import ch.gauteron.jdocsis.parser.DocsisLexer;
import ch.gauteron.jdocsis.exceptions.BadFormatArgumentException;
import ch.gauteron.jdocsis.exceptions.OutOfRangeTLVValueException;

public abstract class TLVhexstr extends TLVscalar
{
   short[] tlvValue;
   int minSize;
   int maxSize;

   public TLVhexstr(byte[] tlvValue, int minSize, int maxSize)
   {
      this.tlvLength = 0;
      this.tlvValue  = null;
      if(maxSize <= 0 || maxSize > 255)
         maxSize = 255;
      this.minSize       = minSize;
      this.maxSize       = maxSize;
      this.expectedLexerType = DocsisLexer.T_HEXSTR;
   }

   public TLVhexstr(int minSize, int maxSize) { this(null, minSize, maxSize); }

   public TLVhexstr(byte[] tlvValue) { this(tlvValue, 0, 0); }

   public TLVhexstr() { this(null, 0, 0); }

   void setValue(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException
   {
      this.tlvInit = false;
      this.tlvValue = null;
      this.tlvLength = 0;

      if(!Pattern.matches("0x([0-9a-fA-F]{2})*", in))
         throw new BadFormatArgumentException(in + " is not a valid hexadecimal string.");

      /* Remove the hex prefix (0x) characters */
      in = in.substring(2);

      if(in.length()/2 < this.minSize || in.length()/2 > this.maxSize)
         throw new OutOfRangeTLVValueException("Size for string \"" + in + "\" (" + in.length()/2 + ") is out of range. (min = " + this.minSize + ", max = " + this.maxSize +")");

      this.tlvValue = new short[in.length()/2];
      for(int i = 0; i < in.length()/2; i++)
      {
         String tmp = Character.toString(in.charAt(2*i)) + Character.toString(in.charAt(2*i+1));
         tlvValue[i] = Short.parseShort(tmp, 16);
      }
      this.tlvLength = this.tlvValue.length;
      this.tlvInit = true;
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
         tmp[i + 2] = (byte)tlvValue[i];

      return tmp;
   }
}
