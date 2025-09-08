package com.automationexercise.tests;

import java.io.IOException;

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

	@AfterMethod
	public void tearDown() {
		if (extent != null) {
			extent.flush();
		}
	}

	//TC21. To verify and validate the  E-commerece web application recommended items list on home page
	@Test
	public void TC23_verifyRecommendedItems() {
		ExtentTest test = extent.createTest("Verify Recommended Items on home page");
		try {
			homepage.clickRecommendedItem();
			test.pass("Clicked first recommended item successfully");
		} catch (Exception e) {
			test.fail("Failed to click recommended item: " + e.getMessage());
		}
	}


	//TC22. To verify and validate the  E-commerece web application hover effect on product on home page.
	@Test
	public void TC22_verifyHoverEffectOnProduct() {
		ExtentTest test = extent.createTest("Verify hover effect on featured product");
		try {
			boolean isHoverVisible = homepage.hoverOnProductByName("Blue Top");

			if (isHoverVisible) {
				test.pass("Hover effect visible for product: Blue Top");
			} else {
				test.fail("Hover effect NOT visible for product: Blue Top")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "HoverEffectFail"));
			}

		} catch (Exception e) {
			test.fail("Exception during hover test: " + e.getMessage());
		}
	}

	// TC23. To verify and validate the  E-commerece web application subscription displayed on home page
	@Test
	public void TC23_verifySubscriptionDisplayed() {
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

	//TC24. To verify and validate the  E-commerece web application subscription mail on home page.
	@Test
	public void TC24_verifyValidSubscriptionMail() {
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

	//TC25.To verify and validate the  E-commerece web application Dots button in the periodic slide show.
	@Test
	public void TC25_verifySliderDots() {
		ExtentTest test = extent.createTest("Verify dots slide show on home page");
		try {
			if (homepage.isSliderDotsVisible()) {
				test.pass("Slider dots are visible");
				homepage.clickFirstSliderDot();
				test.pass("Clicked first slider dot successfully");
			} else {
				test.fail("Slider dots are not visible");
			}
		} catch (Exception e) {
			test.fail("Exception while verifying slider dots: " + e.getMessage());
		}
	}

	//TC26. To verify and validate Category Expansion
	@Test
	public void TC26_verifyCategoryExpansion() {
		ExtentTest test = extent.createTest("Verify first category expansion on home page");
		try {
			homepage.clickWomenCategory();
			test.pass("Women category is clicked successfully");
			homepage.clickMenCategory();
			test.pass("Men category is clicked successfully");

			homepage.clickKidsCategory();
			test.pass("Kids category is clicked successfully");
		} catch(Exception e) {
			test.fail("Failed to click category: " + e.getMessage());
		}
	} 

	//TC27. To verify and validate 'View Product' Link Navigation
	@Test
	public void TC27_verifyViewProductNavigation() {
		ExtentTest test = extent.createTest("Verify view product link navigation for Blue Top");
		try {
			homepage.clickViewProduct();
			String expectedUrl = "https://automationexercise.com/product_details/1"; 
			String actualUrl = driver.getCurrentUrl();
			if(actualUrl.equals(expectedUrl)) {
				test.pass("View Product link navigated successfully to product detail page");
			} else {
				test.fail("Navigation failed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "View product navigation fail"));
			}
		} catch(Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	} 

	//TC28. To verify and validate Subscription with an Invalid Email
	@Test
	public void TC29_verifyInvalidSubscriptionMail() {
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
	// TC29. To verify and validate the e commerce web application without entering the email of subscription on products page
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
	//TC30. To verify and validate with working of side arrow for subscription mail on e commerce web application products page
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


	

	//TC31. To verify and validate 'Recommended Items' Carousel Forward
	@Test
	public void TC30_verifyRecommendedCarouselForward() throws IOException {
		ExtentTest test = extent.createTest("Verify recommended carousel forward button");
		try {
			homepage.clickRecommendedForward();
			test.pass("Clicked ecommended items forward button successfully");
		} catch(Exception e) {
			test.fail("Failed to click recommended items forward button").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Recommended carousel fail"));
		}
	}

	//TC32. To verify and validate 'Recommended Items' Carousel Backward
	@Test
	public void TC30_verifyRecommendedCarouselBackward() throws IOException {
		ExtentTest test = extent.createTest("Verify recommended carousel forward button");
		try {
			homepage.clickRecommendedForward();
			test.pass("Clicked recommended items backward button successfully");
		} catch(Exception e) {
			test.fail("Failed to click recommended items forward button").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Recommended carousel fail"));
		}
	}

	//TC33. To verify and validate Scroll-Up Button Functionality
	@Test
	public void TC32_verifyScrollUpButton() throws IOException {
		ExtentTest test = extent.createTest("Verify scroll up button functionality");
		try {
			homepage.clickScrollUp();
			test.pass("Clicked scroll up button successfully");
		} catch(Exception e) {
			test.fail("Failed to click scroll up button: " + e.getMessage()).addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Scroll up failed"));
		}
	}

	//TC34. To verify and validate Add to Cart from 'Recommended Items'
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
	// TC35. To verify and validate the e commerce web application copyright is displayed on home page
	 @Test
	    public void TC28_verifyCopyrightDisplayed() {
	    	
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

	
	
}



