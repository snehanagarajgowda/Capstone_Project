package com.automationexercise.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Ecom_Homepage {
	WebDriver driver;
	public TC_Ecom_Homepage(WebDriver driver) {
		this.driver = driver;
	}

	By homeLogo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
	By homeButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
	By homeHeading = By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h2");
	By productHeading = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
	By cartHeading = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
	By login_signupHeading = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	By testCases = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
	By apiHeading = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]/a");
	By vedioTutorialsHeading = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[7]/a");
	By contactusHeading = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
	By APIListPractice = By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/a[2]/button");
	By category = By.xpath("/html/body/section[2]/div/div/div[1]/div/h2");
	By featureItem = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/h2");
	By viewItem = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a");
	By brand = By.xpath("/html/body/section[2]/div/div/div[1]/div/div[3]/h2");
	By women = By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a");
	By men = By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a");
	By kids = By.xpath("//*[@id=\"accordian\"]/div[3]/div[1]/h4/a");
	By recommendedItems = By.xpath("/html/body/section[2]/div/div/div[2]/div[2]/h2");
	By backArrow = By.xpath("//*[@id=\"recommended-item-carousel\"]/a[1]/i");
	By forwardArrow = By.xpath("//*[@id=\"recommended-item-carousel\"]/a[2]/i");
	By addToCart = By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[1]/div/div/div/a");
	By subscription = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
	By subscriptionTextBox = By.xpath("//*[@id=\"susbscribe_email\"]");
	By copyRight = By.xpath("//*[@id=\"footer\"]/div[2]/div/div/p");
	By applyCode = By.xpath("//*[@id=\"noir-leaderboard\"]/div/div[1]/div[1]/div/a");
	By subscriptionArrow = By.xpath("//*[@id=\"subscribe\"]");
			
	
	
	
	public boolean isLogoDisplayed() {
		return driver.findElement(homeLogo).isDisplayed();
	}
	public boolean isHomeHedaingDisplayed() {
		return driver.findElement(homeHeading).isDisplayed();
}
	public void clickHomeButton() {
		 driver.findElement(homeButton).click();
}
	public boolean isHomeDisplayed() {
		return driver.findElement(homeButton).isDisplayed();
	}
	public boolean isProductDisplayed() {
		return driver.findElement(productHeading).isDisplayed();
	}
	public boolean isCartDisplayed() {
		return driver.findElement(cartHeading).isDisplayed();
	}
	public boolean isSignup_LoginDisplayed() {
		return driver.findElement(login_signupHeading).isDisplayed();
	}
	public boolean isTestCasesDisplayed() {
		return driver.findElement(testCases).isDisplayed();
	}
	public boolean isAPITestingDisplayed() {
		return driver.findElement(apiHeading).isDisplayed();
	}
	public boolean isVedioTutorialsDisplayed() {
		return driver.findElement(vedioTutorialsHeading).isDisplayed();
	}
	public boolean isContactusDisplayed() {
		return driver.findElement(contactusHeading).isDisplayed();
	}
	public boolean isAPIListPracticeDisplayed() {
		return driver.findElement(APIListPractice).isDisplayed();
	}
	public boolean isCategoryDisplayed() {
		return driver.findElement(category).isDisplayed();
	}
	public boolean isFeatureItemDisplayed() {
		return driver.findElement(featureItem).isDisplayed();
	}
	public boolean isViewItemDisplayed() {
		return driver.findElement(viewItem).isDisplayed();
	}
	public boolean isBrandDisplayed() {
		return driver.findElement(brand).isDisplayed();
	}
	public boolean isWomenDisplayed() {
		return driver.findElement(women).isDisplayed();
	}
	public boolean isMenDisplayed() {
		return driver.findElement(men).isDisplayed();
	}
	public boolean isKidsDisplayed() {
		return driver.findElement(kids).isDisplayed();
	}
	public boolean isRecommendedItemDisplayed() {
		return driver.findElement(recommendedItems).isDisplayed();
	}
	public boolean isBackArrowDisplayed() {
		return driver.findElement(backArrow).isDisplayed();
	}
	public boolean isForwardArrowDisplayed() {
		return driver.findElement(forwardArrow).isDisplayed();
	}
	public boolean isAddToCartDisplayed() {
		return driver.findElement(addToCart).isDisplayed();
	}
	public boolean isSubscriptionDisplayed() {
		return driver.findElement(subscription).isDisplayed();
	}
	public boolean isSubscriptionTextBoxDisplayed() {
		return driver.findElement(subscriptionTextBox).isDisplayed();
	}
	public boolean isCopyRightDisplayed() {
		return driver.findElement(copyRight).isDisplayed();
	}
	public boolean isApplyCodeDisplayed() {
		return driver.findElement(applyCode).isDisplayed();
	}
	public boolean isSubscriptionArrowDisplayed() {
		return driver.findElement(subscriptionArrow).isDisplayed();
	}
}