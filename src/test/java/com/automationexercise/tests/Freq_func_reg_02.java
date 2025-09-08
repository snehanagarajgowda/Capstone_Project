package com.automationexercise.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Freq_func_reg_02;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Freq_func_reg_02 extends BaseTest {

    TC_Freq_func_reg_02 freqPage2;

    @BeforeMethod
    public void setupPage() {
        freqPage2 = new TC_Freq_func_reg_02(driver);
    }

    @Test
    public void TC16_verifyCartProductsIcon() {
        ExtentTest test = extent.createTest("TC16_verifyCartProductsIcon");
        try {
            if (freqPage2.isCartProductsIconDisplayed()) {
                test.pass("Cart page Products icon is displayed");
            } else {
                test.fail("Cart page Products icon NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC17_verifyCartIcon() {
        ExtentTest test = extent.createTest("TC17_verifyCartIcon");
        try {
            if (freqPage2.isCartIconDisplayed()) {
                test.pass("Cart icon is displayed");
            } else {
                test.fail("Cart icon NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC18_verifyCartLoginIcon() {
        ExtentTest test = extent.createTest("TC18_verifyCartLoginIcon");
        try {
            if (freqPage2.isCartLoginIconDisplayed()) {
                test.pass("Cart page Login icon is displayed");
            } else {
                test.fail("Cart page Login icon NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC18_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC19_verifyCartTestCasesIcon() {
        ExtentTest test = extent.createTest("TC19_verifyCartTestCasesIcon");
        try {
            if (freqPage2.isCartTestCasesIconDisplayed()) {
                test.pass("Cart page Test Cases icon is displayed");
            } else {
                test.fail("Cart page Test Cases icon NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC19_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC20_verifyCartApiTestingIcon() {
        ExtentTest test = extent.createTest("TC20_verifyCartApiTestingIcon");
        try {
            if (freqPage2.isCartApiTestingIconDisplayed()) {
                test.pass("Cart page API Testing icon is displayed");
            } else {
                test.fail("Cart page API Testing icon NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC20_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC21_verifyCartVideoTutorialsIcon() {
        ExtentTest test = extent.createTest("TC21_verifyCartVideoTutorialsIcon");
        try {
            if (freqPage2.isCartVideoTutorialsIconDisplayed()) {
                test.pass("Cart page Video Tutorials icon is displayed");
            } else {
                test.fail("Cart page Video Tutorials icon NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC21_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC22_verifyCartContactUsIcon() {
        ExtentTest test = extent.createTest("TC22_verifyCartContactUsIcon");
        try {
            if (freqPage2.isCartContactUsIconDisplayed()) {
                test.pass("Cart page Contact Us icon is displayed");
            } else {
                test.fail("Cart page Contact Us icon NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC22_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC23_verifyProductsCopyright() {
        ExtentTest test = extent.createTest("TC23_verifyProductsCopyright");
        try {
            if (freqPage2.isProductsCopyrightDisplayed()) {
                test.pass("Products page copyright is displayed");
            } else {
                test.fail("Products page copyright NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC23_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC24_verifyProductsTopArrow() {
        ExtentTest test = extent.createTest("TC24_verifyProductsTopArrow");
        try {
            if (freqPage2.isProductsTopArrowDisplayed()) {
                test.pass("Products page Top arrow is displayed");
            } else {
                test.fail("Products page Top arrow NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC24_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC25_verifySearchBoxOnProductsPage() {
        ExtentTest test = extent.createTest("TC25_verifySearchBoxOnProductsPage");
        try {
            // Navigate to Products page first
            driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();

            boolean result = freqPage2.isSearchBoxDisplayed();
            if (result) {
            	freqPage2.enterSearchText("Tshirt");
            	freqPage2.clickSearchButton();
                test.pass("Search input box is displayed and functional");
            } else {
                test.fail("Search input box is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC25_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }


    @Test
    public void TC26_verifyClickProductsBtn() {
        ExtentTest test = extent.createTest("TC26_verifyClickProductsBtn");
        try {
            freqPage2.clickProductsBtn();
            test.pass("Products button clicked successfully");
        } catch (Exception e) {
            test.fail("Exception while clicking Products button: " + e.getMessage());
        }
    }
    @Test
    public void TC27_verifyClickViewCartBtn() {
        ExtentTest test = extent.createTest("TC27_verifyClickViewCartBtn");
        try {
            freqPage2.clickProductsBtn();
            
            freqPage2.clickaddtocart();
            freqPage2.clickViewCartBtn();
            System.out.println("clicked");
            if (freqPage2.isproceedtochecoutDisplayed()) {
                test.pass("proceed to checkout is displayed, verified view cart");
            } else {
                test.fail("proceed to checkout NOT displayed. view cart not clciked")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_Fail"));
            }
            
        } catch (Exception e) {
            test.fail("Exception while clicking View Cart button: " + e.getMessage());
        }
    }


    @Test
    public void TC28_verifyProductsLogo() {
        ExtentTest test = extent.createTest("TC28_verifyProductsLogo");
        try {
            if (freqPage2.isProductsLogoDisplayed()) {
                test.pass("Products page logo is displayed");
            } else {
                test.fail("Products page logo NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC29_verifyProductsHomeBtn() {
        ExtentTest test = extent.createTest("TC29_verifyProductsHomeBtn");
        try {
            if (freqPage2.isProductsHomeBtnDisplayed()) {
                test.pass("Products page Home button is displayed");
            } else {
                test.fail("Products page Home button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC30_verifyProductsBtn() {
        ExtentTest test = extent.createTest("TC30_verifyProductsBtn");
        try {
            if (freqPage2.isProductsBtnDisplayed()) {
                test.pass("Products button is displayed");
            } else {
                test.fail("Products button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC31_verifyProductsCartBtn() {
        ExtentTest test = extent.createTest("TC31_verifyProductsCartBtn");
        try {
            if (freqPage2.isProductsCartBtnDisplayed()) {
                test.pass("Products page Cart button is displayed");
            } else {
                test.fail("Products page Cart button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC32_verifyProductsLoginBtn() {
        ExtentTest test = extent.createTest("TC32_verifyProductsLoginBtn");
        try {
            if (freqPage2.isProductsLoginBtnDisplayed()) {
                test.pass("Products page Login button is displayed");
            } else {
                test.fail("Products page Login button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC33_verifyProductsTestCasesBtn() {
        ExtentTest test = extent.createTest("TC33_verifyProductsTestCasesBtn");
        try {
            if (freqPage2.isProductsTestCasesBtnDisplayed()) {
                test.pass("Products page Test Cases button is displayed");
            } else {
                test.fail("Products page Test Cases button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC34_verifyProductsApiTestingBtn() {
        ExtentTest test = extent.createTest("TC34_verifyProductsApiTestingBtn");
        try {
            if (freqPage2.isProductsApiTestingBtnDisplayed()) {
                test.pass("Products page API Testing button is displayed");
            } else {
                test.fail("Products page API Testing button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }

    @Test
    public void TC35_verifyProductsVideoTutorialsBtn() {
        ExtentTest test = extent.createTest("TC35_verifyProductsVideoTutorialsBtn");
        try {
            if (freqPage2.isProductsVideoTutorialsBtnDisplayed()) {
                test.pass("Products page Video Tutorials button is displayed");
            } else {
                test.fail("Products page Video Tutorials button NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_Fail"));
            }
        } catch (Exception e) { test.fail("Exception: " + e.getMessage()); }
    }
}