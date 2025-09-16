package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TC_Product_page_ui_01 {
    WebDriver driver;

    
    By logo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    By homeButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    By productsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    By cartButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    By signupLoginButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By testCasesButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By apiTestingButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]/a");
    By videoTutorialsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[7]/a");
    By contactUsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    By productpageheading=By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    By productlogo=By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    public boolean isproductslogodisplayed() {
    	return driver.findElement(productlogo).isDisplayed();
    }
    public boolean isproductspageheadingdisplayed() {
    	return driver.findElement(productpageheading).isDisplayed();
    }
    public void clickproductbtn() {
    	driver.findElement(productsButton).click();
    }

    public TC_Product_page_ui_01(WebDriver driver) {
        this.driver = driver;
    }

    // Validation methods (return true if element is displayed)
    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean isHomeDisplayed() {
        return driver.findElement(homeButton).isDisplayed();
    }

    public boolean isProductsDisplayed() {
        return driver.findElement(productsButton).isDisplayed();
    }

    public boolean isCartDisplayed() {
        return driver.findElement(cartButton).isDisplayed();
    }

    public boolean isSignupLoginDisplayed() {
        return driver.findElement(signupLoginButton).isDisplayed();
    }

    public boolean isTestCasesDisplayed() {
        return driver.findElement(testCasesButton).isDisplayed();
    }

    public boolean isApiTestingDisplayed() {
        return driver.findElement(apiTestingButton).isDisplayed();
    }

    public boolean isVideoTutorialsDisplayed() {
        return driver.findElement(videoTutorialsButton).isDisplayed();
    }

    public boolean isContactUsDisplayed() {
        return driver.findElement(contactUsButton).isDisplayed();
    }
 
    public boolean isVerticalScrollBarPresent() {
        driver.findElement(By.xpath("//a[@href='/products']")).click(); // open Products page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Long) js.executeScript("return document.body.scrollHeight;") >
               (Long) js.executeScript("return window.innerHeight;");
    }

}

