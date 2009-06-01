#****************************************************************************
#*                                                                          *
#*  jdocsis - Makefile                                                      *
#*                                                                          *
#*  Copyright (C) 2009, Yann Gauteron <yann.gauteron@gauteron.ch>           *
#*  All rights reserved.                                                    *
#*                                                                          *
#*  Redistribution and use in source and binary forms, with or without      *
#*  modification, are permitted provided that the following conditions are  *
#*  met:                                                                    *
#*    1. Redistributions of source code must retain the above copyright     *
#*       notice, this list of conditions and the following disclaimer.      *
#*    2. Redistributions in binary form must reproduce the above copyright  *
#*       notice, this list of conditions and the following disclaimer in    *
#*       the documentation and/or other materials provided with the         *
#*       distribution.                                                      *
#*                                                                          *
#*  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS     *
#*  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT       *
#*  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR   *
#*  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT    *
#*  HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,  *
#*  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT        *
#*  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,   *
#*  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY   *
#*  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT     *
#*  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE   *
#*  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.    *
#*                                                                          *
#****************************************************************************

DESTCLASS = ../class/
DESTCOMMONCLASSDIR = $(DESTCLASS)/ch/gauteron/jdocsis/common
DESTENCODERCLASSDIR = $(DESTCLASS)/ch/gauteron/jdocsis/encoder
DESTEXCEPTIONCLASSDIR = $(DESTCLASS)/ch/gauteron/jdocsis/exceptions
DESTPARSERCLASSDIR = $(DESTCLASS)/ch/gauteron/jdocsis/parser
DESTTLVCLASSDIR = $(DESTCLASS)/ch/gauteron/jdocsis/TLVs
PARSERDIR = ch/gauteron/jdocsis/parser

ANTLR = java org.antlr.Tool
ANTLRFLAGS = -o $(PARSERDIR)

JCC = javac
JFLAGS = -d $(DESTCLASS)
## FOR DEBUGGING PURPOSES ONLY
# JFLAGS = -d $(DESTCLASS) -g


default: \
        $(DESTPARSERCLASSDIR)/DocsisLexer.class \
        $(DESTPARSERCLASSDIR)/DocsisParser.class \
        $(DESTEXCEPTIONCLASSDIR)/BadFormatArgumentException.class \
        $(DESTEXCEPTIONCLASSDIR)/OutOfRangeTLVValueException.class \
        $(DESTCOMMONCLASSDIR)/TLVClassLoader.class \
        $(DESTTLVCLASSDIR)/TLV.class \
        $(DESTTLVCLASSDIR)/TLVaggregate.class \
        $(DESTTLVCLASSDIR)/TLVscalar.class \
        $(DESTTLVCLASSDIR)/TLVuchar.class \
        $(DESTTLVCLASSDIR)/TLVushort.class \
        $(DESTTLVCLASSDIR)/TLVuint.class \
        $(DESTTLVCLASSDIR)/TLVethernet.class \
        $(DESTTLVCLASSDIR)/TLVethermask.class \
        $(DESTTLVCLASSDIR)/TLVipv4.class \
        $(DESTTLVCLASSDIR)/TLVipv6.class \
        $(DESTTLVCLASSDIR)/TLVhexstr.class \
        $(DESTTLVCLASSDIR)/TLVstring.class \
        $(DESTTLVCLASSDIR)/TLVstrzero.class \
        $(DESTTLVCLASSDIR)/TLV_ActivationState.class \
        $(DESTTLVCLASSDIR)/TLV_ActQosParamsTimeout.class \
        $(DESTTLVCLASSDIR)/TLV_AdmQosParamsTimeout.class \
        $(DESTTLVCLASSDIR)/TLV_AuthGraceTime.class \
        $(DESTTLVCLASSDIR)/TLV_AuthRejectTimeout.class \
        $(DESTTLVCLASSDIR)/TLV_AuthTimeout.class \
        $(DESTTLVCLASSDIR)/TLV_BaselinePrivacy.class \
        $(DESTTLVCLASSDIR)/TLV_BaselinePrivacySupport.class \
        $(DESTTLVCLASSDIR)/TLV_ClassID.class \
        $(DESTTLVCLASSDIR)/TLV_ClassifierId.class \
        $(DESTTLVCLASSDIR)/TLV_ClassifierRef.class \
        $(DESTTLVCLASSDIR)/TLV_ClassOfService.class \
        $(DESTTLVCLASSDIR)/TLV_CMMIC.class \
        $(DESTTLVCLASSDIR)/TLV_CMTSMIC.class \
        $(DESTTLVCLASSDIR)/TLV_ConcatenationSupport.class \
        $(DESTTLVCLASSDIR)/TLV_CoSignerCVCData.class \
        $(DESTTLVCLASSDIR)/TLV_CpeMacAddress.class \
        $(DESTTLVCLASSDIR)/TLV_DCCSupport.class \
        $(DESTTLVCLASSDIR)/TLV_DocsisTwoEnable.class \
        $(DESTTLVCLASSDIR)/TLV_DownstreamFrequency.class \
        $(DESTTLVCLASSDIR)/TLV_DownstreamSAIDSupport.class \
        $(DESTTLVCLASSDIR)/TLV_DscAction.class \
        $(DESTTLVCLASSDIR)/TLV_DsChannelList.class \
        $(DESTTLVCLASSDIR)/TLV_DsPacketClass.class \
        $(DESTTLVCLASSDIR)/TLV_DsServiceFlow.class \
        $(DESTTLVCLASSDIR)/TLV_DstMacAddress.class \
        $(DESTTLVCLASSDIR)/TLV_DstPortEnd.class \
        $(DESTTLVCLASSDIR)/TLV_DstPortStart.class \
        $(DESTTLVCLASSDIR)/TLV_EndOfDataMkr.class \
        $(DESTTLVCLASSDIR)/TLV_EtherType.class \
        $(DESTTLVCLASSDIR)/TLV_FragmentationSupport.class \
        $(DESTTLVCLASSDIR)/TLV_GenericTLV.class \
        $(DESTTLVCLASSDIR)/TLV_GlobalPrivacyEnable.class \
        $(DESTTLVCLASSDIR)/TLV_GrantsPerInterval.class \
        $(DESTTLVCLASSDIR)/TLV_GuaranteedUp.class \
        $(DESTTLVCLASSDIR)/TLV_IEEE802Classifier.class \
        $(DESTTLVCLASSDIR)/TLV_IGMPSupport.class \
        $(DESTTLVCLASSDIR)/TLV_IpDstAddr.class \
        $(DESTTLVCLASSDIR)/TLV_IpDstMask.class \
        $(DESTTLVCLASSDIR)/TLV_IpPacketClassifier.class \
        $(DESTTLVCLASSDIR)/TLV_IpProto.class \
        $(DESTTLVCLASSDIR)/TLV_IpSrcAddr.class \
        $(DESTTLVCLASSDIR)/TLV_IpSrcMask.class \
        $(DESTTLVCLASSDIR)/TLV_IpTos.class \
        $(DESTTLVCLASSDIR)/TLV_IpTosOverwrite.class \
        $(DESTTLVCLASSDIR)/TLV_IPv6DstAddr.class \
        $(DESTTLVCLASSDIR)/TLV_IPv6DstPrefLength.class \
        $(DESTTLVCLASSDIR)/TLV_IPv6FlowLabel.class \
        $(DESTTLVCLASSDIR)/TLV_IPv6NextHeaderType.class \
        $(DESTTLVCLASSDIR)/TLV_IPv6PacketClassifier.class \
        $(DESTTLVCLASSDIR)/TLV_IPv6SrcAddr.class \
        $(DESTTLVCLASSDIR)/TLV_IPv6SrcPrefLength.class \
        $(DESTTLVCLASSDIR)/TLV_IPv6SwUpgradeServer.class \
        $(DESTTLVCLASSDIR)/TLV_IPv6TrafficClassRangeMask.class \
        $(DESTTLVCLASSDIR)/TLV_LLCPacketClassifier.class \
        $(DESTTLVCLASSDIR)/TLV_MaxBurstUp.class \
        $(DESTTLVCLASSDIR)/TLV_MaxClassifiers.class \
        $(DESTTLVCLASSDIR)/TLV_MaxConcatenatedBurst.class \
        $(DESTTLVCLASSDIR)/TLV_MaxCPE.class \
        $(DESTTLVCLASSDIR)/TLV_MaxDsLatency.class \
        $(DESTTLVCLASSDIR)/TLV_MaxRateDown.class \
        $(DESTTLVCLASSDIR)/TLV_MaxRateSustained.class \
        $(DESTTLVCLASSDIR)/TLV_MaxRateUp.class \
        $(DESTTLVCLASSDIR)/TLV_MaxTrafficBurst.class \
        $(DESTTLVCLASSDIR)/TLV_MfgCVCData.class \
        $(DESTTLVCLASSDIR)/TLV_MinReservedRate.class \
        $(DESTTLVCLASSDIR)/TLV_MinResPacketSize.class \
        $(DESTTLVCLASSDIR)/TLV_ModemCapabilities.class \
        $(DESTTLVCLASSDIR)/TLV_ModemDocsisVersion.class \
        $(DESTTLVCLASSDIR)/TLV_MtaConfigDelimiter.class \
        $(DESTTLVCLASSDIR)/TLV_NetworkAccess.class \
        $(DESTTLVCLASSDIR)/TLV_NominalGrantInterval.class \
        $(DESTTLVCLASSDIR)/TLV_NominalPollInterval.class \
        $(DESTTLVCLASSDIR)/TLV_OperTimeout.class \
        $(DESTTLVCLASSDIR)/TLV_PHS.class \
        $(DESTTLVCLASSDIR)/TLV_PHSClassifierId.class \
        $(DESTTLVCLASSDIR)/TLV_PHSClassifierRef.class \
        $(DESTTLVCLASSDIR)/TLV_PHSField.class \
        $(DESTTLVCLASSDIR)/TLV_PHSIndex.class \
        $(DESTTLVCLASSDIR)/TLV_PHSMask.class \
        $(DESTTLVCLASSDIR)/TLV_PHSServiceFlowId.class \
        $(DESTTLVCLASSDIR)/TLV_PHSServiceFlowRef.class \
        $(DESTTLVCLASSDIR)/TLV_PHSSize.class \
        $(DESTTLVCLASSDIR)/TLV_PHSSupport.class \
        $(DESTTLVCLASSDIR)/TLV_PHSVerify.class \
        $(DESTTLVCLASSDIR)/TLV_PriorityUp.class \
        $(DESTTLVCLASSDIR)/TLV_PrivacyEnable.class \
        $(DESTTLVCLASSDIR)/TLV_QosParamSetType.class \
        $(DESTTLVCLASSDIR)/TLV_ReAuthTimeout.class \
        $(DESTTLVCLASSDIR)/TLV_ReKeyTimeout.class \
        $(DESTTLVCLASSDIR)/TLV_RequestOrTxPolicy.class \
        $(DESTTLVCLASSDIR)/TLV_RulePriority.class \
        $(DESTTLVCLASSDIR)/TLV_SAMapMaxRetries.class \
        $(DESTTLVCLASSDIR)/TLV_SAMapWaitTimeout.class \
        $(DESTTLVCLASSDIR)/TLV_SchedulingType.class \
        $(DESTTLVCLASSDIR)/TLV_ServiceClassName.class \
        $(DESTTLVCLASSDIR)/TLV_ServiceFlowId.class \
        $(DESTTLVCLASSDIR)/TLV_ServiceFlowRef.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpMibObject.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpV3MgrPublicNumber.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpV3Kickstart.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpV3SecurityName.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpV3TrapReceiver.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxIP.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxIPv6.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxPort.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxRetries.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxSecurityName.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxTimeout.class \
        $(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxType.class \
        $(DESTTLVCLASSDIR)/TLV_SrcMacAddress.class \
        $(DESTTLVCLASSDIR)/TLV_SrcPortEnd.class \
        $(DESTTLVCLASSDIR)/TLV_SrcPortStart.class \
        $(DESTTLVCLASSDIR)/TLV_SubMgmtControl.class \
        $(DESTTLVCLASSDIR)/TLV_SwUpgradeFilename.class \
        $(DESTTLVCLASSDIR)/TLV_SwUpgradeServer.class \
        $(DESTTLVCLASSDIR)/TLV_TEKGraceTime.class \
        $(DESTTLVCLASSDIR)/TLV_TestModeEnable.class \
        $(DESTTLVCLASSDIR)/TLV_TftpModemAddress.class \
        $(DESTTLVCLASSDIR)/TLV_TftpTimestamp.class \
        $(DESTTLVCLASSDIR)/TLV_ToleratedGrantJitter.class \
        $(DESTTLVCLASSDIR)/TLV_ToleratedPollJitter.class \
        $(DESTTLVCLASSDIR)/TLV_TrafficPriority.class \
        $(DESTTLVCLASSDIR)/TLV_UnsolicitedGrantSize.class \
        $(DESTTLVCLASSDIR)/TLV_UpstreamChannelId.class \
        $(DESTTLVCLASSDIR)/TLV_UpstreamSIDSupport.class \
        $(DESTTLVCLASSDIR)/TLV_UserPriority.class \
        $(DESTTLVCLASSDIR)/TLV_UsPacketClass.class \
        $(DESTTLVCLASSDIR)/TLV_UsServiceFlow.class \
        $(DESTTLVCLASSDIR)/TLV_VendorIdentifier.class \
        $(DESTTLVCLASSDIR)/TLV_VendorSpecific.class \
        $(DESTTLVCLASSDIR)/TLV_VlanID.class \
        $(DESTENCODERCLASSDIR)/Lexer2TLVMapper.class \
        $(DESTENCODERCLASSDIR)/Encoder.class

ch/gauteron/jdocsis/parser/DocsisLexer.java: ch/gauteron/jdocsis/parser/DocsisLexer.g
	$(ANTLR) $(ANTLRFLAGS) ch/gauteron/jdocsis/parser/DocsisLexer.g
		
$(DESTPARSERCLASSDIR)/DocsisLexer.class: ch/gauteron/jdocsis/parser/DocsisLexer.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/parser/DocsisLexer.java

ch/gauteron/jdocsis/parser/DocsisParser.java: ch/gauteron/jdocsis/parser/DocsisParser.g
	$(ANTLR) $(ANTLRFLAGS) ch/gauteron/jdocsis/parser/DocsisParser.g

$(DESTPARSERCLASSDIR)/DocsisParser.class: ch/gauteron/jdocsis/parser/DocsisParser.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/parser/DocsisParser.java

$(DESTEXCEPTIONCLASSDIR)/BadFormatArgumentException.class: ch/gauteron/jdocsis/exceptions/BadFormatArgumentException.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/exceptions/BadFormatArgumentException.java

$(DESTEXCEPTIONCLASSDIR)/OutOfRangeTLVValueException.class: ch/gauteron/jdocsis/exceptions/OutOfRangeTLVValueException.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/exceptions/OutOfRangeTLVValueException.java

$(DESTCOMMONCLASSDIR)/TLVClassLoader.class: ch/gauteron/jdocsis/common/TLVClassLoader.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/common/TLVClassLoader.java
	
$(DESTTLVCLASSDIR)/TLV.class: ch/gauteron/jdocsis/TLVs/TLV.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV.java

$(DESTTLVCLASSDIR)/TLVaggregate.class: ch/gauteron/jdocsis/TLVs/TLVaggregate.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVaggregate.java

$(DESTTLVCLASSDIR)/TLVscalar.class: ch/gauteron/jdocsis/TLVs/TLVscalar.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVscalar.java

$(DESTTLVCLASSDIR)/TLVuchar.class: ch/gauteron/jdocsis/TLVs/TLVushort.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVushort.java

$(DESTTLVCLASSDIR)/TLVushort.class: ch/gauteron/jdocsis/TLVs/TLVuchar.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVuchar.java

$(DESTTLVCLASSDIR)/TLVuint.class: ch/gauteron/jdocsis/TLVs/TLVuint.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVuint.java

$(DESTTLVCLASSDIR)/TLVethernet.class: ch/gauteron/jdocsis/TLVs/TLVethernet.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVethernet.java
	
$(DESTTLVCLASSDIR)/TLVethermask.class: ch/gauteron/jdocsis/TLVs/TLVethermask.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVethermask.java

$(DESTTLVCLASSDIR)/TLVipv4.class: ch/gauteron/jdocsis/TLVs/TLVipv4.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVipv4.java

$(DESTTLVCLASSDIR)/TLVipv6.class: ch/gauteron/jdocsis/TLVs/TLVipv6.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVipv6.java

$(DESTTLVCLASSDIR)/TLVhexstr.class: ch/gauteron/jdocsis/TLVs/TLVhexstr.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVhexstr.java
	
$(DESTTLVCLASSDIR)/TLVstring.class: ch/gauteron/jdocsis/TLVs/TLVstring.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVstring.java
	
$(DESTTLVCLASSDIR)/TLVstrzero.class: ch/gauteron/jdocsis/TLVs/TLVstrzero.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVstrzero.java

$(DESTTLVCLASSDIR)/TLV_ActivationState.class: ch/gauteron/jdocsis/TLVs/TLV_ActivationState.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ActivationState.java

$(DESTTLVCLASSDIR)/TLV_ActQosParamsTimeout.class: ch/gauteron/jdocsis/TLVs/TLV_ActQosParamsTimeout.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ActQosParamsTimeout.java

$(DESTTLVCLASSDIR)/TLV_AdmQosParamsTimeout.class: ch/gauteron/jdocsis/TLVs/TLV_AdmQosParamsTimeout.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_AdmQosParamsTimeout.java

$(DESTTLVCLASSDIR)/TLV_AuthGraceTime.class: ch/gauteron/jdocsis/TLVs/TLV_AuthGraceTime.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_AuthGraceTime.java

$(DESTTLVCLASSDIR)/TLV_AuthRejectTimeout.class: ch/gauteron/jdocsis/TLVs/TLV_AuthRejectTimeout.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_AuthRejectTimeout.java

$(DESTTLVCLASSDIR)/TLV_AuthTimeout.class: ch/gauteron/jdocsis/TLVs/TLV_AuthTimeout.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_AuthTimeout.java

$(DESTTLVCLASSDIR)/TLV_BaselinePrivacy.class: ch/gauteron/jdocsis/TLVs/TLV_BaselinePrivacy.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_BaselinePrivacy.java

$(DESTTLVCLASSDIR)/TLV_BaselinePrivacySupport.class: ch/gauteron/jdocsis/TLVs/TLV_BaselinePrivacySupport.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_BaselinePrivacySupport.java

$(DESTTLVCLASSDIR)/TLV_ClassID.class: ch/gauteron/jdocsis/TLVs/TLV_ClassID.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ClassID.java

$(DESTTLVCLASSDIR)/TLV_ClassifierId.class: ch/gauteron/jdocsis/TLVs/TLV_ClassifierId.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ClassifierId.java

$(DESTTLVCLASSDIR)/TLV_ClassifierRef.class: ch/gauteron/jdocsis/TLVs/TLV_ClassifierRef.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ClassifierRef.java

$(DESTTLVCLASSDIR)/TLV_ClassOfService.class: ch/gauteron/jdocsis/TLVs/TLV_ClassOfService.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ClassOfService.java

$(DESTTLVCLASSDIR)/TLV_CMMIC.class: ch/gauteron/jdocsis/TLVs/TLV_CMMIC.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_CMMIC.java

$(DESTTLVCLASSDIR)/TLV_CMTSMIC.class: ch/gauteron/jdocsis/TLVs/TLV_CMTSMIC.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_CMTSMIC.java

$(DESTTLVCLASSDIR)/TLV_ConcatenationSupport.class: ch/gauteron/jdocsis/TLVs/TLV_ConcatenationSupport.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ConcatenationSupport.java

$(DESTTLVCLASSDIR)/TLV_CoSignerCVCData.class: ch/gauteron/jdocsis/TLVs/TLV_CoSignerCVCData.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_CoSignerCVCData.java	

$(DESTTLVCLASSDIR)/TLV_CpeMacAddress.class: ch/gauteron/jdocsis/TLVs/TLV_CpeMacAddress.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_CpeMacAddress.java

$(DESTTLVCLASSDIR)/TLV_DCCSupport.class: ch/gauteron/jdocsis/TLVs/TLV_DCCSupport.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_DCCSupport.java

$(DESTTLVCLASSDIR)/TLV_DocsisTwoEnable.class: ch/gauteron/jdocsis/TLVs/TLV_DocsisTwoEnable.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_DocsisTwoEnable.java

$(DESTTLVCLASSDIR)/TLV_DownstreamFrequency.class: ch/gauteron/jdocsis/TLVs/TLV_DownstreamFrequency.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_DownstreamFrequency.java

$(DESTTLVCLASSDIR)/TLV_DownstreamSAIDSupport.class: ch/gauteron/jdocsis/TLVs/TLV_DownstreamSAIDSupport.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_DownstreamSAIDSupport.java

$(DESTTLVCLASSDIR)/TLV_DscAction.class: ch/gauteron/jdocsis/TLVs/TLV_DscAction.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_DscAction.java

$(DESTTLVCLASSDIR)/TLV_DsChannelList.class: ch/gauteron/jdocsis/TLVs/TLV_DsChannelList.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_DsChannelList.java

$(DESTTLVCLASSDIR)/TLV_DsPacketClass.class: ch/gauteron/jdocsis/TLVs/TLV_DsPacketClass.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_DsPacketClass.java

$(DESTTLVCLASSDIR)/TLV_DsServiceFlow.class: ch/gauteron/jdocsis/TLVs/TLV_DsServiceFlow.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_DsServiceFlow.java

$(DESTTLVCLASSDIR)/TLV_DstMacAddress.class: ch/gauteron/jdocsis/TLVs/TLV_DstMacAddress.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_DstMacAddress.java

$(DESTTLVCLASSDIR)/TLV_DstPortEnd.class: ch/gauteron/jdocsis/TLVs/TLV_DstPortEnd.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_DstPortEnd.java

$(DESTTLVCLASSDIR)/TLV_DstPortStart.class: ch/gauteron/jdocsis/TLVs/TLV_DstPortStart.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_DstPortStart.java

$(DESTTLVCLASSDIR)/TLV_EndOfDataMkr.class: ch/gauteron/jdocsis/TLVs/TLV_EndOfDataMkr.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_EndOfDataMkr.java

$(DESTTLVCLASSDIR)/TLV_EtherType.class: ch/gauteron/jdocsis/TLVs/TLV_EtherType.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_EtherType.java

$(DESTTLVCLASSDIR)/TLV_FragmentationSupport.class: ch/gauteron/jdocsis/TLVs/TLV_FragmentationSupport.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_FragmentationSupport.java

$(DESTTLVCLASSDIR)/TLV_GenericTLV.class: ch/gauteron/jdocsis/TLVs/TLV_GenericTLV.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_GenericTLV.java

$(DESTTLVCLASSDIR)/TLV_GlobalPrivacyEnable.class: ch/gauteron/jdocsis/TLVs/TLV_GlobalPrivacyEnable.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_GlobalPrivacyEnable.java

$(DESTTLVCLASSDIR)/TLV_GrantsPerInterval.class: ch/gauteron/jdocsis/TLVs/TLV_GrantsPerInterval.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_GrantsPerInterval.java

$(DESTTLVCLASSDIR)/TLV_GuaranteedUp.class: ch/gauteron/jdocsis/TLVs/TLV_GuaranteedUp.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_GuaranteedUp.java

$(DESTTLVCLASSDIR)/TLV_IEEE802Classifier.class: ch/gauteron/jdocsis/TLVs/TLV_IEEE802Classifier.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IEEE802Classifier.java

$(DESTTLVCLASSDIR)/TLV_IGMPSupport.class: ch/gauteron/jdocsis/TLVs/TLV_IGMPSupport.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IGMPSupport.java

$(DESTTLVCLASSDIR)/TLV_IpDstAddr.class: ch/gauteron/jdocsis/TLVs/TLV_IpDstAddr.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IpDstAddr.java

$(DESTTLVCLASSDIR)/TLV_IpDstMask.class: ch/gauteron/jdocsis/TLVs/TLV_IpDstMask.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IpDstMask.java

$(DESTTLVCLASSDIR)/TLV_IpPacketClassifier.class: ch/gauteron/jdocsis/TLVs/TLV_IpPacketClassifier.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IpPacketClassifier.java
	
$(DESTTLVCLASSDIR)/TLV_IpProto.class: ch/gauteron/jdocsis/TLVs/TLV_IpProto.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IpProto.java

$(DESTTLVCLASSDIR)/TLV_IpSrcAddr.class: ch/gauteron/jdocsis/TLVs/TLV_IpSrcAddr.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IpSrcAddr.java

$(DESTTLVCLASSDIR)/TLV_IpSrcMask.class: ch/gauteron/jdocsis/TLVs/TLV_IpSrcMask.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IpSrcMask.java

$(DESTTLVCLASSDIR)/TLV_IpTos.class: ch/gauteron/jdocsis/TLVs/TLV_IpTos.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IpTos.java

$(DESTTLVCLASSDIR)/TLV_IpTosOverwrite.class: ch/gauteron/jdocsis/TLVs/TLV_IpTosOverwrite.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IpTosOverwrite.java

$(DESTTLVCLASSDIR)/TLV_IPv6DstAddr.class: ch/gauteron/jdocsis/TLVs/TLV_IPv6DstAddr.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IPv6DstAddr.java

$(DESTTLVCLASSDIR)/TLV_IPv6DstPrefLength.class: ch/gauteron/jdocsis/TLVs/TLV_IPv6DstPrefLength.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IPv6DstPrefLength.java

$(DESTTLVCLASSDIR)/TLV_IPv6FlowLabel.class: ch/gauteron/jdocsis/TLVs/TLV_IPv6FlowLabel.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IPv6FlowLabel.java

$(DESTTLVCLASSDIR)/TLV_IPv6NextHeaderType.class: ch/gauteron/jdocsis/TLVs/TLV_IPv6NextHeaderType.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IPv6NextHeaderType.java

$(DESTTLVCLASSDIR)/TLV_IPv6PacketClassifier.class: ch/gauteron/jdocsis/TLVs/TLV_IPv6PacketClassifier.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IPv6PacketClassifier.java

$(DESTTLVCLASSDIR)/TLV_IPv6SrcAddr.class: ch/gauteron/jdocsis/TLVs/TLV_IPv6SrcAddr.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IPv6SrcAddr.java
	
$(DESTTLVCLASSDIR)/TLV_IPv6SrcPrefLength.class: ch/gauteron/jdocsis/TLVs/TLV_IPv6SrcPrefLength.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IPv6SrcPrefLength.java

$(DESTTLVCLASSDIR)/TLV_IPv6SwUpgradeServer.class: ch/gauteron/jdocsis/TLVs/TLV_IPv6SwUpgradeServer.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IPv6SwUpgradeServer.java

$(DESTTLVCLASSDIR)/TLV_IPv6TrafficClassRangeMask.class: ch/gauteron/jdocsis/TLVs/TLV_IPv6TrafficClassRangeMask.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_IPv6TrafficClassRangeMask.java

$(DESTTLVCLASSDIR)/TLV_LLCPacketClassifier.class: ch/gauteron/jdocsis/TLVs/TLV_LLCPacketClassifier.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_LLCPacketClassifier.java

$(DESTTLVCLASSDIR)/TLV_MaxBurstUp.class: ch/gauteron/jdocsis/TLVs/TLV_MaxBurstUp.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MaxBurstUp.java

$(DESTTLVCLASSDIR)/TLV_MaxClassifiers.class: ch/gauteron/jdocsis/TLVs/TLV_MaxClassifiers.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MaxClassifiers.java

$(DESTTLVCLASSDIR)/TLV_MaxConcatenatedBurst.class: ch/gauteron/jdocsis/TLVs/TLV_MaxConcatenatedBurst.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MaxConcatenatedBurst.java

$(DESTTLVCLASSDIR)/TLV_MaxCPE.class: ch/gauteron/jdocsis/TLVs/TLV_MaxCPE.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MaxCPE.java

$(DESTTLVCLASSDIR)/TLV_MaxDsLatency.class: ch/gauteron/jdocsis/TLVs/TLV_MaxDsLatency.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MaxDsLatency.java

$(DESTTLVCLASSDIR)/TLV_MaxRateDown.class: ch/gauteron/jdocsis/TLVs/TLV_MaxRateDown.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MaxRateDown.java

$(DESTTLVCLASSDIR)/TLV_MaxRateSustained.class: ch/gauteron/jdocsis/TLVs/TLV_MaxRateSustained.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MaxRateSustained.java

$(DESTTLVCLASSDIR)/TLV_MaxRateUp.class: ch/gauteron/jdocsis/TLVs/TLV_MaxRateUp.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MaxRateUp.java

$(DESTTLVCLASSDIR)/TLV_MaxTrafficBurst.class: ch/gauteron/jdocsis/TLVs/TLV_MaxTrafficBurst.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MaxTrafficBurst.java

$(DESTTLVCLASSDIR)/TLV_MfgCVCData.class: ch/gauteron/jdocsis/TLVs/TLV_MfgCVCData.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MfgCVCData.java

$(DESTTLVCLASSDIR)/TLV_MinReservedRate.class: ch/gauteron/jdocsis/TLVs/TLV_MinReservedRate.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MinReservedRate.java

$(DESTTLVCLASSDIR)/TLV_MinResPacketSize.class: ch/gauteron/jdocsis/TLVs/TLV_MinResPacketSize.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MinResPacketSize.java

$(DESTTLVCLASSDIR)/TLV_ModemCapabilities.class: ch/gauteron/jdocsis/TLVs/TLV_ModemCapabilities.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ModemCapabilities.java

$(DESTTLVCLASSDIR)/TLV_ModemDocsisVersion.class: ch/gauteron/jdocsis/TLVs/TLV_ModemDocsisVersion.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ModemDocsisVersion.java

$(DESTTLVCLASSDIR)/TLV_MtaConfigDelimiter.class: ch/gauteron/jdocsis/TLVs/TLV_MtaConfigDelimiter.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_MtaConfigDelimiter.java

$(DESTTLVCLASSDIR)/TLV_NetworkAccess.class: ch/gauteron/jdocsis/TLVs/TLV_NetworkAccess.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_NetworkAccess.java

$(DESTTLVCLASSDIR)/TLV_NominalGrantInterval.class: ch/gauteron/jdocsis/TLVs/TLV_NominalGrantInterval.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_NominalGrantInterval.java

$(DESTTLVCLASSDIR)/TLV_NominalPollInterval.class: ch/gauteron/jdocsis/TLVs/TLV_NominalPollInterval.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_NominalPollInterval.java

$(DESTTLVCLASSDIR)/TLV_OperTimeout.class: ch/gauteron/jdocsis/TLVs/TLV_OperTimeout.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_OperTimeout.java

$(DESTTLVCLASSDIR)/TLV_PHS.class: ch/gauteron/jdocsis/TLVs/TLV_PHS.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PHS.java


$(DESTTLVCLASSDIR)/TLV_PHSClassifierId.class: ch/gauteron/jdocsis/TLVs/TLV_PHSClassifierId.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PHSClassifierId.java

$(DESTTLVCLASSDIR)/TLV_PHSClassifierRef.class: ch/gauteron/jdocsis/TLVs/TLV_PHSClassifierRef.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PHSClassifierRef.java

$(DESTTLVCLASSDIR)/TLV_PHSField.class: ch/gauteron/jdocsis/TLVs/TLV_PHSField.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PHSField.java
	
$(DESTTLVCLASSDIR)/TLV_PHSIndex.class: ch/gauteron/jdocsis/TLVs/TLV_PHSIndex.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PHSIndex.java

$(DESTTLVCLASSDIR)/TLV_PHSMask.class: ch/gauteron/jdocsis/TLVs/TLV_PHSMask.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PHSMask.java

$(DESTTLVCLASSDIR)/TLV_PHSServiceFlowId.class: ch/gauteron/jdocsis/TLVs/TLV_PHSServiceFlowId.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PHSServiceFlowId.java

$(DESTTLVCLASSDIR)/TLV_PHSServiceFlowRef.class: ch/gauteron/jdocsis/TLVs/TLV_PHSServiceFlowRef.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PHSServiceFlowRef.java
	
$(DESTTLVCLASSDIR)/TLV_PHSSize.class: ch/gauteron/jdocsis/TLVs/TLV_PHSSize.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PHSSize.java

$(DESTTLVCLASSDIR)/TLV_PHSSupport.class: ch/gauteron/jdocsis/TLVs/TLV_PHSSupport.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PHSSupport.java

$(DESTTLVCLASSDIR)/TLV_PHSVerify.class: ch/gauteron/jdocsis/TLVs/TLV_PHSVerify.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PHSVerify.java

$(DESTTLVCLASSDIR)/TLV_PriorityUp.class: ch/gauteron/jdocsis/TLVs/TLV_PriorityUp.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PriorityUp.java

$(DESTTLVCLASSDIR)/TLV_PrivacyEnable.class: ch/gauteron/jdocsis/TLVs/TLV_PrivacyEnable.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_PrivacyEnable.java

$(DESTTLVCLASSDIR)/TLV_QosParamSetType.class: ch/gauteron/jdocsis/TLVs/TLV_QosParamSetType.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_QosParamSetType.java
	
$(DESTTLVCLASSDIR)/TLV_ReAuthTimeout.class: ch/gauteron/jdocsis/TLVs/TLV_ReAuthTimeout.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ReAuthTimeout.java
	
$(DESTTLVCLASSDIR)/TLV_ReKeyTimeout.class: ch/gauteron/jdocsis/TLVs/TLV_ReKeyTimeout.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ReKeyTimeout.java
	
$(DESTTLVCLASSDIR)/TLV_RequestOrTxPolicy.class: ch/gauteron/jdocsis/TLVs/TLV_RequestOrTxPolicy.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_RequestOrTxPolicy.java
	
$(DESTTLVCLASSDIR)/TLV_RulePriority.class: ch/gauteron/jdocsis/TLVs/TLV_RulePriority.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_RulePriority.java

$(DESTTLVCLASSDIR)/TLV_SAMapMaxRetries.class: ch/gauteron/jdocsis/TLVs/TLV_SAMapMaxRetries.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SAMapMaxRetries.java

$(DESTTLVCLASSDIR)/TLV_SAMapWaitTimeout.class: ch/gauteron/jdocsis/TLVs/TLV_SAMapWaitTimeout.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SAMapWaitTimeout.java

$(DESTTLVCLASSDIR)/TLV_SchedulingType.class: ch/gauteron/jdocsis/TLVs/TLV_SchedulingType.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SchedulingType.java

$(DESTTLVCLASSDIR)/TLV_ServiceClassName.class: ch/gauteron/jdocsis/TLVs/TLV_ServiceClassName.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ServiceClassName.java

$(DESTTLVCLASSDIR)/TLV_ServiceFlowId.class: ch/gauteron/jdocsis/TLVs/TLV_ServiceFlowId.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ServiceFlowId.java

$(DESTTLVCLASSDIR)/TLV_ServiceFlowRef.class: ch/gauteron/jdocsis/TLVs/TLV_ServiceFlowRef.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ServiceFlowRef.java

$(DESTTLVCLASSDIR)/TLV_SnmpMibObject.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpMibObject.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpMibObject.java

$(DESTTLVCLASSDIR)/TLV_SnmpV3MgrPublicNumber.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpV3MgrPublicNumber.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpV3MgrPublicNumber.java

$(DESTTLVCLASSDIR)/TLV_SnmpV3Kickstart.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpV3Kickstart.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpV3Kickstart.java
	
$(DESTTLVCLASSDIR)/TLV_SnmpV3SecurityName.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpV3SecurityName.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpV3SecurityName.java

$(DESTTLVCLASSDIR)/TLV_SnmpV3TrapReceiver.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapReceiver.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapReceiver.java
	
$(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxIP.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxIP.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxIP.java

$(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxIPv6.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxIPv6.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxIPv6.java

$(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxPort.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxPort.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxPort.java

$(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxRetries.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxRetries.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxRetries.java

$(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxSecurityName.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxSecurityName.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxSecurityName.java

$(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxTimeout.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxTimeout.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxTimeout.java
	
$(DESTTLVCLASSDIR)/TLV_SnmpV3TrapRxType.class: ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxType.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SnmpV3TrapRxType.java

$(DESTTLVCLASSDIR)/TLV_SrcMacAddress.class: ch/gauteron/jdocsis/TLVs/TLV_SrcMacAddress.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SrcMacAddress.java

$(DESTTLVCLASSDIR)/TLV_SrcPortEnd.class: ch/gauteron/jdocsis/TLVs/TLV_SrcPortEnd.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SrcPortEnd.java

$(DESTTLVCLASSDIR)/TLV_SrcPortStart.class: ch/gauteron/jdocsis/TLVs/TLV_SrcPortStart.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SrcPortStart.java

$(DESTTLVCLASSDIR)/TLV_SubMgmtControl.class: ch/gauteron/jdocsis/TLVs/TLV_SubMgmtControl.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SubMgmtControl.java

$(DESTTLVCLASSDIR)/TLV_SwUpgradeFilename.class: ch/gauteron/jdocsis/TLVs/TLV_SwUpgradeFilename.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SwUpgradeFilename.java

$(DESTTLVCLASSDIR)/TLV_SwUpgradeServer.class: ch/gauteron/jdocsis/TLVs/TLV_SwUpgradeServer.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_SwUpgradeServer.java

$(DESTTLVCLASSDIR)/TLV_TEKGraceTime.class: ch/gauteron/jdocsis/TLVs/TLV_TEKGraceTime.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_TEKGraceTime.java
	
$(DESTTLVCLASSDIR)/TLV_TestModeEnable.class: ch/gauteron/jdocsis/TLVs/TLV_TestModeEnable.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_TestModeEnable.java

$(DESTTLVCLASSDIR)/TLV_TftpModemAddress.class: ch/gauteron/jdocsis/TLVs/TLV_TftpModemAddress.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_TftpModemAddress.java

$(DESTTLVCLASSDIR)/TLV_TftpTimestamp.class: ch/gauteron/jdocsis/TLVs/TLV_TftpTimestamp.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_TftpTimestamp.java

$(DESTTLVCLASSDIR)/TLV_ToleratedGrantJitter.class: ch/gauteron/jdocsis/TLVs/TLV_ToleratedGrantJitter.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ToleratedGrantJitter.java

$(DESTTLVCLASSDIR)/TLV_ToleratedPollJitter.class: ch/gauteron/jdocsis/TLVs/TLV_ToleratedPollJitter.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_ToleratedPollJitter.java

$(DESTTLVCLASSDIR)/TLV_TrafficPriority.class: ch/gauteron/jdocsis/TLVs/TLV_TrafficPriority.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_TrafficPriority.java

$(DESTTLVCLASSDIR)/TLV_UnsolicitedGrantSize.class: ch/gauteron/jdocsis/TLVs/TLV_UnsolicitedGrantSize.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_UnsolicitedGrantSize.java

$(DESTTLVCLASSDIR)/TLV_UpstreamChannelId.class: ch/gauteron/jdocsis/TLVs/TLV_UpstreamChannelId.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_UpstreamChannelId.java

$(DESTTLVCLASSDIR)/TLV_UpstreamSIDSupport.class: ch/gauteron/jdocsis/TLVs/TLV_UpstreamSIDSupport.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_UpstreamSIDSupport.java

$(DESTTLVCLASSDIR)/TLV_UserPriority.class: ch/gauteron/jdocsis/TLVs/TLV_UserPriority.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_UserPriority.java

$(DESTTLVCLASSDIR)/TLV_UsPacketClass.class: ch/gauteron/jdocsis/TLVs/TLV_UsPacketClass.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_UsPacketClass.java

$(DESTTLVCLASSDIR)/TLV_UsServiceFlow.class: ch/gauteron/jdocsis/TLVs/TLV_UsServiceFlow.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_UsServiceFlow.java

$(DESTTLVCLASSDIR)/TLV_VendorIdentifier.class: ch/gauteron/jdocsis/TLVs/TLV_VendorIdentifier.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_VendorIdentifier.java

$(DESTTLVCLASSDIR)/TLV_VendorSpecific.class: ch/gauteron/jdocsis/TLVs/TLV_VendorSpecific.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_VendorSpecific.java

$(DESTTLVCLASSDIR)/TLV_VlanID.class: ch/gauteron/jdocsis/TLVs/TLV_VlanID.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_VlanID.java



$(DESTENCODERCLASSDIR)/Lexer2TLVMapper.class: ch/gauteron/jdocsis/encoder/Lexer2TLVMapper.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/encoder/Lexer2TLVMapper.java	


$(DESTENCODERCLASSDIR)/Encoder.class: ch/gauteron/jdocsis/encoder/Encoder.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/encoder/Encoder.java	


clean: 
	$(RM) *.class


