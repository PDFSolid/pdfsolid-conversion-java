#!/bin/bash

SRC_DIR="src"
BIN_DIR="bin"
OUTPUT_DIR="output"
LIB_JAR="lib/cpdfconversionsdk.jar"

mkdir -p "$BIN_DIR"
mkdir -p "$OUTPUT_DIR"

javac -cp "$LIB_JAR" -d "$BIN_DIR" "$SRC_DIR"/App.java

if [ $? -ne 0 ]; then
  echo "❌ Compile failed"
  exit 1
fi

java -cp "$BIN_DIR:$LIB_JAR" App "$(pwd)"