package com.ansut;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.ansut.Login.LoginAnsut;

import io.qameta.allure.Description;

/**
 * Classe de test TestNG pour le module de connexion (Login)
 * 
 * Cette classe teste la fonctionnalité de connexion de base :
 * - Connexion réussie avec des identifiants valides
 * 
 * Structure de test :
 * 1. Setup : Initialisation du driver Chrome
 * 2. Tests : Exécution de la connexion
 * 3. Teardown : Fermeture propre du navigateur
 */
public class LoginAnsutTest {

    private LoginAnsut loginAnsut;
    private WebDriver driver;

    /**
     * Configuration initiale avant tous les tests de la classe
     * - Initialise le driver Chrome
     * - Se connecte à l'application
     */
    // @BeforeClass
    // public void setUp() {
    //     try {
    //         System.out.println("[INFO] Démarrage des tests de connexion...");
            
    //         // Initialisation de la connexion
    //         loginAnsut = new LoginAnsut();
    //         loginAnsut.setUp();
    //         loginAnsut.login("Exp", "K4dk272001@");
            
    //         // Récupération du driver pour les tests
    //         driver = loginAnsut.getDriver();
            
    //         System.out.println("[INFO] Configuration terminée - Prêt pour les tests de connexion");
            
    //     } catch (Exception e) {
    //         System.out.println("[ERREUR] Échec de la configuration : " + e.getMessage());
    //         Assert.fail("Configuration échouée : " + e.getMessage());
    //     }
    // }

    /**
     * Test de connexion réussie avec des identifiants valides
     * 
     * Ce test vérifie que :
     * - La connexion avec des identifiants valides réussit
     * - L'utilisateur est connecté à l'application
     */
    @Description("Test de connexion réussie avec des identifiants valides")
    @Test(description = "Test de connexion réussie avec des identifiants valides")
    public void testLoginSuccess() {
        try {
            System.out.println("[TEST] Exécution : Test de connexion réussie...");
            
            // loginAnsut.setUp();
            loginAnsut = new LoginAnsut();
            loginAnsut.setUp();
            loginAnsut.login("Exp", "K4dk272001@");
            // Vérification que l'utilisateur est connecté
            String currentUrl = driver.getCurrentUrl();
            

            // Vérification que l'URL contient des éléments attendus
            Assert.assertTrue(
                currentUrl.contains("#/gestionticket") || currentUrl.contains("#/parametres/section"),
                "L'URL doit contenir des éléments indiquant une connexion réussie. URL actuelle : " + currentUrl
            );
            
            System.out.println("[SUCCÈS] Connexion réussie - URL : " + currentUrl);
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la connexion : " + e.getMessage());
            Assert.fail("Test de connexion échoué : " + e.getMessage());
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
            
            System.out.println("[INFO] Tests de connexion terminés avec succès");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Problème lors du nettoyage : " + e.getMessage());
        }
    }
}
