package com.automationexercise.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Homepage;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Homepage_Test extends BaseTest{
	TC_Ecom_Homepage homepage;

	@BeforeMethod
	public void setupPage() {
		homepage = new TC_Ecom_Homepage(driver);
		homepage.clickHomeButton();


	}

	//TC01. To verify Logo on home page
	@Test
	public void TC01_VerifyLogo() {
		ExtentTest test = extent.createTest("Verify logo on home page");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");
				if(homepage.isLogoDisplayed()) {
					test.pass("Logo is displayed on home page");
				}
				else {
					test.fail("Logo is not displayed on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "VerifyLogo fails"));
				}
			}else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC02. To verify home is displayed on home page
	@Test
	public void TC02_VerifyHomeIconVisibility() {
		ExtentTest test = extent.createTest("Verify home icon visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isHomeDisplayed()) {
					test.pass("Home is visible on home page");
				}
				else {
					test.fail("Home is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Home icon Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC03. To verify product is displayed on home page
	@Test
	public void TC03_VerifyProductIconVisibility() {
		ExtentTest test = extent.createTest("Verify product icon visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isProductDisplayed()) {
					test.pass("product is visible on home page");
				}
				else {
					test.fail("product is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify product icon Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
	//TC04. To verify cart is displayed on home page
	@Test
	public void TC04_VerifyCartIconVisibility() {
		ExtentTest test = extent.createTest("Verify Cart icon visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isCartDisplayed()) {
					test.pass("Cart is visible on home page");
				}
				else {
					test.fail("Cart is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify cart icon Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC05. To verify Signup/login is displayed on home page
	@Test
	public void TC05_VerifSignupLoginIconVisibility() {
		ExtentTest test = extent.createTest("Verify Signup/login icon visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isSignup_LoginDisplayed()) {
					test.pass("Signup/login is visible on home page");
				}
				else {
					test.fail("Signup/login is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Login signup icon Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC06. To verify Test Cases is displayed on home page
	@Test
	public void TC06_VerifyTestCasesIconVisibility() {
		ExtentTest test = extent.createTest("Verify Test Cases icon visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isTestCasesDisplayed()) {
					test.pass("Test Cases is visible on home page");
				}
				else {
					test.fail("Test Cases is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Test Cases icon Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC07. To verify API Testing is displayed on home page
	@Test
	public void TC07_VerifyTestCasesIconVisibility() {
		ExtentTest test = extent.createTest("Verify API Testing icon visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isAPITestingDisplayed()) {
					test.pass("API Testing  is visible on home page");
				}
				else {
					test.fail("API Testing  is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify API Testing icon Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC08. To verify Video Tutorials  is displayed on home page
	@Test
	public void TC08_VerifyVideoTutorialsIconVisibility() {
		ExtentTest test = extent.createTest("Verify Video Tutorials icon visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isVedioTutorialsDisplayed()) {
					test.pass("Video Tutorials  is visible on home page");
				}
				else {
					test.fail("Video Tutorials  is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Video Tutorials icon Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC09. To verify Contactus  is displayed on home page
	@Test
	public void TC09_VerifyContactusIconVisibility() {
		ExtentTest test = extent.createTest("Verify Contactus icon visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isContactusDisplayed()) {
					test.pass("Contactus  is visible on home page");
				}
				else {
					test.fail("Contactus  is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Contactus icon Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC10. To verify API List for practice is displayed on home page
	@Test
	public void TC10_VerifyAPIListPracticeElementVisibility() {
		ExtentTest test = extent.createTest("Verify API List for practice  visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isAPIListPracticeDisplayed()) {
					test.pass("API List for practice is visible on home page");
				}
				else {
					test.fail("API List for practice is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify API List for practices element Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC11. To verify Category is displayed on home page
	@Test
	public void TC11_VerifyCategoryElementVisibility() {
		ExtentTest test = extent.createTest("Verify Category Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isCategoryDisplayed()) {
					test.pass("Category is visible on home page");
				}
				else {
					test.fail("Category is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Category Element Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC12. To verify Feature item is displayed on home page
	@Test
	public void TC11_VerifyFeatureItemElementVisibility() {
		ExtentTest test = extent.createTest("Verify Feature item Element  visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isFeatureItemDisplayed()) {
					test.pass("Feature item  is visible on home page");
				}
				else {
					test.fail("Feature item  is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Feature item Element  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
}