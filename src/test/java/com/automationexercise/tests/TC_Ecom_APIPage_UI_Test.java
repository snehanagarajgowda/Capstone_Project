package com.automationexercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_APIPage_UI;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_APIPage_UI_Test extends BaseTest {

    private TC_Ecom_APIPage_UI apiPage;

    @BeforeMethod
    public void setupPage() {
        apiPage = new TC_Ecom_APIPage_UI(driver);
        apiPage.clickAPITestingButton();   // navigate to API Testing page
    }

    private void validateElement(boolean condition, String successMsg, String failMsg, String screenshotName, ExtentTest test) {
        if (condition) {
            test.pass(successMsg);
        } else {
            test.fail(failMsg)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, screenshotName));
        }
    }

    // ---------- TC01 ----------
    @Test
    public void TC01_VerifyLogo() {
        ExtentTest test = extent.createTest("Verify Logo on API Testing page");
        try {
            validateElement(apiPage.isAPITestingPageOpened(), 
                "API Testing page is opened", 
                "API Testing page not opened", 
                "TC01_PageNotOpened", 
                test);
            validateElement(apiPage.isLogoDisplayed(), 
                "Logo is displayed on API Testing page", 
                "Logo is not displayed", 
                "TC01_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC02 ----------
    @Test
    public void TC02_VerifyHomeButton() {
        ExtentTest test = extent.createTest("Verify Home button visibility");
        try {
            validateElement(apiPage.isAPITestingPageOpened(), 
                "API Testing page is opened", 
                "API Testing page not opened", 
                "TC02_PageNotOpened", 
                test);
            validateElement(apiPage.isHomeButtonDisplayed(), 
                "Home button is displayed", 
                "Home button is not displayed", 
                "TC02_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC03 ----------
    @Test
    public void TC03_VerifyProductsButton() {
        ExtentTest test = extent.createTest("Verify Products button visibility");
        try {
            validateElement(apiPage.isAPITestingPageOpened(), 
                "API Testing page is opened", 
                "API Testing page not opened", 
                "TC03_PageNotOpened", 
                test);
            validateElement(apiPage.isProductsButtonDisplayed(), 
                "Products button is displayed", 
                "Products button is not displayed", 
                "TC03_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC04 ----------
    @Test
    public void TC04_VerifyCartButton() {
        ExtentTest test = extent.createTest("Verify Cart button visibility");
        try {
            validateElement(apiPage.isAPITestingPageOpened(), 
                "API Testing page is opened", 
                "API Testing page not opened", 
                "TC04_PageNotOpened", 
                test);
            validateElement(apiPage.isCartButtonDisplayed(), 
                "Cart button is displayed", 
                "Cart button is not displayed", 
                "TC04_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC05 ----------
    @Test
    public void TC05_VerifySignupLoginButton() {
        ExtentTest test = extent.createTest("Verify Signup/Login button visibility");
        try {
            validateElement(apiPage.isAPITestingPageOpened(), 
                "API Testing page is opened", 
                "API Testing page not opened", 
                "TC05_PageNotOpened", 
                test);
            validateElement(apiPage.isSignupLoginButtonDisplayed(), 
                "Signup/Login button is displayed", 
                "Signup/Login button is not displayed", 
                "TC05_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC06 ----------
    @Test
    public void TC06_VerifyTestCasesButton() {
        ExtentTest test = extent.createTest("Verify Test Cases button");
        try {
            validateElement(apiPage.isTestCasesButtonDisplayed(), 
                "Test Cases button is displayed", 
                "Test Cases button is not displayed", 
                "TC06_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC08 ----------
    @Test
    public void TC08_VerifyVideoTutorialsLink() {
        ExtentTest test = extent.createTest("Verify Video Tutorials link");
        try {
            validateElement(apiPage.isVideoTutorialsDisplayed(), 
                "Video Tutorials link is displayed", 
                "Video Tutorials link is not displayed", 
                "TC08_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC09 ----------
    @Test
    public void TC09_VerifyContactUsButton() {
        ExtentTest test = extent.createTest("Verify Contact Us button");
        try {
            validateElement(apiPage.isContactUsDisplayed(), 
                "Contact Us button is displayed", 
                "Contact Us button is not displayed", 
                "TC09_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC10 ----------
    @Test
    public void TC10_VerifyScrollbar() {
        ExtentTest test = extent.createTest("Verify Scrollbar visibility");
        try {
            validateElement(apiPage.isScrollBarPresent(), 
                "Scrollbar is displayed", 
                "Scrollbar is not displayed", 
                "TC10_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC12 ----------
    @Test
    public void TC12_VerifyAllAPIsSection() {
        ExtentTest test = extent.createTest("Verify All APIs section");
        try {
            validateElement(apiPage.isAllAPIsDisplayed(), 
                "All APIs section is displayed", 
                "All APIs section is not displayed", 
                "TC12_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC13 ----------
    @Test
    public void TC13_VerifyNumberOfAPIs() {
        ExtentTest test = extent.createTest("Verify number of APIs");
        try {
            int apiCount = apiPage.getNumberOfAPIs();
            if (apiCount > 0) {
                test.pass("APIs are listed. Count = " + apiCount);
            } else {
                test.fail("No APIs found")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13_Fails"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC15 ----------
    @Test
    public void TC15_VerifyFeedbackForUs() {
        ExtentTest test = extent.createTest("Verify Feedback for us section");
        try {
            validateElement(apiPage.isFeedbackForUsDisplayed(), 
                "Feedback for us is displayed", 
                "Feedback for us is not displayed", 
                "TC15_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC16 ----------
    @Test
    public void TC16_VerifyFeedbackLink() {
        ExtentTest test = extent.createTest("Verify Feedback link");
        try {
            validateElement(apiPage.isFeedbackLinkDisplayed(), 
                "Feedback link is displayed", 
                "Feedback link is not displayed", 
                "TC16_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC17 ----------
    @Test
    public void TC17_VerifyScrollUpButton() {
        ExtentTest test = extent.createTest("Verify Scroll Up button");
        try {
            validateElement(apiPage.isScrollUpDisplayed(), 
                "Scroll Up button is displayed", 
                "Scroll Up button is not displayed", 
                "TC17_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC18 ----------
    @Test
    public void TC18_VerifySubscriptionSection() {
        ExtentTest test = extent.createTest("Verify Subscription section");
        try {
            validateElement(apiPage.isSubscriptionDisplayed(), 
                "Subscription section is displayed", 
                "Subscription section is not displayed", 
                "TC18_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC19 ----------
    @Test
    public void TC19_VerifySubscriptionInputBox() {
        ExtentTest test = extent.createTest("Verify Subscription input box");
        try {
            validateElement(apiPage.isSubscriptionInputBoxDisplayed(), 
                "Subscription input box is displayed", 
                "Subscription input box is not displayed", 
                "TC19_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC20 ----------
    @Test
    public void TC20_VerifySubscriptionArrow() {
        ExtentTest test = extent.createTest("Verify Side Arrow for subscription");
        try {
            validateElement(apiPage.isSideArrowDisplayed(), 
                "Side Arrow is displayed in subscription section", 
                "Side Arrow is not displayed", 
                "TC20_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- TC21 ----------
    @Test
    public void TC21_VerifyCopyright() {
        ExtentTest test = extent.createTest("Verify Copyright");
        try {
            validateElement(apiPage.isCopyRightDisplayed(), 
                "Copyright text is displayed", 
                "Copyright is not displayed", 
                "TC21_Fails", 
                test);
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
