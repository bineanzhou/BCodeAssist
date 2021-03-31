#!/usr/bin/env bash
rm -rf bcode_temp
mkdir -p bcode_temp
cd bcode_temp
#jar -xvf ../bcodetool/libs/ant-1.7.1.jar
jar -xvf ../bcodetool/libs/asm-4.0.jar
jar -xvf ../bcodetool/libs/asm-commons-4.0.jar
jar -xvf ../bcodetool/build/libs/bcodetool.jar
mkdir -p ../jar
jar -cvfM ../jar/bcode_tool.jar .