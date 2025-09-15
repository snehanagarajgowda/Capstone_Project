<<<<<<< HEAD
package com.automationexercise.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Register_page_func;
import com.automationexercise.utilities.ExcelUtilities;
import com.automationexercise.utilities.ScreenshotUtilities;



public class Register_func_02 extends BaseTest {
    TC_Register_page_func registerPage;
    static String projectpath = System.getProperty("user.dir");

    @BeforeMethod
    public void setupPage() {
        registerPage = new TC_Register_page_func(driver); 
    }

 // 17. Select Day from dropdown
    @Test(dataProvider="excelData")
    public void TC17_dayDropdown(String uname, String email, Object day) throws IOException {
        String dayStr = String.valueOf(day).replace(".0", "");
        test = extent.createTest("TC17_dayDropdown");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.select_day(dayStr);
            test.pass("Day selected successfully: " + dayStr);
        } catch (Exception e) {
            test.fail("Unable to select day: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17_DayDropdown_Fail"));
        }
    }

    // 18. Select Month from dropdown
    @Test(dataProvider="excelData")
    public void TC18_monthDropdown(String uname, String email, Object month) throws IOException {
        String monthStr = String.valueOf(month).replace(".0", "");
        test = extent.createTest("TC18_monthDropdown");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC18_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC18_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.select_month(monthStr);
            test.pass("Month selected successfully: " + monthStr);
        } catch (Exception e) {
            test.fail("Unable to select month: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC18_MonthDropdown_Fail"));
        }
    }

    // 19. Select Year from dropdown
    @Test(dataProvider="excelData")
    public void TC19_yearDropdown(String uname, String email, Object year) throws IOException {
        String yearStr = String.valueOf(year).replace(".0", "");
        test = extent.createTest("TC19_yearDropdown");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC19_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC19_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.select_year(yearStr);
            test.pass("Year selected successfully: " + yearStr);
        } catch (Exception e) {
            test.fail("Unable to select year: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC19_YearDropdown_Fail"));
        }
    }


    // 20. Newsletter checkbox
    @Test(dataProvider="excelData")
    public void TC20_newsletterCheckbox(String uname, String email) throws IOException {
        test = extent.createTest("TC20_newsletterCheckbox");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC20_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC20_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.click_newsletter();
            test.pass("Newsletter checkbox selected");
        } catch (Exception e) {
            test.fail("Unable to select newsletter checkbox: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC20_Newsletter_Fail"));
        }
    }

    // 21. Offers checkbox
    @Test(dataProvider="excelData")
    public void TC21_offersCheckbox(String uname, String email) throws IOException {
        test = extent.createTest("TC21_offersCheckbox");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC21_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC21_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.click_offers();
            test.pass("Offers checkbox selected");
        } catch (Exception e) {
            test.fail("Unable to select offers checkbox: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC21_Offers_Fail"));
        }
    }

    // 22. First Name with numbers
    @Test(dataProvider="excelData")
    public void TC22_firstNameNumbers(String uname, String email, String fname) throws IOException {
        test = extent.createTest("TC22_firstNameNumbers");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC22_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC22_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.enter_firstname(fname);
            test.pass("First name entered: " + fname);
        } catch (Exception e) {
            test.fail("Unable to enter first name with numbers: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC22_FirstNameNumbers_Fail"));
        }
    }

    // 23. First Name with letters
    @Test(dataProvider="excelData")
    public void TC23_firstNameLetters(String uname, String email, String fname) throws IOException {
        test = extent.createTest("TC23_firstNameLetters");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC23_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC23_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.enter_firstname(fname);
            test.pass("First name entered: " + fname);
        } catch (Exception e) {
            test.fail("Unable to enter first name with letters: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC23_FirstNameLetters_Fail"));
        }
    }

    // 24. Last Name with numbers
    @Test(dataProvider="excelData")
    public void TC24_lastNameNumbers(String uname, String email, String lname) throws IOException {
        test = extent.createTest("TC24_lastNameNumbers");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC24_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC24_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.enter_lastname(lname);
            test.pass("Last name entered: " + lname);
        } catch (Exception e) {
            test.fail("Unable to enter last name with numbers: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC24_LastNameNumbers_Fail"));
        }
    }

    // 25. Last Name with letters
    @Test(dataProvider="excelData")
    public void TC25_lastNameLetters(String uname, String email, String lname) throws IOException {
        test = extent.createTest("TC25_lastNameLetters");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC25_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC25_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.enter_lastname(lname);
            test.pass("Last name entered: " + lname);
        } catch (Exception e) {
            test.fail("Unable to enter last name with letters: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC25_LastNameLetters_Fail"));
        }
    }

    @DataProvider(name = "excelData")
    public Object[][] getData(Method method) throws IOException {
        String testName = method.getName(); 
        String tcId = testName.split("_")[0]; 
        String datapath = projectpath + "\\src\\test\\resources\\Automationexcercise_Testdata\\reg_fun_02_data.xlsx";
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
import com.automationexcercise.pages.TC_Register_page_func;
import com.automationexcercise.utilities.ExcelUtilities;
import com.automationexcercise.utilities.ScreenshotUtilities;

public class Register_func_02 extends BaseTest {
    TC_Register_page_func registerPage;
    static String projectpath = System.getProperty("user.dir");

    @BeforeMethod
    public void setupPage() {
        registerPage = new TC_Register_page_func(driver); 
    }

 // 17. Select Day from dropdown
    @Test(dataProvider="excelData")
    public void TC17_dayDropdown(String uname, String email, Object day) throws IOException {
        String dayStr = String.valueOf(day).replace(".0", "");
        test = extent.createTest("TC17_dayDropdown");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC17_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC17_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.select_day(dayStr);
            test.pass("Day selected successfully: " + dayStr);
        } catch (Exception e) {
            test.fail("Unable to select day: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC17_DayDropdown_Fail"));
        }
    }

    // 18. Select Month from dropdown
    @Test(dataProvider="excelData")
    public void TC18_monthDropdown(String uname, String email, Object month) throws IOException {
        String monthStr = String.valueOf(month).replace(".0", "");
        test = extent.createTest("TC18_monthDropdown");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC18_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC18_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.select_month(monthStr);
            test.pass("Month selected successfully: " + monthStr);
        } catch (Exception e) {
            test.fail("Unable to select month: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC18_MonthDropdown_Fail"));
        }
    }

    // 19. Select Year from dropdown
    @Test(dataProvider="excelData")
    public void TC19_yearDropdown(String uname, String email, Object year) throws IOException {
        String yearStr = String.valueOf(year).replace(".0", "");
        test = extent.createTest("TC19_yearDropdown");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC19_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC19_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.select_year(yearStr);
            test.pass("Year selected successfully: " + yearStr);
        } catch (Exception e) {
            test.fail("Unable to select year: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC19_YearDropdown_Fail"));
        }
    }


    // 20. Newsletter checkbox
    @Test(dataProvider="excelData")
    public void TC20_newsletterCheckbox(String uname, String email) throws IOException {
        test = extent.createTest("TC20_newsletterCheckbox");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC20_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC20_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.click_newsletter();
            test.pass("Newsletter checkbox selected");
        } catch (Exception e) {
            test.fail("Unable to select newsletter checkbox: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC20_Newsletter_Fail"));
        }
    }

    // 21. Offers checkbox
    @Test(dataProvider="excelData")
    public void TC21_offersCheckbox(String uname, String email) throws IOException {
        test = extent.createTest("TC21_offersCheckbox");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC21_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC21_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.click_offers();
            test.pass("Offers checkbox selected");
        } catch (Exception e) {
            test.fail("Unable to select offers checkbox: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC21_Offers_Fail"));
        }
    }

    // 22. First Name with numbers
    @Test(dataProvider="excelData")
    public void TC22_firstNameNumbers(String uname, String email, String fname) throws IOException {
        test = extent.createTest("TC22_firstNameNumbers");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC22_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC22_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.enter_firstname(fname);
            test.pass("First name entered: " + fname);
        } catch (Exception e) {
            test.fail("Unable to enter first name with numbers: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC22_FirstNameNumbers_Fail"));
        }
    }

    // 23. First Name with letters
    @Test(dataProvider="excelData")
    public void TC23_firstNameLetters(String uname, String email, String fname) throws IOException {
        test = extent.createTest("TC23_firstNameLetters");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC23_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC23_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.enter_firstname(fname);
            test.pass("First name entered: " + fname);
        } catch (Exception e) {
            test.fail("Unable to enter first name with letters: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC23_FirstNameLetters_Fail"));
        }
    }

    // 24. Last Name with numbers
    @Test(dataProvider="excelData")
    public void TC24_lastNameNumbers(String uname, String email, String lname) throws IOException {
        test = extent.createTest("TC24_lastNameNumbers");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC24_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC24_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.enter_lastname(lname);
            test.pass("Last name entered: " + lname);
        } catch (Exception e) {
            test.fail("Unable to enter last name with numbers: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC24_LastNameNumbers_Fail"));
        }
    }

    // 25. Last Name with letters
    @Test(dataProvider="excelData")
    public void TC25_lastNameLetters(String uname, String email, String lname) throws IOException {
        test = extent.createTest("TC25_lastNameLetters");
        try {
            registerPage.clickloginsignupbutton();
            test.pass("Clicked on login/signup button");

            registerPage.enterusername(uname);
            if(uname!=null && !uname.isEmpty()) {
                test.pass("Username entered: " + uname);
            } else {
                test.fail("Username not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC25_Username_Fail"));
            }

            registerPage.enteremail(email);
            if(email!=null && !email.isEmpty()) {
                test.pass("Email entered: " + email);
            } else {
                test.fail("Email not entered")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC25_Email_Fail"));
            }

            registerPage.clicksignupbutton();
            test.pass("Clicked on signup button");

            registerPage.enter_lastname(lname);
            test.pass("Last name entered: " + lname);
        } catch (Exception e) {
            test.fail("Unable to enter last name with letters: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC25_LastNameLetters_Fail"));
        }
    }

    @DataProvider(name = "excelData")
    public Object[][] getData(Method method) throws IOException {
        String testName = method.getName(); 
        String tcId = testName.split("_")[0]; 
        String datapath = projectpath + "\\src\\test\\resources\\Automationexcercise_Testdata\\reg_fun_02_data.xlsx";
        return ExcelUtilities.getdata(datapath, "Sheet1", tcId);
    }
}
>>>>>>> bfd624d6f67bc365de35f9d0fa5a381abc8c9718
