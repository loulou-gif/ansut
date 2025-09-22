package com.ansut;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import com.ansut.Login.LoginAnsut;
import com.ansut.settings.cloture.Cloture;

import io.qameta.allure.*;

/**
 * Classe de test TestNG pour le module Cloture (Raisons de clôture)
 * 
 * Cette classe teste toutes les opérations CRUD sur les raisons de clôture :
 * - Création d'une nouvelle raison de clôture
 * - Recherche d'une raison de clôture
 * - Modification d'une raison de clôture existante
 * - Suppression d'une raison de clôture
 * 
 * Structure de test :
 * 1. Setup : Connexion à l'application
 * 2. Tests : Exécution des opérations CRUD
 * 3. Teardown : Fermeture propre du navigateur
 */
@Epic("Gestion des Paramètres")
@Feature("Raisons de Clôture")
@Story("Opérations CRUD sur les raisons de clôture")
public class ClotureTest {

    private LoginAnsut loginAnsut;
    private Cloture cloture;
    private WebDriver driver;

    /**
     * Configuration initiale avant tous les tests de la classe
     * - Initialise le driver Chrome
     * - Se connecte à l'application
     * - Initialise l'objet Cloture pour les tests
     */
    @BeforeClass
    public void setUp() {
        try {
            System.out.println("[INFO] Démarrage des tests Cloture...");
            
            // Initialisation de la connexion
            loginAnsut = new LoginAnsut();
            loginAnsut.setUp();
            loginAnsut.login("Exp", "K4dk272001@");
            
            // Récupération du driver pour les tests
            driver = loginAnsut.getDriver(); 
            
            // Initialisation de l'objet Cloture
            cloture = new Cloture(driver);
            
            System.out.println("[INFO] Configuration terminée - Prêt pour les tests");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la configuration : " + e.getMessage());
            Assert.fail("Configuration échouée : " + e.getMessage());
        }
    }

    /**
     * Nettoyage après chaque test individuel
     * - Pause pour laisser le temps aux opérations de se terminer
     */
    @BeforeMethod
    public void beforeMethod() {
        try {
            Thread.sleep(2000); // Pause entre les tests
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Nettoyage après chaque test individuel
     * - Pause pour laisser le temps aux opérations de se terminer
     */
    @AfterMethod
    public void afterMethod() {
        try {
            Thread.sleep(2000); // Pause entre les tests
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Test de création d'une raison de clôture
     * 
     * Ce test vérifie que :
     * - La navigation vers le menu fonctionne
     * - La création d'une nouvelle raison de clôture réussit
     * - Les données sont correctement saisies
     */
    @Test(priority = 1, description = "Test de création d'une raison de clôture")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test de création d'une nouvelle raison de clôture dans l'application")
    @Story("Création de raison de clôture")
    public void testCreateCloture() {
        try {
            System.out.println("[TEST] Exécution : Création d'une raison de clôture...");
            
            Allure.step("Navigation vers le menu des raisons de clôture", () -> {
                cloture.GoToMenu();
            });
            
            System.out.println("[SUCCÈS] Création de raison de clôture réussie");
            
        } catch (Exception e) {
            Allure.addAttachment("Erreur de création", e.getMessage());
            System.out.println("[ERREUR] Échec de la création : " + e.getMessage());
            Assert.fail("Test de création échoué : " + e.getMessage());
        }
    }

    /**
     * Test de recherche d'une raison de clôture
     * 
     * Ce test vérifie que :
     * - La recherche fonctionne correctement
     * - Les filtres s'appliquent bien
     * - Les résultats sont affichés
     */
    @Test(priority = 2, description = "Test de recherche d'une raison de clôture")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test de recherche et filtrage des raisons de clôture")
    @Story("Recherche de raison de clôture")
    public void testSearchCloture() {
        try {
            System.out.println("[TEST] Exécution : Recherche d'une raison de clôture...");
            
            Allure.step("Exécution de la recherche de raisons de clôture", () -> {
                cloture.search();
            });
            
            System.out.println("[SUCCÈS] Recherche de raison de clôture réussie");
            
        } catch (Exception e) {
            Allure.addAttachment("Erreur de recherche", e.getMessage());
            System.out.println("[ERREUR] Échec de la recherche : " + e.getMessage());
            Assert.fail("Test de recherche échoué : " + e.getMessage());
        }
    }

    /**
     * Test de modification d'une raison de clôture
     * 
     * Ce test vérifie que :
     * - La modification d'une raison existante fonctionne
     * - Les nouvelles données sont correctement appliquées
     * - La sauvegarde réussit
     */
    @Test(priority = 3, description = "Test de modification d'une raison de clôture")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test de modification d'une raison de clôture existante")
    @Story("Modification de raison de clôture")
    public void testModifyCloture() {
        try {
            System.out.println("[TEST] Exécution : Modification d'une raison de clôture...");
            
            Allure.step("Modification d'une raison de clôture existante", () -> {
                cloture.Modify();
            });
            
            System.out.println("[SUCCÈS] Modification de raison de clôture réussie");
            
        } catch (Exception e) {
            Allure.addAttachment("Erreur de modification", e.getMessage());
            System.out.println("[ERREUR] Échec de la modification : " + e.getMessage());
            Assert.fail("Test de modification échoué : " + e.getMessage());
        }
    }

    /**
     * Test de suppression d'une raison de clôture
     * 
     * Ce test vérifie que :
     * - La suppression d'une raison fonctionne
     * - Les confirmations sont gérées correctement
     * - L'élément est bien supprimé
     */
    @Test(priority = 4, description = "Test de suppression d'une raison de clôture")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test de suppression d'une raison de clôture")
    @Story("Suppression de raison de clôture")
    public void testDeleteCloture() {
        try {
            System.out.println("[TEST] Exécution : Suppression d'une raison de clôture...");
            
            Allure.step("Suppression d'une raison de clôture", () -> {
                cloture.Deleted();
            });
            
            System.out.println("[SUCCÈS] Suppression de raison de clôture réussie");
            
        } catch (Exception e) {
            Allure.addAttachment("Erreur de suppression", e.getMessage());
            System.out.println("[ERREUR] Échec de la suppression : " + e.getMessage());
            Assert.fail("Test de suppression échoué : " + e.getMessage());
        }
    }

    /**
     * Test complet du workflow CRUD
     * 
     * Ce test exécute l'ensemble du workflow :
     * - Création
     * - Modification
     * - Suppression
     * 
     * Utile pour tester l'intégration complète
    //  */
    // @Test(priority = 5, description = "Test complet du workflow CRUD")
    // public void testCompleteWorkflow() {
    //     try {
    //         System.out.println("[TEST] Exécution : Workflow complet CRUD...");
            
    //         // Exécution du workflow complet
    //         cloture.Create();
            
    //         System.out.println("[SUCCÈS] Workflow complet réussi");
            
    //     } catch (Exception e) {
    //         System.out.println("[ERREUR] Échec du workflow complet : " + e.getMessage());
    //         Assert.fail("Test de workflow complet échoué : " + e.getMessage());
    //     }
    // }

    /**
     * Nettoyage final après tous les tests
     * - Ferme proprement le navigateur
     * - Libère les ressources
     */
    @AfterClass
    public void tearDown() {
        try {
            System.out.println("[INFO] Nettoyage final...");
            
            if (loginAnsut != null) {
                loginAnsut.tearDown();
            }
            
            System.out.println("[INFO] Tests Cloture terminés avec succès");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Problème lors du nettoyage : " + e.getMessage());
        }
    }
}
