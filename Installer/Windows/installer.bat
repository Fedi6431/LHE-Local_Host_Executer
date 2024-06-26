@echo off
rem Check if Java is installed
:InstallJava
java -version >nul 2>&1
if %errorlevel% equ 0 (
    echo Java is already installed.
    java -version
) else (
    echo Java is not installed. Installing OpenJDK...
	powershell Invoke-WebRequest https://download.oracle.com/java/22/latest/jdk-22_windows-x64_bin.exe -OutFile c:\users\%username%\Desktop\openjdk-installer.exe
    cd c:\users\%username%\Desktop 
	start /wait openjdk-installer.exe
    echo OpenJDK installation completed.
    java -version
	cls
	del /f c:\users\%username%\Desktop\openjdk-installer.exe
)
:InstallGit
git --version >nul 2>&1
if %errorlevel% equ 0 (
    echo Git is already installed
) else (
    echo Java is not installed. Installing OpenJDK...
	powershell Invoke-WebRequest https://github.com/git-for-windows/git/releases/download/v2.45.2.windows.1/Git-2.45.2-64-bit.exe -OutFile c:\users\%username%\Desktop\git-installer.exe
	cd c:\users\%username%\Desktop
	start /wait git-installer.exe 
	git --version
	cls
	del /f c:\users\%username%\Desktop\git-installer.exe
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
