package com.ansut.settings.Section;

import java.time.Duration;
import org.openqa.selenium.By;
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
@Feature("Gestion des sections")
@Story("Opérations CRUD sur les sections")
public class CreateSection {

    private WebDriver driver;

    public CreateSection(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigation vers le menu des sections")
    @Description("Navigation vers le menu paramètres et l'onglet sections pour créer une section")
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
                By.cssSelector(
                    "body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tabs-container > ul > li:nth-child(1) > a"
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
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div[2]/form/div/div[1]/input"
                )
            )
        ).sendKeys("Test");

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div[2]/form/div/div[2]/input"
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
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "//span[contains(text(),'RAKALL')]"
                )
            )
        ).click();

        WebElement valideBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div[2]/div/div[2]/button"
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

    @Step("Recherche d'une section")
    @Description("Recherche d'une section par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void search() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div/div/button[1]"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[1]/div[2]/div"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[1]/div[2]/ul/li[1]"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[2]/input"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[2]/input"
                )
            )
        ).sendKeys("Test");
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[3]/button[1]"
                )
            )
        ).click();
    }

    @Step("Modification d'une section")
    @Description("Modification d'une section par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void Modify() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/table-component/div[1]/table/tbody/tr[1]/td[3]/span/button[1]/img"
                )
            )
        ).click();

        WebElement libelle = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div[2]/form/div/div[1]/input"
                )
            )
        );

        libelle.clear();
        libelle.sendKeys("Test modify");

        WebElement code = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div[2]/form/div/div[2]/input"
                )
            )
        );
        code.clear();
        code.sendKeys("MODTEST");

        WebElement valideBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div[2]/div/div[2]/button"
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

    @Step("Suppression d'une section")
    @Description("Suppression d'une section par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void Deleted() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);


        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[3]/button[1]"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/table-component/div[1]/table/tbody/tr[1]/td[3]/span/button[2]/img"
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
