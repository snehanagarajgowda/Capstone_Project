package com.automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Ecom_Login_Func {
	
	WebDriver driver;
	public TC_Ecom_Login_Func(WebDriver driver){
		this.driver=driver;
	}
	// Locators 
	
	By loginPageButton=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	public By txt_email=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
	public By txt_password=By.name("password");
	By loggedInText = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
	By btn_login = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
	By loginError = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
	By logoutButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	By LoginMSG = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");
	By LoggedInAsUsername = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
	By homeHeading = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");
	
	
	//Methods
	
	public boolean isHomeHeadingDisplayed() {
		return driver.findElement(homeHeading).isDisplayed();
	}

	public boolean LoggedinUserNameDisplayed() {
		return driver.findElement(LoggedInAsUsername).isDisplayed();	
	}
	public WebElement VerifyMSG() {
		return driver.findElement(LoginMSG);
	}
	
	public void clickonLoginPage() {
		driver.findElement(loginPageButton).click();
	}
	
	public void enteremail(String email) {
		driver.findElement(txt_email).clear();
		driver.findElement(txt_email).sendKeys(email);
	}
	
	public void enterpassword(String password)
	{
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickLogin()
	{
		driver.findElement(btn_login).click();
	}
	
	public  boolean LoggedIntxt() {
		return driver.findElement(loggedInText).isDisplayed();
	}
	
	public Boolean loginError() {
		return driver.findElement(loginError).isDisplayed();
	}
	
	public void clickLogout()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
		 //driver.findElement(logoutButton).click();
	}
	
	public boolean isPasswordMasked() {
        return driver.findElement(txt_password).getAttribute("type").equals("password");
    }
	
	public String getEmailPlaceholder() {
        return driver.findElement(txt_email).getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return driver.findElement(txt_password).getAttribute("placeholder");
    }
    
    public void pressTabFromEmail() {
        driver.findElement(txt_email).sendKeys(Keys.TAB);
    }

    public WebElement getFocusedElement() {
        return driver.switchTo().activeElement();
    }	
    public boolean LoginErrorMSGDisplayed() {
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
    		By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")));
    		return errorMsg.isDisplayed();
    	} catch (TimeoutException e) {
    		return false;
    	}
    }

}