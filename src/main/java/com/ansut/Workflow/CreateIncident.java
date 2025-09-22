package com.ansut.Workflow;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Description;

@Epic("Workflow")
@Feature("Gestion des incidents")
@Story("Opérations CRUD sur les incidents")
public class CreateIncident {

    private WebDriver driver;

    public CreateIncident(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Remplissage du formulaire d'incident")
    @Description("Remplissage du formulaire d'incident")
    @Severity(SeverityLevel.NORMAL)
    public void fillForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions actions = new Actions(driver);

        try {
            // Menu "Création de ticket"
            wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"sidebar\"]/div/div[2]/ul/li[2]/div/span"))
            ).click();

            // Type de ticket
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"typeTicket\"]/div/div/div[3]/input"))
            ).sendKeys("incid");
            wait.until(ExpectedConditions.elementToBeClickable(
                By.className("ng-option"))
            ).click();

            // Client impacté
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"clientImpacte\"]/div/div/div[3]/input"))
            ).sendKeys("ORAN");
            wait.until(ExpectedConditions.elementToBeClickable(
                By.className("ng-option"))
            ).click();

            // Sujet
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("sujetIncident"))
            ).sendKeys("Automate test");

            // Détails
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("detailsIncident"))
            ).sendKeys("Détails d'un tests automatisé par Julius Konan");

            // Canal
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"canalInitiateur\"]/div/div/div[3]/input"))
            ).sendKeys("web");
            wait.until(ExpectedConditions.elementToBeClickable(
                By.className("ng-option"))
            ).click();

            // Équipement
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"equipement\"]/div/div/div[3]/input"))
            ).sendKeys("section");
            wait.until(ExpectedConditions.elementToBeClickable(
                By.className("ng-option"))
            ).click();

            // Affecté à
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"section\"]/div/div/div[3]/input"))
            ).sendKeys("TEST-SAM");

            Thread.sleep(30);
            wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'TEST-SAM')]"))
            ).click();

            Thread.sleep(30);
            // Valider
            actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

            Thread.sleep(30);

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[2]/div/div[6]/button[1]")
            )).sendKeys(Keys.ENTER);

            Thread.sleep(40000);

            System.out.println("✅ Formulaire de création d'incident rempli avec succès.");

        } catch (Exception e) {
            System.out.println("❌ Erreur lors du remplissage du formulaire : " + e.getMessage());
        }
    }
}
