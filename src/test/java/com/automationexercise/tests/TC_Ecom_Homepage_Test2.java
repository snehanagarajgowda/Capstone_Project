<<<<<<< HEAD
package com.automationexercise.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Homepage;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Homepage_Test2 extends BaseTest {
	TC_Ecom_Homepage homepage;

	@BeforeMethod
	public void setupPage() {
		homepage = new TC_Ecom_Homepage(driver);
	}

	//TC13. To verify View item is displayed on home page
	@Test
	public void TC13_VerifyFeatureItemElementVisibility() {
		ExtentTest test = extent.createTest("Verify View item Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isViewItemDisplayed()) {
					test.pass("View item  is visible on home page");
				}
				else {
					test.fail("View item  is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify View item  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}


	//TC14. To verify Brand is displayed on home page
	@Test
	public void TC14_VerifyBrandElementVisibility() {
		ExtentTest test = extent.createTest("Verify Brand Element  visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isBrandDisplayed()) {
					test.pass("Brand  is visible on home page");
				}
				else {
					test.fail("Brand  is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Brand  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC15. To verify Women is displayed under category on home page
	@Test
	public void TC15_VerifyWomenElementVisibility() {
		ExtentTest test = extent.createTest("Verify Women Element visibility under category");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isWomenDisplayed()) {
					test.pass("Women is visible under category on home page");
				}
				else {
					test.fail("Women is  not visible under category on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Women  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC16. To verify Men is displayed under category on home page
	@Test
	public void TC16_VerifyMenElementVisibility() {
		ExtentTest test = extent.createTest("Verify Men Element visibility under category");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isMenDisplayed()) {
					test.pass("Men is visible under category on home page");
				}
				else {
					test.fail("Men is  not visible under category on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Men  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC17. To verify Kids is displayed under category on home page
	@Test
	public void TC17_VerifyKidsElementVisibility() {
		ExtentTest test = extent.createTest("Verify Kids Element visibility under category");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isMenDisplayed()) {
					test.pass("Kids is visible under category on home page");
				}
				else {
					test.fail("Kids is  not visible under category on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Kids  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC18. To verify Recommended items is displayed under category on home page
	@Test
	public void TC18_VerifyRecommendedItemElementVisibility() {
		ExtentTest test = extent.createTest("Verify Recommended items Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isRecommendedItemDisplayed()) {
					test.pass("Recommended items is visible  on home page");
				}
				else {
					test.fail("Recommended items is  not visible under category on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Recommended items  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC19. To verify back arrow is displayed in recommended items section on home page
	@Test
	public void TC19_VerifyBackArrowElementVisibility() {
		ExtentTest test = extent.createTest("Verify back arrow Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isBackArrowDisplayed()) {
					test.pass("back arrow is visible in recommended item section on home page");
				}
				else {
					test.fail("back arrow items is  not visible in recommended item section on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify back arrow  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC20. To verify forward arrow is displayed in recommended items section on home page
	@Test
	public void TC20_VerifyForwardArrowElementVisibility() {
		ExtentTest test = extent.createTest("Verify forward arrow Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isForwardArrowDisplayed()) {
					test.pass("forward arrow is visible in recommended item section on home page");
				}
				else {
					test.fail("forward arrow items is  not visible in recommended item section on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify forward arrow  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC21. To verify add to cart is displayed in recommended items section on home page
	@Test
	public void TC21_VerifyAddToCartElementVisibility() {
		ExtentTest test = extent.createTest("Verify add to cart Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isAddToCartDisplayed()) {
					test.pass("add to cart is visible in recommended item section on home page");
				}
				else {
					test.fail("add to cart items is  not visible in recommended item section on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify add to cart  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC22. To verify Subscription is displayed on home page
	@Test
	public void TC22_VerifySubscriptionElementVisibility() {
		ExtentTest test = extent.createTest("Verify add to cart Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isSubscriptionDisplayed()) {
					test.pass("Subscription is visible on home page");
				}
				else {
					test.fail("Subscription is  not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify subscription  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC23. To verify Subscription text box is displayed on home page
	@Test
	public void TC23_VerifySubscriptionTextBoxElementVisibility() {
		ExtentTest test = extent.createTest("Verify add to cart Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isSubscriptionTextBoxDisplayed()) {
					test.pass("Subscription text box is visible on home page");
				}
				else {
					test.fail("Subscription text box is  not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify subscription text box  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC24. To verify Copy Right is displayed on home page
	@Test
	public void TC24_VerifyCopyRightElementVisibility() {
		ExtentTest test = extent.createTest("Verify Copy Right Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isSubscriptionTextBoxDisplayed()) {
					test.pass("Copy Right is visible on home page");
				}
				else {
					test.fail("Copy Right is  not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Copy Right  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC25. To verify apply code is displayed on home page
	@Test
	public void TC25_VerifyApplyCodeElementVisibility() {
		ExtentTest test = extent.createTest("Verify apply code Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isSubscriptionTextBoxDisplayed()) {
					test.pass("apply code is visible on home page");
				}
				else {
					test.fail("apply code is  not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "apply code  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC26. To verify Subscription Arrow is displayed on home page
	@Test
	public void TC26_VerifySubscriptionArrowElementVisibility() {
		ExtentTest test = extent.createTest("Verify Subscription Arrow Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isSubscriptionTextBoxDisplayed()) {
					test.pass("Subscription Arrow is visible on home page");
				}
				else {
					test.fail("Subscription Arrow is  not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subscription Arrow  Visibility fails"));
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
=======
package com.automationexercise.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Homepage;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Homepage_Test2 extends BaseTest {
	TC_Ecom_Homepage homepage;

	@BeforeMethod
	public void setupPage() {
		homepage = new TC_Ecom_Homepage(driver);
	}

	//TC13. To verify View item is displayed on home page
	@Test
	public void TC13_VerifyFeatureItemElementVisibility() {
		ExtentTest test = extent.createTest("Verify View item Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isViewItemDisplayed()) {
					test.pass("View item  is visible on home page");
				}
				else {
					test.fail("View item  is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify View item  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}


	//TC14. To verify Brand is displayed on home page
	@Test
	public void TC14_VerifyBrandElementVisibility() {
		ExtentTest test = extent.createTest("Verify Brand Element  visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isBrandDisplayed()) {
					test.pass("Brand  is visible on home page");
				}
				else {
					test.fail("Brand  is not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Brand  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC15. To verify Women is displayed under category on home page
	@Test
	public void TC15_VerifyWomenElementVisibility() {
		ExtentTest test = extent.createTest("Verify Women Element visibility under category");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isWomenDisplayed()) {
					test.pass("Women is visible under category on home page");
				}
				else {
					test.fail("Women is  not visible under category on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Women  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC16. To verify Men is displayed under category on home page
	@Test
	public void TC16_VerifyMenElementVisibility() {
		ExtentTest test = extent.createTest("Verify Men Element visibility under category");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isMenDisplayed()) {
					test.pass("Men is visible under category on home page");
				}
				else {
					test.fail("Men is  not visible under category on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Men  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC17. To verify Kids is displayed under category on home page
	@Test
	public void TC17_VerifyKidsElementVisibility() {
		ExtentTest test = extent.createTest("Verify Kids Element visibility under category");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isMenDisplayed()) {
					test.pass("Kids is visible under category on home page");
				}
				else {
					test.fail("Kids is  not visible under category on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Kids  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC18. To verify Recommended items is displayed under category on home page
	@Test
	public void TC18_VerifyRecommendedItemElementVisibility() {
		ExtentTest test = extent.createTest("Verify Recommended items Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isRecommendedItemDisplayed()) {
					test.pass("Recommended items is visible  on home page");
				}
				else {
					test.fail("Recommended items is  not visible under category on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Recommended items  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC19. To verify back arrow is displayed in recommended items section on home page
	@Test
	public void TC19_VerifyBackArrowElementVisibility() {
		ExtentTest test = extent.createTest("Verify back arrow Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isBackArrowDisplayed()) {
					test.pass("back arrow is visible in recommended item section on home page");
				}
				else {
					test.fail("back arrow items is  not visible in recommended item section on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify back arrow  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC20. To verify forward arrow is displayed in recommended items section on home page
	@Test
	public void TC20_VerifyForwardArrowElementVisibility() {
		ExtentTest test = extent.createTest("Verify forward arrow Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isForwardArrowDisplayed()) {
					test.pass("forward arrow is visible in recommended item section on home page");
				}
				else {
					test.fail("forward arrow items is  not visible in recommended item section on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify forward arrow  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC21. To verify add to cart is displayed in recommended items section on home page
	@Test
	public void TC21_VerifyAddToCartElementVisibility() {
		ExtentTest test = extent.createTest("Verify add to cart Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isAddToCartDisplayed()) {
					test.pass("add to cart is visible in recommended item section on home page");
				}
				else {
					test.fail("add to cart items is  not visible in recommended item section on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify add to cart  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC22. To verify Subscription is displayed on home page
	@Test
	public void TC22_VerifySubscriptionElementVisibility() {
		ExtentTest test = extent.createTest("Verify add to cart Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isSubscriptionDisplayed()) {
					test.pass("Subscription is visible on home page");
				}
				else {
					test.fail("Subscription is  not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify subscription  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC23. To verify Subscription text box is displayed on home page
	@Test
	public void TC23_VerifySubscriptionTextBoxElementVisibility() {
		ExtentTest test = extent.createTest("Verify add to cart Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isSubscriptionTextBoxDisplayed()) {
					test.pass("Subscription text box is visible on home page");
				}
				else {
					test.fail("Subscription text box is  not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify subscription text box  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC24. To verify Copy Right is displayed on home page
	@Test
	public void TC24_VerifyCopyRightElementVisibility() {
		ExtentTest test = extent.createTest("Verify Copy Right Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isSubscriptionTextBoxDisplayed()) {
					test.pass("Copy Right is visible on home page");
				}
				else {
					test.fail("Copy Right is  not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Verify Copy Right  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC25. To verify apply code is displayed on home page
	@Test
	public void TC25_VerifyApplyCodeElementVisibility() {
		ExtentTest test = extent.createTest("Verify apply code Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isSubscriptionTextBoxDisplayed()) {
					test.pass("apply code is visible on home page");
				}
				else {
					test.fail("apply code is  not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "apply code  Visibility fails"));
				}
			}
			else {
				test.fail("Home page is not opened").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Fails to open home page"));
			}
		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC26. To verify Subscription Arrow is displayed on home page
	@Test
	public void TC26_VerifySubscriptionArrowElementVisibility() {
		ExtentTest test = extent.createTest("Verify Subscription Arrow Element visibility");
		try {
			if(homepage.isHomeHedaingDisplayed()) {
				test.pass("Clicked on home page");
				test.pass("Home page is opened");

				if(homepage.isSubscriptionTextBoxDisplayed()) {
					test.pass("Subscription Arrow is visible on home page");
				}
				else {
					test.fail("Subscription Arrow is  not visible on home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Subscription Arrow  Visibility fails"));
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
>>>>>>> bfd624d6f67bc365de35f9d0fa5a381abc8c9718
