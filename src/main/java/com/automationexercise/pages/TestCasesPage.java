package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    WebDriver driver;

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ XPaths for elements
    private By logo = By.xpath("//div[@class='logo pull-left']/a/img");
    private By homeButton = By.xpath("//a[text()=' Home']");
    private By productsButton = By.xpath("//a[text()=' Products']");
    private By cartButton = By.xpath("//a[text()=' Cart']");
    private By signupLoginButton = By.xpath("//a[text()=' Signup / Login']");
    private By testCasesButton = By.xpath("//a[text()=' Test Cases']");
    private By footer = By.xpath("//footer[@id='footer']");
    private By recommendedItems = By.xpath("//h2[text()='recommended items']");
    private By subscriptionSection = By.xpath("//h2[text()='Subscription']");
    private By contactUsButton = By.xpath("//a[text()=' Contact us']");
    private By scrollUpButton = By.xpath("//a[@id='scrollUp']");

    // ✅ Methods to check visibility
    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean isHomeButtonDisplayed() {
        return driver.findElement(homeButton).isDisplayed();
    }

    public boolean isProductsButtonDisplayed() {
        return driver.findElement(productsButton).isDisplayed();
    }

    public boolean isCartButtonDisplayed() {
        return driver.findElement(cartButton).isDisplayed();
    }

    public boolean isSignupLoginButtonDisplayed() {
        return driver.findElement(signupLoginButton).isDisplayed();
    }

    public boolean isTestCasesButtonDisplayed() {
        return driver.findElement(testCasesButton).isDisplayed();
    }

    public boolean isFooterDisplayed() {
        return driver.findElement(footer).isDisplayed();
    }

    public boolean isRecommendedItemsDisplayed() {
        return driver.findElement(recommendedItems).isDisplayed();
    }

    public boolean isSubscriptionSectionDisplayed() {
        return driver.findElement(subscriptionSection).isDisplayed();
    }

    public boolean isContactUsButtonDisplayed() {
        return driver.findElement(contactUsButton).isDisplayed();
    }

    public boolean isScrollUpButtonDisplayed() {
        return driver.findElement(scrollUpButton).isDisplayed();
    }
}