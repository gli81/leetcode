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
set /a num=%q%
setlocal enabledelayedexpansion
if %num% lss 100 (
    set "q=00%q%"
    set "q=!q:~-3!"
)
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
    :: Extract the numeric part and non-numeric part
    for /f "tokens=1* delims=0123456789" %%a in ("%cd%") do (
        set "namee=%%b"
    )
    :: echo !namee!
    javac -d ..\ -cp ..\ .\*.java
    cd ..\
    java !namee!Java
)
endlocal
