package com.automationexercise.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Ecom_APIPage_UI {

    private WebDriver driver;
    private WebDriverWait wait;

    public TC_Ecom_APIPage_UI(WebDriver driver) {
        this.driver = driver;
        // Increase wait timeout to 15 or 20 seconds — helps in slower network or page load delays
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ===== Locators =====
    private By apiTestingButton           = By.linkText("API Testing");
    private By logo                       = By.cssSelector("#header .logo img"); 
    // Adjusted logo path: inspect the logo — often in header with class “logo” etc.
    private By homeButton                 = By.linkText("Home");
    private By productsButton             = By.linkText("Products");
    private By cartButton                 = By.linkText("Cart");
    private By signupLoginButton          = By.linkText("Signup / Login");
    private By testCasesButton            = By.linkText("Test Cases");
    private By apiTestingPageHeaderText   = By.xpath("//h2[contains(normalize-space(),'APIs List for practice')]");
    // Changed to exact header on the APIs page. The site shows “APIs List for practice”. :contentReference[oaicite:3]{index=3}
    private By videoTutorials             = By.linkText("Video Tutorials");
    private By contactUs                  = By.linkText("Contact us");
    private By scrollBar                  = By.tagName("html");
    private By apiTestForPracticeWord     = By.xpath("//h3[contains(normalize-space(),'APIs for practice')]");
    private By allAPIsSection             = By.xpath("//h3[contains(text(),'All APIs')]");
    private By allAPIsList                = By.cssSelector("ul > li");  
    // Might be generic: but narrow if needed (e.g. under a specific section)
    private By feedbackForUs              = By.xpath("//h2[contains(text(),'Feedback For Us')]");
    private By feedbackLink               = By.linkText("Click Here to Give Feedback");
    private By scrollUp                   = By.id("scrollUp");
    private By subscription               = By.xpath("//footer//h2[contains(text(),'Subscription')]");
    private By subscriptionInputBox       = By.id("susbscribe_email");
    private By sideArrow                  = By.cssSelector("#subscribe i");
    private By copyRight                  = By.cssSelector("footer p");

    // ===== Actions =====

    public void clickAPITestingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(apiTestingButton)).click();
    }

    public boolean isAPITestingPageOpened() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(apiTestingPageHeaderText)
            ).isDisplayed();
        } catch (TimeoutException e) {
            System.err.println("[ERROR] Cannot find API Testing page header: " + e.getMessage());
            return false;
        }
    }

    public boolean isLogoDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isHomeButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeButton)).isDisplayed();
    }

    public boolean isProductsButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productsButton)).isDisplayed();
    }

    public boolean isCartButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton)).isDisplayed();
    }

    public boolean isSignupLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(signupLoginButton)).isDisplayed();
    }

    public boolean isTestCasesButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesButton)).isDisplayed();
    }

    public boolean isVideoTutorialsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(videoTutorials)).isDisplayed();
    }

    public boolean isContactUsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs)).isDisplayed();
    }

    public boolean isScrollBarPresent() {
        try {
            WebElement html = driver.findElement(scrollBar);
            return html.getSize().getHeight() > driver.manage().window().getSize().getHeight();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAPIsForPracticeWordDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(apiTestForPracticeWord)).isDisplayed();
    }

    public boolean isAllAPIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(allAPIsSection)).isDisplayed();
    }

    public int getNumberOfAPIs() {
        List<WebElement> list = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(allAPIsList)
        );
        return list.size();
    }

    public boolean isFeedbackForUsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackForUs)).isDisplayed();
    }

    public boolean isFeedbackLinkDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackLink)).isDisplayed();
    }

    public boolean isScrollUpDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(scrollUp)).isDisplayed();
    }

    public boolean isSubscriptionDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subscription)).isDisplayed();
    }

    public boolean isSubscriptionInputBoxDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionInputBox)).isDisplayed();
    }

    public boolean isSideArrowDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sideArrow)).isDisplayed();
    }

    public boolean isCopyRightDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(copyRight)).isDisplayed();
    }
}
