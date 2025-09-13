package com.automationexercise.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Login_Func;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Login_Functional_Test_1 extends BaseTest {
    String projectpath = System.getProperty("user.dir");

    // TC01. Verify Home Page URL
    @Test
    public void Tc_ecom_login_01() throws IOException {
        ExtentTest test = extent.createTest("Verify user can navigate to the home page");

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        String expectedURL = "https://automationexercise.com/";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.equals(expectedURL)) {
            test.pass("TC01 Passed: URL navigates to home page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Homepage"));
        } else {
            test.fail("TC01 Failed: URL did not navigate to home page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Homepage_Fail"));
        }
    }

    // TC02. Verify valid login and logout
    @Test(dataProvider = "validCredentials")
    public void Tc_ecom_login_02(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("Verify user can log in and log out successfully");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        login.enteremail(email);
        test.pass("Entered email: " + email);

        login.enterpassword(password);
        test.pass("Entered password");

        login.clickLogin();
        test.pass("Clicked on Login button");

        login.clickLogout();
        test.pass("Clicked on Logout button");

        WebElement verifyLogout = login.VerifyMSG();
        if (verifyLogout.getText().contains("Login to your account")) {
            test.pass("User logged in and logged out successfully")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc02_Pass"));
        } else {
            test.fail("Logout not successful")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc02_Fail"));
        }
    }

    // TC03. Verify redirection to login page after logout
    @Test(dataProvider = "validCredentials")
    public void Tc_ecom_login_03(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("Verify redirection to login page after logout");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        login.enteremail(email);
        test.pass("Entered email: " + email);

        login.enterpassword(password);
        test.pass("Entered password");

        login.clickLogin();
        test.pass("Clicked on Login button");

        login.clickLogout();
        test.pass("Clicked on Logout button");

        if (login.isHomeHeadingDisplayed()) {
            test.pass("User redirected to home page after logout")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc03_Pass"));
        } else {
            test.fail("User not redirected to home page after logout")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc03_Fail"));
        }
    }

    // TC04. Verify 'Logged in as username' is visible
    @Test(dataProvider = "validCredentials")
    public void Tc_ecom_login_04(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("Verify 'Logged in as username' is visible");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        login.enteremail(email);
        test.pass("Entered email: " + email);

        login.enterpassword(password);
        test.pass("Entered password");

        login.clickLogin();
        test.pass("Clicked on Login button");

        if (login.LoggedinUserNameDisplayed()) {
            test.pass("'Logged in as username' is visible")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc04_Pass"));
        } else {
            test.fail("'Logged in as username' not visible")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc04_Fail"));
        }
    }

    // TC05. Login with invalid email
    @Test(dataProvider = "invalidEmail")
    public void Tc_ecom_login_05(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("Verify login with invalid email shows error");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        login.enteremail(email);
        test.pass("Entered invalid email: " + email);

        login.enterpassword(password);
        test.pass("Entered password: " + password);

        login.clickLogin();
        test.pass("Clicked on Login button");

        if (login.LoginErrorMSGDisplayed()) {
            test.pass("Error message displayed for invalid email login")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc05_Pass"));
        } else {
            test.fail("Error message NOT displayed for invalid email login")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc05_Fail"));
        }
    }

    // TC06. Login button is clickable
    @Test
    public void Tc_ecom_login_06() throws IOException {
        ExtentTest test = extent.createTest("Verify login button is clickable");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        String msg = login.VerifyMSG().getText();
        test.pass("Captured login section message: " + msg);

        Assert.assertTrue(msg.contains("Login to your account"));
        test.pass("Login section is visible")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc06_Pass"));
    }

    // TC07. Login with invalid password
    @Test(dataProvider = "invalidPassword")
    public void Tc_ecom_login_07(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("Verify error message for invalid password");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        login.enteremail(email);
        test.pass("Entered email: " + email);

        login.enterpassword(password);
        test.pass("Entered invalid password");

        login.clickLogin();
        test.pass("Clicked on Login button");

        if (login.LoginErrorMSGDisplayed()) {
            test.pass("Error message displayed for invalid password")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc07_Pass"));
        } else {
            test.fail("Error message NOT displayed for invalid password")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc07_Fail"));
        }
    }

    // TC08. Email field validation when left blank
    @Test(dataProvider = "blankEmail")
    public void Tc_ecom_login_08(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("Verify validation message when email is blank");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        login.enterpassword(password);
        test.pass("Entered password: " + password);

        login.clickLogin();
        test.pass("Clicked on Login button");

        String validationMessage = driver.findElement(login.txt_email).getAttribute("validationMessage");
        test.pass("Captured validation message: " + validationMessage);

        Assert.assertTrue(validationMessage.length() > 0);
        test.pass("Validation message displayed for blank email")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc08_Pass"));
    }

    // TC09. Password field validation when left blank
    @Test(dataProvider = "blankPassword")
    public void Tc_ecom_login_09(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("Verify validation message when password is blank");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        login.enteremail(email);
        test.pass("Entered email: " + email);

        login.enterpassword(password);
        test.pass("Left password field blank");

        login.clickLogin();
        test.pass("Clicked on Login button");

        Assert.assertTrue(login.isHomeHeadingDisplayed());
        test.pass("Validation message displayed for blank password")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc09_Pass"));
    }

    // TC10. Verify password masking
    @Test(dataProvider = "validCredentials")
    public void Tc_ecom_login_10(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("Verify password is masked");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        login.enterpassword(password);
        test.pass("Entered password");

        Assert.assertTrue(login.isPasswordMasked());
        test.pass("Password is masked properly")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc10_Pass"));
    }

    // TC11. Verify page refresh keeps user on same page
    @Test(dataProvider = "validCredentials")
    public void Tc_ecom_login_11(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("Verify user stays on same page after refresh");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        login.enteremail(email);
        test.pass("Entered email: " + email);

        login.enterpassword(password);
        test.pass("Entered password");

        login.clickLogout();
        test.pass("Clicked Logout button");

        String beforeRefresh = driver.getCurrentUrl();
        test.pass("Captured URL before refresh: " + beforeRefresh);

        driver.navigate().refresh();
        test.pass("Refreshed the page");

        String afterRefresh = driver.getCurrentUrl();
        test.pass("Captured URL after refresh: " + afterRefresh);

        Assert.assertEquals(beforeRefresh, afterRefresh);
        test.pass("User stayed on same page after refresh")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc11_Pass"));
    }

    // --------------------- DATA PROVIDERS ---------------------

    @DataProvider(name = "validCredentials")
    public Object[][] validCredentials() throws IOException {
        return getDataByType("valid");
    }

    @DataProvider(name = "invalidEmail")
    public Object[][] invalidEmail() throws IOException {
        return getDataByType("invalid_email");
    }

    @DataProvider(name = "invalidPassword")
    public Object[][] invalidPassword() throws IOException {
        return getDataByType("invalid_password");
    }

    @DataProvider(name = "invalidBoth")
    public Object[][] invalidBoth() throws IOException {
        return getDataByType("invalid_both");
    }

    @DataProvider(name = "blankEmail")
    public Object[][] blankEmail() throws IOException {
        return getDataByType("blank_email");
    }

    @DataProvider(name = "blankPassword")
    public Object[][] blankPassword() throws IOException {
        return getDataByType("blank_password");
    }

    // Generic method to filter Excel data by type
    public Object[][] getDataByType(String type) throws IOException {
        File file = new File(projectpath + "\\src\\test\\resources\\AutomationExercise_TestData\\Data.xlsx");
        FileInputStream fs = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        int rowcount = worksheet.getPhysicalNumberOfRows();
        List<Object[]> filteredData = new ArrayList<>();

        for (int i = 1; i < rowcount; i++) { // row 0 = headers
            String email = worksheet.getRow(i).getCell(0).getStringCellValue();
            String password = worksheet.getRow(i).getCell(1).getStringCellValue();
            String rowType = worksheet.getRow(i).getCell(2).getStringCellValue();

            if (rowType.equalsIgnoreCase(type)) {
                filteredData.add(new Object[]{email, password});
            }
        }
        workbook.close();
        return filteredData.toArray(new Object[0][0]);
    }
}
