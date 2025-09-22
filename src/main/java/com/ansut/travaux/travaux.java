package com.ansut.travaux;

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

@Epic("Travaux")
@Feature("Gestion des travaux programmés")
@Story("Opérations CRUD sur les travaux programmés")
public class travaux {

    private WebDriver driver;

    public travaux(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigation vers le menu des travaux programmés")
    @Description("Navigation vers le menu travaux et l'onglet travaux programmés pour créer un travail programmé")
    @Severity(SeverityLevel.NORMAL)
    public void GoToMenu() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions actions = new Actions(driver);

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#sidebar > div > div.sidebar > ul > li:nth-child(9) > div > span"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "body > app-root > div > app-main-layout > div > div.main-content.main > app-travaux-programmes > div > div.search-row > div.actions > button.btn.btn-user.add"
                )
            )
        ).click();

        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#clientImpacte > div > div > div.ng-input > input[type=text]"
                )
            )
        ).click();
        Thread.sleep(2000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "//*[@id=\"clientImpacte\"]/div/div/div[3]/input"
                )
            )
        ).sendKeys("ORANGE");
        Thread.sleep(2000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "ng-option"
                )
            )
        ).click();
        Thread.sleep(2000);
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#sujet"
                )
            )
        ).sendKeys("Test travaux");  

        actions.sendKeys(Keys.TAB);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#description"
                )
            )
        ).sendKeys("Des travaux seront menés sur le site");  

        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#affecteA > div"
                )
            )
        ).click();


        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "//*[@id=\"affecteA\"]/div/div/div[3]/input"
                )
            )
        ).sendKeys("RAKALL");

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "ng-option"
                )
            )
        ).click();


        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#equipement > div > div > div.ng-input > input[type=text]"
                )
            )
        ).click();

                
        WebElement dateDebut = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#calendar-24h"
                )
            )
        );
        dateDebut.click();
        WebElement day21 = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("body > app-root > div > app-main-layout > div > div.main-content.main > app-travaux-programmes > div > app-form-travaux-programmes > div > div > div:nth-child(2) > div > form > div.container.m-1.w-100 > div > div > div:nth-child(2) > div > div.style-date > div:nth-child(1) > p-calendar > span > div > div.p-datepicker-group-container.ng-tns-c125-1.ng-star-inserted > div > div.p-datepicker-calendar-container.ng-tns-c125-1.ng-star-inserted > table > tbody > tr:nth-child(4) > td.ng-tns-c125-1.p-datepicker-today.ng-star-inserted > span")
            )
        );
        day21.click();

        
        WebElement dateFin = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "//label[contains(text(),'Date de fin')]/following::input[1]"
                )
            )
        );
        dateFin.click();
        WebElement day25 = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/app-root/div/app-main-layout/div/div[2]/app-travaux-programmes/div/app-form-travaux-programmes/div/div/div[2]/div/form/div[1]/div/div/div[2]/div/div[1]/div[2]/p-calendar/span/div/div[1]/div/div[2]/table/tbody/tr[5]/td[2]/span")
            )
        );
        day25.click();
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#equipement > div > div > div.ng-input > input[type=text]"
                )
            )
        ).sendKeys("SECTION");

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "ng-option"
                )
            )
        ).click();

        WebElement sectionBascule = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#section > div > div > div.ng-input > input[type=text]"
                )
            )
        );
        sectionBascule.click();

        Thread.sleep(3000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#section > div > div > div.ng-input > input[type=text]"
                )
            )
        ).sendKeys("TEST-SAM");
        Thread.sleep(3000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "ng-option"
                )
            )
        ).click();

        WebElement sectionImpacte = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "//label[contains(., 'Section impactés')]/following-sibling::ng-select"
                )
            )
        );
        sectionImpacte.click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "//label[contains(., 'Section impactés')]/following::ng-select[1]//input"
                )
            )
        ).sendKeys("TEST-YAPI");
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "ng-option"
                )
            )
        ).click();

        WebElement enregistrerBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "btn-primary"
                )
            )
        );

        enregistrerBtn.click();
        Thread.sleep(3000);

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "swal2-confirm"
                )
            )
        ).click();
        Thread.sleep(3000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.className(
                    "swal2-confirm"
                )
            )
        ).click();

    }

 
    @Step("Recherche d'un travail programmé")
    @Description("Recherche d'un travail programmé par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void search() throws InterruptedException{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    Actions action = new Actions(driver);
    
    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.className(
                "fa-filter"
            )
        )
    ).click();


    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath(
                "/html/body/app-root/div/app-main-layout/div/div[2]/app-travaux-programmes/div/div[2]/div[2]/div/div/app-filter-v2/div/div[2]/div[1]/div[2]/div"
            )
        )
    ).click();
    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath(
                "/html/body/app-root/div/app-main-layout/div/div[2]/app-travaux-programmes/div/div[2]/div[2]/div/div/app-filter-v2/div/div[2]/div[1]/div[2]/ul/li[3]/small"
            )
        )
    ).click();


    WebElement SearchInput = wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath(
                "/html/body/app-root/div/app-main-layout/div/div[2]/app-travaux-programmes/div/div[2]/div[2]/div/div/app-filter-v2/div/div[2]/div[2]/input"
            )
        )
    );
    SearchInput.click();
    SearchInput.sendKeys("RAKALL");

    Thread.sleep(2000);


    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.className(
                "btn-Filtre"
            )
        )
    ).click();

    Thread.sleep(2000);
}

}