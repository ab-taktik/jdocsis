/****************************************************************************
 *                                                                          *
 *  jdocsis - TLVushort.java                                                *
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

public abstract class TLVushort extends TLVscalar
{
   int tlvValue;
   int min;
   int max;

   public TLVushort(int tlvValue, int min, int max)
   {
      this.tlvLength = 2;
      this.tlvValue  = tlvValue;
      this.min       = min;
      this.max       = max;
      this.expectedLexerType = DocsisLexer.T_INT;
   }

   public TLVushort(int min, int max) { this(0, min, max); }

   public TLVushort(int tlvValue) { this(tlvValue, 0, Short.MAX_VALUE-Short.MIN_VALUE); }

   public TLVushort() { this(0, 0, Short.MAX_VALUE-Short.MIN_VALUE); }

   void setValue(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException
   {
      this.tlvInit = false;
      if(!Pattern.matches("^[0-9]{1,5}$", in))
         throw new OutOfRangeTLVValueException(in + " is out of range (min = " + this.min + ", max = " + this.max +")");

      int val = Integer.parseInt(in);
      if(val < this.min || val > this.max)
         throw new OutOfRangeTLVValueException(in + " is out of range (min = " + this.min + ", max = " + this.max +")");

      this.tlvValue = val;
      this.tlvInit = true;
   }

   public String toString()
   {
      if(this.tlvInit)
         return super.toString() + ", Value = " + this.tlvValue;
      else
         return "TLV " + tlvCode + " - !!! Value NOT initialized !!!";
   }

   public byte[] getEncoding()
   {
      if(!this.tlvInit)
         return null;

      byte[] buffer = new byte[4];

      buffer[0] = getTlvCode();
      buffer[1] = (byte)this.tlvLength;
      buffer[2] = (byte)(this.tlvValue >> 8);
      buffer[3] = (byte)(this.tlvValue & 255);

      return buffer;
   }
}

