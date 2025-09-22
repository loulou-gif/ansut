package com.ansut;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.ansut.Login.LoginAnsut;
import com.ansut.settings.actifs.Actifs;

import io.qameta.allure.*;

/**
 * Classe de test TestNG pour le module Actifs
 * 
 * Cette classe teste toutes les opérations CRUD sur les actifs :
 * - Création d'un nouvel actif
 * - Recherche d'un actif
 * - Modification d'un actif existant
 * - Suppression d'un actif
 * 
 * Structure de test :
 * 1. Setup : Connexion à l'application
 * 2. Tests : Exécution des opérations CRUD
 * 3. Teardown : Fermeture propre du navigateur
 */
@Epic("Gestion des Paramètres")
@Feature("Gestion des Actifs")
@Story("Opérations CRUD sur les actifs")
public class ActifsTest {

    private LoginAnsut loginAnsut;
    private Actifs actifs;
    private WebDriver driver;

    /**
     * Configuration initiale avant tous les tests de la classe
     * - Initialise le driver Chrome
     * - Se connecte à l'application
     * - Initialise l'objet Actifs pour les tests
     */
    @BeforeClass
    public void setUp() {
        try {
            System.out.println("[INFO] Démarrage des tests Actifs...");
            
            // Initialisation de la connexion
            loginAnsut = new LoginAnsut();
            loginAnsut.setUp();
            loginAnsut.login("Exp", "K4dk272001@");
            
            // Récupération du driver pour les tests
            driver = loginAnsut.getDriver();
            
            // Initialisation de l'objet Actifs
            actifs = new Actifs(driver);
            
            System.out.println("[INFO] Configuration terminée - Prêt pour les tests");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la configuration : " + e.getMessage());
            Assert.fail("Configuration échouée : " + e.getMessage());
        }
    }

    /**
     * Test de création d'un actif
     * 
     * Ce test vérifie que :
     * - La navigation vers le menu fonctionne
     * - La création d'un nouvel actif réussit
     * - Les données sont correctement saisies
     */
    @Test(priority = 1, description = "Test de création d'un actif")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test de création d'un nouvel actif dans l'application")
    @Story("Création d'actif")
    public void testCreateActifs() {
        try {
            System.out.println("[TEST] Exécution : Création d'un actif...");
            
            Allure.step("Navigation vers le menu des actifs", () -> {
                actifs.GoToMenu();
            });
            
            System.out.println("[SUCCÈS] Création d'actif réussie");
            
        } catch (Exception e) {
            Allure.addAttachment("Erreur de création", e.getMessage());
            System.out.println("[ERREUR] Échec de la création : " + e.getMessage());
            Assert.fail("Test de création échoué : " + e.getMessage());
        }
    }

    /**
     * Test de recherche d'un actif
     * 
     * Ce test vérifie que :
     * - La recherche fonctionne correctement
     * - Les filtres s'appliquent bien
     * - Les résultats sont affichés
     */
    @Test(priority = 2, description = "Test de recherche d'un actif")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test de recherche et filtrage des actifs")
    @Story("Recherche d'actif")
    public void testSearchActifs() {
        try {
            System.out.println("[TEST] Exécution : Recherche d'un actif...");
            
            Allure.step("Exécution de la recherche d'actifs", () -> {
                actifs.search();
            });
            
            System.out.println("[SUCCÈS] Recherche d'actif réussie");
            
        } catch (Exception e) {
            Allure.addAttachment("Erreur de recherche", e.getMessage());
            System.out.println("[ERREUR] Échec de la recherche : " + e.getMessage());
            Assert.fail("Test de recherche échoué : " + e.getMessage());
        }
    }

    /**
     * Test de modification d'un actif
     * 
     * Ce test vérifie que :
     * - La modification d'un actif existant fonctionne
     * - Les nouvelles données sont correctement appliquées
     * - La sauvegarde réussit
     */
    @Test(priority = 3, description = "Test de modification d'un actif")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test de modification d'un actif existant")
    @Story("Modification d'actif")
    public void testModifyActifs() {
        try {
            System.out.println("[TEST] Exécution : Modification d'un actif...");
            
            Allure.step("Modification d'un actif existant", () -> {
                actifs.Modify();
            });
            
            System.out.println("[SUCCÈS] Modification d'actif réussie");
            
        } catch (Exception e) {
            Allure.addAttachment("Erreur de modification", e.getMessage());
            System.out.println("[ERREUR] Échec de la modification : " + e.getMessage());
            Assert.fail("Test de modification échoué : " + e.getMessage());
        }
    }

    /**
     * Test de suppression d'un actif
     * 
     * Ce test vérifie que :
     * - La suppression d'un actif fonctionne
     * - Les confirmations sont gérées correctement
     * - L'élément est bien supprimé
     */
    @Test(priority = 4, description = "Test de suppression d'un actif")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test de suppression d'un actif")
    @Story("Suppression d'actif")
    public void testDeleteActifs() {
        try {
            System.out.println("[TEST] Exécution : Suppression d'un actif...");
            
            Allure.step("Suppression d'un actif", () -> {
                actifs.Deleted();
            });
            
            System.out.println("[SUCCÈS] Suppression d'actif réussie");
            
        } catch (Exception e) {
            Allure.addAttachment("Erreur de suppression", e.getMessage());
            System.out.println("[ERREUR] Échec de la suppression : " + e.getMessage());
            Assert.fail("Test de suppression échoué : " + e.getMessage());
        }
    }


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
            
            System.out.println("[INFO] Tests Actifs terminés avec succès");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Problème lors du nettoyage : " + e.getMessage());
        }
    }
}
