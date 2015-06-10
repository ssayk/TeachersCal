@echo off

set PATH=C:\jdk1.6.0_26\bin;U:\BankingSolutions\AntBuild6\apache-ant\bin;%PATH%
set JAVA_HOME=C:\jdk1.6.0_26
set ANT_HOME=U:\BankingSolutions\AntBuild6\apache-ant
rem echo Java Path set!

ant -f build.xml %1 %2 %3 %4 %5 %6 %7 %8 %9
