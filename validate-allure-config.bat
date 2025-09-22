@echo off
echo ========================================
echo    VALIDATION DE LA CONFIGURATION ALLURE
echo ========================================
echo.

echo [1/6] Verification de Maven...
mvn --version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERREUR: Maven n'est pas installe ou n'est pas dans le PATH
    pause
    exit /b 1
)
echo OK: Maven detecte

echo.
echo [2/6] Verification des dependances Allure...
call mvn dependency:resolve -q
if %errorlevel% neq 0 (
    echo ERREUR: Probleme avec les dependances Maven
    pause
    exit /b 1
)
echo OK: Dependances Allure disponibles

echo.
echo [3/6] Verification de la compilation...
call mvn clean compile test-compile -q
if %errorlevel% neq 0 (
    echo ERREUR: Echec de la compilation
    pause
    exit /b 1
)
echo OK: Compilation reussie

echo.
echo [4/6] Verification des fichiers de configuration...
if not exist "testng.xml" (
    echo ERREUR: Fichier testng.xml manquant
    pause
    exit /b 1
)
echo OK: testng.xml present

if not exist "allure.properties" (
    echo ATTENTION: Fichier allure.properties manquant (optionnel)
) else (
    echo OK: allure.properties present
)

if not exist "allure-environment.properties" (
    echo ATTENTION: Fichier allure-environment.properties manquant (optionnel)
) else (
    echo OK: allure-environment.properties present
)

echo.
echo [5/6] Test de generation de rapport (dry-run)...
call mvn allure:report -Dallure.results.directory=target\allure-results -q
if %errorlevel% neq 0 (
    echo ERREUR: Plugin Allure Maven non fonctionnel
    pause
    exit /b 1
)
echo OK: Plugin Allure Maven fonctionnel

echo.
echo [6/6] Verification des classes de test...
dir /b src\test\java\com\ansut\*.java >nul 2>&1
if %errorlevel% neq 0 (
    echo ERREUR: Aucune classe de test trouvee
    pause
    exit /b 1
)
echo OK: Classes de test detectees

echo.
echo ========================================
echo    CONFIGURATION ALLURE VALIDEE
echo ========================================
echo.
echo Votre configuration Allure est correcte!
echo.
echo Pour executer les tests et generer un rapport:
echo 1. run-allure-tests.bat
echo.
echo Pour generer uniquement le rapport:
echo 2. generate-allure-report.bat
echo.
echo Pour ouvrir le rapport:
echo 3. serve-allure-report.bat
echo.
pause

