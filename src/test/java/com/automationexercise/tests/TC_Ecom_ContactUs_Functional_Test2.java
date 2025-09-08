package com.automationexercise.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_ContactUs_Func;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
public class TC_Ecom_ContactUs_Functional_Test2 extends BaseTest {
	String projectpath=System.getProperty("user.dir");


	//TC12. To verify and validate form submission with numeric characters in the 'Name' field.
	@Test
	public void verifyContactFormWithNumericName() throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with numeric characters in the name");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		contactus.enterName("12345"); 
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("Capstone project");
		contactus.enterMessage("Testing automation exercise");

		contactus.clickSubmit();
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
			test.fail("Form not submitted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form cannot be submitted with numberic in name"));
		}
	} 

	//TC13. To verify and validate form submission with special characters in the 'Name' field.
	@Test
	public void verifyContactFormWithSpecialCharName() throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with numeric characters in the name");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		contactus.enterName("sn@ha#"); 
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("TCapstone Project");
		contactus.enterMessage("Testing automation exercise");

		contactus.clickSubmit();
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// continue
		}

		if(contactus.isSuccessMessageDisplayed()) {
			test.pass("Form submitted successfully");
		}
		else {
			test.fail("Form not submitted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form cannot be submitted with special character in name"));
		}
	}

	//TC14. To verify and validate form submission with special characters in the 'Subject' and 'Message' fields.
	@Test
	public void verifyContactFormWithSpecialCharSubMsg() throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with numeric characters in the name");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		contactus.enterName("Sneha"); 
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("Aut@mati@n T@est @#$%^&*()_+{}|:\\\"");
		contactus.enterMessage("Testing@ for#$%^&* C@pstone project");

		contactus.clickSubmit();
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// continue
		}

		if(contactus.isSuccessMessageDisplayed()) {
			test.pass("Form submitted successfully");
		}
		else {
			test.fail("Form not submitted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form cannot be submitted with special character in mesaage and subject field"));
		}
	} 

	// TC15. To verify and validate form submission with a very long string in the 'Name' field.
	@Test
	public void verifyFormSubmissionwithLongStr() throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with valid details and file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		contactus.enterName("Snehaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
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

	//TC16 To verify and validate form submission with a very long string in the 'Subject' field.
	@Test
	public void verifyContactFormSubmissionwithlongSub() throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with valid details and file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		contactus.enterName("Sneha");
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("In Capstone project we are automating test cases using automation exercise url ");
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
	//TC17 To verify and validate form submission with a very long string in the 'Message' field.
	@Test
	public void verifyContactFormSubmissionwithLongMsg() throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with valid details and file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		contactus.enterName("Sneha");
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("In Capstone project");
		contactus.enterMessage("On the Automation Exercise website, the Contact Us form includes built-in validation to ensure users provide correct information. If a user enters an invalid email format, the form displays a clear message prompting them to correct it. This feature helps prevent incorrect submissions and ensures that messages reach the intended recipients reliably.");
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

	//TC18 To verify and validate that the form cannot be submitted with all fields empty.
	@Test
	public void verifyContactFormWithAllFieldsEmpty() throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with all fields empty");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		contactus.enterName();
		contactus.enterEmail("");
		contactus.enterSubject("");
		contactus.enterMessage("");

		contactus.clickSubmit();
		// Handle alert if appears
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// continue
		}
		String nameValidation = contactus.enterName().getAttribute("validationMessage");
		String emailValidation = contactus.enterEmail().getAttribute("validationMessage");
		String subjectValidation = contactus.enterSubject().getAttribute("validationMessage");
		String messageValidation = contactus.enterMessage().getAttribute("validationMessage");
		if ((nameValidation != null && !nameValidation.isEmpty()) ||
				(emailValidation != null && !emailValidation.isEmpty()) ||
				(subjectValidation != null && !subjectValidation.isEmpty()) ||
				(messageValidation != null && !messageValidation.isEmpty())) {
			test.pass("Form cannot be submitted with empty fields");
		}
		else {
			test.fail("Form submitted with empty fields").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form submission failed"));
		}
	} 


	
	//TC19 To verify and validate form submission with a different valid file type (e.g., .png).
	@Test
	public void verifyFormWithpng() throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with a valid png form");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		contactus.enterName("Sneha");
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("Test PDF File Upload");
		contactus.enterMessage("Testing form submission with a PDF file upload.");

		String pdfFilePath = projectpath + "\\src\\test\\resources\\automationexercise_TestData\\CapstoneProject.png";
		contactus.uploadFile(pdfFilePath);
		contactus.clickSubmit();

		try {
			driver.switchTo().alert().accept();
		}catch (NoAlertPresentException e) {
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(contactus.isSuccessMessageDisplayed()) {
			test.pass("Form submitted successfully with png file format");
		}
		else {
			test.fail("Form not submitted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form submission failed with png file format"));
		} 
	} 

	//TC20 To verify and validate the system's behavior when uploading a large file.
	@Test
	public void verifyContactFormWithLargeFileUpload() throws IOException {
		ExtentTest test = extent.createTest("Verify system behaviour by uploading large file");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		contactus.enterName("Sneha");
		contactus.enterEmail("sneha@example.com");
		contactus.enterSubject("Test Large File Upload");
		contactus.enterMessage("Testing form submission with a file exceeding the allowed size limit.");
		String pdfFilePath = projectpath + "\\src\\test\\resources\\automationexercise_TestData\\package com.pdf";
		contactus.uploadFile(pdfFilePath);
		contactus.clickSubmit();

		try {
			driver.switchTo().alert().accept();
		}catch (NoAlertPresentException e) {
		}

		if(contactus.isSuccessMessageDisplayed()) {
			test.pass("Form submitted successfully with large file size");
		}
		else {
			test.fail("Form not submitted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form submission failed with large file size"));
		} 
	}    

	
	//TC21 To verify and validate submit button
	@Test
	public void VerifySubmitButton() throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with a valid PDF file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		contactus.enterName("Sneha");
		contactus.enterEmail("03snehan@gmail.com");
		contactus.enterSubject("Test PDF File Upload");
		contactus.enterMessage("Testing form submission with a PDF file upload.");

		String pdfFilePath = projectpath + "\\src\\test\\resources\\automationexercise_TestData\\CapstoneProject.png";
		contactus.uploadFile(pdfFilePath);
		contactus.clickSubmit();

		try {
			driver.switchTo().alert().accept();
		}catch (NoAlertPresentException e) {
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(contactus.isSuccessMessageDisplayed()) {
			test.pass("Form submitted successfully");
		}
		else {
			test.fail("Form not submitted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Form submission failed, submit button not working"));
		} 
	} 
}