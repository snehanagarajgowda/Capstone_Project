package com.automationexercise.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Homepage_UI;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Homepage_UI_Test2 extends BaseTest {
	TC_Ecom_Homepage_UI homepage;

	@BeforeMethod
	public void setupPage() {
		homepage = new TC_Ecom_Homepage_UI(driver);
	}


	//TC18. To verify and validate the  E-commerece web application recommended items list on home page
	@Test
	public void TC18_verifyRecommendedItems() {
		ExtentTest test = extent.createTest("Verify Recommended Items on home page");
		try {
			homepage.clickRecommendedItem();
			test.pass("Clicked first recommended item successfully");
		} catch (Exception e) {
			test.fail("Failed to click recommended item: " + e.getMessage());
		}
	}


	//TC19. To verify and validate the  E-commerece web application recommended items display
	@Test
	public void TC19_verifyRecommendedItemsDisplay() {
		ExtentTest test = extent.createTest("Verify hover effect on featured product");
		try {
			if(homepage.isDisplayedRecommendedItems()) {
				test.pass("Recommended items is displayed");
			}
			else {
				test.fail("Recommended items not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Recommended items not displayed"));
			}

		} catch (Exception e) {
			test.fail("Exception during hover test: " + e.getMessage());
		}
	}

	// TC20. To verify and validate the  E-commerece web application subscription displayed on home page
	@Test
	public void TC20_verifySubscriptionDisplayed() {
		ExtentTest test = extent.createTest("Verify subscription displayed");
		try {
			boolean result = homepage.isSubscriptionDisplayed();
			if (result) {
				test.pass("Subscription section is displayed");
			} else {
				test.fail("Subscription section is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subscription is not displayed"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC21. To verify and validate the  E-commerece web application subscription mail on home page.
	@Test
	public void TC21_verifyValidSubscriptionMail() {
		ExtentTest test = extent.createTest("Verify valid subscription mail");
		try {
			homepage.enterSubscriptionEmail("03snehan@gmail.com");
			boolean result = homepage.isSubscriptionSuccess();
			if (result) {
				test.pass("Valid subscription mail accepted");
			} else {
				test.fail("Valid subscription mail not accepted").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subscription fails"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC22.To verify and validate the  E-commerece web application Dots button in the periodic slide show.
	@Test
	public void TC22_verifySliderDots() {
		ExtentTest test = extent.createTest("Verify dots slide show on home page");
		try {
			if (homepage.isSliderDotsVisible()) {
				test.pass("Slider dots are visible");
				homepage.clickFirstSliderDot();
				test.pass("Clicked first slider dot successfully");
			} else {
				test.fail("Slider dots are not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Dot slide show fails"));;
			}
		} catch (Exception e) {
			test.fail("Exception while verifying slider dots: " + e.getMessage());
		}
	}

	//TC23. To verify and validate Category display on home page
	@Test
	public void TC23_verifyCategoryisDisplayed() {
		ExtentTest test = extent.createTest("Verify first category expansion on home page");
		try {
			boolean result=homepage.isCategoryDisplayed();
			if(result) {
				test.pass("Category is displayed on home page");
			}
			else {
				test.fail("Category is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Category display fails"));
			}

		} catch(Exception e) {
			test.fail("Failed to click category: " + e.getMessage());
		}
	} 

	//TC24. To verify and validate feature item is displayed on homepage
	@Test
	public void TC24_verifyFeatureItemsDisplay() {
		ExtentTest test = extent.createTest("Verify feature item  display");
		try {
			if(homepage.isDisplayedFeatureItems()) {
				test.pass("Feature item is displayed");
			}
			else {
				test.fail("Feature item is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Feature items display fails"));
			}
		} catch(Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

	//TC25. To verify and validate Subscription with an Invalid Email
	@Test
	public void TC25_verifyInvalidSubscriptionMail() {
		ExtentTest test = extent.createTest("Verify invalid subscription mail");
		try {
			homepage.enterSubscriptionEmail("12mail.com");
			boolean result = homepage.isSubscriptionSuccess();
			if (!result) {
				test.pass("Invalid subscription mail correctly rejected");
			} else {
				test.fail("Invalid subscription mail NOT handled")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Failed to subscribe with invalid email"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 
	// TC26. To verify and validate the e commerce web application without entering the email of subscription on products page
	@Test
	public void TC26_verifyEmptySubscriptionMail() {
		ExtentTest test = extent.createTest("Verify Empty SubscriptionMail");
		try {
			homepage.enterSubscriptionEmail("");
			boolean result = homepage.isSubscriptionSuccess();
			if (!result) {
				test.pass("Empty subscription mail correctly handled");
			} else {
				test.fail("Empty subscription mail not  handled").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Cannot suscribe without email"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}
	//TC27. To verify and validate with working of side arrow for subscription mail on e commerce web application products page
	@Test
	public void TC27_verifySubscriptionArrowWorks() {
		ExtentTest test = extent.createTest("Verify subscription arrow works");
		try {
			homepage.enterSubscriptionEmail("valid@email.com");
			boolean result = homepage.isSubscriptionSuccess();
			if (result) {
				test.pass("Subscription arrow works with valid email");
			} else {
				test.fail("Subscription arrow not working properly").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subcription arrow not working"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}




	//TC28. To verify and validate 'Recommended Items' Carousel Forward
	@Test
	public void TC28_verifyRecommendedCarouselForward() throws IOException {
		ExtentTest test = extent.createTest("Verify recommended carousel forward button");
		try {
			homepage.clickRecommendedForward();
			test.pass("Clicked ecommended items forward button successfully");
		} catch(Exception e) {
			test.fail("Failed to click recommended items forward button").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Recommended carousel fail"));
		}
	}

	//TC29. To verify and validate 'Recommended Items' Carousel Backward
	@Test
	public void TC29_verifyRecommendedCarouselBackward() throws IOException {
		ExtentTest test = extent.createTest("Verify recommended carousel backward button");
		try {
			homepage.clickRecommendedBackward();
			test.pass("Clicked recommended items backward button successfully");
		} catch(Exception e) {
			test.fail("Failed to click recommended items backward button").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Recommended carousel fail"));
		}
	}

	//TC30. To verify and validate Page Scroll-Up  Functionality
	@Test
	public void TC30_verifyPageScrollUp() throws IOException {
		ExtentTest test = extent.createTest("Verify scroll up button functionality");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try {
			js.executeScript("window.scrollBy(0, -document.body.scrollHeight);");
			System.out.println(js.executeScript("return window.pageYOffset;"));
			test.pass("Page scrolled up");

		}catch(Exception e) {
			test.fail("Page is not scrolled up").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Page scroll up fails"));;
		}
	}


	//TC31. To verify and validate Add to Cart from 'Recommended Items'
	@Test
	public void TC31_verifyAddToCartRecommended() throws IOException {
		ExtentTest test = extent.createTest("Verify add to cart functionality from recommended items");
		try {
			homepage.clickRecommendedAddCart();
			test.pass("Clicked add to cart for recommended item successfully");
		} catch(Exception e) {
			test.fail("Failed to click add to cart for recommended item: " + e.getMessage()).addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Recommended failed to add cart"));
		}
	}
	// TC32. To verify and validate the e commerce web application copyright is displayed on home page
	@Test
	public void TC32_verifyCopyrightDisplayed() {

		ExtentTest test = extent.createTest("TC28_verifyCopyrightDisplayed");
		try {
			boolean result = homepage.isCopyrightDisplayed();
			if (result) {
				test.pass("Copyright is displayed");
			} else {
				test.fail("Copyright is not displayed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Copy right is not displayed"));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC33. TO verify and validate page scroll down
	@Test
	public void TC33_verifyPageScrollDown() {
		ExtentTest test = extent.createTest("Verify scroll up button functionality");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try {
			js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
			System.out.println(js.executeScript("return window.pageYOffset;"));
			test.pass("Page scrolled down");

		}catch(Exception e) {
			test.fail("Page is not scrolled down").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Page scroll down fails"));;
		}
	}

}



