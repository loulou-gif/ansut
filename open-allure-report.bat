@echo off
echo ========================================
echo    OUVERTURE DU RAPPORT ALLURE
echo ========================================
echo.

if not exist "target\allure-results" (
    echo ERREUR: Aucun resultat de test trouve dans target\allure-results
    echo Veuillez d'abord executer les tests avec: run-allure-tests.bat
    pause
    exit /b 1
)

echo Generation et ouverture du rapport Allure...
echo.

call mvn allure:serve

echo.
echo Le rapport Allure devrait s'ouvrir automatiquement dans votre navigateur.
echo Si ce n'est pas le cas, ouvrez manuellement: http://localhost:port
echo.
pause

