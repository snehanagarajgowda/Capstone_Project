package com.automationexercise.tests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.LOGIN_SIGNUP_PAGE;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Ecom_Functional_Login extends BaseTest {
		String projectpath=System.getProperty("user.dir");
		
		
	// TC01. Verify Home Page URL
	    @Test
	    public void Tc_ecom_login_01() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate that the user can navigate to the URL: 'http://automationexercise.com'");
			
			driver.get("https://automationexercise.com");
			
	        String expectedURL = "https://automationexercise.com/";
	        String actualURL = driver.getCurrentUrl();
	        if(actualURL.equals(expectedURL)) {
	        	test.pass("TC01 Passed: URL navigates to the home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Homepage"));
	        }
	        else {
	        	test.fail("TC01 Failed: Url is not navigated to home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Homepage fail"));
	        }
	    }
	    
	    //TC02. To Verify and validate user can log out successfully
	    @Test
	    public void Tc_ecom_login_02() throws IOException {
			ExtentTest test=extent.createTest("To Verify and validate user can log out successfully");
			
			LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
			driver.get("https://automationexercise.com");
			
			login.clickonLoginPage();
			
			login.enteremail("viratkohli814722@gmail.com");
			
			login.enterpassword("rohithkumar90942@");
			
			login.clickLogin();
			
			login.clickLogout();
			
			WebElement verifyLogout = login.VerifyMSG();
			
			if(verifyLogout.getText().contains("Login to your account")) {
				System.out.println("User able to Logout");
				test.pass("User able to Logout").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_02 Pass"));
			}
	  }
			
	  //TC03. To Verify and validate redirection to login page after logout
	    @Test
	    public void Tc_ecom_login_03() throws IOException {
			ExtentTest test=extent.createTest("To Verify and validate redirection to login page after logout");
			
			LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
			driver.get("https://automationexercise.com");
			
			login.clickonLoginPage();
			
			login.enteremail("viratkohli814722@gmail.com");
			
			login.enterpassword("rohithkumar90942@");
			
			login.clickLogin();
			
			login.clickLogout();
			
			WebElement verifyLogout = login.VerifyMSG();
			
			if(verifyLogout.getText().contains("Login to your account")) {
				System.out.println("User able to redirection to login page after logout");
				test.pass("User able to redirection to login page after logout").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_03 Pass"));
			}
			else {
				System.out.println("User not able to redirection to login page after logout");
				test.fail("User not able to redirection to login page after logout").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_03 fail"));
			}
	  }
	    
	 
	  //TC04. To verify and validate and validate 'Logged in as username' is visible
	    @Test
	    public void Tc_ecom_login_04() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate and validate 'Logged in as username' is visible");
			
			LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
			driver.get("https://automationexercise.com");
			
			login.clickonLoginPage();
			
			login.enteremail("viratkohli814722@gmail.com");
			
			login.enterpassword("rohithkumar90942@");
			
			login.clickLogin();
			
			if(login.LoggedinasUsername()) {
				test.pass("'Logged in as username' is visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_04 pass"));
			}
			else {
				test.fail("'Logged in as username' is not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_04 fail"));
			}
	    }
	    
	    //TC05. Login with invalid email and invalid password
	    @Test
	    public void Tc_ecom_login_05() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate that the user can enter an incorrect email address and password");

	    	LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
	    	driver.get("https://automationexercise.com");
	    	
	    	login.clickonLoginPage();
	        login.enteremail("sneha@gmail.com");
	        login.enterpassword("Sneha@123");
	        login.clickLogin();
	        if (login.LoginErrorMSG()) {
	        	test.pass("TC04 Passed: Error message displayed for invalid login").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_05 Pass"));
	        } else {
	        	test.fail("TC04 Failed: Error message not displayed for invalid login").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_05 Fail"));
	        }
	 
	    	}
	    
	    //TC06 To verify and validate and validate that the 'Login' button is clickable and initiates login
	    @Test
	    public void Tc_ecom_login_06() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate and validate that the 'Login' button is clickable and initiates login");

	    	LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
	    	driver.get("https://automationexercise.com/");

	        //Click on Signup/Login button
	        login.clickonLoginPage();

	        //Verify "Login to your account" section is visible
	        String msg = login.VerifyMSG().getText();
	        Assert.assertTrue(msg.contains("Login to your account"), "Login section not visible");
	        test.pass("Login section is visible: " + msg).addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_06 Pass"));
	    }
	    
	    
	    //TC07 To verify and validate and validate that the error message 'Your email or password is incorrect!' appears
	    @Test
	    public void Tc_ecom_login_07() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate and validate that the error message 'Your email or password is incorrect!' appears");

	    	LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
	    	driver.get("https://automationexercise.com");
	    	
	    	login.clickonLoginPage();
	        login.enteremail("sneha@gmail.com");
	        login.enterpassword("Sneha@123");
	        login.clickLogin();
	        
	        boolean error = login.LoginErrorMSG();
	        
	        if (error) {
	        	test.pass("TC04 Passed: Error message “Your email or password is incorrect!” displayed for invalid login").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_07 Pass"));
	        } else {
	        	test.fail("TC04 Failed: Error message “Your email or password is incorrect!” not displayed for invalid login").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_07 Fail"));
	        }
	 
	    	}
	    

	    //TC08 To verify and validate that the email field shows validation message when left blank
	    @Test
	    public void Tc_ecom_login_08() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate that the email field shows validation message when left blank");

	    	LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
	    	driver.get("https://automationexercise.com/");
	    	
	    	login.clickonLoginPage();
	        
	    	login.enterpassword("rohithkumar90942@");
	    	String validationMessage = driver.findElement(login.txt_email)
                    .getAttribute("validationMessage");
	    	
	    	// Click Login button to trigger validation
	    	login.clickLogin();
	    	
	    	//Verify validation message is displayed
	    	Assert.assertTrue(validationMessage.length() > 0, "No validation message shown for empty email field");
	    	
	    	test.pass("Validation message displayed for empty email field: " + validationMessage).addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Login_TC08"));
}
	    
	  //TC09 To verify and validate that the password field shows validation message when left blank
	    @Test
	    public void Tc_ecom_login_09() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate that the password field shows validation message when left blank");

	    	LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
	    	driver.get("https://automationexercise.com/");
	    	
	    	login.clickonLoginPage();
	        
	    	login.enteremail("viratkohli814722@gmail.com");
	    	String validationMessage = driver.findElement(login.txt_password)
                    .getAttribute("validationMessage");
	    	
	    	// Click Login button to trigger validation
	    	login.clickLogin();
	    	
	    	//Verify validation message is displayed
	    	Assert.assertTrue(validationMessage.length() > 0, "No validation message shown for empty password field");
	    	
	    	test.pass("Validation message displayed for empty password field: " + validationMessage).addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Login_TC09"));
}

	    //TC10 To verify and validate that the password is masked when entered
	    
	    @Test
	    public void Tc_ecom_login_10() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate that the password is masked when entered");

	        LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);

	        //Navigate to login page
	        driver.get("https://automationexercise.com/");
	        login.clickonLoginPage();

	        //Enter a sample password
	        login.enterpassword("test123");

	        //Verify the password field masks input
	        boolean isMasked = login.isPasswordMasked();

	        // Assertion
	        Assert.assertTrue(isMasked, "❌ Password is not masked");

	        test.pass("✅ Password is masked properly (displayed as dots).").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Login_TC08"));
	    }
	    
 //TC11. Verify after page refresh its stays in same page or redirects to different one
	    
	    @Test
	    public void Tc_ecom_login_11() throws IOException {
			ExtentTest test=extent.createTest("To Verify and validate user can log out successfully");

	    	LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
	    	driver.get("https://automationexercise.com");
	    	
	        login.clickonLoginPage();
	        login.enteremail("snehagowda@gmail.com");   
	        login.enterpassword("Sneha@123");           
	        login.clickLogout();

	        String beforeRefresh = driver.getCurrentUrl();
	        driver.navigate().refresh();
	        String afterRefresh = driver.getCurrentUrl();
	        if (beforeRefresh.equals(afterRefresh)) {
	            test.pass("TC10 Passed: After refresh user stays on the same page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Login_11"));
	        } else {
	            test.fail("TC10 Failed: After refresh user redirects to different page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_11 fail"));
	            }
	        }
	    
	    
	    //TC12. To verify and validate that session ends when the browser is closed
	    
	    @Test
	    public void Tc_ecom_login_12() throws IOException {
	        ExtentTest test = extent.createTest("To verify and validate that session ends when the browser is closed");

	        LOGIN_SIGNUP_PAGE loginPage = new LOGIN_SIGNUP_PAGE(driver);

	        // Step 1: Login
	        driver.get("https://automationexercise.com/");
	        loginPage.clickonLoginPage();
	        loginPage.enteremail("viratkohli814722@gmail.com");
	        loginPage.enterpassword("rohithkumar90942@");
	        loginPage.clickLogin();

	        if (loginPage.LoggedinasUsername()) {
	            test.pass("Successfully logged in");
	        } else {
	            test.fail("Unsuccessful login");
	        }

	        // Step 2: Close the browser
	        driver.quit();

	        // Step 3: Start a new browser session
	        driver = WebDriverManager.chromedriver().create();  // start fresh browser
	        LOGIN_SIGNUP_PAGE loginPage2 = new LOGIN_SIGNUP_PAGE(driver);

	        driver.get("https://automationexercise.com/");
	        loginPage2.clickonLoginPage();

	        // Step 4: Verify session does not persist
	        WebElement btn = loginPage2.VerifyMSG();
	        if (btn.isDisplayed()) {
	            test.pass("Account is logged out").addScreenCaptureFromPath(
	                ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_12_pass"));
	        } else {
	            test.fail("Account is still logged in").addScreenCaptureFromPath(
	                ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_12_fail"));
	        }
	    }

		
	    
	  //TC13 To verify and validate that the user cannot log in with an unregistered email
	    @Test
	    public void Tc_ecom_login_13() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate that the user cannot log in with an unregistered email");

	    	LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
	    	driver.get("https://automationexercise.com");
	    	
	    	login.clickonLoginPage();
	        login.enteremail("sneha@gmail.com");
	        login.enterpassword("Sneha@123");
	        login.clickLogin();
	        if (login.LoginErrorMSG()) {
	        	test.pass("TC04 Passed: Error message “Your email or password is incorrect!” displayed for unregistered email").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_13 Pass"));
	        } else {
	        	test.fail("TC04 Failed: Error message “Your email or password is incorrect!” not displayed for unregistered email").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_13 Fail"));
	        }
	 
	    	}
	    
	  //TC14. To verify and validate that special characters in the email field are handled correctly
	    @Test
	    public void Tc_ecom_login_14() throws IOException {
	        ExtentTest test = extent.createTest("To verify and validate that special characters in the email field are handled correctly");

	        LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
	        driver.get("https://automationexercise.com");

	        //Go to login page
	        login.clickonLoginPage();

	        //Enter invalid email with special characters
	        driver.findElement(login.txt_email).sendKeys("viratkohli814722@@gmail..com");
	        driver.findElement(login.txt_password).sendKeys("rohithkumar90942@");

	        //Try to click login
	        login.clickLogin();

	        //Capture browser’s native validation message
	        String validationMessage = driver.findElement(login.txt_email).getAttribute("validationMessage");

	        if (!validationMessage.isEmpty()) {
	            test.pass("✅ TC16 Passed: Validation error displayed → " + validationMessage)
	                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_14_Pass"));
	        } else {
	            test.fail("❌ TC16 Failed: Validation error was not displayed for invalid email")
	                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_14_Fail"));
	            Assert.fail("Validation error not displayed for invalid email format");
	        }
	    }

	 
	    
	  //TC15. To verify and validate that the login form fields have proper placeholder text
	    @Test
	    public void Tc_ecom_login_15() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate that the login form fields have proper placeholder text");

			LOGIN_SIGNUP_PAGE loginPage = new LOGIN_SIGNUP_PAGE(driver);
	        
	            //Navigate to the website
	            driver.get("https://automationexercise.com/");
	            loginPage.clickonLoginPage();
	            test.info("Navigated to login page");

	            //Get placeholders 
	            String emailPlaceholder = loginPage.getEmailPlaceholder();
	            String passwordPlaceholder = loginPage.getPasswordPlaceholder();

	            //Validate placeholders
	            if (emailPlaceholder.equals("Email Address") && passwordPlaceholder.equals("Password")) {
	                test.pass("✅ Email and Password fields have correct placeholder text").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_15 Pass"));
	            } else {
	                test.fail("❌ Placeholder text is incorrect").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_15 Fail"));
	            }
	    }
	    
	    
	  //TC18. To verify and validate that the login page shows the correct page title in the browser tab
	    @Test
	    public void Tc_ecom_login_18() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate that the login page shows the correct page title in the browser tab");
			
	    	LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
	    	driver.get("https://automationexercise.com");
	    	
	    	login.clickonLoginPage();
	    	
	    	if(driver.getTitle().contains("Automation Exercise - Signup / Login")) {
	    		test.pass("login page shows the correct page title in the browser tab").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_18"));
	    	}
	    }
	    
	    
	  //TC19. To verify and validate that the 'Back' button in the browser navigates correctly
	    @Test
	    public void Tc_ecom_login_19() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate that the 'Back' button in the browser navigates correctly");
			
	    	LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
	    	driver.get("https://automationexercise.com");
	    	
	    	login.clickonLoginPage();
	    	
	    	driver.navigate().back();
	    	test.pass("'Back' button in the browser navigates correctly").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_19 Pass"));
	    }
	    
	    
	  //TC20. To verify and validate that the login form has proper field tab order
	    @Test
	    public void Tc_ecom_login_20() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate that the login form has proper field tab order");
			
	    	LOGIN_SIGNUP_PAGE login = new LOGIN_SIGNUP_PAGE(driver);
	    	driver.get("https://automationexercise.com");
	    	
	    	login.clickonLoginPage();
	    	 //Focus email and press Tab
            driver.findElement(login.txt_email).click();
            login.pressTabFromEmail();

            //Check focus order
            WebElement focused = login.getFocusedElement();
            boolean correctOrder = focused.equals(driver.findElement(login.txt_password));

            if (correctOrder) {
                test.pass("✅ Focus moved from Email → Password on pressing Tab").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_20 Pass"));
            } else {
                test.fail("❌ Focus did NOT move correctly. Current focused element: " + focused.getTagName()).addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_20 Fail"));
            }
	    }
	    
	    
	  //TC21. To verify and validate that error messages disappear after correcting the input

	        @Test
	        public void Tc_ecom_login_21() throws InterruptedException, IOException {
	            LOGIN_SIGNUP_PAGE loginPage = new LOGIN_SIGNUP_PAGE(driver);
	            ExtentTest test = extent.createTest("To verify and validate that error messages disappear after correcting the input");

	                //Navigate to login page
	                driver.get("https://automationexercise.com/");
	                loginPage.clickonLoginPage();

	                //Enter invalid credentials
	                loginPage.enteremail("wrong@example.com");
	                loginPage.enterpassword("wrong123");
	                loginPage.clickLogin();

	                // Verify error message appears
	                if (loginPage.LoginErrorMSG()) {
	                    test.pass("✅ Error message displayed for invalid credentials");
	                } else {
	                    test.fail("❌ Error message NOT displayed for invalid credentials");
	                }

	                //Enter valid credentials
	                loginPage.enteremail("valid@example.com");  
	                loginPage.enterpassword("valid123");        
	                loginPage.clickLogin();

	                // Verify error message disappears
	                Thread.sleep(1000); 
	                boolean errorVisible = false;
	                    errorVisible = loginPage.LoginErrorMSG();


	                if (!errorVisible) {
	                    test.pass("✅ Error message disappeared after valid login input").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_21 Pass"));
	                } else {
	                    test.fail("❌ Error message did NOT disappear after entering valid credentials").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_21 Fail"));
	                }

	            } 
	        

	       //TC. 22 To verify and validate that multiple tabs share the same session
	        @Test
	        public void Tc_ecom_login_22() throws InterruptedException, IOException {
	            ExtentTest test = extent.createTest("To verify and validate that multiple tabs share the same session");
	
	        	
	            LOGIN_SIGNUP_PAGE loginPage = new LOGIN_SIGNUP_PAGE(driver);

	            //Navigate to login page
	            driver.get("https://automationexercise.com/");
	            loginPage.clickonLoginPage();

	            //Login with valid credentials
	            loginPage.enteremail("viratkohli814722@gmail.com");
	            loginPage.enterpassword("rohithkumar90942@");     
	            loginPage.clickLogin();

	            Thread.sleep(1000);

	            //Verify user is logged in on first tab
	            if (loginPage.LoggedinasUsername()) {
	                test.pass("✅ User is logged in on first tab");
	            } else {
	                test.fail("❌ User is not logged in on first tab");
	            }

	            //Open a new tab
	            ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
	            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

	            //Switch to new tab and open site
	            driver.switchTo().window(tabs.get(1));
	            driver.get("https://automationexercise.com/");

	            //Verify user is still logged in
	            if (loginPage.LoggedinasUsername()) {
	                test.pass("✅ User remains logged in on second tab (session shared)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_22 Pass"));
	            } else {
	                test.fail("❌ User is NOT logged in on second tab (session not shared)").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "Tc_ecom_login_22 Fail"));
	            }
	        }
}
	    
	    
	  
	   