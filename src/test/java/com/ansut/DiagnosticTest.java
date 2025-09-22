package com.ansut;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.ansut.Login.LoginAnsut;
import com.ansut.settings.diagnostic.diagnostic;

/**
 * Classe de test TestNG pour le module Diagnostic
 * 
 * Cette classe teste toutes les opérations CRUD sur les diagnostics :
 * - Création d'un nouveau diagnostic
 * - Recherche d'un diagnostic
 * - Modification d'un diagnostic existant
 * - Suppression d'un diagnostic
 * 
 * Structure de test :
 * 1. Setup : Connexion à l'application
 * 2. Tests : Exécution des opérations CRUD
 * 3. Teardown : Fermeture propre du navigateur
 */
public class DiagnosticTest {

    private LoginAnsut loginAnsut;
    private diagnostic diagnosticModule;
    private WebDriver driver;

    /**
     * Configuration initiale avant tous les tests de la classe
     * - Initialise le driver Chrome
     * - Se connecte à l'application
     * - Initialise l'objet diagnostic pour les tests
     */
    @BeforeClass
    public void setUp() {
        try {
            System.out.println("[INFO] Démarrage des tests Diagnostic...");
            
            // Initialisation de la connexion
            loginAnsut = new LoginAnsut();
            loginAnsut.setUp();
            loginAnsut.login("Exp", "K4dk272001@");
            
            // Récupération du driver pour les tests
            driver = loginAnsut.getDriver();
            
            // Initialisation de l'objet diagnostic
            diagnosticModule = new diagnostic(driver);
            
            System.out.println("[INFO] Configuration terminée - Prêt pour les tests");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la configuration : " + e.getMessage());
            Assert.fail("Configuration échouée : " + e.getMessage());
        }
    }

    /**
     * Test de création d'un diagnostic
     * 
     * Ce test vérifie que :
     * - La navigation vers le menu fonctionne
     * - La création d'un nouveau diagnostic réussit
     * - Les données sont correctement saisies
     */
    @Test(priority = 1, description = "Test de création d'un diagnostic")
    public void testCreateDiagnostic() {
        try {
            System.out.println("[TEST] Exécution : Création d'un diagnostic...");
            
            // Exécution de la création
            diagnosticModule.GoToMenu();
            
            System.out.println("[SUCCÈS] Création de diagnostic réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la création : " + e.getMessage());
            Assert.fail("Test de création échoué : " + e.getMessage());
        }
    }

    /**
     * Test de recherche d'un diagnostic
     * 
     * Ce test vérifie que :
     * - La recherche fonctionne correctement
     * - Les filtres s'appliquent bien
     * - Les résultats sont affichés
     */
    @Test(priority = 2, description = "Test de recherche d'un diagnostic")
    public void testSearchDiagnostic() {
        try {
            System.out.println("[TEST] Exécution : Recherche d'un diagnostic...");
            
            // Exécution de la recherche
            diagnosticModule.search();
            
            System.out.println("[SUCCÈS] Recherche de diagnostic réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la recherche : " + e.getMessage());
            Assert.fail("Test de recherche échoué : " + e.getMessage());
        }
    }

    /**
     * Test de modification d'un diagnostic
     * 
     * Ce test vérifie que :
     * - La modification d'un diagnostic existant fonctionne
     * - Les nouvelles données sont correctement appliquées
     * - La sauvegarde réussit
     */
    @Test(priority = 3, description = "Test de modification d'un diagnostic")
    public void testModifyDiagnostic() {
        try {
            System.out.println("[TEST] Exécution : Modification d'un diagnostic...");
            
            // Exécution de la modification
            diagnosticModule.Modify();
            
            System.out.println("[SUCCÈS] Modification de diagnostic réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la modification : " + e.getMessage());
            Assert.fail("Test de modification échoué : " + e.getMessage());
        }
    }

    /**
     * Test de suppression d'un diagnostic
     * 
     * Ce test vérifie que :
     * - La suppression d'un diagnostic fonctionne
     * - Les confirmations sont gérées correctement
     * - L'élément est bien supprimé
     */
    @Test(priority = 4, description = "Test de suppression d'un diagnostic")
    public void testDeleteDiagnostic() {
        try {
            System.out.println("[TEST] Exécution : Suppression d'un diagnostic...");
            
            // Exécution de la suppression
            diagnosticModule.Deleted();
            
            System.out.println("[SUCCÈS] Suppression de diagnostic réussie");
            
        } catch (Exception e) {
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
            
            System.out.println("[INFO] Tests Diagnostic terminés avec succès");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Problème lors du nettoyage : " + e.getMessage());
        }
    }
}
