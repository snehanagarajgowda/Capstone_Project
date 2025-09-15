package com.automationexercise.tests;

import java.io.IOException;
import java.sql.Time;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Login_Signup_UI;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;


public class TC_Ecom_Login_Signup_UI_Test1 extends BaseTest{
	TC_Ecom_Login_Signup_UI loginSignup;

	@BeforeMethod
	public void setupPage() {
		loginSignup = new TC_Ecom_Login_Signup_UI(driver);
	} 

	//TC01. To verify and validate that Ecommerce web application logo is visible on login-signup
	@Test
	public void TC01_VerifyLogo() {
		ExtentTest test = extent.createTest("Verify Logo");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isLogoDisplayed();
			if (result) {
				test.pass("Logo is displayed on login/signup page");
			} else {
				test.fail("Logo is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC01_Ecom_Login_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

	//TC02. To verify and validate login to your account visibility on login-signup
	@Test
	public void TC02_VerifyLoginVisibilityMessage() {
		ExtentTest test = extent.createTest("Verify login to your account text visibility");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isLoginTextDisplayed();
			if (result) {
				test.pass("Login to your account  is displayed on login page");
			} else {
				test.fail("Login to your account is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

	//TC03. Verify presence of email element on login-signup
	@Test
	public void TC03_VerifyLoginEmailElement() {
		ExtentTest test = extent.createTest("Verify login page email element");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isLoginEmailDisplayed();
			if (result) {
				test.pass("Login page email element is visible");
			} else {
				test.fail("Login page email element is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

	//TC04. Verify presence of password element on login-signup
	@Test
	public void TC04_VerifyLoginPasswordElement() {
		ExtentTest test = extent.createTest("Verify login page password element");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isLoginPasswordDisplayed();
			if (result) {
				test.pass("Login page password element is visible");
			} else {
				test.fail("Login page password element is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

	//TC05. Verify presence of login button element on login-signup
	@Test
	public void TC05_VerifyLoginButtonElement() {
		ExtentTest test = extent.createTest("Verify login page login button element");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isLoginButtonDisplayed();
			if (result) {
				test.pass("Login page login Button element is visible");
			} else {
				test.fail("Login page login Button element is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 
	//TC06. Verify presence of OR element on login-signup
	@Test
	public void TC06_VerifyORElement() {
		ExtentTest test = extent.createTest("Verify login page OR element");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isORDisplayed();
			if (result) {
				test.pass("Login page Or element is visible");
			} else {
				test.fail("Login page Or element is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

	//TC07. Verify presence of signup email element on login-signup
	@Test
	public void TC07_VerifySignupEmailElement() {
		ExtentTest test = extent.createTest("Verify signup page email element");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isSignupEmailDisplayed();
			if (result) {
				test.pass("Signup page email element is visible");
			} else {
				test.fail("Signup page email element is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

	//TC08. Verify presence of signup name element on login-signup
	@Test
	public void TC08_VerifySignupNameElement() {
		ExtentTest test = extent.createTest("Verify signup page name element");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isSignupEmailDisplayed();
			if (result) {
				test.pass("Signup page name element is visible");
			} else {
				test.fail("Signup page name element is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 
	//TC09. Verify presence of signup button  on login-signup
	@Test
	public void TC09_VerifySignupButtonElement() {
		ExtentTest test = extent.createTest("Verify Signup Button element");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isSignupButtonDisplayed();
			if (result) {
				test.pass("Signup button  is visible");
			} else {
				test.fail("Signup button is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 
	//TC10. Verify presence of signup Text  on login-signup page
	@Test
	public void TC10_VerifySignupTextElement() {
		ExtentTest test = extent.createTest("Verify Signup Text visibility");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isSignupTextDisplayed();
			if (result) {
				test.pass("Signup text new user signup is visible");
			} else {
				test.fail("Signup text new user signup is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 
	//TC11. Verify presence of Home icon  on login-signup page
	@Test
	public void TC11_VerifyHomeIconVisibility() {
		ExtentTest test = extent.createTest("Verify Home icon visibility");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isHomeIconDisplayed();
			if (result) {
				test.pass("Home icon is displayed on login-signup page");
			} else {
				test.fail("Home icon is displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

	//TC12. Verify presence of Product icon  on login-signup page
	@Test
	public void TC12_VerifyProductIconVisibility() {
		ExtentTest test = extent.createTest("Verify product icon visibility");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isProductIconDisplayed();
			if (result) {
				test.pass("Product icon is displayed on login-signup page");
			} else {
				test.fail("Home icon is not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

	//TC13. Verify presence of Cart icon  on login-signup page
	@Test
	public void TC13_VerifyCartIconVisibility() {
		ExtentTest test = extent.createTest("Verify cart icon visibility");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isCartIconDisplayed();
			if (result) {
				test.pass("Cart icon is displayed on login-signup page");
			} else {
				test.fail("Cart icon is not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

	//TC14. Verify presence of login/signup icon  on login-signup page
	@Test
	public void TC14_VerifySignupLoginIconVisibility() {
		ExtentTest test = extent.createTest("Verify signup/login icon visibility");
		try {
			loginSignup.clickLoginSignupButton();
			boolean result = loginSignup.isSignupLoginIconDisplayed();
			if (result) {
				test.pass("Signup/login icon is displayed on login-signup page");
			} else {
				test.fail("Signup/login icon is not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14_Ecom_LoginSignup_UI Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

} 























