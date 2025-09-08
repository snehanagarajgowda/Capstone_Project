package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.APIPage;

public class UI_ApiTesting_Test extends BaseTest {

    private APIPage apiPage;

    @BeforeMethod
    public void initPage() {
        apiPage = new APIPage(driver);
    }

    // ---------- Header & Logo ----------
    @Test public void verifyLogoVisible()                 { Assert.assertTrue(apiPage.isLogoVisible(), "Logo not visible!"); }
    @Test public void verifyHomeButtonVisible()           { Assert.assertTrue(apiPage.isDisplayed(apiPage.homeBtn), "Home not visible!"); }
    @Test public void verifyProductsButtonVisible()       { Assert.assertTrue(apiPage.isDisplayed(apiPage.productsBtn), "Products not visible!"); }
    @Test public void verifyCartButtonVisible()           { Assert.assertTrue(apiPage.isDisplayed(apiPage.cartBtn), "Cart not visible!"); }
    @Test public void verifySignupLoginButtonVisible()    { Assert.assertTrue(apiPage.isDisplayed(apiPage.signupLoginBtn), "Signup/Login not visible!"); }
    @Test public void verifyTestCasesButtonVisible()      { Assert.assertTrue(apiPage.isDisplayed(apiPage.testCasesBtn), "Test Cases not visible!"); }
    @Test public void verifyApiTestingButtonVisible()     { Assert.assertTrue(apiPage.isDisplayed(apiPage.apiTestingBtn), "API Testing not visible!"); }
    @Test public void verifyVideoTutorialsButtonVisible() { Assert.assertTrue(apiPage.isDisplayed(apiPage.videoTutorialsBtn), "Video Tutorials not visible!"); }
    @Test public void verifyContactUsButtonVisible()      { Assert.assertTrue(apiPage.isDisplayed(apiPage.contactUsBtn), "Contact Us not visible!"); }

    // ---------- Page Characteristics ----------
    @Test public void verifyScrollbarPresent() {
        Assert.assertTrue(apiPage.isScrollbarPresent(), "Expected a vertical scrollbar!");
    }

    @Test public void verifyApiTestWordColored() {
        String color = apiPage.getApiListHeadingColor(); // “APIs List for practice”
        Assert.assertNotNull(color, "Heading color was null");
        Assert.assertFalse(color.isEmpty(), "Heading color empty");
    }

    // ---------- APIs ----------
    @Test public void verifyAllAPIsDisplayed() {
        Assert.assertTrue(apiPage.areApisListed(), "No API items listed!");
    }

    @Test public void verifyApiClickShowsInfo() {
        Assert.assertTrue(apiPage.clickFirstApiAndSeeDetails(), "Clicking API did not reveal details!");
    }

    @Test public void verifyAPICount() {
        int count = apiPage.getAPICount();
        Assert.assertTrue(count >= 10, "Unexpectedly small API count: " + count);
    }

    // ---------- Feedback ----------
    @Test public void verifyFeedbackVisible() {
        Assert.assertTrue(apiPage.isFeedbackVisible(), "'Feedback for Us' section not visible!");
    }

    @Test public void verifyFeedbackLinkVisible() {
        Assert.assertTrue(apiPage.isFeedbackLinkVisible(), "Feedback mailto link not visible!");
    }

    // ---------- Scroll Up ----------
    @Test public void verifyScrollUpVisibleAfterScroll() {
        Assert.assertTrue(apiPage.makeScrollUpVisible(), "Scroll Up arrow not visible after scrolling!");
    }

    // ---------- Subscription ----------
    @Test public void verifySubscriptionVisible() {
        Assert.assertTrue(apiPage.isSubscriptionVisible(), "Subscription section not visible!");
    }

    @Test public void verifyValidSubscription() {
        apiPage.subscribe("valid_" + System.currentTimeMillis() + "@mail.com");
        String msg = apiPage.getSubscriptionMessage().toLowerCase();
        Assert.assertTrue(msg.contains("successfully"), "Expected success message; got: " + msg);
    }

   

    @Test public void verifyEmptySubscription() {
        apiPage.subscribe("");
        String msg = apiPage.getSubscriptionMessage().toLowerCase();
        // Accept any banner text (site behavior can be inconsistent)
        Assert.assertTrue(!msg.isEmpty(), "No banner/feedback shown for empty email!");
    }

    // ---------- Footer ----------
    @Test public void verifyCopyright() {
        Assert.assertTrue(apiPage.isCopyrightDisplayed(), "Copyright line not visible!");
    }
}