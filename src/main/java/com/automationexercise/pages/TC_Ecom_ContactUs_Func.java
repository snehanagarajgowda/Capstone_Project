package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_Ecom_ContactUs_Func {
	WebDriver driver;
	public TC_Ecom_ContactUs_Func(WebDriver driver) {
		this.driver=driver;	
	}
	//Locators
	
	By btn_ContactUs = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
	By name = By.name("name");
	By email = By.name("email");
	By subject = By.name("subject");
	By message = By.name("message");
	By uploadFile = By.name("upload_file");
	By btn_Submit = By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input");
	By successMessage = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");
	By btn_HomeButton = By.xpath("//*[@id=\"form-section\"]/a/span");
	By contactText = By.xpath("//*[@id=\"contact-page\"]/div[1]/div/div/h2");
	By homeheadingText = By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h1/span");


// Methods for Contact us page
	
	public boolean isHomePageTextDisplayed() {
		return driver.findElement(homeheadingText).isDisplayed();
	}
	
	public boolean isContactUsDisplayed() {
		return driver.findElement(contactText).isDisplayed();
	}



	public void clickContactUs() {
		driver.findElement(btn_ContactUs).click();
	}
	public WebElement enterName() {
	    return driver.findElement(name);
	}

	public void enterName(String username) {
		driver.findElement(name).clear();
		driver.findElement(name).sendKeys(username);
        
    }

	public WebElement enterEmail() {
		return driver.findElement(email);
	}
	
	  public void enterEmail(String useremail) {
		  driver.findElement(email).clear();
			driver.findElement(email).sendKeys(useremail);
	    }
	  


	public WebElement enterSubject() {
		return driver.findElement(subject);
	}
	
	public void enterSubject(String sub) {
		driver.findElement(subject).clear();
		driver.findElement(subject).sendKeys(sub);
        
    }
	public WebElement enterMessage() {
		return driver.findElement(message);
	}
	public void enterMessage(String messagetxt) {
		driver.findElement(message).clear();
		driver.findElement(message).sendKeys(messagetxt);
    }

	public void uploadFile(String filePath) {
		driver.findElement(uploadFile).sendKeys(filePath);
	}

	public void clickSubmit() {
		 WebElement submitBtn = driver.findElement(btn_Submit);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
		    submitBtn.click();
		}
	public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }
	
	public void clickHomeButton() {
		driver.findElement(btn_HomeButton).click();
	}
}


