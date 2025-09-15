package com.automationexercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_Ecom_CartPage_UI {
    WebDriver driver;
    WebDriverWait wait;

    public TC_Ecom_CartPage_UI(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By cartButton = By.xpath("//a[@href='/view_cart']");
    private By productsLink = By.xpath("//a[@href='/products']");
    private By addToCartButton = By.xpath("//a[contains(text(),'Add to cart')]");
    private By viewCartButton = By.xpath("//u[contains(text(),'View Cart')]");
    private By productName = By.xpath("//tr[@id='product-1']//td[@class='cart_description']/h4/a");
    private By productQuantityInput = By.xpath("//tr[@id='product-1']//input[@type='text']");
    private By removeButton = By.xpath("//tr[@id='product-1']//a[@class='cart_quantity_delete']");
    private By subscriptionInput = By.id("susbscribe_email");
    private By subscriptionArrow = By.id("subscribe");
    private By proceedToCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private By totalPrice = By.xpath("//tr[@id='product-1']//td[@class='cart_total']/p");

    // ---------------- Page actions ----------------

    public void clickCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }

    public void clickProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(productsLink)).click();
    }

    public boolean isProductsLinkDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(productsLink)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
    }

    public void addMultipleProductsToCart(int numberOfProducts) {
        for (int i = 1; i <= numberOfProducts; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
            if (i < numberOfProducts) driver.navigate().back();
        }
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
    }

    public boolean isProductDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateProductQuantity(String quantity) {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityInput));
            input.clear();
            input.sendKeys(quantity);
            // Trigger change event using JS to update cart
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'))", input);
            Thread.sleep(1000); // wait for update
            return driver.findElement(productQuantityInput).getAttribute("value").equals(quantity);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeProduct() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
            Thread.sleep(1000); // wait for removal
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean subscribe(String email) {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionInput));
            input.clear();
            input.sendKeys(email);
            driver.findElement(subscriptionArrow).click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSubscriptionInputDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionInput)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollToSubscription() {
        scrollToElement(subscriptionInput);
    }

    public boolean clickProceedToCheckout() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();
            Thread.sleep(1000); // wait for redirect
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTotalPriceDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
