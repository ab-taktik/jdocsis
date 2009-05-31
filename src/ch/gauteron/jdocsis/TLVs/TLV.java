/****************************************************************************
 *                                                                          *
 *  jdocsis - TLV.java                                                      *
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

import java.util.ArrayList;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

public abstract class TLV
{
   int tlvCode = -1;
   int tlvLength = 0;
   boolean tlvCmtsMIC = false;
   boolean tlvInit = false;


   String tlvName = null;
   int[] parentTLV = null; // Array of allowed parent TLV (null if this is a root TLV)
   CommonTree node = null;

   TLV parent  = null;     // For sub-TLVs, indicates the current parent TLV
   ArrayList<TLV> children = new ArrayList<TLV>();

   public boolean processNode(CommonTree node) throws NullPointerException
   {
      if(node == null)
         throw new NullPointerException("Tree node is a null value.");
      this.node = node;

      return true;
   }

   public byte getTlvCode() { return (byte)this.tlvCode; }
   public String getTlvCodeString()
   {
      if(parent != null)
         return parent.getTlvCode() + "." + Integer.toString(this.tlvCode);
      else
         return Integer.toString(this.tlvCode);
   }

   public int getTLVLength()
   {
      return this.tlvLength;
   }

   public String toString()
   {
      return "TLV " + this.getTlvCodeString() + " (" + this.tlvName + "), Length = " + Integer.toString(getTLVLength());
   }

   public void setParent(TLV parent)
   {
      this.parent = parent;
   }

   public boolean usedForCmtsMIC()
   {
      return this.tlvCmtsMIC;
   }

   public abstract byte[] getEncoding();
}
