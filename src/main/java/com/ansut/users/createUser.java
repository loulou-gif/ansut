package com.ansut.users;

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

@Epic("Utilisateurs")
@Feature("Gestion des utilisateurs")
@Story("Opérations CRUD sur les utilisateurs")
public class createUser {

    private WebDriver driver;

    public createUser(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigation vers le menu des utilisateurs")
    @Description("Navigation vers le menu utilisateurs et l'onglet utilisateurs pour créer un utilisateur")
    @Severity(SeverityLevel.NORMAL)
    public void GoToMenu() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"sidebar\"]/div/div[2]/ul/li[7]/div/span")
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/app-root/div/app-main-layout/div/div[2]/app-gestion-utilisateurs/div/div[2]/div[1]/div[2]/div/button[2]")
            )
        ).click();

        WebElement name = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"nom\"]")
            )
        );
        name.sendKeys("automatique");
        name.sendKeys(Keys.TAB);
        
        WebElement login = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("login")
            )
        );
        login.sendKeys("automatique.test");
        login.sendKeys(Keys.TAB);
        
        WebElement email = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("email")
            )
        );
        email.sendKeys("automatique.test@gmail.com");
        
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("groupName")
            )
        ).click();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"groupName\"]/div/div/div[2]/input")
            )
        ).sendKeys("admin");
       
        Thread.sleep(4000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'admin')]")
            )
        ).click();

        WebElement surname = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("prenom")
            )
        );
        surname.sendKeys("test");
        surname.sendKeys(Keys.TAB);

        WebElement password = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("password")
            )
        );
        password.sendKeys("K4dk272001@");
        password.sendKeys(Keys.TAB);

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("structure")
            )
        ).click();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"structure\"]/div/div/div[3]/input")
            )
        ).sendKeys("ANSUT");
       
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'ANSUT')]")
            )
        ).click();
        
        WebElement valideBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/app-root/div/app-main-layout/div/div[2]/app-gestion-utilisateurs/div/div[2]/div[2]/form/div/div/div[2]/button")
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

    @Step("Recherche d'un utilisateur")
    @Description("Recherche d'un utilisateur par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void search() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-gestion-utilisateurs/div/div[2]/div[1]/div[2]/div/button[1]"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-gestion-utilisateurs/div/div[2]/div[1]/div[2]/div/div[2]/div/app-filter-v2/div/div[2]/div[1]/div[2]/div"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-gestion-utilisateurs/div/div[2]/div[1]/div[2]/div/div[2]/div/app-filter-v2/div/div[2]/div[1]/div[2]/ul/li[1]/small"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-gestion-utilisateurs/div/div[2]/div[1]/div[2]/div/div[2]/div/app-filter-v2/div/div[2]/div[2]/input"
                )
            )
        ).click();
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-gestion-utilisateurs/div/div[2]/div[1]/div[2]/div/div[2]/div/app-filter-v2/div/div[2]/div[2]/input"
                )
            )
        ).sendKeys("automatique");
    
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-gestion-utilisateurs/div/div[2]/div[1]/div[2]/div/div[2]/div/app-filter-v2/div/div[2]/div[3]/button[1]"
                )
            )
        ).click();
    }

    @Step("Modification d'un utilisateur")
    @Description("Modification d'un utilisateur par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void Modify() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);
        
        Thread.sleep(20000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-gestion-utilisateurs/div/div[2]/div[2]/table/tbody/tr[1]/td[5]/div/span/img"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Modifier')]")
            )
        ).click();

        WebElement name = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"nom\"]")
            )
        );
        action.click(name).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        name.sendKeys("automatique modifier");
        name.sendKeys(Keys.TAB);

        Thread.sleep(40000);
        
        WebElement email = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("email")
            )
        );
        email.clear();
        email.sendKeys("automatique.modify@gmail.com");
        
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("groupName")
            )
        ).click();

        WebElement group = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"groupName\"]/div/div/div[2]/input")
            )
        );
        group.clear();
        group.sendKeys("everybody ");
       
        Thread.sleep(4000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'everybody ')]")
            )
        ).click();

        WebElement surname = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("prenom")
            )
        );
        surname.sendKeys("modify");
        surname.sendKeys(Keys.TAB);

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("structure")
            )
        ).click();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"structure\"]/div/div/div[3]/input")
            )
        ).sendKeys("RAKALL");
       
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'RAKALL')]")
            )
        ).click();
        
        WebElement valideBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/app-root/div/app-main-layout/div/div[2]/app-gestion-utilisateurs/div/div[2]/div[2]/form/div/div/div[2]/button")
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

    @Step("Suppression d'un utilisateur")
    @Description("Suppression d'un utilisateur par libellé")
    @Severity(SeverityLevel.NORMAL)
    public void Deleted() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions action = new Actions(driver);

        Thread.sleep(20000);
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "/html/body/app-root/div/app-main-layout/div/div[2]/app-gestion-utilisateurs/div/div[2]/div[2]/table/tbody/tr[1]/td[5]/div/span/button[2]/img"
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

}
