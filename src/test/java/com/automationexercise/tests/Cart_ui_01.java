package com.automationexcercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automationexcercise.Base.BaseTest;
import com.automationexcercise.pages.TC_Cart_UI_01;
import com.automationexcercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Cart_ui_01 extends BaseTest {

    TC_Cart_UI_01 cartPage;

    @BeforeMethod
    public void setupPage() {
        cartPage = new TC_Cart_UI_01(driver);
      
    }

    @Test
    public void TC01_verifyLogo() {
        ExtentTest test = extent.createTest("TC01_verifyLogo");
        try {
        	cartPage.clickcartbtn();
        	test.pass("clicked on cart button on homepage");
        	if(cartPage.isCartPageheadingDisplayed()) {
        		test.pass("cart page opened");
        	} else {
        		test.fail("cart page not opened")
        		.addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC01_verifyCartLogo"));
        	}
            if (cartPage.isLogoVisible()) {
                test.pass("Logo is displayed on Cart page");
            } else {
                test.fail("Logo is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC01_verifyCartLogo"));
            } 
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
        }

        @Test
        public void TC02_verifyProductsIcon() {
            ExtentTest test = extent.createTest("TC02_verifyProductsIcon");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC02_verifyCartPage"));
                }
                if (cartPage.isProductsIconVisible()) {
                    test.pass("Products icon is visible on Cart page");
                } else {
                    test.fail("Products icon is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC02_verifyProductsIcon"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC03_verifyCartIcon() {
            ExtentTest test = extent.createTest("TC03_verifyCartIcon");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC03_verifyCartPage"));
                }
                if (cartPage.isCartIconVisible()) {
                    test.pass("Cart icon is visible on Cart page");
                } else {
                    test.fail("Cart icon is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC03_verifyCartIcon"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC04_verifySignupLoginIcon() {
            ExtentTest test = extent.createTest("TC04_verifySignupLoginIcon");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC04_verifyCartPage"));
                }
                if (cartPage.isSignupLoginIconVisible()) {
                    test.pass("Signup/Login icon is visible on Cart page");
                } else {
                    test.fail("Signup/Login icon is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC04_verifySignupLoginIcon"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC05_verifyTestCasesIcon() {
            ExtentTest test = extent.createTest("TC05_verifyTestCasesIcon");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC05_verifyCartPage"));
                }
                if (cartPage.isTestCasesIconVisible()) {
                    test.pass("Test Cases icon is visible on Cart page");
                } else {
                    test.fail("Test Cases icon is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC05_verifyTestCasesIcon"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC06_verifyAPITestingIcon() {
            ExtentTest test = extent.createTest("TC06_verifyAPITestingIcon");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC06_verifyCartPage"));
                }
                if (cartPage.isAPITestingIconVisible()) {
                    test.pass("API Testing icon is visible on Cart page");
                } else {
                    test.fail("API Testing icon is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC06_verifyAPITestingIcon"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC07_verifyVideoTutorialsIcon() {
            ExtentTest test = extent.createTest("TC07_verifyVideoTutorialsIcon");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC07_verifyCartPage"));
                }
                if (cartPage.isVideoTutorialsIconVisible()) {
                    test.pass("Video Tutorials icon is visible on Cart page");
                } else {
                    test.fail("Video Tutorials icon is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC07_verifyVideoTutorialsIcon"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC08_verifyContactUsIcon() {
            ExtentTest test = extent.createTest("TC08_verifyContactUsIcon");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC08_verifyCartPage"));
                }
                if (cartPage.isContactUsIconVisible()) {
                    test.pass("Contact Us icon is visible on Cart page");
                } else {
                    test.fail("Contact Us icon is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC08_verifyContactUsIcon"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC09_verifyEmptyCartMessage() {
            ExtentTest test = extent.createTest("TC09_verifyEmptyCartMessage");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC09_verifyCartPage"));
                }
                if (cartPage.isEmptyCartMessageVisible()) {
                    test.pass("Empty cart message is visible on Cart page");
                } else {
                    test.fail("Empty cart message is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC09_verifyEmptyCartMessage"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC10_verifyClickHereLink() {
            ExtentTest test = extent.createTest("TC10_verifyClickHereLink");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC10_verifyCartPage"));
                }
                if (cartPage.isClickHereLinkVisible()) {
                    test.pass("Click here link is visible on Cart page");
                } else {
                    test.fail("Click here link is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC10_verifyClickHereLink"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC11_verifySubscriptionSection() {
            ExtentTest test = extent.createTest("TC11_verifySubscriptionSection");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC11_verifyCartPage"));
                }
                if (cartPage.isSubscriptionSectionVisible()) {
                    test.pass("Subscription section is visible on Cart page");
                } else {
                    test.fail("Subscription section is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC11_verifySubscriptionSection"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC12_verifyEmailInput() {
            ExtentTest test = extent.createTest("TC12_verifyEmailInput");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC12_verifyCartPage"));
                }
                if (cartPage.isEmailInputVisible()) {
                    test.pass("Email input field is visible in Subscription section on Cart page");
                } else {
                    test.fail("Email input field is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC12_verifyEmailInput"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC13_verifySubmitButton() {
            ExtentTest test = extent.createTest("TC13_verifySubmitButton");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC13_verifyCartPage"));
                }
                if (cartPage.isSubmitButtonVisible()) {
                    test.pass("Subscription submit button is visible on Cart page");
                } else {
                    test.fail("Subscription submit button is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC13_verifySubmitButton"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC14_verifyFooterSection() {
            ExtentTest test = extent.createTest("TC14_verifyFooterSection");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC14_verifyCartPage"));
                }
                if (cartPage.isFooterSectionVisible()) {
                    test.pass("Footer section is visible on Cart page");
                } else {
                    test.fail("Footer section is NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC14_verifyFooterSection"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }

        @Test
        public void TC15_verifySocialMediaIcons() {
            ExtentTest test = extent.createTest("TC15_verifySocialMediaIcons");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC15_verifyCartPage"));
                }
                if (cartPage.areSocialMediaIconsVisible()) {
                    test.pass("Social media icons are visible on Cart page");
                } else {
                    test.fail("Social media icons are NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC15_verifySocialMediaIcons"));
                }
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }
        @Test
        public void TC16_verifyProductName() {
            ExtentTest test = extent.createTest("TC16_verifyProductName");
            try {
                cartPage.clickcartbtn();
                test.pass("Clicked on cart button on homepage");
                if(cartPage.isCartPageheadingDisplayed()) {
                    test.pass("Cart page opened");
                    
                } else {
                    test.fail("Cart page not opened")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC16_verifyCartPage"));
                }
                if(cartPage.clickherebtndisplayed()) {
                	test.pass("click here link visible");
                }
                else {
                	test.fail("click here link not visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC16_verifyCartPage"));
                }
               
               
            } catch (Exception e) {
                test.fail("Exception: " + e.getMessage());
            }
        }


}
