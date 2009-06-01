/****************************************************************************
 *                                                                          *
 *  jdocsis - DocsisLexer.[g|java]                                          *
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

lexer grammar DocsisLexer;

@header {package ch.gauteron.jdocsis.parser;}

/*********************************
 * Declaration of special tokens *
 *********************************/
// WS: Whitespaces. Skips all whitespaces
WS
	:	(' ' | '\t' | '\n' | '\r')+ { skip(); }
	;

// COMMENT: Multi-line comment. Skip it
COMMENT
	:	'/*' (options {greedy=false;} : . )*  '*/' { skip(); }
	;
	
// LINE_COMMENT: One-line comment. Skip it
LINE_COMMENT
	:	'//' ~('\n'|'\r')*  ('\r\n' | '\r' | '\n') { skip(); }
	|	'//' ~('\n'|'\r')*  { skip(); }
	;  



/************************************************
 * Declaration of the configuration file tokens *
 ************************************************/
// STATIC_MAIN: Configuration "Main" keyword
STATIC_MAIN
	:	('M'|'m') ('A'|'a') ('I'|'i') ('N'|'n')
	;

/************************************
 * Declaration of the Docsis tokens *
 ************************************/
// Docsis tokens follows

ID_DOWNSTREAMFREQUENCY 		:	'DownstreamFrequency';			// DOCSIS 1.0: TLV 1
ID_UPSTREAMCHANNELID 		:	'UpstreamChannelId';			// DOCSIS 1.0: TLV 2
ID_NETWORKACCESS		:	'NetworkAccess';			// DOCSIS 1.0: TLV 3
ID_CLASSOFSERVICE		:	'ClassOfService';			// DOCSIS 1.0: TLV 4
ID_CLASSID			:	'ClassID';				// DOCSIS 1.0: TLV 4.1
ID_MAXRATEDOWN			:	'MaxRateDown';				// DOCSIS 1.0: TLV 4.2
ID_MAXRATEUP			:	'MaxRateUp';				// DOCSIS 1.0: TLV 4.3
ID_PRIORITYUP			:	'PriorityUp';				// DOCSIS 1.0: TLV 4.4
ID_GUARANTEEDUP			:	'GuaranteedUp';				// DOCSIS 1.0: TLV 4.5
ID_MAXBURSTUP			:	'MaxBurstUp';				// DOCSIS 1.0: TLV 4.6
ID_PRIVACYENABLE		:	'PrivacyEnable';			// DOCSIS 1.0: TLV 4.7
ID_MODEMCAPABILITIES		:	'ModemCapabilities';			// DOCSIS 1.x: TLV 5 
ID_CONCATENATIONSUPPORT		:	'ConcatenationSupport';			// DOCSIS 1.x: TLV 5.1
ID_MODEMDOCSISVERSION		:	'ModemDocsisVersion';			// DOCSIS 1.x: TLV 5.2
ID_FRAGMENTATIONSUPPORT		:	'FragmentationSupport';			// DOCSIS 1.x: TLV 5.3
ID_PHSSUPPORT			:	'PHSSupport';				// DOCSIS 1.x: TLV 5.4
ID_IGMPSUPPORT			:	'IGMPSupport';				// DOCSIS 1.x: TLV 5.5
ID_BASELINEPRIVACYSUPPORT	:	'BaselinePrivacySupport';		// DOCSIS 1.x: TLV 5.6
ID_DOWNSTREAMSAIDSUPPORT	:	'DownstreamSAIDSupport';		// DOCSIS 1.x: TLV 5.7
ID_UPSTREAMSIDSUPPORT		:	'UpstreamSIDSupport';			// DOCSIS 1.x: TLV 5.8
ID_DCCSUPPORT			:	'DCCSupport';				// DOCSIS 1.x: TLV 5.12
ID_SWUPGRADEFILENAME		:	'SwUpgradeFilename';			// DOCSIS 1.0: TLV 8
ID_SNMPWRITECONTROL		:	'SnmpWriteControl';			// DOCSIS x.x: TLV 10
ID_SNMPMIBOBJECT		:	'SnmpMibObject';			// DOCSIS 1.0: TLV 11
ID_CPEMACADDRESS		:	'CpeMacAddress';			// DOCSIS x.x: TLV 14
ID_BASELINEPRIVACY		:	'BaselinePrivacy';			// DOCSIS 1.x: TLV 17
ID_AUTHTIMEOUT			:	'AuthTimeout';				// DOCSIS 1.x: TLV 17.1
ID_REAUTHTIMEOUT		:	'ReAuthTimeout';			// DOCSIS 1.x: TLV 17.2
ID_AUTHGRACETIME		:	'AuthGraceTime';			// DOCSIS 1.x: TLV 17.3
ID_OPERTIMEOUT			:	'OperTimeout';				// DOCSIS 1.x: TLV 17.4
ID_REKEYTIMEOUT			:	'ReKeyTimeout';				// DOCSIS 1.x: TLV 17.5
ID_TEKGRACETIME			:	'TEKGraceTime';				// DOCSIS 1.x: TLV 17.6
ID_AUTHREJECTTIMEOUT		:	'AuthRejectTimeout';			// DOCSIS 1.x: TLV 17.7
ID_SAMAPWAITTIMEOUT		:	'SAMapWaitTimeout';			// DOCSIS 1.x: TLV 17.8
ID_SAMAPMAXRETRIES		:	'SAMapMaxRetries';			// DOCSIS 1.x: TLV 17.9
ID_MAXCPE			:	'MaxCPE';				// DOCSIS 1.0: TLV 18
ID_TFTPTIMESTAMP		:	'TftpTimestamp';			// DOCSIS x.x: TLV 19
ID_TFTPMODEMADDRESS		:	'TftpModemAddress';			// DOCSIS x.x: TLV 20
ID_SWUPGRADESERVER		:	'SwUpgradeServer';			// DOCSIS 1.0: TLV 21
ID_USPACKETCLASS		:	'UsPacketClass';			// DOCSIS 1.1: TLV 22
ID_DSPACKETCLASS		:	'DsPacketClass';			// DOCSIS 1.1: TLV 23
ID_CLASSIFIERREF		:	'ClassifierRef';			// DOCSIS 1.1: TLV [22|23].1
ID_CLASSIFIERID			:	'ClassifierId';				// DOCSIS 1.1: TLV [22|23].2
ID_SERVICEFLOWREF		:	'ServiceFlowRef';			// DOCSIS 1.1: TLV [22|23].3 + TLV [24|25].1
ID_SERVICEFLOWID		:	'ServiceFlowId';			// DOCSIS 1.1: TLV [22|23].4 + TLV [24|25].2
ID_RULEPRIORITY			:	'RulePriority';				// DOCSIS 1.1: TLV [22|23].5
ID_ACTIVATIONSTATE		:	'ActivationState';			// DOCSIS 1.1: TLV [22|23].6
ID_DSCACTION			:	'DscAction';				// DOCSIS 1.1: TLV [22|23].7
ID_IPPACKETCLASSIFIER		:	'IpPacketClassifier';			// DOCSIS 1.1: TLV [22|23].9
ID_IPTOS			:	'IpTos';				// DOCSIS 1.1: TLV [22|23].9.1
ID_IPPROTO			:	'IpProto';				// DOCSIS 1.1: TLV [22|23].9.2
ID_IPSRCADDR			:	'IpSrcAddr';				// DOCSIS 1.1: TLV [22|23].9.3
ID_IPSRCMASK			:	'IpSrcMask';				// DOCSIS 1.1: TLV [22|23].9.4
ID_IPDSTADDR			:	'IpDstAddr';				// DOCSIS 1.1: TLV [22|23].9.5
ID_IPDSTMASK			:	'IpDstMask';				// DOCSIS 1.1: TLV [22|23].9.6
ID_SRCPORTSTART			:	'SrcPortStart';				// DOCSIS 1.1: TLV [22|23].9.7
ID_SRCPORTEND			:	'SrcPortEnd';				// DOCSIS 1.1: TLV [22|23].9.8
ID_DSTPORTSTART			:	'DstPortStart';				// DOCSIS 1.1: TLV [22|23].9.9
ID_DSTPORTEND			:	'DstPortEnd';				// DOCSIS 1.1: TLV [22|23].9.10
ID_LLCPACKETCLASSIFIER		:	'LLCPacketClassifier';			// DOCSIS 1.1: TLV [22|23].10
ID_DSTMACADDRESS		:	'DstMacAddress';			// DOCSIS 1.1: TLV [22|23].10.1
ID_SRCMACADDRESS	 	:	'SrcMacAddress';			// DOCSIS 1.1: TLV [22|23].10.2
ID_ETHERTYPE			:	'EtherType';				// DOCSIS 1.1: TLV [22|23].10.3
ID_IEEE802CLASSIFIER		:	'IEEE802Classifier';			// DOCSIS 1.1: TLV [22|23].11
ID_USERPRIORITY			:	'UserPriority';				// DOCSIS 1.1: TLV [22|23].11.1
ID_VLANID			:	'VlanID';				// DOCSIS 1.1: TLV [22|23].11.2
ID_IPV6PACKETCLASSIFIER		:	'IPv6PacketClassifier';			// DOCSIS 3.0: TLV [22|23].12
ID_IPV6TRAFFICCLASSRANGEMASK	:	'IPv6TrafficClassRangeMask';		// DOCSIS 3.0: TLV [22|23].12.1
ID_IPV6FLOWLABEL		:	'IPv6FlowLabel';			// DOCSIS 3.0: TLV [22|23].12.2
ID_IPV6NEXTHEADERTYPE		:	'IPv6NextHeaderType';			// DOCSIS 3.0: TLV [22|23].12.3
ID_IPV6SRCADDR			:	'IPv6SrcAddr';				// DOCSIS 3.0: TLV [22|23].12.4
ID_IPV6SRCPREFLENGTH		:	'IPv6SrcPrefLength';			// DOCSIS 3.0: TLV [22|23].12.5
ID_IPV6DSTADDR			:	'IPv6DstAddr';				// DOCSIS 3.0: TLV [22|23].12.6
ID_IPV6DSTPREFLENGTH		:	'IPv6DstPrefLength';			// DOCSIS 3.0: TLV [22|23].12.7
ID_USSERVICEFLOW		:	'UsServiceFlow';			// DOCSIS 1.1: TLV 24
ID_DSSERVICEFLOW		:	'DsServiceFlow';			// DOCSIS 1.1: TLV 25
ID_USSERVICEFLOWREF		:	'UsServiceFlowRef';			// DOCSIS 1.1: TLV 24.1 (Alias, obsoleted by "ID_SERVICEFLOWREF")
ID_USSERVICEFLOWID		:	'UsServiceFlowId';			// DOCSIS 1.1: TLV 24.2 (Alias, obsoleted by "ID_SERVICEFLOWID")
ID_DSSERVICEFLOWREF		:	'DsServiceFlowRef';			// DOCSIS 1.1: TLV 25.1 (Alias, obsoleted by "ID_SERVICEFLOWREF")
ID_DSSERVICEFLOWID		:	'DsServiceFlowId';			// DOCSIS 1.1: TLV 25.2 (Alias, obsoleted by "ID_SERVICEFLOWID")
ID_SERVICECLASSNAME		:	'ServiceClassName';			// DOCSIS 1.1: TLV [24|25].4
ID_QOSPARAMSETTYPE		:	'QosParamSetType';			// DOCSIS 1.1: TLV [24|25].6
ID_TRAFFICPRIORITY		:	'TrafficPriority';			// DOCSIS 1.1: TLV [24|25].7
ID_MAXRATESUSTAINED		:	'MaxRateSustained';			// DOCSIS 1.1: TLV [24|25].8
ID_MAXTRAFFICBURST		:	'MaxTrafficBurst';			// DOCSIS 1.1: TLV [24|25].9
ID_MINRESERVEDRATE		:	'MinReservedRate';			// DOCSIS 1.1: TLV [24|25].10
ID_MINRESPACKETSIZE		:	'MinResPacketSize';			// DOCSIS 1.1: TLV [24|25].11
ID_ACTQOSPARAMSTIMEOUT		:	'ActQosParamsTimeout';			// DOCSIS 1.1: TLV [24|25].12
ID_ADMQOSPARAMSTIMEOUT		:	'AdmQosParamsTimeout';			// DOCSIS 1.1: TLV [24|25].13
ID_MAXCONCATENATEDBURST		:	'MaxConcatenatedBurst';			// DOCSIS 1.1: TLV 24.14
ID_SCHEDULINGTYPE		:	'SchedulingType';			// DOCSIS 1.1: TLV 24.15
ID_REQUESTORTXPOLICY		:	'RequestOrTxPolicy';			// DOCSIS 1.1: TLV 24.16
ID_NOMINALPOLLINTERVAL		:	'NominalPollInterval';			// DOCSIS 1.1: TLV 24.17
ID_TOLERATEDPOLLJITTER		:	'ToleratedPollJitter';			// DOCSIS 1.1: TLV 24.18
ID_UNSOLICITEDGRANTSIZE		:	'UnsolicitedGrantSize';			// DOCSIS 1.1: TLV 24.19
ID_NOMINALGRANTINTERVAL		:	'NominalGrantInterval';			// DOCSIS 1.1: TLV 24.20
ID_TOLERATEDGRANTJITTER		:	'ToleratedGrantJitter';			// DOCSIS 1.1: TLV 24.21
ID_GRANTSPERINTERVAL		:	'GrantsPerInterval';			// DOCSIS 1.1: TLV 24.22
ID_IPTOSOVERWRITE		:	'IpTosOverwrite';			// DOCSIS 1.1: TLV 24.23
ID_MAXDSLATENCY			:	'MaxDsLatency';				// DOCSIS 1.1: TLV 25.14
ID_PHS				:	'PHS';					// DOCSIS x.x: TLV 26
ID_PHSCLASSIFIERREF		:	'PHSClassifierRef';			// DOCSIS x.x: TLV 26.1
ID_PHSCLASSIFIERID		:	'PHSClassifierId';			// DOCSIS x.x: TLV 26.2
ID_PHSERVICEFLOWREF		:	'PHSServiceFlowRef';			// DOCSIS x.x: TLV 26.3
ID_PHSSERVICEFLOWID		:	'PHSServiceFlowId';			// DOCSIS x.x: TLV 26.4
ID_PHSFIELD			:	'PHSField';				// DOCSIS x.x: TLV 26.7
ID_PHSINDEX			:	'PHSIndex';				// DOCSIS x.x: TLV 26.8
ID_PHSMASK			:	'PHSMask';				// DOCSIS x.x: TLV 26.9
ID_PHSSIZE			:	'PHSSize';				// DOCSIS x.x: TLV 26.10
ID_PHSVERIFY			:	'PHSVerify';				// DOCSIS x.x: TLV 26.11
ID_MAXCLASSIFIERS		:	'MaxClassifiers';			// DOCSIS x.x: TLV 28
ID_GLOBALPRIVACYENABLE		:	'GlobalPrivacyEnable';			// DOCSIS x.x: TLV 29
ID_MFGCVCDATA			:	'MfgCVCData';				// DOCSIS 1.1: TLV 32
ID_MANUFACTURERCVC		:	'ManufacturerCVC';			// DOCSIS 1.1: TLV 32 (alias)
ID_COSIGNERCVCDATA		:	'CoSignerCVCData';			// DOCSIS 1.1: TLV 33
ID_COSIGNERCVC			:	'CoSignerCVC';				// DOCSIS 1.1: TLV 33 (alias)
ID_SNMPV3KICKSTART		:	'SnmpV3Kickstart';			// DOCSIS x.x: TLV 34
ID_SNMPV3SECURITYNAME		:	'SnmpV3SecurityName';			// DOCSIS x.x: TLV 34.1
ID_SNMPV3MGRPUBLICNUMBER	:	'SnmpV3MgrPublicNumber';		// DOCSIS x.x: TLV 34.2
ID_SUBMGMTCONTROL		:	'SubMgmtControl';			// DOCSIS x.x: TLV 35
ID_SUBMGMTFILTERS		:	'SubMgmtFilters'; 			// DOCSIS x.x: TLV 37
ID_SNMPV3TRAPRECEIVER		:	'SnmpV3TrapReceiver';			// DOCSIS x.x: TLV 38
ID_SNMPV3TRAPRXIP		:	'SnmpV3TrapRxIP';			// DOCSIS x.x: TLV 38.1
ID_SNMPV3TRAPRXPORT		:	'SnmpV3TrapRxPort';			// DOCSIS x.x: TLV 38.2
ID_SNMPV3TRAPRXTYPE		:	'SnmpV3TrapRxType';			// DOCSIS x.x: TLV 38.3
ID_SNMPV3TRAPRXTIMEOUT		:	'SnmpV3TrapRxTimeout';			// DOCSIS x.x: TLV 38.4
ID_SNMPV3TRAPRXRETRIES		:	'SnmpV3TrapRxRetries';			// DOCSIS x.x: TLV 38.5
ID_SNMPV3TRAPRXFILTEROID	:	'SnmpV3TrapRxFilterOID';		// DOCSIS x.x: TLV 38.6
ID_SNMPV3TRAPRXSECURITYNAME	:	'SnmpV3TrapRxSecurityName';		// DOCSIS x.x: TLV 38.7
ID_SNMPV3TRAPRXIPV6		:	'SnmpV3TrapRxIPv6';			// DOCSIS 3.0: TLV 38.8
ID_DOCSISTWOENABLE		:	'DocsisTwoEnable';			// DOCSIS 2.0: TLV 39
ID_TESTMODEENABLE		:	'TestModeEnable';			// DOCSIS 2.0: TLV 40
ID_DSCHANNELLIST		:	'DsChannelList';			// DOCSIS x.x: TLV 41
ID_DEFAULTSCANTIMEOUT		:	'DefaultScanTimeout';			// DOCSIS x.x: TLV 41.3
ID_SINGLEDSCHANNEL		:	'SingleDsChannel';			// DOCSIS x.x: TLV 41.1
ID_SINGLEDSTIMEOUT		:	'SingleDsTimeout';			// DOCSIS x.x: TLV 41.1.1
ID_SINGLEDSFREQUENCY		:	'SingleDsFrequency';			// DOCSIS x.x: TLV 41.1.2
ID_DSFREQRANGE			:	'DsFreqRange';				// DOCSIS x.x: TLV 41.2
ID_DSFREQRANGETIMEOUT		:	'DsFreqRangeTimeout';			// DOCSIS x.x: TLV 41.2.1
ID_DSFREQRANGESTART		:	'DsFreqRangeStart';			// DOCSIS x.x: TLV 41.2.2
ID_DSFREQRANGEEND		:	'DsFreqRangeEnd';			// DOCSIS x.x: TLV 41.2.3
ID_DSFREQRANGESTEPSIZE		:	'DsFreqRangeStepSize';			// DOCSIS x.x: TLV 41.2.4
ID_VENDORSPECIFIC		:	'VendorSpecific';			// DOCSIS x.x: TLV 43
ID_VENDORIDENTIFIER		:	'VendorIdentifier';			// DOCSIS x.x: TLV 43.8
ID_SNMPCPEACCESSCONTROL		:	'SnmpCpeAccessControl';			// DOCSIS 3.0: TLV 55
ID_IPV6SWUPGRADESERVER		:	'IPv6SwUpgradeServer';			// DOCSIS 3.0: TLV 58
ID_MTACONFIGDELIMITER		:	'MtaConfigDelimiter';			// PACKETCABLE: TLV 254

// Support for undefined Docsis TLV
ID_GENERICTLV			:	'GenericTLV';
TLV_CODE			:	'TlvCode';
TLV_LENGTH			:	'TlvLength';
TLV_VALUE			:	'TlvValue';

/**************************************************
 * Declaration of the tokens for the SNMP-support *
 **************************************************/
SNMP_INTEGER			:	'Integer';
SNMP_COUNTER32			:	'Counter32';
SNMP_GAUGE32			:	'Gauge' 
				|	'Gauge32';
SNMP_TIMETICKS			:	'TimeTicks';
SNMP_UNSIGNED32			:	'Unsigned32';
SNMP_COUNTER64			:	'Counter64';
SNMP_OCTETSTRING		:	'OctetString';
SNMP_IPADDRESS			:	'IpAddress';
SNMP_Opaque			:	'Opaque';
SNMP_OID			:	'ObjectID';
SNMP_BITSTRING			:	'BitString';
SNMP_STRING			:	'String';
SNMP_HEXSTRING			:	'HexString';


/********************************************
 * Declaration of the supported type tokens *
 ********************************************/
T_INTLIST4			:	T_INT ',' T_INT ',' T_INT ',' T_INT;
T_INT				:	S_SIGN? S_DIGIT+;			// Integer values
T_HEXSTR			:	'0' ('x'|'X') S_HEXDIGIT+;		// Hexadecimal strings ("0x001122..")
T_MACADDR			:	S_HEX2 ':' S_HEX2 ':' S_HEX2 ':' S_HEX2 ':' S_HEX2 ':' S_HEX2;
										// MAC address ("00:11:22:33:44:55")
T_MACMASK			:	T_MACADDR '/' T_MACADDR;		// MAC+mask
T_IP				:	S_DIGIT+ '.' S_DIGIT+ '.' S_DIGIT+ '.' S_DIGIT+;
										// IPv4 address
T_IPV6				:	S_HEX4FAC ':' S_HEX4FAC ':' S_HEX4FAC ':' S_HEX4FAC ':' S_HEX4FAC ':' S_HEX4FAC ':' S_HEX4FAC ':' S_HEX4FAC
				|	((S_HEX4FAC ':')* S_HEX4FAC+)? '::' ((S_HEX4FAC ':')* S_HEX4FAC+)?
  				;						// IPv6 address
T_OID				:	'.'? ((S_ALPHANUM | '_' | '-')+ '.')+ (S_ALPHANUM)+ 
				|	'.'? ((S_ALPHANUM | '_' | '-')+ '.')+ '\'' (S_ALPHANUM | '[' | ']' | ',' | ':' | '_' | '-' | '.')+ '\''
				|	'.'? ((S_ALPHANUM | '_' | '-')+ '.')+ '"' (S_ALPHANUM | '[' | ']' | ',' | ':' | '_' | '-' | '.')+ '"'
				;						// SNMP OID (text or number)
T_TIMETICKS			:	(S_DIGIT+ ':')(S_DIGIT+ ':')(S_DIGIT+ ':') '.' S_DIGIT+;
										// Tiketicks ("00:11:22.123")
T_STRING			:	'"' ~'"'* '"';				// String

/********************************
 * Declaration of atomic tokens *
 ********************************/
fragment S_SIGN			:	'+' | '-';
fragment S_DIGIT		:	'0'..'9';
fragment S_LOWER		:	'a'..'z';
fragment S_UPPER		:	'A'..'Z';
fragment S_LETTER		:	S_LOWER | S_UPPER;
fragment S_ALPHANUM		:	S_DIGIT | S_LETTER;
fragment S_LOWERHEXDIGIT	:	'a'..'f';
fragment S_UPPERHEXDIGIT	:	'A'..'F';
fragment S_HEXDIGIT		:	S_DIGIT | S_LOWERHEXDIGIT | S_UPPERHEXDIGIT;
fragment S_HEX2			:	S_HEXDIGIT S_HEXDIGIT;
fragment S_HEX4FAC		:	S_HEXDIGIT ((S_HEXDIGIT? S_HEXDIGIT)? S_HEXDIGIT)?;
S_SEMICOLON			:	';';
S_OPENBRACE			:	'{';
S_CLOSEBRACE			:	'}';