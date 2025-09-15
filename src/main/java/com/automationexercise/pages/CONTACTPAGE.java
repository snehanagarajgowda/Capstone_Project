package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CONTACTPAGE {
	WebDriver driver;
	public CONTACTPAGE(WebDriver driver) {
		this.driver=driver;	
	}
	
	By btn_ContactUs = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
	By name = By.name("name");
	By email = By.name("email");
	By subject = By.name("subject");
	By message = By.name("message");
	By uploadFile = By.name("upload_file");
	By btn_Submit = By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input");
	By successMessage = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");
	By btn_HomeButton = By.xpath("//*[@id=\"form-section\"]/a/span");


	public void clickContactUs() {
		driver.findElement(btn_ContactUs).click();
	}

	public WebElement enterName() {
		return driver.findElement(name);	
	}
	public void enterName(String name) {
        WebElement nameField = enterName();
        nameField.clear();
        nameField.sendKeys(name);
    }

	public WebElement enterEmail() {
		return driver.findElement(email);
	}
	
	  public void enterEmail(String email) {
	        WebElement emailField = enterEmail();
	        emailField.clear();
	        emailField.sendKeys(email);
	    }
	 
	public WebElement enterSubject() {
		return driver.findElement(subject);
	}
	
	public void enterSubject(String sub) {
        WebElement subjectField = enterSubject();
        subjectField.clear();
        subjectField.sendKeys(sub);
    }
	public WebElement enterMessage() {
		return driver.findElement(message);
	}
	public void enterMessage(String message) {
        WebElement messageField = enterMessage();
        messageField.clear();
        messageField.sendKeys(message);
    }

	public void uploadFile(String filePath) {
		driver.findElement(uploadFile).sendKeys(filePath);
	}

	public void clickSubmit() {
		driver.findElement(btn_Submit).click();
	}
	public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }
	
	public void clickHomeButton() {
		driver.findElement(btn_HomeButton).click();
	}

}


