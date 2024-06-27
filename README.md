# LHE-Local_Host_Executer
# ⚠ EDUCATIONAL PURPOSE ONLY ⚠ 
### ⚠ DISCLAMER I DON'T ASSUME RESPONSIBILITY FOR THE UNLAWFUL USE OF THIS PROGRAM ⚠ 
### Badge ( They're just cool )
[![Java CI with Gradle](https://github.com/Fedi6431/LHE-Local_Host_Executer/actions/workflows/gradle.yml/badge.svg)](https://github.com/Fedi6431/LHE-Local_Host_Executer/actions/workflows/gradle.yml)


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
The server is built in java with a socket connection, it will use port 5000 and its own IPv4 as its IP address (Ex. 192.168.1.255).

### Client
The client is built in java with a socket connection like the server.

As soon as the client starts it will ask for the IP address of the server (Ex. 192.168.1.255) you can go to see the IP address using the `ipconfig` command on Windows and on Linux using `ifconfig` or if you do not have physical access to the server, being in the same network you can use a network analyzer capable of seeing all the devices connected to the network.

After entering the server's IP address, the client will ask you for the server's operating system.

And finally, after configuring the client, you can execute the payloads remotely (in the same network)

#### Examples of payloads
Windows payload :

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
