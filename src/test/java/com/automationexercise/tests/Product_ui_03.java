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
        	if(productPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
        		if(productPage.firstproductvisible()) {
        			test.pass("product is visible");
            if (productPage.isAddToCartIconDisplayed()) {
                test.pass("Add to Cart icon is displayed");
            } else {
                test.fail("Add to Cart icon is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC21_Fail"));
            }
        		} else {
       	    	 test.fail("product is not visible");
       	     }
       	} else {
           	test.fail("products page not opened");
           }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC22_verifyViewProductButton() {
        ExtentTest test = extent.createTest("TC22_verifyViewProductButton");
        try {
        	if(productPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
        		if(productPage.firstproductvisible()) {
        			test.pass("product is visible");
            if (productPage.isViewProductButtonDisplayed()) {
                test.pass("View Product button is displayed");
            } else {
                test.fail("View Product button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC22_Fail"));
            }
        		} else {
          	    	 test.fail("product is not visible");
          	     }
          	} else {
              	test.fail("products page not opened");
              }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC23_verifySubscriptionDisplayed() {
        ExtentTest test = extent.createTest("TC23_verifySubscriptionDisplayed");
        try {
        	 
             	if(productPage.isproductspageheadingdisplayed()) {
             		test.pass("clicked on products page");
             		test.pass("products page opened");
            if (productPage.isSubscriptionDisplayed()) {
                test.pass("Subscription section is displayed");
            } else {
                test.fail("Subscription section is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC23_Fail"));
            }
             	} else {
                  	test.fail("products page not opened");
                  }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
        
    }

    @Test
    public void TC24_verifyValidSubscriptionMail() {
        ExtentTest test = extent.createTest("TC24_verifyValidSubscriptionMail");
        try {
        	if(productPage.isproductspageheadingdisplayed()) {
         		test.pass("clicked on products page");
         		test.pass("products page opened");
                productPage.enterSubscriptionEmail("valid@gmail.com");
                test.pass("entered subscripton mail : valid@gmail.com");
            if (productPage.isSubscriptionSuccess()) {
                test.pass("Valid subscription mail accepted");
            } else {
                test.fail("Valid subscription mail NOT accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC24_Fail"));
            }
        	} else {
              	test.fail("products page not opened");
              }
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC25_verifyInvalidSubscriptionMail() {
        ExtentTest test = extent.createTest("TC25_verifyInvalidSubscriptionMail");
        try {
        	if(productPage.isproductspageheadingdisplayed()) {
         		test.pass("clicked on products page");
         		test.pass("products page opened");
                productPage.enterSubscriptionEmail("invalidMail@123");
                test.pass("entered subscripton mail : invalidMail@123");
            if (!productPage.isSubscriptionSuccess()) {
                test.pass("Invalid subscription mail correctly rejected");
            } else {
                test.fail("Invalid subscription mail NOT handled")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC25_Fail"));
            }
        	} else {
              	test.fail("products page not opened");
              }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC26_verifyEmptySubscriptionMail() {
        ExtentTest test = extent.createTest("TC26_verifyEmptySubscriptionMail");
        try {
        	if(productPage.isproductspageheadingdisplayed()) {
         		test.pass("clicked on products page");
         		test.pass("products page opened");
                productPage.enterSubscriptionEmail("");
                test.pass("subscription mail without mail");
            if (!productPage.isSubscriptionSuccess()) {
                test.pass("Empty subscription mail correctly handled");
            } else {
                test.fail("Empty subscription mail NOT handled")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC26_Fail"));
            } 
        	} else {
              	test.fail("products page not opened");
              }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC27_verifySubscriptionArrow() {
        ExtentTest test = extent.createTest("TC27_verifySubscriptionArrowWorks");
        try {
        	if(productPage.isproductspageheadingdisplayed()) {
         		test.pass("clicked on products page");
         		test.pass("products page opened");
            if (productPage.issubscribebuttonDisplayed()) {
                test.pass("Subscription arrow works with valid email");
            } else {
                test.fail("Subscription arrow NOT working properly")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC27_Fail"));
            } 
        	} else {
              	test.fail("products page not opened");
              }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC28_verifyCopyrightDisplayed() {
    	
        ExtentTest test = extent.createTest("TC28_verifyCopyrightDisplayed");
        try {
        	if(productPage.isproductspageheadingdisplayed()) {
         		test.pass("clicked on products page");
         		test.pass("products page opened");
            if (productPage.isCopyrightDisplayed()) {
                test.pass("Copyright is displayed");
            } else {
                test.fail("Copyright is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC28_Fail"));
            }
        	} else {
              	test.fail("products page not opened");
              }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC29_verifyTopArrowDisplayed() {
    	
        ExtentTest test = extent.createTest("TC29_verifyTopArrowDisplayed");
        try {
        	if(productPage.isproductspageheadingdisplayed()) {
         		test.pass("clicked on products page");
         		test.pass("products page opened");
            if (productPage.isTopArrowDisplayed()) {
                test.pass("Top arrow is displayed");
            } else {
                test.fail("Top arrow is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC29_Fail"));
            }
        	} else {
              	test.fail("products page not opened");
              }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }
}