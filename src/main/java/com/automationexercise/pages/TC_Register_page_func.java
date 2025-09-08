package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_Register_page_func {

    WebDriver driver;

    // Locators
    By loginSignupBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By usernameField = By.xpath("//input[@placeholder='Name']");
    By emailField = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[contains(text(),'Signup')]");
    By registerHeading = By.xpath("//b[contains(text(),'Enter Account Information')]");
    By signupError = By.xpath("//p[contains(text(),'Email Address already exist!')]");

    By mrRadioBtn = By.id("id_gender1");
    By mrsRadioBtn = By.id("id_gender2");

    By registerName = By.id("name");
    By registerPassword = By.id("password");

    By dayDropdown = By.id("days");
    By monthDropdown = By.id("months");
    By yearDropdown = By.id("years");

    By newsletterCheckbox = By.id("newsletter");
    By offersCheckbox = By.id("optin");

    By firstnameField = By.id("first_name");
    By lastnameField = By.id("last_name");
    By companyField = By.id("company");
    By address1Field = By.id("address1");
    By address2Field = By.id("address2");
    By countryDropdown = By.id("country");
    By stateField = By.id("state");
    By cityField = By.id("city");
    By zipcodeField = By.id("zipcode");
    By mobileNumberField = By.id("mobile_number");

    // Constructor
    public TC_Register_page_func(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickloginsignupbutton() {
       driver.findElement(loginSignupBtn).click();
    }

    public void enterusername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enteremail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public WebElement clicksignupbutton() {
        WebElement signupBtn = driver.findElement(signupButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signupBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signupBtn);
        return signupBtn;
    }


    public boolean registerpageheadingisdisplayed() {
        try {
            return driver.findElement(registerHeading).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean signuppageerrorisdisplayed() {
    	 return driver.findElements(signupError).size() > 0;
       
    }

    public void clickmrradiobutton() {
        driver.findElement(mrRadioBtn).click();
    }

    public void clickmrsradiobutton() {
        driver.findElement(mrsRadioBtn).click();
    }

    public void enter_regisiter_name(String name) {
        driver.findElement(registerName).clear();
        driver.findElement(registerName).sendKeys(name);
    }

    public void enter_register_password(String password) {
        driver.findElement(registerPassword).clear();
        driver.findElement(registerPassword).sendKeys(password);
    }

    public void select_day(String day) {
        new Select(driver.findElement(dayDropdown)).selectByValue(day);
    }

    public void select_month(String month) {
        new Select(driver.findElement(monthDropdown)).selectByValue(month);
    }

    public void select_year(String year) {
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
    }

    public void click_newsletter() {
        driver.findElement(newsletterCheckbox).click();
    }

    public void click_offers() {
        driver.findElement(offersCheckbox).click();
    }

    public void enter_firstname(String fname) {
        driver.findElement(firstnameField).clear();
        driver.findElement(firstnameField).sendKeys(fname);
    }

    public void enter_lastname(String lname) {
        driver.findElement(lastnameField).clear();
        driver.findElement(lastnameField).sendKeys(lname);
    }

    public void enter_company(String company) {
        driver.findElement(companyField).clear();
        driver.findElement(companyField).sendKeys(company);
    }

    public void enter_address1(String address) {
        driver.findElement(address1Field).clear();
        driver.findElement(address1Field).sendKeys(address);
    }

    public void enter_address2(String address) {
        driver.findElement(address2Field).clear();
        driver.findElement(address2Field).sendKeys(address);
    }

    public void select_country(String country) {
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
    }

    public void enter_state(String state) {
        driver.findElement(stateField).clear();
        driver.findElement(stateField).sendKeys(state);
    }

    public void enter_city(String city) {
        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);
    }

    public void enter_zipcode(String zip) {
        driver.findElement(zipcodeField).clear();
        driver.findElement(zipcodeField).sendKeys(zip);
    }

    public void enter_mobile(String mobile) {
        driver.findElement(mobileNumberField).clear();
        driver.findElement(mobileNumberField).sendKeys(mobile);
    }

    


}