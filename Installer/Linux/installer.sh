#!/bin/bash

banner="What are you using:
1) Linux 
2) Termux
"
echo "$banner"
read -p "--> " usr_ch

if [[ $usr_ch = 1 ]]; then
  username=$USER
  sudo apt update -y
  sudo apt upgrade -y 
  sudo apt autoremove -y
  sudo apt install openjdk git -y
  java -version
  cd /home/$username/desktop || exit
elif [[ $usr_ch = 2 ]]; then
  pkg update -y
  apt upgrade -y
  apt autoremove -y
  pkg install openjdk git
  java -version
  cd ~ || exit
else
  echo "Invalid choice. Exiting."
  exit 1
fi

cat > installer.sh <<EOF
while true; do
  echo -e "Select option\n1) Install\n2) Update\n3) Remove\n4) Close"
  read -p "--> " user_choice
  case \$user_choice in
    1)
      git clone https://github.com/Fedi6431/LHE-Local_Host_Executer.git
      echo -e "\\nLHE installed successfully!\\n"
      ;;
    2)
      rm -rfv LHE-Local_Host_Executer
      echo -e "\\nRemoved old LHE-Local_Host_Executer\\n"
      git clone https://github.com/Fedi6431/LHE-Local_Host_Executer.git
      echo -e "\\nUpdated git LHE-Local_Host_Executer!\\n"
      ;;
    3)
      rm -rfv LHE-Local_Host_Executer
      echo -e "\\nRemoved LHE-Local_Host_Executer successfully!\\n"
      ;;
    4)
      echo -e "\\nThanks for using Fedi6431's LHE installer\\n"
      break
      ;;
    *)
      echo -e "\\nWrong option\\n"
      ;;
  esac
  read -p "Press Enter to continue"
  clear
done
EOF

chmod +x installer.sh
./installer.sh
