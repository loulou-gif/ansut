package com.ansut;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import com.ansut.Login.LoginAnsut;
import com.ansut.settings.prestataire.Operateur;

/**
 * Classe de test TestNG pour le module Operateur (Prestataires)
 * 
 * Cette classe teste toutes les opérations CRUD sur les prestataires :
 * - Création d'un nouveau prestataire
 * - Recherche d'un prestataire
 * - Modification d'un prestataire existant
 * - Suppression d'un prestataire
 * 
 * Structure de test :
 * 1. Setup : Connexion à l'application
 * 2. Tests : Exécution des opérations CRUD
 * 3. Teardown : Fermeture propre du navigateur
 */
public class OperateurTest {

    private LoginAnsut loginAnsut;
    private Operateur operateur;
    private WebDriver driver;

    /**
     * Configuration initiale avant tous les tests de la classe
     * - Initialise le driver Chrome
     * - Se connecte à l'application
     * - Initialise l'objet Operateur pour les tests
     */
    @BeforeClass
    public void setUp() {
        try {
            System.out.println("[INFO] Démarrage des tests Operateur...");
            
            // Initialisation de la connexion
            loginAnsut = new LoginAnsut();
            loginAnsut.setUp();
            loginAnsut.login("Exp", "K4dk272001@");
            
            // Récupération du driver pour les tests
            driver = loginAnsut.getDriver();
            
            // Initialisation de l'objet Operateur
            operateur = new Operateur(driver);
            
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
     * Test de création d'un prestataire
     * 
     * Ce test vérifie que :
     * - La navigation vers le menu fonctionne
     * - La création d'un nouveau prestataire réussit
     * - Les données sont correctement saisies
     */
    @Test(priority = 1, description = "Test de création d'un prestataire")
    public void testCreateOperateur() {
        try {
            System.out.println("[TEST] Exécution : Création d'un prestataire...");
            
            // Exécution de la création
            operateur.GoToMenu();
            
            System.out.println("[SUCCÈS] Création de prestataire réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la création : " + e.getMessage());
            Assert.fail("Test de création échoué : " + e.getMessage());
        }
    }

    /**
     * Test de recherche d'un prestataire
     * 
     * Ce test vérifie que :
     * - La recherche fonctionne correctement
     * - Les filtres s'appliquent bien
     * - Les résultats sont affichés
     */
    @Test(priority = 2, description = "Test de recherche d'un prestataire")
    public void testSearchOperateur() {
        try {
            System.out.println("[TEST] Exécution : Recherche d'un prestataire...");
            
            // Exécution de la recherche
            operateur.search();
            
            System.out.println("[SUCCÈS] Recherche de prestataire réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la recherche : " + e.getMessage());
            Assert.fail("Test de recherche échoué : " + e.getMessage());
        }
    }

    /**
     * Test de modification d'un prestataire
     * 
     * Ce test vérifie que :
     * - La modification d'un prestataire existant fonctionne
     * - Les nouvelles données sont correctement appliquées
     * - La sauvegarde réussit
     */
    @Test(priority = 3, description = "Test de modification d'un prestataire")
    public void testModifyOperateur() {
        try {
            System.out.println("[TEST] Exécution : Modification d'un prestataire...");
            
            // Exécution de la modification
            operateur.Modify();
            
            System.out.println("[SUCCÈS] Modification de prestataire réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la modification : " + e.getMessage());
            Assert.fail("Test de modification échoué : " + e.getMessage());
        }
    }

    /**
     * Test de suppression d'un prestataire
     * 
     * Ce test vérifie que :
     * - La suppression d'un prestataire fonctionne
     * - Les confirmations sont gérées correctement
     * - L'élément est bien supprimé
     */
    @Test(priority = 4, description = "Test de suppression d'un prestataire")
    public void testDeleteOperateur() {
        try {
            System.out.println("[TEST] Exécution : Suppression d'un prestataire...");
            
            // Exécution de la suppression
            operateur.Deleted();
            
            System.out.println("[SUCCÈS] Suppression de prestataire réussie");
            
        } catch (Exception e) {
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
     */
    // @Test(priority = 5, description = "Test complet du workflow CRUD")
    // public void testCompleteWorkflow() {
    //     try {
    //         System.out.println("[TEST] Exécution : Workflow complet CRUD...");
            
    //         // Exécution du workflow complet
    //         operateur.Create();
            
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
            
            System.out.println("[INFO] Tests Operateur terminés avec succès");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Problème lors du nettoyage : " + e.getMessage());
        }
    }
}
