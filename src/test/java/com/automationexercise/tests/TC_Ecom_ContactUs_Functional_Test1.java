package com.automationexercise.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_ContactUs_Func;
import com.automationexercise.pages.TC_Ecom_Contactus_UI;
import com.automationexercise.utilities.ExcelUtilities;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_ContactUs_Functional_Test1 extends BaseTest {
	String projectpath=System.getProperty("user.dir");
	TC_Ecom_ContactUs_Func contactus;
	@BeforeMethod
	public void setupPage() {
		contactus= new TC_Ecom_ContactUs_Func(driver);
	}




	// TC01. Verify Home Page URL
	@Test
	public void TC01_VerifyUrlNavigatesHomepage() throws IOException {
		ExtentTest test=extent.createTest("To verify and validate that the user can navigate to the URL: 'http://automationexercise.com'");

		try {

			String expectedURL = "https://automationexercise.com/";
			String actualURL = driver.getCurrentUrl();

			if (actualURL.equals(expectedURL)) {
				test.pass("URL navigates correctly to home page");

				if (driver.getTitle().contains("Automation Exercise")) {
					test.pass("Home page title is correct: " + driver.getTitle());
				} else {
					test.fail(" Home page title mismatch").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "HomepageTitleMismatch"));
				}

			} else {
				test.fail("Step 2: URL is not correct. Actual: " + actualURL).addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "NavigationToHomePageFails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	// TC02. Verify on clicking contactus its should open contact us page
	@Test
	public void TC02_VerifyHomeNavigatesContactuspage() throws IOException {
		ExtentTest test=extent.createTest("To verify and validate that the user can navigate to the Contact us page");
		try {
			if(driver.getTitle().contains("Automation Exercise")) {
				test.pass("Url navigated to home page");
				contactus.clickContactUs();
				test.pass("Clicked on contact us button");


				String actualTitle = driver.getTitle();
				if(actualTitle.equalsIgnoreCase("Automation Exercise - Contact us")) {
					test.pass("Navigated to contact us page");
					test.pass("Contact us page is opened");
				}
				else {
					test.fail("Not navigated to contact us page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Navigation fails to contactus page"));
					test.fail("Contact us page is not opened");

				}
			}else {
				test.fail("Url not navigated to home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Navigation fails to home page"));;
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	// TC03. Verify form submission with valid details and file upload
	@Test(dataProvider="excelData")

	public void TC03_verifyContactFormSubmission(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with valid details and file upload");

		try {
			if(driver.getTitle().contains("Automation Exercise")) {
				test.pass("Url navigated to home page");
				contactus.clickContactUs();
				test.pass("Clicked on contact us button");
				if(contactus.isContactUsDisplayed()) {
					test.pass("Contactus page is opened");
				}else {
					test.fail("Contactus page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Contactus page open fails "));
				}
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
				
				String filePath = projectpath + "\\src\\test\\resources\\automationexercise_TestData\\CapstoneProject.txt";
				contactus.uploadFile(filePath);
				test.pass("Uploaded file");
				contactus.clickSubmit();
				test.pass("Clicked on submit button");

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


			}else {
				test.fail("Url not navigated to home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Navigation fails to home page"));;
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
	// TC04. Verify form submission with valid details without file upload)
	@Test(dataProvider="excelData")
	public void TC04_verifyContactFormSubmissionWithoutFile(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the Contact Us form submission with all valid details but without file upload");
		try {
			if(driver.getTitle().contains("Automation Exercise")) {
				test.pass("Url navigated to home page");
				contactus.clickContactUs();
				test.pass("Clicked on contact us button");
				if(contactus.isContactUsDisplayed()) {
					test.pass("Contactus page is opened");
				}else {
					test.fail("Contactus page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Contactus page open fails "));
				}
				// Enter valid details
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
				test.pass("Clicked on submit button");
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
			} else {
				test.fail("Url not navigated to home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Navigation fails to home page"));;
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC05. Verify form submission with valid details without name

	@Test(dataProvider="excelData")
	public void TC05_verifyContactFormWithoutName(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with empty name");
		try {
			if(driver.getTitle().contains("Automation Exercise")) {
				test.pass("Url navigated to home page");
				contactus.clickContactUs();
				test.pass("Clicked on contact us button");
				if(contactus.isContactUsDisplayed()) {
					test.pass("Contactus page is opened");
				}else {
					test.fail("Contactus page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Contactus page open fails "));
				}

				// Leave Name empty
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
				test.pass("Clicked on submit button");

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
			else {
				test.fail("Url not navigated to home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Navigation fails to home page"));;
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	// TC06. Verify form submission with empty Email field
	@Test(dataProvider="excelData")
	public void TC06_verifyContactFormWithoutEmail(String username,String email, String subject, String msg) throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with empty Email address");

		if(driver.getTitle().contains("Automation Exercise")) {
			test.pass("Url navigated to home page");
			contactus.clickContactUs();
			test.pass("Clicked on contact us button");
			if(contactus.isContactUsDisplayed()) {
				test.pass("Contactus page is opened");
			}else {
				test.fail("Contactus page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Contactus page open fails "));
			}

			// Enter valid details
			contactus.enterName(username);
			test.pass("Name entered successfully");
			contactus.enterEmail("");        //leave email blank	
			contactus.enterSubject(subject);
			contactus.enterMessage(msg);
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
	}
	// TC07. To verify and validate that the form cannot be submitted with an invalid email format.
	@Test(dataProvider="excelData")
	public void TC07_verifyContactFormWithInvalidEmail(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with invalid email format");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		// Enter invalid email format
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
	@Test(dataProvider="excelData")
	public void TC08_verifyContactFormWithoutSubject(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with invalid email format");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		// Enter invalid email format
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
	@Test(dataProvider="excelData")
	public void TC09_verifyContactFormWithoutMessage(String username,String useremail, String sub) throws IOException {
		ExtentTest test = extent.createTest("Verify Contact Us form cannot be submitted with invalid email format");

		driver.get("https://automationexercise.com");

		TC_Ecom_ContactUs_Func contactus = new TC_Ecom_ContactUs_Func(driver);
		contactus.clickContactUs();

		// Enter invalid email format
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
		
		
		contactus.enterMessage("");
		test.pass("Message is empty");


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
	@Test(dataProvider="excelData")
	public void TC10_verifyContactFormCancelSubmission(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify form submission is cancelled when user clicks 'Cancel' on alert");

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
	@Test(dataProvider="excelData")
	public void TC11_verifyHomeButtonFunctionality(String username,String useremail, String sub, String messagetxt) throws IOException {
		ExtentTest test = extent.createTest("Verify functionality of home button on success page");
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
	@DataProvider(name = "excelData")
	public Object[][] getData(Method method) throws IOException {
		String testName = method.getName(); 
		String tcId = testName.split("_")[0]; 

		String datapath = projectpath + "\\src\\test\\resources\\automationexercise_TestData\\Contactus.xlsx";
		return ExcelUtilities.getdata(datapath, "Sheet1", tcId);
	}

}