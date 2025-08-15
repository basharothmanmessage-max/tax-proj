@echo off
setlocal

echo.
echo ============================
echo   Building Java Project...
echo ============================

:: Clean and build the project using Maven
call mvn clean package

:: Check if the build failed
if %ERRORLEVEL% NEQ 0 (
    echo Build failed. Please check errors above.
    pause
    exit /b 1
)

echo.
echo ============================
echo     Build Successful
echo ============================

:: Define the name of the fat (shaded) JAR file
set JAR_FILE=target\sales-tax-system-1.0-SNAPSHOT.jar

:: Check if the JAR exists
if not exist %JAR_FILE% (
    echo ERROR: %JAR_FILE% not found.
    pause
    exit /b 1
)

echo.
echo ============================
echo   Running Application...
echo ============================

:: Run the JAR file
java -jar %JAR_FILE%

:: Pause to keep window open after execution
pause
endlocal
