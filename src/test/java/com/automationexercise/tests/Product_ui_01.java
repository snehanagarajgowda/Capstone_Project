package com.automationexcercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.automationexcercise.Base.BaseTest;
import com.automationexcercise.pages.TC_Product_page_ui_01;
import com.automationexcercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Product_ui_01 extends BaseTest {
    
	TC_Product_page_ui_01 productspage;

    @BeforeMethod
    public void setupPage() {
        productspage = new TC_Product_page_ui_01(driver);
        
        productspage.clickproductbtn();
        
    }   
    @Test
    public void TC01_verifyLogo() {
        ExtentTest test = extent.createTest("TC01_verifyLogo");
        try {
        	if(productspage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
        		if (productspage.isproductslogodisplayed()) {
                	
                    test.pass("Logo is displayed on Products page");
                } else {
                    test.fail("Logo is NOT displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC01_Fail"));
                }
        	} else { test.fail("product page not opened"); }
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC02_verifyHomeButton() {
        ExtentTest test = extent.createTest("TC02_verifyHomeButton");
        try {
        	if(productspage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page button");
        		test.pass("products page opened");
        		if (productspage.isHomeDisplayed()) {
                    test.pass("Home button is displayed");
                } else {
                    test.fail("Home button is NOT displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC02_Fail"));
                }
        	} else {
        		test.fail("products page not opened");
        	}
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC03_verifyProductsButton() {
        ExtentTest test = extent.createTest("TC03_verifyProductsButton");
        try {
        	if(productspage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page button");
        		test.pass("products page opened");
        		if (productspage.isProductsDisplayed()) {
                    test.pass("Products button is displayed");
                } else {
                    test.fail("Products button is NOT displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC03_Fail"));
                }
        	} else {
        		test.fail("products page not opened");
        	}
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC04_verifyCartButton() {
        ExtentTest test = extent.createTest("TC04_verifyCartButton");
        try {
        	if(productspage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page button");
        		test.pass("products page opened");
        		if (productspage.isCartDisplayed()) {
                    test.pass("Cart button is displayed");
                } else {
                    test.fail("Cart button is NOT displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC04_Fail"));
                }
        	} else {
        		test.fail("products page not opened");
        	}
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC05_verifySignupLoginButton() {
        ExtentTest test = extent.createTest("TC05_verifySignupLoginButton");
        try {
        	if(productspage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page button");
        		test.pass("products page opened");
        		if (productspage.isSignupLoginDisplayed()) {
                    test.pass("Signup/Login button is displayed");
                } else {
                    test.fail("Signup/Login button is NOT displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC05_Fail"));
                }
        	} else {
        		test.fail("products page not opened");
        	}
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC06_verifyTestCasesButton() {
        ExtentTest test = extent.createTest("TC06_verifyTestCasesButton");
        try {
        	if(productspage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page button");
        		test.pass("products page opened");
        		 if (productspage.isTestCasesDisplayed()) {
                     test.pass("Test Cases button is displayed");
                 } else {
                     test.fail("Test Cases button is NOT displayed")
                         .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC06_Fail"));
                 }
        	} else {
        		test.fail("products page not opened");
        	}
           
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC07_verifyApiTestingButton() {
        ExtentTest test = extent.createTest("TC07_verifyApiTestingButton");
        try {
        	if(productspage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page button");
        		test.pass("products page opened");
        		if (productspage.isApiTestingDisplayed()) {
                    test.pass("API Testing button is displayed");
                } else {
                    test.fail("API Testing button is NOT displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC07_Fail"));
                }
        	} else {
        		test.fail("products page not opened");
        	}
            
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC08_verifyVideoTutorialsButton() {
        ExtentTest test = extent.createTest("TC08_verifyVideoTutorialsButton");
        try {
        	if(productspage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page button");
        		test.pass("products page opened");
        		if (productspage.isVideoTutorialsDisplayed()) {
                    test.pass("Video Tutorials link is displayed");
                } else {
                    test.fail("Video Tutorials link is NOT displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC08_Fail"));
                }
        	} else {
        		test.fail("products page not opened");
        	}
            
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC09_verifyContactUsButton() {
        ExtentTest test = extent.createTest("TC09_verifyContactUsButton");
        try {
        	if(productspage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page button");
        		test.pass("products page opened");
        		if (productspage.isContactUsDisplayed()) {
                    test.pass("Contact Us button is displayed");
                } else {
                    test.fail("Contact Us button is NOT displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC09_Fail"));
                } 
        	} else {
        		test.fail("products page not opened");
        	}
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }
    @Test
    public void TC10_verifyScrollBarPresent() {
        ExtentTest test = extent.createTest("TC10_verifyScrollBarPresent");
        try {
        	if(productspage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page button");
        		test.pass("products page opened");
        		if (productspage.isVerticalScrollBarPresent()) {
                    test.pass("Vertical scroll bar is present on Products page");
                } else {
                    test.fail("Vertical scroll bar is NOT present")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC10_Fail"));
                }
        	} else {
        		test.fail("products page not opened");
        	}
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }
}
