@echo off
echo ========================================
echo    GENERATION DU RAPPORT ALLURE
echo ========================================
echo.

if not exist "target\allure-results" (
    echo ERREUR: Aucun resultat de test trouve dans target\allure-results
    echo Veuillez d'abord executer les tests avec: mvn test
    pause
    exit /b 1
)

echo Generation du rapport Allure...
echo.

REM Copier les fichiers de configuration Allure
if exist "allure.properties" (
    echo Copie de la configuration Allure...
    copy "allure.properties" "target\allure-results\" >nul
)

if exist "allure-environment.properties" (
    echo Copie de la configuration environnement...
    copy "allure-environment.properties" "target\allure-results\" >nul
)

if exist "allure-categories.json" (
    echo Copie de la configuration des categories...
    copy "allure-categories.json" "target\allure-results\" >nul
)

REM Utiliser Maven pour generer le rapport
echo Generation du rapport avec Maven...
call mvn allure:report

if %errorlevel% neq 0 (
    echo ERREUR: Generation du rapport echouee
    pause
    exit /b 1
)

echo.
echo ========================================
echo    RAPPORT ALLURE GENERE
echo ========================================
echo.
echo Le rapport Allure a ete genere dans: target\allure-report\index.html
echo.
echo Pour ouvrir le rapport, double-cliquez sur: target\allure-report\index.html
echo.
echo Ou executez: serve-allure-report.bat pour le servir en local
echo.
pause

