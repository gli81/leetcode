@echo off
set "q=%1"

:: check if there is input
if "%q%"=="" (
    echo No Input
    exit /b
)

:: check if input is digit only
echo %q%| findstr /r /x "[0-9][0-9]*" >nul
if not %errorlevel% == 0 (
    echo Not a Number
    exit /b
)

setlocal enabledelayedexpansion
set "found=false"

for /d %%d in (%q%*) do (
    if '!found!'=='false' (
        cd %%d
        set "found=true"
    )
)


if '!found!'=='false' (
    echo Question Not Found
) else (
    echo %cd%
    javac -d ..\ -cp ..\ .\*.java
    cd ..\
    java
)
endlocal