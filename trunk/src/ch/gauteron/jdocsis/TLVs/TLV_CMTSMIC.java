/****************************************************************************
 *                                                                          *
 *  jdocsis - TLV_CMTSMIC.java                                              *
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TLV_CMTSMIC extends TLV // TLV 7
{
   short[] order = new short[] { 1, 2, 3, 4, 17, 43, 6, 18, 19, 20, 22, 23, 24, 25, 28, 29, 26, 35, 36, 37, 40 };

   byte[] tlvValue = null;
   String secret = null;

   public TLV_CMTSMIC(ArrayList<TLV>  tlvs, String secret)
   {
      this.tlvLength = 0;
      this.tlvCode   = 7;
      this.secret    = secret;
      setValue(tlvs);
   }

   public TLV_CMTSMIC()
   {
      this(null, null);
   }

   public TLV_CMTSMIC(ArrayList<TLV>  tlvs)
   {
      this(tlvs, null);
   }

   public TLV_CMTSMIC(String secret)
   {
      this(null, secret);
   }

   public void setValue(ArrayList<TLV> tlvs)
   {
      this.tlvInit = false;
      this.tlvValue = null;
      this.tlvLength = 0;

      if(tlvs == null || this.secret == null)
         return;

      ByteArrayOutputStream os = new ByteArrayOutputStream();

      for(short or: order)
      {
         for(int i = 0; i < tlvs.size(); i++)
         {
            if(tlvs.get(i).getTlvCode() == or)
            {
               System.out.println("TLV " + or + " is CMTS computed.");
               try
               {
                  os.write(tlvs.get(i).getEncoding());
               }
               catch(IOException e)
               {
                  System.err.println("ERROR: I/O error");
                  System.err.println(e);
                  System.exit(300);
               }
            }
         }
      }

      // Let's process the encodings for MD5
      byte[] digest = hmacMd5(os.toByteArray(), this.secret.getBytes());

      this.tlvValue = digest;
      this.tlvLength = digest.length;
      this.tlvInit = true;
   }

   public byte[] getEncoding()
   {
      if(!this.tlvInit || this.secret == null)
         return null;

      byte[] tmp = new byte[this.tlvLength + 2];
      tmp[0] = getTlvCode();
      tmp[1] = (byte)this.tlvLength;
      for(short i = 0; i < tlvLength; i++)
         tmp[i + 2] = tlvValue[i];

      return tmp;
   }

   private byte[] hmacMd5(byte[] data, byte[] key)
   {
      if(data == null || key == null)
         return null;

      MessageDigest md5 = null;
      try
      {
         md5 = MessageDigest.getInstance("MD5");
      }
      catch(NoSuchAlgorithmException e)
      {
         System.err.println("ERROR: MD5 algorithm is not supported with JRE/JDK");
         System.err.println(e);
         return null;
      }

      // If key size > 64, reduce it through MD5
      byte[] ikey = null;
      if(key.length > 64)
      {
         md5.update(key, 0, key.length);
         ikey = md5.digest();
      }
      else
         ikey = key;

      byte[] k_ipad = new byte[65];
      byte[] k_opad = new byte[65];

      for(byte i = 0; i < 64; i++)
      {
         k_ipad[i] = 0 ^ 0x36;
         k_opad[i] = 0 ^ 0x5c;
      }

      for(byte i = 0; i < ikey.length; i++)
      {
         k_ipad[i] = (byte)(ikey[i] ^ 0x36);
         k_opad[i] = (byte)(ikey[i] ^ 0x5c);
      }

      md5.reset();
      md5.update(k_ipad, 0, 64);
      md5.update(data, 0, data.length);
      byte[] digest = md5.digest();

      md5.reset();
      md5.update(k_opad, 0, 64);
      md5.update(digest, 0, 16);
      digest = md5.digest();

      return digest;
   }
}

