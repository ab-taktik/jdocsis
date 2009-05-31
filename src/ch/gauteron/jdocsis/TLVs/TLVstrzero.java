/****************************************************************************
 *                                                                          *
 *  jdocsis - TLVstrzero.java                                               *
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

import ch.gauteron.jdocsis.parser.DocsisLexer;
import ch.gauteron.jdocsis.exceptions.BadFormatArgumentException;
import ch.gauteron.jdocsis.exceptions.OutOfRangeTLVValueException;

public abstract class TLVstrzero extends TLVstring
{
   public TLVstrzero(String tlvValue, int minSize, int maxSize)
   {
      this.tlvLength = 0;
      this.tlvValue  = null;
      if(maxSize <= 0 || maxSize > 255)
         maxSize = 255;
      this.minSize       = minSize;
      this.maxSize       = maxSize;
      this.expectedLexerType = DocsisLexer.T_STRING;
   }

   public TLVstrzero(int minSize, int maxSize) { this(null, minSize, maxSize); }

   public TLVstrzero(String tlvValue) { this(tlvValue, 0, 0); }

   public TLVstrzero() { this(null, 0, 0); }

   void setValue(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException
   {
      this.tlvInit = false;
      this.tlvValue = null;
      this.tlvLength = 0;
      /* Remove the quote (") characters */
      if(in.length() > 0 && in.charAt(0) == '"')
         in = in.substring(1);
      if(in.length() > 0 && in.charAt(in.length()-1) == '"')
         in = in.substring(0, in.length()-1);

      if(in.length() < this.minSize || in.length() > this.maxSize)
         throw new OutOfRangeTLVValueException("Size for string \"" + in + "\" (" + in.length() + ") is out of range. (min = " + this.minSize + ", max = " + this.maxSize +")");

      this.tlvValue = in;
      this.tlvLength = this.tlvValue.length() + 1; // +1 for the ending zero
      this.tlvInit = true;
   }
}
