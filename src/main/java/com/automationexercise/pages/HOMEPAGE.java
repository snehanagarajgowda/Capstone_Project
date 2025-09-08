
package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HOMEPAGE {
	WebDriver driver;
	public HOMEPAGE(WebDriver driver) {
		this.driver = driver;
	}

	By category = By.xpath("/html/body/section[2]/div/div/div[1]/div/h2");
	
	public WebElement category() {
		return driver.findElement(category);
	}
}
