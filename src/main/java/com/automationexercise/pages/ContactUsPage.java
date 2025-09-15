package com.automationexercise.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.time.Duration;

public class ContactUsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ---------- General ----------
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getFaviconHref() {
        try {
            Object href = ((JavascriptExecutor) driver)
                    .executeScript("return (document.querySelector('link[rel*=\"icon\"]') || {}).href;");
            return href != null ? href.toString() : "";
        } catch (Exception e) {
            return "";
        }
    }

    // ---------- Header icons ----------
    public boolean isHomeIconVisible()        { return waitVisible(By.xpath("//a[text()=' Home']")).isDisplayed(); }
    public boolean isProductsIconVisible()    { return waitVisible(By.xpath("//a[text()=' Products']")).isDisplayed(); }
 
    public boolean isSignupLoginIconVisible() { return waitVisible(By.xpath("//a[text()=' Signup / Login']")).isDisplayed(); }
    public boolean isTestCasesIconVisible()   { return waitVisible(By.xpath("//a[text()=' Test Cases']")).isDisplayed(); }
    public boolean isApiTestingIconVisible()  { return waitVisible(By.xpath("//a[text()=' API Testing']")).isDisplayed(); }
    public boolean isContactUsIconVisible()   { return waitVisible(By.xpath("//a[text()=' Contact us']")).isDisplayed(); }

    public boolean clickHomeAndVerify()        { waitVisible(By.xpath("//a[text()=' Home']")).click(); return driver.getCurrentUrl().contains("/"); }
    public boolean clickProductsAndVerify()    { waitVisible(By.xpath("//a[text()=' Products']")).click(); return driver.getCurrentUrl().contains("products"); }
    public boolean clickCartAndVerify()        { waitVisible(By.xpath("//a[text()=' Cart']")).click(); return driver.getCurrentUrl().contains("view_cart"); }
    public boolean clickSignupLoginAndVerify() { waitVisible(By.xpath("//a[text()=' Signup / Login']")).click(); return driver.getCurrentUrl().contains("login"); }
    public boolean clickTestCasesAndVerify()   { waitVisible(By.xpath("//a[text()=' Test Cases']")).click(); return driver.getCurrentUrl().contains("test_cases"); }
    public boolean clickApiTestingAndVerify()  { waitVisible(By.xpath("//a[text()=' API Testing']")).click(); return driver.getCurrentUrl().contains("api_list"); }
    public boolean clickContactUsAndVerify()   { waitVisible(By.xpath("//a[text()=' Contact us']")).click(); return driver.getCurrentUrl().contains("contact_us"); }

    // ---------- Logo ----------
    public boolean isLogoVisible() {
        return waitVisible(By.xpath("//div[@class='logo pull-left']")).isDisplayed();
    }

    // ---------- Subscription ----------
    public boolean isSubscriptionVisible() {
        return waitVisible(By.xpath("//h2[text()='Subscription']")).isDisplayed();
    }

    public void enterSubscriptionEmail(String email) {
        WebElement box = waitVisible(By.id("susbscribe_email"));
        box.clear();
        box.sendKeys(email);
    }

    public void clickSubscribeButton() {
        waitVisible(By.id("subscribe")).click();
    }

    public String getSubscriptionMessage() {
        try {
            // First try success
            try {
                WebElement success = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("#success-subscribe, .alert-success")));
                return success.getText();
            } catch (TimeoutException ignore) {}

            // If not found, try error
            WebElement error = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.cssSelector(".alert-danger, .error_message")));
            return error.getText();

        } catch (TimeoutException e) {
            return "";
        }
    }

    // ---------- Scroll Up ----------
    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public boolean isScrollUpVisibleAfterScroll() {
        scrollToBottom();
        return waitVisible(By.id("scrollUp")).isDisplayed();
    }

    public boolean clickScrollUpAndVerifyTop() {
        scrollToBottom();
        WebElement up = waitVisible(By.id("scrollUp"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", up);
        return wait.until(d -> {
            Long y = (Long) ((JavascriptExecutor) d).executeScript("return Math.round(window.pageYOffset);");
            return y != null && y == 0;
        });
    }

    // ---------- Contact Form ----------
    public String getNamePlaceholder()    { return waitVisible(By.name("name")).getAttribute("placeholder"); }
    public String getEmailPlaceholder()   { return waitVisible(By.name("email")).getAttribute("placeholder"); }
    public String getSubjectPlaceholder() { return waitVisible(By.name("subject")).getAttribute("placeholder"); }
    public String getMessagePlaceholder() { return waitVisible(By.name("message")).getAttribute("placeholder"); }

    public WebElement submitButton() {
        return waitVisible(By.name("submit"));
    }

    public WebElement uploadFileInput() {
        return waitVisible(By.name("upload_file"));
    }

    public String ensureTempFile(String filename) throws Exception {
        File file = new File(System.getProperty("java.io.tmpdir"), filename);
        try (FileWriter fw = new FileWriter(file)) {
            fw.write("dummy content");
        }
        return file.getAbsolutePath();
    }
}