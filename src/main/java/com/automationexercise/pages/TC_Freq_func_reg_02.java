package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_Freq_func_reg_02 {

    WebDriver driver;

    public TC_Freq_func_reg_02(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.id("search_product");
    By searchButton = By.id("submit_search");
    By cartProductsIcon = By.xpath("//a[contains(text(),'Products')]");
    By cartIcon = By.xpath("//a[contains(text(),'Cart')]");
    By cartLoginIcon = By.xpath("//a[contains(text(),'Signup / Login')]");
    By cartTestCasesIcon = By.xpath("//a[contains(text(),'Test Cases')]");
    By cartApiTestingIcon = By.xpath("//a[contains(text(),'API Testing')]");
    By cartVideoTutorialsIcon = By.xpath("//a[contains(text(),'Video Tutorials')]");
    By cartContactUsIcon = By.xpath("//a[contains(text(),'Contact us')]");

    // Locators for Products Page
    By productsCopyright = By.xpath("//p[contains(text(),'All rights reserved')]");
    By productsTopArrow = By.id("scrollUp");
    By productsLogo = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a/i");
    By productsHomeBtn = By.xpath("//a[contains(text(),'Home')]");
    By productsBtn = By.xpath("//a[contains(text(),'Products')]");
    By productsCartBtn = By.xpath("//a[contains(text(),'Cart')]");
    By productsLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By productsTestCasesBtn = By.xpath("//a[contains(text(),'Test Cases')]");
    By productsApiTestingBtn = By.xpath("//a[contains(text(),'API Testing')]");
    By productsVideoTutorialsBtn = By.xpath("//a[contains(text(),'Video Tutorials')]");
    By clickProductsBtn = By.xpath("//a[contains(text(),'Products')]");
    By addtocart=By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a");
    By clickViewCartBtn = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    By findproduct=By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]");
    By proceedtocheckout=By.xpath("//*[@id=\"do_action\"]/div[1]/div/div");
    public boolean isproceedtochecoutDisplayed() {
    	return driver.findElement(proceedtocheckout).isDisplayed();
    }

    public void enterSearchText(String text) {
        WebElement input = driver.findElement(searchBox);
        input.clear();
        input.sendKeys(text);
    }
    public void clickaddtocart() {
    	driver.findElement(addtocart).click();
    }
    public boolean firstfindproduct() {
    	return driver.findElement(findproduct).isDisplayed();
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }


    public boolean isSearchBoxDisplayed() {
        return driver.findElement(searchBox).isDisplayed();
    }
    public boolean isCartProductsIconDisplayed() { 
    	return driver.findElement(cartProductsIcon).isDisplayed(); 
    	}
    public boolean isCartIconDisplayed() { 
    	return driver.findElement(cartIcon).isDisplayed(); 
    	}
    public boolean isCartLoginIconDisplayed() { 
    	return driver.findElement(cartLoginIcon).isDisplayed(); 
    	}
    public boolean isCartTestCasesIconDisplayed() { 
    	return driver.findElement(cartTestCasesIcon).isDisplayed(); 
    	}
    public boolean isCartApiTestingIconDisplayed() { 
    	return driver.findElement(cartApiTestingIcon).isDisplayed(); 
    	}
    public boolean isCartVideoTutorialsIconDisplayed() { 
    	return driver.findElement(cartVideoTutorialsIcon).isDisplayed(); 
    	}
    public boolean isCartContactUsIconDisplayed() { 
    	return driver.findElement(cartContactUsIcon).isDisplayed(); 
    	}

    public boolean isProductsCopyrightDisplayed() { 
    	return driver.findElement(productsCopyright).isDisplayed(); 
    	}
    public boolean isProductsTopArrowDisplayed() throws InterruptedException { 
    	Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("alert('Hello')");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
    	return driver.findElement(productsTopArrow).isDisplayed(); 
    	}

    public void clickProductsBtn() { 
    	driver.findElement(clickProductsBtn).click(); 
    	}
    public boolean isViewCartBtnDisplayed() { 
    	return driver.findElement(clickViewCartBtn).isDisplayed();
    	}
    public void clickViewCartBtn() {
    	driver.findElement(clickViewCartBtn).click();
    }

    public boolean isProductsLogoDisplayed() { 
    	return driver.findElement(productsLogo).isDisplayed(); 
    	}
    public boolean isProductsHomeBtnDisplayed() { 
    	return driver.findElement(productsHomeBtn).isDisplayed(); 
    	}
    public boolean isProductsBtnDisplayed() { 
    	return driver.findElement(productsBtn).isDisplayed(); 
    	}
    public boolean isProductsCartBtnDisplayed() { 
    	return driver.findElement(productsCartBtn).isDisplayed(); 
    	}
    public boolean isProductsLoginBtnDisplayed() { 
    	return driver.findElement(productsLoginBtn).isDisplayed(); 
    	}
    public boolean isProductsTestCasesBtnDisplayed() { 
    	return driver.findElement(productsTestCasesBtn).isDisplayed(); 
    	}
    public boolean isProductsApiTestingBtnDisplayed() { 
    	return driver.findElement(productsApiTestingBtn).isDisplayed(); 
    	}
    public boolean isProductsVideoTutorialsBtnDisplayed() { 
    	return driver.findElement(productsVideoTutorialsBtn).isDisplayed(); 
    	}
}