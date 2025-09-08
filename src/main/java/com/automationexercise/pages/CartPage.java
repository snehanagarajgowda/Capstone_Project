package com.automationexercise.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ---------- Logo ----------
    public boolean isLogoVisible() {
        return waitVisible(By.xpath("//div[@class='logo pull-left']")).isDisplayed();
    }

    // ---------- Header Icons ----------
    public boolean isProductsIconVisible() {
        return waitVisible(By.xpath("//a[text()=' Products']")).isDisplayed();
    }

    public boolean isCartIconVisible() {
        return waitVisible(By.xpath("//a[text()=' Cart']")).isDisplayed();
    }

    public boolean isSignupLoginIconVisible() {
        return waitVisible(By.xpath("//a[text()=' Signup / Login']")).isDisplayed();
    }

    public boolean isTestCasesIconVisible() {
        return waitVisible(By.xpath("//a[text()=' Test Cases']")).isDisplayed();
    }

    public boolean isApiTestingIconVisible() {
        return waitVisible(By.xpath("//a[text()=' API Testing']")).isDisplayed();
    }

    public boolean isVideoTutorialsIconVisible() {
        return waitVisible(By.xpath("//a[text()=' Video Tutorials']")).isDisplayed();
    }

    public boolean isContactUsIconVisible() {
        return waitVisible(By.xpath("//a[text()=' Contact us']")).isDisplayed();
    }

    // ---------- Empty Cart ----------
    public boolean isEmptyCartMessageVisible() {
        return waitVisible(By.xpath("//b[text()='Cart is empty!']")).isDisplayed();
    }

    public boolean isClickHereLinkWorking() {
        WebElement link = waitVisible(By.xpath("//a/u[text()='Click Here']"));
        link.click();
        return driver.getCurrentUrl().contains("products");
    }

    // ---------- Subscription ----------
    public boolean isSubscriptionSectionVisible() {
        return waitVisible(By.xpath("//h2[text()='Subscription']")).isDisplayed();
    }

    public boolean isSubscriptionEmailBoxVisible() {
        return waitVisible(By.id("susbscribe_email")).isDisplayed();
    }

    public boolean isSubscriptionButtonClickable() {
        WebElement btn = waitVisible(By.id("subscribe"));
        return btn.isDisplayed() && btn.isEnabled();
    }

    // ---------- Footer ----------
    public boolean isFooterVisible() {
        return waitVisible(By.tagName("footer")).isDisplayed();
    }

    // ---------- Promo Banner ----------
    public boolean isPromoBannerVisible() {
        return waitVisible(By.xpath("//section[@id='advertisement']")).isDisplayed();
    }

    // ---------- Scroll to Top ----------
    public boolean isScrollUpVisibleAfterScroll() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        return waitVisible(By.xpath("//a[@id='scrollUp']")).isDisplayed();
    }

    public boolean clickScrollUpAndVerify() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        WebElement up = waitVisible(By.xpath("//a[@id='scrollUp']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", up);
        return wait.until(d -> {
            Long y = (Long) ((JavascriptExecutor) d).executeScript("return Math.round(window.pageYOffset);");
            return y != null && y == 0;
        });
    }

    // ---------- Responsive Design ----------
    public boolean checkMobileResponsive() {
        driver.manage().window().setSize(new Dimension(390, 844)); // iPhone 12 size
        boolean mobileMenu = waitVisible(By.cssSelector("button.navbar-toggler")).isDisplayed();
        driver.manage().window().maximize(); // reset
        return mobileMenu;
    }
}