package com.automationexercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Product_page_ui_01;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Product_ui_01 extends BaseTest {
    
	TC_Product_page_ui_01 productsPage;

    @BeforeMethod
    public void setupPage() {
        productsPage = new TC_Product_page_ui_01(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (extent != null) {
            extent.flush();
        }
    }

    @Test
    public void TC01_verifyLogo() {
        ExtentTest test = extent.createTest("TC01_verifyLogo");
        try {
            boolean result = productsPage.isLogoDisplayed();
            if (result) {
                test.pass("Logo is displayed on Products page");
            } else {
                test.fail("Logo is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC01_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC02_verifyHomeButton() {
        ExtentTest test = extent.createTest("TC02_verifyHomeButton");
        try {
            boolean result = productsPage.isHomeDisplayed();
            if (result) {
                test.pass("Home button is displayed");
            } else {
                test.fail("Home button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC03_verifyProductsButton() {
        ExtentTest test = extent.createTest("TC03_verifyProductsButton");
        try {
            boolean result = productsPage.isProductsDisplayed();
            if (result) {
                test.pass("Products button is displayed");
            } else {
                test.fail("Products button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC04_verifyCartButton() {
        ExtentTest test = extent.createTest("TC04_verifyCartButton");
        try {
            boolean result = productsPage.isCartDisplayed();
            if (result) {
                test.pass("Cart button is displayed");
            } else {
                test.fail("Cart button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC05_verifySignupLoginButton() {
        ExtentTest test = extent.createTest("TC05_verifySignupLoginButton");
        try {
            boolean result = productsPage.isSignupLoginDisplayed();
            if (result) {
                test.pass("Signup/Login button is displayed");
            } else {
                test.fail("Signup/Login button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC06_verifyTestCasesButton() {
        ExtentTest test = extent.createTest("TC06_verifyTestCasesButton");
        try {
            boolean result = productsPage.isTestCasesDisplayed();
            if (result) {
                test.pass("Test Cases button is displayed");
            } else {
                test.fail("Test Cases button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC07_verifyApiTestingButton() {
        ExtentTest test = extent.createTest("TC07_verifyApiTestingButton");
        try {
            boolean result = productsPage.isApiTestingDisplayed();
            if (result) {
                test.pass("API Testing button is displayed");
            } else {
                test.fail("API Testing button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC08_verifyVideoTutorialsButton() {
        ExtentTest test = extent.createTest("TC08_verifyVideoTutorialsButton");
        try {
            boolean result = productsPage.isVideoTutorialsDisplayed();
            if (result) {
                test.pass("Video Tutorials link is displayed");
            } else {
                test.fail("Video Tutorials link is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC09_verifyContactUsButton() {
        ExtentTest test = extent.createTest("TC09_verifyContactUsButton");
        try {
            boolean result = productsPage.isContactUsDisplayed();
            if (result) {
                test.pass("Contact Us button is displayed");
            } else {
                test.fail("Contact Us button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }
    @Test
    public void TC10_verifyScrollBarPresent() {
        ExtentTest test = extent.createTest("TC10_verifyScrollBarPresent");
        try {
            boolean result = productsPage.isVerticalScrollBarPresent();
            if (result) {
                test.pass("Vertical scroll bar is present on Products page");
            } else {
                test.fail("Vertical scroll bar is NOT present")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }
}