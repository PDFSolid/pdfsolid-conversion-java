@echo off
set SRC_DIR=src
set BIN_DIR=bin
set OUTPUT_DIR=output
set LIB_JAR=lib\pdfsolidconversionsdk.jar

if not exist "%BIN_DIR%" mkdir "%BIN_DIR%"
if not exist "%OUTPUT_DIR%" mkdir "%OUTPUT_DIR%"

echo Compiling...

javac -cp "%LIB_JAR%" -d "%BIN_DIR%" "%SRC_DIR%\App.java"
if %errorlevel% neq 0 (
    echo Compile failed
    exit /b 1
)

echo Running...

java -cp "%BIN_DIR%;%LIB_JAR%" App "%cd%"