/****************************************************************************
 *                                                                          *
 *  jdocsis - TLVethernet.java                                              *
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

public abstract class TLVethernet extends TLVscalar
{
   short[] tlvValue;

   public TLVethernet()
   {
      this.tlvLength = 6;
      this.tlvValue = new short[] { 0, 0, 0, 0, 0, 0 };
      this.expectedLexerType = DocsisLexer.T_MACADDR;
   }

   void setValue(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException
   {
      this.tlvInit = false;

      if(!Pattern.matches("^([0-9a-fA-F]{2}:){5}[0-9a-fA-F]{2}$", in))
         throw new BadFormatArgumentException(in + " is not a valid Ethernet address.");

      String[] digits = in.split(":");
      for(int i = 0; i < 6; i++)
      {
         short digit = Short.parseShort(digits[i], 16);
         if(digit < 0 || digit > 255)
            throw new BadFormatArgumentException(in + " is not a valid Ethernet address.");
         tlvValue[i] = digit;
      }

      this.tlvInit = true;
   }

   public String getMAC()
   {
      if(this.tlvInit)
         return String.format("%02x:%02x:%02x:%02x:%02x:%02x", tlvValue[0], tlvValue[1], tlvValue[2], tlvValue[3], tlvValue[4], tlvValue[5]);
      else
         return "";
   }

   public String toString()
   {
      if(this.tlvInit)
         return super.toString() + ", Value = " + getMAC();
      else
         return "TLV " + tlvCode + " - !!! Value NOT initialized !!!";
   }

   public byte[] getEncoding()
   {
      if(!this.tlvInit)
         return null;

      byte[] tmp = new byte[tlvLength+2];
      tmp[0] = (byte)this.tlvCode;
      tmp[1] = (byte)this.tlvLength;
      for(byte i = 0; i < this.tlvLength; i++)
         tmp[i+2] = (byte)tlvValue[i];

      return tmp;
   }
}
