#!/usr/bin/env bash

RULE_FILE=$1
INPUT_FILE=$2
if [ "${RULE_FILE}" = "" ] || [ "${INPUT_FILE}" = "" ]; then
    echo "命令格式:./bcodeassist.sh rule.txt file"
    exit
fi

echo "RULE_FILE:$RULE_FILE"
echo "INPUT_FILE:$INPUT_FILE"

FILE=${INPUT_FILE##*/}
echo "FILE:${FILE}"
# 右边开始去掉最短匹配
FILE_NAME=${FILE%.*}
# 左边开始去掉最长匹配
FILE_TYPE=${FILE##*.}

echo ${FILE_NAME}
echo ${FILE_TYPE}

BCODE_JAR=bcodeassist_v1.0.0.jar

function makeJAR() {
    local jar_file=$1
    local jar_name=$2
    rm -rf jar/${jar_name}_new.jar
    mkdir -p jar
    java -jar ${BCODE_JAR} process ${RULE_FILE} ${jar_file} jar/${jar_name}_new.jar
    echo "生成新的jar文件 jar/${jar_name}_new.jar"
    #cp jar/xxx_new.jar ../libs/xxx_new.jar
}

function makeAAR() {
    local aar_file=$1
    local aar_name=$2
    local rule_file=${RULE_FILE}
    echo "make aar:${aar_name}"
    local tmp_dir=${aar_name}_tmp_dir
    rm -rf aar/${tmp_dir}
    unzip ${aar_file} -d aar/${tmp_dir}
    mv aar/${tmp_dir}/classes.jar aar/${tmp_dir}/classes_old.jar
    java -jar ${BCODE_JAR} process ${rule_file} aar/${tmp_dir}/classes_old.jar aar/$tmp_dir/classes.jar
    rm -rf aar/${tmp_dir}/classes_old.jar
    jar cvf aar/${aar_name}_new.aar -C aar/${tmp_dir}/ .
    rm -rf aar/$tmp_dir
    #    cp aar/${aar_name}_new.aar ../../aar/${aar_name}_new.aar
}

function makeAPK() {
    echo "makeAPK"
}
case ${FILE_TYPE} in
jar)
    makeJAR ${INPUT_FILE} ${FILE_NAME}
    ;;
aar)
    makeAAR ${INPUT_FILE} ${FILE_NAME}
    ;;
apk)
    makeAPK ${INPUT_FILE} ${FILE_NAME}
    ;;
*)
    echo "不支持该类型文件"
    ;;
esac
