package com.automationexcercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automationexcercise.Base.BaseTest;
import com.automationexcercise.pages.TC_Product_page_ui_03;
import com.automationexcercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Product_ui_03 extends BaseTest {
    
    TC_Product_page_ui_03 productPage;

    @BeforeMethod
    public void setupPage() {
        productPage = new TC_Product_page_ui_03(driver);
        productPage.clickproductsbutton();
    }

    @Test
    public void TC21_verifyAddToCartIcon() {
        ExtentTest test = extent.createTest("TC21_verifyAddToCartIcon");
        try {
            boolean result = productPage.isAddToCartIconDisplayed();
            if (result) {
                test.pass("Add to Cart icon is displayed");
            } else {
                test.fail("Add to Cart icon is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC21_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC22_verifyViewProductButton() {
        ExtentTest test = extent.createTest("TC22_verifyViewProductButton");
        try {
            boolean result = productPage.isViewProductButtonDisplayed();
            if (result) {
                test.pass("View Product button is displayed");
            } else {
                test.fail("View Product button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC22_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC23_verifySubscriptionDisplayed() {
        ExtentTest test = extent.createTest("TC23_verifySubscriptionDisplayed");
        try {
            boolean result = productPage.isSubscriptionDisplayed();
            if (result) {
                test.pass("Subscription section is displayed");
            } else {
                test.fail("Subscription section is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC23_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC24_verifyValidSubscriptionMail() {
        ExtentTest test = extent.createTest("TC24_verifyValidSubscriptionMail");
        try {
            productPage.enterSubscriptionEmail("valid@email.com");
            boolean result = productPage.isSubscriptionSuccess();
            if (result) {
                test.pass("Valid subscription mail accepted");
            } else {
                test.fail("Valid subscription mail NOT accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC24_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC25_verifyInvalidSubscriptionMail() {
        ExtentTest test = extent.createTest("TC25_verifyInvalidSubscriptionMail");
        try {
            productPage.enterSubscriptionEmail("invalidMail@gmail.com");
            boolean result = productPage.isSubscriptionSuccess();
            if (!result) {
                test.pass("Invalid subscription mail correctly rejected");
            } else {
                test.fail("Invalid subscription mail NOT handled")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC25_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC26_verifyEmptySubscriptionMail() {
        ExtentTest test = extent.createTest("TC26_verifyEmptySubscriptionMail");
        try {
            productPage.enterSubscriptionEmail("");
            boolean result = productPage.isSubscriptionSuccess();
            if (!result) {
                test.pass("Empty subscription mail correctly handled");
            } else {
                test.fail("Empty subscription mail NOT handled")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC26_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC27_verifySubscriptionArrowWorks() {
        ExtentTest test = extent.createTest("TC27_verifySubscriptionArrowWorks");
        try {
            productPage.enterSubscriptionEmail("valid@email.com");
            boolean result = productPage.isSubscriptionSuccess();
            if (result) {
                test.pass("Subscription arrow works with valid email");
            } else {
                test.fail("Subscription arrow NOT working properly")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC27_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC28_verifyCopyrightDisplayed() {
    	
        ExtentTest test = extent.createTest("TC28_verifyCopyrightDisplayed");
        try {
            boolean result = productPage.isCopyrightDisplayed();
            if (result) {
                test.pass("Copyright is displayed");
            } else {
                test.fail("Copyright is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC28_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC29_verifyTopArrowDisplayed() {
    	
        ExtentTest test = extent.createTest("TC29_verifyTopArrowDisplayed");
        try {
            boolean result = productPage.isTopArrowDisplayed();
            if (result) {
                test.pass("Top arrow is displayed");
            } else {
                test.fail("Top arrow is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC29_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }
}