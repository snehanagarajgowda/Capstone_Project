package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.UI_Testcase_page;

public class UI_Testcase_Test extends BaseTest {

    // ---------- Logo ----------
    @Test
    public void verifyLogo() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isLogoDisplayed(), "Logo not visible");
    }

    // ---------- Top Menu ----------
    @Test
    public void verifyHomeButton() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isHomeButtonDisplayed(), "Home button not visible");
    }

    @Test
    public void verifyProductsButton() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isProductsButtonDisplayed(), "Products button not visible");
    }

    @Test
    public void verifyCartButton() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isCartButtonDisplayed(), "Cart button not visible");
    }

    @Test
    public void verifySignupLoginButton() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isSignupLoginButtonDisplayed(), "Signup/Login not visible");
    }

    @Test
    public void verifyTestCasesButton() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isTestCasesButtonDisplayed(), "Test Cases button not visible");
    }

    @Test
    public void verifyApiTestingLink() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isApiTestingDisplayed(), "API Testing link not visible");
    }

    @Test
    public void verifyVideoTutorials() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isVideoTutorialsDisplayed(), "Video Tutorials link not visible");
    }

    @Test
    public void verifyContactUsButton() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isContactUsDisplayed(), "Contact Us not visible");
    }

    // ---------- Page Content ----------
    @Test
    public void verifyScrollBar() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isScrollBarDisplayed(), "Scroll bar not visible");
    }

    @Test
    public void verifyTestCasesWordDisplayed() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        page.clickTestCasesButton(); // 🔧 FIX
        Assert.assertTrue(page.isTestCasesWordDisplayed(), "Test Cases word missing");
    }

    @Test
    public void verifyAllTestCasesDisplayed() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        page.clickTestCasesButton(); // 🔧 FIX
        Assert.assertTrue(page.getNumberOfTestCases() > 0, "No test cases found");
    }

    @Test
    public void verifyTestCasesClickable() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        page.clickTestCasesButton(); // 🔧 FIX
        Assert.assertTrue(page.areTestCasesClickable(), "Test cases not clickable");
    }

    @Test
    public void verifyNumberOfTestCases() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        page.clickTestCasesButton(); // 🔧 FIX
        int count = page.getNumberOfTestCases();
        Assert.assertTrue(count > 0, "No test cases available");
        System.out.println("Total Test Cases: " + count);
    }

    // ---------- Feedback ----------
    @Test
    public void verifyFeedbackDisplayed() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        page.clickContactUs(); // 🔧 FIX
        Assert.assertTrue(page.isFeedbackDisplayed(), "Feedback section not visible");
    }

    @Test
    public void verifyFeedbackLink() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isFeedbackLinkDisplayed(), "Feedback link missing");
    }

    // ---------- Scroll Up ----------
    @Test
    public void verifyScrollUpButton() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isScrollUpDisplayed(), "Scroll up button not visible");
    }

    // ---------- Subscription ----------
    @Test
    public void verifySubscriptionDisplayed() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isSubscriptionDisplayed(), "Subscription section missing");
    }

    @Test
    public void verifyValidSubscription() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        page.enterSubscriptionEmail("valid@gmail.com");
        page.clickSubscribe();
        String message = page.getSubscriptionMessage();
        Assert.assertTrue(message.contains("successfully") || message.contains("Success"),
                "Valid subscription failed: " + message);
    }

    @Test
    public void verifyInvalidSubscription() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        page.enterSubscriptionEmail("invalidEmail@gmail.com");
        page.clickSubscribe();
        String message = page.getSubscriptionMessage();
        Assert.assertTrue(message.contains("Invalid email address!"),
                "Invalid subscription not handled: " + message);
    }

    @Test
    public void verifyEmptySubscription() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        page.enterSubscriptionEmail("");
        page.clickSubscribe();
        String message = page.getSubscriptionMessage();
        Assert.assertTrue(
                message.contains("Invalid email address!") || message.contains("Please fill out this field"),
                "Empty subscription not handled: " + message
        );
    }

    // ---------- Footer ----------
    @Test
    public void verifyCopyright() {
        UI_Testcase_page page = new UI_Testcase_page(driver);
        Assert.assertTrue(page.isCopyrightDisplayed(),
                "Copyright text not visible");
    }
}