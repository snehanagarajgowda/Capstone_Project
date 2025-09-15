<<<<<<< HEAD
package com.automationexercise.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Register_page_func_02;
import com.automationexercise.utilities.ExcelUtilities;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Register_func_04 extends BaseTest {

    TC_Register_page_func_02 registerPage;
    static String projectpath=System.getProperty("user.dir");
    @BeforeMethod
    public void setupPage() {
        registerPage = new TC_Register_page_func_02(driver);
    }

 // 41. Zipcode in numbers
    @Test(dataProvider="excelData")
    public void TC41_zipcodeNumbers(String username, String email, Object zipcode) throws IOException {
        test = extent.createTest("TC41_zipcodeNumbers");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null && !username.isEmpty())
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC41_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null && !email.isEmpty())
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC41_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC41_SignupClickFail"));

                    // 🔹 Convert Object to String safely
                    String zipValue = (zipcode == null) ? "" : String.valueOf(zipcode).trim();

                    boolean entered = registerPage.enter_zipcode(zipValue);
                    if(!entered)
                        test.pass("Zipcode entered successfully: " + zipValue);
                    else
                        test.fail("Failed to enter zipcode")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC41_ZipcodeFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC41_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC41_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC41_Exception"));
        }
    }



    // 42. Zipcode in letters
    @Test(dataProvider="excelData")
    public void TC42_zipcodeLetters(String username, String email, String zipcode) throws IOException {
        test = extent.createTest("TC42_zipcodeLetters");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null)
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC42_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC42_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC42_SignupClickFail"));

                    boolean entered = registerPage.enter_zipcode(zipcode);
                    if(entered)
                        test.pass("Invalid zipcode rejected as expected");
                    else
                        test.fail("Invalid zipcode accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC42_ZipcodeFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC42_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC42_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC42_Exception"));
        }
    }
 // 43. Valid Zipcode
    @Test(dataProvider="excelData")
    public void TC43_validZipcode(String username, String email, Object zipcode) throws IOException {
        test = extent.createTest("TC43_validZipcode");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null && !username.isEmpty())
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC43_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null && !email.isEmpty())
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC43_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC43_SignupClickFail"));

                    // 🔹 Convert Object to String
                    String zipValue = (zipcode == null) ? "" : String.valueOf(zipcode).trim();

                    boolean entered = registerPage.enter_zipcode(zipValue);
                    if(!entered)
                        test.pass("Valid zipcode entered successfully: " + zipValue);
                    else
                        test.fail("Failed to enter valid zipcode")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC43_ZipcodeFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC43_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC43_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC43_Exception"));
        }
    }

    // 44. Invalid Zipcode
    @Test(dataProvider="excelData")
    public void TC44_invalidZipcode(String username, String email, String zipcode) throws IOException {
        test = extent.createTest("TC44_invalidZipcode");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null)
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC44_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC44_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC44_SignupClickFail"));

                    boolean entered = registerPage.enter_zipcode(zipcode);
                    if(entered)
                        test.pass("Invalid zipcode rejected as expected");
                    else
                        test.fail("Invalid zipcode accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC44_ZipcodeFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC44_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC44_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC44_Exception"));
        }
    }

    // 45. Mobile Number in digits
    @Test(dataProvider="excelData")
    public void TC45_mobileNumberDigits(String username, String email, String mobile) throws IOException {
        test = extent.createTest("TC45_mobileNumberDigits");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null)
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC45_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC45_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC45_SignupClickFail"));

                    boolean entered = registerPage.enter_mobileNumber(mobile);
                    if(!entered)
                        test.pass("Mobile number entered successfully: " + mobile);
                    else
                        test.fail("Failed to enter mobile number")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC45_MobileFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC45_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC45_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC45_Exception"));
        }
    }

    // 46. Mobile Number in letters
    @Test(dataProvider="excelData")
    public void TC46_mobileNumberLetters(String username, String email, String mobile) throws IOException {
        test = extent.createTest("TC46_mobileNumberLetters");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null)
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC46_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC46_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC46_SignupClickFail"));

                    boolean entered = registerPage.enter_mobileNumber(mobile);
                    if(!entered)
                        test.pass("Invalid mobile number rejected as expected");
                    else
                        test.fail("Invalid mobile number accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC46_MobileFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC46_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC46_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC46_Exception"));
        }
    }

 // 47. Valid Mobile Number
    @Test(dataProvider="excelData")
    public void TC47_validMobileNumber(String username, String email, Object mobile) throws IOException {
        test = extent.createTest("TC47_validMobileNumber");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null && !username.isEmpty())
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC47_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null && !email.isEmpty())
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC47_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC47_SignupClickFail"));

                    // 🔹 Convert Object → String (handles numeric & text cases)
                    String mobileValue = (mobile == null) ? "" : String.valueOf(mobile).trim();

                    boolean entered = registerPage.enter_mobileNumber(mobileValue);
                    if(!entered)
                        test.pass("Valid mobile number entered successfully: " + mobileValue);
                    else
                        test.fail("Failed to enter valid mobile number")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC47_MobileFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC47_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC47_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC47_Exception"));
        }
    }

 // 48. Invalid Mobile Number
    @Test(dataProvider="excelData")
    public void TC48_invalidMobileNumber(String username, String email, String mobile) throws IOException {
        test = extent.createTest("TC48_invalidMobileNumber");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null)
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC48_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC48_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC48_SignupClickFail"));

                    boolean entered = registerPage.enter_mobileNumber(mobile);
                    if(!entered)
                        test.pass("Invalid mobile number rejected as expected: " + mobile);
                    else
                        test.fail("Invalid mobile number accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC48_MobileFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC48_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC48_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC48_Exception"));
        }
    }
    @DataProvider(name = "excelData")
    public Object[][] getData(Method method) throws IOException {
        String testName = method.getName(); 
        String tcId = testName.split("_")[0]; 
        String datapath = projectpath + "\\src\\test\\resources\\automationexercise_TestData\\reg_fun_04_data.xlsx";
        return ExcelUtilities.getdata(datapath, "Sheet1", tcId);
    }

}
=======
package com.automationexcercise.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automationexcercise.Base.BaseTest;
import com.automationexcercise.pages.TC_Register_page_func_02;
import com.automationexcercise.utilities.ExcelUtilities;
import com.automationexcercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Register_func_04 extends BaseTest {

    TC_Register_page_func_02 registerPage;
    static String projectpath=System.getProperty("user.dir");
    @BeforeMethod
    public void setupPage() {
        registerPage = new TC_Register_page_func_02(driver);
    }

 // 41. Zipcode in numbers
    @Test(dataProvider="excelData")
    public void TC41_zipcodeNumbers(String username, String email, Object zipcode) throws IOException {
        test = extent.createTest("TC41_zipcodeNumbers");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null && !username.isEmpty())
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC41_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null && !email.isEmpty())
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC41_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC41_SignupClickFail"));

                    // 🔹 Convert Object to String safely
                    String zipValue = (zipcode == null) ? "" : String.valueOf(zipcode).trim();

                    boolean entered = registerPage.enter_zipcode(zipValue);
                    if(!entered)
                        test.pass("Zipcode entered successfully: " + zipValue);
                    else
                        test.fail("Failed to enter zipcode")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC41_ZipcodeFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC41_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC41_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC41_Exception"));
        }
    }



    // 42. Zipcode in letters
    @Test(dataProvider="excelData")
    public void TC42_zipcodeLetters(String username, String email, String zipcode) throws IOException {
        test = extent.createTest("TC42_zipcodeLetters");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null)
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC42_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC42_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC42_SignupClickFail"));

                    boolean entered = registerPage.enter_zipcode(zipcode);
                    if(entered)
                        test.pass("Invalid zipcode rejected as expected");
                    else
                        test.fail("Invalid zipcode accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC42_ZipcodeFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC42_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC42_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC42_Exception"));
        }
    }
 // 43. Valid Zipcode
    @Test(dataProvider="excelData")
    public void TC43_validZipcode(String username, String email, Object zipcode) throws IOException {
        test = extent.createTest("TC43_validZipcode");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null && !username.isEmpty())
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC43_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null && !email.isEmpty())
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC43_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC43_SignupClickFail"));

                    // 🔹 Convert Object to String
                    String zipValue = (zipcode == null) ? "" : String.valueOf(zipcode).trim();

                    boolean entered = registerPage.enter_zipcode(zipValue);
                    if(!entered)
                        test.pass("Valid zipcode entered successfully: " + zipValue);
                    else
                        test.fail("Failed to enter valid zipcode")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC43_ZipcodeFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC43_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC43_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC43_Exception"));
        }
    }

    // 44. Invalid Zipcode
    @Test(dataProvider="excelData")
    public void TC44_invalidZipcode(String username, String email, String zipcode) throws IOException {
        test = extent.createTest("TC44_invalidZipcode");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null)
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC44_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC44_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC44_SignupClickFail"));

                    boolean entered = registerPage.enter_zipcode(zipcode);
                    if(entered)
                        test.pass("Invalid zipcode rejected as expected");
                    else
                        test.fail("Invalid zipcode accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC44_ZipcodeFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC44_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC44_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC44_Exception"));
        }
    }

    // 45. Mobile Number in digits
    @Test(dataProvider="excelData")
    public void TC45_mobileNumberDigits(String username, String email, String mobile) throws IOException {
        test = extent.createTest("TC45_mobileNumberDigits");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null)
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC45_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC45_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC45_SignupClickFail"));

                    boolean entered = registerPage.enter_mobileNumber(mobile);
                    if(!entered)
                        test.pass("Mobile number entered successfully: " + mobile);
                    else
                        test.fail("Failed to enter mobile number")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC45_MobileFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC45_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC45_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC45_Exception"));
        }
    }

    // 46. Mobile Number in letters
    @Test(dataProvider="excelData")
    public void TC46_mobileNumberLetters(String username, String email, String mobile) throws IOException {
        test = extent.createTest("TC46_mobileNumberLetters");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null)
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC46_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC46_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC46_SignupClickFail"));

                    boolean entered = registerPage.enter_mobileNumber(mobile);
                    if(!entered)
                        test.pass("Invalid mobile number rejected as expected");
                    else
                        test.fail("Invalid mobile number accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC46_MobileFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC46_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC46_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC46_Exception"));
        }
    }

 // 47. Valid Mobile Number
    @Test(dataProvider="excelData")
    public void TC47_validMobileNumber(String username, String email, Object mobile) throws IOException {
        test = extent.createTest("TC47_validMobileNumber");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null && !username.isEmpty())
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC47_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null && !email.isEmpty())
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC47_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC47_SignupClickFail"));

                    // 🔹 Convert Object → String (handles numeric & text cases)
                    String mobileValue = (mobile == null) ? "" : String.valueOf(mobile).trim();

                    boolean entered = registerPage.enter_mobileNumber(mobileValue);
                    if(!entered)
                        test.pass("Valid mobile number entered successfully: " + mobileValue);
                    else
                        test.fail("Failed to enter valid mobile number")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC47_MobileFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC47_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC47_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC47_Exception"));
        }
    }

 // 48. Invalid Mobile Number
    @Test(dataProvider="excelData")
    public void TC48_invalidMobileNumber(String username, String email, String mobile) throws IOException {
        test = extent.createTest("TC48_invalidMobileNumber");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened successfully");

                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked login/signup button successfully");

                    registerPage.enterusername(username);
                    if(username != null)
                        test.pass("Username entered: " + username);
                    else
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC48_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC48_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC48_SignupClickFail"));

                    boolean entered = registerPage.enter_mobileNumber(mobile);
                    if(!entered)
                        test.pass("Invalid mobile number rejected as expected: " + mobile);
                    else
                        test.fail("Invalid mobile number accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC48_MobileFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC48_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC48_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC48_Exception"));
        }
    }
    @DataProvider(name = "excelData")
    public Object[][] getData(Method method) throws IOException {
        String testName = method.getName(); 
        String tcId = testName.split("_")[0]; 
        String datapath = projectpath + "\\src\\test\\resources\\Automationexcercise_Testdata\\reg_fun_04_data.xlsx";
        return ExcelUtilities.getdata(datapath, "Sheet1", tcId);
    }

}
>>>>>>> bfd624d6f67bc365de35f9d0fa5a381abc8c9718
