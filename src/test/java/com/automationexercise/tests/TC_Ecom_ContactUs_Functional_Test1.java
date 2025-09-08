package com.automationexercise.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_ContactUs_Func;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_ContactUs_Functional_Test1 extends BaseTest {
	String projectpath=System.getProperty("user.dir");
	
	// TC01. Verify Home Page URL
	@Test
	public void VerifyUrlNavigatesHomepage() throws IOException {
		ExtentTest test=extent.createTest("To verify and validate that the user can navigate to the URL: 'http://automationexercise.com'");

		driver.get("https://automationexercise.com");

		String expectedURL = "https://automationexercise.com/";
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equals(expectedURL)) {
			test.pass("TC01 Passed: URL navigates to the home page");

		}
		else {
			test.fail("TC01 Failed: Url is not navigated to home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Navigation to home page fails"));;
		}
	} 

	// TC02. Verify on clicking contactus its should open contact us page
	@Test
	public void VerifyHomeNavigatesContactuspage() throws IOException {
		ExtentTest test=extent.createTest("To verify and validate that the user can navigate to the Contact us page");

		driver.get("https://automationexercise.com");
		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		String actualTitle = driver.getTitle();
		if(actualTitle.equalsIgnoreCase("Automation Exercise - Contact us")) {
			test.pass("Navigated to contact us page");
		}
		else {
			test.fail("Not navigated to contact us page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Navigation fails to contactus page"));
		}
	}  

	// TC03. Verify form submission with valid details and file upload
	@Test
	public void verifyContactFormSubmission() throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with valid details and file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		contactus.enterName("Sneha");
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("Capstone project");
		contactus.enterMessage("Testing automation exercise");
		String filePath = projectpath + "\\src\\test\\resources\\automationexercise_TestData\\CapstoneProject.txt";
		contactus.uploadFile(filePath);
		contactus.clickSubmit();

		//to handle alert after submission
		try {
			driver.switchTo().alert().accept();
		}catch (NoAlertPresentException e) {
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(contactus.isSuccessMessageDisplayed()) {
			test.pass("Form submitted successfully");
		}
		else {
			test.fail("Form not submitted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form submission failed"));
		}


	}
	// TC04. Verify form submission with valid details without file upload)
	@Test
	public void verifyContactFormSubmissionWithoutFile() throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with all valid details but without file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		// Enter valid details
		contactus.enterName("Sneha");
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("Capstone project");
		contactus.enterMessage("Testing automation exercise");
		contactus.clickSubmit();
		//to handle alert after submission
		try {
			driver.switchTo().alert().accept();
		}catch (NoAlertPresentException e) {
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(contactus.isSuccessMessageDisplayed()) {
			test.pass("Form submitted successfully");
		}
		else {
			test.fail("Form not submitted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form submission failed"));

		}
	} 

	//TC05. // TC04. Verify form submission with valid details without name

	@Test
	public void verifyContactFormWithoutName() throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with empty name");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		// Leave Name empty
		contactus.enterName("");
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("Capstone project");
		contactus.enterMessage("Testing automation exercise");

		contactus.clickSubmit();
		//to handle alert after submission
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// continue
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(contactus.isSuccessMessageDisplayed()) {
			test.pass("Form submitted successfully");
		}
		else {
			test.fail("Form not submitted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form submission failed"));
		}
	} 

	// TC06. Verify form submission with empty Email field
	@Test
	public void verifyContactFormWithoutEmail() throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with empty Email address");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		// Enter valid details
		contactus.enterName("Sneha");
		contactus.enterEmail();        //leave email blank		
		contactus.enterSubject("Capstone project");
		contactus.enterMessage("Testing automation exercise");
		contactus.clickSubmit();
		//to handle alert after submission
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// continue
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String emailValidationMessage = contactus.enterEmail().getAttribute("validationMessage");
		if (emailValidationMessage != null && !emailValidationMessage.isEmpty()) {
		} else {
			test.fail("Message not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Navigation to contact us page fail"));
		}
	} 
	// TC07. To verify and validate that the form cannot be submitted with an invalid email format.
	@Test
	public void verifyContactFormWithInvalidEmail() throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with invalid email format");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		// Enter invalid email format
		contactus.enterName("Sneha");
		contactus.enterEmail("snehacom12"); 
		contactus.enterSubject("Test Invalid Email");
		contactus.enterMessage("Testing automation exercise");

		// Click submit
		contactus.clickSubmit();
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// if no alert continue
		}
		String emailValidationMessage = contactus.enterEmail().getAttribute("validationMessage");
		if (emailValidationMessage != null && !emailValidationMessage.isEmpty()) {
			test.pass("Validation message is displayed");
		} else {
			test.fail("Message not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Navigation to contact us page fail"));
		}
	} 
	//TC08. To verify and validate that the form cannot be submitted with an empty 'Subject' field.
	@Test
	public void verifyContactFormWithoutSubject() throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with invalid email format");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		// Enter invalid email format
		contactus.enterName("Sneha");
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("");
		contactus.enterMessage("Testing automation exercise");

		// Click submit
		contactus.clickSubmit();
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// if no alert continue
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(contactus.isSuccessMessageDisplayed()) {
			test.pass("Form submitted successfully");
		}
		else {
			test.fail("Form not submitted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form cannot be submitted without subject"));
		}
	} 

	//TC09. To verify and validate that the form cannot be submitted with an empty 'Message' field.
	@Test
	public void verifyContactFormWithoutMessage() throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with invalid email format");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		// Enter invalid email format
		contactus.enterName("Sneha");
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("Capstone project");
		contactus.enterMessage("");

		// Click submit
		contactus.clickSubmit();
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// if no alert continue
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(contactus.isSuccessMessageDisplayed()) {
			test.pass("Form submitted successfully");
		}
		else {
			test.fail("Form not submitted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form cannot be submitted without meassage"));
		}
	} 

	//TC10. To verify and validate that the form submission is cancelled when the user clicks 'Cancel' on the confirmation alert.
	@Test
	public void verifyContactFormCancelSubmission() throws IOException {
		ExtentTest test = extent.createTest("Verify form submission is cancelled when user clicks 'Cancel' on alert");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		contactus.enterName("Sneha");
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("Capstone Project");
		contactus.enterMessage("Testing automation exercise");

		contactus.clickSubmit();
		try {
			driver.switchTo().alert().dismiss(); 
			System.out.println("Alert dismissed and clicked cancel");
			test.pass("User clicked Cancel on confirmation alert and submission cancelled");
		} catch (NoAlertPresentException e) {
			System.out.println("No alert appeared!");
			test.fail("No confirmation alert appeared").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "NoAlertOnCancel"));
		}
		if (contactus.isSuccessMessageDisplayed()) {
			test.fail("Form submitted even after clicking cancel");

		} else {
			test.pass("Form submission cancelled as expected").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Submission not cancelled"));
		}
	} 

	//TC11. To verify and validate the functionality of the Home button on the success page.
	@Test
	public void verifyHomeButtonFunctionality() throws IOException {
		ExtentTest test = extent.createTest("Verify functionality of home button on success page");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		contactus.enterName("Sneha");
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("Capstone Project");
		contactus.enterMessage("Testing automation exercise");

		contactus.clickSubmit();
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// if no alerts continue
		}
		contactus.clickHomeButton();
		String expectedURL = "https://automationexercise.com/";
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equals(expectedURL)) {
			test.pass("Home button navigated to home page");

		}
		else {
			test.fail("Home button is not navigated to home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Homepage fail"));
		}
	} 

}