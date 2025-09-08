package com.automationexercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Products_page_ui_02;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Product_ui_02 extends BaseTest {

    TC_Products_page_ui_02 productsPage;

    @BeforeMethod
    public void setUpPage() {
        productsPage = new TC_Products_page_ui_02(driver);
        productsPage.clickproductsbutton();
    }
    @Test
    public void TC11_verifySpecialOfferDisplayed() {
        ExtentTest test = extent.createTest("TC11_verifySpecialOfferDisplayed");
        try {
            if (productsPage.isSpecialOfferDisplayed()) {
                test.pass("Special offer is displayed on Products page");
            } else {
                test.fail("Special offer is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC12_verifySearchBoxDisplayed() {
        ExtentTest test = extent.createTest("TC12_verifySearchBoxDisplayed");
        try {
            if (productsPage.isSearchBoxDisplayed() && productsPage.isSearchButtonDisplayed()) {
                test.pass("Search input box & button are displayed");
            } else {
                test.fail("Search box or button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC13_verifyCategorySectionDisplayed() {
        ExtentTest test = extent.createTest("TC13_verifyCategorySectionDisplayed");
        try {
            if (productsPage.isCategorySectionDisplayed()) {
                test.pass("Category section is displayed");
            } else {
                test.fail("Category section is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC14_verifyBrandsSectionDisplayed() {
        ExtentTest test = extent.createTest("TC14_verifyBrandsSectionDisplayed");
        try {
            if (productsPage.isBrandsSectionDisplayed()) {
                test.pass("Brands section is displayed");
            } else {
                test.fail("Brands section is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC15_verifyAllProductsDisplayed() {
        ExtentTest test = extent.createTest("TC15_verifyAllProductsDisplayed");
        try {
            if (productsPage.areProductsDisplayed()) {
                test.pass("All products are displayed");
            } else {
                test.fail("Products are NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC15_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC16_verifyProductNameDisplayed() {
        ExtentTest test = extent.createTest("TC16_verifyProductNameDisplayed");
        try {
            if (productsPage.isProductNameDisplayed()) {
                test.pass("Product name is displayed");
            } else {
                test.fail("Product name is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC17_verifyProductPriceDisplayed() {
        ExtentTest test = extent.createTest("TC17_verifyProductPriceDisplayed");
        try {
            if (productsPage.isProductPriceDisplayed()) {
                test.pass("Product price is displayed");
            } else {
                test.fail("Product price is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC18_verifyHoverEffectOnProduct() {
        ExtentTest test = extent.createTest("TC18_verifyHoverEffectOnProduct");
        try {
            if (productsPage.isHoverEffectWorking()) {
                test.pass("Hover effect is working on product");
            } else {
                test.fail("Hover effect is NOT working")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC18_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }
}