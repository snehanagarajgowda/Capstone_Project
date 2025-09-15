package com.automationexcercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automationexcercise.Base.BaseTest;
import com.automationexcercise.pages.TC_TestCase_UI_02;
import com.automationexcercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TestCase_ui_02 extends BaseTest {

    TC_TestCase_UI_02 testCasesPage;
    @BeforeMethod
    public void setupPage() {
        testCasesPage = new TC_TestCase_UI_02(driver);
    }

    @Test
    public void TC13_verifyAllTestCasesClickability() {
        ExtentTest test = extent.createTest("TC13_verifyAllTestCasesClickability");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.areAllTestCasesClickable()) {
                    test.pass("All test cases are clickable");
                } else {
                    test.fail("All test cases visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC13_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC13_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void TC14_verifyNumberOfTestCases() {
        ExtentTest test = extent.createTest("TC14_verifyNumberOfTestCases");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isNumberOfTestCasesCorrect()) {
                    test.pass("Correct number of test cases displayed");
                } else {
                    test.fail("Incorrect number of test cases displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC14_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC14_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void TC15_verifyTestCaseInformation() {
        ExtentTest test = extent.createTest("TC15_verifyTestCaseInformation");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(!testCasesPage.isTestCaseInfoAvailable()) {
                    test.pass("Test case information is available on clicking");
                } else {
                    test.fail("Test case information NOT available")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC15_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC15_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void TC16_verifyFeedbackForUsDisplayed() {
        ExtentTest test = extent.createTest("TC16_verifyFeedbackForUsDisplayed");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isFeedbackSectionVisible()) {
                    test.pass("Feedback section is visible");
                } else {
                    test.fail("Feedback section NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC16_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC16_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void TC17_verifyFeedbackLinkDisplayed() {
        ExtentTest test = extent.createTest("TC17_verifyFeedbackLinkDisplayed");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(!testCasesPage.isFeedbackLinkVisible()) {
                    test.pass("Feedback link is visible");
                } else {
                    test.fail("Feedback link NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC17_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC17_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void TC18_verifyUpArrowScrollability() {
        ExtentTest test = extent.createTest("TC18_verifyUpArrowScrollability");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(!testCasesPage.isUpArrowWorking()) {
                    test.pass("Up arrow scroll works correctly");
                } else {
                    test.fail("Up arrow scroll NOT working")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC18_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC18_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void TC19_verifySubscriptionDisplayed() {
        ExtentTest test = extent.createTest("TC19_verifySubscriptionDisplayed");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(!testCasesPage.isSubscriptionSectionVisible()) {
                    test.pass("Subscription section is visible");
                } else {
                    test.fail("Subscription section NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC19_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC19_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void TC20_verifyValidSubscriptionMail() {
        ExtentTest test = extent.createTest("TC20_verifyValidSubscriptionMail");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.enterSubscriptionMail("valid@example.com")) {
                    test.pass("Valid subscription email accepted");
                } else {
                    test.fail("Valid subscription email NOT accepted")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC20_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC20_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void TC21_verifyInvalidSubscriptionMail() {
        ExtentTest test = extent.createTest("TC21_verifyInvalidSubscriptionMail");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.enterSubscriptionMail("invalidemail")) {
                    test.pass("Invalid subscription email handled");
                } else {
                    test.fail("Invalid subscription email NOT handled")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC21_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC21_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void TC22_verifySubscriptionWithoutEmail() {
        ExtentTest test = extent.createTest("TC22_verifySubscriptionWithoutEmail");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.enterSubscriptionMail("")) {
                    test.pass("Handled empty subscription email");
                } else {
                    test.fail("Empty subscription email NOT handled")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC22_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC22_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void TC23_verifySideArrowForSubscriptionMail() {
        ExtentTest test = extent.createTest("TC23_verifySideArrowForSubscriptionMail");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isSideArrowWorking()) {
                    test.pass("Side arrow for subscription mail works");
                } else {
                    test.fail("Side arrow NOT working")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC23_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC23_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void TC24_verifyCopyrightDisplayed() {
        ExtentTest test = extent.createTest("TC24_verifyCopyrightDisplayed");
        try {
        	testCasesPage.clickTestCasesButton();
            test.pass("Clicked on Test Cases button on homepage");

            if(testCasesPage.isTestCasesPageHeadingDisplayed()) {
                test.pass("Test Cases page opened");

                if(testCasesPage.isCopyrightVisible()) {
                    test.pass("Copyright is visible");
                } else {
                    test.fail("Copyright NOT visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC24_Fail"));
                }

            } else {
                test.fail("Test Cases page NOT opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC24_Fail"));
            }

        } catch(Exception e) {
            test.fail("Exception: "+e.getMessage());
        }
    }
}
