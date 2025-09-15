<<<<<<< HEAD
package com.automationexercise.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_ContactUs_Func;
import com.automationexercise.utilities.ExcelUtilities;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
public class TC_Ecom_ContactUs_Functional_Test2 extends BaseTest {
	String projectpath=System.getProperty("user.dir");


	//TC12. To verify and validate form submission with numeric characters in the 'Name' field.
	@Test(dataProvider="excelData")
	public void TC12_verifyContactFormWithNumericName(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with numeric characters in the name");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		contactus.enterName(username);
		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}
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
	@Test(dataProvider="excelData")
	public void TC13_verifyContactFormWithSpecialCharName(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with numeric characters in the name");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC14_verifyContactFormWithSpecialCharSubMsg(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with numeric characters in the name");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}


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
	@Test(dataProvider="excelData")
	public void TC15_verifyFormSubmissionwithLongStr(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with valid details and file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC16_verifyContactFormSubmissionwithlongSub(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with valid details and file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC17_verifyContactFormSubmissionwithLongMsg(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with valid details and file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC18_verifyContactFormWithAllFieldsEmpty(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with all fields empty");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC19_verifyFormWithpng(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with a valid png form");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC20_verifyContactFormWithLargeFileUpload(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify system behaviour by uploading large file");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}
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
	@Test(dataProvider="excelData")
	public void TC21_VerifySubmitButton(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with a valid PDF file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	} @DataProvider(name = "excelData")
	public Object[][] getData(Method method) throws IOException {
		String testName = method.getName(); 
		String tcId = testName.split("_")[0]; 

		String datapath = projectpath + "\\src\\test\\resources\\automationexercise_TestData\\Contactus.xlsx";
		return ExcelUtilities.getdata(datapath, "Sheet1", tcId);
	}

}
=======
package com.automationexercise.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_ContactUs_Func;
import com.automationexercise.utilities.ExcelUtilities;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
public class TC_Ecom_ContactUs_Functional_Test2 extends BaseTest {
	String projectpath=System.getProperty("user.dir");


	//TC12. To verify and validate form submission with numeric characters in the 'Name' field.
	@Test(dataProvider="excelData")
	public void TC12_verifyContactFormWithNumericName(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with numeric characters in the name");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		contactus.enterName(username);
		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}
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
	@Test(dataProvider="excelData")
	public void TC13_verifyContactFormWithSpecialCharName(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with numeric characters in the name");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC14_verifyContactFormWithSpecialCharSubMsg(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with numeric characters in the name");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}


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
	@Test(dataProvider="excelData")
	public void TC15_verifyFormSubmissionwithLongStr(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with valid details and file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC16_verifyContactFormSubmissionwithlongSub(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with valid details and file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC17_verifyContactFormSubmissionwithLongMsg(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with valid details and file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();
		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC18_verifyContactFormWithAllFieldsEmpty(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with all fields empty");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC19_verifyFormWithpng(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with a valid png form");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	@Test(dataProvider="excelData")
	public void TC20_verifyContactFormWithLargeFileUpload(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify system behaviour by uploading large file");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}
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
	@Test(dataProvider="excelData")
	public void TC21_VerifySubmitButton(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify form submission with a valid PDF file upload");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		if(username!=null) {
			test.pass("username entered:" +username);
		}else {
			test.fail("username not entered(invalid name)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Name not entered"));
		}


		contactus.enterEmail(useremail);
		if(useremail!=null) {
			test.pass("useremail entered:" +useremail);
		}else {
			test.fail("useremail not entered(invalid email)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Email not entered"));
		}
		
		contactus.enterSubject(sub);
		if(sub!=null) {
			test.pass("subject entered:" +sub);
		}else {
			test.fail("subject not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subject not entered"));
		}
		
		
		contactus.enterMessage(messagetxt);
		if(messagetxt!=null) {
			test.pass("message entered:" +messagetxt);
		}else {
			test.fail("message not entered").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Message not entered"));
		}

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
	} @DataProvider(name = "excelData")
	public Object[][] getData(Method method) throws IOException {
		String testName = method.getName(); 
		String tcId = testName.split("_")[0]; 

		String datapath = projectpath + "\\src\\test\\resources\\automationexercise_TestData\\Contactus.xlsx";
		return ExcelUtilities.getdata(datapath, "Sheet1", tcId);
	}

}
>>>>>>> bfd624d6f67bc365de35f9d0fa5a381abc8c9718
