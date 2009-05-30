/****************************************************************************
 *                                                                          *
 *  jdocsis - DocsisParser.g                                                *
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
 
parser grammar DocsisParser;

options {
	output=AST;
	ASTLabelType=CommonTree;
	tokenVocab = DocsisLexer;
}

@header { package ch.gauteron.docsis.parser; }

// Main rules
main				:	STATIC_MAIN! S_OPENBRACE! (statement)+ S_CLOSEBRACE! EOF!;

genericTLVStat			:	ID_GENERICTLV^ 			TLV_CODE T_INT TLV_LENGTH T_INT TLV_VALUE T_HEXSTR	S_SEMICOLON!;

// Statement
statement			:	ID_DOWNSTREAMFREQUENCY^		T_INT							S_SEMICOLON!
				|	ID_UPSTREAMCHANNELID^		T_INT							S_SEMICOLON!
				|	ID_NETWORKACCESS^		T_INT							S_SEMICOLON!
				|	ID_SWUPGRADEFILENAME^		T_STRING						S_SEMICOLON!
				|	ID_SNMPWRITECONTROL^		T_OID T_INT						S_SEMICOLON!
				|	ID_SNMPMIBOBJECT^		T_OID snmpType						S_SEMICOLON!
				|	ID_CPEMACADDRESS^		T_MACADDR						S_SEMICOLON!
				|	ID_MAXCPE^			T_INT							S_SEMICOLON!
				|	ID_TFTPTIMESTAMP^		T_INT							S_SEMICOLON!
				|	ID_TFTPMODEMADDRESS^		T_IP							S_SEMICOLON!
				|	ID_SWUPGRADESERVER^		T_IP							S_SEMICOLON!
				|	ID_MAXCLASSIFIERS^		T_INT							S_SEMICOLON!
				|	ID_GLOBALPRIVACYENABLE^		T_INT							S_SEMICOLON!
				|	ID_MFGCVCDATA^			T_HEXSTR						S_SEMICOLON!
				|	ID_MANUFACTURERCVC^		T_HEXSTR						S_SEMICOLON!
				|	ID_COSIGNERCVCDATA^		T_HEXSTR						S_SEMICOLON!
				|	ID_COSIGNERCVC^			T_HEXSTR						S_SEMICOLON!
				|	ID_SUBMGMTCONTROL^		T_HEXSTR						S_SEMICOLON!
				|	ID_SUBMGMTFILTERS^		T_INTLIST4						S_SEMICOLON!
				|	ID_DOCSISTWOENABLE^		T_INT							S_SEMICOLON!
				|	ID_TESTMODEENABLE^		T_INT							S_SEMICOLON!
				|	ID_SNMPCPEACCESSCONTROL^	T_INT							S_SEMICOLON!
				|	ID_IPV6SWUPGRADESERVER^		T_IPV6							S_SEMICOLON!
				|	ID_MTACONFIGDELIMITER^		T_INT							S_SEMICOLON!
				|	ID_CLASSOFSERVICE^ 		S_OPENBRACE! (classOfServiceStat)+			S_CLOSEBRACE! 
				|	ID_MODEMCAPABILITIES^ 		S_OPENBRACE! (modemCapabilitiesStat)+			S_CLOSEBRACE!
				|	ID_BASELINEPRIVACY^ 		S_OPENBRACE! (baselinePrivacyStat)+			S_CLOSEBRACE!
				|	ID_USPACKETCLASS^ 		S_OPENBRACE! (usdsPacketClassStat)+			S_CLOSEBRACE!
				|	ID_DSPACKETCLASS^ 		S_OPENBRACE! (usdsPacketClassStat)+			S_CLOSEBRACE!
				|	ID_USSERVICEFLOW^ 		S_OPENBRACE! (usServiceFlowStat)+			S_CLOSEBRACE!
				|	ID_DSSERVICEFLOW^ 		S_OPENBRACE! (dsServiceFlowStat)+			S_CLOSEBRACE!
				|	ID_PHS^ 			S_OPENBRACE! (phsStat)+					S_CLOSEBRACE!
				|	ID_SNMPV3KICKSTART^ 		S_OPENBRACE! (snmpV3KickstartStat)+			S_CLOSEBRACE!
				|	ID_SNMPV3TRAPRECEIVER^ 		S_OPENBRACE! (snmpV3TrapReceiverStat)+			S_CLOSEBRACE!
				|	ID_DSCHANNELLIST^ 		S_OPENBRACE! (dsChannelListStat)+			S_CLOSEBRACE!
				|	ID_VENDORSPECIFIC^ 		S_OPENBRACE! (vendorSpecificStat)+			S_CLOSEBRACE!
				|	genericTLVStat
				;

// ClassOfService sub-statement (DOCSIS 1.0 TLV 4)
classOfServiceStat		:	ID_CLASSID^ 			T_INT							S_SEMICOLON!
				|	ID_MAXRATEDOWN^			T_INT							S_SEMICOLON!
				|	ID_MAXRATEUP^			T_INT							S_SEMICOLON!
				|	ID_PRIORITYUP^			T_INT							S_SEMICOLON!
				|	ID_GUARANTEEDUP^		T_INT							S_SEMICOLON!
				|	ID_MAXBURSTUP^			T_INT							S_SEMICOLON!
				|	ID_PRIVACYENABLE^		T_INT							S_SEMICOLON!
				|	genericTLVStat
				;

// ModemCapabilities sub-statement (DOCSIS x.x TLV 5)
modemCapabilitiesStat		:	ID_CONCATENATIONSUPPORT^	T_INT							S_SEMICOLON!
				|	ID_MODEMDOCSISVERSION^		T_INT							S_SEMICOLON!
				|	ID_FRAGMENTATIONSUPPORT^	T_INT							S_SEMICOLON!
				|	ID_PHSSUPPORT^			T_INT							S_SEMICOLON!
				|	ID_IGMPSUPPORT^			T_INT							S_SEMICOLON!
				|	ID_BASELINEPRIVACYSUPPORT^	T_INT							S_SEMICOLON!
				|	ID_DOWNSTREAMSAIDSUPPORT^	T_INT							S_SEMICOLON!
				|	ID_UPSTREAMSIDSUPPORT^		T_INT							S_SEMICOLON!
				|	ID_DCCSUPPORT^			T_INT							S_SEMICOLON!
				|	genericTLVStat
				;

// BaselinePrivacy sub-statement (DOCSIS x.x TLV 17)
baselinePrivacyStat		:	ID_AUTHTIMEOUT^			T_INT							S_SEMICOLON!
				|	ID_REAUTHTIMEOUT^		T_INT							S_SEMICOLON!
				|	ID_AUTHGRACETIME^		T_INT							S_SEMICOLON!
				|	ID_OPERTIMEOUT^			T_INT							S_SEMICOLON!
				|	ID_REKEYTIMEOUT^		T_INT							S_SEMICOLON!
				|	ID_TEKGRACETIME^		T_INT							S_SEMICOLON!
				|	ID_AUTHREJECTTIMEOUT^		T_INT							S_SEMICOLON!
				|	ID_SAMAPWAITTIMEOUT^		T_INT							S_SEMICOLON!
				|	ID_SAMAPMAXRETRIES^		T_INT							S_SEMICOLON!
				|	genericTLVStat
				;

// [Us|Ds]PacketClass sub-statement (DOCSIS 1.1 TLV [22|23])
usdsPacketClassStat		:	ID_CLASSIFIERREF^		T_INT							S_SEMICOLON!
				|	ID_CLASSIFIERID^		T_INT							S_SEMICOLON!
				|	ID_SERVICEFLOWREF^		T_INT							S_SEMICOLON!
				|	ID_SERVICEFLOWID^		T_INT							S_SEMICOLON!
				|	ID_RULEPRIORITY^		T_INT							S_SEMICOLON!
				|	ID_ACTIVATIONSTATE^		T_INT							S_SEMICOLON!
				|	ID_DSCACTION^			T_INT							S_SEMICOLON!
				|	ID_IPPACKETCLASSIFIER^		S_OPENBRACE! (ipPacketClassifierStat)+			S_CLOSEBRACE!
				|	ID_LLCPACKETCLASSIFIER^		S_OPENBRACE! (llcPacketClassifierStat)+			S_CLOSEBRACE!
				|	ID_IEEE802CLASSIFIER^		S_OPENBRACE! (ieee802ClassifierStat)+			S_CLOSEBRACE!
				|	ID_IPV6PACKETCLASSIFIER^	S_OPENBRACE! (ipv6PacketClassifierStat)+		S_CLOSEBRACE!
				|	genericTLVStat
				;
				
 
// IpPacketClassifier sub-sub-statement (DOCSIS 1.1 TLV [22|23])
ipPacketClassifierStat		:	ID_IPTOS^			T_HEXSTR						S_SEMICOLON!
				|	ID_IPPROTO^			T_INT							S_SEMICOLON!
				|	ID_IPSRCADDR^			T_IP							S_SEMICOLON!
				|	ID_IPSRCMASK^			T_IP							S_SEMICOLON!
				|	ID_IPDSTADDR^			T_IP							S_SEMICOLON!
				|	ID_IPDSTMASK^			T_IP							S_SEMICOLON!
				|	ID_SRCPORTSTART^		T_INT							S_SEMICOLON!
				|	ID_SRCPORTEND^			T_INT							S_SEMICOLON!
				|	ID_DSTPORTSTART^		T_INT							S_SEMICOLON!
				|	ID_DSTPORTEND^			T_INT							S_SEMICOLON!
				|	genericTLVStat
				;

// LLCPacketClassifier sub-sub-statement (DOCSIS 1.1 TLV [22|23])
llcPacketClassifierStat		:	ID_DSTMACADDRESS^		T_MACMASK						S_SEMICOLON!
				|	ID_SRCMACADDRESS^		T_MACADDR						S_SEMICOLON!
				|	ID_ETHERTYPE^			T_HEXSTR						S_SEMICOLON!
				|	genericTLVStat
				;

// IEEE802Classifier sub-sub-statement (DOCSIS 1.1 TLV [22|23])
ieee802ClassifierStat		:	ID_USERPRIORITY^		T_INT							S_SEMICOLON!
				|	ID_VLANID^			T_INT							S_SEMICOLON!
				|	genericTLVStat
				;

// IPv6PacketClassifier sub-sub-statement (DOCSIS 3.0 TLV [22|23])
ipv6PacketClassifierStat	:	ID_IPV6TRAFFICCLASSRANGEMASK^	T_INT							S_SEMICOLON!
				|	ID_IPV6FLOWLABEL^		T_INT							S_SEMICOLON!
				|	ID_IPV6NEXTHEADERTYPE^		T_INT							S_SEMICOLON!
				|	ID_IPV6SRCADDR^			T_IPV6							S_SEMICOLON!
				|	ID_IPV6SRCPREFLENGTH^		T_INT							S_SEMICOLON!
				|	ID_IPV6DSTADDR^			T_IPV6							S_SEMICOLON!
				|	ID_IPV6DSTPREFLENGTH^		T_INT							S_SEMICOLON!
				|	ID_SRCPORTEND^			T_INT							S_SEMICOLON!
				|	ID_DSTPORTSTART^		T_INT							S_SEMICOLON!
				|	ID_DSTPORTEND^			T_INT							S_SEMICOLON!
				|	genericTLVStat
				;


// [Us|Ds]ServiceFlow sub-statement (DOCSIS 1.1 TLV [24|25])
usServiceFlowStat		:	(usdsServiceFlowSubSet | usServiceFlowSubSet);
dsServiceFlowStat		:	(usdsServiceFlowSubSet | dsServiceFlowSubSet);
     
usdsServiceFlowSubSet		:	ID_SERVICEFLOWREF^		T_INT							S_SEMICOLON!
				|	ID_SERVICEFLOWID^		T_INT							S_SEMICOLON!
				|	ID_SERVICECLASSNAME^		T_STRING						S_SEMICOLON!
				|	ID_QOSPARAMSETTYPE^		T_INT							S_SEMICOLON!
				|	ID_TRAFFICPRIORITY^		T_INT							S_SEMICOLON!
				|	ID_MAXRATESUSTAINED^		T_INT							S_SEMICOLON!
				|	ID_MAXTRAFFICBURST^		T_INT							S_SEMICOLON!
				|	ID_MINRESERVEDRATE^		T_INT							S_SEMICOLON!
				|	ID_MINRESPACKETSIZE^		T_INT							S_SEMICOLON!
				|	ID_ACTQOSPARAMSTIMEOUT^		T_INT							S_SEMICOLON!
				|	ID_ADMQOSPARAMSTIMEOUT^		T_INT							S_SEMICOLON!
				|	genericTLVStat
				;

usServiceFlowSubSet		:	ID_USSERVICEFLOWREF^		T_INT							S_SEMICOLON!
				|	ID_USSERVICEFLOWID^		T_INT							S_SEMICOLON!
				|	ID_MAXCONCATENATEDBURST^	T_INT							S_SEMICOLON!
				|	ID_SCHEDULINGTYPE^		T_INT							S_SEMICOLON!
				|	ID_REQUESTORTXPOLICY^		T_HEXSTR						S_SEMICOLON!
				|	ID_NOMINALPOLLINTERVAL^		T_INT							S_SEMICOLON!
				|	ID_TOLERATEDPOLLJITTER^		T_INT							S_SEMICOLON!
				|	ID_UNSOLICITEDGRANTSIZE^	T_INT							S_SEMICOLON!
				|	ID_NOMINALGRANTINTERVAL^	T_INT							S_SEMICOLON!
				|	ID_TOLERATEDGRANTJITTER^	T_INT							S_SEMICOLON!
				|	ID_GRANTSPERINTERVAL^		T_INT							S_SEMICOLON!
				|	ID_IPTOSOVERWRITE^		T_HEXSTR						S_SEMICOLON!
				;

dsServiceFlowSubSet		:	ID_DSSERVICEFLOWREF^		T_INT							S_SEMICOLON!
				|	ID_DSSERVICEFLOWID^		T_INT							S_SEMICOLON!
				|	ID_MAXDSLATENCY^		T_INT							S_SEMICOLON!
				;

// PHS sub-statement (DOCSIS x.x TLV 26)
phsStat				:	ID_PHSCLASSIFIERREF^		T_INT							S_SEMICOLON!
				|	ID_PHSCLASSIFIERID^		T_INT							S_SEMICOLON!
				|	ID_PHSERVICEFLOWREF^		T_INT							S_SEMICOLON!
				|	ID_PHSSERVICEFLOWID^		T_INT							S_SEMICOLON!
				|	ID_PHSFIELD^			T_HEXSTR						S_SEMICOLON!
				|	ID_PHSINDEX^			T_INT							S_SEMICOLON!
				|	ID_PHSMASK^			T_HEXSTR						S_SEMICOLON!
				|	ID_PHSSIZE^			T_INT							S_SEMICOLON!
				|	ID_PHSVERIFY^			T_INT							S_SEMICOLON!
				|	genericTLVStat
				;

// SnmpV3Kickstart sub-statement (DOCSIS x.x TLV 34)
snmpV3KickstartStat		:	ID_SNMPV3SECURITYNAME^		T_STRING						S_SEMICOLON!
				|	ID_SNMPV3MGRPUBLICNUMBER^	T_HEXSTR						S_SEMICOLON!
				|	genericTLVStat
				;

// SnmpV3TrapReceiver sub-statement (DOCSIS x.x TLV 38)
snmpV3TrapReceiverStat		:	ID_SNMPV3TRAPRXIP^		T_STRING						S_SEMICOLON!
				|	ID_SNMPV3TRAPRXPORT^		T_INT							S_SEMICOLON!
				|	ID_SNMPV3TRAPRXTYPE^		T_INT							S_SEMICOLON!
				|	ID_SNMPV3TRAPRXTIMEOUT^		T_INT							S_SEMICOLON!
				|	ID_SNMPV3TRAPRXRETRIES^		T_INT							S_SEMICOLON!
				|	ID_SNMPV3TRAPRXFILTEROID^	T_OID							S_SEMICOLON!
				|	ID_SNMPV3TRAPRXSECURITYNAME^	T_STRING						S_SEMICOLON!
				|	genericTLVStat
				;

// DsChannelList sub-statement (DOCSIS x.x TLV 41)
dsChannelListStat		:	ID_DEFAULTSCANTIMEOUT^		T_INT							S_SEMICOLON!
				|	ID_SINGLEDSCHANNEL^		S_OPENBRACE! (singleDsChannelStat)+			S_CLOSEBRACE!
				|	ID_DSFREQRANGE^			S_OPENBRACE! (dsFreqRangeStat)+				S_CLOSEBRACE!
				|	genericTLVStat
				;

// SingleDsChannel sub-sub-statement
singleDsChannelStat
				:	ID_SINGLEDSTIMEOUT^		T_INT							S_SEMICOLON!	// DOCSIS x.x: TLV 41.1.1
				|	ID_SINGLEDSFREQUENCY^		T_INT							S_SEMICOLON!	// DOCSIS x.x: TLV 41.1.2
				|	genericTLVStat
				;

// DsFreqRange sub-sub-statement
dsFreqRangeStat
				:	ID_DSFREQRANGETIMEOUT^		T_INT							S_SEMICOLON!	// DOCSIS x.x: TLV 41.2.1
				|	ID_DSFREQRANGESTART^		T_INT							S_SEMICOLON!	// DOCSIS x.x: TLV 41.2.2
				|	ID_DSFREQRANGEEND^		T_INT							S_SEMICOLON!	// DOCSIS x.x: TLV 41.2.3
				|	ID_DSFREQRANGESTEPSIZE^		T_INT							S_SEMICOLON!	// DOCSIS x.x: TLV 41.2.4
				|	genericTLVStat
				;

// VendorSpecific complex rule and statements (DOCSIS x.x TLV 43)
vendorSpecificStat
				:	ID_VENDORIDENTIFIER^		T_HEXSTR						S_SEMICOLON!
				|	genericTLVStat
				;


// SNMP types and values
// TODO: Not yet managed "OPAQUE" and "BITSTRING"
snmpType       			:	SNMP_INTEGER			T_INT
				|	SNMP_COUNTER32			T_INT
				|	SNMP_GAUGE32			T_INT
				|	SNMP_UNSIGNED32			T_INT
				|	SNMP_COUNTER64			T_INT
				|	SNMP_IPADDRESS			T_IP
				|	SNMP_OID			T_OID
				|	SNMP_STRING			T_STRING
				|	SNMP_HEXSTRING			T_HEXSTR
				|	SNMP_TIMETICKS			T_TIMETICKS
				;
