package com.automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Ecom_Contactus_UI {
	WebDriver driver;
	public TC_Ecom_Contactus_UI(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locators
	By contactUsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
	By contactusText = By.xpath("//*[@id=\"contact-page\"]/div[1]/div/div/h2");
	By logo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
	By getInText = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2");
	By nameInputBox = By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input");
	By emailInputBox = By.xpath("//input[@name='email']");
	By subjectTextBox=By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input");
	By yourMessageHereText = By.xpath("//*[@id=\"message\"]");
	By uploadFiles = By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input");
	By submitButton = By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input");
	By subscription = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
	By  subscriptionInputBox = By.xpath("//*[@id=\"susbscribe_email\"]");
	By copyRight = By.xpath("//*[@id=\"footer\"]/div[2]/div/div/p");
	By feedbackForUs = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[2]/div/h2");
	By scrollUp = By.xpath("//*[@id=\"scrollUp\"]");
	By arrow = By.xpath("//*[@id=\"subscribe\"]/i");
	
	
	
	public void clickContactusButton() {
		driver.findElement(contactUsButton).click();
	}
	
	
	public boolean isLogoDisplayed() {
		return driver.findElement(logo).isDisplayed();
	}
	public boolean isGetInTextDisplayed() {
		return driver.findElement(getInText).isDisplayed();
	}
	public boolean isNameInputTextBoxDisplayed() {
		return driver.findElement(nameInputBox).isDisplayed();
	}
	public boolean isEmailInputTextBoxDisplayed() {
		return driver.findElement(emailInputBox).isDisplayed();
	}
	public boolean isSubjectTextBoxDisplayed() {
		return driver.findElement(subjectTextBox).isDisplayed();
	}
	public boolean isyourMSGHereTextDisplayed() {
		return driver.findElement(yourMessageHereText).isDisplayed();
	}
	public boolean isUploadFilesDisplayed() {
		return driver.findElement(uploadFiles).isDisplayed();
	}
	public boolean isSubmitButtonDisplayed() {
		return driver.findElement(submitButton).isDisplayed();
	}
	public boolean isSubscriptionDisplayed() {
		return driver.findElement(subscription).isDisplayed();
	}
	public boolean isSubscriptionInputTextBoxDisplayed() {
		return driver.findElement(subscriptionInputBox).isDisplayed();
	}
	public boolean isCopyRightDisplayed() {
		return driver.findElement(copyRight).isDisplayed();
	}
	public boolean isFeedbackForUsDisplayed() {
		return driver.findElement(feedbackForUs).isDisplayed();
	}
	public boolean isScrollUpDisplayed() {
		return driver.findElement(scrollUp).isDisplayed();
	}
	public boolean isArrowDisplayed() {
		return driver.findElement(arrow).isDisplayed();
	}
	public boolean isNameFieldEditable() {
	    try {
	        WebElement element = driver.findElement(nameInputBox);
	        return element.isDisplayed() && element.isEnabled();
	    } catch (Exception e) {
	        return false;
	    }
	}
	public boolean isEmailFieldEditable() {
	    try {
	        WebElement element = driver.findElement(emailInputBox);
	        return element.isDisplayed() && element.isEnabled();
	    } catch (Exception e) {
	        return false;
	    }
	}
	public boolean isSubjectFieldEditable() {
	    try {
	        WebElement element = driver.findElement(By.name("subject"));
	        element.clear();
	        element.sendKeys("Test Subject");
	        return "Test Subject".equals(element.getAttribute("value"));
	    } catch (Exception e) {
	        return false;
	    }
	}
	public boolean isMessageFieldEditable() {
	    try {
	        WebElement element = driver.findElement(By.name("message"));
	        element.clear();
	        element.sendKeys("Test message content");
	        return "Test message content".equals(element.getAttribute("value"));
	    } catch (Exception e) {
	        return false;
	    }
	}


	
	

	}


