package org.home.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GooglePageTest {
    private String searchedText = "codenvy";
    private String expectedLinkAfterSearch = "Codenvy";
    private String expectedTextAfterSearch = "Industrial-strength cloud IDE for developers and enterprise ...";
    private String expectedTextAfterGoToCodenvyPafe = "Try Codenvy without an account";


    private WebDriver driver;
    public PageFactoriesCreator PageFactoriesCreator;

    //init Webdriver as Firefox, go to google page and create PageFactoriesCreator object.
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
        PageFactoriesCreator = new PageFactoriesCreator(driver);
    }

    //shut down driver
    @After
    public void tearDown() {
        driver.quit();
    }

    // This testcase describes next steps: 1. goto Google search page, enter 'codenvy' text into search field, submit,
    // wait expected link 'Codenvy', wait codenvy text under link, click on the link, wait specified text on codenvy page after go to the page.
    @Test
    public void testSearch() {
        PageFactoriesCreator.GOOGLE_SEARCH_PAGE.fillText(searchedText);
        PageFactoriesCreator.GOOGLE_SEARCH_PAGE.submit();
        PageFactoriesCreator.RESULTPAGE.waitExpectedLinkOnPage(expectedLinkAfterSearch);
        PageFactoriesCreator.RESULTPAGE.waitExpectedTextOnPage(expectedTextAfterSearch);
        PageFactoriesCreator.RESULTPAGE.clickOnExpectedLinkAndWaitText(expectedLinkAfterSearch, expectedTextAfterGoToCodenvyPafe);
    }
}
