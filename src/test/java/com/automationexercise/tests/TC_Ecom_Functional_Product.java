package com.automationexercise.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.PRODUCTPAGE;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Functional_Product  extends BaseTest {
	String projectpath=System.getProperty("user.dir");
	

	// TC01. To Verify and Validate  navigation to ALL PRODUCTS page
	@Test
	public void Tc_products_01() throws IOException {
		ExtentTest test=extent.createTest("To Verify and Validate  navigat to all products page");
		
		PRODUCTPAGE products = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");

		products.btn_Products();
		WebElement present = products.All_products();

		if(present.getText().contains("ALL PRODUCTS")) {
			System.out.println("User will navigate to ALL PRODUCTS page");
			test.pass("User will navigate to ALL PRODUCTS page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_01"));
		}
		else {
			System.out.println("User will not navigate to ALL PRODUCTS page");
			test.fail("User will not navigate to ALL PRODUCTS page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_01"));
		}
	}

	// TC02. To Verify and Validate search for existing product
	@Test
	public void Tc_products_02() throws IOException {
		ExtentTest test=extent.createTest("To Verify search for existing product");
		
		PRODUCTPAGE products = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		
		products.btn_Products();
		WebElement search = products.searchProduct();
		search.sendKeys("Blue Top");
		
		products.clickonSearch();
		WebElement prod = products.getFirstProductName();
		if(prod.isDisplayed()) {
			test.pass("Product found").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_02"));       
		}
		else{
			test.pass("Product not found").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_02"));
		}
	}

	// TC04. Verify search is case-insensitive
	@Test
	public void Tc_products_04() throws IOException {
	    ExtentTest test = extent.createTest("Verify search is case-insensitive");

	    PRODUCTPAGE products = new PRODUCTPAGE(driver);	    
	    driver.get("https://automationexercise.com");

	    products.btn_Products();       
	    
	    WebElement search = products.searchProduct();
		search.sendKeys("BlUe TOp");
		
	    products.clickonSearch();  
	    
	    WebElement prod = products.getFirstProductName();
	    
	    if (prod.getText().contains("View Product")) {
	    	test.pass("Case insensitive").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_04"));   
	    }
	    }
	
	// TC05. Verify partial keyword search
	@Test
	public void Tc_products_05() throws IOException {
	    ExtentTest test = extent.createTest("Verify partial keyword search");
	    
	    PRODUCTPAGE products = new PRODUCTPAGE(driver);
	    driver.get("https://automationexercise.com");

	    products.btn_Products();        
	    
	    WebElement search = products.searchProduct();
		search.sendKeys("Blu");     
		
	    products.clickonSearch();     
	    
	    WebElement prod = products.getFirstProductName();
	    
	    if (prod != null && prod.getText().toLowerCase().contains("blu")) {
	    	test.pass("Partial keyboard search is working").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_05"));   
	    }
	    else {
	    	test.pass("Partial keyboard search is not working").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_05"));   	
	    }
	    
	    }
	
	// TC06. To Verify and Validate product detail page navigation
	@Test
	public void Tc_products_06() throws IOException {
	    ExtentTest test = extent.createTest("To Verify and Validate product detail page navigation");
	    
	    PRODUCTPAGE products = new PRODUCTPAGE(driver);
	    driver.get("https://automationexercise.com");
	    
	    products.btn_Products();
	    
	    products.FirstProductViewProduct();
	    
	    WebElement detailTitle = products.productDetailTitle();
	    
	    if(detailTitle.isDisplayed()) {
	        test.pass("Product detail is displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_06"));
	    } else {
	        test.fail("Product detail page not displayed").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_06"));
	    }
	}
	    
	 // TC08. To Verify and Validate adding single product to cart from list
	    @Test
	    public void Tc_products_08() throws IOException {
	        ExtentTest test = extent.createTest("To Verify and Validate adding single product to cart from list");
	        
	        PRODUCTPAGE products = new PRODUCTPAGE(driver);
	        driver.get("https://automationexercise.com");
	        
	        products.btn_Products();
	       
	       products.FirstProductViewProduct();
	        
	       products.addFirstproductToCart();
	       
	       products.clickViewCart();
	        
	        WebElement quantity = products.QuantityCheck();
	        
	        if(quantity.getText().contains("1")) {
	        	test.pass("Product appears in cart").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_08"));
	        }
	        
	    }
	    
	    
	    //TC03. To Verify and Validate  search for non-existing product
	    @Test
	    public void Tc_products_03() throws IOException {
	    	ExtentTest test = extent.createTest("To Verify and Validate  search for non-existing product");
	        
	        PRODUCTPAGE product = new PRODUCTPAGE(driver);
	        driver.get("https://automationexercise.com");

	        //Navigate to Products page
	        product.btn_Products();
	        

	        //Enter invalid product name
	        product.searchProduct().sendKeys("XYZ123");
	        test.info("Entered invalid product name: XYZ123");

	        //Click search button
	        product.clickonSearch();
	        test.info("Clicked on Search button");

	        //Verify 'SEARCHED PRODUCTS' title
	        String searchedProductsTitle = product.All_products().getText();
	        boolean titleCheck = searchedProductsTitle.trim().equals("SEARCHED PRODUCTS");

	        //Verify no products are displayed
	        int productCount = product.getProductsList().size();
	        boolean noProductCheck = (productCount == 0);

	        //Final result
	        if (titleCheck && noProductCheck) {
	            test.pass("Non-existing product search validated successfully – No products displayed.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_03"));
	        } else {
	            test.fail("Non-existing product search failed – Either title not visible or products appeared.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_03 Fail"));
	        }
	    }
	    
	
	//TC.07 To Verify and Validate  product description is visible
	@Test
	public void Tc_products_07() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate  product description is visible");
        
        PRODUCTPAGE product = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");

        //Navigate to Products page
        product.btn_Products();
        
        product.FirstProductViewProduct();
        
        WebElement details = product.ProductDetails();
        
        if(details.getText().contains("Blue Top")) {
        	test.pass("Product description is visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_07"));
        }
	}
	
	
	//TC.09 To Verify and Validate  adding product to cart from detail page
		@Test
		public void Tc_products_09() throws IOException {
			ExtentTest test = extent.createTest("To Verify and Validate  adding product to cart from detail page");
	        
	        PRODUCTPAGE product = new PRODUCTPAGE(driver);
	        driver.get("https://automationexercise.com");

	        //Navigate to Products page
	        product.btn_Products();
	     		       
		       product.FirstProductViewProduct();
		        
		       product.addFirstproductToCart();
		       
		       product.clickViewCart();
		        
		        WebElement quantity = product.QuantityCheck();
		        
		        if(quantity.getText().contains("1")) {
		        	test.pass("Product appears in cart and User able to add the product to the cart through product details page.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_09"));
		        }
		        
		    }
		    
	
	//TC.10 To Verify and Validate  quantity selection before adding to cart
			@Test
			public void Tc_products_10() throws IOException {
				ExtentTest test = extent.createTest("To Verify and Validate  quantity selection before adding to cart");
		        
		        PRODUCTPAGE product = new PRODUCTPAGE(driver);
		        driver.get("https://automationexercise.com");

		        //Navigate to Products page
		        product.btn_Products();
		        
		        product.FirstProductViewProduct();
		        
		        WebElement input = product.QuantityInput();
		        input.clear();
		        input.sendKeys("3");
		        
		        product.addFirstproductToCart();
			       
			    product.clickViewCart();
			    
			    WebElement quantity = product.QuantityCheck();
			    
			    if(quantity.getText().contains("3")) {
			    	test.pass("Product appears in cart and User able to add 3 Quantity of product to the cart.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_10"));
			    	}
			}
			
	
	//TC.11 To Verify and Validate multiple different products added to cart
	@Test
	public void Tc_products_11() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate multiple different products added to cart");
        
        PRODUCTPAGE product = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");

        //Navigate to Products page
        product.btn_Products();
        
        product.FirstProductViewProduct();
        
        product.addFirstproductToCart();
	       
	    product.clickViewCart();
	       
	    product.btn_Products();
	        
	    product.SecondProductViewProduct();
	        
	    product.SecondProductAddCart();
		       
	    product.SecondProductViewCart();
	    
	    WebElement quantity = product.SecondQuantityCheck();
        
        if(quantity.getText().contains("1")) {
        	test.pass("User is able to check Both products appear in cart.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_11"));
        }
        
	}
	
	
	//TC.12 To Verify and Validate  products by category
		@Test
		public void Tc_products_12() throws IOException {
			ExtentTest test = extent.createTest("To Verify and Validate  products by category");
	        
	        PRODUCTPAGE product = new PRODUCTPAGE(driver);
	        driver.get("https://automationexercise.com");

	        //Navigate to Products page
	        product.btn_Products();
	        
	        product.clickWomenCategory();

	        product.clickDressCategory();

	        String categoryTitle = product.getCategoryTitle().getText();
	        boolean categoryCheck = categoryTitle.trim().equalsIgnoreCase("WOMEN - DRESS PRODUCTS");

	        int productCount = product.getCategoryProducts().size();
	        boolean productCheck = productCount > 0;

	        if (categoryCheck && productCheck) {
	            test.pass("Products by category validated successfully – Only Dress products are shown.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_12"));
	        } else {
	            test.fail("Products by category validation failed – Category title mismatch or products not shown.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_12 Fail"));
	        }
		}
		
	
	//TC.13 To Verify and Validate  filtering products by brand
			@Test
			public void Tc_products_13() throws IOException {
				ExtentTest test = extent.createTest("To Verify and Validate  filtering products by brand");
		        
		        PRODUCTPAGE product = new PRODUCTPAGE(driver);
		        driver.get("https://automationexercise.com");

		        //Navigate to Products page
		        product.btn_Products();
		        
		        product.clickPoloBrand();

		        String brandTitle = product.getBrandTitle().getText();
		        boolean brandCheck = brandTitle.trim().equalsIgnoreCase("BRAND - POLO PRODUCTS");

		        int productCount = product.getBrandProducts().size();
		        boolean productCheck = productCount > 0;

		        if (brandCheck && productCheck) {
		            test.pass("Filtering by brand validated successfully – Only Polo products are shown.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_13"));
		        } else {
		            test.fail("Filtering by brand validation failed – Brand title mismatch or products not shown.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_13 Fail"));
		        }
		    }
		    
	
	//TC.14 To Verify and Validate  brand filter resets after navigating to ALL PRODUCTS
	@Test
	public void Tc_products_14() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate  brand filter resets after navigating to ALL PRODUCTS");
        
        PRODUCTPAGE product = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");

        //Navigate to Products page
        product.btn_Products();
        
        product.clickPoloBrand();
        
        product.btn_Products();

        int productCount = product.getAllProducts().size();
        boolean productsVisible = productCount > 0;

        if (productsVisible) {
            test.pass("All products are displayed successfully, brand filter reset confirmed.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_14"));
        } else {
            test.fail("All products are NOT displayed, brand filter reset failed.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_14 Fail"));
        }
	}
	
	
	//TC.15 To Verify and Validate  product image zoom on detail page
		@Test
		public void Tc_products_15() throws IOException {
			ExtentTest test = extent.createTest("To Verify and Validate  product image zoom on detail page");
	        
	        PRODUCTPAGE product = new PRODUCTPAGE(driver);
	        driver.get("https://automationexercise.com");

	        //Navigate to Products page
	        product.btn_Products();
	        
	        WebElement productImg = product.getFirstProductName();

	        Actions actions = new Actions(driver);
	        actions.moveToElement(productImg).perform();
	        test.info("Hovered over first product image");

	        boolean zoomEffect = productImg.getCssValue("transform").contains("matrix") 
	                             || productImg.getAttribute("style").contains("scale");

	        if (zoomEffect) {
	            test.pass("Product image zoom works correctly without distortion.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_15"));
	        } else {
	            test.fail("Product image zoom did NOT work as expected.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_15 Fail"));
	        }
	    }
	
	
	//TC.16 To Verify and Validate  breadcrumb navigation works
			@Test
			public void Tc_products_16() throws IOException {
				ExtentTest test = extent.createTest("To Verify and Validate  breadcrumb navigation works");
		        
		        PRODUCTPAGE product = new PRODUCTPAGE(driver);
		        driver.get("https://automationexercise.com");

		        //Navigate to Products page
		        product.btn_Products();
		        
		        product.clickBreadcrumbWomen();

		        product.clickBreadcrumbDress();

		        String title = product.getCategoryTitle().getText();
		        boolean correctCategory = title.trim().equalsIgnoreCase("WOMEN - DRESS PRODUCTS");

		        if (correctCategory) {
		            test.pass("Breadcrumb navigation works correctly – Correct category page loads.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_16"));
		        } else {
		            test.fail("Breadcrumb navigation failed – Incorrect category page loaded.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_16 Fail"));
		        }
			}
			
			
			//TC.17 To Verify and Validate filtering products by category
			@Test
			public void Tc_products_17() throws IOException {
				ExtentTest test = extent.createTest("To Verify and Validate filtering products by category");
		        
		        PRODUCTPAGE product = new PRODUCTPAGE(driver);
		        driver.get("https://automationexercise.com");

		        //Navigate to Products page
		        product.btn_Products();
		        
		        product.clickWomenCategory();

		        product.clickDressCategory();

		        String categoryTitle = product.getCategoryTitle().getText();
		        boolean categoryCheck = categoryTitle.trim().equalsIgnoreCase("WOMEN - DRESS PRODUCTS");

		        int productCount = product.getCategoryProducts().size();
		        boolean productCheck = productCount > 0;

		        if (categoryCheck && productCheck) {
		            test.pass("Products by category validated successfully – Only Dress products are shown.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_17"));
		        } else {
		            test.fail("Products by category validation failed – Category title mismatch or products not shown.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_17 Fail"));
		        }
			}
			
	
	//TC.18 To Verify and Validate  filtering products by brand
	@Test
	public void Tc_products_18() throws IOException {
		ExtentTest test = extent.createTest("To Verify and Validate  filtering products by brand");
        
        PRODUCTPAGE product = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");

        //Navigate to Products page
        product.btn_Products();
        
        product.clickPoloBrand();

        String brandTitle = product.getBrandTitle().getText();
        boolean brandCheck = brandTitle.trim().equalsIgnoreCase("BRAND - POLO PRODUCTS");

        int productCount = product.getBrandProducts().size();
        boolean productCheck = productCount > 0;

        if (brandCheck && productCheck) {
            test.pass("Filtering by brand validated successfully – Only Polo products are shown.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_18"));
        } else {
            test.fail("Filtering by brand validation failed – Brand title mismatch or products not shown.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_18 Fail"));
        }
    }
    
	
	//TC.19 To Verify and Validate searching with spaces before/after product name
	@Test
	public void Tc_products_19() throws IOException {
	    ExtentTest test = extent.createTest("To Verify and Validate searching with spaces before/after product name");

	    PRODUCTPAGE product = new PRODUCTPAGE(driver);
	    driver.get("https://automationexercise.com");

	    // Navigate to Products page
	    product.btn_Products();

	    product.searchProduct().clear();
	    	    
	    product.searchProduct().clear();
	    
	    product.searchProduct().sendKeys("       Dress"); 

	    product.clickonSearch();

	    int resultCount = product.getSearchedProducts().size();

	    if (resultCount > 0) {
	        test.pass("Search handled correctly – Products displayed as expected.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_19"));
	    } else {
	        test.fail("Search failed – No products displayed.").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_19 Fail"));
	    }
	}
	
	//TC.20 To Verify and Validate search for product by full exact name
	@Test
	public void Tc_products_20() throws IOException {
		ExtentTest test=extent.createTest("To Verify and Validate search for product by full exact name");
		
		PRODUCTPAGE products = new PRODUCTPAGE(driver);
		driver.get("https://automationexercise.com");
		
		products.btn_Products();
		WebElement search = products.searchProduct();
		search.sendKeys("Blue Top");
		
		products.clickonSearch();
		WebElement prod = products.getFirstProductName();
		if(prod.isDisplayed()) {
			test.pass("Product found").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_20"));       
		}
		else{
			test.pass("Product not found").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_20 Fail"));
		}
		}
		
	
	//TC.21 To verify and validate click products button
		@Test
		public void Tc_products_21() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate click products button");
			
			PRODUCTPAGE products = new PRODUCTPAGE(driver);
			driver.get("https://automationexercise.com");
			
			products.clickOnCartButton();
			
			products.ClickOnhere();
			
			WebElement present = products.All_products();

			if(present.getText().contains("ALL PRODUCTS")) {
				test.pass("User will navigate to ALL PRODUCTS page after clicking on 'here' link in cart page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_21"));
			}
			else {
				test.fail("User will not navigate to ALL PRODUCTS page after clicking on 'here' link in cart page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_21 Fail"));
			}
		}
		
	
	//TC.22 To verify and validate Click 'Continue Shopping' button
		@Test
		public void Tc_products_22() throws IOException {
			ExtentTest test=extent.createTest("To verify and validate Click 'Continue Shopping' button");
			
			PRODUCTPAGE products = new PRODUCTPAGE(driver);
			driver.get("https://automationexercise.com");
			
			products.btn_Products();
			
			products.FirstProductViewProduct();
		      
			products.addFirstproductToCart();
			
			products.clickOnContinue();
	
			 WebElement detailTitle = products.productDetailTitle();
			    
			    if(detailTitle.isDisplayed()) {
			        test.pass("'Continue Shopping' button works properly").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_22"));
			    } else {
			        test.fail("'Continue Shopping' button doesnot works properly").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_22"));
			    }
			}
			
	
	
	
	// TC24. To verify and validate Click 'View Cart' button
    @Test
    public void Tc_products_24() throws IOException {
        ExtentTest test = extent.createTest("To verify and validate Click 'View Cart' button");
        
        PRODUCTPAGE products = new PRODUCTPAGE(driver);
        driver.get("https://automationexercise.com");
        
        products.btn_Products();
       
       products.FirstProductViewProduct();
        
       products.addFirstproductToCart();
       
       products.clickViewCart();
        
        WebElement quantity = products.QuantityCheck();
        
        if(quantity.getText().contains("1")) {
        	test.pass("View cart button works properly").addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC_Ecom_Product_08"));
        }
        
    }
}
	


