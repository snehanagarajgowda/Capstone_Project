package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LOGIN_SIGNUP_PAGE {
	
	WebDriver driver;
	public LOGIN_SIGNUP_PAGE(WebDriver driver){
		this.driver=driver;
	}
	
	By loginPageButton=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	public By txt_email=By.name("email");
	public By txt_password=By.name("password");
	By loggedInText = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
	By btn_login = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
	By loginError = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
	By logoutButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	By LoginMSG = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");
	By LoggedInAsUsername = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
	
	public boolean LoginErrorMSG() {
		 return driver.findElement(loginError).getText().contains("Your email or password is incorrect!");
	}
	
	
	public boolean LoggedinasUsername() {
		return driver.findElement(LoggedInAsUsername).getText().contains("Logged in as Rohith Kumar");
	}

	public WebElement VerifyMSG() {
		return driver.findElement(LoginMSG);
	}
	
	public void clickonLoginPage() {
		driver.findElement(loginPageButton).click();
	}
	
	public void enteremail(String email) {
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
		 driver.findElement(logoutButton).click();
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
	
	


	
	
}