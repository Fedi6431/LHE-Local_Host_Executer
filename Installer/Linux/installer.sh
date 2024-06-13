#!/bin/bash
banner="What are you using:
1 Linux
2 Tremux
"

read -p -n 1 "Enter system choice:  " system

if [ $system = 1 ]; then
    username=$USER
    
    sudo apt update -y 
    sudo apt full-upgrade -y
    sudo apt autoremove -y
    
    cd /home/$username/Desktop/
    sudo apt install default-jdk
    java -version
    
    echo Now you can use LHE-Local_Host_Executer made by Fedi6431

elif [ $system = 2 ]; then
    apt update -y
    apt full-upgrade -y 
    apt autoremove -y

    pkg install openjdk -y
    java -version
    echo Now you can use LHE-Local_Host_Executer made by Fedi6431
