package com.automationexercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_TestCase_UI_01;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TestCase_ui_01 extends BaseTest {

    TC_TestCase_UI_01 testCasesPage;

    @BeforeMethod
    public void setupPage() {
        testCasesPage = new TC_TestCase_UI_01(driver);
    }

    @Test
    public void TC01_verifyLogo() {
        ExtentTest test = extent.createTest("TC01_verifyLogo");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isLogoVisible()) {
                    test.pass("Logo is visible on Test Cases page");
                } else {
                    test.fail("Logo NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC01_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC01_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC02_verifyHomeButton() {
        ExtentTest test = extent.createTest("TC02_verifyHomeButton");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isHomeButtonVisible()) {
                    test.pass("Home button is visible");
                } else {
                    test.fail("Home button NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC02_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC02_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC03_verifyProductsButton() {
        ExtentTest test = extent.createTest("TC03_verifyProductsButton");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isProductsButtonVisible()) {
                    test.pass("Products button is visible");
                } else {
                    test.fail("Products button NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC03_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC03_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC04_verifyCartButton() {
        ExtentTest test = extent.createTest("TC04_verifyCartButton");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isCartButtonVisible()) {
                    test.pass("Cart button is visible");
                } else {
                    test.fail("Cart button NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC04_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC04_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC05_verifySignupLoginButton() {
        ExtentTest test = extent.createTest("TC05_verifySignupLoginButton");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isSignupLoginButtonVisible()) {
                    test.pass("Signup/Login button is visible");
                } else {
                    test.fail("Signup/Login button NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC05_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC05_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC06_verifyTestCasesButton() {
        ExtentTest test = extent.createTest("TC06_verifyTestCasesButton");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isTestCasesButtonVisible()) {
                    test.pass("Test Cases button is visible");
                } else {
                    test.fail("Test Cases button NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC06_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC06_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC07_verifyAPITestingButton() {
        ExtentTest test = extent.createTest("TC07_verifyAPITestingButton");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isAPITestingButtonVisible()) {
                    test.pass("API Testing button is visible");
                } else {
                    test.fail("API Testing button NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC07_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC07_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC08_verifyVideoTutorialsButton() {
        ExtentTest test = extent.createTest("TC08_verifyVideoTutorialsButton");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isVideoTutorialsButtonVisible()) {
                    test.pass("Video Tutorials button is visible");
                } else {
                    test.fail("Video Tutorials button NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC08_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC08_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC09_verifyContactUsButton() {
        ExtentTest test = extent.createTest("TC09_verifyContactUsButton");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isContactUsButtonVisible()) {
                    test.pass("Contact Us button is visible");
                } else {
                    test.fail("Contact Us button NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC09_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC09_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC10_verifyScrollBar() {
        ExtentTest test = extent.createTest("TC10_verifyScrollBar");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(!testCasesPage.isScrollBarVisible()) {
                    test.pass("Scroll bar is visible");
                } else {
                    test.fail("Scroll bar NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC10_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC10_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC11_verifyTestCasesWord() {
        ExtentTest test = extent.createTest("TC11_verifyTestCasesWord");
        try {
            testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isTestCasesWordVisible()) {
                    test.pass("Test Cases word is displayed");
                } else {
                    test.fail("Test Cases word NOT displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC11_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC11_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC12_verifyAllTestCasesDisplayed() {
        ExtentTest test = extent.createTest("TC12_verifyAllTestCasesDisplayed");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.areAllTestCasesDisplayed()) {
                    test.pass("All test cases are displayed");
                } else {
                    test.fail("All test cases NOT displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC12_Fail"));
                }
            } else {
                test.fail("Test Cases page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver,"TC12_Fail"));
            }
        } catch(Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }
}
