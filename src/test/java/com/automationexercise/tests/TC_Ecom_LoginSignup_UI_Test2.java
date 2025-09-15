package com.automationexercise.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Login_Signup_UI;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_LoginSignup_UI_Test2 extends BaseTest{
	TC_Ecom_Login_Signup_UI loginSignup;

	@BeforeMethod
	public void setupPage() {
		loginSignup = new TC_Ecom_Login_Signup_UI(driver);
		loginSignup.clickLoginSignupButton();

	}

	//TC15. Verify presence of test cases icon  on login-signup page
	@Test
	public void TC15_VerifyTestCasesIconVisibility() {
		ExtentTest test = extent.createTest("Verify test cases icon visibility");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");		
				if (loginSignup.isTestCasesIconDisplayed()) {
					test.pass("Test cases icon is displayed on login-signup page");
				} else {
					test.fail("Test cases icon is not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC15_Ecom_LoginSignup_UI Fail"));
				}
			} else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}
	//TC16. Verify presence of Api testing icon  on login-signup page
	@Test
	public void TC16_VerifyApiTestingIconVisibility() {
		ExtentTest test = extent.createTest("Verify API testing icon visibility");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");		

				if (loginSignup.isTestCasesIconDisplayed()) {
					test.pass("API testing icon is displayed on login-signup page");
				} else {
					test.fail("API testing icon is not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16_Ecom_LoginSignup_UI Fail"));
				}
			} else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}

	//TC17. Verify presence of Vedio tutorial icon  on login-signup page
	@Test
	public void TC17_VerifyVedioTutorialIconVisibility() {
		ExtentTest test = extent.createTest("Verify Vedio tutorial icon visibility");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");

				if (loginSignup.isVideoTutorialsIconDisplayed()) {
					test.pass("Vedio tutorial icon is displayed on login-signup page");
				} else {
					test.fail("Vedio tutorial is not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17_Ecom_LoginSignup_UI Fail"));
				}
			}else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}

	//TC18. Verify presence of Contact us icon  on login-signup page
	@Test
	public void TC18_VerifyContactusIconVisibility() {
		ExtentTest test = extent.createTest("Verify Contact us icon visibility");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");

				if (loginSignup.isContactUsIconDisplayed()) {
					test.pass("Contact us icon is displayed on login-signup page");
				} else {
					test.fail("Contact us is not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC18_Ecom_LoginSignup_UI Fail"));
				}
			} else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}
	//TC19. Verify presence of Subscription text  on login-signup page
	@Test
	public void TC19_VerifySubscriptionTextVisibility() {
		ExtentTest test = extent.createTest("Verify Subscription text visibility");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");

				if (loginSignup.isSubscriptionTextDisplayed()) {
					test.pass("Subscription text is displayed on login-signup page");
				} else {
					test.fail("Subscription text not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC19_Ecom_LoginSignup_UI Fail"));
				}
			} else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}

	//TC20. Verify presence of Subscription email  on login-signup page
	@Test
	public void TC20_VerifySubscriptionEmailVisibility() {
		ExtentTest test = extent.createTest("Verify Subscription email visibility");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");

				if (loginSignup.isSubscriptionEmailDisplayed()) {
					test.pass("Subscription email is displayed on login-signup page");
				} else {
					test.fail("Subscription email not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC20_Ecom_LoginSignup_UI Fail"));
				}
			} else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}
	//TC21. Verify presence of Paragraph text  on login-signup page
	@Test
	public void TC21_VerifyParagraphTextVisibility() {
		ExtentTest test = extent.createTest("Verify Paragraph text visibility");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");

				if (loginSignup.isParagraphTextDisplayed()) {
					test.pass("Paragraph text is displayed on login-signup page");
				} else {
					test.fail("Paragraph text not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC21_Ecom_LoginSignup_UI Fail"));
				}
			}else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}
	//TC22. Verify presence of Arrow button on login-signup page
	@Test
	public void TC22_VerifArrowButtonVisibility() {
		ExtentTest test = extent.createTest("Verify Arrow button visibility");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");

				if (loginSignup.isArrowButtonDisplayed()) {
					test.pass("Arrow button is displayed on login-signup page");
				} else {
					test.fail("Arrow button not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC22_Ecom_LoginSignup_UI Fail"));
				}
			} else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}
	//TC23. Verify presence of Copy right on login-signup page
	@Test
	public void TC23_VerifyCopyRightVisibility() {
		ExtentTest test = extent.createTest("Verify Copy right visibility");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");

				if (loginSignup.isCopyRightTextDisplayed()) {
					test.pass("Copy right is displayed on login-signup page");
				} else {
					test.fail("Copy right is not displayed on login-signup page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC23_Ecom_LoginSignup_UI Fail"));
				}
			} else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}
	//TC24. Verify placeholder text in input fields
	@Test
	public void TC24_VerifyPlaceholderTextInputFields() {
		ExtentTest test = extent.createTest("Verify placeholder text in input fields");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");
				String emailPlaceholder = loginSignup.getEmailPlaceholder();
				String passwordPlaceholder = loginSignup.getPasswordPlaceholder();
				if ("Email Address".equals(emailPlaceholder) && "Password".equals(passwordPlaceholder)) {
					test.pass("Placeholders are correct");
				} else {
					test.fail("Placeholders are incorrect").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC24_Ecom_LoginSignup_UI Fail"));
				}
			}else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}
	//TC25. Verify alignment and spacing of elements
	@Test
	public void TC25_VerifyAlignmentAndSpacing() {
		ExtentTest test = extent.createTest("Verify placeholder text in input fields");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");
				int emailX = loginSignup.getEmailField().getLocation().getX();
				int passwordX = loginSignup.getPasswordField().getLocation().getX();

				if (emailX == passwordX) {
					test.pass("Email and Password fields are aligned");
				} else {
					test.fail("Email and Password fields are not aligned").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC25_Ecom_LoginSignup_UI Fail"));
				}
			} else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}

	//TC26. Verify font style and color consistency for Email and Password fields
	@Test
	public void TC26_VerifyColorStyle() {
		ExtentTest test = extent.createTest("Verify font style and color consistency for Email and Password fields");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");
				String emailFont = loginSignup.getEmailField().getCssValue("font-family");
				String passwordFont = loginSignup.getPasswordField().getCssValue("font-family");

				String emailColor = loginSignup.getEmailField().getCssValue("color");
				String passwordColor = loginSignup.getPasswordField().getCssValue("color");
				if (emailFont.equals(passwordFont) && emailColor.equals(passwordColor)) {
					test.pass("Font style and color are consistent");
				} else {
					test.fail("Font or color mismatch: Email(font=" + emailFont + ", color=" + emailColor +"), Password(font=" + passwordFont + ", color=" + passwordColor + ")").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_Ecom_LoginSignup_UI Fail"));
				}
			} else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}
	//TC27. Verify Hower effect on login button
	@Test
	public void TC27_VerifyHoverEffectOnLoginButton() {
		ExtentTest test = extent.createTest("Verify Hover Effect on Login Button");
		try {
			if(loginSignup.isLoginTextDisplayed()) {
				test.pass("Clicked on login/signup page");
				test.pass("Login/Signup page is opened");
				WebElement loginButton = loginSignup.getLoginButton(); // Get Login button

				String beforeHover = loginButton.getCssValue("background-color");

				new Actions(driver).moveToElement(loginButton).perform(); // Hover

				String afterHover = loginButton.getCssValue("background-color");

				if (!beforeHover.equals(afterHover)) {
					test.pass("Hover effect is applied on Login button");
				} else {
					test.fail("Hover effect is NOT applied on Login button").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_Ecom_LoginSignup_UI Fail"));
				}
			} else{
				test.fail("Login/Signup page not displayed");
			}
		}
		catch (Exception e) {
			test.fail("Exception: "+e.getMessage());
		}

	}
}