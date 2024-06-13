# LHE-Local_Host_Executer
[![Java CI with Gradle](https://github.com/Fedi6431/LHE-Local_Host_Executer/actions/workflows/gradle.yml/badge.svg)](https://github.com/Fedi6431/LHE-Local_Host_Executer/actions/workflows/gradle.yml)
## ⚠ EDUCATIONAL PURPOSE ONLY ⚠ 
# User guide
## Installer
### Windows
In the Windows installer, simply open it and the program will download the JDK from the Orcale site.

### Linux (Debian distribution and Tremux)
Before running `installer.sh` you need to open the terminal as root in the installer folder and type `chmod +x /bin/zsh` after typing it press enter and type `chmod +x installer.sh` and run the installer using this command `./installer.sh`.

After running it you can select the "system" that you're using.

## Guide

### Server
The server is build in java with socket connection.

### Client
The client is build in java with socket connection, like the server.

But the client can write payload in the console that are executed in the server computer using the process Runtime.getRuntime()

Example of windows payload :

- echo Hello world > C:\users\%username\Desktop\Hello.txt 

- echo @echo off > C:\users\%username%\Desktop\file.cmd 

- echo start >> C:\users\%username%\Desktop\file.cmd    

- start C:\users\%username%\Desktop\file.cmd

### How to use
First of all, start the server (server.jar or server.java)

After starting the server, start the client which will connect automatically

Now you have a Local Host Executer made by Fedi6431

### FILE Path

#### JAVA Files
server.java : src/server.java

client.java : src/client.java

#### CLASS Files
server.class : out/production/Local_Host_Executer/server.class

client.class : out/production/Local_Host_Executer/client.class

#### JAR Files
server.jar : out/artifacts/Server_jar/Server.jar

client.jar : out/artifacts/Client_jar/Client.jar

## ⚠ EDUCATIONAL PURPOSE ONLY ⚠ 
### ⚠ I DO NOT TAKE RESPONSIBILITY FOR THE USE OF THE PROGRAM BY OTHERS ⚠
