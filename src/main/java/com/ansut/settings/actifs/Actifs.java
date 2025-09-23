package com.ansut.settings.actifs;

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
@Feature("Gestion des actifs")
@Story("Opérations CRUD sur les actifs")
public class Actifs {

    private WebDriver driver;

    public Actifs(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Navigation vers le menu des actifs")
    @Description("Navigation vers le menu paramètres et l'onglet actifs pour créer un actif")
    @Severity(SeverityLevel.NORMAL)
    public void GoToMenu() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "//*[@id=\"sidebar\"]/div/div[2]/div/li[1]/span"
                )
            )
        ).click();

        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(500, 0);");

        // WebElement Scrolling = wait.until(
        //     ExpectedConditions.elementToBeClickable(
        //         By.cssSelector(
        //             "body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tabs-container > ul"
        //         )    
        //     )
        // );
        // js.executeScript("arguments[0].scrollLeft += 500;", Scrolling);

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[1]/ul/li[7]/a"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-actif/div/div/div/button[2]"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-actif/div/div[2]/form/div/div[1]/input"
                )
            )
        ).sendKeys("Test");

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-actif/div/div[2]/form/div/div[2]/input"
                )
            )
        ).sendKeys("TST");

        WebElement maintainer = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "//*[@id=\"maintainer\"]/div/div/div[2]/input"
                )
            )
        );
        maintainer.click();
        maintainer.sendKeys("RAKALL");
        Thread.sleep(200);

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "ng-option"
                )
            )
        ).click();

        Thread.sleep(1000);
        WebElement valideBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-actif/div/div[2]/div/div[2]/button"
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

    @Step("Recherche d'un actif")
    @Description("Recherche d'un actif par libellé")
    @Severity(SeverityLevel.MINOR)
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
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-actif/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[1]/div[2]/ul/li[1]/small"
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
        select.sendKeys("Test");

    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "btn-Filtre"
                )
            )
        ).click();
    }

    @Step("Modification d'un actif")
    @Description("Modification d'un actif par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void Modify() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);
        

        WebElement btnModify = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-actif/div/table-component/div[1]/table/tbody/tr[1]/td[4]/span/button[1]/img"
                )
            )
        );
        btnModify.click();
        WebElement libelle = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-actif/div/div[2]/form/div/div[1]/input"
                )
            )
        );

        libelle.clear();
        libelle.sendKeys("Test modify");

        WebElement code = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-actif/div/div[2]/form/div/div[2]/input"
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

    @Step("Suppression d'un actif")
    @Description("Suppression d'un actif par libellé")
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
        select.click();
        select.sendKeys("Test");

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
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-actif/div/table-component/div[1]/table/tbody/tr[1]/td[4]/span/button[2]/img"
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

        Thread.sleep(2000);
    }

}
