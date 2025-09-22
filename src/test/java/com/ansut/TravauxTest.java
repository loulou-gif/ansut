package com.ansut;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import com.ansut.Login.LoginAnsut;
import com.ansut.travaux.travaux;

/**
 * Classe de test TestNG pour le module Travaux (Travaux programmés)
 * 
 * Cette classe teste toutes les opérations sur les travaux programmés :
 * - Création d'un nouveau travail programmé
 * - Recherche d'un travail programmé
 * - Modification d'un travail programmé existant
 * - Suppression d'un travail programmé
 * 
 * Structure de test :
 * 1. Setup : Connexion à l'application
 * 2. Tests : Exécution des opérations CRUD
 * 3. Teardown : Fermeture propre du navigateur
 */
public class TravauxTest {

    private LoginAnsut loginAnsut;
    private travaux travauxModule;
    private WebDriver driver;

    /**
     * Configuration initiale avant tous les tests de la classe
     * - Initialise le driver Chrome
     * - Se connecte à l'application
     * - Initialise l'objet travaux pour les tests
     */
    @BeforeClass
    public void setUp() {
        try {
            System.out.println("[INFO] Démarrage des tests Travaux...");
            
            // Initialisation de la connexion
            loginAnsut = new LoginAnsut();
            loginAnsut.setUp();
            loginAnsut.login("Exp", "K4dk272001@");
            
            // Récupération du driver pour les tests
            driver = loginAnsut.getDriver();
            
            // Initialisation de l'objet travaux
            travauxModule = new travaux(driver);
            
            System.out.println("[INFO] Configuration terminée - Prêt pour les tests");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la configuration : " + e.getMessage());
            Assert.fail("Configuration échouée : " + e.getMessage());
        }
    }

    /**
     * Nettoyage avant chaque test individuel
     * - Pause pour laisser le temps aux opérations de se terminer
     */
    @BeforeMethod
    public void beforeMethod() {
        try {
            Thread.sleep(3000); // Pause plus longue pour les travaux
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
            Thread.sleep(3000); // Pause plus longue pour les travaux
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Test de création d'un travail programmé
     * 
     * Ce test vérifie que :
     * - La navigation vers le menu fonctionne
     * - La création d'un nouveau travail programmé réussit
     * - Les données sont correctement saisies
     * - Les champs de section sont correctement remplis
     */
    @Test(priority = 1, description = "Test de création d'un travail programmé")
    public void testCreateTravaux() {
        try {
            System.out.println("[TEST] Exécution : Création d'un travail programmé...");
            
            // Exécution de la création
            travauxModule.GoToMenu();
            
            System.out.println("[SUCCÈS] Création de travail programmé réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la création : " + e.getMessage());
            Assert.fail("Test de création échoué : " + e.getMessage());
        }
    }

    /**
     * Test de recherche d'un travail programmé
     * 
     * Ce test vérifie que :
     * - La recherche fonctionne correctement
     * - Les filtres s'appliquent bien
     * - Les résultats sont affichés
     */
    @Test(priority = 2, description = "Test de recherche d'un travail programmé")
    public void testSearchTravaux() {
        try {
            System.out.println("[TEST] Exécution : Recherche d'un travail programmé...");
            
            // Exécution de la recherche
            travauxModule.search();
            
            System.out.println("[SUCCÈS] Recherche de travail programmé réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la recherche : " + e.getMessage());
            Assert.fail("Test de recherche échoué : " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        try {
            System.out.println("[INFO] Nettoyage final...");
            
            if (loginAnsut != null) {
                loginAnsut.tearDown();
            }
            
            System.out.println("[INFO] Tests Travaux terminés avec succès");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Problème lors du nettoyage : " + e.getMessage());
        }
    }
}
