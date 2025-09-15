package com.automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Register_page_func_02 {
    WebDriver driver;

    public TC_Register_page_func_02(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By loginSignupBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By signupUsername = By.xpath("//input[@name='name']");
    By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    By companyInput = By.id("company");
    By address1Input = By.id("address1");
    By address2Input = By.id("address2");
    By countryDropdown = By.id("country");
    By stateInput = By.id("state");
    By cityInput = By.id("city");
    By zipcodeInput = By.id("zipcode");
    By mobileNumberInput = By.id("mobile_number");
    By companyTextbox = By.id("company");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");
    public void clicksignupbutton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(signupButton));
        try {
            button.click();
        } catch (Exception e) {
            // fallback: JavaScript click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    }
    // **Add this getter method**
    public String get_company() {
        return driver.findElement(companyTextbox).getAttribute("value");
    }

    // Click Login/Signup
    public void clickloginsignupbutton() {
        driver.findElement(loginSignupBtn).click();
    }

    // Enter username
    public void enterusername(String name) {
        driver.findElement(signupUsername).clear();
        driver.findElement(signupUsername).sendKeys(name);
    }

    // Enter email
    public void enteremail(String email) {
        driver.findElement(signupEmail).clear();
        driver.findElement(signupEmail).sendKeys(email);
    }


    // Company
    public boolean enter_company(String company) {
        try {
            WebElement ele = driver.findElement(companyInput);
            ele.clear();
            if (company.matches("[a-zA-Z0-9\\s]+") || company.isEmpty()) {
                ele.sendKeys(company);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Address1
    public boolean enter_address1(String address1) {
        try {
            WebElement ele = driver.findElement(address1Input);
            ele.clear();
            if (address1.matches("[a-zA-Z0-9\\s]+") || address1.isEmpty()) {
                ele.sendKeys(address1);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Address2
    public boolean enter_address2(String address2) {
        try {
            WebElement ele = driver.findElement(address2Input);
            ele.clear();
            if (address2.matches("[a-zA-Z0-9\\s]+") || address2.isEmpty()) {
                ele.sendKeys(address2);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Country
    public boolean select_country(String country) {
        try {
            Select sel = new Select(driver.findElement(countryDropdown));
            sel.selectByVisibleText(country);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // State
    public boolean enter_state(String state) {
        try {
            WebElement ele = driver.findElement(stateInput);
            ele.clear();
            if (state.matches("[a-zA-Z\\s]+") || state.isEmpty()) {
                ele.sendKeys(state);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // City
    public boolean enter_city(String city) {
        try {
            WebElement ele = driver.findElement(cityInput);
            ele.clear();
            if (city.matches("[a-zA-Z\\s]+") || city.isEmpty()) {
                ele.sendKeys(city);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Zipcode
    public boolean enter_zipcode(String zipcode) {
        try {
            WebElement ele = driver.findElement(zipcodeInput);
            ele.clear();
            if (zipcode.matches("\\d+") || zipcode.isEmpty()) { // only digits allowed
                ele.sendKeys(zipcode);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Mobile Number
    public boolean enter_mobileNumber(String mobile) {
        try {
            WebElement ele = driver.findElement(mobileNumberInput);
            ele.clear();
            if (mobile.matches("\\d+") || mobile.isEmpty()) { // only digits allowed
                ele.sendKeys(mobile);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}