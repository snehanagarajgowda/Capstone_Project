package com.automationexercise.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.PRODUCTPAGE;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Functional_Product_1  extends BaseTest {
	String projectpath=System.getProperty("user.dir");
	

	// TC01. To Verify and Validate navigation to ALL PRODUCTS page
	@Test
	public void Tc_products_01() throws IOException {
		ExtentTest test=extent.createTest("To Verify and Validate navigation to ALL PRODUCTS page");
		
		PRODUCTPAGE products = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");

		products.btn_Products();
		test.pass("Clicked on Products button");

		WebElement present = products.All_products();
		test.pass("Located ALL PRODUCTS page element");

		if(present.getText().contains("ALL PRODUCTS")) {
			test.pass("User navigated to ALL PRODUCTS page")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_01"));
		}
		else {
			test.fail("User did not navigate to ALL PRODUCTS page")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_01"));
		}
	}

	// TC02. To Verify and Validate search for existing product
	@Test
	public void Tc_products_02() throws IOException {
		ExtentTest test=extent.createTest("To Verify search for existing product");
		
		PRODUCTPAGE products = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");
		
		products.btn_Products();
		test.pass("Clicked on Products button");

		WebElement search = products.searchProduct();
		search.sendKeys("Blue Top");
		test.pass("Entered product name: Blue Top");

		products.clickonSearch();
		test.pass("Clicked on Search button");

		WebElement prod = products.getFirstProductName();
		test.pass("Located first product in results");

		if(prod.isDisplayed()) {
			test.pass("Product found")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_02"));       
		}
		else{
			test.fail("Product not found")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_02"));
		}
	}

	// TC03. To Verify and Validate search for non-existing product
	@Test
	public void Tc_products_03() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate search for non-existing product");
		
		PRODUCTPAGE product = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");

		product.btn_Products();
		test.pass("Clicked on Products button");

		product.searchProduct().sendKeys("XYZ123");
		test.pass("Entered invalid product name: XYZ123");

		product.clickonSearch();
		test.pass("Clicked on Search button");

		String searchedProductsTitle = product.All_products().getText();
		test.pass("Captured 'SEARCHED PRODUCTS' title");

		int productCount = product.getProductsList().size();
		test.pass("Checked product list size: " + productCount);

		if (searchedProductsTitle.trim().equals("SEARCHED PRODUCTS") && productCount == 0) {
			test.pass("Non-existing product search validated successfully – No products displayed.")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_03"));
		} else {
			test.fail("Non-existing product search failed – Either title not visible or products appeared.")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_03_Fail"));
		}
	}

	// TC04. Verify search is case-insensitive
	@Test
	public void Tc_products_04() throws IOException {
		ExtentTest test = extent.createTest("Verify search is case-insensitive");

		PRODUCTPAGE products = new PRODUCTPAGE(driver);	    
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");

		products.btn_Products();       
		test.pass("Clicked on Products button");

		WebElement search = products.searchProduct();
		search.sendKeys("BlUe TOp");
		test.pass("Entered product name in mixed case: BlUe TOp");

		products.clickonSearch();  
		test.pass("Clicked on Search button");

		WebElement prod = products.getFirstProductName();
		test.pass("Located first product in results");

		if (prod.getText().contains("View Product")) {
			test.pass("Case insensitive search working")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_04"));   
		} else {
			test.fail("Case insensitive search failed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_04_Fail"));
		}
	}
	
	// TC05. Verify partial keyword search
	@Test
	public void Tc_products_05() throws IOException {
		ExtentTest test = extent.createTest("Verify partial keyword search");
		
		PRODUCTPAGE products = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");

		products.btn_Products();        
		test.pass("Clicked on Products button");

		WebElement search = products.searchProduct();
		search.sendKeys("Blu");     
		test.pass("Entered partial keyword: Blu");

		products.clickonSearch();     
		test.pass("Clicked on Search button");

		WebElement prod = products.getFirstProductName();
		test.pass("Located first product in results");

		if (prod != null && prod.getText().toLowerCase().contains("blu")) {
			test.pass("Partial keyword search is working")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_05"));   
		}
		else {
			test.fail("Partial keyword search is not working")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_05_Fail"));   	
		}
	}

	// TC06. To Verify and Validate product detail page navigation
	@Test
	public void Tc_products_06() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate product detail page navigation");
		
		PRODUCTPAGE products = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");

		products.btn_Products();
		test.pass("Clicked on Products button");

		products.FirstProductViewProduct();
		test.pass("Clicked on first product View Product");

		WebElement detailTitle = products.productDetailTitle();
		test.pass("Located product detail title element");

		if(detailTitle.isDisplayed()) {
			test.pass("Product detail is displayed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_06"));
		} else {
			test.fail("Product detail page not displayed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_06_Fail"));
		}
	}
	    
	// TC07. To Verify and Validate product description is visible
	@Test
	public void Tc_products_07() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate product description is visible");
		
		PRODUCTPAGE product = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");

		product.btn_Products();
		test.pass("Clicked on Products button");

		product.FirstProductViewProduct();
		test.pass("Clicked on first product View Product");

		WebElement details = product.ProductDetails();
		test.pass("Located product description element");

		if(details.getText().contains("Blue Top")) {
			test.pass("Product description is visible")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_07"));
		} else {
			test.fail("Product description not visible")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_07_Fail"));
		}
	}

	// TC08. To Verify and Validate adding single product to cart from list
	@Test
	public void Tc_products_08() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate adding single product to cart from list");
		
		PRODUCTPAGE products = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");

		products.btn_Products();
		test.pass("Clicked on Products button");

		products.FirstProductViewProduct();
		test.pass("Clicked on first product View Product");

		products.addFirstproductToCart();
		test.pass("Added first product to cart");

		products.clickViewCart();
		test.pass("Clicked on View Cart");

		WebElement quantity = products.QuantityCheck();
		test.pass("Checked cart quantity");

		if(quantity.getText().contains("1")) {
			test.pass("Product appears in cart")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_08"));
		} else {
			test.fail("Product not added to cart")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_08_Fail"));
		}
	}
	    
	// TC09. To Verify and Validate adding product to cart from detail page
	@Test
	public void Tc_products_09() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate adding product to cart from detail page");
		
		PRODUCTPAGE product = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");

		product.btn_Products();
		test.pass("Clicked on Products button");

		product.FirstProductViewProduct();
		test.pass("Clicked on first product View Product");

		product.addFirstproductToCart();
		test.pass("Added product to cart from details page");

		product.clickViewCart();
		test.pass("Clicked on View Cart");

		WebElement quantity = product.QuantityCheck();
		test.pass("Checked cart quantity");

		if(quantity.getText().contains("1")) {
			test.pass("Product appears in cart via details page")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_09"));
		} else {
			test.fail("Product not added via details page")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_09_Fail"));
		}
	}
		    
	// TC10. To Verify and Validate quantity selection before adding to cart
	@Test
	public void Tc_products_10() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate quantity selection before adding to cart");
		
		PRODUCTPAGE product = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");

		product.btn_Products();
		test.pass("Clicked on Products button");

		product.FirstProductViewProduct();
		test.pass("Clicked on first product View Product");

		WebElement input = product.QuantityInput();
		input.clear();
		input.sendKeys("3");
		test.pass("Entered quantity: 3");

		product.addFirstproductToCart();
		test.pass("Added product with quantity 3 to cart");

		product.clickViewCart();
		test.pass("Clicked on View Cart");

		WebElement quantity = product.QuantityCheck();
		test.pass("Checked cart quantity");

		if(quantity.getText().contains("3")) {
			test.pass("Product added with correct quantity")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_10"));
		} else {
			test.fail("Quantity selection failed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_10_Fail"));
		}
	}
			
	// TC11. To Verify and Validate multiple different products added to cart
	@Test
	public void Tc_products_11() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate multiple different products added to cart");
		
		PRODUCTPAGE product = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");

		product.btn_Products();
		test.pass("Clicked on Products button");

		product.FirstProductViewProduct();
		test.pass("Clicked on first product View Product");

		product.addFirstproductToCart();
		test.pass("Added first product to cart");

		product.clickViewCart();
		test.pass("Clicked on View Cart");

		product.btn_Products();
		test.pass("Returned to Products page");

		product.SecondProductViewProduct();
		test.pass("Clicked on second product View Product");

		product.SecondProductAddCart();
		test.pass("Added second product to cart");

		product.SecondProductViewCart();
		test.pass("Clicked on View Cart for second product");

		WebElement quantity = product.SecondQuantityCheck();
		test.pass("Checked cart quantity for second product");

		if(quantity.getText().contains("1")) {
			test.pass("Both products appear in cart")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_11"));
		} else {
			test.fail("Multiple product add to cart failed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_11_Fail"));
		}
	}
	
	// TC12. To Verify and Validate products by category
	@Test
	public void Tc_products_12() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate products by category");
		
		PRODUCTPAGE product = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		test.pass("Opened application URL");

		product.btn_Products();
		test.pass("Clicked on Products button");

		product.clickWomenCategory();
		test.pass("Clicked on Women category");

		product.clickDressCategory();
		test.pass("Clicked on Dress subcategory");

		String categoryTitle = product.getCategoryTitle().getText();
		test.pass("Captured category title: " + categoryTitle);

		int productCount = product.getCategoryProducts().size();
		test.pass("Captured product count: " + productCount);

		if (categoryTitle.trim().equalsIgnoreCase("WOMEN - DRESS PRODUCTS") && productCount > 0) {
			test.pass("Products by category validated successfully")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_12"));
		} else {
			test.fail("Products by category validation failed")
				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_12_Fail"));
		}
	}
}
