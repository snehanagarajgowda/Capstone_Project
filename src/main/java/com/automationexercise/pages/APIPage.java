package com.automationexercise.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class APIPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // ---------- Locators (robust to small UI changes) ----------
    private final By logoDiv = By.xpath("//div[contains(@class,'logo')]");
    private final By logoImg = By.xpath("//header//img[contains(@alt,'automation') or contains(@alt,'practice')]");
    public final By homeBtn = By.xpath("//a[normalize-space()='Home' or normalize-space()=' Home']");
    public final By productsBtn = By.xpath("//a[normalize-space()='Products' or normalize-space()=' Products']");
    public final By cartBtn = By.xpath("//a[normalize-space()='Cart' or normalize-space()=' Cart']");
    public final By signupLoginBtn = By.xpath("//a[normalize-space()='Signup / Login' or normalize-space()=' Signup / Login']");
    public final By testCasesBtn = By.xpath("//a[normalize-space()='Test Cases' or normalize-space()=' Test Cases']");
    public final By apiTestingBtn = By.xpath("//a[normalize-space()='API Testing' or normalize-space()=' API Testing']");
    public final By videoTutorialsBtn = By.xpath("//a[normalize-space()='Video Tutorials' or normalize-space()=' Video Tutorials']");
    public final By contactUsBtn = By.xpath("//a[normalize-space()='Contact us' or normalize-space()=' Contact us']");

    private final By apiListHeading = By.xpath("//*[self::h1 or self::h2][contains(normalize-space(), 'APIs List for practice')]");
    // top list: anchor items like “API 1: …” that link to a hash (NOT the endpoint links)
    private final By apiItems = By.xpath("//a[starts-with(normalize-space(),'API ') and contains(normalize-space(),':') and not(starts-with(@href,'http'))]");
    // details anywhere on page (already visible even before click)
    private final By anyApiUrlLine = By.xpath("//*[contains(normalize-space(),'API URL:')]");
    private final By anyEndpointLink = By.xpath("//a[starts-with(@href,'https://automationexercise.com/api/')]");

    private final By feedbackHeading = By.xpath("//*[self::h2 or self::h3 or self::h4][contains(normalize-space(),'Feedback for Us')]");
    private final By feedbackMailLink = By.xpath("//a[starts-with(@href,'mailto:')]");
    public final By scrollUpArrow = By.id("scrollUp");

    private final By subscriptionHeading = By.xpath("//h2[normalize-space()='Subscription']");
    public final By subscriptionEmail = By.id("susbscribe_email");
    public final By subscribeBtn = By.id("subscribe");
    // success or error banners
    public final By subscriptionBanner = By.cssSelector("#success-subscribe, .alert-success, .alert-danger, .error_message");

    private final By copyright = By.xpath("//*[contains(normalize-space(),'Copyright')]");

    public APIPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    // ---------- Helpers ----------
    public WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isDisplayed(By locator) {
        try { return waitVisible(locator).isDisplayed(); }
        catch (TimeoutException e) { return false; }
    }

    // ---------- Header & Logo ----------
    public boolean isLogoVisible() {
        // accept either the wrapper div or the img
        try { return isDisplayed(logoDiv) || isDisplayed(logoImg); }
        catch (Exception e) { return false; }
    }

    // ---------- Page characteristics ----------
    public boolean isScrollbarPresent() {
        Long scrollHeight = (Long) ((JavascriptExecutor) driver).executeScript("return Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);");
        Long clientHeight = (Long) ((JavascriptExecutor) driver).executeScript("return Math.max(document.body.clientHeight, document.documentElement.clientHeight);");
        return scrollHeight != null && clientHeight != null && scrollHeight > clientHeight + 50;
    }

    public String getApiListHeadingColor() {
        return waitVisible(apiListHeading).getCssValue("color");
    }

    // ---------- APIs ----------
    public int getAPICount() {
        return driver.findElements(apiItems).size();
    }

    public boolean areApisListed() {
        return getAPICount() > 0;
    }

    public boolean clickFirstApiAndSeeDetails() {
        List<WebElement> list = driver.findElements(apiItems);
        if (list.isEmpty()) return false;

        WebElement first = list.get(0);
        // use JS click to avoid overlay issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", first);

        // Details are always on the page; verify we can see URL/endpoint lines
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(anyApiUrlLine),
                    ExpectedConditions.visibilityOfElementLocated(anyEndpointLink)
            ));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // ---------- Feedback ----------
    public boolean isFeedbackVisible() { return isDisplayed(feedbackHeading); }
    public boolean isFeedbackLinkVisible() { return isDisplayed(feedbackMailLink); }

    // ---------- Scroll Up ----------
    public boolean makeScrollUpVisible() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        return isDisplayed(scrollUpArrow);
    }

    // ---------- Subscription ----------
    public boolean isSubscriptionVisible() { return isDisplayed(subscriptionHeading); }

    public void subscribe(String email) {
        WebElement box = waitVisible(subscriptionEmail);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", box);
        box.clear();
        box.sendKeys(email);
        waitVisible(subscribeBtn).click();
    }

    public String getSubscriptionMessage() {
        try {
            WebElement banner = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionBanner));
            return banner.getText().trim();
        } catch (TimeoutException e) {
            return "";
        }
    }

    // ---------- Footer ----------
    public boolean isCopyrightDisplayed() { return isDisplayed(copyright); }
}