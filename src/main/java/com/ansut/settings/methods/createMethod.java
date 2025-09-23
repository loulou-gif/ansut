package com.ansut.settings.methods;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

@Epic("Paramétrage")
@Feature("Gestion des méthodes de diagnostics")
@Story("Opérations CRUD sur les méthodes de diagnostics")
public class createMethod {
    
   
    private WebDriver driver;
    
    public createMethod(WebDriver driver){
        this.driver = driver;
    }

    @Step("Navigation vers le menu des méthodes de diagnostics")
    @Description("Navigation vers le menu paramètres et l'onglet méthodes de diagnostics pour créer une méthode de diagnostic")
    @Severity(SeverityLevel.NORMAL)
    public void GoToMenu() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("#sidebar > div > div.sidebar > div > li:nth-child(1)")
            )
        ).click();
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tabs-container > ul > li:nth-child(3) > a")
            )
        ).click();

        WebElement button = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "btn-user"
                )
            )
        );
        button.click();

        WebElement designation = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-methode-de-diagnostics/div/div[2]/form/div/div[1]/input"
                )
            )
        );
        designation.click();
        designation.sendKeys("Test Atomate");
        designation.sendKeys(Keys.TAB);
        
        WebElement code = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-methode-de-diagnostics/div/div[2]/form/div/div[2]/input"
                )
            )
        );

        code.sendKeys("TESAUT");
        
        WebElement valideBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "btn-primary"
                )
            )
        );
        valideBtn.click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "swal2-confirm"
                )
            )
        ).click();

    }

    @Step("Recherche d'une méthode de diagnostic")
    @Description("Recherche d'une méthode de diagnostic par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void search() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "filter"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "fw-bold"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-methode-de-diagnostics/div/div[1]/div/div[2]/div/app-filter-v2/div/div[2]/div[1]/div[2]/ul/li/small"
                )
            )
        ).click();
    
        WebElement select = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "filter__input-select"
                )
            )
        );
        select.click();
        select.sendKeys("Test Atomate");
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "btn-Filtre"
                )
            )
        ).click();
    }

    @Step("Modification d'une méthode de diagnostic")
    @Description("Modification d'une méthode de diagnostic par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void Modify() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-methode-de-diagnostics/div/table-component/div[1]/table/tbody/tr[1]/td[2]/span/button[1]"
                )
            )
        ).click();

        WebElement libelle = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-methode-de-diagnostics/div/div[2]/form/div/div[1]/input"
                )
            )
        );

        libelle.clear();
        libelle.sendKeys("Test Atomate");

        WebElement code = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-methode-de-diagnostics/div/div[2]/form/div/div[2]/input"
                )
            )
        );
        code.clear();
        code.sendKeys("MODTEST");

        WebElement valideBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "btn-primary"
                )
            )
        );

        valideBtn.click();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.className(
                    "swal2-confirm"
                )
            )
        ).click();

    }

    @Step("Suppression d'une méthode de diagnostic")
    @Description("Suppression d'une méthode de diagnostic par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void Deleted() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);
        
        WebElement select = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "filter__input-select"
                )
            )
        );
        select.clear();
        select.sendKeys("Test Atomate");

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "btn-Filtre"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-methode-de-diagnostics/div/table-component/div[1]/table/tbody/tr[1]/td[2]/span/button[2]/img"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.className(
                    "swal2-confirm"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.className(
                    "swal2-confirm"
                )
            )
        ).click();
        
        Thread.sleep(1000);
        action.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        action.sendKeys(Keys.ENTER);
        action.sendKeys(Keys.ENTER);
        action.sendKeys(Keys.ENTER);

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.className(
                    "swal2-confirm"
                )
            )
        ).click();
    }

}
