@echo off
echo ========================================
echo    EXECUTION DES TESTS AVEC ALLURE
echo ========================================
echo.

echo [1/3] Nettoyage et compilation...
call mvn clean compile test-compile
if %errorlevel% neq 0 (
    echo ERREUR: Echec de la compilation
    pause
    exit /b 1
)
echo Compilation reussie.
echo.

echo [2/3] Execution des tests...
call mvn test
if %errorlevel% neq 0 (
    echo ATTENTION: Certains tests ont echoue, mais le rapport sera genere
)
echo Execution des tests terminee.
echo.

echo [3/3] Generation du rapport Allure...
call generate-allure-report.bat
if %errorlevel% neq 0 (
    echo ERREUR: Echec de la generation du rapport
    pause
    exit /b 1
)
echo Rapport genere avec succes.
echo.

echo ========================================
echo    RAPPORT ALLURE DISPONIBLE
echo ========================================
echo.
echo Le rapport Allure a ete genere dans: target\allure-report\index.html
echo.
echo Pour ouvrir le rapport, executez:
echo serve-allure-report.bat
echo.
echo Ou double-cliquez sur: target\allure-report\index.html
echo.
pause
