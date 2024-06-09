#!/bin/bash

username=$USER

sudo apt update
sudo apt upgrade
#sudo apt full-upgrade
sudo apt autoremove

cd /home/$username/Desktop/
sudo apt install default-jdk
java -version

echo Now you can use LHE-Local_Host_Executer made by Fedi6431
