package com.ansut.settings.cloture;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
@Feature("Gestion des raisons de clôture")
@Story("Opérations CRUD sur les raisons de clôture")
public class Cloture {

    private WebDriver driver;

    public Cloture(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigation vers le menu des raisons de clôture")
    @Description("Navigation vers le menu paramètres et l'onglet raisons de clôture pour créer une raison de clôture")
    @Severity(SeverityLevel.NORMAL)
    public void GoToMenu() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);
        // Thread.sleep(20000);

        // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > div > div.sidebar > div > li:nth-child(1)"))).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#sidebar > div > div.sidebar > div > li:nth-child(1)"
                )
            )
        ).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(500, 0);");

        WebElement Scrolling = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tabs-container > ul"
                )    
            )
        );
        js.executeScript("arguments[0].scrollLeft += 500;", Scrolling);


        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tabs-container > ul > li:nth-child(6) > a"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div/div/button[2]"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div[2]/form/div/div[1]/input"
                )
            )
        ).sendKeys("Test");

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div[2]/form/div/div[2]/input"
                )
            )
        ).sendKeys("TST");


        WebElement valideBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div[2]/div/div[2]/button"
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


    @Step("Recherche d'une raison de clôture")
    @Description("Recherche d'une raison de clôture par libellé")
    @Severity(SeverityLevel.NORMAL)
public void search() throws InterruptedException{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    Actions action = new Actions(driver);
    
    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath(
                "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div/div/button[1]"
            )
        )
    ).click();


    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath(
                "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[1]/div[2]/div"
            )
        )
    ).click();

    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath(
                "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[1]/div[2]/ul/li"
            )
        )
    ).click();

    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath(
                "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[2]/input"
            )
        )
    ).click();

    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath(
                "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[2]/input"
            )
        )
    ).sendKeys("Test");

    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath(
                "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[3]/button[1]"
            )
        )
    ).click();
}


    @Step("Modification d'une raison de clôture")
    @Description("Modification d'une raison de clôture par libellé")
    @Severity(SeverityLevel.NORMAL)
 public void Modify() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/table-component/div[1]/table/tbody/tr/td[2]/span/button[1]"
                )
            )
        ).click();

        WebElement libelle = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div[2]/form/div/div[1]/input"
                )
            )
        );

        libelle.click();
        libelle.sendKeys("Test modify");

        WebElement code = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div[2]/form/div/div[2]/input"
                )
            )
        );
        code.click();
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

    @Step("Suppression d'une raison de clôture")
    @Description("Suppression d'une raison de clôture par libellé")
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
        select.sendKeys("Test modify");

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
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[3]/button[1]"
                )
            )
        ).click();

          wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-raisons-de-cloture/div/table-component/div[1]/table/tbody/tr[1]/td[2]/span/button[2]/img"
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
