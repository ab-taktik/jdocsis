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
PARSERDIR = ch/gauteron/jdocsis/parser

ANTLR = java org.antlr.Tool
ANTLRFLAGS = -o $(PARSERDIR)

JCC = javac
JFLAGS = -d $(DESTCLASS)
## FOR DEBUGGING PURPOSES ONLY
# JFLAGS = -d $(DESTCLASS) -g


default: \
        DocsisLexer.class \
        DocsisParser.class \
        BadFormatArgumentException.class \
        OutOfRangeTLVValueException.class \
        TLVClassLoader.class \
        TLV.class \
        TLVaggregate.class \
        TLVscalar.class \
        TLVuchar.class \
        TLVushort.class \
        TLVuint.class \
        TLVethernet.class \
        TLVethermask.class \
        TLVhexstr.class \
        TLVstring.class \
        TLVstrzero.class \
        TLV_EndOfDataMkr.class \
        TLV_CMTSMIC.class \
        TLV_CMMIC.class \
        TLV_TestModeEnable.class \
        Lexer2TLVMapper.class \
        TLV_EndOfDataMkr.class \
        Encoder.class

ch/gauteron/jdocsis/parser/DocsisLexer.java: ch/gauteron/jdocsis/parser/DocsisLexer.g
	$(ANTLR) $(ANTLRFLAGS) ch/gauteron/jdocsis/parser/DocsisLexer.g
		
DocsisLexer.class: ch/gauteron/jdocsis/parser/DocsisLexer.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/parser/DocsisLexer.java

ch/gauteron/jdocsis/parser/DocsisParser.java: ch/gauteron/jdocsis/parser/DocsisParser.g
	$(ANTLR) $(ANTLRFLAGS) ch/gauteron/jdocsis/parser/DocsisParser.g

DocsisParser.class: ch/gauteron/jdocsis/parser/DocsisParser.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/parser/DocsisParser.java

BadFormatArgumentException.class: ch/gauteron/jdocsis/exceptions/BadFormatArgumentException.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/exceptions/BadFormatArgumentException.java

OutOfRangeTLVValueException.class: ch/gauteron/jdocsis/exceptions/OutOfRangeTLVValueException.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/exceptions/OutOfRangeTLVValueException.java

TLVClassLoader.class: ch/gauteron/jdocsis/common/TLVClassLoader.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/common/TLVClassLoader.java
	
TLV.class: ch/gauteron/jdocsis/TLVs/TLV.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV.java

TLVaggregate.class: ch/gauteron/jdocsis/TLVs/TLVaggregate.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVaggregate.java

TLVscalar.class: ch/gauteron/jdocsis/TLVs/TLVscalar.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVscalar.java

TLVuchar.class: ch/gauteron/jdocsis/TLVs/TLVushort.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVushort.java

TLVushort.class: ch/gauteron/jdocsis/TLVs/TLVuchar.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVuchar.java

TLVuint.class: ch/gauteron/jdocsis/TLVs/TLVuint.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVuint.java

TLVethernet.class: ch/gauteron/jdocsis/TLVs/TLVethernet.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVethernet.java
	
TLVethermask.class: ch/gauteron/jdocsis/TLVs/TLVethermask.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVethermask.java

TLVhexstr.class: ch/gauteron/jdocsis/TLVs/TLVhexstr.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVhexstr.java
	
TLVstring.class: ch/gauteron/jdocsis/TLVs/TLVstring.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVstring.java
	
TLVstrzero.class: ch/gauteron/jdocsis/TLVs/TLVstrzero.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLVstrzero.java

TLV_EndOfDataMkr.class: ch/gauteron/jdocsis/TLVs/TLV_EndOfDataMkr.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_EndOfDataMkr.java

TLV_CMTSMIC.class: ch/gauteron/jdocsis/TLVs/TLV_CMTSMIC.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_CMTSMIC.java

TLV_CMMIC.class: ch/gauteron/jdocsis/TLVs/TLV_CMMIC.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_CMMIC.java

TLV_TestModeEnable.class: ch/gauteron/jdocsis/TLVs/TLV_TestModeEnable.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/TLVs/TLV_TestModeEnable.java

Lexer2TLVMapper.class: ch/gauteron/jdocsis/encoder/Lexer2TLVMapper.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/encoder/Lexer2TLVMapper.java	


Encoder.class: ch/gauteron/jdocsis/encoder/Encoder.java
	$(JCC) $(JFLAGS) ch/gauteron/jdocsis/encoder/Encoder.java	


clean: 
	$(RM) *.class


