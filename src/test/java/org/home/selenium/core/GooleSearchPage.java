package org.home.selenium.core;

import org.home.selenium.PageFactoriesCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This PageObject for communicate with searching Google page
 */
public class GooleSearchPage {
    private WebDriver driver;

    public GooleSearchPage() {
        this.driver = PageFactoriesCreator.getDriver();
    }

    /**
     * inner interface for locators
     */
    private interface Locators {
        String TEXT_BOX_XPATH = "//input[@id]";
    }

    /**
     * init input field as WebElement with xpath
     */
    @FindBy(xpath = Locators.TEXT_BOX_XPATH)
    private WebElement textBox;

    /**
     * wait 10 sec. appearance Google search field on main Google page.
     */
    public void waitGoogleSearchField() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(textBox));
    }

    /**
     * type into the search Google field specified text.
     *
     * @param text the text for entering
     */
    public void fillText(String text) {
        waitGoogleSearchField();
        textBox.sendKeys(text);
    }

    /**
     * submit  the search request on the Google page
     */
    public void submit() {
        textBox.submit();
    }
}
