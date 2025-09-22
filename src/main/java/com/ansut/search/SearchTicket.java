package com.ansut.search;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchTicket {

    private WebDriver driver;

    public SearchTicket(WebDriver driver) {
        this.driver = driver;
    }

    public void GoToMenu() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Thread.sleep(20);

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#sidebar > div > div.sidebar > ul > li:nth-child(11) > div > span"
                )
            )
        ).click();
    }

    public void FirstSearch() throws InterruptedException{
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));

        // Thread.sleep(10000);

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "#nDossier"
                )
            )
        ).sendKeys(
            "INC20250627017"
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "body > app-root > div > app-main-layout > div > div.main-content.main > app-search-workcase > div > div.search-content > div.search-form > div.button-group > button.btn.btn-primary > span"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "body > app-root > div > app-main-layout > div > div.main-content.main > app-search-workcase > div > div.search-content > div.results-table > table > tbody > tr > td:nth-child(6) > button"
                )
            )
        ).click();
        
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "body > ngb-modal-window > div > div > app-details > div.modal-body.p-0 > div > div > div.tabs-container > div > a:nth-child(2)"
                )
            )
        ).click();
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "body > ngb-modal-window > div > div > app-details > div.modal-body.p-0 > div > div > div.tabs-container > div > a:nth-child(3)"
                )
            )
        ).click();
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "body > ngb-modal-window > div > div > app-details > div.modal-body.p-0 > div > div > div.tabs-container > div > a:nth-child(4)"
                )
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(
                    "body > ngb-modal-window > div > div > app-details > div.modal-header.border-bottom > button"
                )
            )
        ).click();
    }

        public void SecondSearch() throws InterruptedException{
        
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                        "#processType > div > div > div.ng-input > input[type=text]"
                    )
                )
            ).click();

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                        "#processType > div > div > div.ng-input > input[type=text]"
                    )
                )
            ).sendKeys("Ticket");

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath(
                        "//span[contains(text(),'Ticket')]"
                    )
                )
            ).click();

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                        "#nDossier"
                    )
                )
            ).clear();

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                        "#nDossier"
                    )
                )
            ).sendKeys(
                "TIC20250627025"
            );


            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                        "body > app-root > div > app-main-layout > div > div.main-content.main > app-search-workcase > div > div.search-content > div.search-form > div.button-group > button.btn.btn-primary > span"
                    )
                )
            ).click();

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                        "body > app-root > div > app-main-layout > div > div.main-content.main > app-search-workcase > div > div.search-content > div.search-form > div.button-group > button.btn.btn-primary > span"
                    )
                )
            ).click();

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                        "body > app-root > div > app-main-layout > div > div.main-content.main > app-search-workcase > div > div.search-content > div.results-table > table > tbody > tr > td:nth-child(6) > button"
                    )
                )
            ).click();


            Thread.sleep(20000);

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                        "body > ngb-modal-window > div > div > app-details > div.modal-body.p-0 > div > div > div.tabs-container > div > a:nth-child(2)"
                    )
                )
            ).click();
            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                        "body > ngb-modal-window > div > div > app-details > div.modal-body.p-0 > div > div > div.tabs-container > div > a:nth-child(3)"
                    )
                )
            ).click();
            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                        "body > ngb-modal-window > div > div > app-details > div.modal-body.p-0 > div > div > div.tabs-container > div > a:nth-child(4)"
                    )
                )
            ).click();

            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(
                        "body > ngb-modal-window > div > div > app-details > div.modal-header.border-bottom > button"
                    )
                )
            ).click();

            Thread.sleep(20000);
        }
    public void FinalSearch() throws InterruptedException {
        GoToMenu();
        FirstSearch();
        SecondSearch();
    }


    // public void makeSearch() throws InterruptedException{
    //     Thread.sleep(20000);


    // }

}
