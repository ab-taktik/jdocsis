/****************************************************************************
 *                                                                          *
 *  jdocsis - TLV_CMMIC.java                                                *
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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TLV_CMMIC extends TLV // TLV 6
{
   byte[] tlvValue = null;

   public TLV_CMMIC()
   {
      this(null);
   }

   public TLV_CMMIC(byte[] encodings)
   {
      this.tlvLength = 0;
      this.tlvCode   = 6;
      if(encodings == null)
         this.tlvValue = null;

      setValue(encodings);

   }

   public void setValue(byte[] encodings)
   {
      this.tlvInit = false;
      this.tlvValue = null;
      this.tlvLength = 0;

      if(encodings == null)
         return;

      // Let's process the encodings for MD5
      MessageDigest md5 = null;
      try
      {
         md5 = MessageDigest.getInstance("MD5");
      }
      catch(NoSuchAlgorithmException e)
      {
         System.err.println("ERROR: MD5 algorithm is not supported with JRE/JDK");
         System.err.println(e);
         return;
      }

      md5.update(encodings, 0, encodings.length);

      byte[] digest = md5.digest();
      if(digest.length != 16)
         return;

      this.tlvValue = digest;
      this.tlvLength = digest.length;
      this.tlvInit = true;
   }

   public byte[] getEncoding()
   {
      if(!this.tlvInit)
         return null;

      byte[] tmp = new byte[this.tlvLength + 2];
      tmp[0] = getTlvCode();
      tmp[1] = (byte)this.tlvLength;
      for(short i = 0; i < tlvLength; i++)
         tmp[i + 2] = tlvValue[i];

      return tmp;
   }
}

