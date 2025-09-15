<<<<<<< HEAD
package com.automationexercise.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Register_page_func;
import com.automationexercise.utilities.ExcelUtilities;
import com.automationexercise.utilities.ScreenshotUtilities;



public class Register_func_01 extends BaseTest {
    TC_Register_page_func registerPage;
    static String projectpath=System.getProperty("user.dir");
    @BeforeMethod
    public void setupPage() {
        registerPage = new TC_Register_page_func(driver); 
    }
    @Test
    // 1. Verify URL
    
    public void TC01_verifyURL() throws IOException {
        test = extent.createTest("TC01_verifyURL");

        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals("https://automationexercise.com/")) {
            test.pass("URL is correct: " + actualURL);
            if(registerPage.ishomepageheadingDisplayed()) {
            	test.pass("page opened after clicking on url");
            } else {
            	test.fail("page not opened")
            	.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC01_verifyURL_Fail"));
            }
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
        	if(registerPage.ishomepageheadingDisplayed()) {
            	test.pass("page opened after clicking on url");
            registerPage.clickloginsignupbutton();
            if(registerPage.issignuppageheadingDisplayed()) {
            	test.pass("clicked on login/signup button");
       
            String actualTitle = driver.getTitle();
            if (actualTitle.contains("Automation Exercise - Signup / Login")) {
                test.pass("Signup/Login page opened: " + actualTitle);
            } else {
                test.fail("Signup/Login page not opened: " + actualTitle)
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02_LoginSignup_Fail"));
            }
            } else {
            	test.fail("not clicked on login/signup button");
            }
        	}  else {
            	test.fail("page not opened")
            	.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC01_verifyURL_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02_Exception"));
        }
    }
 // 3. Signup valid name & email
    @Test(dataProvider="excelData")
    public void TC03_signupValidNameValidEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC03_signupValidNameValidEmail");

        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("page opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("clicked on login/signup button");

                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("username entered : " + username);
                    } else {
                        test.fail("username not entered (invalid value)")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_ValidSignup_Username"));
                    }

                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("email entered : " + email);
                    } else {
                        test.fail("email not entered (invalid value)")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_ValidSignup_Email"));
                    }

                    registerPage.clicksignupbutton();
                    test.pass("clicked on signup button");

                    if (registerPage.registerpageheadingisdisplayed()) {
                        test.pass("Register page opened successfully with valid details. username: " + username + ", email: " + email);
                    } else {
                        test.fail("Signup rejected unexpectedly. username: " + username + ", email: " + email)
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_ValidSignup_Fail"));
                    }
                } else {
                    test.fail("not clicked on login/signup button")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_ValidSignup_SignupPageFail"));
                }
            } else {
                test.fail("page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_ValidSignup_PageFail"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_Exception"));
        }
    }


 // 4. Signup invalid name & email
    @Test(dataProvider="excelData")
    public void TC04_signupInvalidNameInvalidEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC04_signupInvalidNameInvalidEmail");

        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("page opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("clicked on login/signup button");
                    
                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("username entered : " + username);
                    } else {
                        test.fail("username not entered (invalid value)")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_InvalidSignup_Username"));
                    }

                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("email entered : " + email);
                    } else {
                        test.fail("email not entered (invalid value)")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_InvalidSignup_Email"));
                    }

                    registerPage.clicksignupbutton();
                    test.pass("clicked on signup button");

                    if (registerPage.registerpageheadingisdisplayed()) {
                        test.fail("Register page opened with invalid details. username: " + username + ", email: " + email)
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_InvalidSignup_Fail"));
                    } else {
                        test.pass("Signup rejected as expected. username: " + username + ", email: " + email);
                    }
                } else {
                    test.fail("not clicked on login/signup button")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_InvalidSignup_SignupPageFail"));
                }
            } else {
                test.fail("page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_InvalidSignup_PageFail"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_Exception"));
        }
    }


 // 5. Signup invalid name & valid email
    @Test(dataProvider="excelData")
    public void TC05_signupInvalidNameValidEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC05_signupInvalidNameValidEmail");

        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("page opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("clicked on login/signup button");
                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("username entered : " + username);
                    } else {
                        test.fail("username not entered (invalid value)")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_InvalidName_Username"));
                    }
                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("email entered : " + email);
                    } else {
                        test.fail("email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_InvalidName_Email"));
                    }
                    registerPage.clicksignupbutton();
                    test.pass("clicked on signup button");

                    if (registerPage.registerpageheadingisdisplayed()) {
                        test.fail("Register page opened with invalid name. username: " + username + ", email: " + email)
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_InvalidName_Fail"));
                    } else {
                        test.pass("Signup rejected as expected with invalid name. username: " + username + ", email: " + email);
                    }
                } else {
                    test.fail("not clicked on login/signup button")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_InvalidName_SignupPageFail"));
                }
            } else {
                test.fail("page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_InvalidName_PageFail"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_Exception"));
        }
    }

 // 6. Signup valid name & invalid email
    @Test(dataProvider="excelData")
    public void TC06_signupValidNameInvalidEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC06_signupValidNameInvalidEmail");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");
                    
                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("Username entered: " + username);
                    } else {
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_UsernameFail"));
                    }
                    
                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("Email entered: " + email);
                    } else {
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_EmailFail"));
                    }
                    
                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");
                    
                    if(registerPage.registerpageheadingisdisplayed()) {
                        test.fail("Register page opened with invalid email")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_InvalidEmail_Fail"));
                    } else {
                        test.pass("Signup rejected as expected with invalid email");
                    }
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_Exception"));
        }
    }

 // 7. Signup without name & email
    @Test
    public void TC07_signupWithoutNameAndEmail() throws IOException {
        test = extent.createTest("TC07_signupWithoutNameAndEmail");
        try {
                 if(registerPage.ishomepageheadingDisplayed()) {
                     test.pass("Homepage opened after clicking on url");
                     registerPage.clickloginsignupbutton();
                     if(registerPage.issignuppageheadingDisplayed()) {
                         test.pass("Clicked on login/signup button");
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
            } else {
                    test.fail("Signup page not displayed")
                             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_SignupPageFail"));
             }
            } else {
                test.fail("Homepage not opened")
                         .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_HomepageFail"));
             }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07_Exception"));
        }
    }

    // 8. Signup without name but with email
    @Test(dataProvider="excelData")
    public void TC08_signupWithoutNameWithEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC08_signupWithoutNameWithEmail");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username field left empty");

                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("Email entered: " + email);
                    } else {
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_EmailFail"));
                    }

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    if(registerPage.registerpageheadingisdisplayed()) {
                        test.fail("Register page opened without name")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_NoName_Fail"));
                    } else {
                        test.pass("Signup rejected as expected without name");
                    }
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_Exception"));
        }
    }

    // 9. Signup with name but without email
    @Test(dataProvider="excelData")
    public void TC09_signupWithNameWithoutEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC09_signupWithNameWithoutEmail");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("Username entered: " + username);
                    } else {
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_UsernameFail"));
                    }

                    registerPage.enteremail(email);
                    test.pass("Email field left empty");

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    if(registerPage.registerpageheadingisdisplayed()) {
                        test.fail("Register page opened without email")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_NoEmail_Fail"));
                    } else {
                        test.pass("Signup rejected as expected without email");
                    }
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_Exception"));
        }
    }

    // 10. Signup with existing email
    @Test(dataProvider="excelData")
    public void TC10_signupWithExistingEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC10_signupWithExistingEmail");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username entered: " + username);

                    registerPage.enteremail(email);
                    test.pass("Email entered: " + email);

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    if(registerPage.signuppageerrorisdisplayed()) {
                        test.pass("Error message displayed for existing email");
                    } else {
                        test.fail("No error message for existing email")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10_ExistingEmail_Fail"));
                    }
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10_Exception"));
        }
    }

 // 11. MR radio button
    @Test(dataProvider="excelData")
    public void TC11_MRRadiobutton(String username,String email,String password) throws IOException {
        test = extent.createTest("TC11_MRRadiobutton");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("Username entered: " + username);
                    } else {
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_UsernameFail"));
                    }

                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("Email entered: " + email);
                    } else {
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_EmailFail"));
                    }

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    registerPage.clickmrradiobutton();
                    test.pass("Clicked MR radio button");
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_Exception"));
        }
    }

    // 12. MRS radio button
    @Test(dataProvider="excelData")
    public void TC12_MRSRadiobutton(String username,String email,String password) throws IOException {
        test = extent.createTest("TC12_MRSRadiobutton");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username entered: " + username);

                    registerPage.enteremail(email);
                    test.pass("Email entered: " + email);

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    registerPage.clickmrsradiobutton();
                    test.pass("Clicked MRS radio button");
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12_Exception"));
        }
    }

    // 13. Name with letters
    @Test(dataProvider="excelData")
    public void TC13_Nameletters(String username,String email,String rname) throws IOException {
        test = extent.createTest("TC13_Nameletters");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username entered: " + username);

                    registerPage.enteremail(email);
                    test.pass("Email entered: " + email);

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    registerPage.enter_regisiter_name(rname);
                    test.pass("Entered name with letters: " + rname);
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13_Exception"));
        }
    }

    // 14. Name with numbers
    @Test(dataProvider="excelData")
    public void TC14_Namenumbers(String username,String email,String rname) throws IOException {
        test = extent.createTest("TC14_Namenumbers");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username entered: " + username);

                    registerPage.enteremail(email);
                    test.pass("Email entered: " + email);

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    
                 if(registerPage.registerpageheadingisdisplayed())
                 {
                	 registerPage.enter_regisiter_name(rname);
                     test.fail("Name field accepted numbers: " + rname);
                 } else {
                	 test.pass("name field not accepted numbers")
                	 .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14_SignuppageFail"));
                 }
                  
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14_Exception"));
        }
    }

    // 16. Average password length
    @Test(dataProvider="excelData")
    public void TC16_AveragePasswordLength(String username,String email,String password) throws IOException {
        test = extent.createTest("TC16_AveragePasswordLength");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username entered: " + username);

                    registerPage.enteremail(email);
                    test.pass("Email entered: " + email);

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    registerPage.enter_register_password(password);
                    test.pass("Entered password of average length: " + password);
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16_Exception"));
        }
    }

    @DataProvider(name = "excelData")
    public Object[][] getData(Method method) throws IOException {
        String testName = method.getName(); 
        String tcId = testName.split("_")[0]; 

        String datapath = projectpath + "\\src\\test\\resources\\automationexercise_TestData\\reg_fun_01_data.xlsx";
        return ExcelUtilities.getdata(datapath, "Sheet1", tcId);
    }
    
}
=======
package com.automationexcercise.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexcercise.Base.BaseTest;
import com.automationexcercise.pages.TC_Register_page_func;
import com.automationexcercise.utilities.ScreenshotUtilities;
import com.automationexcercise.utilities.ExcelUtilities;

public class Register_func_01 extends BaseTest {
    TC_Register_page_func registerPage;
    static String projectpath=System.getProperty("user.dir");
    @BeforeMethod
    public void setupPage() {
        registerPage = new TC_Register_page_func(driver); 
    }
    @Test
    // 1. Verify URL
    
    public void TC01_verifyURL() throws IOException {
        test = extent.createTest("TC01_verifyURL");

        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals("https://automationexercise.com/")) {
            test.pass("URL is correct: " + actualURL);
            if(registerPage.ishomepageheadingDisplayed()) {
            	test.pass("page opened after clicking on url");
            } else {
            	test.fail("page not opened")
            	.addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC01_verifyURL_Fail"));
            }
        } else {
            test.fail("URL is incorrect: " + actualURL)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC01_verifyURL_Fail"));
        }
    }

    // 2. Verify Login/Signup button
    @Test
    public void TC02_verifyLoginSignupButton() throws IOException {
        test = extent.createTest("TC02_verifyLoginSignupButton");

        try {
        	if(registerPage.ishomepageheadingDisplayed()) {
            	test.pass("page opened after clicking on url");
            registerPage.clickloginsignupbutton();
            if(registerPage.issignuppageheadingDisplayed()) {
            	test.pass("clicked on login/signup button");
       
            String actualTitle = driver.getTitle();
            if (actualTitle.contains("Automation Exercise - Signup / Login")) {
                test.pass("Signup/Login page opened: " + actualTitle);
            } else {
                test.fail("Signup/Login page not opened: " + actualTitle)
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC02_LoginSignup_Fail"));
            }
            } else {
            	test.fail("not clicked on login/signup button");
            }
        	}  else {
            	test.fail("page not opened")
            	.addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC01_verifyURL_Fail"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC02_Exception"));
        }
    }
 // 3. Signup valid name & email
    @Test(dataProvider="excelData")
    public void TC03_signupValidNameValidEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC03_signupValidNameValidEmail");

        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("page opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("clicked on login/signup button");

                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("username entered : " + username);
                    } else {
                        test.fail("username not entered (invalid value)")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC03_ValidSignup_Username"));
                    }

                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("email entered : " + email);
                    } else {
                        test.fail("email not entered (invalid value)")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC03_ValidSignup_Email"));
                    }

                    registerPage.clicksignupbutton();
                    test.pass("clicked on signup button");

                    if (registerPage.registerpageheadingisdisplayed()) {
                        test.pass("Register page opened successfully with valid details. username: " + username + ", email: " + email);
                    } else {
                        test.fail("Signup rejected unexpectedly. username: " + username + ", email: " + email)
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC03_ValidSignup_Fail"));
                    }
                } else {
                    test.fail("not clicked on login/signup button")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC03_ValidSignup_SignupPageFail"));
                }
            } else {
                test.fail("page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC03_ValidSignup_PageFail"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC03_Exception"));
        }
    }


 // 4. Signup invalid name & email
    @Test(dataProvider="excelData")
    public void TC04_signupInvalidNameInvalidEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC04_signupInvalidNameInvalidEmail");

        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("page opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("clicked on login/signup button");
                    
                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("username entered : " + username);
                    } else {
                        test.fail("username not entered (invalid value)")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC04_InvalidSignup_Username"));
                    }

                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("email entered : " + email);
                    } else {
                        test.fail("email not entered (invalid value)")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC04_InvalidSignup_Email"));
                    }

                    registerPage.clicksignupbutton();
                    test.pass("clicked on signup button");

                    if (registerPage.registerpageheadingisdisplayed()) {
                        test.fail("Register page opened with invalid details. username: " + username + ", email: " + email)
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC04_InvalidSignup_Fail"));
                    } else {
                        test.pass("Signup rejected as expected. username: " + username + ", email: " + email);
                    }
                } else {
                    test.fail("not clicked on login/signup button")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC04_InvalidSignup_SignupPageFail"));
                }
            } else {
                test.fail("page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC04_InvalidSignup_PageFail"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC04_Exception"));
        }
    }


 // 5. Signup invalid name & valid email
    @Test(dataProvider="excelData")
    public void TC05_signupInvalidNameValidEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC05_signupInvalidNameValidEmail");

        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("page opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("clicked on login/signup button");
                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("username entered : " + username);
                    } else {
                        test.fail("username not entered (invalid value)")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC05_InvalidName_Username"));
                    }
                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("email entered : " + email);
                    } else {
                        test.fail("email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC05_InvalidName_Email"));
                    }
                    registerPage.clicksignupbutton();
                    test.pass("clicked on signup button");

                    if (registerPage.registerpageheadingisdisplayed()) {
                        test.fail("Register page opened with invalid name. username: " + username + ", email: " + email)
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC05_InvalidName_Fail"));
                    } else {
                        test.pass("Signup rejected as expected with invalid name. username: " + username + ", email: " + email);
                    }
                } else {
                    test.fail("not clicked on login/signup button")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC05_InvalidName_SignupPageFail"));
                }
            } else {
                test.fail("page not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC05_InvalidName_PageFail"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC05_Exception"));
        }
    }

 // 6. Signup valid name & invalid email
    @Test(dataProvider="excelData")
    public void TC06_signupValidNameInvalidEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC06_signupValidNameInvalidEmail");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");
                    
                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("Username entered: " + username);
                    } else {
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC06_UsernameFail"));
                    }
                    
                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("Email entered: " + email);
                    } else {
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC06_EmailFail"));
                    }
                    
                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");
                    
                    if(registerPage.registerpageheadingisdisplayed()) {
                        test.fail("Register page opened with invalid email")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC06_InvalidEmail_Fail"));
                    } else {
                        test.pass("Signup rejected as expected with invalid email");
                    }
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC06_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC06_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC06_Exception"));
        }
    }

 // 7. Signup without name & email
    @Test
    public void TC07_signupWithoutNameAndEmail() throws IOException {
        test = extent.createTest("TC07_signupWithoutNameAndEmail");
        try {
                 if(registerPage.ishomepageheadingDisplayed()) {
                     test.pass("Homepage opened after clicking on url");
                     registerPage.clickloginsignupbutton();
                     if(registerPage.issignuppageheadingDisplayed()) {
                         test.pass("Clicked on login/signup button");
            registerPage.clickloginsignupbutton();
            WebElement signupBtn = registerPage.clicksignupbutton();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signupBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signupBtn);

            if (registerPage.registerpageheadingisdisplayed()) {
                test.fail("Register page opened without data")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC07_WithoutData_Fail"));
            } else {
                test.pass("Signup rejected as expected");
            }
            } else {
                    test.fail("Signup page not displayed")
                             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC06_SignupPageFail"));
             }
            } else {
                test.fail("Homepage not opened")
                         .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC06_HomepageFail"));
             }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC07_Exception"));
        }
    }

    // 8. Signup without name but with email
    @Test(dataProvider="excelData")
    public void TC08_signupWithoutNameWithEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC08_signupWithoutNameWithEmail");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username field left empty");

                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("Email entered: " + email);
                    } else {
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC08_EmailFail"));
                    }

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    if(registerPage.registerpageheadingisdisplayed()) {
                        test.fail("Register page opened without name")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC08_NoName_Fail"));
                    } else {
                        test.pass("Signup rejected as expected without name");
                    }
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC08_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC08_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC08_Exception"));
        }
    }

    // 9. Signup with name but without email
    @Test(dataProvider="excelData")
    public void TC09_signupWithNameWithoutEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC09_signupWithNameWithoutEmail");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("Username entered: " + username);
                    } else {
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC09_UsernameFail"));
                    }

                    registerPage.enteremail(email);
                    test.pass("Email field left empty");

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    if(registerPage.registerpageheadingisdisplayed()) {
                        test.fail("Register page opened without email")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC09_NoEmail_Fail"));
                    } else {
                        test.pass("Signup rejected as expected without email");
                    }
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC09_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC09_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC09_Exception"));
        }
    }

    // 10. Signup with existing email
    @Test(dataProvider="excelData")
    public void TC10_signupWithExistingEmail(String username,String email,String password) throws IOException {
        test = extent.createTest("TC10_signupWithExistingEmail");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username entered: " + username);

                    registerPage.enteremail(email);
                    test.pass("Email entered: " + email);

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    if(registerPage.signuppageerrorisdisplayed()) {
                        test.pass("Error message displayed for existing email");
                    } else {
                        test.fail("No error message for existing email")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC10_ExistingEmail_Fail"));
                    }
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC10_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC10_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC10_Exception"));
        }
    }

 // 11. MR radio button
    @Test(dataProvider="excelData")
    public void TC11_MRRadiobutton(String username,String email,String password) throws IOException {
        test = extent.createTest("TC11_MRRadiobutton");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    if(username!=null) {
                        test.pass("Username entered: " + username);
                    } else {
                        test.fail("Username not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC11_UsernameFail"));
                    }

                    registerPage.enteremail(email);
                    if(email!=null) {
                        test.pass("Email entered: " + email);
                    } else {
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC11_EmailFail"));
                    }

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    registerPage.clickmrradiobutton();
                    test.pass("Clicked MR radio button");
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC11_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC11_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC11_Exception"));
        }
    }

    // 12. MRS radio button
    @Test(dataProvider="excelData")
    public void TC12_MRSRadiobutton(String username,String email,String password) throws IOException {
        test = extent.createTest("TC12_MRSRadiobutton");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username entered: " + username);

                    registerPage.enteremail(email);
                    test.pass("Email entered: " + email);

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    registerPage.clickmrsradiobutton();
                    test.pass("Clicked MRS radio button");
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC12_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC12_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC12_Exception"));
        }
    }

    // 13. Name with letters
    @Test(dataProvider="excelData")
    public void TC13_Nameletters(String username,String email,String rname) throws IOException {
        test = extent.createTest("TC13_Nameletters");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username entered: " + username);

                    registerPage.enteremail(email);
                    test.pass("Email entered: " + email);

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    registerPage.enter_regisiter_name(rname);
                    test.pass("Entered name with letters: " + rname);
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC13_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC13_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC13_Exception"));
        }
    }

    // 14. Name with numbers
    @Test(dataProvider="excelData")
    public void TC14_Namenumbers(String username,String email,String rname) throws IOException {
        test = extent.createTest("TC14_Namenumbers");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username entered: " + username);

                    registerPage.enteremail(email);
                    test.pass("Email entered: " + email);

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    
                 if(registerPage.registerpageheadingisdisplayed())
                 {
                	 registerPage.enter_regisiter_name(rname);
                     test.fail("Name field accepted numbers: " + rname);
                 } else {
                	 test.pass("name field not accepted numbers")
                	 .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC14_SignuppageFail"));
                 }
                  
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC14_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC14_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC14_Exception"));
        }
    }

    // 16. Average password length
    @Test(dataProvider="excelData")
    public void TC16_AveragePasswordLength(String username,String email,String password) throws IOException {
        test = extent.createTest("TC16_AveragePasswordLength");
        try {
            if(registerPage.ishomepageheadingDisplayed()) {
                test.pass("Homepage opened after clicking on url");
                registerPage.clickloginsignupbutton();
                if(registerPage.issignuppageheadingDisplayed()) {
                    test.pass("Clicked on login/signup button");

                    registerPage.enterusername(username);
                    test.pass("Username entered: " + username);

                    registerPage.enteremail(email);
                    test.pass("Email entered: " + email);

                    registerPage.clicksignupbutton();
                    test.pass("Clicked signup button");

                    registerPage.enter_register_password(password);
                    test.pass("Entered password of average length: " + password);
                } else {
                    test.fail("Signup page not displayed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC16_SignupPageFail"));
                }
            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC16_HomepageFail"));
            }
        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC16_Exception"));
        }
    }

    @DataProvider(name = "excelData")
    public Object[][] getData(Method method) throws IOException {
        String testName = method.getName(); 
        String tcId = testName.split("_")[0]; 

        String datapath = projectpath + "\\src\\test\\resources\\Automationexcercise_Testdata\\reg_fun_01_data.xlsx";
        return ExcelUtilities.getdata(datapath, "Sheet1", tcId);
    }
    
}
>>>>>>> bfd624d6f67bc365de35f9d0fa5a381abc8c9718
