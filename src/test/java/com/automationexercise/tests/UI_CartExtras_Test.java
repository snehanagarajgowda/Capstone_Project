package com.automationexercise.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.automationexercise.pages.CartPage;

public class UI_CartExtras_Test {
    WebDriver driver;
    CartPage cartPage;

    @BeforeClass
    @Parameters({"browser", "page"})
    public void setup(@Optional("chrome") String browser,
                      @Optional("view_cart") String page) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/" + page);
        cartPage = new CartPage(driver);
    }

    @Test
    public void verifyClickHereLinkWorks() {
        boolean result = cartPage.isClickHereLinkWorking();
        Assert.assertTrue(result, "Click Here link did not redirect correctly!");
    }

    @Test
    public void verifyPromoBannerVisible() {
        boolean result = cartPage.isPromoBannerVisible();
        Assert.assertTrue(result, "Promo banner not visible on cart page!");
    }

    @Test
    public void verifyScrollUpVisible() {
        boolean result = cartPage.isScrollUpVisibleAfterScroll();
        Assert.assertTrue(result, "Scroll Up button not visible after scrolling!");
    }

    @Test
    public void verifyScrollUpClickWorks() {
        boolean result = cartPage.clickScrollUpAndVerify();
        Assert.assertTrue(result, "Scroll Up button did not scroll page to top!");
    }

    @Test
    public void verifyMobileResponsive() {
        boolean result = cartPage.checkMobileResponsive();
        Assert.assertTrue(result, "Mobile responsive menu toggle not visible!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}