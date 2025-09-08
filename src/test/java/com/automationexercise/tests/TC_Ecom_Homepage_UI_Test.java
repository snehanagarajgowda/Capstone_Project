package com.automationexercise.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Ecom_Homepage_UI;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Homepage_UI_Test extends BaseTest{
	String projectpath=System.getProperty("user.dir");

	//TC01. To verify and validate the E-commerece web application  URL is working on chrome browsers.
	@Test
	public void TC01_NavigateHomepage() {
		ExtentTest test = extent.createTest("Verify url opening homepage on browser");
		driver.get("https://automationexercise.com");
		
		try {
			
			String actualURL = driver.getCurrentUrl();
			String actualTitle = driver.getTitle();
			if (actualURL.equals("https://automationexercise.com/") && actualTitle.equalsIgnoreCase("Automation Exercise")) {
				test.pass("Homepage loaded successfully");
			} else {
				test.fail("Homepage did not load correctly").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Home page loading fails"));
			}

		}catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
		}
	}

	//TC02. To verify and validate the logo of  E-commerece web application home page
	@Test
	public void TC02_verifyLogo() {
		ExtentTest test = extent.createTest("verify Logo");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

		try {
			boolean result = homepage.isLogoDisplayed();
			if(result) {
				test.pass("Logo is displayed in home page");
			}
			else {
				test.fail("Logo is not displayed in home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Home page logo not present"));
			}
		}
		catch(Exception e) {
			test.fail("Exception: " + e.getMessage());
			
		}

		}

	
	//TC04. To verify and validate the E-commerece web application home logo is displayed on home page
		@Test
		public void TC04_verifyHomeButtonlogo() {
			TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
			driver.get("https://automationexercise.com");

			ExtentTest test = extent.createTest("verify Home logo in home page");
			try {
				 if (homepage.isHomeButtonDisplayed()) {
			            test.pass("Home button is displayed on the homepage");
			            homepage.clickHomeButton();
			            test.pass("Home button clicked successfully");
			        } else {
			        	test.fail("Home button is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Home button not present"));
			        }
			}
				 catch(Exception e) {
						test.fail("Exception: " + e.getMessage());
			}
				
			} 
	
	//TC05. To verify and validate the E-commerece web application products button on home page.
	@Test
	public void TC05_verifyProductButton() throws IOException {
		ExtentTest test = extent.createTest("verify products button clickability");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

		try {
			homepage.clickProductButton();
			test.pass("Product button clicked successfully");
		}
			 catch(Exception e) {
					test.fail("Product button is not clicked").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Product button not clicked"));;
		}
			
		} 
	
	//TC06. To verify and validate the E-commerece web application Cart button on home page.
	@Test
	public void TC06_verifyCartButton() throws IOException {
		ExtentTest test = extent.createTest("verify cart button clickability");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

		try {
			homepage.clickCartButton();
			test.pass("Cart button clicked successfully");
		}
			 catch(Exception e) {
					test.fail("Cart button is not clicked").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Cart button not clicked"));;
		}
			
		} 
	//TC07. To verify and validate the  E-commerece web application Signup/login button on home page.
	@Test
	public void TC07_verifyLogin_SignUpButton() throws IOException {
		ExtentTest test = extent.createTest("verify signup/login button clickability");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

		try {
			homepage.clickLoginSignup();
			test.pass("Login_Signup button clicked successfully");
		}
			 catch(Exception e) {
					test.fail("Login_Signup button is not clicked").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Login_Signup button not clicked"));;
		}
			
		} 
	
	
	//TC09. To verify and validate the E-commerece web application API Testing button on home page.
	@Test
	public void TC09_verifyAPITesting() throws IOException {
		ExtentTest test = extent.createTest("verify API testing button clickability");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

		try {
			homepage.clickAPITesting();
			test.pass("API Testing button clicked successfully");
		}
			 catch(Exception e) {
					test.fail("API Testing  button is not clicked").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "API Testing button not clicked"));
		}
			
		} 
	
	//TC.10 To verify and validate the  E-commerece web application Vedio Tutorials button on home page.
	@Test
	public void TC10_verifyVideoTutorials() throws IOException {
		ExtentTest test = extent.createTest("verify and validate vedio tutorials button clickability");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

		try {
			homepage.clickVideoTutorials();
			test.pass("Vedio Tutorials button clicked successfully");
		}
			 catch(Exception e) {
					test.fail("Vedio Tutorials  button is not clicked").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Vedio Tutorials button not clicked"));;
		}
			
		} 
	//TC11. To verify and validate the functionality of  E-commerece web application Contact Us button on home page.
	@Test
	public void TC11_verifyContactUs() throws IOException {
		ExtentTest test = extent.createTest("verify and validate Contact Us button clickability");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

		try {
			homepage.clickContactUs();
			test.pass("Contact Us button clicked successfully");
		}
			 catch(Exception e) {
					test.fail("Contact Us button is not clicked").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Contact Us button not clicked"));;
		}
			
		} 
	
	//TC08 To verify and validate the  E-commerece web application Test cases button on home page.
	@Test
	public void TC08_verifyTestCases() throws IOException {
		ExtentTest test = extent.createTest("verify Test cases button clickability");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

		try {
			homepage.clickTestCases();
			test.pass("Test Cases button clicked successfully");
		}
			 catch(Exception e) {
					test.fail("Test Cases button is not clicked").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Test Cases button not clicked"));;
		}
			
		} 
	//TC13. To verify and validate the  E-commerece web application APIs list for product on home page.
	@Test
	public void TC13_verifyAPIListProduct() throws IOException {
		ExtentTest test = extent.createTest("To verify and validate the  E-commerece web application APIs list for product on home page.");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

		try {
			homepage.clickAPITestPractice();
			test.pass("Clicked successfully on api test practice");
		}
		catch(Exception e) {
			test.fail("API test practice is not clicked").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "API test practice is not clicked"));;
}
	} 
	
	//TC14. To verify and validate the  E-commerece web application Category(Ex: Women,men,kids) on home page.
	@Test
	public void TC14_verifyCategories() throws IOException {
	    ExtentTest test = extent.createTest("Verify Categories on Homepage");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

	    try{
	    	String[] categories = {"Women", "Men", "Kids"};
	    	for (String categoryName : categories) {
	            homepage.clickCategory(categoryName);
	            test.pass("Clicked successfully on category: " + categoryName);
	    	}

	    } catch (Exception e) {
	        test.fail("Category verification failed: " + e.getMessage()).addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Category verification failed"));
	    }
	}  
	
	//TC15. To verify and validate the  E-commerece web application Brands name(Ex: H&M) on home page.
	@Test
	public void TC15_verifyBrands() throws IOException {
	    ExtentTest test = extent.createTest("Verify brands on Homepage");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

	    try {
	    	String[] brands = {"H&M", "Polo", "MADAME"};

	        for (String brandName : brands) {
	            homepage.clickBrand(brandName); 
	            test.pass("Clicked successfully on brand: " + brandName);
	        }
	 } catch (Exception e) {
	        test.fail("Brand verification failed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Brand verification failed"));
	    } 
	} 
	
	//TC16. To verify and validate the  E-commerece web application Feature items on home page.
	@Test
	public void TC16_verifyandClickFeaturedItems() throws IOException {
	    ExtentTest test = extent.createTest("Verify and Click Featured Items on Homepage");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

	    try {
	        for (int i = 1; i <= 3; i++) {
	            homepage.clickFeaturedItem(i);
	            test.pass("Clicked  on featured item index: " + i);
	        }
	    } catch (Exception e) {
	        test.fail("Featured item verification failed: " + e.getMessage()).addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "click on feature item failed"));
	    }
	} 
	//TC17. To verify and validate the  E-commerece web application Add to cart icon is visible on home page.
	@Test
	public void TC17_verifyAddCartVisible() {
	    ExtentTest test = extent.createTest("Verify add to cart is visible on home page");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

	    try {
	    	homepage.ClickOnViewProduct();
	    	WebElement result = homepage.ClickOnAddCart();
	    	if(result.getText().contains("Availability:")) {
	    		test.pass("Add to cart is displayed");
	    	}
	    	else {
	    		test.fail("Add to cart is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Failed to add cart"));
	    	}
	    } catch(Exception e) {
	    	test.fail("Exception: " + e.getMessage());
	    }
	    	
	    } 
	//TC18. To verify and validate the  E-commerece web application Cost under product is displayed on home page.
	@Test
	public void TC18_verifycostproductisVisible() {
	    ExtentTest test = extent.createTest("Verify cost of product visible on home page");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

	    try {
	    	homepage.ClickOnViewProduct();
	    	WebElement result = homepage.ClickOnAddCart();
	    	if(result.getText().contains("Availability:")) {
	    		test.pass("Product cost is displayed");
	    	}
	    	else {
	    		test.fail("Product cost is not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Product is not displayed"));
	    	}
	    } catch(Exception e) {
	    	test.fail("Exception: " + e.getMessage());
	    }
	    	
	    } 
	
	//TC19. To verify and validate the  E-commerece web application view  product is displayed under product on home page.
	@Test
	public void TC19_verifyViewItemVisible() {
	    ExtentTest test = extent.createTest("Verify view item is visible on home page");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

	    try {
	    	WebElement result = homepage.ViewProductVisible();
	    	if(result.getText().contains("View Product")) {
	    		test.pass("View product is visible");
	    	}
	    	else {
	    		test.fail("view item is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "view product is not visible"));
	    	}
	    } catch(Exception e) {
	    	test.fail("Exception: " + e.getMessage());
	    }
	    	
	    } 
	//TC20. To verify and validate the  E-commerece web application by clicking on view products that re directs to detailed product view on home page.
	@Test
	public void TC20_verifyViewProductRedirects() {
	    ExtentTest test = extent.createTest("Verify clicking on View Product redirects to product detail page");
		TC_Ecom_Homepage_UI homepage = new TC_Ecom_Homepage_UI(driver);
		driver.get("https://automationexercise.com");

	    try {
	    	 homepage.clickFeaturedItemByName(); 
	         String expectedUrl = "https://automationexercise.com/product_details/1"; // example
	         String actualUrl = driver.getCurrentUrl();
	         if(actualUrl.equals(expectedUrl)) {
	             test.pass("Successfully redirected to product detail page");
	         } else {
	             test.fail("Redirection failed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "ViewProductRedirectFail"));
	         }
	     } catch(Exception e) {
	         test.fail("Exception: " + e.getMessage());
	     }
	 
	    } 
	
	
}
	
	



		
