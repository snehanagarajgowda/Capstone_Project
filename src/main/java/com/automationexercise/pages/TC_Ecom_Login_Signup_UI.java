package com.automationexercise.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Ecom_Login_Signup_UI {
	WebDriver driver;
	public TC_Ecom_Login_Signup_UI(WebDriver driver) {
		this.driver=driver;

	}
	

	
	By loginSignupButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	By loginpageLogo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
	By loginText = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");
	By loginEmail = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
	By loginPassword = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
	By loginButton = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
	
	By Or = By.xpath("//*[@id=\"form\"]/div/div/div[2]/h2");
	
	
	By signupEmail = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
	By signupName = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
	By signupButton = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
	By signupText = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
	
	By homeIcon = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
	By productIcon = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
	By cartIcon = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
	By signupIcon = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	By testCasesIcon = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
	By ApiTestingIcon = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]/a");
	By videoTutorials = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[7]/a");
	By contactUs = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
	
	By subscriptionText = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
	By subscriptionEmail = By.xpath("//*[@id=\"susbscribe_email\"]");
	By paragraphText = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/form/p");
	By arrowButton = By.xpath("//*[@id=\"subscribe\"]/i");
	By copyRight = By.xpath("//*[@id=\"footer\"]/div[2]/div/div/p");
	
	//Methods
	
	public void clickLoginSignupButton() {
		driver.findElement(loginSignupButton).click();
	}
	public boolean isLogoDisplayed() {
		return driver.findElement(loginpageLogo).isDisplayed();
	}
	public boolean isLoginTextDisplayed() {
		return driver.findElement(loginText).isDisplayed();
	}
	public boolean isLoginEmailDisplayed() {
		return driver.findElement(loginEmail).isDisplayed();
	}
	public boolean isLoginPasswordDisplayed() {
		return driver.findElement(loginPassword).isDisplayed();
	}
	public boolean isLoginButtonDisplayed() {
		return driver.findElement(loginButton).isDisplayed();
	}
	public boolean isORDisplayed() {
		return driver.findElement(Or).isDisplayed();
	}
	public boolean isSignupEmailDisplayed() {
		return driver.findElement(signupEmail).isDisplayed();
	}
	public boolean isSignupNameDisplayed() {
		return driver.findElement(signupName).isDisplayed();
	}
	public boolean isSignupButtonDisplayed() {
		return driver.findElement(signupButton).isDisplayed();
	}
	public boolean isSignupTextDisplayed() {
		return driver.findElement(signupText).isDisplayed();
	}
	public boolean isHomeIconDisplayed() {
		return driver.findElement(homeIcon).isDisplayed();
	}
	public boolean isProductIconDisplayed() {
		return driver.findElement(productIcon).isDisplayed();
	}
	public boolean isCartIconDisplayed() {
		return driver.findElement(cartIcon).isDisplayed();
	}
	public boolean isSignupLoginIconDisplayed() {
		return driver.findElement(cartIcon).isDisplayed();
	}
	public boolean isTestCasesIconDisplayed() {
		return driver.findElement(testCasesIcon).isDisplayed();
	}
	public boolean isAPITestingIconDisplayed() {
		return driver.findElement(ApiTestingIcon).isDisplayed();
	}
	public boolean isVideoTutorialsIconDisplayed() {
		return driver.findElement(videoTutorials).isDisplayed();
	}
	public boolean isContactUsIconDisplayed() {
		return driver.findElement(contactUs).isDisplayed();
	}
	public boolean isSubscriptionTextDisplayed() {
		return driver.findElement(subscriptionText).isDisplayed();
	}
	public boolean isSubscriptionEmailDisplayed() {
		return driver.findElement(subscriptionEmail).isDisplayed();
	}
	public boolean isParagraphTextDisplayed() {
		return driver.findElement(paragraphText).isDisplayed();
	}
	public boolean isArrowButtonDisplayed() {
		return driver.findElement(arrowButton).isDisplayed();
	}
	public boolean isCopyRightTextDisplayed() {
		return driver.findElement(copyRight).isDisplayed();
	}
	public String getEmailPlaceholder() {
	    return driver.findElement(By.xpath("//input[@data-qa='login-email']")).getAttribute("placeholder");
	}

	public String getPasswordPlaceholder() {
	    return driver.findElement(By.xpath("//input[@data-qa='login-password']")).getAttribute("placeholder");
	}
	public WebElement getEmailField() {
	    return driver.findElement(loginEmail);
	}
	public WebElement getPasswordField() {
	    return driver.findElement(loginPassword);
	}
	public WebElement getSignupLink() {
	    return driver.findElement(loginSignupButton);
	}
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	
}


	