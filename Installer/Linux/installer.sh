#!/bin/bash

username=$USER

sudo apt update --force-yes
sudo apt full-upgrade --force-yes
sudo apt autoremove --force-yes

cd /home/$username/Desktop/
sudo apt install default-jdk
java -version

echo Now you can use LHE-Local_Host_Executer made by Fedi6431
