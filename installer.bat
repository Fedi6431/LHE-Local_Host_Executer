@echo off
set url=https://download.oracle.com/java/22/latest/jdk-22_windows-x64_bin.exe
set output=C:\Users\%username%\Desktop\jdk-22_windows-x64_bin.exe

(
  echo $url = '%url%'
  echo $output = '%output%'
  echo Invoke-WebRequest -Uri $url -OutFile $output
) > SDK-INSTALLER.ps1

powershell.exe -ExecutionPolicy Bypass -File SDK-INSTALLER.ps1

del SDK-INSTALLER.ps1

start C:\Users\%username%\Desktop\jdk-22_windows-x64_bin.exe
