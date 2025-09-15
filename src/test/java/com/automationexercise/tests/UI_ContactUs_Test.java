package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.ContactUsPage;

public class UI_ContactUs_Test extends BaseTest {

    private ContactUsPage contactPage;

    @BeforeMethod
    public void initPage() {
        contactPage = new ContactUsPage(driver);
    }

    // ---------- Page Title & Favicon ----------
    @Test
    public void verifyPageTitle() {
        Assert.assertTrue(contactPage.getPageTitle().toLowerCase().contains("contact"),
                "Page title mismatch! Got: " + contactPage.getPageTitle());
    }

    @Test
    public void verifyFaviconExists() {
        String href = contactPage.getFaviconHref();
        Assert.assertTrue(href != null && !href.isEmpty(), "Favicon missing!");
    }

    // ---------- Header Icons ----------
    @Test public void verifyHomeIconVisible()        { Assert.assertTrue(contactPage.isHomeIconVisible()); }
    @Test public void verifyProductsIconVisible()    { Assert.assertTrue(contactPage.isProductsIconVisible()); }
   
    @Test public void verifySignupLoginIconVisible() { Assert.assertTrue(contactPage.isSignupLoginIconVisible()); }
    @Test public void verifyTestCasesIconVisible()   { Assert.assertTrue(contactPage.isTestCasesIconVisible()); }
    @Test public void verifyApiTestingIconVisible()  { Assert.assertTrue(contactPage.isApiTestingIconVisible()); }
    @Test public void verifyContactUsIconVisible()   { Assert.assertTrue(contactPage.isContactUsIconVisible()); }

    // ---------- Header Icons Click Functionality ----------
    @Test public void verifyHomeClickWorks()        { Assert.assertTrue(contactPage.clickHomeAndVerify()); }
    @Test public void verifyProductsClickWorks()    { Assert.assertTrue(contactPage.clickProductsAndVerify()); }
    @Test public void verifyCartClickWorks()        { Assert.assertTrue(contactPage.clickCartAndVerify()); }
    @Test public void verifySignupLoginClickWorks() { Assert.assertTrue(contactPage.clickSignupLoginAndVerify()); }
    @Test public void verifyTestCasesClickWorks()   { Assert.assertTrue(contactPage.clickTestCasesAndVerify()); }
    @Test public void verifyApiTestingClickWorks()  { Assert.assertTrue(contactPage.clickApiTestingAndVerify()); }
    @Test public void verifyContactUsClickWorks()   { Assert.assertTrue(contactPage.clickContactUsAndVerify()); }

    // ---------- Logo ----------
    @Test
    public void verifyLogoVisible() {
        Assert.assertTrue(contactPage.isLogoVisible(), "Logo not visible!");
    }

    // ---------- Subscription ----------
    @Test
    public void verifySubscriptionVisible() {
        Assert.assertTrue(contactPage.isSubscriptionVisible(), "Subscription section not visible!");
    }

    
   
    @Test
    public void verifyScrollUpVisible() {
        Assert.assertTrue(contactPage.isScrollUpVisibleAfterScroll(), "ScrollUp not visible!");
    }

    @Test
    public void verifyScrollUpClickWorks() {
        Assert.assertTrue(contactPage.clickScrollUpAndVerifyTop(), "Scroll up did not return to top!");
    }

    // ---------- Contact Form ----------
    @Test public void verifyNamePlaceholder()    { Assert.assertTrue(contactPage.getNamePlaceholder().length() > 0); }
    @Test public void verifyEmailPlaceholder()   { Assert.assertTrue(contactPage.getEmailPlaceholder().length() > 0); }
    @Test public void verifySubjectPlaceholder() { Assert.assertTrue(contactPage.getSubjectPlaceholder().length() > 0); }
    @Test public void verifyMessagePlaceholder() { Assert.assertTrue(contactPage.getMessagePlaceholder().length() > 0); }

    @Test
    public void verifySubmitButtonVisible() {
        Assert.assertTrue(contactPage.submitButton().isDisplayed(), "Submit button missing!");
    }

    @Test
    public void verifyFileUploadInputVisible() {
        Assert.assertTrue(contactPage.uploadFileInput().isDisplayed(), "File upload input missing!");
    }

    @Test
    public void verifyFileUploadWorks() throws Exception {
        String filePath = contactPage.ensureTempFile("dummy.txt");
        contactPage.uploadFileInput().sendKeys(filePath);
        Assert.assertTrue(contactPage.uploadFileInput().getAttribute("value").contains("dummy.txt"),
                "File not uploaded correctly!");
    }
}