package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_Freq_func_reg_03 {

    WebDriver driver;

    public TC_Freq_func_reg_03(WebDriver driver) {
        this.driver = driver;
    }

    By brandFilter = By.cssSelector("input[name='brand']");

    By contactUsProducts = By.linkText("Contact Us");
    By allProductsBtn = By.linkText("All Products");
    By contactusheading=By.xpath("//*[@id=\"contact-page\"]/div[1]/div");
    By password=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");

    By emailField = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    By productsBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    By cartBtn = By.linkText("Cart");
    By signupLoginBtn = By.linkText("Signup / Login");
    By testCasesBtn = By.linkText("Test Cases");
    By apiTestingBtn = By.linkText("API Testing");
    By videoTutorialsBtn = By.linkText("Video Tutorials");
    By contactusbtn=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    By deleteBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By logoutBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    
    By brandLink(String brandName) {
        return By.linkText(brandName);
    }

    By filteredProducts = By.cssSelector(".productinfo"); 
    By brandname=By.xpath("/html/body/section[2]/div[1]/div/div[1]/div[1]/div[2]/div/ul/li[1]/a");
    By brandproducts=By.xpath("/html/body/section/div/div[2]/div[2]/div");
    By loginbtn=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    By scrollbar=By.xpath("/html");

    public void clickloginbutton() {
    	driver.findElement(loginbtn).click();
    }
    public boolean clickbrandproductspolo() {
    	return driver.findElement(brandproducts).isDisplayed();
    }
    public void clickbrandname() {
    	driver.findElement(brandname).click();
    	
    }
    public void enterpassword(String pword) {
    	driver.findElement(password).sendKeys(pword);
    }
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailField);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public boolean isEmailValid(String email) {
        return email.matches("cvvbghhjk@gmail.com");
    }

    public void clickBrand(String brandName) {
        driver.findElement(brandLink(brandName)).click();
    }    

    public boolean iscontactusheadingDisplayed() {
    	return driver.findElement(contactusheading).isDisplayed();
    }
    public void clickContactUsButton() {
    driver.findElement(contactusbtn).click();
    }
    public void applyBrandFilter(String brand) {
        try {
            WebElement filter = driver.findElement(brandFilter);
            filter.clear();
            filter.sendKeys(brand);
        } catch (Exception e) {
            System.out.println("Brand filter element not found: " + e.getMessage());
        }
    }

    public void navigateToAllProducts() {
        driver.findElement(allProductsBtn).click();
    }

    public boolean isBrandFilterReset() {
        return driver.findElement(brandFilter).getText().isEmpty();
    }

    public boolean isScrollBarDisplayed() {
        return driver.findElement(scrollbar).isDisplayed();
    }
    
    public boolean clickProductsBtn() {
        try { 
        	driver.findElement(productsBtn).click(); 
        	return true; 
        	} 
        catch(Exception e) 
        { 
        	return false; 
        	}
    }

    public boolean clickCartBtn() {
        try { 
        	driver.findElement(cartBtn).click(); return true; 
        	} catch(Exception e) { 
        		return false; }
    }

    public boolean clickSignupLoginBtn() {
        try { driver.findElement(signupLoginBtn).click(); return true; } catch(Exception e) { return false; }
    }

    public boolean clickTestCasesBtn() {
        try { driver.findElement(testCasesBtn).click(); return true; } catch(Exception e) { return false; }
    }

    public boolean clickApiTestingBtn() {
        try { driver.findElement(apiTestingBtn).click(); return true; } catch(Exception e) { return false; }
    }

    public boolean clickVideoTutorialsBtn() {
        try { driver.findElement(videoTutorialsBtn).click(); return true; } catch(Exception e) { return false; }
    }

    public boolean clickDeleteBtn() {
        try { driver.findElement(deleteBtn).click(); return true; } catch(Exception e) { return false; }
    }

    public boolean clickLogoutBtn() {
        try { driver.findElement(logoutBtn).click(); return true; } catch(Exception e) { return false; }
    }

    public boolean isDeleteBtnDisplayed() {
        try { return driver.findElement(deleteBtn).isDisplayed(); } catch(Exception e) { return false; }
    }

    public boolean isLogoutBtnDisplayed() {
        try { return driver.findElement(logoutBtn).isDisplayed(); } catch(Exception e) { return false; }
    }
    public void clicklogoutbutton() {
    	driver.findElement(logoutBtn).click();
    }
}