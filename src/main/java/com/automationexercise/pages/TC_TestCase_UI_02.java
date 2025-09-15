package com.automationexcercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_TestCase_UI_02 {

    WebDriver driver;

    public TC_TestCase_UI_02(WebDriver driver) {
        this.driver = driver;
    }

    By allTestCases = By.xpath("//*[@id=\"form\"]/div");
    By feedbackSection = By.id("feedback");
    By feedbackLink = By.id("feedback-link");
    By upArrow = By.cssSelector(".scroll-top");
    By subscriptionSection = By.id("subscription");
    By subscriptionInput = By.id("susbscribe_email");
    By subscriptionSideArrow = By.xpath("//*[@id=\"subscribe\"]");
    By copyrightText = By.xpath("//*[@id=\"footer\"]/div[2]/div/div");
    By tcheading=By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b");
    By testCasesButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    public void clickTestCasesButton() {
    	driver.findElement(testCasesButton).click();
    }
    public boolean isTestCasesPageHeadingDisplayed() {
    	return driver.findElement(tcheading).isDisplayed();
    }

    public boolean areAllTestCasesClickable() {
        try {
            for(WebElement tc : driver.findElements(allTestCases)) {
                if(!tc.isEnabled()) return false;
            }
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isNumberOfTestCasesCorrect() {
        try {
            int count = driver.findElements(allTestCases).size();
            return count > 0;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isTestCaseInfoAvailable() {
        try {
            WebElement firstTC = driver.findElements(allTestCases).get(0);
            firstTC.click();
            return driver.findElement(By.cssSelector(".test-case-info")).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isFeedbackSectionVisible() {
        try {
            return driver.findElement(feedbackSection).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isFeedbackLinkVisible() {
        try {
            return driver.findElement(feedbackLink).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isUpArrowWorking() {
        try {
            driver.findElement(upArrow).click();
            Thread.sleep(500);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isSubscriptionSectionVisible() {
        try {
            return driver.findElement(subscriptionSection).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public boolean enterSubscriptionMail(String email) {
        try {
            WebElement input = driver.findElement(subscriptionInput);
            input.clear();
            input.sendKeys(email);
            driver.findElement(subscriptionSideArrow).click();
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isSideArrowWorking() {
        try {
            driver.findElement(subscriptionSideArrow).click();
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isCopyrightVisible() {
        try {
            return driver.findElement(copyrightText).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }
}
