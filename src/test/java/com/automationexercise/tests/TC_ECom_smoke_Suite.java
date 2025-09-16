package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.HOMEPAGE;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TC_ECom_smoke_Suite extends BaseTest {
	String projectpath=System.getProperty("user.dir");
	
	
	//TC01
  @Test
  public void Tc_smoke_01() throws IOException {
	   test = extent.createTest("To verify and validate with the url on browser redirecting to automation excerise");

	   HOMEPAGE obj = new HOMEPAGE(driver);
	   
	   driver.get("https://www.automationexercise.com");
		
		WebElement url = obj.category(); 
		//Category xpath to check if category text is present then the URL can be redirected 
		//to Automation Excercise home page.
		
		if(url.getText().contains("CATEGORY")) {
			System.out.println("The URL is redirecting to automation excerise");
			test.pass("The URL is redirecting to automation excerise").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "redirecting to automation excerise"));
		}
		else {
			System.out.println("The URL is not redirecting to automation excerise");
			test.fail("The URL is not redirecting to automation excerise").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "redirecting to automation excerise"));
		}
  }
  
  //TC02
  @Test
  public void Tc_smoke_02() throws IOException { 
		test = extent.createTest("To verify and validate with the login/signup button opening register/login page in ecommerce web application");
		
		driver.get("https://automationexercise.com");
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click(); //clicking on Signup/Login icon
		
		//entering values to the name input field of New Signup User.
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Rohith"); 
		//entering values to the email input field of New Signup User.
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("rohithkumar6360@gmail.com");
		//clicking on Signup button
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
		
		//Checking if the page is redirected to register new User page or not
		WebElement signup = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b"));
		
		if(signup.getText().contains("ENTER ACCOUNT INFORMATION")) {
			System.out.println("The signup button is redirected to New User account/registration page with new Email.");
			test.pass("The signup button is redirected to New User account/registration page with new Email.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "login/signup button"));
		}
		else {
			System.out.println("The signup button is not redirected to New User account/registration page with new Email.");
			test.fail("The signup button is not redirected to New User account/registration page with new Email.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "login/signup button"));
		}		
  }

  
  //TC03
  @Test
  public void Tc_smoke_03() throws IOException {
		ExtentTest test=extent.createTest("To verify that login fails with invalid credentials.");
		
		driver.get("https://automationexercise.com");
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		
		//entering values to the email input field of Login User.
		driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/form/input[2]")).sendKeys("rohithkumar@gmail.com"); 
		//entering values to the password input field of Login User.
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("something@258");
		//clicking on Login button
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
				
		//checking an error message comes if we try to login using invalid credentials
		WebElement login = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
				
		if(login.getText().contains("Your email or password is incorrect!")) {
			System.out.println("The user cannot be able to login with invalid credentials");
			test.pass("The user cannot be able to login with invalid credentials").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "verify that login"));
		}
		else {
			System.out.println("The user can be able to login with invalid credentials");
			test.fail("The user can be able to login with invalid credentials").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "verify that login"));
		}
  }
  
  //TC04
  @Test
  public void Tc_smoke_04() throws IOException { 
		ExtentTest test=extent.createTest("To verify that the user can navigate to the 'Products' page.");
		
		driver.get("https://automationexercise.com");
		
		//navigating to product page
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
	  
		WebElement verify = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2"));
		
		if(verify.getText().contains("ALL PRODUCTS")) {
			System.out.println("User can navigate to product page by clicking on product icon in navigation bar");
			test.pass("User can navigate to product page by clicking on product icon in navigation bar").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "navigate to the 'Products' page"));
		}
		else {
			System.out.println("User cannot be able to navigate to product page by clicking on product icon in navigation bar");
			test.fail("User cannot be able to navigate to product page by clicking on product icon in navigation bar").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "navigate to the 'Products' page"));
		}
  }
  
  //TC05
  @Test
  public void Tc_smoke_05() throws IOException { 
		ExtentTest test=extent.createTest("To verify that the product detail page loads correctly.");
		
		driver.get("https://automationexercise.com");
		
		//navigating to product page
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		
		//cliking on view product details
		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")).click();
		
		//verifying product details page loads correctly or not
		if(driver.getTitle().contains("Automation Exercise - Product Details")) {
			System.out.println("User can load and see product details page by clicking on view product button");
			test.pass("User can load and see product details page by clicking on view product button").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "product detail page"));
		}
		else {
			System.out.println("User cannot be able to load and see product details page by clicking on view product button");
			test.fail("User cannot be able to load and see product details page by clicking on view product button").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "product detail page"));
		}
  }
  
  //TC06
  @Test
  public void Tc_smoke_06() throws IOException {
		ExtentTest test=extent.createTest("To verify the basic product search functionality.");
		
		driver.get("https://automationexercise.com");
		
		//navigating to product page
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		
		//search product names in search bar
		driver.findElement(By.xpath("//*[@id=\"search_product\"]")).sendKeys("Sleeveless Dress");
		
		//click on search
		driver.findElement(By.xpath("//*[@id=\"submit_search\"]")).click();
		
		//
		WebElement check = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div"));
		
		//verifying product details page loads correctly or not
		if(check.isDisplayed()) {
			System.out.println("User can search any product item and search button is functional");
			test.pass("User can search any product item and search button is functional").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "product search functionality"));
		}
		else {
			System.out.println("User can search any product item but search button is NOT functional");
			test.fail("User can search any product item but search button is NOT functional").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "product search functionality"));
		}
  }
  
  //TC07
  @Test
  public void Tc_smoke_07() throws IOException, InterruptedException {
		ExtentTest test=extent.createTest("To verify that a user can add a product to the cart.");
		
		driver.get("https://automationexercise.com");
		
		//navigating to product page
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		
		// Create Actions class object
        Actions actions = new Actions(driver);

        WebElement blueTopProduct = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]"));
		// Perform hover
        Thread.sleep(2000);
        actions.moveToElement(blueTopProduct).perform();
        
		//clicking on add to cart button
		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")).click();
		
		//clicking on view cart button
		driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")).click();
		
		//checking if product item is added to cart or not
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a"));
		
		if(cart.isDisplayed()) {
			System.out.println("User is able to add products to cart and also able to view product in cart page.");
			test.pass("User is able to add products to cart and also able to view product in cart page.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "add a product to the cart"));
		}
		else {
			System.out.println("User is not able to add products to cart and also not able to view product in cart page.");
			test.fail("User is not able to add products to cart and also not able to view product in cart page.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "add a product to the cart"));
		}
  }
  
  //TC08
  @Test
  public void Tc_smoke_08() throws IOException, InterruptedException { 
		ExtentTest test=extent.createTest("To verify the quantity of a product in the cart.");
		
		driver.get("https://automationexercise.com");
		
		//navigating to product page
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		
		// Create Actions class object
        Actions actions = new Actions(driver);

        WebElement product = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]"));
		// Perform hover
        Thread.sleep(2000);
        actions.moveToElement(product).perform();
        
		//clicking on add to cart button
		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")).click();
		
		//clicking on view cart button
		driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")).click();
		
		//checking if product item is added to cart of quantity 1
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button"));
		
		if(cart.isDisplayed()) {
			System.out.println("User is able to add products to cart and also able to view default 1 quantity of added product in cart page.");
			test.pass("User is able to add products to cart and also able to view default 1 quantity of added product in cart page.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "quantity of a product in the cart"));
		}
		else {
			System.out.println("User is able to add products to cart but not able to view default 1 quantity of added product in cart page.");
			test.fail("User is able to add products to cart but not able to view default 1 quantity of added product in cart page.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "quantity of a product in the cart"));
		}
  }
  
  //TC09
  @Test
  public void Tc_smoke_09() throws IOException {
		ExtentTest test=extent.createTest("To verify that a user can remove a product from the cart.");
		
		driver.get("https://automationexercise.com");
		
		//navigating to product page
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		
		// locate product container
		WebElement product = driver.findElement(
		    By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]")
		);

		// hover over the product
		Actions actions = new Actions(driver);
		actions.moveToElement(product).perform();
        
		//clicking on add to cart button
		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a")).click();
		
		//clicking on view cart button
		driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")).click();
		
		//deleting added product to cart
		driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[6]/a/i")).click();
		
		//checking if product item is deleted or not
		WebElement delete = driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a"));

		if(delete.isDisplayed()) {
			System.out.println("User is able to add products to cart and also able to delete added product in cart page.");
			test.pass("User is able to add products to cart and also able to delete added product in cart page.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "remove a product from the cart"));
		}
		else {
			System.out.println("User is not able to add products to cart and also not able to delete added product in cart page.");
			test.fail("User is not able to add products to cart and also not able to delete added product in cart page.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "remove a product from the cart"));
		}
  }
  
  //TC10
  @Test
  public void Tc_smoke_10() throws IOException, InterruptedException { 
		ExtentTest test=extent.createTest("To verify that the user can proceed to checkout.");
		
		driver.get("https://automationexercise.com");
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		
		//entering values to the email input field of Login User.
		driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/form/input[2]")).sendKeys("viratkohli814722@gmail.com"); 
		//entering values to the password input field of Login User.
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("rohithkumar90942@");
		//clicking on Login button
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
		
		//navigating to product page
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		
		// Create Actions class object
        Actions actions = new Actions(driver);

        WebElement blueTopProduct = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]"));
		// Perform hover
        Thread.sleep(2000);
        actions.moveToElement(blueTopProduct).perform();
        
		//clicking on add to cart button
		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")).click();
		
		//clicking on view cart button
		driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")).click();
		
		//checking if product item is added to cart or not
		driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
		
		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[4]/h2"));
		
		if(checkout.getText().contains("Review Your Order")) {
			System.out.println("user can proceed to checkout.");
			test.pass("user can proceed to checkout.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "user can proceed to checkout"));
		}
		else {
			System.out.println("user cannnot proceed to checkout.");
			test.fail("user cannnot proceed to checkout.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "user can proceed to checkout"));
		}
  }
  
  //TC11
  @Test
  public void Tc_smoke_11() throws IOException {
		ExtentTest test=extent.createTest("To verify the email subscription on the homepage.");
		
		driver.get("https://automationexercise.com");
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		
		//entering values to the email input field of Login User.
		driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/form/input[2]")).sendKeys("viratkohli814722@gmail.com"); 
		//entering values to the password input field of Login User.
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("rohithkumar90942@");
		//clicking on Login button
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"susbscribe_email\"]")).sendKeys("rohithkumar90942@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"subscribe\"]")).click();
		
		WebElement successMSG = driver.findElement(By.xpath("//*[@id=\"success-subscribe\"]/div"));
		
		if(successMSG.getText().contains("You have been successfully subscribed!")) {
			System.out.println("User can able to see A success message 'You have been successfully subscribed!'.");
			test.pass("User can able to see A success message 'You have been successfully subscribed!'.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "email subscription on the homepage"));
		}
		else {
			System.out.println("User cannot be able to see A success message 'You have been successfully subscribed!'.");
			test.fail("User cannot be able to see A success message 'You have been successfully subscribed!'.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "email subscription on the homepage"));
		}
  }
  
  //TC12
  @Test
  public void c_smoke_12() throws IOException {
		ExtentTest test=extent.createTest("To verify that the 'Contact Us' form can be submitted.");
		
		driver.get("https://automationexercise.com");
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		
		//entering values to the email input field of Login User.
		driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/form/input[2]")).sendKeys("viratkohli814722@gmail.com"); 
		//entering values to the password input field of Login User.
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("rohithkumar90942@");
		//clicking on Login button
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
		
		//navigating to Contact Us page
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a")).click();
		
		//Entering input fields for contacting
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys("Rohith");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys("rohithkumar90942@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys("New Blue Top is not visible");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input")).click();
		
		//alert accepting
		Alert simpAlert = driver.switchTo().alert();
		simpAlert.accept();
		
		WebElement contactMSG = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
		
		if(contactMSG.getText().contains("Success! Your details have been submitted successfully.")) {
			System.out.println("User can able to contact with respective team.");
			test.pass("User can able to contact with respective team.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "'Contact Us' form"));
		}
		else {
			System.out.println("User cannot be able to contact with respective team.");
			test.fail("User cannot be able to contact with respective team.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "'Contact Us' form"));
		}
  }
  
  //TC13
  @Test
  public void Tc_smoke_13() throws IOException {
		ExtentTest test=extent.createTest("To verify that the 'Test Cases' page is accessible.");
		
		driver.get("https://automationexercise.com");
		
		//navigate to Test cases page
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
		
		WebElement verifyTestCases = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/div/div[1]/h4/a/u"));
		
		if(verifyTestCases.getText().contains("Test Case 1: Register User")) {
			System.out.println("User can able to navigate to Test cases page and able to see set of test cases");
			test.pass("User can able to navigate to Test cases page and able to see set of test cases").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "'Test Cases' page is accessible"));
		}
		else {
			System.out.println("User cannot able to navigate to Test cases page and therefore not able to see set of test cases");
			test.fail("User cannot able to navigate to Test cases page and therefore not able to see set of test cases").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "'Test Cases' page is accessible"));
		}
  }
  
  //TC14
  @Test
  public void Tc_smoke_14() throws IOException {
		ExtentTest test=extent.createTest("To verify the user can log out successfully.");
		
		driver.get("https://automationexercise.com");
		
		//navigate to login/signup page
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		
		//entering values to the email input field of Login User.
		driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/form/input[2]")).sendKeys("viratkohli814722@gmail.com"); 
		//entering values to the password input field of Login User.
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("rohithkumar90942@");
		//clicking on Login button
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
		
		//Clicking on Logout button
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		
		WebElement verifyLogout = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
		
		if(verifyLogout.getText().contains("Login to your account")) {
			System.out.println("User able to Logout");
			test.pass("User able to Logout").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "user can log out"));
		}
		else {
			System.out.println("User not able to Logout");
			test.fail("User not able to Logout").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "user can log out"));
		}
  }
  
  //TC15
  @Test
  public void Tc_smoke_15() throws IOException { 
		ExtentTest test=extent.createTest("To verify that the 'API Testing' page is accessible.");
		
		driver.get("https://automationexercise.com");
		
		//navigate to API Test cases page
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]/a")).click();
		
		WebElement verifyAPITestCases = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/div/div[1]/h4/a/u"));
		
		if(verifyAPITestCases.getText().contains("API 1: Get All Products List")) {
			System.out.println("User can able to navigate to API Test cases page and able to see set of API test cases");
			test.pass("User can able to navigate to API Test cases page and able to see set of API test cases").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "'API Testing' page"));
		}
		else {
			System.out.println("User cannot able to navigate to API Test cases page and therefore not able to see set of API test cases");
			test.fail("User cannot able to navigate to API Test cases page and therefore not able to see set of API test cases").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "'API Testing' page"));
		}
  }

}