#!/bin/bash

username=$USER

sudo apt update -y
sudo apt full-upgrade -y 
sudo apt autoremove -y

cd /home/$username/Desktop/
sudo apt install default-jdk
java -version

echo Now you can use LHE-Local_Host_Executer made by Fedi6431
