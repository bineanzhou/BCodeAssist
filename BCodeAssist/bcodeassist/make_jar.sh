#!/usr/bin/env bash
VER_NAME=$1
rm -rf bcode_temp
mkdir -p bcode_temp
cd bcode_temp
#jar -xvf ../bcodeassist/libs/ant-1.7.1.jar
jar -xvf ../libs/asm-4.0.jar
jar -xvf ../libs/asm-commons-4.0.jar
jar -xvf ../build/libs/bcodeassist.jar
mkdir -p ../tools
jar -cvfM ../tools/bcodeassist_${VER_NAME}.jar .
cd ..
rm -rf bcode_temp