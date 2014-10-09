package org.home.selenium;

import org.home.selenium.core.GooleSearchPage;
import org.home.selenium.core.ResultPage;
import org.openqa.selenium.WebDriver;

/**
 * This class serves as an example to realize a PageFactory pattern
 */

public class PageFactoriesCreator {

    private static WebDriver driver;
    public GooleSearchPage GOOGLE_SEARCH_PAGE;
    public ResultPage RESULTPAGE;

    // in constructor we use page objects RESULTPAGE and GOOGLE_SEARCH_PAGE for init. in PageFactoey
    public PageFactoriesCreator(WebDriver instDriver) {
        this.driver = instDriver;
        org.openqa.selenium.support.PageFactory.initElements(driver, GOOGLE_SEARCH_PAGE = new GooleSearchPage());
        org.openqa.selenium.support.PageFactory.initElements(driver, RESULTPAGE = new ResultPage());
    }

    /**
     * return of current the WebDriver instance
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver;
    }

}
