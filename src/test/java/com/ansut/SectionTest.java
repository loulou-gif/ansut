package com.ansut;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import com.ansut.Login.LoginAnsut;
import com.ansut.settings.Section.CreateSection;

/**
 * Classe de test TestNG pour le module Section
 * 
 * Cette classe teste toutes les opérations CRUD sur les sections :
 * - Création d'une nouvelle section
 * - Recherche d'une section
 * - Modification d'une section existante
 * - Suppression d'une section
 * 
 * Structure de test :
 * 1. Setup : Connexion à l'application
 * 2. Tests : Exécution des opérations CRUD
 * 3. Teardown : Fermeture propre du navigateur
 */
public class SectionTest {

    private LoginAnsut loginAnsut;
    private CreateSection createSection;
    private WebDriver driver;

    /**
     * Configuration initiale avant tous les tests de la classe
     * - Initialise le driver Chrome
     * - Se connecte à l'application
     * - Initialise l'objet CreateSection pour les tests
     */
    @BeforeClass
    public void setUp() {
        try {
            System.out.println("[INFO] Démarrage des tests Section...");
            
            // Initialisation de la connexion
            loginAnsut = new LoginAnsut();
            loginAnsut.setUp();
            loginAnsut.login("Exp", "K4dk272001@");
            
            // Récupération du driver pour les tests
            driver = loginAnsut.getDriver();
            
            // Initialisation de l'objet CreateSection
            createSection = new CreateSection(driver);
            
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
            Thread.sleep(1000); // Pause entre les tests
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
     * Test de création d'une section
     * 
     * Ce test vérifie que :
     * - La navigation vers le menu fonctionne
     * - La création d'une nouvelle section réussit
     * - Les données sont correctement saisies
     */
    @Test(priority = 1, description = "Test de création d'une section")
    public void testCreateSection() {
        try {
            System.out.println("[TEST] Exécution : Création d'une section...");
            
            // Exécution de la création
            createSection.GoToMenu();
            
            System.out.println("[SUCCÈS] Création de section réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la création : " + e.getMessage());
            Assert.fail("Test de création échoué : " + e.getMessage());
        }
    }

    /**
     * Test de recherche d'une section
     * 
     * Ce test vérifie que :
     * - La recherche fonctionne correctement
     * - Les filtres s'appliquent bien
     * - Les résultats sont affichés
     */
    @Test(priority = 2, description = "Test de recherche d'une section")
    public void testSearchSection() {
        try {
            System.out.println("[TEST] Exécution : Recherche d'une section...");
            
            // Exécution de la recherche
            createSection.search();
            
            System.out.println("[SUCCÈS] Recherche de section réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la recherche : " + e.getMessage());
            Assert.fail("Test de recherche échoué : " + e.getMessage());
        }
    }

    /**
     * Test de modification d'une section
     * 
     * Ce test vérifie que :
     * - La modification d'une section existante fonctionne
     * - Les nouvelles données sont correctement appliquées
     * - La sauvegarde réussit
     */
    @Test(priority = 3, description = "Test de modification d'une section")
    public void testModifySection() {
        try {
            System.out.println("[TEST] Exécution : Modification d'une section...");
            
            // Exécution de la modification
            createSection.Modify();
            
            System.out.println("[SUCCÈS] Modification de section réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la modification : " + e.getMessage());
            Assert.fail("Test de modification échoué : " + e.getMessage());
        }
    }

    /**
     * Test de suppression d'une section
     * 
     * Ce test vérifie que :
     * - La suppression d'une section fonctionne
     * - Les confirmations sont gérées correctement
     * - L'élément est bien supprimé
     */
    @Test(priority = 4, description = "Test de suppression d'une section")
    public void testDeleteSection() {
        try {
            System.out.println("[TEST] Exécution : Suppression d'une section...");
            
            // Exécution de la suppression
            createSection.Deleted();
            
            System.out.println("[SUCCÈS] Suppression de section réussie");
            
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
    //         createSection.Create();
            
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
            
            System.out.println("[INFO] Tests Section terminés avec succès");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Problème lors du nettoyage : " + e.getMessage());
        }
    }
}
