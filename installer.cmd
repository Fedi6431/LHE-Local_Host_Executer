@echo off
set url=https://download.oracle.com/java/22/latest/jdk-22_windows-x64_bin.exe
set output=C:\Users\%username\Desktop

powershell.exe -Command "& {$url = '%url%'; $output = '%output%'; Invoke-WebRequest -Uri $url -OutFile $output}"
