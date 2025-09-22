package com.ansut.Login;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.ansut.Workflow.CreateIncident;
import com.ansut.search.SearchTicket;
import com.ansut.settings.Section.CreateSection;
// import com.ansut.settings.actifs.Actifs;
import com.ansut.settings.cloture.Cloture;
// import com.ansut.settings.curative.workDone;
import com.ansut.settings.diagnostic.diagnostic;
// import com.ansut.settings.maintenancier.Maintenancier;
// import com.ansut.settings.methods.createMethod;
// import com.ansut.settings.raison.CreateReason;
// import com.ansut.users.createUser;
// import com.ansut.users.modifyUser;
import com.ansut.settings.prestataire.Operateur;
// import com.ansut.travaux.travaux;
public class LoginAnsut {

    private WebDriver driver;
    private static final String URL = "https://pgir-preprod.ansut.ci/#/auth";
    private static final String USR = "Exp";
    private static final String PWD = "K4dk272001@";

    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-password-manager-reauthentication");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public void login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).sendKeys(username);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("body > app-root > div > app-auth > div > section > div.form-section > div.row > div > form > button")
            )).click();
            System.out.println("[INFO] Login réussi !");
        } catch (Exception e) {
            System.out.println("[ERREUR] Echec du login : " + e.getMessage());
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("[INFO] Driver fermé proprement.");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void main(String[] args) throws InterruptedException {
        LoginAnsut loginAnsut = new LoginAnsut();

        try {
            loginAnsut.setUp();
            loginAnsut.login(USR, PWD);

            System.out.println("[INFO] Début des tests...");

            // Test des Sections
            try {
                CreateSection sectionTest = new CreateSection(loginAnsut.getDriver());
                System.out.println("[TEST] Execution : Create Section...");
                sectionTest.GoToMenu();
                sectionTest.search();
                // sectionTest.Modify();
                // sectionTest.Deleted();
            } catch (Exception e) {
                System.out.println("[ERREUR] CreateSection failed : " + e.getMessage());
            }

            // // Test des Raisons
            // try {
            //     CreateReason reasonTest = new CreateReason(loginAnsut.getDriver());
            //     System.out.println("[TEST] Execution : Create Reason...");
            //     reasonTest.GoToMenu();
            //     reasonTest.search();
            //     reasonTest.Modify();
            //     reasonTest.Deleted();
            // } catch (Exception e) {
            //     System.out.println("[ERREUR] CreateReason failed : " + e.getMessage());
            // }

            // // Test des Méthodes de Diagnostic
            // try {
            //     createMethod reasonMethodTest = new createMethod(loginAnsut.getDriver());
            //     System.out.println("[TEST] Execution : Create Method...");
            //     reasonMethodTest.GoToMenu();
            //     reasonMethodTest.search();
            //     reasonMethodTest.Modify();
            //     reasonMethodTest.Deleted();
            // } catch (Exception e) {
            //     System.out.println("[ERREUR] CreateMethod failed : " + e.getMessage());
            // }

            // // Test des Actifs
            // try {
            //     Actifs actifsTest = new Actifs(loginAnsut.getDriver());
            //     System.out.println("[TEST] Execution : Actifs...");
            //     actifsTest.GoToMenu();
            //     actifsTest.search();
            //     actifsTest.Modify();
            //     actifsTest.Deleted();
            // } catch (Exception e) {
            //     System.out.println("[ERREUR] Actifs failed : " + e.getMessage());
            // }

            // // Test des Méthodes Curatives
            // try {
            //     workDone curativeTest = new workDone(loginAnsut.getDriver());
            //     System.out.println("[TEST] Execution : Méthodes Curatives...");
            //     curativeTest.GoToMenu();
            //     curativeTest.search();
            //     curativeTest.Modify();
            //     curativeTest.Deleted();
            // } catch (Exception e) {
            //     System.out.println("[ERREUR] Curative failed : " + e.getMessage());
            // }

            // // Test des Diagnostics
            try {
                diagnostic diagnosticTest = new diagnostic(loginAnsut.getDriver());
                System.out.println("[TEST] Execution : Diagnostics...");
                diagnosticTest.GoToMenu();
                diagnosticTest.search();
                diagnosticTest.Modify();
                diagnosticTest.Deleted();
            } catch (Exception e) {
                System.out.println("[ERREUR] Diagnostic failed : " + e.getMessage());
            }

            // // Test des Maintenanciers
            // try {
            //     Maintenancier maintenancierTest = new Maintenancier(loginAnsut.getDriver());
            //     System.out.println("[TEST] Execution : Maintenanciers...");
            //     maintenancierTest.GoToMenu();
            //     maintenancierTest.search();
            //     maintenancierTest.Modify();
            //     maintenancierTest.Deleted();
            // } catch (Exception e) {
            //     System.out.println("[ERREUR] Maintenancier failed : " + e.getMessage());
            // }

            // // Test des Operateurs
            try {
                Operateur operateur = new Operateur(loginAnsut.getDriver());
                System.out.println("[TEST] Execution : Operateur...");
                operateur.GoToMenu();
                operateur.search();
                operateur.Modify();
                operateur.Deleted();
            } catch (Exception e) {
                System.out.println("[ERREUR] Operateur failed : " + e.getMessage());
            }

            // // Test des Raisons de Clôture
            try {
                Cloture cloture = new Cloture(loginAnsut.getDriver());
                System.out.println("[TEST] Execution : Raisons de Clôture...");
                cloture.GoToMenu();
                cloture.search();
                cloture.Modify();
                cloture.Deleted();
            } catch (Exception e) {
                System.out.println("[ERREUR] Cloture failed : " + e.getMessage());
            }

            // // Test des Utilisateurs
            // try {
            //     modifyUser userAccount = new modifyUser(loginAnsut.getDriver());
            //     System.out.println("[TEST] Execution : Modify User...");
            //     userAccount.modify();
            // } catch (Exception e) {
            //     System.out.println("[ERREUR] modifyUser failed : " + e.getMessage());
            // }

            // try {
            //     createUser userAccount1 = new createUser(loginAnsut.getDriver());
            //     System.out.println("[TEST] Execution : Create User...");
            //     userAccount1.create();
            // } catch (Exception e) {
            //     System.out.println("[ERREUR] createUser failed : " + e.getMessage());
            // }

            // // Test de Recherche de Tickets
            // try {
            //     SearchTicket search = new SearchTicket(loginAnsut.getDriver());
            //     System.out.println("[TEST] Execution : Search Ticket...");
            //     search.FinalSearch();
            // } catch (Exception e) {
            //     System.out.println("[ERREUR] SearchTicket failed : " + e.getMessage());
            // }

            // // Test de Création d'Incidents
            // try {
            //     CreateIncident incidentTest = new CreateIncident(loginAnsut.getDriver());
            //     System.out.println("[TEST] Execution : Create Incident...");
            //     incidentTest.fillForm();
            // } catch (Exception e) {
            //     System.out.println("[ERREUR] CreateIncident failed : " + e.getMessage());
            // }

            // Test de Création de Travaux
            // try {
            //     travaux travauxTest = new travaux(loginAnsut.getDriver());
            //     System.out.println("[TEST] Execution : Create Travaux...");
            //     travauxTest.GoToMenu();
            //     travauxTest.search();
            // } catch (Exception e) {
            //     System.out.println("[ERREUR] CreateTravaux failed : " + e.getMessage());
            // }

            System.out.println("[INFO] Tous les tests sont terminés.");

        } catch (Exception e) {
            System.out.println("[ERREUR FATALE] Une erreur s'est produite : " + e.getMessage());
        } finally {
            loginAnsut.tearDown();
        }
    }
}
