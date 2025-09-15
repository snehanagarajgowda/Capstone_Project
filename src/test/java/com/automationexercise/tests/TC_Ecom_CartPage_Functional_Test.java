package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_CartPage_UI;



public class TC_Ecom_CartPage_Functional_Test extends BaseTest {

    private TC_Ecom_CartPage_UI cartPage;

    @BeforeMethod
    public void setupPage() {
        cartPage = new TC_Ecom_CartPage_UI(driver);
    }

    // ---------- TC01: Launch Browser ----------
    @Test
    public void TC01_BrowserLaunch() {
        driver.get("https://www.automationexercise.com");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com");
    }

    // ---------- TC02: Navigate URL ----------
    @Test
    public void TC02_NavigateURL() {
        driver.get("http://automationexercise.com");
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationexercise.com/");
    }

    // ---------- TC03: Home page visible ----------
    @Test
    public void TC03_HomePageVisible() {
        driver.get("https://www.automationexercise.com");
        Assert.assertTrue(cartPage.isProductsLinkDisplayed(), "Products link not visible on home page");
    }

    // ---------- TC04: Navigate to Cart ----------
    @Test
    public void TC04_NavigateToCart() {
        cartPage.clickCartButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));
    }

    // ---------- TC05: Add product to Cart ----------
    @Test
    public void TC05_AddProductToCart() {
        cartPage.clickProducts();
        cartPage.addProductToCart();
        Assert.assertTrue(cartPage.isProductDisplayed(), "Product not added to cart");
    }

    // ---------- TC06: Add multiple products ----------
    @Test
    public void TC06_AddMultipleProducts() {
        cartPage.clickProducts();
        cartPage.addMultipleProductsToCart(2);
        Assert.assertTrue(cartPage.isProductDisplayed(), "Multiple products not added to cart");
    }

    // ---------- TC07: Update product quantity ----------
    @Test
    public void TC07_UpdateProductQuantity() {
        cartPage.clickCartButton();
        Assert.assertTrue(cartPage.updateProductQuantity("3"), "Product quantity not updated");
    }

    // ---------- TC08: Remove product ----------
    @Test
    public void TC08_RemoveProduct() {
        cartPage.clickCartButton();
        Assert.assertTrue(cartPage.removeProduct(), "Product not removed from cart");
    }

    // ---------- TC09: Subscription block exists ----------
    @Test
    public void TC09_SubscriptionBlock() {
        cartPage.scrollToSubscription();
        Assert.assertTrue(cartPage.isSubscriptionInputDisplayed(), "Subscription block not visible");
    }

    // ---------- TC10: Subscribe with valid email ----------
    @Test
    public void TC10_SubscribeValidEmail() {
        cartPage.scrollToSubscription();
        Assert.assertTrue(cartPage.subscribe("test@example.com"), "Subscription with valid email failed");
    }

    // ---------- TC11: Subscribe with invalid email ----------
    @Test
    public void TC11_SubscribeInvalidEmail() {
        cartPage.scrollToSubscription();
        Assert.assertTrue(cartPage.subscribe("abc123"), "Subscription accepted invalid email");
    }

    // ---------- TC12: Proceed to checkout without login ----------
    @Test
    public void TC12_CheckoutWithoutLogin() {
        cartPage.clickCartButton();
        cartPage.clickProceedToCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Checkout allowed without login");
    }

    // ---------- TC13: Checkout after login ----------
    @Test
    public void TC13_CheckoutAfterLogin() {
        // Login logic to be implemented
        cartPage.clickCartButton();
        cartPage.clickProceedToCheckout();
        // Assert order confirmation after filling address/payment
    }

    // ---------- TC14: Checkout after registration ----------
    @Test
    public void TC14_CheckoutAfterRegistration() {
        // Registration logic to be implemented
        cartPage.clickCartButton();
        cartPage.clickProceedToCheckout();
        // Assert order confirmation
    }

    // ---------- TC15: Remove product from cart ----------
    @Test
    public void TC15_RemoveProductFromCart() {
        cartPage.clickCartButton();
        Assert.assertTrue(cartPage.removeProduct(), "Product not removed from cart");
    }

    // ---------- TC16: Verify product price ----------
    @Test
    public void TC16_VerifyProductPrice() {
        cartPage.clickCartButton();
        Assert.assertTrue(cartPage.isTotalPriceDisplayed(), "Product price not displayed in cart");
    }

    // ---------- TC17: Verify product quantity ----------
    @Test
    public void TC17_VerifyProductQuantity() {
        cartPage.clickCartButton();
        Assert.assertTrue(cartPage.updateProductQuantity("2"), "Product quantity not updated in cart");
    }

    // ---------- TC18: Verify total price ----------
    @Test
    public void TC18_VerifyTotalPrice() {
        cartPage.clickCartButton();
        Assert.assertTrue(cartPage.isTotalPriceDisplayed(), "Total price not displayed in cart");
    }
}
