package com.automationexercise.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Freq_func_reg_03;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Freq_func_reg_03 extends BaseTest {

    TC_Freq_func_reg_03 page;

    @BeforeMethod
    public void setupPage() {
        page = new TC_Freq_func_reg_03(driver);
    }

    @Test
    public void TC36_verifyContactUsOnProductsPage() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("TC36_verifyContactUsOnProductsPage");
        try {
        page.clickProductsBtn();
        page.clickContactUsButton();
        if(page.iscontactusheadingDisplayed()) {
            test.pass("Contact Us clicked on Products page");
        } else {
            test.fail("Contact Us not found on Products page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_Fail"));
        }
        } catch(Exception e) {
        	System.out.println(e.getLocalizedMessage());
        }
    }

    @Test
    public void TC37_verifyScrollBarOnProductsPage() throws IOException {
        ExtentTest test = extent.createTest("TC37_verifyScrollBarOnProductsPage");
        page.clickProductsBtn();
        
        if(page.isScrollBarDisplayed()) {
            test.pass("Scroll bar is displayed on Products page");
        } else {
            test.fail("Scroll bar not found on Products page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_Fail"));
        }
    }

    @Test
    public void TC38_verifyBrandFilter() {
        ExtentTest test = extent.createTest("TC38_verifyBrandFilter");
        try {
            page.clickbrandname();
            if(page.clickbrandproductspolo()) {
                test.pass("brand items visible");
            } else {
                test.fail("brand items not found")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception in TC38: " + e.getMessage());
        }
    }


    @Test
    public void TC39_verifyDeleteButtonAfterLogin() throws IOException {
        ExtentTest test = extent.createTest("TC39_verifyDeleteButtonAfterLogin");
        page.clickSignupLoginBtn();
        page.enterEmail("thejaswarioleti@gmail.com");
        page.enterpassword("thejaswari@1234");
        page.clickloginbutton();
        if(page.isDeleteBtnDisplayed() && page.clickDeleteBtn()) {
            test.pass("Delete button clicked after login");
        } else {
            test.fail("Delete button not found or not clickable")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_Fail"));
        }
    }

    @Test
    public void TC40_verifyLogoutButtonAfterLogin() throws IOException {
        ExtentTest test = extent.createTest("TC40_verifyLogoutButtonAfterLogin");
        page.clickSignupLoginBtn();
        page.enterEmail("thejaswarioleti@gmail.com");
        page.enterpassword("thejaswari@1234");
        page.clickloginbutton();
        if(page.isLogoutBtnDisplayed()) {
        	 page.clicklogoutbutton();
            test.pass("Logout button clicked after login");
        } else {
            test.fail("Logout button not found or not clickable")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_Fail"));
        }
    }

    @Test
    public void TC41_verifyEmailFormatOnLoginPage() {
        ExtentTest test = extent.createTest("TC41_verifyEmailFormatOnLoginPage");
        try {
            page.clickSignupLoginBtn();
            String email = "cvvbghhjk@gmail.com"; // You can change it to test other emails
            page.enterEmail(email);

            // Step 2: Validate email format
            if (page.isEmailValid(email)) {
                test.pass("Email format is valid on login page");
            } else {
                // Only capture screenshot if test fails
                try {
                    String path = ScreenshotUtilities.capturescreenshot(driver, "TC41_Fail");
                    test.fail("Invalid email format on login page")
                        .addScreenCaptureFromPath(path);
                } catch (IOException e) {
                    test.fail("Invalid email format, screenshot failed: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            test.fail("Exception in TC41: " + e.getMessage());
        }
    }


    @Test
    public void TC42_verifyProductsButtonOnLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC42_verifyProductsButtonOnLoginPage");
        page.clickSignupLoginBtn();
        if(page.clickProductsBtn()) {
            test.pass("Products button clicked on login page");
        } else {
            test.fail("Products button not found on login page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC42_Fail"));
        }
    }

    @Test
    public void TC43_verifyCartButtonOnLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC43_verifyCartButtonOnLoginPage");
        page.clickSignupLoginBtn();
        if(page.clickCartBtn()) {
            test.pass("Cart button clicked on login page");
        } else {
            test.fail("Cart button not found on login page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC43_Fail"));
        }
    }

    @Test
    public void TC44_verifySignupLoginButtonOnLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC44_verifySignupLoginButtonOnLoginPage");
        page.clickSignupLoginBtn();
        if(page.clickSignupLoginBtn()) {
            test.pass("Signup/Login button clicked on login page");
        } else {
            test.fail("Signup/Login button not found on login page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC44_Fail"));
        }
    }
    @Test
    public void TC45_verifyTestCasesButtonOnLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC45_verifyTestCasesButtonOnLoginPage");
        page.clickSignupLoginBtn();
        if(page.clickTestCasesBtn()) {
            test.pass("Test Cases button clicked on login page");
        } else {
            test.fail("Test Cases button not found on login page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC45_Fail"));
        }
    }

    @Test
    public void TC46_verifyApiTestingButtonOnLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC46_verifyApiTestingButtonOnLoginPage");
        page.clickSignupLoginBtn();
        if(page.clickApiTestingBtn()) {
            test.pass("API Testing button clicked on login page");
        } else {
            test.fail("API Testing button not found on login page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC46_Fail"));
        }
    }

    @Test
    public void TC47_verifyVideoTutorialsButtonOnLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC47_verifyVideoTutorialsButtonOnLoginPage");
        page.clickSignupLoginBtn();
        if(page.clickVideoTutorialsBtn()) {
            test.pass("Video Tutorials button clicked on login page");
        } else {
            test.fail("Video Tutorials button not found on login page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC47_Fail"));
        }
    }

    @Test
    public void TC48_verifyContactUsButtonOnLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC48_verifyContactUsButtonOnLoginPage");
        page.clickSignupLoginBtn();
        page.clickContactUsButton();
        if(page.iscontactusheadingDisplayed()) {
            test.pass("Contact Us clicked on Products page");
        } else {
            test.fail("Contact Us not found on Products page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC48_Fail"));
        }
    }

    @Test
    public void TC49_verifyScrollBarOnLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC49_verifyScrollBarOnLoginPage");
        page.clickSignupLoginBtn();
        if(page.isScrollBarDisplayed()) {
            test.pass("Scroll bar is displayed on login page");
        } else {
            test.fail("Scroll bar not found on login page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC49_Fail"));
        }
    }
}