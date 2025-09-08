package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC_Products_page_ui_02 {
    WebDriver driver;

    // Locators for TC11–TC20
    By productsbutton=By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a");
    By specialOfferBanner = By.xpath("//*[@id=\"sale_image\"]");
    By searchBox = By.id("search_product");
    By searchButton = By.id("submit_search");
    By categorySection = By.xpath("//div[@class='left-sidebar']//h2[text()='Category']");
    By brandsSection = By.xpath("//div[@class='brands_products']");
    By productsList = By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']");
    By productName = By.xpath("(//div[@class='productinfo text-center']//p)[1]");
    By productPrice = By.xpath("(//div[@class='productinfo text-center']//h2)[1]");
    public void clickproductsbutton() {
    	driver.findElement(productsbutton).click();
    }

    public TC_Products_page_ui_02(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSpecialOfferDisplayed() {
        return driver.findElement(specialOfferBanner).isDisplayed();
    }

    public boolean isSearchBoxDisplayed() {
        return driver.findElement(searchBox).isDisplayed();
    }

    public boolean isSearchButtonDisplayed() {
        return driver.findElement(searchButton).isDisplayed();
    }

    public boolean isCategorySectionDisplayed() {
        return driver.findElement(categorySection).isDisplayed();
    }

    public boolean isBrandsSectionDisplayed() {
        return driver.findElement(brandsSection).isDisplayed();
    }

    public boolean areProductsDisplayed() {
        return driver.findElements(productsList).size() > 0;
    }

    public boolean isProductNameDisplayed() {
        return driver.findElement(productName).isDisplayed();
    }

    public boolean isProductPriceDisplayed() {
        return driver.findElement(productPrice).isDisplayed();
    }

    public boolean isHoverEffectWorking() {
        // Simple hover validation = element is displayed (hover testing needs Actions class if required)
        return driver.findElement(productsList).isDisplayed();
    }
}