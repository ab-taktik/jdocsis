/****************************************************************************
 *                                                                          *
 *  jdocsis - Lexer2TLVMapper.java                                          *
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

/*
 * REMARK: This file is not terminated yet.
 *         It has to be edited when new TLVs are added in the project.
 */

package ch.gauteron.jdocsis.encoder;

import java.util.Hashtable;
import java.lang.reflect.Constructor;
import ch.gauteron.jdocsis.parser.DocsisLexer;

import ch.gauteron.jdocsis.common.*;
import ch.gauteron.jdocsis.TLVs.*;

public class Lexer2TLVMapper
{
   private static boolean inited = false;

   private static Hashtable<Integer, String> idTLV;
   private static TLVClassLoader cl;

   private static void init()
   {
      if(inited)     // Has already been initialized. Nothing to do.
         return;

      cl = new TLVClassLoader();
      idTLV = new Hashtable<Integer, String>(150);
      idTLV.put(DocsisLexer.ID_DOWNSTREAMFREQUENCY,       "ch.gauteron.docsis.TLVs.TLV_DownstreamFrequency");       // TLV 1
      idTLV.put(DocsisLexer.ID_UPSTREAMCHANNELID,         "ch.gauteron.docsis.TLVs.TLV_UpstreamChannelId");         // TLV 2
      idTLV.put(DocsisLexer.ID_NETWORKACCESS,             "ch.gauteron.docsis.TLVs.TLV_NetworkAccess");             // TLV 3
      idTLV.put(DocsisLexer.ID_CLASSOFSERVICE,            "ch.gauteron.docsis.TLVs.TLV_ClassOfService");            // TLV 4
/*
      idTLV.put(DocsisLexer.ID_CLASSID,                   "ch.gauteron.docsis.TLVs.TLV_ClassID");                   // TLV 4.1
      idTLV.put(DocsisLexer.ID_MAXRATEDOWN,               "ch.gauteron.docsis.TLVs.TLV_MaxRateDown");               // TLV 4.2
      idTLV.put(DocsisLexer.ID_MAXRATEUP,                 "ch.gauteron.docsis.TLVs.TLV_MaxRateUp");                 // TLV 4.3
      idTLV.put(DocsisLexer.ID_PRIORITYUP,                "ch.gauteron.docsis.TLVs.TLV_PriorityUp");                // TLV 4.4
      idTLV.put(DocsisLexer.ID_GUARANTEEDUP,              "ch.gauteron.docsis.TLVs.TLV_GuaranteedUp");              // TLV 4.5
      idTLV.put(DocsisLexer.ID_MAXBURSTUP,                "ch.gauteron.docsis.TLVs.TLV_MaxBurstUp");                // TLV 4.6
      idTLV.put(DocsisLexer.ID_PRIVACYENABLE,             "ch.gauteron.docsis.TLVs.TLV_PrivacyEnable");             // TLV 4.7
      idTLV.put(DocsisLexer.ID_MODEMCAPABILITIES,         "ch.gauteron.docsis.TLVs.TLV_ModemCapabilities");         // TLV 5
      idTLV.put(DocsisLexer.ID_CONCATENATIONSUPPORT,      "ch.gauteron.docsis.TLVs.TLV_ConcatenationSupport");      // TLV 5.1
      idTLV.put(DocsisLexer.ID_MODEMDOCSISVERSION,        "ch.gauteron.docsis.TLVs.TLV_ModemDocsisVersion");        // TLV 5.2
      idTLV.put(DocsisLexer.ID_FRAGMENTATIONSUPPORT,      "ch.gauteron.docsis.TLVs.TLV_FragmentationSupport");      // TLV 5.3
      idTLV.put(DocsisLexer.ID_PHSSUPPORT,                "ch.gauteron.docsis.TLVs.TLV_PHSSupport");                // TLV 5.4
      idTLV.put(DocsisLexer.ID_IGMPSUPPORT,               "ch.gauteron.docsis.TLVs.TLV_IGMPSupport");               // TLV 5.5
      idTLV.put(DocsisLexer.ID_BASELINEPRIVACYSUPPORT ,   "ch.gauteron.docsis.TLVs.TLV_BaselinePrivacySupport");    // TLV 5.6
      idTLV.put(DocsisLexer.ID_DOWNSTREAMSAIDSUPPORT,     "ch.gauteron.docsis.TLVs.TLV_DownstreamSAIDSupport");     // TLV 5.7
      idTLV.put(DocsisLexer.ID_UPSTREAMSIDSUPPORT,        "ch.gauteron.docsis.TLVs.TLV_UpstreamSIDSupport");        // TLV 5.8
      idTLV.put(DocsisLexer.ID_DCCSUPPORT,                "ch.gauteron.docsis.TLVs.TLV_DCCSupport");                // TLV 5.12 */
      idTLV.put(DocsisLexer.ID_SWUPGRADEFILENAME,         "ch.gauteron.docsis.TLVs.TLV_SwUpgradeFilename");         // TLV 9
/*
      idTLV.put(DocsisLexer.ID_SNMPWRITECONTROL,          "ch.gauteron.docsis.TLVs.TLV_SnmpWriteControl");          // TLV 10
*/
      idTLV.put(DocsisLexer.ID_SNMPMIBOBJECT,             "ch.gauteron.docsis.TLVs.TLV_SnmpMibObject");             // TLV 11
      idTLV.put(DocsisLexer.ID_CPEMACADDRESS,             "ch.gauteron.docsis.TLVs.TLV_CpeMacAddress");             // TLV 14
      idTLV.put(DocsisLexer.ID_BASELINEPRIVACY,           "ch.gauteron.docsis.TLVs.TLV_BaselinePrivacy");           // TLV 17
      idTLV.put(DocsisLexer.ID_AUTHTIMEOUT,               "ch.gauteron.docsis.TLVs.TLV_AuthTimeout");               // TLV 17.1
      idTLV.put(DocsisLexer.ID_REAUTHTIMEOUT,             "ch.gauteron.docsis.TLVs.TLV_ReAuthTimeout");             // TLV 17.2
      idTLV.put(DocsisLexer.ID_AUTHGRACETIME,             "ch.gauteron.docsis.TLVs.TLV_AuthGraceTime");             // TLV 17.3
      idTLV.put(DocsisLexer.ID_OPERTIMEOUT,               "ch.gauteron.docsis.TLVs.TLV_OperTimeout");               // TLV 17.4
      idTLV.put(DocsisLexer.ID_REKEYTIMEOUT,              "ch.gauteron.docsis.TLVs.TLV_ReKeyTimeout");              // TLV 17.5
      idTLV.put(DocsisLexer.ID_TEKGRACETIME,              "ch.gauteron.docsis.TLVs.TLV_TEKGraceTime");              // TLV 17.6
      idTLV.put(DocsisLexer.ID_AUTHREJECTTIMEOUT,         "ch.gauteron.docsis.TLVs.TLV_AuthRejectTimeout");         // TLV 17.7
      idTLV.put(DocsisLexer.ID_SAMAPWAITTIMEOUT,          "ch.gauteron.docsis.TLVs.TLV_SAMapWaitTimeout");          // TLV 17.8
      idTLV.put(DocsisLexer.ID_SAMAPMAXRETRIES,           "ch.gauteron.docsis.TLVs.TLV_SAMapMaxRetries");           // TLV 17.9
      idTLV.put(DocsisLexer.ID_MAXCPE,                    "ch.gauteron.docsis.TLVs.TLV_MaxCPE");                    // TLV 18
      idTLV.put(DocsisLexer.ID_TFTPTIMESTAMP,             "ch.gauteron.docsis.TLVs.TLV_TftpTimestamp");             // TLV 19
      idTLV.put(DocsisLexer.ID_TFTPMODEMADDRESS,          "ch.gauteron.docsis.TLVs.TLV_TftpModemAddress");          // TLV 20
      idTLV.put(DocsisLexer.ID_SWUPGRADESERVER,           "ch.gauteron.docsis.TLVs.TLV_SwUpgradeServer");           // TLV 21
      idTLV.put(DocsisLexer.ID_USPACKETCLASS,             "ch.gauteron.docsis.TLVs.TLV_UsPacketClass");             // TLV 22
      idTLV.put(DocsisLexer.ID_DSPACKETCLASS,             "ch.gauteron.docsis.TLVs.TLV_DsPacketClass");             // TLV 23
      idTLV.put(DocsisLexer.ID_CLASSIFIERREF,             "ch.gauteron.docsis.TLVs.TLV_ClassifierRef");             // TLV [22|23].1
      idTLV.put(DocsisLexer.ID_CLASSIFIERID,              "ch.gauteron.docsis.TLVs.TLV_ClassifierId");              // TLV [22|23].2
      idTLV.put(DocsisLexer.ID_SERVICEFLOWREF,            "ch.gauteron.docsis.TLVs.TLV_ServiceFlowRef");            // TLV [22|23].3 + TLV [24|25].1
      idTLV.put(DocsisLexer.ID_SERVICEFLOWID,             "ch.gauteron.docsis.TLVs.TLV_ServiceFlowId");             // TLV [22|23].4 + TLV [24|25].2
      idTLV.put(DocsisLexer.ID_RULEPRIORITY,              "ch.gauteron.docsis.TLVs.TLV_RulePriority");              // TLV [22|23].5
      idTLV.put(DocsisLexer.ID_ACTIVATIONSTATE,           "ch.gauteron.docsis.TLVs.TLV_ActivationState");           // TLV [22|23].7
      idTLV.put(DocsisLexer.ID_DSCACTION,                 "ch.gauteron.docsis.TLVs.TLV_DscAction");                 // TLV [22|23].7
      idTLV.put(DocsisLexer.ID_IPPACKETCLASSIFIER,        "ch.gauteron.docsis.TLVs.TLV_IpPacketClassifier");        // TLV [22|23].9
      idTLV.put(DocsisLexer.ID_IPTOS,                     "ch.gauteron.docsis.TLVs.TLV_IpTos");                     // TLV [22|23].9.1
      idTLV.put(DocsisLexer.ID_IPPROTO,                   "ch.gauteron.docsis.TLVs.TLV_IpProto");                   // TLV [22|23].9.2
      idTLV.put(DocsisLexer.ID_IPSRCADDR,                 "ch.gauteron.docsis.TLVs.TLV_IpSrcAddr");                 // TLV [22|23].9.3
      idTLV.put(DocsisLexer.ID_IPSRCMASK,                 "ch.gauteron.docsis.TLVs.TLV_IpSrcMask");                 // TLV [22|23].9.4
      idTLV.put(DocsisLexer.ID_IPDSTADDR,                 "ch.gauteron.docsis.TLVs.TLV_IpDstAddr");                 // TLV [22|23].9.5
      idTLV.put(DocsisLexer.ID_IPDSTMASK,                 "ch.gauteron.docsis.TLVs.TLV_IpDstMask");                 // TLV [22|23].9.6
      idTLV.put(DocsisLexer.ID_SRCPORTSTART,              "ch.gauteron.docsis.TLVs.TLV_SrcPortStart");              // TLV [22|23].9.7
      idTLV.put(DocsisLexer.ID_SRCPORTEND,                "ch.gauteron.docsis.TLVs.TLV_SrcPortEnd");                // TLV [22|23].9.8
      idTLV.put(DocsisLexer.ID_DSTPORTSTART,              "ch.gauteron.docsis.TLVs.TLV_DstPortStart");              // TLV [22|23].9.9
      idTLV.put(DocsisLexer.ID_DSTPORTEND,                "ch.gauteron.docsis.TLVs.TLV_DstPortEnd");                // TLV [22|23].9.10
      idTLV.put(DocsisLexer.ID_LLCPACKETCLASSIFIER,       "ch.gauteron.docsis.TLVs.TLV_LLCPacketClassifier");       // TLV [22|23].10
      idTLV.put(DocsisLexer.ID_DSTMACADDRESS,             "ch.gauteron.docsis.TLVs.TLV_DstMacAddress");             // TLV [22|23].10.1
      idTLV.put(DocsisLexer.ID_SRCMACADDRESS,             "ch.gauteron.docsis.TLVs.TLV_SrcMacAddress");             // TLV [22|23].10.2
      idTLV.put(DocsisLexer.ID_ETHERTYPE,                 "ch.gauteron.docsis.TLVs.TLV_EtherType");                 // TLV [22|23].10.3
      idTLV.put(DocsisLexer.ID_IEEE802CLASSIFIER,         "ch.gauteron.docsis.TLVs.TLV_IEEE802Classifier");         // TLV [22|23].11
      idTLV.put(DocsisLexer.ID_USERPRIORITY,              "ch.gauteron.docsis.TLVs.TLV_UserPriority");              // TLV [22|23].11.1
      idTLV.put(DocsisLexer.ID_VLANID,                    "ch.gauteron.docsis.TLVs.TLV_VlanID");                    // TLV [22|23].11.2
/*
      idTLV.put(DocsisLexer.ID_IPV6PACKETCLASSIFIER,      "ch.gauteron.docsis.TLVs.TLV_IPv6PacketClassifier");      // TLV [22|23].12
      idTLV.put(DocsisLexer.ID_IPV6TRAFFICCLASSRANGEMASK, "ch.gauteron.docsis.TLVs.TLV_IPv6TrafficClassRangeMask"); // TLV [22|23].12.1
      idTLV.put(DocsisLexer.ID_IPV6FLOWLABEL,             "ch.gauteron.docsis.TLVs.TLV_IPv6FlowLabel");             // TLV [22|23].12.2
      idTLV.put(DocsisLexer.ID_IPV6NEXTHEADERTYPE,        "ch.gauteron.docsis.TLVs.TLV_IPv6NextHeaderType");        // TLV [22|23].12.3
      idTLV.put(DocsisLexer.ID_IPV6SRCADDR,               "ch.gauteron.docsis.TLVs.TLV_IPv6SrcAddr");               // TLV [22|23].12.4
      idTLV.put(DocsisLexer.ID_IPV6SRCPREFLENGTH,         "ch.gauteron.docsis.TLVs.TLV_IPv6SrcPrefLength");         // TLV [22|23].12.5
      idTLV.put(DocsisLexer.ID_IPV6DSTADDR,               "ch.gauteron.docsis.TLVs.TLV_IPv6DstAddr");               // TLV [22|23].12.6
      idTLV.put(DocsisLexer.ID_IPV6DSTPREFLENGTH,         "ch.gauteron.docsis.TLVs.TLV_IPv6DstPrefLength");         // TLV [22|23].12.7
*/

      idTLV.put(DocsisLexer.ID_USSERVICEFLOW,             "ch.gauteron.docsis.TLVs.TLV_UsServiceFlow");             // TLV 24
      idTLV.put(DocsisLexer.ID_DSSERVICEFLOW,             "ch.gauteron.docsis.TLVs.TLV_DsServiceFlow");             // TLV 25
      idTLV.put(DocsisLexer.ID_SERVICEFLOWREF,            "ch.gauteron.docsis.TLVs.TLV_ServiceFlowRef");            // TLV [22|23].3 + TLV [24|25].1
      idTLV.put(DocsisLexer.ID_USSERVICEFLOWREF,          "ch.gauteron.docsis.TLVs.TLV_ServiceFlowRef");            // TLV 24.1 (Alias)
      idTLV.put(DocsisLexer.ID_DSSERVICEFLOWREF,          "ch.gauteron.docsis.TLVs.TLV_ServiceFlowRef");            // TLV 25.1 (Alias)
      idTLV.put(DocsisLexer.ID_SERVICEFLOWID,             "ch.gauteron.docsis.TLVs.TLV_ServiceFlowId");             // TLV [22|23].4 + TLV [24|25].2
      idTLV.put(DocsisLexer.ID_USSERVICEFLOWID,           "ch.gauteron.docsis.TLVs.TLV_ServiceFlowId");             // TLV 24.2 (Alias)
      idTLV.put(DocsisLexer.ID_DSSERVICEFLOWID,           "ch.gauteron.docsis.TLVs.TLV_ServiceFlowId");             // TLV 25.2 (Alias)
      idTLV.put(DocsisLexer.ID_SERVICECLASSNAME,          "ch.gauteron.docsis.TLVs.TLV_ServiceClassName");          // TLV [24|25].4
      idTLV.put(DocsisLexer.ID_QOSPARAMSETTYPE,           "ch.gauteron.docsis.TLVs.TLV_QosParamSetType");           // TLV [24|25].6
      idTLV.put(DocsisLexer.ID_TRAFFICPRIORITY,           "ch.gauteron.docsis.TLVs.TLV_TrafficPriority");           // TLV [24|25].7
      idTLV.put(DocsisLexer.ID_MAXRATESUSTAINED,          "ch.gauteron.docsis.TLVs.TLV_MaxRateSustained");          // TLV [24|25].8
      idTLV.put(DocsisLexer.ID_MAXTRAFFICBURST,           "ch.gauteron.docsis.TLVs.TLV_MaxTrafficBurst");           // TLV [24|25].9
      idTLV.put(DocsisLexer.ID_MINRESERVEDRATE,           "ch.gauteron.docsis.TLVs.TLV_MinReservedRate");           // TLV [24|25].10
      idTLV.put(DocsisLexer.ID_MINRESPACKETSIZE,          "ch.gauteron.docsis.TLVs.TLV_MinResPacketSize");          // TLV [24|25].11
      idTLV.put(DocsisLexer.ID_ACTQOSPARAMSTIMEOUT,       "ch.gauteron.docsis.TLVs.TLV_ActQosParamsTimeout");       // TLV [24|25].12
      idTLV.put(DocsisLexer.ID_ADMQOSPARAMSTIMEOUT,       "ch.gauteron.docsis.TLVs.TLV_AdmQosParamsTimeout");       // TLV [24|25].13
      idTLV.put(DocsisLexer.ID_MAXCONCATENATEDBURST,      "ch.gauteron.docsis.TLVs.TLV_MaxConcatenatedBurst");      // TLV 24.14
      idTLV.put(DocsisLexer.ID_SCHEDULINGTYPE,            "ch.gauteron.docsis.TLVs.TLV_SchedulingType");            // TLV 24.15
      idTLV.put(DocsisLexer.ID_REQUESTORTXPOLICY,         "ch.gauteron.docsis.TLVs.TLV_RequestOrTxPolicy");         // TLV 24.16
      idTLV.put(DocsisLexer.ID_NOMINALPOLLINTERVAL,       "ch.gauteron.docsis.TLVs.TLV_NominalPollInterval");       // TLV 24.17
      idTLV.put(DocsisLexer.ID_TOLERATEDPOLLJITTER,       "ch.gauteron.docsis.TLVs.TLV_ToleratedPollJitter");       // TLV 24.18
      idTLV.put(DocsisLexer.ID_UNSOLICITEDGRANTSIZE,      "ch.gauteron.docsis.TLVs.TLV_UnsolicitedGrantSize");      // TLV 24.19
      idTLV.put(DocsisLexer.ID_NOMINALGRANTINTERVAL,      "ch.gauteron.docsis.TLVs.TLV_NominalGrantInterval");      // TLV 24.20
      idTLV.put(DocsisLexer.ID_TOLERATEDGRANTJITTER,      "ch.gauteron.docsis.TLVs.TLV_ToleratedGrantJitter");      // TLV 24.21
      idTLV.put(DocsisLexer.ID_GRANTSPERINTERVAL,         "ch.gauteron.docsis.TLVs.TLV_GrantsPerInterval");         // TLV 24.22
      idTLV.put(DocsisLexer.ID_IPTOSOVERWRITE,            "ch.gauteron.docsis.TLVs.TLV_IpTosOverwrite");            // TLV 24.23
      idTLV.put(DocsisLexer.ID_MAXDSLATENCY,              "ch.gauteron.docsis.TLVs.TLV_MaxDsLatency");              // TLV 25.14
/*
      idTLV.put(DocsisLexer.ID_PHS         ,              "ch.gauteron.docsis.TLVs.TLV_PHS");                       // TLV 26
      idTLV.put(DocsisLexer.ID_PHSCLASSIFIERREF,          "ch.gauteron.docsis.TLVs.TLV_PHSClassifierRef");          // TLV 26.1
      idTLV.put(DocsisLexer.ID_PHSCLASSIFIERID,           "ch.gauteron.docsis.TLVs.TLV_PHSClassifierId");           // TLV 26.2
      idTLV.put(DocsisLexer.ID_PHSERVICEFLOWREF,          "ch.gauteron.docsis.TLVs.TLV_PHSServiceFlowRef");         // TLV 26.3
      idTLV.put(DocsisLexer.ID_PHSSERVICEFLOWID,          "ch.gauteron.docsis.TLVs.TLV_PHSServiceFlowId");          // TLV 26.4
      idTLV.put(DocsisLexer.ID_PHSFIELD,                  "ch.gauteron.docsis.TLVs.TLV_PHSField");                  // TLV 26.7
      idTLV.put(DocsisLexer.ID_PHSINDEX,                  "ch.gauteron.docsis.TLVs.TLV_PHSIndex");                  // TLV 26.8
      idTLV.put(DocsisLexer.ID_PHSMASK,                   "ch.gauteron.docsis.TLVs.TLV_PHSMask");                   // TLV 26.9
      idTLV.put(DocsisLexer.ID_PHSSIZE,                   "ch.gauteron.docsis.TLVs.TLV_PHSSize");                   // TLV 26.10
      idTLV.put(DocsisLexer.ID_PHSVERIFY,                 "ch.gauteron.docsis.TLVs.TLV_PHSVerify");                 // TLV 26.11

*/
      idTLV.put(DocsisLexer.ID_MAXCLASSIFIERS,            "ch.gauteron.docsis.TLVs.TLV_MaxClassifiers");            // TLV 28
      idTLV.put(DocsisLexer.ID_GLOBALPRIVACYENABLE,       "ch.gauteron.docsis.TLVs.TLV_GlobalPrivacyEnable");       // TLV 29
      idTLV.put(DocsisLexer.ID_MFGCVCDATA ,               "ch.gauteron.docsis.TLVs.TLV_MfgCVCData");                // TLV 32
      idTLV.put(DocsisLexer.ID_MANUFACTURERCVC,           "ch.gauteron.docsis.TLVs.TLV_MfgCVCData");                // TLV 32 (alias)
      idTLV.put(DocsisLexer.ID_COSIGNERCVCDATA ,          "ch.gauteron.docsis.TLVs.TLV_CoSignerCVCData");           // TLV 33
      idTLV.put(DocsisLexer.ID_COSIGNERCVC ,              "ch.gauteron.docsis.TLVs.TLV_CoSignerCVCData");           // TLV 33 (alias)

/*
ID_SNMPV3KICKSTART      :  'SnmpV3Kickstart';         // DOCSIS x.x: TLV 34
ID_SNMPV3SECURITYNAME      :  'SnmpV3SecurityName';         // DOCSIS x.x: TLV 34.1
ID_SNMPV3MGRPUBLICNUMBER   :  'SnmpV3MgrPublicNumber';      // DOCSIS x.x: TLV 34.2 */

      idTLV.put(DocsisLexer.ID_SUBMGMTCONTROL,                        "ch.gauteron.docsis.TLVs.TLV_SubMgmtControl");                        // TLV 35

/*
ID_SUBMGMTFILTERS    :  'SubMgmtFilters';          // DOCSIS x.x: TLV 37
ID_SNMPV3TRAPRECEIVER      :  'SnmpV3TrapReceiver';         // DOCSIS x.x: TLV 38
ID_SNMPV3TRAPRXIP    :  'SnmpV3TrapRxIP';       // DOCSIS x.x: TLV 38.1
ID_SNMPV3TRAPRXPORT     :  'SnmpV3TrapRxPort';        // DOCSIS x.x: TLV 38.2
ID_SNMPV3TRAPRXTYPE     :  'SnmpV3TrapRxType';        // DOCSIS x.x: TLV 38.3
ID_SNMPV3TRAPRXTIMEOUT     :  'SnmpV3TrapRxTimeout';        // DOCSIS x.x: TLV 38.4
ID_SNMPV3TRAPRXRETRIES     :  'SnmpV3TrapRxRetries';        // DOCSIS x.x: TLV 38.5
ID_SNMPV3TRAPRXFILTEROID   :  'SnmpV3TrapRxFilterOID';      // DOCSIS x.x: TLV 38.6
ID_SNMPV3TRAPRXSECURITYNAME   :  'SnmpV3TrapRxSecurityName';      // DOCSIS x.x: TLV 38.7
*/
      idTLV.put(DocsisLexer.ID_DOCSISTWOENABLE,                   "ch.gauteron.docsis.TLVs.TLV_DocsisTwoEnable");                   // TLV 39
      idTLV.put(DocsisLexer.ID_TESTMODEENABLE,                    "ch.gauteron.docsis.TLVs.TLV_TestModeEnable");                    // TLV 40

/*
ID_DSCHANNELLIST     :  'DsChannelList';        // DOCSIS x.x: TLV 41
ID_DEFAULTSCANTIMEOUT      :  'DefaultScanTimeout';         // DOCSIS x.x: TLV 41.3
ID_SINGLEDSCHANNEL      :  'SingleDsChannel';         // DOCSIS x.x: TLV 41.1
ID_SINGLEDSTIMEOUT      :  'SingleDsTimeout';         // DOCSIS x.x: TLV 41.1.1
ID_SINGLEDSFREQUENCY    :  'SingleDsFrequency';       // DOCSIS x.x: TLV 41.1.2
ID_DSFREQRANGE       :  'DsFreqRange';          // DOCSIS x.x: TLV 41.2
ID_DSFREQRANGETIMEOUT      :  'DsFreqRangeTimeout';         // DOCSIS x.x: TLV 41.2.1
ID_DSFREQRANGESTART     :  'DsFreqRangeStart';        // DOCSIS x.x: TLV 41.2.2
ID_DSFREQRANGEEND    :  'DsFreqRangeEnd';       // DOCSIS x.x: TLV 41.2.3
ID_DSFREQRANGESTEPSIZE     :  'DsFreqRangeStepSize';        // DOCSIS x.x: TLV 41.2.4
*/
      idTLV.put(DocsisLexer.ID_VENDORSPECIFIC,                       "ch.gauteron.docsis.TLVs.TLV_VendorSpecific");                    // TLV 43
      idTLV.put(DocsisLexer.ID_VENDORIDENTIFIER,                     "ch.gauteron.docsis.TLVs.TLV_VendorIdentifier");                  // TLV 43.8
      idTLV.put(DocsisLexer.ID_SNMPCPEACCESSCONTROL,                 "ch.gauteron.docsis.TLVs.TLV_SnmpCpeAccessControl");              // TLV 55

      idTLV.put(DocsisLexer.ID_IPV6SWUPGRADESERVER,                  "ch.gauteron.docsis.TLVs.TLV_IPv6SwUpgradeServer");                  // TLV 58
      idTLV.put(DocsisLexer.ID_MTACONFIGDELIMITER,                   "ch.gauteron.docsis.TLVs.TLV_MtaConfigDelimiter");                   // TLV 254

     idTLV.put(DocsisLexer.ID_GENERICTLV,                            "ch.gauteron.docsis.TLVs.TLV_GenericTLV");                            // Generic
//   MUST NOT BE REFERENCED: Pad (automatically added at file creation)
//   MUST NOT BE REFERENCED: EndOfDataMkr (automatically added at file creation)
      inited = true;
   }

   public static String getClassName(int ID)
   {
      if(!inited)
         init();

      return idTLV.get(ID);
   }

   public static TLV instanciateClass(int ID)
   {
      if(!inited)
         init();

      Class c;
      Constructor cons;
      String className = getClassName(ID);
      TLV tlv;

      // Let's load the class
      try
      {
         c = cl.loadClass(className);
      }
      catch(Exception e)
      {
         System.err.println("Error while loading class " + className + ".");
         System.err.println(e);
         return null;
      }

      // Let's instanciate the class now
      try
      {
         tlv = (TLV)c.newInstance();
      }
      catch(Exception e)
      {
         System.err.println("Error while instanciating class " + className + ".");
         System.err.println(e);
         return null;
      }

      return tlv;
   }
}

