/****************************************************************************
 *                                                                          *
 *  jdocsis - TLVscalar.java                                                *
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

import ch.gauteron.jdocsis.exceptions.BadFormatArgumentException;
import ch.gauteron.jdocsis.exceptions.OutOfRangeTLVValueException;

public abstract class TLVscalar extends TLV
{
   int expectedLexerType = 0;

   public boolean processNode(CommonTree node) throws NullPointerException
   {
      super.processNode(node);

      CommonTree child = (CommonTree)this.node.getChild(0);

      Token token = child.getToken();

      if(Pattern.matches("^<missing T_[A-Z0-9]*>$", token.getText()))
      {
         System.out.println("WARNING: Invalid entry at pos: " + token.getLine() + ":" + token.getCharPositionInLine());
         System.out.println("  Entry is ignored!");
         return false;
      }

      if(token.getType() != expectedLexerType)
      {
         System.out.println("WARNING: Parameter has an invalid type. Pos: " + token.getLine() + ":" + token.getCharPositionInLine());
         System.out.println("  Entry is ignored!");
         return false;
      }

      try
      {
         setValue(token.getText());
      }
      catch(OutOfRangeTLVValueException e)
      {
         System.out.println("WARNING: Out of range value catched. Pos: " + token.getLine() + ":" + token.getCharPositionInLine());
         System.out.println("  " + e.getMessage());
         System.out.println("  Entry is ignored!");
         return false;
      }
      catch(BadFormatArgumentException e)
      {
         System.out.println("WARNING: Invalid argument catched. Pos: " + token.getLine() + ":" + token.getCharPositionInLine());
         System.out.println("  " + e.getMessage());
         System.out.println("  Entry is ignored!");
         return false;
      }
      return true;
   }


   abstract void setValue(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException;
}