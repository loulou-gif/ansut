package com.ansut.settings.prestataire;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
// import org.openqa.selenium.support.ui.ExpectedCondition;
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
@Feature("Gestion des prestataires")
@Story("Opérations CRUD sur les prestataires")
public class Operateur {

    private WebDriver driver;

    public Operateur(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigation vers le menu des prestataires")
    @Description("Navigation vers le menu paramètres et l'onglet prestataires pour créer un prestataire")
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
                    "body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tabs-container > ul > li:nth-child(8) > a"
                )
            )
        ).click();

        // Thread.sleep(20000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div/div/button[2]"
                )
            )
        ).click();

         wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div[2]/form/div/div[1]/input"
                )
            )
        ).sendKeys("Test");

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div[2]/form/div/div[2]/input"
                )
            )
        ).sendKeys("Test@test.com");

        WebElement lastInput = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div[2]/form/div/div[3]/input"
                )
            )
        );

        lastInput.sendKeys("070707070707");

        WebElement valideBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div[2]/div/div[2]/button"
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


    @Step("Recherche d'un prestataire")
    @Description("Recherche d'un prestataire par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void search() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div/div/button[1]"
                )
            )
        ).click();
    
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[1]/div[2]/div"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[1]/div[2]/ul/li[1]/small"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[2]/input"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[2]/input"
                )
            )
        ).sendKeys("Test");
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[3]/button[1]"
                )
            )
        ).click();
    }
    

    @Step("Modification d'un prestataire")
    @Description("Modification d'un prestataire par libellé")
    @Severity(SeverityLevel.NORMAL)
 public void Modify() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);
        // Thread.sleep(20000);

        // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > div > div.sidebar > div > li:nth-child(1)"))).click();
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/table-component/div[1]/table/tbody/tr[1]/td[4]/span/button[1]/img"
                )
            )
        ).click();

         WebElement name= wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div[2]/form/div/div[1]/input"
                )
            )
        );
        name.clear();
        name.sendKeys("Test modifier");

        WebElement mail = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div[2]/form/div/div[2]/input"
                )
            )
        );
        mail.clear();
        mail.sendKeys("Testmodifier@test.com");

        WebElement lastInput = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div[2]/form/div/div[3]/input"
                )
            )
        );
        lastInput.clear();
        lastInput.sendKeys("05050505");

        WebElement valideBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div[2]/div/div[2]/button"
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

    @Step("Suppression d'un prestataire")
    @Description("Suppression d'un prestataire par libellé")
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
        select.sendKeys("Test modifier");

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
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/div/div/div[2]/div/app-filter-v2/div/div[2]/div[3]/button[1]"
                )
            )
        ).click();

          wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-prestataire/div/table-component/div[1]/table/tbody/tr/td[4]/span/button[2]/img"
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
        Thread.sleep(2000);
        action.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
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
