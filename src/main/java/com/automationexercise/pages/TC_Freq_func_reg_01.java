package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC_Freq_func_reg_01 {

    WebDriver driver;

    public TC_Freq_func_reg_01(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By apiHomeBtn = By.xpath("//a[contains(text(),'Home')]");
    By apiProductsBtn = By.xpath("//a[contains(text(),'Products')]");
    By apiCartBtn = By.xpath("//a[contains(text(),'Cart')]");
    By apiLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By apiContactBtn = By.xpath("//a[contains(text(),'Contact us')]");
    By recommendedItems = By.xpath("//div[@class='recommended_items']");
    By homeBtn = By.xpath("//a[contains(text(),'Home')]");
    By productsBtn = By.xpath("//a[contains(text(),'Products')]");
    By cartBtn = By.xpath("//a[contains(text(),'Cart')]");
    By loginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By testCasesBtn = By.xpath("//a[contains(text(),'Test Cases')]");
    By apiTestingBtn = By.xpath("//a[contains(text(),'API Testing')]");
    By videoTutorialsBtn = By.xpath("//a[contains(text(),'Video Tutorials')]");
    By contactHomeBtn = By.xpath("//a[contains(text(),'Contact us')]");
    By subscriptionSection = By.xpath("//h2[contains(text(),'Subscription')]");

    
    public boolean isApiHomeBtnDisplayed() { 
    	return driver.findElement(apiHomeBtn).isDisplayed(); 
    	}
    public boolean isApiProductsBtnDisplayed() { 
    	return driver.findElement(apiProductsBtn).isDisplayed(); 
    	}
    public boolean isApiCartBtnDisplayed() { 
    	return driver.findElement(apiCartBtn).isDisplayed(); 
    	}
    public boolean isApiLoginBtnDisplayed() { 
    	return driver.findElement(apiLoginBtn).isDisplayed(); 
    	}
    public boolean isApiContactBtnDisplayed() { 
    	return driver.findElement(apiContactBtn).isDisplayed(); 
    	}
    public boolean isRecommendedItemsDisplayed() { 
    	return driver.findElement(recommendedItems).isDisplayed(); 
    	}
    public boolean isHomeBtnDisplayed() { 
    	return driver.findElement(homeBtn).isDisplayed(); 
    	}
    public boolean isProductsBtnDisplayed() { 
    	return driver.findElement(productsBtn).isDisplayed(); 
    	}
    public boolean isCartBtnDisplayed() { 
    	return driver.findElement(cartBtn).isDisplayed(); 
    	}
    public boolean isLoginBtnDisplayed() { 
    	return driver.findElement(loginBtn).isDisplayed(); 
    	}
    public boolean isTestCasesBtnDisplayed() { 
    	return driver.findElement(testCasesBtn).isDisplayed(); 
    	}
    public boolean isApiTestingBtnDisplayed() { 
    	return driver.findElement(apiTestingBtn).isDisplayed(); 
    	}
    public boolean isVideoTutorialsBtnDisplayed() { 
    	return driver.findElement(videoTutorialsBtn).isDisplayed(); 
    	}
    public boolean isContactHomeBtnDisplayed() {  
    	return driver.findElement(contactHomeBtn).isDisplayed(); 
    	}
    public boolean isSubscriptionDisplayed() { 
    	return driver.findElement(subscriptionSection).isDisplayed(); 
    	}
}