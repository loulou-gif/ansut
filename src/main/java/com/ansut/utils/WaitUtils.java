package com.ansut.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe utilitaire pour gérer les waits et les interactions avec les éléments
 */
public class WaitUtils {
    
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;
    
    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.js = (JavascriptExecutor) driver;
    }
    
    /**
     * Attend qu'un élément soit cliquable et le clique
     */
    public void clickElement(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            throw new RuntimeException("Impossible de cliquer sur l'élément: " + locator, e);
        }
    }
    
    /**
     * Attend qu'un élément soit visible et saisit du texte
     */
    public void sendKeysToElement(By locator, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new RuntimeException("Impossible de saisir du texte dans l'élément: " + locator, e);
        }
    }
    
    /**
     * Attend qu'un élément soit visible
     */
    public WebElement waitForElementVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            throw new RuntimeException("Élément non visible: " + locator, e);
        }
    }
    
    /**
     * Attend qu'un élément soit cliquable
     */
    public WebElement waitForElementClickable(By locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            throw new RuntimeException("Élément non cliquable: " + locator, e);
        }
    }
    
    /**
     * Scroll vers un élément
     */
    public void scrollToElement(By locator) {
        try {
            WebElement element = waitForElementVisible(locator);
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500); // Petit délai pour le scroll
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            throw new RuntimeException("Impossible de scroller vers l'élément: " + locator, e);
        }
    }
    
    /**
     * Vérifie si un élément est présent dans le DOM
     */
    public boolean isElementPresent(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator)) != null;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Vérifie si un élément est visible
     */
    public boolean isElementVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Attend qu'une page soit chargée (URL change)
     */
    public void waitForPageLoad() {
        try {
            wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            throw new RuntimeException("La page n'a pas fini de charger", e);
        }
    }
    
    /**
     * Attend qu'un élément disparaisse
     */
    public void waitForElementToDisappear(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            throw new RuntimeException("L'élément n'a pas disparu: " + locator, e);
        }
    }
}
