@echo off

rem Check if OpenJDK is installed
java -version >nul 2>&1
if %errorlevel% == 0 (
    echo OpenJDK is already installed
) else (
    rem Install OpenJDK
    set "url=https://download.oracle.com/java/22/latest/jdk-22_windows-x64_bin.exe"
    set "output=C:\Users\%username%\Desktop\jdk-22_windows-x64_bin.exe"
    (
        echo $url = '%url%'
        echo $output = '%output%'
        echo Invoke-WebRequest -Uri $url -OutFile $output
    ) > jdk_installer.ps1
    powershell.exe -ExecutionPolicy Bypass -File jdk_installer.ps1
    del jdk_installer.ps1
    start "" "%output%"
    set /p WAIT="If OpenJDK is installed, press enter"
)

rem Check if Git is installed
git --version >nul 2>&1
if %errorlevel% == 0 (
    echo Git is already installed
) else (
    rem Install Git
    set "url=https://github.com/git-for-windows/git/releases/download/v2.45.2.windows.1/Git-2.45.2-64-bit.exe"
    set "output=C:\Users\%username%\Desktop\Git-2.45.2-64-bit.exe"
    (
        echo $url = '%url%'
        echo $output = '%output%'
        echo Invoke-WebRequest -Uri $url -OutFile $output
    ) > git_installer.ps1
    powershell.exe -ExecutionPolicy Bypass -File git_installer.ps1
    del git_installer.ps1
    start "" "%output%"
    set /p WAIT="If Git is installed, press enter"
)

:installer
cls
echo Installer menu
echo 1) Install
echo 2) Update
echo 3) Remove
echo 4) exit
echo.

set /P user_choice="--> "

if "%user_choice%"=="1" (
    git clone https://github.com/Fedi6431/LHE-Local_Host_Executer.git 
    echo.
    echo LHE-Local_Host_Executer installed successfully!
    echo.
    echo Thanks for using Fedi6431's LHE installer
    echo.
    set /p WAIT="Press enter to continue"
) else if "%user_choice%"=="2" (
    rmdir /s /q LHE-Local_Host_Executer
    echo old LHE-Local_Host_Executer removed
    git clone https://github.com/Fedi6431/LHE-Local_Host_Executer.git
    echo.
    echo LHE-Local_Host_Executer updated successfully!
    echo.
    echo Thanks for using Fedi6431's LHE installer
    echo.
    set /p WAIT="Press enter to continue"
) else if "%user_choice%"=="3" (
    rmdir /s /q LHE-Local_Host_Executer
    echo.
    echo LHE-Local_Host_Executer removed successfully!
    echo.
    echo Thanks for using Fedi6431's LHE installer
    echo.
    set /p WAIT="Press enter to continue"
) else if "%user_choice%"=="4" (
    echo.
    echo Thanks for using Fedi6431's LHE installer
    echo.
    timeout /t 2 /nobreak >nul
    exit
)

goto installer
