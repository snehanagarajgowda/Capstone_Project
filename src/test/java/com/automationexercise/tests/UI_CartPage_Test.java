package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.CartPage;

public class UI_CartPage_Test extends BaseTest {

    private CartPage cartPage;

    @BeforeMethod
    public void openCartPage() {
        driver.get("https://automationexercise.com/view_cart");
        cartPage = new CartPage(driver);
    }

    // ---------- Logo ----------
    @Test public void verifyLogoVisible() { Assert.assertTrue(cartPage.isLogoVisible()); }

    // ---------- Header ----------
    @Test public void verifyProductsIconVisible() { Assert.assertTrue(cartPage.isProductsIconVisible()); }
    @Test public void verifyCartIconVisible() { Assert.assertTrue(cartPage.isCartIconVisible()); }
    @Test public void verifySignupLoginIconVisible() { Assert.assertTrue(cartPage.isSignupLoginIconVisible()); }
    @Test public void verifyTestCasesIconVisible() { Assert.assertTrue(cartPage.isTestCasesIconVisible()); }
    @Test public void verifyApiTestingIconVisible() { Assert.assertTrue(cartPage.isApiTestingIconVisible()); }
    @Test public void verifyVideoTutorialsIconVisible() { Assert.assertTrue(cartPage.isVideoTutorialsIconVisible()); }
    @Test public void verifyContactUsIconVisible() { Assert.assertTrue(cartPage.isContactUsIconVisible()); }

    // ---------- Empty Cart ----------
    @Test public void verifyEmptyCartMessage() { Assert.assertTrue(cartPage.isEmptyCartMessageVisible()); }
   
    // ---------- Subscription ----------
    @Test public void verifySubscriptionSectionVisible() { Assert.assertTrue(cartPage.isSubscriptionSectionVisible()); }
    @Test public void verifyEmailBoxVisible() { Assert.assertTrue(cartPage.isSubscriptionEmailBoxVisible()); }
    @Test public void verifySubscribeButtonClickable() { Assert.assertTrue(cartPage.isSubscriptionButtonClickable()); }

    // ---------- Footer ----------
    @Test public void verifyFooterVisible() { Assert.assertTrue(cartPage.isFooterVisible()); }

  
    // ---------- Responsive ----------
   
}