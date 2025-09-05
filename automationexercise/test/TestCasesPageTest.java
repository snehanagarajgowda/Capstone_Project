package com.automationexercise.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationexercise.pages.TestCasesPage;
import com.automationexercise.base.BaseTest;   

public class TestCasesPageTest extends BaseTest {  

    @Test
    public void verifyLogo() {
        TestCasesPage page = new TestCasesPage(driver);   
        Assert.assertTrue(page.isLogoDisplayed(), "Logo is not visible!");
    }

    @Test
    public void verifyHomeButton() {
        TestCasesPage page = new TestCasesPage(driver);
        Assert.assertTrue(page.isHomeButtonDisplayed(), "Home button is not visible!");
    }

    @Test
    public void verifyProductsButton() {
        TestCasesPage page = new TestCasesPage(driver);
        Assert.assertTrue(page.isProductsButtonDisplayed(), "Products button is not visible!");
    }

    @Test
    public void verifyCartButton() {
        TestCasesPage page = new TestCasesPage(driver);
        Assert.assertTrue(page.isCartButtonDisplayed(), "Cart button is not visible!");
    }

    @Test
    public void verifySignupLoginButton() {
        TestCasesPage page = new TestCasesPage(driver);
        Assert.assertTrue(page.isSignupLoginButtonDisplayed(), "Signup/Login button is not visible!");
    }

    @Test
    public void verifyTestCasesButton() {
        TestCasesPage page = new TestCasesPage(driver);
        Assert.assertTrue(page.isTestCasesButtonDisplayed(), "Test Cases button is not visible!");
    }

    @Test
    public void verifyFooter() {
        TestCasesPage page = new TestCasesPage(driver);
        Assert.assertTrue(page.isFooterDisplayed(), "Footer is not visible!");
    }

    @Test
    public void verifyRecommendedItems() {
        TestCasesPage page = new TestCasesPage(driver);
        Assert.assertTrue(page.isRecommendedItemsDisplayed(), "Recommended items are not visible!");
    }

    @Test
    public void verifySubscriptionSection() {
        TestCasesPage page = new TestCasesPage(driver);
        Assert.assertTrue(page.isSubscriptionSectionDisplayed(), "Subscription section is not visible!");
    }

    @Test
    public void verifyContactUsButton() {
        TestCasesPage page = new TestCasesPage(driver);
        Assert.assertTrue(page.isContactUsButtonDisplayed(), " Contact Us button is not visible!");
    }

    @Test
    public void verifyScrollUpButton() {
        TestCasesPage page = new TestCasesPage(driver);
        Assert.assertTrue(page.isScrollUpButtonDisplayed(), " Scroll Up button is not visible!");
    }
}
