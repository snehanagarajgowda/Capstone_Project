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

public class Register_func_03 extends BaseTest {

    TC_Register_page_func_02 registerPage;
    static String projectpath=System.getProperty("user.dir");
    @BeforeMethod
    public void setupPage() {
        registerPage = new TC_Register_page_func_02(driver);
    }

 // 26. Valid Company
    @Test(dataProvider="excelData")
    public void TC26_validCompany(String username, String email, String company) throws IOException {
        test = extent.createTest("TC26_validCompany");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_SignupClickFail"));

                    boolean entered = registerPage.enter_company(company);
                    if(entered)
                        test.pass("Company entered: " + company);
                    else
                        test.fail("Company not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_CompanyFail"));

                    String enteredValue = registerPage.get_company();
                    if(enteredValue.equals(company))
                        test.pass("Company verified successfully: " + company);
                    else
                        test.fail("Company value mismatch")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_CompanyFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_Exception"));
        }
    }

    // 27. Invalid Company
    @Test(dataProvider="excelData")
    public void TC27_invalidCompany(String username, String email, String company) throws IOException {
        test = extent.createTest("TC27_invalidCompany");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null && !email.isEmpty())
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_SignupClickFail"));

                    boolean entered = registerPage.enter_company(company);
                    if(entered)
                        test.pass("Invalid company rejected as expected: " + company);
                    else
                        test.fail("Invalid company accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_CompanyFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_Exception"));
        }
    }

    // 28. Without Company
    @Test(dataProvider="excelData")
    public void TC28_withoutCompany(String username, String email) throws IOException {
        test = extent.createTest("TC28_withoutCompany");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_SignupClickFail"));

                    boolean entered = registerPage.enter_company("");
                    if(!entered)
                        test.pass("Company left empty handled correctly");
                    else
                        test.fail("Empty company accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_CompanyFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_Exception"));
        }
    }

 // 29. Valid Company
    @Test(dataProvider="excelData")
    public void TC29_validCompany(String username, String email, String company) throws IOException {
        test = extent.createTest("TC29_validCompany");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_SignupClickFail"));

                    boolean entered = registerPage.enter_company(company);
                    if(entered)
                        test.pass("Company entered: " + company);
                    else
                        test.fail("Failed to enter company")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_CompanyFail"));

                    String enteredValue = registerPage.get_company();
                    if(enteredValue.equals(company))
                        test.pass("Company verified successfully: " + company);
                    else
                        test.fail("Company value mismatch")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_CompanyMismatch"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_Exception"));
        }
    }

    // 30. Without Address1
    @Test(dataProvider="excelData")
    public void TC30_withoutAddress1(String username, String email, String address1) throws IOException {
        test = extent.createTest("TC30_withoutAddress1");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_SignupClickFail"));

                    boolean entered = registerPage.enter_address1(address1);
                    if(!entered)
                    	 test.fail("Empty Address1 accepted")
                         .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_Address1Fail"));
                    else   
                    test.pass("Address1 left empty handled correctly");

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_Exception"));
        }
    }

    // 31. Valid Address1
    @Test(dataProvider="excelData")
    public void TC31_validAddress1(String username, String email, String address1) throws IOException {
        test = extent.createTest("TC31_validAddress1");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_SignupClickFail"));

                    boolean entered = registerPage.enter_address1(address1);
                    if(entered)
                        test.pass("Address1 entered: " + address1);
                    else
                        test.fail("Failed to enter Address1")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_Address1Fail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_Exception"));
        }
    }

    // 32. Without Address2
    @Test(dataProvider="excelData")
    public void TC32_withoutAddress2(String username, String email, String address2) throws IOException {
        test = extent.createTest("TC32_withoutAddress2");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_SignupClickFail"));

                    boolean entered = registerPage.enter_address2(address2);
                    if(!entered)
                        test.fail("Empty Address2 accepted")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_Address2Fail"));
                    else
   
                    test.pass("Address2 left empty handled correctly");
                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_Exception"));
        }
    }


 // 33. Valid Address2
    @Test(dataProvider="excelData")
    public void TC33_validAddress2(String username, String email, String address2) throws IOException {
        test = extent.createTest("TC33_validAddress2");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_SignupClickFail"));

                    boolean entered = registerPage.enter_address2(address2);
                    if(entered)
                        test.pass("Address2 entered: " + address2);
                    else
                        test.fail("Failed to enter Address2")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_Address2Fail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_Exception"));
        }
    }

    // 34. Without Address2
    @Test(dataProvider="excelData")
    public void TC34_withoutAddress2(String username, String email, String address2) throws IOException {
        test = extent.createTest("TC34_withoutAddress2");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_SignupClickFail"));

                    boolean entered = registerPage.enter_address2(address2);
                    if(!entered)
                        test.pass("Address2 left empty handled correctly");
                    else
                        test.fail("Empty Address2 accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_Address2Fail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_Exception"));
        }
    }

    // 35. Country Dropdown
    @Test(dataProvider="excelData")
    public void TC35_countryDropdown(String username, String email, String country) throws IOException {
        test = extent.createTest("TC35_countryDropdown");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_SignupClickFail"));

                    boolean selected = registerPage.select_country(country);
                    if(selected)
                        test.pass("Country selected: " + country);
                    else
                        test.fail("Country selection failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_CountryFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_Exception"));
        }
    }

    // 36. Valid State
    @Test(dataProvider="excelData")
    public void TC36_validState(String username, String email, String state) throws IOException {
        test = extent.createTest("TC36_validState");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_SignupClickFail"));

                    boolean entered = registerPage.enter_state(state);
                    if(entered)
                        test.pass("State entered: " + state);
                    else
                        test.fail("Failed to enter state")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_StateFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_Exception"));
        }
    }

 // 37. Invalid State
    @Test(dataProvider="excelData")
    public void TC37_invalidState(String username, String email, String state) throws IOException {
        test = extent.createTest("TC37_invalidState");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_SignupClickFail"));

                    boolean entered = registerPage.enter_state(state);
                    if(entered)
                        test.pass("Invalid state rejected as expected");
                    else
                        test.fail("Invalid state accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_StateFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_Exception"));
        }
    }

    // 38. Valid City
    @Test(dataProvider="excelData")
    public void TC38_validCity(String username, String email, String city) throws IOException {
        test = extent.createTest("TC38_validCity");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_SignupClickFail"));

                    boolean entered = registerPage.enter_city(city);
                    if(entered)
                        test.pass("City entered: " + city);
                    else
                        test.fail("Failed to enter city")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_CityFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_Exception"));
        }
    }

    // 39. Invalid City
    @Test(dataProvider="excelData")
    public void TC39_invalidCity(String username, String email, String city) throws IOException {
        test = extent.createTest("TC39_invalidCity");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_SignupClickFail"));

                    boolean entered = registerPage.enter_city(city);
                    if(entered)
                        test.pass("Invalid city rejected as expected");
                    else
                        test.fail("Invalid city accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_CityFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_Exception"));
        }
    }

    // 40. Without City
    @Test(dataProvider="excelData")
    public void TC40_withoutCity(String username, String email) throws IOException {
        test = extent.createTest("TC40_withoutCity");
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
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_UsernameFail"));

                    registerPage.enteremail(email);
                    if(email != null)
                        test.pass("Email entered: " + email);
                    else
                        test.fail("Email not entered")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_EmailFail"));

                    registerPage.clicksignupbutton();
                    if(registerPage.registerpageheadingisdisplayed())
                        test.pass("Clicked signup button successfully");
                    else
                        test.fail("Signup button click failed")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_SignupClickFail"));

                    boolean entered = registerPage.enter_city("");
                    if(!entered)
                        test.pass("City left empty handled correctly");
                    else
                        test.fail("Empty city accepted")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_CityFail"));

                } else {
                    test.fail("Login/Signup button click failed")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_LoginSignupFail"));
                }

            } else {
                test.fail("Homepage not opened")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_HomepageFail"));
            }

        } catch(Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_Exception"));
        }
    }

    @DataProvider(name = "excelData")
    public Object[][] getData(Method method) throws IOException {
        String testName = method.getName(); 
        String tcId = testName.split("_")[0];

        String datapath = projectpath + "\\src\\test\\resources\\automationexercise_TestData\\reg_fun_03_data.xlsx";
        return ExcelUtilities.getdata(datapath, "Sheet1", tcId);
    }
    
}

