/****************************************************************************
 *                                                                          *
 *  jdocsis - TLV_SnmpMibObject.java                                        *
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
import java.math.BigInteger;
import java.util.regex.Pattern;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.snmp4j.smi.AbstractVariable;
import org.snmp4j.smi.Counter32;
import org.snmp4j.smi.Counter64;
import org.snmp4j.smi.Gauge32;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.TimeTicks;
import org.snmp4j.smi.UnsignedInteger32;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;

import ch.gauteron.jdocsis.parser.DocsisLexer;
import ch.gauteron.jdocsis.exceptions.BadFormatArgumentException;
import ch.gauteron.jdocsis.exceptions.OutOfRangeTLVValueException;

// TODO: Handle textual OID
// TODO: Handle TLV 64 (SNMP MIB object with Length > 255)

public class TLV_SnmpMibObject extends TLV
{
   VariableBinding binding = null;

   public TLV_SnmpMibObject()
   {
      super();
      this.tlvCode = 11;
      this.tlvName = "SnmpMibObject";
      this.parentTLV = new int[] {0};
   }

   public boolean processNode(CommonTree node) throws NullPointerException
   {
      super.processNode(node);

      this.tlvInit = false;
      this.binding = null;
      this.tlvLength = 0;

      // Validate all parser tokens
      if(this.node.getChildCount() != 3)
      {
         System.err.println("WARNING: Invalid entry at pos: " + node.getLine() + ":" + node.getCharPositionInLine());
         System.err.println("  Entry is ignored!");
         return false;
      }

      for(int i = 0; i < this.node.getChildCount(); i++)
      {
         Token token = ((CommonTree)this.node.getChild(i)).getToken();

         if(Pattern.matches("^<missing [A-Z0-9]*_[A-Z0-9]*>$", token.getText()))
         {
            System.err.println("WARNING: Invalid entry at pos: " + token.getLine() + ":" + token.getCharPositionInLine());
            System.err.println("  Entry is ignored!");
            return false;
         }
      }

      String oidText = ((CommonTree)this.node.getChild(0)).getToken().getText();

      OID oid = new OID(oidText);
      AbstractVariable  value   = null;
      CommonTree nodeType   = (CommonTree)this.node.getChild(1);
      Token tokenValue = ((CommonTree)this.node.getChild(2)).getToken();
      try
      {
         switch(nodeType.getType())
         {
            case DocsisLexer.SNMP_INTEGER:
               value = new Integer32(valSigned32(tokenValue.getText()));
               break;
            case DocsisLexer.SNMP_COUNTER32:
               value = new Counter32(valUnsigned32(tokenValue.getText()));
               break;
            case DocsisLexer.SNMP_GAUGE32:
               value = new Gauge32(valUnsigned32(tokenValue.getText()));
               break;
            case DocsisLexer.SNMP_UNSIGNED32:
               value = new UnsignedInteger32(valUnsigned32(tokenValue.getText()));
               break;
            case DocsisLexer.SNMP_COUNTER64:
               value = new Counter64(valUnsigned64(tokenValue.getText()));
               break;
            case DocsisLexer.SNMP_IPADDRESS:
               value = new IpAddress(valIPv4(tokenValue.getText()));
               break;
            case DocsisLexer.SNMP_OID: // T_OID
               System.err.println("WARNING: OID type is not supported yet at pos: " + tokenValue.getLine() + ":" + tokenValue.getCharPositionInLine());
               System.err.println("  Entry is ignored!");
               return false;
            case DocsisLexer.SNMP_STRING:
               value = new OctetString(valString(tokenValue.getText()));
               break;
            case DocsisLexer.SNMP_HEXSTRING:
               value = new OctetString(valHexString(tokenValue.getText()));
               break;
            case DocsisLexer.SNMP_TIMETICKS: // T_TIMETICKS
               System.err.println("WARNING: TIMETICKS type is not supported yet at pos: " + tokenValue.getLine() + ":" + tokenValue.getCharPositionInLine());
               System.err.println("  Entry is ignored!");
               return false;
            default:
               System.err.println("WARNING: Unsupported SNMP type at pos: " + tokenValue.getLine() + ":" + tokenValue.getCharPositionInLine());
               System.err.println("  Entry is ignored!");
               return false;
         }
      }
      catch(OutOfRangeTLVValueException e)
      {
         System.err.println("WARNING: Out of range value catched. Pos: " + tokenValue.getLine() + ":" + tokenValue.getCharPositionInLine());
         System.err.println("  " + e.getMessage());
         System.err.println("  Entry is ignored!");
         return false;
      }
      catch(BadFormatArgumentException e)
      {
         System.err.println("WARNING: Invalid argument catched. Pos: " + tokenValue.getLine() + ":" + tokenValue.getCharPositionInLine());
         System.err.println("  " + e.getMessage());
         System.err.println("  Entry is ignored!");
         return false;
      }

      if(value == null)
         return false;

      this.binding = new VariableBinding(oid, value);
      this.tlvLength = binding.getBERLength();
      this.tlvInit = true;
      return true;
   }

   public String getBERType()
   {
      if(binding == null)
         return null;

      Variable value = binding.getVariable();
      if(value instanceof Integer32)
         return "Integer";
      if(value instanceof Counter32)
         return "Counter32";
      if(value instanceof Gauge32)
         return "Gauge32";
      if(value instanceof UnsignedInteger32)
         return "Unsigned32";
      if(value instanceof Counter64)
         return "Counter64";
      if(value instanceof OID)
         return "OID";
      if(value instanceof IpAddress)
         return "IpAddress";
      if(value instanceof OctetString) // TODO: Should make deeper analyzis to permit the use of String
         return "HexString";
      if(value instanceof TimeTicks)
         return "TimeTicks";
      return "<Unknown>";
   }

   public String toString()
   {
      if(binding == null)
         return null;
      String res = super.toString();

      res += ", SNMP Type = " + getBERType();
      res += ", Value = " + binding.toString();

      return res;
   }

   private int valSigned32(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException
   {
      // Validate input
      if(!Pattern.matches("^-?[0-9]{1,10}$", in))
         throw new OutOfRangeTLVValueException(in + " is out of range (min = " + Integer.MIN_VALUE + ", max = " + Integer.MAX_VALUE + ")");

      long val = Long.parseLong(in);
      if(val < Integer.MIN_VALUE || val > Integer.MAX_VALUE)
         throw new OutOfRangeTLVValueException(in + " is out of range (min = " + Integer.MIN_VALUE + ", max = " + Integer.MAX_VALUE + ")");

      return Integer.parseInt(in);
   }

   private long valUnsigned32(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException
   {
      long max = (long)Integer.MAX_VALUE - (long)Integer.MIN_VALUE;

      // Validate input
      if(!Pattern.matches("^[0-9]{1,10}$", in))
         throw new OutOfRangeTLVValueException(in + " is out of range (min = 0, max = " + max + ")");

      long val = Long.parseLong(in);
      if(val < 0 || val > max)
         throw new OutOfRangeTLVValueException(in + " is out of range (min = 0, max = " + max + ")");

      return Long.parseLong(in);
   }

   private long valUnsigned64(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException
   {
      String max = "18446744073709551615";

      // Validate input
      if(!Pattern.matches("^[0-9]{1,20}$", in))
         throw new OutOfRangeTLVValueException(in + " is out of range (min = 0, max = " + max + ")");

      BigInteger val = new BigInteger(in);
      if(val.compareTo(new BigInteger("0")) == -1 || val.compareTo(new BigInteger(max)) == 1)
         throw new OutOfRangeTLVValueException(in + " is out of range (min = 0, max = " + max + ")");

      return val.longValue();
   }

   private String valString(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException
   {
      if(in.length() > 0 && in.charAt(0) == '"')
         in = in.substring(1);
      if(in.length() > 0 && in.charAt(in.length()-1) == '"')
         in = in.substring(0, in.length()-1);

      if(in.length() > 65535)
         throw new OutOfRangeTLVValueException("Size for string \"" + in + "\" (" + in.length() + ") is out of range. (min = 0, max = 65535)");

      return in;
   }

   private byte[] valHexString(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException
   {
      if(!Pattern.matches("0x([0-9a-fA-F]{2})*", in))
         throw new BadFormatArgumentException(in + " is not a valid hexadecimal string.");

      /* Remove the hex prefix (0x) characters */
      in = in.substring(2);

      if(in.length()/2 > 65535)
         throw new OutOfRangeTLVValueException("Size for string \"" + in + "\" (" + in.length()/2 + ") is out of range. (min = 0, max = 65535)");

      byte[] res = new byte[in.length()/2];
      for(int i = 0; i < in.length()/2; i++)
      {
         String tmp = Character.toString(in.charAt(2*i)) + Character.toString(in.charAt(2*i+1));
         res[i] = (byte)Short.parseShort(tmp, 16);
      }
      return res;
   }

   private String valIPv4(String in) throws OutOfRangeTLVValueException, BadFormatArgumentException
   {
      if(!Pattern.matches("^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$", in))
         throw new BadFormatArgumentException(in + " is not a valid IPv4 address.");

      String[] digits = in.split("\\.");
      for(int i = 0; i < 4; i++)
      {
         short digit = Short.parseShort(digits[i]);
         if(digit < 0 || digit > 255)
            throw new BadFormatArgumentException(in + " is not a valid IPv4 address.");
      }

      return in;
   }

   public byte[] getEncoding()
   {
      ByteArrayOutputStream os = new ByteArrayOutputStream();

      if(binding == null)
         return null;

      int len = binding.getBERLength();
      if(len > 255)                          // VarBind is > 255 (see CM-SP-MULPIv3.0-I08, C.1.2.5)
         return null;                        // TODO: Throw an exception would be nicer

      os.write((byte)this.tlvCode);
      os.write((byte)len);
      try
      {
         binding.encodeBER(os);
      }
      catch(Exception e)
      {
         System.out.println("A problem occured while creating the SNMP Mib Object.");
         return null;
      }

      return os.toByteArray();
   }

}