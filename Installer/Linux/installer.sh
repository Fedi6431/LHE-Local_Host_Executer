#!/bin/bash

url="https://download.oracle.com/java/22/latest/jdk-22_linux-x64_bin.deb"
output="/home/username/Desktop/jdk-22_linux-x64_bin.deb"

wget "$url" -O "$output"

cd /home/username/Desktop/

chmod +x jdk-22_linux-x64_bin.deb
sudo ./jdk-22_linux-x64_bin.deb
