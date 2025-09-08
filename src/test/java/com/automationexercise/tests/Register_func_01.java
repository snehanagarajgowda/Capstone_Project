package com.automationexercise.tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Register_page_func;
import com.automationexercise.utilities.ScreenshotUtilities;

public class Register_func_01 extends BaseTest {
    TC_Register_page_func registerPage;

    @BeforeMethod
    public void setupPage() {
        registerPage = new TC_Register_page_func(driver); // driver comes from BaseTest
    }

    // 1. Verify URL
    @Test
    public void TC01_verifyURL() throws IOException {
        test = extent.createTest("TC01_verifyURL");

        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals("https://automationexercise.com/")) {
            test.pass("URL is correct: " + actualURL);
        } else {
            test.fail("URL is incorrect: " + actualURL)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC01_verifyURL_Fail"));
        }
    }

    // 2. Verify Login/Signup button
    @Test
    public void TC02_verifyLoginSignupButton() throws IOException {
        test = extent.createTest("TC02_verifyLoginSignupButton");

        try {
            registerPage.clickloginsignupbutton();
            String actualTitle = driver.getTitle();
            if (actualTitle.contains("Automation Exercise - Signup / Login")) {
                test.pass("Signup/Login page opened: " + actualTitle);
            } else {
                test.fail("Signup/Login page not opened: " + actualTitle)
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02_LoginSignup_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02_Exception"));
        }
    }

    // 3. Signup valid name & email
    @Test
    public void TC03_signupValidNameValidEmail() throws IOException {
        test = extent.createTest("TC03_signupValidNameValidEmail");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("Tejaswani");
            registerPage.enteremail("tejadh@gmail.com");
            registerPage.clicksignupbutton();

            if (registerPage.registerpageheadingisdisplayed()) {
                test.pass("Register page opened with valid details");
            } else {
                test.fail("Signup rejected")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_ValidSignup_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_Exception"));
        }
    }

    // 4. Signup invalid name & email
    @Test
    public void TC04_signupInvalidNameInvalidEmail() throws IOException {
        test = extent.createTest("TC04_signupInvalidNameInvalidEmail");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("e.23333");
            registerPage.enteremail("tejj..@123");
            registerPage.clicksignupbutton();

            if (registerPage.registerpageheadingisdisplayed()) {
                test.fail("Register page opened with invalid details")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_InvalidSignup_Fail"));
            } else {
                test.pass("Signup rejected as expected");
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_Exception"));
        }
    }

    // 5. Signup invalid name & valid email
    @Test
    public void TC05_signupInvalidNameValidEmail() throws IOException {
        test = extent.createTest("TC05_signupInvalidNameValidEmail");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("12345677j@.#");
            registerPage.enteremail("validcgimail@gmail.com");
            registerPage.clicksignupbutton();

            if (registerPage.registerpageheadingisdisplayed()) {
                test.fail("Register page opened with invalid name")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_InvalidName_Fail"));
            } else {
                test.pass("Signup rejected as expected");
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_Exception"));
        }
    }

    // 6. Signup valid name & invalid email
    @Test
    public void TC06_signupValidNameInvalidEmail() throws IOException {
        test = extent.createTest("TC06_signupValidNameInvalidEmail");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("Tejaswani");
            registerPage.enteremail("123#4@123");
            registerPage.clicksignupbutton();

            if (registerPage.registerpageheadingisdisplayed()) {
                test.fail("Register page opened with invalid email")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_InvalidEmail_Fail"));
            } else {
                test.pass("Signup rejected as expected");
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_Exception"));
        }
    }

    // 7. Signup without name & email
    @Test
    public void TC07_signupWithoutNameAndEmail() throws IOException {
        test = extent.createTest("TC07_signupWithoutNameAndEmail");

        try {
            registerPage.clickloginsignupbutton();
            WebElement signupBtn = registerPage.clicksignupbutton();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signupBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signupBtn);

            if (registerPage.registerpageheadingisdisplayed()) {
                test.fail("Register page opened without data")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07_WithoutData_Fail"));
            } else {
                test.pass("Signup rejected as expected");
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07_Exception"));
        }
    }

    // 8. Signup without name but with email
    @Test
    public void TC08_signupWithoutNameWithEmail() throws IOException {
        test = extent.createTest("TC08_signupWithoutNameWithEmail");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enteremail("valid@gmail.com");
            registerPage.clicksignupbutton();

            if (registerPage.registerpageheadingisdisplayed()) {
                test.fail("Register page opened without name")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_NoName_Fail"));
            } else {
                test.pass("Signup rejected as expected");
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_Exception"));
        }
    }

    // 9. Signup with name but without email
    @Test
    public void TC09_signupWithNameWithoutEmail() throws IOException {
        test = extent.createTest("TC09_signupWithNameWithoutEmail");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("Tejaswani");
            registerPage.clicksignupbutton();

            if (registerPage.registerpageheadingisdisplayed()) {
                test.fail("Register page opened without email")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_NoEmail_Fail"));
            } else {
                test.pass("Signup rejected as expected");
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_Exception"));
        }
    }

    // 10. Signup with existing email
    @Test
    public void TC10_signupWithExistingEmail() throws IOException {
        test = extent.createTest("TC10_signupWithExistingEmail");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("ExistingUser");
            registerPage.enteremail("thejaswarioleti@gmail.com");
            registerPage.clicksignupbutton();

            if (registerPage.signuppageerrorisdisplayed()) {
                test.pass("Error message shown for existing email");
            } else {
                test.fail("No error shown for existing email")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10_ExistingEmail_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10_Exception"));
        }
    }

    // 11. MR radio button
    @Test
    public void TC11_MRRadiobutton() throws IOException {
        test = extent.createTest("TC11_MRRadiobutton");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("ExistingUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();
            registerPage.clickmrradiobutton();

            test.pass("Clicked on MR radio button");
        } catch (Exception e) {
            test.fail("Unable to click MR radio button: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_MRRadio_Fail"));
        }
    }

    // 12. MRS radio button
    @Test
    public void TC12_MRSRadiobutton() throws IOException {
        test = extent.createTest("TC12_MRSRadiobutton");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();
            registerPage.clickmrsradiobutton();

            test.pass("Clicked on MRS radio button");
        } catch (Exception e) {
            test.fail("Unable to click MRS radio button: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12_MRSRadio_Fail"));
        }
    }

    // 13. Name with letters
    @Test
    public void TC13_Nameletters() throws IOException {
        test = extent.createTest("TC13_Nameletters");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();
            registerPage.enter_regisiter_name("newuser");

            test.pass("Entered name with letters");
        } catch (Exception e) {
            test.fail("Unable to enter name with letters: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13_NameLetters_Fail"));
        }
    }

    // 14. Name with numbers
    @Test
    public void TC14_Namenumbers() throws IOException {
        test = extent.createTest("TC14_Namenumbers");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();
            registerPage.enter_regisiter_name("12345678");

            test.pass("Entered name with numbers");
        } catch (Exception e) {
            test.fail("Unable to enter name with numbers: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14_NameNumbers_Fail"));
        }
    }

    // 15. Average password length
    @Test
    public void TC16_AveragePasswordLength() throws IOException {
        test = extent.createTest("TC16_AveragePasswordLength");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();
            registerPage.enter_register_password("fthhjjygfdfgjjjjjjjjjjjjjjjjjjjjjjjjjjjjhhhhhhhhh");

            test.pass("Entered password of average length");
        } catch (Exception e) {
            test.fail("Unable to enter password: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16_PasswordLength_Fail"));
        }
    }
}