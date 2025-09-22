package com.ansut;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateSection {
    private WebDriver driver;
    private static final String URL = "http://4.210.245.79:7718/ansut";
        public CreateSection(WebDriver driver) {
        this.driver = driver;
    }

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public void Create(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar > div > div.sidebar > div > li:nth-child(1)"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tab-content.mt-3 > app-section > div > div > div > button"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tab-content.mt-3 > app-section > div > div.card.ng-star-inserted > form > div > div:nth-child(1) > input"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tab-content.mt-3 > app-section > div > div.card.ng-star-inserted > form > div > div:nth-child(1) > input"))).sendKeys("Section automate");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tab-content.mt-3 > app-section > div > div.card.ng-star-inserted > form > div > div:nth-child(2) > input"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > app-main-layout > div > div.main-content.main > app-parameters > div > div.tab-content.mt-3 > app-section > div > div.card.ng-star-inserted > form > div > div:nth-child(2) > input"))).sendKeys("SECAUT");

        WebElement dropdown = driver.findElement(By.id("maintainer"));
        dropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-dropdown-panel")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ab7c71754f6f-0\"]"))).click();

        WebElement validateBtn = driver.findElement(By.xpath("/html/body/app-root/div/app-main-layout/div/div[2]/app-parameters/div/div[2]/app-section/div/div[2]/div/div[2]/button0"));
        validateBtn.click();

    }

    // public void tearDown() {
    //     if (driver != null) {
    //         driver.quit();
    //     }
    // }

    // public static void main(String[] args) {
    //     LoginAnsut loginAnsut = new LoginAnsut();
    //     CreateSection CreateSection = new CreateSection();
        
    //     try {
    //         loginAnsut.setUp();
    //         loginAnsut.login(USR, PWD);
    //         CreateSection.Create();
    //     } catch (Exception e) {
    //         System.out.println("Une erreur s'est produite : " + e.getMessage());
    //         loginAnsut.tearDown();
    //     }
    // }
}
