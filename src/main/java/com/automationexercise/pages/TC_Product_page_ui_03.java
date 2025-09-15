package com.automationexcercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TC_Product_page_ui_03 {
    WebDriver driver;
    By productsbutton=By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a");
    By addToCartIcon = By.xpath("//a[@data-product-id='1']");  
    By viewProductButton = By.xpath("//a[contains(text(),'View Product')]");
    By subscriptionSection = By.xpath("//div[@class='single-widget']//h2[contains(text(),'Subscription')]");
    By subscriptionEmailBox = By.xpath("//*[@id=\"susbscribe_email\"]");
    By subscriptionButton = By.id("subscribe");
    By subscriptionSuccess = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");
    By subscriptionError = By.xpath("//div[contains(text(),'Invalid email address!')]");
    By copyright = By.xpath("//*[@id=\"footer\"]/div[2]/div/div/p");
    By topArrow = By.cssSelector("#scrollUp");
    By productpageheading=By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    By productlogo=By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    By firstproduct=By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div");
     public boolean issubscribebuttonDisplayed() {
		
		return driver.findElement(subscriptionButton).isDisplayed();
	}
    public boolean isproductslogodisplayed() {
    	return driver.findElement(productlogo).isDisplayed();
    }
    public boolean firstproductvisible() {
		
		return driver.findElement(firstproduct).isDisplayed();
	}
    public boolean isproductspageheadingdisplayed() {
    	return driver.findElement(productpageheading).isDisplayed();
    }
    public void clickproductsbutton() {
    	driver.findElement(productsbutton).click();
    }

    public TC_Product_page_ui_03(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAddToCartIconDisplayed() {
        return driver.findElement(addToCartIcon).isDisplayed();
    }

    public boolean isViewProductButtonDisplayed() {
        return driver.findElement(viewProductButton).isDisplayed();
    }

    public boolean isSubscriptionDisplayed() {
        return driver.findElement(subscriptionSection).isDisplayed();
    }

    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionEmailBox).clear();
        driver.findElement(subscriptionEmailBox).sendKeys(email);
        driver.findElement(subscriptionButton).click();
    }

    public boolean isSubscriptionSuccess() {
        return driver.findElement(subscriptionSuccess).isDisplayed();
    }

    public boolean isSubscriptionError() {
        return driver.findElement(subscriptionError).isDisplayed();
    }

    public boolean isCopyrightDisplayed() {
        return driver.findElement(copyright).isDisplayed();
    }

    public boolean isTopArrowDisplayed() throws InterruptedException {
    	Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("alert('Hello')");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
         return driver.findElement(topArrow).isDisplayed();
    }
}
