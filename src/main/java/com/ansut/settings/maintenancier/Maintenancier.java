package com.ansut.settings.maintenancier;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Paramétrage")
@Feature("Gestion des maintenanciers")
@Story("Opérations CRUD sur les maintenanciers")
public class Maintenancier {

    private WebDriver driver;

    public Maintenancier(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigation vers le menu des maintenanciers")
    @Description("Navigation vers le menu paramètres et l'onglet maintenanciers pour créer un maintenancier")
    @Severity(SeverityLevel.NORMAL)
    public void GoToMenu() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#sidebar > div > div.sidebar > div > li:nth-child(1)"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[1]/ul/li[9]/a"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "btn-user"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-maintenancier/div/div[2]/form/div/div[1]/input"
                )
            )
        ).sendKeys("Test");

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-maintenancier/div/div[2]/form/div/div[2]/input"
                )
            )
        ).sendKeys("TST");

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

        Thread.sleep(2000);
    }

    @Step("Recherche d'un maintenancier")
    @Description("Recherche d'un maintenancier par libellé")
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
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-maintenancier/div/div[1]/div/div[2]/div/app-filter-v2/div/div[2]/div[1]/div[2]/ul/li[1]/small"
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
        select.sendKeys("Test");
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "btn-Filtre"
                )
            )
        ).click();
    }

    @Step("Modification d'un maintenancier")
    @Description("Modification d'un maintenancier par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void Modify() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-maintenancier/div/table-component/div[1]/table/tbody/tr[1]/td[3]/span/button[1]/img"
                )
            )
        ).click();

        WebElement libelle = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-maintenancier/div/div[2]/form/div/div[1]/input"
                )
            )
        );

        libelle.clear();
        libelle.sendKeys("Test modify");

        WebElement code = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-maintenancier/div/div[2]/form/div/div[2]/input"
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

    @Step("Suppression d'un maintenancier")
    @Description("Suppression d'un maintenancier par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void Deleted() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "btn-Filtre"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tab-content.mt-3 > app-maintenancier > div > table-component > div.table-container.card > table > tbody > tr:nth-child(1) > td:nth-child(3) > span > button:nth-child(2) > img"
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
        
        action.sendKeys(Keys.ENTER);
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
