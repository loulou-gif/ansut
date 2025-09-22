@echo off
echo ========================================
echo    OUVERTURE DU RAPPORT ALLURE
echo ========================================
echo.

if not exist "target\allure-results" (
    echo ERREUR: Aucun resultat de test trouve dans target\allure-results
    echo Veuillez d'abord executer les tests avec: mvn test
    pause
    exit /b 1
)

echo Ouverture du rapport Allure...
echo.

REM Utiliser l'Allure telecharge par Maven
set ALLURE_HOME=.allure\allure-2.24.0
set ALLURE_BIN=%ALLURE_HOME%\bin\allure.bat

if not exist "%ALLURE_BIN%" (
    echo Telechargement d'Allure...
    call mvn allure:report -q
    if %errorlevel% neq 0 (
        echo ERREUR: Impossible de telecharger Allure
        pause
        exit /b 1
    )
)

echo Demarrage du serveur Allure...
echo Le rapport devrait s'ouvrir automatiquement dans votre navigateur.
echo.
echo Pour arreter le serveur, appuyez sur Ctrl+C
echo.

"%ALLURE_BIN%" serve target\allure-results

