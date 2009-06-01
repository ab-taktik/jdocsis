/****************************************************************************
 *                                                                          *
 *  jdocsis - TLVipv6.java                                                  *
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

import java.net.Inet6Address;
import java.io.ByteArrayOutputStream;

import ch.gauteron.jdocsis.parser.DocsisLexer;
import ch.gauteron.jdocsis.exceptions.BadFormatArgumentException;
import ch.gauteron.jdocsis.exceptions.OutOfRangeTLVValueException;

public abstract class TLVipv6 extends TLVscalar
{
   Inet6Address tlvValue = null;

   public TLVipv6()
   {
      this.tlvLength = 16;
      this.tlvValue = null;
      this.expectedLexerType = DocsisLexer.T_IPV6;
   }

   void setValue(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException
   {
      this.tlvInit = false;
      this.tlvValue = null;

      try {
        tlvValue = (Inet6Address)Inet6Address.getByName(in);
      } catch(Exception e) {
         throw new BadFormatArgumentException(in + " is not a valid IPv6 address.");
      }

      this.tlvInit = true;
   }

   public String getIPv6()
   {
      if(this.tlvInit)
         return tlvValue.getHostAddress();
      else
         return null;
   }

   public String toString()
   {
      if(this.tlvInit)
         return super.toString() + ", Value = " + getIPv6();
      else
         return "TLV " + tlvCode + " - !!! Value NOT initialized !!!";
   }

   public byte[] getEncoding()
   {
      ByteArrayOutputStream os = new ByteArrayOutputStream();

      if(this.tlvValue == null)
         return null;

      os.write((byte)this.tlvCode);
      os.write((byte)this.tlvLength);
      try
      {
         os.write(this.tlvValue.getAddress());
      }
      catch(Exception e)
      {
         System.err.println("Unexpected error while encoding IPv6.");
         return null;
      }

      return os.toByteArray();

   }
}

