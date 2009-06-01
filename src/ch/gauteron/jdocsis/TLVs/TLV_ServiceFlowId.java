/****************************************************************************
 *                                                                          *
 *  jdocsis - TLV_ServiceFlowId.java                                        *
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

public class TLV_ServiceFlowId extends TLVuint // TLV [22|23].4 + TLV [24|25].2
{
   public TLV_ServiceFlowId()
   {
      super(1, 0xFFFFFFFFL);
      this.tlvCode = -1; // Value depends on the parent!
      this.tlvName = "ServiceFlowId";
      this.parentTLV = new int[] {22, 23, 24, 25};
   }

    public byte getTlvCode()
   {
      if(this.parent == null)
         return 0;

      String parentTLV = this.parent.getTlvCodeString();
      if(parentTLV == null)
         return 0;

      String subTLV = null;
      if(parentTLV.equals("22") || parentTLV.equals("23"))
         return 4;
      if(parentTLV.equals("24") || parentTLV.equals("25"))
         return 2;

      return 0;
   }

   public String getTlvCodeString()
   {
      if(this.parent == null)
         return null;

      String parentTLV = this.parent.getTlvCodeString();
      if(parentTLV == null)
         return null;

      String subTLV = null;
      if(parentTLV.equals("22") || parentTLV.equals("23"))
         subTLV = "4";
      if(parentTLV.equals("24") || parentTLV.equals("25"))
         subTLV = "2";

      if(subTLV == null)
         return null;

      return parentTLV + "." + subTLV;
   }
}
