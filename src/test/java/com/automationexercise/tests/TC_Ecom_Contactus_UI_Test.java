<<<<<<< HEAD
package com.automationexercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Contactus_UI;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Contactus_UI_Test extends BaseTest {
	TC_Ecom_Contactus_UI ContactUs;

	@BeforeMethod
	public void setupPage() {
		ContactUs= new TC_Ecom_Contactus_UI(driver);
		ContactUs.clickContactusButton();	

	}

	//TC01. To verify and validate that Ecommerce web application logo is visible on contact us page
	@Test
	public void TC01_VerifyLogo() {
		ExtentTest test = extent.createTest("Verify Logo");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");

				if (ContactUs.isLogoDisplayed()) {
					test.pass("Logo is displayed on contact us page");
				} else {
					test.fail("Logo is not displayed on contact us page")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC01_Fails"));
				}

			} else {
				test.fail("Contact us page is not opened")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02_Fails"));
			}

		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}


	//TC02 To verify name input box is visible
	@Test
	public void TC02_VerifyNameInputTextBox() {
		ExtentTest test = extent.createTest("Verify name input box");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isNameInputTextBoxDisplayed()) {
					test.pass("Name input box is visible");
				}else {
					test.fail("Name input box is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02 Fails"));
				}

			}else {
				test.fail("Contact us page not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02 Fails"));;

			}

		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
	//TC03 To verify email input box is visible
	@Test
	public void TC03_VerifyemailInputTextBOX() {
		ExtentTest test = extent.createTest("Verify email input box");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isEmailInputTextBoxDisplayed()) {
					test.pass("email input box is visible");
				}else {
					test.fail("email input box is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03 Fails"));
				}

			}else {
				test.fail("Contact us page not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03 Fails"));

			}

		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC04. To verify and validate that Subject text box is visible on Contact Us page
	@Test
	public void TC04_VerifySubjectTextBox() {
		ExtentTest test = extent.createTest("Verify Subject TextBox visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if (ContactUs.isSubjectTextBoxDisplayed()) {
					test.pass("Subject text box is visible on Contact Us page");
				} else {
					test.fail("Subject text box is not visible")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_SubjectTextbox_Fail"));
				}
			} else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_SubjectTextbox_Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC05 TO verify message text box is visible on contact us page
	@Test
	public void TC05_VerifyMessageTextBox() {
		ExtentTest test = extent.createTest("Verify Message TextBox visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isyourMSGHereTextDisplayed()) {
					test.pass("Message box is displayed");
				}else {
					test.fail("Message box is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
	//TC06 TO verify upload files is visible on contact us page
	@Test
	public void TC06_VerifyUploadFilText() {
		ExtentTest test = extent.createTest("Verify upload files visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isUploadFilesDisplayed()) {
					test.pass("Upload files is displayed");
				}else {
					test.fail("Upload files is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC07 TO verify submit button is visible on contact us page
	@Test
	public void TC07_VerifySubmitButton() {
		ExtentTest test = extent.createTest("Verify submit button visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isSubmitButtonDisplayed()) {
					test.pass("submit button is displayed");
				}else {
					test.fail("submit button is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC08 TO verify Subscription text is visible on contact us page
	@Test
	public void TC08_VerifySubscriptiontext() {
		ExtentTest test = extent.createTest("Verify Subscription text visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isSubscriptionDisplayed()) {
					test.pass("Subscription text is displayed");
				}else {
					test.fail("Subscription text is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC09 TO verify Subscription input text box is visible on contact us page
	@Test
	public void TC09_VerifySubscriptionInputtextBox() {
		ExtentTest test = extent.createTest("Verify Subscription input text box visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isSubscriptionInputTextBoxDisplayed()) {
					test.pass("Subscription input text box is displayed");
				}else {
					test.fail("Subscription input text box is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}


	//TC10 TO verify Copy rights is visible on contact us page
	@Test
	public void TC10_VerifyCopyRights() {
		ExtentTest test = extent.createTest("Verify Copy rights visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isCopyRightDisplayed()) {
					test.pass("Copy rights is displayed");
				}else {
					test.fail("Copy rights is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC11 TO verify Feedback us is visible on contact us page
	@Test
	public void TC11_VerifyFeedbackUs() {
		ExtentTest test = extent.createTest("Verify Feedback us visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isFeedbackForUsDisplayed()) {
					test.pass("Feedback us is displayed");
				}else {
					test.fail("Feedback us is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC12 TO verify Scroll up is visible on contact us page
	@Test
	public void TC12_VerifyScrollUp() {
		ExtentTest test = extent.createTest("Verify Scroll up visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isScrollUpDisplayed()) {
					test.pass("Scroll up is displayed");
				}else {
					test.fail("Scroll up is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
	//TC13 TO verify arrow is visible on contact us page
	@Test
	public void TC13_VerifyArrow() {
		ExtentTest test = extent.createTest("Verify Arrow visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isArrowDisplayed()) {
					test.pass("Arrow is displayed");
				}else {
					test.fail("Arrow is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
	//TC14 TO verify name is editable on contact us page

	@Test
	public void TC14_VerifyNameFieldEditable() {
		ExtentTest test = extent.createTest("Verify Name field editable");

		try {

			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");

				if (ContactUs.isNameFieldEditable()) {
					test.pass("Name input field is editable");
				} else {
					test.fail("Name input field is not editable")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14 fails"));
				}

			} else {
				test.fail("Contact Us page not displayed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14 fails"));
			}

		} catch (Exception e) {
			test.fail("Exception occurred: " + e.getMessage());
		}
	}

	//TC15 TO verify email is editable on contact us page

	@Test
	public void TC13_VerifyEmailFieldEditable() {
		ExtentTest test = extent.createTest("Verify Email field editable");

		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");

				// Step 2: Verify Email field is editable
				if (ContactUs.isEmailFieldEditable()) {
					test.pass("Email input field is editable");
				} else {
					test.fail("Email input field is not editable")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC15 fails"));
				}

			} else {
				test.fail("Contact Us page not displayed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC15 fails"));
			}

		} catch (Exception e) {
			test.fail("Exception occurred: " + e.getMessage());
		}
	}
	//TC16 TO verify subject is editable on contact us page
	@Test
	public void TC16_VerifySubjectFieldEditable() {
		ExtentTest test = extent.createTest("Verify Subject field editable");

		try {

			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");

				if (ContactUs.isSubjectFieldEditable()) {
					test.pass("Subject input field is editable");
				} else {
					test.fail("Subject input field is not editable")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16 fails"));
				}

			} else {
				test.fail("Contact Us page not displayed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16 fails"));
			}

		} catch (Exception e) {
			test.fail("Exception occurred: " + e.getMessage());
		}
	}
	//TC17 TO verify message field is editable on contact us page
	@Test
	public void TC17_VerifyMessageFieldEditable() {
		ExtentTest test = extent.createTest("Verify Message field editable");

		try {

			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");

				if (ContactUs.isMessageFieldEditable()) {
					test.pass("Message textarea is editable");
				} else {
					test.fail("Message textarea is not editable")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17 Fails"));
				}

			} else {
				test.fail("Contact Us page not displayed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17 fails"));
			}

		} catch (Exception e) {
			test.fail("Exception occurred: " + e.getMessage());
		}
	}


}

=======
package com.automationexercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Contactus_UI;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Contactus_UI_Test extends BaseTest {
	TC_Ecom_Contactus_UI ContactUs;

	@BeforeMethod
	public void setupPage() {
		ContactUs= new TC_Ecom_Contactus_UI(driver);
		ContactUs.clickContactusButton();	

	}

	//TC01. To verify and validate that Ecommerce web application logo is visible on contact us page
	@Test
	public void TC01_VerifyLogo() {
		ExtentTest test = extent.createTest("Verify Logo");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");

				if (ContactUs.isLogoDisplayed()) {
					test.pass("Logo is displayed on contact us page");
				} else {
					test.fail("Logo is not displayed on contact us page")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC01_Fails"));
				}

			} else {
				test.fail("Contact us page is not opened")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02_Fails"));
			}

		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}


	//TC02 To verify name input box is visible
	@Test
	public void TC02_VerifyNameInputTextBox() {
		ExtentTest test = extent.createTest("Verify name input box");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isNameInputTextBoxDisplayed()) {
					test.pass("Name input box is visible");
				}else {
					test.fail("Name input box is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02 Fails"));
				}

			}else {
				test.fail("Contact us page not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02 Fails"));;

			}

		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
	//TC03 To verify email input box is visible
	@Test
	public void TC03_VerifyemailInputTextBOX() {
		ExtentTest test = extent.createTest("Verify email input box");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isEmailInputTextBoxDisplayed()) {
					test.pass("email input box is visible");
				}else {
					test.fail("email input box is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03 Fails"));
				}

			}else {
				test.fail("Contact us page not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03 Fails"));

			}

		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC04. To verify and validate that Subject text box is visible on Contact Us page
	@Test
	public void TC04_VerifySubjectTextBox() {
		ExtentTest test = extent.createTest("Verify Subject TextBox visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if (ContactUs.isSubjectTextBoxDisplayed()) {
					test.pass("Subject text box is visible on Contact Us page");
				} else {
					test.fail("Subject text box is not visible")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_SubjectTextbox_Fail"));
				}
			} else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_SubjectTextbox_Fail"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC05 TO verify message text box is visible on contact us page
	@Test
	public void TC05_VerifyMessageTextBox() {
		ExtentTest test = extent.createTest("Verify Message TextBox visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isyourMSGHereTextDisplayed()) {
					test.pass("Message box is displayed");
				}else {
					test.fail("Message box is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
	//TC06 TO verify upload files is visible on contact us page
	@Test
	public void TC06_VerifyUploadFilText() {
		ExtentTest test = extent.createTest("Verify upload files visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isUploadFilesDisplayed()) {
					test.pass("Upload files is displayed");
				}else {
					test.fail("Upload files is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC07 TO verify submit button is visible on contact us page
	@Test
	public void TC07_VerifySubmitButton() {
		ExtentTest test = extent.createTest("Verify submit button visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isSubmitButtonDisplayed()) {
					test.pass("submit button is displayed");
				}else {
					test.fail("submit button is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC08 TO verify Subscription text is visible on contact us page
	@Test
	public void TC08_VerifySubscriptiontext() {
		ExtentTest test = extent.createTest("Verify Subscription text visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isSubscriptionDisplayed()) {
					test.pass("Subscription text is displayed");
				}else {
					test.fail("Subscription text is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC09 TO verify Subscription input text box is visible on contact us page
	@Test
	public void TC09_VerifySubscriptionInputtextBox() {
		ExtentTest test = extent.createTest("Verify Subscription input text box visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isSubscriptionInputTextBoxDisplayed()) {
					test.pass("Subscription input text box is displayed");
				}else {
					test.fail("Subscription input text box is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}


	//TC10 TO verify Copy rights is visible on contact us page
	@Test
	public void TC10_VerifyCopyRights() {
		ExtentTest test = extent.createTest("Verify Copy rights visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isCopyRightDisplayed()) {
					test.pass("Copy rights is displayed");
				}else {
					test.fail("Copy rights is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC11 TO verify Feedback us is visible on contact us page
	@Test
	public void TC11_VerifyFeedbackUs() {
		ExtentTest test = extent.createTest("Verify Feedback us visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isFeedbackForUsDisplayed()) {
					test.pass("Feedback us is displayed");
				}else {
					test.fail("Feedback us is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC12 TO verify Scroll up is visible on contact us page
	@Test
	public void TC12_VerifyScrollUp() {
		ExtentTest test = extent.createTest("Verify Scroll up visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isScrollUpDisplayed()) {
					test.pass("Scroll up is displayed");
				}else {
					test.fail("Scroll up is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
	//TC13 TO verify arrow is visible on contact us page
	@Test
	public void TC13_VerifyArrow() {
		ExtentTest test = extent.createTest("Verify Arrow visibility");
		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");
				if(ContactUs.isArrowDisplayed()) {
					test.pass("Arrow is displayed");
				}else {
					test.fail("Arrow is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13 Fails"));
				}
			}else {
				test.fail("Contact Us page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13 fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
	//TC14 TO verify name is editable on contact us page

	@Test
	public void TC14_VerifyNameFieldEditable() {
		ExtentTest test = extent.createTest("Verify Name field editable");

		try {

			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");

				if (ContactUs.isNameFieldEditable()) {
					test.pass("Name input field is editable");
				} else {
					test.fail("Name input field is not editable")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14 fails"));
				}

			} else {
				test.fail("Contact Us page not displayed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14 fails"));
			}

		} catch (Exception e) {
			test.fail("Exception occurred: " + e.getMessage());
		}
	}

	//TC15 TO verify email is editable on contact us page

	@Test
	public void TC13_VerifyEmailFieldEditable() {
		ExtentTest test = extent.createTest("Verify Email field editable");

		try {
			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");

				// Step 2: Verify Email field is editable
				if (ContactUs.isEmailFieldEditable()) {
					test.pass("Email input field is editable");
				} else {
					test.fail("Email input field is not editable")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC15 fails"));
				}

			} else {
				test.fail("Contact Us page not displayed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC15 fails"));
			}

		} catch (Exception e) {
			test.fail("Exception occurred: " + e.getMessage());
		}
	}
	//TC16 TO verify subject is editable on contact us page
	@Test
	public void TC16_VerifySubjectFieldEditable() {
		ExtentTest test = extent.createTest("Verify Subject field editable");

		try {

			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");

				if (ContactUs.isSubjectFieldEditable()) {
					test.pass("Subject input field is editable");
				} else {
					test.fail("Subject input field is not editable")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16 fails"));
				}

			} else {
				test.fail("Contact Us page not displayed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16 fails"));
			}

		} catch (Exception e) {
			test.fail("Exception occurred: " + e.getMessage());
		}
	}
	//TC17 TO verify message field is editable on contact us page
	@Test
	public void TC17_VerifyMessageFieldEditable() {
		ExtentTest test = extent.createTest("Verify Message field editable");

		try {

			if (ContactUs.isGetInTextDisplayed()) {
				test.pass("Clicked on contactus page");
				test.pass("Contact us page is opened");

				if (ContactUs.isMessageFieldEditable()) {
					test.pass("Message textarea is editable");
				} else {
					test.fail("Message textarea is not editable")
					.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17 Fails"));
				}

			} else {
				test.fail("Contact Us page not displayed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17 fails"));
			}

		} catch (Exception e) {
			test.fail("Exception occurred: " + e.getMessage());
		}
	}


}

>>>>>>> bfd624d6f67bc365de35f9d0fa5a381abc8c9718
