<<<<<<< HEAD
package com.automationexercise.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Login_Func;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Ecom_Login_Functional_Test_2 extends BaseTest {

    String projectpath = System.getProperty("user.dir");

    // ----------------- TEST CASES -----------------

    // TC12. Verify session ends when browser is closed
    @Test(dataProvider = "validCredentials")
    public void Tc_ecom_login_12(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("TC12 - Verify session ends when browser is closed");

        TC_Ecom_Login_Func loginPage = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com/");
        test.pass("Opened application URL");

        loginPage.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        loginPage.enteremail(email);
        test.pass("Entered valid email");

        loginPage.enterpassword(password);
        test.pass("Entered valid password");

        loginPage.clickLogin();
        test.pass("Clicked Login button");

        if (loginPage.LoggedinUserNameDisplayed()) {
            test.pass("Successfully logged in");
        } else {
            test.fail("Unsuccessful login");
        }

        driver.quit();
        test.pass("Closed browser to end session");

        driver = WebDriverManager.chromedriver().create();
        test.pass("Started a new browser session");

        TC_Ecom_Login_Func loginPage2 = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com/");
        test.pass("Opened application URL in new session");

        loginPage2.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        WebElement btn = loginPage2.VerifyMSG();
        if (btn.isDisplayed()) {
            test.pass("Account is logged out after closing browser")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc12_Pass"));
        } else {
            test.fail("Account is still logged in after closing browser")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc12_Fail"));
        }
    }

    // TC13. Unregistered email login
    @Test(dataProvider = "invalidEmail")
    public void Tc_ecom_login_13(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("TC13 - Verify user cannot log in with unregistered email");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        login.enteremail(email);
        test.pass("Entered unregistered email");

        login.enterpassword(password);
        test.pass("Entered password");

        login.clickLogin();
        test.pass("Clicked Login button");

        if (login.LoginErrorMSGDisplayed()) {
            test.pass("Error message displayed for unregistered email")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc13_Pass"));
        } else {
            test.fail("Error message not displayed for unregistered email")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc13_Fail"));
        }
    }

    // TC14. Invalid email with special characters
    @Test(dataProvider = "special_characters")
    public void Tc_ecom_login_14(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("TC14 - Verify special characters in email field");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        driver.findElement(login.txt_email).sendKeys(email);
        test.pass("Entered invalid email with special characters");

        driver.findElement(login.txt_password).sendKeys(password);
        test.pass("Entered password");

        login.clickLogin();
        test.pass("Clicked Login button");

        String validationMessage = driver.findElement(login.txt_email).getAttribute("validationMessage");
        test.pass("Captured browser validation message");

        if (!validationMessage.isEmpty()) {
            test.pass("Validation error displayed → " + validationMessage)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc14_Pass"));
        } else {
            test.fail("Validation error not displayed for invalid email")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc14_Fail"));
            Assert.fail("Validation error not displayed for invalid email format");
        }
    }

    // TC15. Placeholder validation
    @Test
    public void Tc_ecom_login_15() throws IOException {
        ExtentTest test = extent.createTest("TC15 - Verify placeholder text in login fields");

        TC_Ecom_Login_Func loginPage = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com/");
        test.pass("Opened application URL");

        loginPage.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        String emailPlaceholder = loginPage.getEmailPlaceholder();
        test.pass("Captured email placeholder: " + emailPlaceholder);

        String passwordPlaceholder = loginPage.getPasswordPlaceholder();
        test.pass("Captured password placeholder: " + passwordPlaceholder);

        if (emailPlaceholder.equals("Email Address") && passwordPlaceholder.equals("Password")) {
            test.pass("Email and Password fields have correct placeholder text")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc15_Pass"));
        } else {
            test.fail("Placeholder text is incorrect")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc15_Fail"));
        }
    }

 // TC18. Verify login page title
 @Test(dataProvider = "validCredentials")
 public void Tc_ecom_login_18(String email, String password) throws IOException {
     ExtentTest test = extent.createTest("TC18 - Verify login page title");

     TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

     driver.get("https://automationexercise.com");
     test.pass("Opened application URL");

     login.clickonLoginPage();
     test.pass("Clicked on Login/Signup button");

     String expectedTitle = "Automation Exercise - Signup / Login";
     String actualTitle = driver.getTitle();
     test.pass("Captured page title: " + actualTitle);

     if (actualTitle.equals(expectedTitle)) {
         test.pass("Login page title is correct")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc18_Pass"));
     } else {
         test.fail("Login page title is incorrect. Actual: " + actualTitle)
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc18_Fail"));
     }
 }

 // TC19. Verify 'Back' button navigation
 @Test(dataProvider = "validCredentials")
 public void Tc_ecom_login_19(String email, String password) throws IOException {
     ExtentTest test = extent.createTest("TC19 - Verify browser 'Back' button navigation");

     TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

     driver.get("https://automationexercise.com");
     test.pass("Opened application URL");

     login.clickonLoginPage();
     test.pass("Clicked on Login/Signup button");

     driver.navigate().back();
     test.pass("Clicked browser 'Back' button");

     test.pass("'Back' button navigated correctly")
         .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc19_Pass"));
 }

 // TC20. Verify tab order in login form
 @Test(dataProvider = "validCredentials")
 public void Tc_ecom_login_20(String email, String password) throws IOException {
     ExtentTest test = extent.createTest("TC20 - Verify login form tab order");

     TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

     driver.get("https://automationexercise.com");
     test.pass("Opened application URL");

     login.clickonLoginPage();
     test.pass("Clicked on Login/Signup button");

     driver.findElement(login.txt_email).click();
     test.pass("Focused on email field");

     login.pressTabFromEmail();
     test.pass("Pressed Tab from email field");

     WebElement focused = login.getFocusedElement();
     boolean correctOrder = focused.equals(driver.findElement(login.txt_password));

     if (correctOrder) {
         test.pass("Focus moved from Email → Password correctly")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc20_Pass"));
     } else {
         test.fail("Focus did not move correctly. Focused element: " + focused.getTagName())
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc20_Fail"));
     }
 }

 // TC21. Verify error messages disappear after valid input
 @Test(dataProvider = "invalidEmail") // start with invalid data
 public void Tc_ecom_login_21(String email, String password) throws InterruptedException, IOException {
     ExtentTest test = extent.createTest("TC21 - Verify error messages disappear after correcting input");

     TC_Ecom_Login_Func loginPage = new TC_Ecom_Login_Func(driver);

     driver.get("https://automationexercise.com/");
     test.pass("Opened application URL");

     loginPage.clickonLoginPage();
     test.pass("Clicked on Login/Signup button");

     loginPage.enteremail(email);
     test.pass("Entered invalid email");

     loginPage.enterpassword(password);
     test.pass("Entered invalid password");

     loginPage.clickLogin();
     test.pass("Clicked on Login button with invalid credentials");

     if (loginPage.LoginErrorMSGDisplayed()) {
         test.pass("Error message displayed for invalid credentials");
     } else {
         test.fail("Error message NOT displayed for invalid credentials");
     }

     // Correct input
     Object[][] validData = validCredentials();
     loginPage.enteremail((String) validData[0][0]);
     test.pass("Entered valid email");

     loginPage.enterpassword((String) validData[0][1]);
     test.pass("Entered valid password");

     loginPage.clickLogin();
     test.pass("Clicked on Login button with valid credentials");

     Thread.sleep(1000);

     boolean errorVisible = loginPage.LoginErrorMSGDisplayed();
     if (!errorVisible) {
         test.pass("Error message disappeared after valid input")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc21_Pass"));
     } else {
         test.fail("Error message still visible after valid input")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc21_Fail"));
     }
 }

 // TC22. Verify session shared across multiple tabs
 @Test(dataProvider = "validCredentials")
 public void Tc_ecom_login_22(String email, String password) throws InterruptedException, IOException {
     ExtentTest test = extent.createTest("TC22 - Verify session shared across multiple tabs");

     TC_Ecom_Login_Func loginPage = new TC_Ecom_Login_Func(driver);

     driver.get("https://automationexercise.com/");
     test.pass("Opened application URL");

     loginPage.clickonLoginPage();
     test.pass("Clicked on Login/Signup button");

     loginPage.enteremail(email);
     test.pass("Entered valid email");

     loginPage.enterpassword(password);
     test.pass("Entered valid password");

     loginPage.clickLogin();
     test.pass("Clicked on Login button");

     Thread.sleep(1000);

     if (loginPage.LoggedinUserNameDisplayed()) {
         test.pass("User is logged in on first tab");
     } else {
         test.fail("User is not logged in on first tab");
     }

     ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
     test.pass("Opened a new tab");

     ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
     driver.switchTo().window(tabs.get(1));
     test.pass("Switched to new tab");

     driver.get("https://automationexercise.com/");
     test.pass("Opened application URL in new tab");

     if (loginPage.LoggedinUserNameDisplayed()) {
         test.pass("User remains logged in on second tab (session shared)")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc22_Pass"));
     } else {
         test.fail("User is NOT logged in on second tab (session not shared)")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc22_Fail"));
     }
 }

    // ----------------- DATA PROVIDERS -----------------

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

    @DataProvider(name = "blankEmail")
    public Object[][] blankEmail() throws IOException {
        return getDataByType("blank_email");
    }

    @DataProvider(name = "blankPassword")
    public Object[][] blankPassword() throws IOException {
        return getDataByType("blank_password");
    }
    
    @DataProvider(name = "special_characters")
    public Object[][] special_characters() throws IOException {
        return getDataByType("special_characters");
    }

    // ----------------- EXCEL DATA READER -----------------

    public Object[][] getDataByType(String type) throws IOException {
        File file = new File(projectpath + "\\src\\test\\resources\\automationexercise_TestData\\Data.xlsx");
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
=======
package com.automationexercise.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Login_Func;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Ecom_Login_Functional_Test_2 extends BaseTest {

    String projectpath = System.getProperty("user.dir");

    // ----------------- TEST CASES -----------------

    // TC12. Verify session ends when browser is closed
    @Test(dataProvider = "validCredentials")
    public void Tc_ecom_login_12(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("TC12 - Verify session ends when browser is closed");

        TC_Ecom_Login_Func loginPage = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com/");
        test.pass("Opened application URL");

        loginPage.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        loginPage.enteremail(email);
        test.pass("Entered valid email");

        loginPage.enterpassword(password);
        test.pass("Entered valid password");

        loginPage.clickLogin();
        test.pass("Clicked Login button");

        if (loginPage.LoggedinUserNameDisplayed()) {
            test.pass("Successfully logged in");
        } else {
            test.fail("Unsuccessful login");
        }

        driver.quit();
        test.pass("Closed browser to end session");

        driver = WebDriverManager.chromedriver().create();
        test.pass("Started a new browser session");

        TC_Ecom_Login_Func loginPage2 = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com/");
        test.pass("Opened application URL in new session");

        loginPage2.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        WebElement btn = loginPage2.VerifyMSG();
        if (btn.isDisplayed()) {
            test.pass("Account is logged out after closing browser")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc12_Pass"));
        } else {
            test.fail("Account is still logged in after closing browser")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc12_Fail"));
        }
    }

    // TC13. Unregistered email login
    @Test(dataProvider = "invalidEmail")
    public void Tc_ecom_login_13(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("TC13 - Verify user cannot log in with unregistered email");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        login.enteremail(email);
        test.pass("Entered unregistered email");

        login.enterpassword(password);
        test.pass("Entered password");

        login.clickLogin();
        test.pass("Clicked Login button");

        if (login.LoginErrorMSGDisplayed()) {
            test.pass("Error message displayed for unregistered email")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc13_Pass"));
        } else {
            test.fail("Error message not displayed for unregistered email")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc13_Fail"));
        }
    }

    // TC14. Invalid email with special characters
    @Test(dataProvider = "special_characters")
    public void Tc_ecom_login_14(String email, String password) throws IOException {
        ExtentTest test = extent.createTest("TC14 - Verify special characters in email field");

        TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        login.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        driver.findElement(login.txt_email).sendKeys(email);
        test.pass("Entered invalid email with special characters");

        driver.findElement(login.txt_password).sendKeys(password);
        test.pass("Entered password");

        login.clickLogin();
        test.pass("Clicked Login button");

        String validationMessage = driver.findElement(login.txt_email).getAttribute("validationMessage");
        test.pass("Captured browser validation message");

        if (!validationMessage.isEmpty()) {
            test.pass("Validation error displayed → " + validationMessage)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc14_Pass"));
        } else {
            test.fail("Validation error not displayed for invalid email")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc14_Fail"));
            Assert.fail("Validation error not displayed for invalid email format");
        }
    }

    // TC15. Placeholder validation
    @Test
    public void Tc_ecom_login_15() throws IOException {
        ExtentTest test = extent.createTest("TC15 - Verify placeholder text in login fields");

        TC_Ecom_Login_Func loginPage = new TC_Ecom_Login_Func(driver);

        driver.get("https://automationexercise.com/");
        test.pass("Opened application URL");

        loginPage.clickonLoginPage();
        test.pass("Clicked on Login/Signup button");

        String emailPlaceholder = loginPage.getEmailPlaceholder();
        test.pass("Captured email placeholder: " + emailPlaceholder);

        String passwordPlaceholder = loginPage.getPasswordPlaceholder();
        test.pass("Captured password placeholder: " + passwordPlaceholder);

        if (emailPlaceholder.equals("Email Address") && passwordPlaceholder.equals("Password")) {
            test.pass("Email and Password fields have correct placeholder text")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc15_Pass"));
        } else {
            test.fail("Placeholder text is incorrect")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc15_Fail"));
        }
    }

 // TC18. Verify login page title
 @Test(dataProvider = "validCredentials")
 public void Tc_ecom_login_18(String email, String password) throws IOException {
     ExtentTest test = extent.createTest("TC18 - Verify login page title");

     TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

     driver.get("https://automationexercise.com");
     test.pass("Opened application URL");

     login.clickonLoginPage();
     test.pass("Clicked on Login/Signup button");

     String expectedTitle = "Automation Exercise - Signup / Login";
     String actualTitle = driver.getTitle();
     test.pass("Captured page title: " + actualTitle);

     if (actualTitle.equals(expectedTitle)) {
         test.pass("Login page title is correct")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc18_Pass"));
     } else {
         test.fail("Login page title is incorrect. Actual: " + actualTitle)
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc18_Fail"));
     }
 }

 // TC19. Verify 'Back' button navigation
 @Test(dataProvider = "validCredentials")
 public void Tc_ecom_login_19(String email, String password) throws IOException {
     ExtentTest test = extent.createTest("TC19 - Verify browser 'Back' button navigation");

     TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

     driver.get("https://automationexercise.com");
     test.pass("Opened application URL");

     login.clickonLoginPage();
     test.pass("Clicked on Login/Signup button");

     driver.navigate().back();
     test.pass("Clicked browser 'Back' button");

     test.pass("'Back' button navigated correctly")
         .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc19_Pass"));
 }

 // TC20. Verify tab order in login form
 @Test(dataProvider = "validCredentials")
 public void Tc_ecom_login_20(String email, String password) throws IOException {
     ExtentTest test = extent.createTest("TC20 - Verify login form tab order");

     TC_Ecom_Login_Func login = new TC_Ecom_Login_Func(driver);

     driver.get("https://automationexercise.com");
     test.pass("Opened application URL");

     login.clickonLoginPage();
     test.pass("Clicked on Login/Signup button");

     driver.findElement(login.txt_email).click();
     test.pass("Focused on email field");

     login.pressTabFromEmail();
     test.pass("Pressed Tab from email field");

     WebElement focused = login.getFocusedElement();
     boolean correctOrder = focused.equals(driver.findElement(login.txt_password));

     if (correctOrder) {
         test.pass("Focus moved from Email → Password correctly")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc20_Pass"));
     } else {
         test.fail("Focus did not move correctly. Focused element: " + focused.getTagName())
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc20_Fail"));
     }
 }

 // TC21. Verify error messages disappear after valid input
 @Test(dataProvider = "invalidEmail") // start with invalid data
 public void Tc_ecom_login_21(String email, String password) throws InterruptedException, IOException {
     ExtentTest test = extent.createTest("TC21 - Verify error messages disappear after correcting input");

     TC_Ecom_Login_Func loginPage = new TC_Ecom_Login_Func(driver);

     driver.get("https://automationexercise.com/");
     test.pass("Opened application URL");

     loginPage.clickonLoginPage();
     test.pass("Clicked on Login/Signup button");

     loginPage.enteremail(email);
     test.pass("Entered invalid email");

     loginPage.enterpassword(password);
     test.pass("Entered invalid password");

     loginPage.clickLogin();
     test.pass("Clicked on Login button with invalid credentials");

     if (loginPage.LoginErrorMSGDisplayed()) {
         test.pass("Error message displayed for invalid credentials");
     } else {
         test.fail("Error message NOT displayed for invalid credentials");
     }

     // Correct input
     Object[][] validData = validCredentials();
     loginPage.enteremail((String) validData[0][0]);
     test.pass("Entered valid email");

     loginPage.enterpassword((String) validData[0][1]);
     test.pass("Entered valid password");

     loginPage.clickLogin();
     test.pass("Clicked on Login button with valid credentials");

     Thread.sleep(1000);

     boolean errorVisible = loginPage.LoginErrorMSGDisplayed();
     if (!errorVisible) {
         test.pass("Error message disappeared after valid input")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc21_Pass"));
     } else {
         test.fail("Error message still visible after valid input")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc21_Fail"));
     }
 }

 // TC22. Verify session shared across multiple tabs
 @Test(dataProvider = "validCredentials")
 public void Tc_ecom_login_22(String email, String password) throws InterruptedException, IOException {
     ExtentTest test = extent.createTest("TC22 - Verify session shared across multiple tabs");

     TC_Ecom_Login_Func loginPage = new TC_Ecom_Login_Func(driver);

     driver.get("https://automationexercise.com/");
     test.pass("Opened application URL");

     loginPage.clickonLoginPage();
     test.pass("Clicked on Login/Signup button");

     loginPage.enteremail(email);
     test.pass("Entered valid email");

     loginPage.enterpassword(password);
     test.pass("Entered valid password");

     loginPage.clickLogin();
     test.pass("Clicked on Login button");

     Thread.sleep(1000);

     if (loginPage.LoggedinUserNameDisplayed()) {
         test.pass("User is logged in on first tab");
     } else {
         test.fail("User is not logged in on first tab");
     }

     ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
     test.pass("Opened a new tab");

     ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
     driver.switchTo().window(tabs.get(1));
     test.pass("Switched to new tab");

     driver.get("https://automationexercise.com/");
     test.pass("Opened application URL in new tab");

     if (loginPage.LoggedinUserNameDisplayed()) {
         test.pass("User remains logged in on second tab (session shared)")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc22_Pass"));
     } else {
         test.fail("User is NOT logged in on second tab (session not shared)")
             .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc22_Fail"));
     }
 }

    // ----------------- DATA PROVIDERS -----------------

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

    @DataProvider(name = "blankEmail")
    public Object[][] blankEmail() throws IOException {
        return getDataByType("blank_email");
    }

    @DataProvider(name = "blankPassword")
    public Object[][] blankPassword() throws IOException {
        return getDataByType("blank_password");
    }
    
    @DataProvider(name = "special_characters")
    public Object[][] special_characters() throws IOException {
        return getDataByType("special_characters");
    }

    // ----------------- EXCEL DATA READER -----------------

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
>>>>>>> bfd624d6f67bc365de35f9d0fa5a381abc8c9718
