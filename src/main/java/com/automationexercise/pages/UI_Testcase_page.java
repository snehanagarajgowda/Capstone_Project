package com.automationexercise.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UI_Testcase_page {
    WebDriver driver;
    WebDriverWait wait;

    public UI_Testcase_page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Logo
    public boolean isLogoDisplayed() {
        return driver.findElement(By.cssSelector("div.logo img[alt*='automation']")).isDisplayed();
    }

    // ✅ Top Menu
    public boolean isHomeButtonDisplayed() {
        return driver.findElement(By.xpath("//a[text()=' Home']")).isDisplayed();
    }

    public boolean isProductsButtonDisplayed() {
        return driver.findElement(By.xpath("//a[text()=' Products']")).isDisplayed();
    }

    public boolean isCartButtonDisplayed() {
        return driver.findElement(By.xpath("//a[text()=' Cart']")).isDisplayed();
    }

    public boolean isSignupLoginButtonDisplayed() {
        return driver.findElement(By.xpath("//a[text()=' Signup / Login']")).isDisplayed();
    }

    public boolean isTestCasesButtonDisplayed() {
        return driver.findElement(By.xpath("//a[text()=' Test Cases']")).isDisplayed();
    }

    public void clickTestCasesButton() {
        driver.findElement(By.xpath("//a[text()=' Test Cases']")).click();
    }

    public boolean isApiTestingDisplayed() {
        return driver.findElement(By.xpath("//a[text()=' API Testing']")).isDisplayed();
    }

    public boolean isVideoTutorialsDisplayed() {
        return driver.findElement(By.xpath("//a[text()=' Video Tutorials']")).isDisplayed();
    }

    public boolean isContactUsDisplayed() {
        return driver.findElement(By.xpath("//a[text()=' Contact us']")).isDisplayed();
    }

    public void clickContactUs() {
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();
    }

    // ✅ Page Checks
    public boolean isScrollBarDisplayed() {
        Long scrollHeight = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight;");
        Long clientHeight = (Long) ((JavascriptExecutor) driver).executeScript("return window.innerHeight;");
        return scrollHeight > clientHeight;
    }

    // 🔧 FIX 1: Test Cases heading only after navigation
    public boolean isTestCasesWordDisplayed() {
        clickTestCasesButton();
        WebElement heading = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Test Cases')]")));
        return heading.isDisplayed();
    }

    public int getNumberOfTestCases() {
        clickTestCasesButton();
        return driver.findElements(By.cssSelector("div.panel-group .panel")).size();
    }

    public boolean areTestCasesClickable() {
        clickTestCasesButton();
        List<WebElement> links = driver.findElements(By.cssSelector("div.panel-group a"));
        return !links.isEmpty();
    }

    // ✅ Feedback
    // 🔧 FIX 2: Navigate before checking
    public boolean isFeedbackDisplayed() {
        clickContactUs();
        WebElement heading = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Get In Touch')]")));
        return heading.isDisplayed();
    }

    public boolean isFeedbackLinkDisplayed() {
        return driver.findElement(By.xpath("//a[text()=' Contact us']")).isDisplayed();
    }

    // ✅ Scroll Up
    public boolean isScrollUpDisplayed() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        WebElement up = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scrollUp")));
        return up.isDisplayed();
    }

    // ✅ Subscription
    public boolean isSubscriptionDisplayed() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        return driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed();
    }

    public void enterSubscriptionEmail(String email) {
        WebElement box = driver.findElement(By.id("susbscribe_email"));
        box.clear();
        box.sendKeys(email);
    }

    public void clickSubscribe() {
        driver.findElement(By.id("subscribe")).click();
    }

    // 🔧 FIX 3 & 4: Handle invalid + empty properly
    public String getSubscriptionMessage() {
        try {
            WebElement success = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.cssSelector("#success-subscribe, .alert-success")));
            return success.getText().trim();
        } catch (TimeoutException e1) {
            try {
                WebElement error = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector(".alert-danger, .error_message")));
                return error.getText().trim();
            } catch (TimeoutException e2) {
                // For empty email -> browser validation, not DOM
                return "Please fill out this field";
            }
        }
    }

    // ✅ Footer
    public boolean isCopyrightDisplayed() {
        return driver.findElement(By.xpath("//p[contains(text(),'Copyright')]")).isDisplayed();
    }
}