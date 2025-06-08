# LHE-Local_Host_Executer

## Installer guide
### Windows
`! To avoid bugs, move the installer out of the LHE folder !`

After running `installer.bat` it will check if you have openJDK and git, i you don't have it, the program will install and run them.
After installing the openJDK and the git, the program open the option menu.

### Linux (Debian distribution and Tremux)
Before running `installer.sh` you need to open the terminal as root in the installer folder and type 
`chmod +x /bin/zsh` after typing it press enter and type `chmod +x installer.sh` and run the installer using this command 
`./installer.sh`.

After running it you can select the "system" that you're using.

## User guide
### Server
The server is built in java with a socket connection, it will use port 65000 and its own IPv4 as its IP address (Ex. 192.168.1.255). To execute the server in backgroud use `javaw *name*`.

### Client
The client is built in java with a socket connection like the server.

As soon as the client starts it will ask for the IP address of the server (Ex. 192.168.1.255) you can go to see the IP address using the `ipconfig` command on Windows and on Linux using `ifconfig` or if you do not have physical access to the server, being in the same network you can use a network analyzer capable of seeing all the devices connected to the network.

After entering the server's IP address, the client will ask you for the server's operating system.

And finally, after configuring the client, you can execute the payloads remotely (in the same network)

### Client GUI
The client GUI is build in java with swing and socket connection.

As soon as you launch the client GUI, a server login panel will open with a text field where you need to enter the IPv4 of the server. 
![image](https://github.com/user-attachments/assets/6161b338-52c6-44f4-b251-69cb4dfa8603)


After typing the IPv4 of the server, the server control panel will open, in this panel there are 2 buttons and a text field. The text field is used to write payloads and the button next to the text field is used to send them to the server, however, the other button is used to close the session.

![image](https://github.com/user-attachments/assets/542f582b-1e3d-4854-8b71-79dd4cfbcb18)


#### Examples of payloads
Windows payload :

- `echo Hello world > C:\users\%username\Desktop\Hello.txt `

- `echo @echo off > C:\users\%username%\Desktop\file.cmd `

- `echo start >> C:\users\%username%\Desktop\file.cmd`  

- `start C:\users\%username%\Desktop\file.cmd`


### FILE Path
#### JAVA Files
server.java : `src/server.java`

client.java : `src/client.java`
clientGUI.java : `src/clientGUI.java`
#### CLASS Files
server.class : `out/production/LHE-Local_Host_Executer/Server.class`

client.class : `out/production/LHE-Local_Host_Executer\Client.class`

### Badge ( just cool )
[![Java CI with Gradle](https://github.com/Fedi6431/LHE-Local_Host_Executer/actions/workflows/gradle.yml/badge.svg)](https://github.com/Fedi6431/LHE-Local_Host_Executer/actions/workflows/gradle.yml)

