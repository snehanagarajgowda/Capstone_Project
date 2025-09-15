package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC_TestCase_UI_01 {

    WebDriver driver;

    public TC_TestCase_UI_01(WebDriver driver) {
        this.driver = driver;
    }

    By logo = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By homeButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    By productsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    By cartButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    By signupLoginButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By testCasesButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By apiTestingButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]/a");
    By videoTutorialsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[7]/a");
    By contactUsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    By scrollBar = By.xpath("body"); 
    By allTestCases = By.xpath("//*[@id=\"form\"]/div");
    By tcheading=By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b");
    public void clickTestCasesButton() {
    	driver.findElement(testCasesButton).click();
    }
    public boolean isTestCasesPageHeadingDisplayed() {
    	return driver.findElement(tcheading).isDisplayed();
    }
    public boolean isLogoVisible() {
        try {
            return driver.findElement(logo).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isHomeButtonVisible() {
        try {
            return driver.findElement(homeButton).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isProductsButtonVisible() {
        try {
            return driver.findElement(productsButton).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isCartButtonVisible() {
        try {
            return driver.findElement(cartButton).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isSignupLoginButtonVisible() {
        try {
            return driver.findElement(signupLoginButton).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isTestCasesButtonVisible() {
        try {
            return driver.findElement(testCasesButton).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isAPITestingButtonVisible() {
        try {
            return driver.findElement(apiTestingButton).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isVideoTutorialsButtonVisible() {
        try {
            return driver.findElement(videoTutorialsButton).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isContactUsButtonVisible() {
        try {
            return driver.findElement(contactUsButton).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isScrollBarVisible() {
        try {
            return driver.findElement(scrollBar).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isTestCasesWordVisible() {
        try {
            return driver.findElement(tcheading).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean areAllTestCasesDisplayed() {
        try {
            return driver.findElements(allTestCases).size() > 0;
        } catch(Exception e) {
            return false;
        }
    }
}
