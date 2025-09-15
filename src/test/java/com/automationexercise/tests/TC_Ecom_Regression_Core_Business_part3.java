package com.automationexercise.tests;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.EcommercePage;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

import org.testng.annotations.Test;

	public class TC_Ecom_Regression_Core_Business_part3 extends BaseTest {

		    @Test
		    public void TC41_VerifyAddingMultipleDistinctItemsToCart() throws IOException {
		        ExtentTest test = extent.createTest("TC41 - Verify adding multiple distinct items to cart");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        page.clickProducts();
		        test.info("Products page opened");

		        page.clickAddToCart();            
		        test.info("Added first product to cart");

		        driver.navigate().refresh();      
		        page.clickAddToCart();            
		        test.info("Added second product to cart");

		        page.clickCart();
		        int rows = page.getCartRows().size();

		        if (rows >= 2) {
		            test.pass("Multiple distinct items added successfully.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC41_pass"));
		        } else {
		            test.fail("Failed to add multiple distinct items to cart.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC41_fail"));
		        }
		    }

		    @Test
		    public void TC42_VerifyProceedToCheckoutForGuest() throws IOException {
		        ExtentTest test = extent.createTest("TC42 - Verify 'Proceed To Checkout' for guest user");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        page.clickProducts();
		        page.clickAddToCart();
		        page.clickCart();
		        page.clickProceedToCheckout();
		        test.info("Clicked Proceed To Checkout as guest");

		        boolean modalOrRedirect = page.isLoginOrRegisterPromptVisible();

		        if (modalOrRedirect) {
		            test.pass("Guest is prompted to register/login before checkout (expected).")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC42_pass"));
		        } else {
		            test.fail("Guest checkout flow did not prompt for login/register.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC42_fail"));
		        }
		    }

		    @Test
		    public void TC43_VerifyProceedToCheckoutForLoggedInUser() throws IOException {
		        ExtentTest test = extent.createTest("TC43 - Verify 'Proceed To Checkout' for logged-in user");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        page.login("valid@mail.com", "validpass");
		        test.info("Logged in with valid credentials");

		        page.clickProducts();
		        page.clickAddToCart();
		        page.clickCart();
		        page.clickProceedToCheckout();
		        test.info("Proceeded to checkout");

		        boolean onCheckout = driver.getCurrentUrl().toLowerCase().contains("checkout");
		        if (onCheckout) {
		            test.pass("Logged-in user navigated to checkout page successfully.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC43_pass"));
		        } else {
		            test.fail("Logged-in user did not navigate to checkout page.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC43_fail"));
		        }
		    }

		    @Test
		    public void TC44_VerifyAddingSameProductUpdatesQuantity() throws IOException {
		        ExtentTest test = extent.createTest("TC44 - Verify adding same product again updates quantity");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        page.clickProducts();
		        page.clickAddToCart();   
		        page.clickContinueShopping(); 
		        page.clickAddToCart();   
		        page.clickCart();

		        String quantity = page.getCartQuantityForProduct(1);
		        if ("2".equals(quantity)) {
		            test.pass("Quantity updated to 2 after adding same product twice.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC44_pass"));
		        } else {
		            test.fail("Quantity did not update correctly. Found: " + quantity)
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC44_fail"));
		        }
		    }

		    @Test
		    public void TC45_VerifyCheckoutProcessForRegisteredUser() throws IOException {
		        ExtentTest test = extent.createTest("TC45 - Verify checkout for registered user after filling details");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        page.login("valid@mail.com", "validpass");
		        test.info("Logged in");

		        page.clickProducts();
		        page.clickAddToCart();
		        page.clickCart();
		        page.clickProceedToCheckout();

		        page.fillCheckoutAddress("John", "Doe", "123 Test St", "City", "State", "12345", "Country");
		        page.enterOrderComment("Please deliver between 9am-5pm");
		        page.clickPlaceOrder();
		        test.info("Placed order from checkout");

		        boolean onPayment = driver.getCurrentUrl().toLowerCase().contains("payment");
		        if (onPayment) {
		            test.pass("Checkout proceeded to payment page for registered user.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC45_pass"));
		        } else {
		            test.fail("Checkout did not proceed to payment page.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC45_fail"));
		        }
		    }

		    @Test
		    public void TC46_VerifyNavigationToHomePage() throws IOException {
		        ExtentTest test = extent.createTest("TC46 - Verify navigation to home page");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        page.clickHome();
		        test.info("Clicked home");

		        boolean homeVisible = driver.getTitle().toLowerCase().contains("automation exercise");
		        if (homeVisible) {
		            test.pass("Navigated to home page successfully.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC46_pass"));
		        } else {
		            test.fail("Navigation to home page failed.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC46_fail"));
		        }
		    }

		    @Test
		    public void TC47_VerifyCategoriesOnHomePage() throws IOException {
		        ExtentTest test = extent.createTest("TC47 - Verify categories visible on home page");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        int categories = page.getCategoryList().size();

		        if (categories > 0) {
		            test.pass("Categories visible on home page.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC47_pass"));
		        } else {
		            test.fail("Categories not visible on home page.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC47_fail"));
		        }
		    }

		    @Test
		    public void TC48_VerifyBrandsOnHomePage() throws IOException {
		        ExtentTest test = extent.createTest("TC48 - Verify brands visible on home page");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        int brands = page.getBrandList().size();

		        if (brands > 0) {
		            test.pass("Brands visible on home page.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC48_pass"));
		        } else {
		            test.fail("Brands not visible on home page.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC48_fail"));
		        }
		    }

		    @Test
		    public void TC49_VerifyFeatureItemsVisible() throws IOException {
		        ExtentTest test = extent.createTest("TC49 - Verify feature items visible on home page");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        page.scrollToFeatureItems();
		        int features = page.getFeatureItems().size();

		        if (features > 0) {
		            test.pass("Feature items visible.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC49_pass"));
		        } else {
		            test.fail("Feature items not visible.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC49_fail"));
		        }
		    }

		    @Test
		    public void TC50_VerifyAddToCartIconOnHomePage() throws IOException {
		        ExtentTest test = extent.createTest("TC50 - Verify Add to cart icon on home page");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        page.clickAddToCartFromHome(1);
		        page.clickCart();

		        if (page.getCartRows().size() > 0) {
		            test.pass("Add to cart from home page works.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC50_pass"));
		        } else {
		            test.fail("Add to cart from home page failed.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC50_fail"));
		        }
		    }

		    @Test
		    public void TC51_VerifyPriceVisibleUnderProductOnHomePage() throws IOException {
		        ExtentTest test = extent.createTest("TC51 - Verify price visible under product on home page");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        boolean priceVisible = page.isPriceVisibleForHomeProduct(1);

		        if (priceVisible) {
		            test.pass("Price is visible under product on home page.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC51_pass"));
		        } else {
		            test.fail("Price not visible under product on home page.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC51_fail"));
		        }
		    }

		    @Test
		    public void TC52_VerifyViewProductDisplayedUnderProductOnHomePage() throws IOException {
		        ExtentTest test = extent.createTest("TC52 - Verify 'View Product' displayed under product on home page");
		        EcommercePage page = new EcommercePage(driver);

		        driver.get("https://automationexercise.com");
		        boolean viewDisplayed = page.isViewProductVisibleOnHome(1);

		        if (viewDisplayed) {
		            test.pass("View Product displayed under product on home page.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC52_pass"));
		        } else {
		            test.fail("View Product not displayed under product on home page.")
		                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC52_fail"));
		        }
		    }
		}

