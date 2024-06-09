@echo off
set url=https://download.oracle.com/java/22/latest/jdk-22_windows-x64_bin.exe
set output=C:\Users\%username%\Desktop\jdk-22_windows-x64_bin.exe

(
  echo $url = '%url%'
  echo $output = '%output%'
  echo Invoke-WebRequest -Uri $url -OutFile $output
) > download.ps1

powershell.exe -ExecutionPolicy Bypass -File download.ps1

del download.ps1

start C:\Users\%username%\Desktop\jdk-22_windows-x64_bin.exe