package com.automationexercise.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.PRODUCTPAGE;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Functional_Product_2 extends BaseTest {
	String projectpath=System.getProperty("user.dir");
	
	//TC.13 To Verify and Validate  filtering products by brand
	@Test
	public void Tc_products_13() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate  filtering products by brand");
        
        PRODUCTPAGE product = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        product.btn_Products();
        test.pass("Clicked on 'Products' button");
        
        product.clickPoloBrand();
        test.pass("Clicked on Polo brand");

        String brandTitle = product.getBrandTitle().getText();
        boolean brandCheck = brandTitle.trim().equalsIgnoreCase("BRAND - POLO PRODUCTS");

        int productCount = product.getBrandProducts().size();
        boolean productCheck = productCount > 0;

        if (brandCheck && productCheck) {
            test.pass("Filtering by brand validated successfully – Only Polo products are shown.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_13"));
        } else {
            test.fail("Filtering by brand validation failed – Brand title mismatch or products not shown.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_13 Fail"));
        }
    }
    

    //TC.14 To Verify and Validate  brand filter resets after navigating to ALL PRODUCTS
    @Test
    public void Tc_products_14() throws IOException {
        ExtentTest test = extent.createTest("To Verify and Validate  brand filter resets after navigating to ALL PRODUCTS");

        PRODUCTPAGE product = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        product.btn_Products();
        test.pass("Clicked on 'Products' button");

        product.clickPoloBrand();
        test.pass("Clicked on Polo brand");

        product.btn_Products();
        test.pass("Clicked again on 'Products' button to reset brand filter");

        int productCount = product.getAllProducts().size();
        boolean productsVisible = productCount > 0;

        if (productsVisible) {
            test.pass("All products are displayed successfully, brand filter reset confirmed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_14"));
        } else {
            test.fail("All products are NOT displayed, brand filter reset failed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_14 Fail"));
        }
    }


    //TC.15 To Verify and Validate  product image zoom on detail page
    @Test
    public void Tc_products_15() throws IOException {
        ExtentTest test = extent.createTest("To Verify and Validate  product image zoom on detail page");
    
        PRODUCTPAGE product = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        product.btn_Products();
        test.pass("Clicked on 'Products' button");
    
        WebElement productImg = product.getFirstProductName();
        test.pass("Located first product image");

        Actions actions = new Actions(driver);
        actions.moveToElement(productImg).perform();
        test.pass("Hovered over first product image");

        boolean zoomEffect = productImg.getCssValue("transform").contains("matrix") 
                             || productImg.getAttribute("style").contains("scale");

        if (zoomEffect) {
            test.pass("Product image zoom works correctly without distortion.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_15"));
        } else {
            test.fail("Product image zoom did NOT work as expected.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_15 Fail"));
        }
    }


    //TC.16 To Verify and Validate  breadcrumb navigation works
	@Test
	public void Tc_products_16() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate  breadcrumb navigation works");
        
        PRODUCTPAGE product = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        product.btn_Products();
        test.pass("Clicked on 'Products' button");
        
        product.clickBreadcrumbWomen();
        test.pass("Clicked on Women breadcrumb");

        product.clickBreadcrumbDress();
        test.pass("Clicked on Dress breadcrumb");

        String title = product.getCategoryTitle().getText();
        boolean correctCategory = title.trim().equalsIgnoreCase("WOMEN - DRESS PRODUCTS");

        if (correctCategory) {
            test.pass("Breadcrumb navigation works correctly – Correct category page loads.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_16"));
        } else {
            test.fail("Breadcrumb navigation failed – Incorrect category page loaded.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_16 Fail"));
        }
	}
	
	
	//TC.17 To Verify and Validate filtering products by category
	@Test
	public void Tc_products_17() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate filtering products by category");
        
        PRODUCTPAGE product = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        product.btn_Products();
        test.pass("Clicked on 'Products' button");
        
        product.clickWomenCategory();
        test.pass("Clicked on Women category");

        product.clickDressCategory();
        test.pass("Clicked on Dress sub-category");

        String categoryTitle = product.getCategoryTitle().getText();
        boolean categoryCheck = categoryTitle.trim().equalsIgnoreCase("WOMEN - DRESS PRODUCTS");

        int productCount = product.getCategoryProducts().size();
        boolean productCheck = productCount > 0;

        if (categoryCheck && productCheck) {
            test.pass("Products by category validated successfully – Only Dress products are shown.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_17"));
        } else {
            test.fail("Products by category validation failed – Category title mismatch or products not shown.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_17 Fail"));
        }
	}
	

    //TC.18 To Verify and Validate  filtering products by brand
    @Test
    public void Tc_products_18() throws IOException {
        ExtentTest test = extent.createTest("To Verify and Validate  filtering products by brand");

        PRODUCTPAGE product = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        product.btn_Products();
        test.pass("Clicked on 'Products' button");

        product.clickPoloBrand();
        test.pass("Clicked on Polo brand");

        String brandTitle = product.getBrandTitle().getText();
        boolean brandCheck = brandTitle.trim().equalsIgnoreCase("BRAND - POLO PRODUCTS");

        int productCount = product.getBrandProducts().size();
        boolean productCheck = productCount > 0;

        if (brandCheck && productCheck) {
            test.pass("Filtering by brand validated successfully – Only Polo products are shown.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_18"));
        } else {
            test.fail("Filtering by brand validation failed – Brand title mismatch or products not shown.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_18 Fail"));
        }
    }


    //TC.19 To Verify and Validate searching with spaces before/after product name
    @Test
    public void Tc_products_19() throws IOException {
        ExtentTest test = extent.createTest("To Verify and Validate searching with spaces before/after product name");

        PRODUCTPAGE product = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        product.btn_Products();
        test.pass("Clicked on 'Products' button");

        product.searchProduct().clear();
        test.pass("Cleared search field");
	    
        product.searchProduct().sendKeys("       Dress"); 
        test.pass("Entered product name with leading spaces");

        product.clickonSearch();
        test.pass("Clicked on Search button");

        int resultCount = product.getSearchedProducts().size();

        if (resultCount > 0) {
            test.pass("Search handled correctly – Products displayed as expected.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_19"));
        } else {
            test.fail("Search failed – No products displayed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_19 Fail"));
        }
    }

    //TC.20 To Verify and Validate search for product by full exact name
    @Test
    public void Tc_products_20() throws IOException {
        ExtentTest test=extent.createTest("To Verify and Validate search for product by full exact name");

        PRODUCTPAGE products = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        products.btn_Products();
        test.pass("Clicked on 'Products' button");

        WebElement search = products.searchProduct();
        search.sendKeys("Blue Top");
        test.pass("Entered exact product name: Blue Top");

        products.clickonSearch();
        test.pass("Clicked on Search button");

        WebElement prod = products.getFirstProductName();
        if(prod.isDisplayed()) {
            test.pass("Product found")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_20"));       
        }
        else{
            test.fail("Product not found")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_20 Fail"));
        }
    }


    //TC.21 To verify and validate click products button
    @Test
    public void Tc_products_21() throws IOException {
        ExtentTest test=extent.createTest("To verify and validate click products button");
	
        PRODUCTPAGE products = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");
	
        products.clickOnCartButton();
        test.pass("Clicked on Cart button");
	
        products.ClickOnhere();
        test.pass("Clicked on 'here' link in cart page");
	
        WebElement present = products.All_products();

        if(present.getText().contains("ALL PRODUCTS")) {
            test.pass("User navigated to ALL PRODUCTS page after clicking 'here' link in cart page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_21"));
        }
        else {
            test.fail("User did not navigate to ALL PRODUCTS page after clicking 'here' link in cart page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_21 Fail"));
        }
    }


    //TC.22 To verify and validate Click 'Continue Shopping' button
    @Test
    public void Tc_products_22() throws IOException {
        ExtentTest test=extent.createTest("To verify and validate Click 'Continue Shopping' button");
	
        PRODUCTPAGE products = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");
	
        products.btn_Products();
        test.pass("Clicked on 'Products' button");
	
        products.FirstProductViewProduct();
        test.pass("Clicked on View Product for first product");
      
        products.addFirstproductToCart();
        test.pass("Added product to cart");
	
        products.clickOnContinue();
        test.pass("Clicked on Continue Shopping button");

        WebElement detailTitle = products.productDetailTitle();
	    
        if(detailTitle.isDisplayed()) {
            test.pass("'Continue Shopping' button works properly")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_22"));
        } else {
            test.fail("'Continue Shopping' button does not work properly")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_22 Fail"));
        }
    }


    // TC24. To verify and validate Click 'View Cart' button
    @Test
    public void Tc_products_24() throws IOException {
        ExtentTest test = extent.createTest("To verify and validate Click 'View Cart' button");

        PRODUCTPAGE products = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        test.pass("Opened application URL");

        products.btn_Products();
        test.pass("Clicked on 'Products' button");

        products.FirstProductViewProduct();
        test.pass("Clicked on View Product for first product");

        products.addFirstproductToCart();
        test.pass("Added product to cart");

        products.clickViewCart();
        test.pass("Clicked on View Cart button");

        WebElement quantity = products.QuantityCheck();

        if(quantity.getText().contains("1")) {
            test.pass("View Cart button works properly")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_24"));
        } else {
            test.fail("View Cart button failed to show correct cart details")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_24 Fail"));
        }
    }
}
