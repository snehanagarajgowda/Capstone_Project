package com.automationexercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Register_page_func_02;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Register_func_04 extends BaseTest {

    TC_Register_page_func_02 registerPage;

    @BeforeMethod
    public void setupPage() {
        registerPage = new TC_Register_page_func_02(driver);
    }

    // 41. Zipcode in numbers
    @Test
    public void TC41_zipcodeNumbers() {
        ExtentTest test = extent.createTest("TC41_zipcodeNumbers");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser41");
            registerPage.enteremail("validuuh41@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_zipcode("560001");
            if (entered) {
                test.pass("Zipcode in numbers entered successfully");
            } else {
                test.fail("Failed to enter zipcode in numbers")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC41_zipcodeNumbers_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC41 failed: " + e.getMessage());
        }
    }

    // 42. Zipcode in letters
    @Test
    public void TC42_zipcodeLetters() {
        ExtentTest test = extent.createTest("TC42_zipcodeLetters");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser42");
            registerPage.enteremail("validuuh42@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_zipcode("ABCDE");
            if (!entered) {
                test.pass("Zipcode in letters rejected as expected");
            } else {
                test.fail("Invalid zipcode accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC42_zipcodeLetters_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC42 failed: " + e.getMessage());
        }
    }

    // 43. Valid Zipcode
    @Test
    public void TC43_validZipcode() {
        ExtentTest test = extent.createTest("TC43_validZipcode");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser43");
            registerPage.enteremail("validuuh43@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_zipcode("560001");
            if (entered) {
                test.pass("Valid zipcode entered successfully");
            } else {
                test.fail("Failed to enter valid zipcode")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC43_validZipcode_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC43 failed: " + e.getMessage());
        }
    }

    // 44. Invalid Zipcode
    @Test
    public void TC44_invalidZipcode() {
        ExtentTest test = extent.createTest("TC44_invalidZipcode");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser44");
            registerPage.enteremail("validuuh44@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_zipcode("!@#$%");
            if (!entered) {
                test.pass("Invalid zipcode rejected as expected");
            } else {
                test.fail("Invalid zipcode accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC44_invalidZipcode_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC44 failed: " + e.getMessage());
        }
    }

    // 45. Mobile number in numbers
    @Test
    public void TC45_mobileNumberDigits() {
        ExtentTest test = extent.createTest("TC45_mobileNumberDigits");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser45");
            registerPage.enteremail("validuuh45@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_mobileNumber("9876543210");
            if (entered) {
                test.pass("Mobile number in digits entered successfully");
            } else {
                test.fail("Failed to enter mobile number in digits")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC45_mobileNumberDigits_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC45 failed: " + e.getMessage());
        }
    }

    // 46. Mobile number in letters
    @Test
    public void TC46_mobileNumberLetters() {
        ExtentTest test = extent.createTest("TC46_mobileNumberLetters");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser46");
            registerPage.enteremail("validuuh46@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_mobileNumber("abcdefghij");
            if (!entered) {
                test.pass("Mobile number in letters rejected as expected");
            } else {
                test.fail("Invalid mobile number accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC46_mobileNumberLetters_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC46 failed: " + e.getMessage());
        }
    }

    // 47. Valid Mobile Number
    @Test
    public void TC47_validMobileNumber() {
        ExtentTest test = extent.createTest("TC47_validMobileNumber");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser47");
            registerPage.enteremail("validuuh47@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_mobileNumber("9876543210");
            if (entered) {
                test.pass("Valid mobile number entered successfully");
            } else {
                test.fail("Failed to enter valid mobile number")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC47_validMobileNumber_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC47 failed: " + e.getMessage());
        }
    }

    // 48. Invalid Mobile Number
    @Test
    public void TC48_invalidMobileNumber() {
        ExtentTest test = extent.createTest("TC48_invalidMobileNumber");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser48");
            registerPage.enteremail("validuuh48@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_mobileNumber("!@#$%^&*()");
            if (!entered) {
                test.pass("Invalid mobile number rejected as expected");
            } else {
                test.fail("Invalid mobile number accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC48_invalidMobileNumber_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC48 failed: " + e.getMessage());
        }
    }
}