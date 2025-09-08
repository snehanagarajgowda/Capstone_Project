package com.automationexercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Freq_func_reg_01;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Freq_func_reg_01 extends BaseTest {

    TC_Freq_func_reg_01 freqPage;

    @BeforeMethod
    public void setupPage() {
        freqPage = new TC_Freq_func_reg_01(driver);
    }

    @Test
    public void TC01_verifyApiHomeBtn() {
        ExtentTest test = extent.createTest("TC01_verifyApiHomeBtn");
        try {
            if (freqPage.isApiHomeBtnDisplayed()) {
                test.pass("API Home button is displayed");
            } else {
                test.fail("API Home button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC01_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC02_verifyApiProductsBtn() {
        ExtentTest test = extent.createTest("TC02_verifyApiProductsBtn");
        try {
            if (freqPage.isApiProductsBtnDisplayed()) {
                test.pass("API Products button is displayed");
            } else {
                test.fail("API Products button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC03_verifyApiCartBtn() {
        ExtentTest test = extent.createTest("TC03_verifyApiCartBtn");
        try {
            if (freqPage.isApiCartBtnDisplayed()) {
                test.pass("API Cart button is displayed");
            } else {
                test.fail("API Cart button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC04_verifyApiLoginBtn() {
        ExtentTest test = extent.createTest("TC04_verifyApiLoginBtn");
        try {
            if (freqPage.isApiLoginBtnDisplayed()) {
                test.pass("API Login button is displayed");
            } else {
                test.fail("API Login button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC05_verifyApiContactBtn() {
        ExtentTest test = extent.createTest("TC05_verifyApiContactBtn");
        try {
            if (freqPage.isApiContactBtnDisplayed()) {
                test.pass("API Contact Us button is displayed");
            } else {
                test.fail("API Contact Us button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC06_verifyRecommendedItems() {
        ExtentTest test = extent.createTest("TC06_verifyRecommendedItems");
        try {
            if (freqPage.isRecommendedItemsDisplayed()) {
                test.pass("Recommended items are displayed");
            } else {
                test.fail("Recommended items NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC07_verifyHomeBtn() {
        ExtentTest test = extent.createTest("TC07_verifyHomeBtn");
        try {
            if (freqPage.isHomeBtnDisplayed()) {
                test.pass("Home button is displayed");
            } else {
                test.fail("Home button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC08_verifyProductsBtn() {
        ExtentTest test = extent.createTest("TC08_verifyProductsBtn");
        try {
            if (freqPage.isProductsBtnDisplayed()) {
                test.pass("Products button is displayed");
            } else {
                test.fail("Products button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC09_verifyCartBtn() {
        ExtentTest test = extent.createTest("TC09_verifyCartBtn");
        try {
            if (freqPage.isCartBtnDisplayed()) {
                test.pass("Cart button is displayed");
            } else {
                test.fail("Cart button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC10_verifyLoginBtn() {
        ExtentTest test = extent.createTest("TC10_verifyLoginBtn");
        try {
            if (freqPage.isLoginBtnDisplayed()) {
                test.pass("Login button is displayed");
            } else {
                test.fail("Login button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC11_verifyTestCasesBtn() {
        ExtentTest test = extent.createTest("TC11_verifyTestCasesBtn");
        try {
            if (freqPage.isTestCasesBtnDisplayed()) {
                test.pass("Test Cases button is displayed");
            } else {
                test.fail("Test Cases button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC12_verifyApiTestingBtn() {
        ExtentTest test = extent.createTest("TC12_verifyApiTestingBtn");
        try {
            if (freqPage.isApiTestingBtnDisplayed()) {
                test.pass("API Testing button is displayed");
            } else {
                test.fail("API Testing button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC13_verifyVideoTutorialsBtn() {
        ExtentTest test = extent.createTest("TC13_verifyVideoTutorialsBtn");
        try {
            if (freqPage.isVideoTutorialsBtnDisplayed()) {
                test.pass("Video Tutorials button is displayed");
            } else {
                test.fail("Video Tutorials button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC14_verifyContactHomeBtn() {
        ExtentTest test = extent.createTest("TC14_verifyContactHomeBtn");
        try {
            if (freqPage.isContactHomeBtnDisplayed()) {
                test.pass("Contact Us button is displayed");
            } else {
                test.fail("Contact Us button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC15_verifySubscriptionSection() {
        ExtentTest test = extent.createTest("TC15_verifySubscriptionSection");
        try {
            if (freqPage.isSubscriptionDisplayed()) {
                test.pass("Subscription section is displayed");
            } else {
                test.fail("Subscription section NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC15_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }
}