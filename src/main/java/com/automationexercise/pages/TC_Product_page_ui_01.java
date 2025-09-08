package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC_Product_page_ui_01 {
    WebDriver driver;

    
    By logo = By.xpath("//img[@alt='Website for automation practice']");
    By homeButton = By.xpath("//a[contains(text(),'Home')]");
    By productsButton = By.xpath("//a[contains(text(),'Products')]");
    By cartButton = By.xpath("//a[contains(text(),'Cart')]");
    By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    By testCasesButton = By.xpath("//a[contains(text(),'Test Cases')]");
    By apiTestingButton = By.xpath("//a[contains(text(),'API Testing')]");
    By videoTutorialsButton = By.xpath("//a[contains(text(),'Video Tutorials')]");
    By contactUsButton = By.xpath("//a[contains(text(),'Contact us')]");

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
        Long scrollHeight = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return document.body.scrollHeight;");
        Long clientHeight = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return window.innerHeight;");
        return scrollHeight > clientHeight;
    }
}

