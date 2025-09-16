package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_Cart_UI_01 {

    WebDriver driver;

    public TC_Cart_UI_01(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By logo = By.xpath("//*[@id=\\\"header\\\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By productsIcon = By.cssSelector("a[href='/products']");
    By cartIcon = By.cssSelector("a[href='/view_cart']");
    By signupLoginIcon = By.cssSelector("a[href='/login']");
    By testCasesIcon = By.cssSelector("a[href='/test_cases']");
    By apiTestingIcon = By.cssSelector("a[href='/api_list']");
    By videoTutorialsIcon = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[7]/a");
    By contactUsIcon = By.cssSelector("a[href='/contact_us']");
    By emptyCartMessage = By.xpath("//*[@id=\"empty_cart\"]/p");
    By clickHereLink = By.cssSelector("a[href='/products']");
    By subscriptionSection = By.xpath("//*[@id=\"footer\"]/div[1]/div/div");
    By emailInput = By.id("susbscribe_email"); // check actual id
    By submitButton = By.id("subscribe"); // check actual id
    By footerSection = By.cssSelector("footer");
    By socialMediaIcons = By.cssSelector(".social-icons a");
    By cartbutton=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    By cartheading=By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]");
    By clickhere=By.xpath("//*[@id=\"empty_cart\"]/p/a/u");
    public boolean clickherebtndisplayed() {
    	return driver.findElement(clickhere).isDisplayed();
    }
    public void clickcartbtn() {
    	driver.findElement(cartbutton).click();
    }
    public boolean isCartPageheadingDisplayed() {
    	return driver.findElement(cartheading).isDisplayed();
    }
    public boolean isLogoVisible() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean isProductsIconVisible() {
        return driver.findElement(productsIcon).isDisplayed();
    }

    public boolean isCartIconVisible() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    public boolean isSignupLoginIconVisible() {
        return driver.findElement(signupLoginIcon).isDisplayed();
    }

    public boolean isTestCasesIconVisible() {
        return driver.findElement(testCasesIcon).isDisplayed();
    }

    public boolean isAPITestingIconVisible() {
        return driver.findElement(apiTestingIcon).isDisplayed();
    }

    public boolean isVideoTutorialsIconVisible() {
        return driver.findElement(videoTutorialsIcon).isDisplayed();
    }

    public boolean isContactUsIconVisible() {
        return driver.findElement(contactUsIcon).isDisplayed();
    }

    public boolean isEmptyCartMessageVisible() {
        return driver.findElement(emptyCartMessage).isDisplayed();
    }

    public boolean isClickHereLinkVisible() {
        return driver.findElement(clickHereLink).isDisplayed();
    }

    public boolean isSubscriptionSectionVisible() {
        return driver.findElement(subscriptionSection).isDisplayed();
    }

    public boolean isEmailInputVisible() {
        return driver.findElement(emailInput).isDisplayed();
    }

    public boolean isSubmitButtonVisible() {
        return driver.findElement(submitButton).isDisplayed();
    }

    public boolean isFooterSectionVisible() {
        return driver.findElement(footerSection).isDisplayed();
    }

    public boolean areSocialMediaIconsVisible() {
        return driver.findElements(socialMediaIcons).size() > 0;
    }
}
