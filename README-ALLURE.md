# Configuration Allure pour le Projet ANSUT

Ce document explique comment utiliser et configurer Allure pour générer des rapports de tests détaillés.

## 📋 Prérequis

- Java 8 ou supérieur
- Maven 3.6 ou supérieur
- Chrome/ChromeDriver (pour les tests Selenium)

## 🚀 Utilisation Rapide

### 1. Exécuter tous les tests et générer le rapport
```batch
run-allure-tests.bat
```

### 2. Générer uniquement le rapport (après exécution des tests)
```batch
generate-allure-report.bat
```

### 3. Ouvrir le rapport Allure
```batch
serve-allure-report.bat
```

### 4. Valider la configuration
```batch
validate-allure-config.bat
```

## 📁 Structure des Fichiers

```
ansut/
├── src/test/java/com/ansut/          # Classes de test avec annotations Allure
├── allure.properties                  # Configuration principale d'Allure
├── allure-environment.properties     # Informations sur l'environnement
├── allure-categories.json            # Catégories de défauts
├── testng.xml                        # Configuration TestNG avec listener Allure
├── pom.xml                           # Configuration Maven avec plugin Allure
└── *.bat                             # Scripts d'automatisation
```

## 🏷️ Annotations Allure Utilisées

### Annotations de Classe
- `@Epic` : Groupe de fonctionnalités (ex: "Gestion des Paramètres")
- `@Feature` : Fonctionnalité spécifique (ex: "Raisons de Clôture")
- `@Story` : User story (ex: "Opérations CRUD")

### Annotations de Méthode
- `@Test` : Méthode de test TestNG
- `@Description` : Description détaillée du test
- `@Severity` : Niveau de criticité (CRITICAL, NORMAL, MINOR, TRIVIAL, BLOCKER)
- `@Story` : User story spécifique au test

### Fonctionnalités Avancées
- `Allure.step()` : Définition d'étapes dans les tests
- `Allure.addAttachment()` : Ajout d'attachements (screenshots, logs, etc.)

## 📊 Types de Rapports Générés

### 1. Rapport HTML Statique
- **Localisation** : `target/allure-report/index.html`
- **Usage** : Double-clic pour ouvrir dans le navigateur
- **Avantages** : Portable, peut être partagé

### 2. Serveur Allure Local
- **Commande** : `serve-allure-report.bat`
- **Usage** : Serveur web local avec auto-refresh
- **Avantages** : Mise à jour automatique des résultats

## 🔧 Configuration Avancée

### Personnalisation des Catégories
Modifiez `allure-categories.json` pour définir vos propres catégories de défauts.

### Configuration de l'Environnement
Modifiez `allure-environment.properties` pour décrire votre environnement de test.

### Liens Externes
Configurez les patterns de liens dans `allure.properties` :
```properties
allure.link.issue.pattern=https://github.com/your-repo/issues/{}
allure.link.tms.pattern=https://github.com/your-repo/tms/{}
```

## 📈 Exemples d'Annotations

### Classe de Test Complète
```java
@Epic("Gestion des Paramètres")
@Feature("Raisons de Clôture")
@Story("Opérations CRUD sur les raisons de clôture")
public class ClotureTest {
    
    @Test(priority = 1, description = "Test de création d'une raison de clôture")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test de création d'une nouvelle raison de clôture dans l'application")
    @Story("Création de raison de clôture")
    public void testCreateCloture() {
        Allure.step("Navigation vers le menu des raisons de clôture", () -> {
            cloture.GoToMenu();
        });
        
        // En cas d'erreur
        Allure.addAttachment("Erreur de création", e.getMessage());
    }
}
```

## 🐛 Dépannage

### Problème : "Aucun résultat de test trouvé"
**Solution** : Exécutez d'abord les tests avec `mvn test`

### Problème : "Plugin Allure non trouvé"
**Solution** : Vérifiez que les dépendances Allure sont dans le `pom.xml`

### Problème : "Rapport ne s'ouvre pas"
**Solution** : Utilisez `serve-allure-report.bat` au lieu d'ouvrir directement le HTML

### Problème : "Tests sans annotations Allure"
**Solution** : Ajoutez les annotations `@Epic`, `@Feature`, `@Story`, `@Severity`, `@Description`

## 📋 Checklist de Validation

- [ ] Maven installé et configuré
- [ ] Dépendances Allure dans `pom.xml`
- [ ] Listener Allure dans `testng.xml`
- [ ] Annotations Allure dans les classes de test
- [ ] Scripts `.bat` fonctionnels
- [ ] Fichiers de configuration présents
- [ ] Tests exécutables avec `mvn test`
- [ ] Rapport générable avec `mvn allure:report`

## 🔗 Liens Utiles

- [Documentation Allure](https://docs.qameta.io/allure/)
- [Allure TestNG Integration](https://docs.qameta.io/allure/#_testng)
- [Annotations Allure](https://docs.qameta.io/allure/#_annotations)
- [Maven Plugin Allure](https://docs.qameta.io/allure/#_maven)

