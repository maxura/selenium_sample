package org.home.selenium.core;

import org.home.selenium.PageFactoriesCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This PageObject for communicate with page after performing search  on Google
 */

public class ResultPage {

    private WebDriver driver;

    public ResultPage() {
        this.driver = PageFactoriesCreator.getDriver();
    }

    /**
     * wait 10sec. expected link after searching on Google page
     *
     * @param textLink
     */
    public void waitExpectedLinkOnPage(String textLink) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(textLink)));
    }

    /**
     * wait 10sec. expected link after searching on Google page and click on the link.
     *
     * @param textLink
     */
    public void clickOnExpectedLink(String textLink) {
        waitExpectedLinkOnPage(textLink);
        driver.findElement(By.linkText(textLink)).click();
    }

    /**
     * Wait some text on any page. Check all text on the page after <body> tag.
     *
     * @param text
     */
    public void waitExpectedTextOnPage(String text) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text));
    }

    /**
     * Click on expected link after searching and wait some text after go to the page
     *
     * @param link
     * @param expectedText
     */
    public void clickOnExpectedLinkAndWaitText(String link, String expectedText) {
        clickOnExpectedLink(link);
        waitExpectedTextOnPage(expectedText);
    }

}
