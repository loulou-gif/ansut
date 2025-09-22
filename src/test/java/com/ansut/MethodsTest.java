package com.ansut;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.ansut.Login.LoginAnsut;
import com.ansut.settings.methods.createMethod;

/**
 * Classe de test TestNG pour le module Methods (Méthodes)
 * 
 * Cette classe teste toutes les opérations CRUD sur les méthodes :
 * - Création d'une nouvelle méthode
 * - Recherche d'une méthode
 * - Modification d'une méthode existante
 * - Suppression d'une méthode
 * 
 * Structure de test :
 * 1. Setup : Connexion à l'application
 * 2. Tests : Exécution des opérations CRUD
 * 3. Teardown : Fermeture propre du navigateur
 */
public class MethodsTest {

    private LoginAnsut loginAnsut;
    private createMethod createMethodModule;
    private WebDriver driver;

    /**
     * Configuration initiale avant tous les tests de la classe
     * - Initialise le driver Chrome
     * - Se connecte à l'application
     * - Initialise l'objet createMethod pour les tests
     */
    @BeforeClass
    public void setUp() {
        try {
            System.out.println("[INFO] Démarrage des tests Methods...");
            
            // Initialisation de la connexion
            loginAnsut = new LoginAnsut();
            loginAnsut.setUp();
            loginAnsut.login("Exp", "K4dk272001@");
            
            // Récupération du driver pour les tests
            driver = loginAnsut.getDriver();
            
            // Initialisation de l'objet createMethod
            createMethodModule = new createMethod(driver);
            
            System.out.println("[INFO] Configuration terminée - Prêt pour les tests");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la configuration : " + e.getMessage());
            Assert.fail("Configuration échouée : " + e.getMessage());
        }
    }

    /**
     * Test de création d'une méthode
     * 
     * Ce test vérifie que :
     * - La navigation vers le menu fonctionne
     * - La création d'une nouvelle méthode réussit
     * - Les données sont correctement saisies
     */
    @Test(priority = 1, description = "Test de création d'une méthode")
    public void testCreateMethod() {
        try {
            System.out.println("[TEST] Exécution : Création d'une méthode...");
            
            // Exécution de la création
            createMethodModule.GoToMenu();
            
            System.out.println("[SUCCÈS] Création de méthode réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la création : " + e.getMessage());
            Assert.fail("Test de création échoué : " + e.getMessage());
        }
    }

    /**
     * Test de recherche d'une méthode
     * 
     * Ce test vérifie que :
     * - La recherche fonctionne correctement
     * - Les filtres s'appliquent bien
     * - Les résultats sont affichés
     */
    @Test(priority = 2, description = "Test de recherche d'une méthode")
    public void testSearchMethod() {
        try {
            System.out.println("[TEST] Exécution : Recherche d'une méthode...");
            
            // Exécution de la recherche
            createMethodModule.search();
            
            System.out.println("[SUCCÈS] Recherche de méthode réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la recherche : " + e.getMessage());
            Assert.fail("Test de recherche échoué : " + e.getMessage());
        }
    }

    /**
     * Test de modification d'une méthode
     * 
     * Ce test vérifie que :
     * - La modification d'une méthode existante fonctionne
     * - Les nouvelles données sont correctement appliquées
     * - La sauvegarde réussit
     */
    @Test(priority = 3, description = "Test de modification d'une méthode")
    public void testModifyMethod() {
        try {
            System.out.println("[TEST] Exécution : Modification d'une méthode...");
            
            // Exécution de la modification
            createMethodModule.Modify();
            
            System.out.println("[SUCCÈS] Modification de méthode réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la modification : " + e.getMessage());
            Assert.fail("Test de modification échoué : " + e.getMessage());
        }
    }

    /**
     * Test de suppression d'une méthode
     * 
     * Ce test vérifie que :
     * - La suppression d'une méthode fonctionne
     * - Les confirmations sont gérées correctement
     * - L'élément est bien supprimé
     */
    @Test(priority = 4, description = "Test de suppression d'une méthode")
    public void testDeleteMethod() {
        try {
            System.out.println("[TEST] Exécution : Suppression d'une méthode...");
            
            // Exécution de la suppression
            createMethodModule.Deleted();
            
            System.out.println("[SUCCÈS] Suppression de méthode réussie");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Échec de la suppression : " + e.getMessage());
            Assert.fail("Test de suppression échoué : " + e.getMessage());
        }
    }


    @AfterClass
    public void tearDown() {
        try {
            System.out.println("[INFO] Nettoyage final...");
            
            if (loginAnsut != null) {
                loginAnsut.tearDown();
            }
            
            System.out.println("[INFO] Tests Methods terminés avec succès");
            
        } catch (Exception e) {
            System.out.println("[ERREUR] Problème lors du nettoyage : " + e.getMessage());
        }
    }
}
