@echo off
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-25.0.1.8-hotspot
set PATH=%JAVA_HOME%\bin;%PATH%

echo Compiling...
javac src/*.java -d out
if %errorlevel% neq 0 (
    echo Compilation failed!
    exit /b 1
)

echo Running...
echo =======================================================
java -cp out Main
