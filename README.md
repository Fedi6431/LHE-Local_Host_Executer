# LHE-Local_Host_Executer
## ⚠ EDUCATIONAL PURPOSE ONLY ⚠ 
## User guide
### Installer
I've made two insaller, one for windows and one for linux (only debian distribution)
- Windows installer:
- In the windows installer you just only need to open it and the program will download the JDK form the Orcale site. If you already have the JDK don't run installer.bat because is useless.
- Debian Linux Distribution Installer:
-  Before running installer.sh you need to open the terminal as root in the installer folder and type "chmod +x /bin/zsh" after typing it press enter and type "chmod +x installer.sh" and to finish to run the installer./installer.sh
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

### LHE FILE Path

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
