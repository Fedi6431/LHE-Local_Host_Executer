#!/bin/bash

banner="What are you using:
1) Linux 
2) Termux
"

echo "$banner"

read -p "--> " usr_ch

if [[ $usr_ch = 1 ]]; then
  username=$USER
  # Update the system and remove old packages
  sudo apt update -y
  sudo apt full-upgrade -y 
  sudo apt autoremove -y
  
  # Install OpenJDK and git
  sudo apt install openjdk -y
  sudo apt install git
  # Check the Java version of OpenJDK
  java -version
  
  # change the directory to the main dir
  cd /home/$username/desktop
  # Code that will go in the installer.sh
  cat > installer.sh <<EOF
  while :
  do
    echo -e "Select option\n1) Install\n2) Update\n3) Remove\n4) Close"
    read -p "--> " user_choice
    
    if [ "\$user_choice" = 1 ]; then
      git clone https://github.com/Fedi6431/LHE-Local_Host_Executer.git
      echo -e "\\nLHE installed successfully!\\n"
    elif [ "\$user_choice" = 2 ]; then
        rm -rfv LHE-Local_Host_Executer
        echo -e "\\nRemoved old LHE-Local_Host_Executer\\n"
        git clone https://github.com/Fedi6431/LHE-Local_Host_Executer.git
        echo -e "\\nUpdated git LHE-Local_Host_Executer!\\n"
    elif [ "\$user_choice" = 3 ]; then
        rm -rfv LHE-Local_Host_Executer
        echo -e "\\nRemoved LHE-Local_Host_Executer successfully!\\n"
    elif [ "\$user_choice" = 4 ]; then
        echo -e "\\nThanks for using Fedi6431's LHE installer\\n"
        break
    else 
      echo -e "\\nWrong option\\n"
    fi
    read -p "Press Enter to continue"
    clear
  done
EOF
  # clear apt outputs
  clear
  # Make the installer.sh executable and run it
  chmod +x installer.sh
  ./installer.sh

elif [[ $usr_ch = 2 ]]; then
  # Update the system and remove old packages
  pkg update -y
  apt update -y
  apt full-upgrade -y
  apt autoremove -y
  
  # Install OpenJDK and git
  pkg install openjdk
  pkg install git
  # Check the Java version of OpenJDK
  java -version
  
  # change the directory to the main dir
  cd ~
  # Code that will go in the installer.sh
  cat > installer.sh <<EOF
  while :
  do
    echo -e "Select option\n1) Install\n2) Update\n3) Remove\n4) Close"
    read -p "--> " user_choice
    
    if [ "\$user_choice" = 1 ]; then
      git clone https://github.com/Fedi6431/LHE-Local_Host_Executer.git
      echo -e "\\nLHE installed successfully!\\n"
    elif [ "\$user_choice" = 2 ]; then
        rm -rfv LHE-Local_Host_Executer
        echo -e "\\nRemoved old LHE-Local_Host_Executer\\n"
        git clone https://github.com/Fedi6431/LHE-Local_Host_Executer.git
        echo -e "\\nUpdated git LHE-Local_Host_Executer!\\n"
    elif [ "\$user_choice" = 3 ]; then
        rm -rfv LHE-Local_Host_Executer
        echo -e "\\nRemoved LHE-Local_Host_Executer successfully!\\n"
    elif [ "\$user_choice" = 4 ]; then
        echo -e "\\nThanks for using Fedi6431's LHE installer\\n"
        break
    else 
      echo -e "\\nWrong option\\n"
    fi
    read -p "Press Enter to continue"
    clear
  done
EOF
  # clear pkg outputs
  clear
  # Make the installer.sh executable and run it
  chmod +x installer.sh
  ./installer.sh

fi
