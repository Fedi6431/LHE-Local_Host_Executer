# LHE-Local_Host_Executer
# ⚠ EDUCATIONAL PURPOSE ONLY ⚠ 
### ⚠ DISCLAMER I DON'T ASSUME RESPONSIBILITY FOR THE UNLAWFUL USE OF THIS PROGRAM ⚠ 
# User guide
## Installer
### Windows
`! To avoid bugs, move the installer out of the LHE folder !`

After running `installer.bat` it will check if you have openJDK and git, i you don't have it, the program will install and run them.
After installing the openJDK and the git, the program open the option menu.

### Linux (Debian distribution and Tremux)
Before running `installer.sh` you need to open the terminal as root in the installer folder and type 
`chmod +x /bin/zsh` after typing it press enter and type `chmod +x installer.sh` and run the installer using this command `./installer.sh`.

After running it you can select the "system" that you're using.

### Server
The server is build in java with socket connection.

### Client
The client is build in java with socket connection, like the server.

But the client can write payload in the console that are executed in the server computer using the process `Runtime.getRuntime()`

Example of windows payload :

- `echo Hello world > C:\users\%username\Desktop\Hello.txt `

- `echo @echo off > C:\users\%username%\Desktop\file.cmd `

- `echo start >> C:\users\%username%\Desktop\file.cmd`  

- `start C:\users\%username%\Desktop\file.cmd`

## Guide
First of all, start the server (server.jar or server.java)

After starting the server, start the client which will connect automatically

Now you have a Local Host Executer made by Fedi6431

### FILE Path

#### JAVA Files
server.java : `src/server.java`

client.java : `src/client.java`

## ⚠ EDUCATIONAL PURPOSE ONLY ⚠ 
### ⚠ I DON'T ASSUME RESPONSIBILITY FOR THE UNLAWFUL USE OF THIS PROGRAM ⚠
