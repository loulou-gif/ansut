package com.ansut.settings.diffusion;

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

public class Diffusion {

    private WebDriver driver;

    public Diffusion(WebDriver driver) {
        this.driver = driver;
    }

    public void GoToMenu() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);
        // Thread.sleep(20000);

        // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > div > div.sidebar > div > li:nth-child(1)"))).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[1]/ul/li[9]/a"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-maintenancier/div/div/div/button"
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


        Thread.sleep(10000);
        WebElement valideBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-maintenancier/div/div[2]/div/div[2]/button"
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


 public void Modify() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);
        // Thread.sleep(20000);

        // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > div > div.sidebar > div > li:nth-child(1)"))).click();
         Thread.sleep(20000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-maintenancier/div/table-component/div[1]/table/tbody/tr[3]/td[3]/span/button[1]"
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


        Thread.sleep(10000);
        WebElement valideBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-maintenancier/div/div[2]/div/div[2]/button"
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

    public void Deleted() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);

        Thread.sleep(20000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-maintenancier/div/table-component/div[1]/table/tbody/tr[3]/td[3]/span/button[2]/img"
                )
            )
        ).click();

        Thread.sleep(10000);
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

        Thread.sleep(20000);
    }

    public void Create() throws InterruptedException{
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        GoToMenu();
        Modify();
        
    }


}
