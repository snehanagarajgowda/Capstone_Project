package com.automationexercise.tests;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.EcommercePage;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

import org.testng.annotations.Test;

public class TC_Ecom_Regression_Core_Business_part1  extends BaseTest {

    //TC01
    @Test
    public void TC01_VerifyLoginSignupButtonRedirect() throws IOException {
        ExtentTest test = extent.createTest("TC01 - Verify Login/Signup button opens register/login page");
        
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        
        page.clickLoginSignup();
        if (driver.getCurrentUrl().contains("login")) {
            test.pass("Login/Signup button redirected correctly.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC01_VerifyLoginSignupButtonRedirect_pass"));
        } else {
            test.fail("Login/Signup button did not redirect.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC01_VerifyLoginSignupButtonRedirect_fail"));
        }
    }

    @Test
    public void TC02_VerifyInvalidLoginShowsErrorMessage() throws IOException {
        ExtentTest test = extent.createTest("TC02 - Verify invalid login shows error message");
        
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        
        page.clickLoginSignup();
        page.enterEmail("wrong@mail.com");
        page.enterPassword("wrongpass");
        page.clickLogin();
        String msg = page.getErrorMsgInvalidLogin();
        if (msg.contains("incorrect")) {
            test.pass("Invalid login error displayed correctly.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02_VerifyInvalidLoginShowsErrorMessage_pass"));
        } else {
            test.fail("Invalid login error not displayed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC02_VerifyInvalidLoginShowsErrorMessage_fail"));
        }
    }

    @Test
    public void TC03_VerifyEmailPasswordPlaceholders() throws IOException {
        ExtentTest test = extent.createTest("TC03 - Verify placeholders in email & password fields");
        
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        
        page.clickLoginSignup();
        String emailPh = page.getPlaceholderEmail();
        String passPh = page.getPlaceholderPassword();
        if (emailPh.equals("Email Address") && passPh.equals("Password")) {
            test.pass("Placeholders are correct.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_VerifyEmailPasswordPlaceholders_pass"));
        } else {
            test.fail("Placeholders are incorrect.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC03_VerifyEmailPasswordPlaceholders_fail"));
        }
    }

    @Test
    public void TC04_VerifyHomePageTitle() throws IOException {
        ExtentTest test = extent.createTest("TC04 - Verify home page title is correct");
        
        driver.get("https://automationexercise.com");
        String title = driver.getTitle();
        if (title.contains("Automation Exercise")) {
            test.pass("Home page title is correct.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_VerifyHomePageTitle_pass"));
        } else {
            test.fail("Home page title mismatch.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC04_VerifyHomePageTitle_fail"));
        }
    }

    @Test
    public void TC05_VerifyTabOrderOnLoginPage() throws IOException {
        ExtentTest test = extent.createTest("TC05 - Verify tab order on login page");
        
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        
        page.clickLoginSignup();
        String attr = driver.findElement(page.tabOrderEmail).getAttribute("tabindex");
        if (attr != null) {
            test.pass("Tab order present.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_VerifyTabOrderOnLoginPage_pass"));
        } else {
            test.fail("Tab order missing.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC05_VerifyTabOrderOnLoginPage_fail"));
        }
    }

    @Test
    public void TC06_VerifyAllProductsPageLoads() throws IOException {
        ExtentTest test = extent.createTest("TC06 - Verify all products page loads");
        
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        
        page.clickProducts();
        if (driver.getPageSource().contains("All Products")) {
            test.pass("All Products page loaded successfully.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_VerifyAllProductsPageLoads_pass"));
        } else {
            test.fail("Failed to load All Products page.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC06_VerifyAllProductsPageLoads_fail"));
        }
    }

    @Test
    public void TC07_VerifySearchProductFunctionality() throws IOException {
        ExtentTest test = extent.createTest("TC07 - Verify search product works");
        
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        
        page.clickProducts();
        page.searchProduct("Dress");
        page.clickSearch();
        if (page.getSearchedProducts().size() > 0) {
            test.pass("Products displayed for search.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07_VerifySearchProductFunctionality_pass"));
        } else {
            test.fail("No products displayed for search.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC07_VerifySearchProductFunctionality_fail"));
        }
    }

    @Test
    public void TC08_VerifySearchProductWithSpaces() throws IOException {
        ExtentTest test = extent.createTest("TC08 - Verify search handles spaces");
        
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        
        page.clickProducts();
        page.searchProduct("      Dress    ");
        page.clickSearch();
        if (page.getSearchedProducts().size() > 0) {
            test.pass("Search with spaces works.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_VerifySearchProductWithSpaces_pass"));
        } else {
            test.fail("Search with spaces failed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC08_VerifySearchProductWithSpaces_fail"));
        }
    }

    @Test
    public void TC09_VerifyViewProductFromList() throws IOException {
        ExtentTest test = extent.createTest("TC09 - Verify view product works");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        page.clickProducts();
        page.clickViewProduct();
        if (page.getProductDescription().length() > 0) {
            test.pass("Product detail page opened.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_VerifyViewProductFromList_pass"));
        } else {
            test.fail("Product detail page not opened.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC09_VerifyViewProductFromList_fail"));
        }
    }

    @Test
    public void TC10_VerifyQuantitySelection() throws IOException {
        ExtentTest test = extent.createTest("TC10 - Verify quantity selection works");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        page.clickProducts();
        page.clickViewProduct();
        page.setQuantity("3");
        page.clickAddToCart();
        page.clickCart();
        if (page.getCartRows().size() > 0) {
            test.pass("Quantity selection successful.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10_VerifyQuantitySelection_pass"));
        } else {
            test.fail("Quantity selection failed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC10_VerifyQuantitySelection_fail"));
        }
    }

    @Test
    public void TC11_VerifyAddToCartFromProductList() throws IOException {
        ExtentTest test = extent.createTest("TC11 - Verify add to cart from list");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        page.clickProducts();
        page.clickAddToCart();
        page.clickCart();
        if (page.getCartRows().size() > 0) {
            test.pass("Add to cart from list successful.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_VerifyAddToCartFromProductList_pass"));
        } else {
            test.fail("Add to cart from list failed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_VerifyAddToCartFromProductList_fail"));
        }
    }

    @Test
    public void TC12_VerifyCartPageLoads() throws IOException {
        ExtentTest test = extent.createTest("TC12 - Verify cart page loads");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        page.clickCart();
        if (driver.getPageSource().contains("Shopping Cart")) {
            test.pass("Cart page loaded.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12_VerifyCartPageLoads_pass"));
        } else {
            test.fail("Cart page not loaded.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12_VerifyCartPageLoads_fail"));
        }
    }

    @Test
    public void TC13_VerifyRemoveFromCart() throws IOException {
        ExtentTest test = extent.createTest("TC13 - Verify remove from cart works");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        page.clickProducts();
        page.clickAddToCart();
        page.clickCart();
        driver.findElement(page.removeFromCart).click();
        if (page.getCartRows().size() == 0) {
            test.pass("Remove from cart successful.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13_VerifyRemoveFromCart_pass"));
        } else {
            test.fail("Remove from cart failed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13_VerifyRemoveFromCart_fail"));
        }
    }

    @Test
    public void TC14_VerifyCartTotalPriceDisplayed() throws IOException {
        ExtentTest test = extent.createTest("TC14 - Verify cart total price");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        page.clickProducts();
        page.clickAddToCart();
        page.clickCart();
        if (driver.findElement(page.cartTotalPrice).isDisplayed()) {
            test.pass("Total price displayed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14_VerifyCartTotalPriceDisplayed_pass"));
        } else {
            test.fail("Total price not displayed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14_VerifyCartTotalPriceDisplayed_fail"));
        }
    }

    @Test
    public void TC15_VerifyProceedToCheckoutButton() throws IOException {
        ExtentTest test = extent.createTest("TC15 - Verify proceed to checkout works");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        page.clickProducts();
        page.clickAddToCart();
        page.clickCart();
        page.clickProceedToCheckout();
        if (driver.getCurrentUrl().contains("checkout")) {
            test.pass("Proceed to checkout works.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC15_VerifyProceedToCheckoutButton_pass"));
        } else {
            test.fail("Proceed to checkout failed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC15_VerifyProceedToCheckoutButton_fail"));
        }
    }

    @Test
    public void TC16_VerifyCategoryListVisible() throws IOException {
        ExtentTest test = extent.createTest("TC16 - Verify category list visible");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        if (page.getCategoryList().size() > 0) {
            test.pass("Category list visible.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16_VerifyCategoryListVisible_pass"));
        } else {
            test.fail("Category list not visible.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16_VerifyCategoryListVisible_fail"));
        }
    }

    @Test
    public void TC17_VerifySelectCategoryLoadsProducts() throws IOException {
        ExtentTest test = extent.createTest("TC17 - Verify category selection works");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        driver.findElement(page.categoryWomenDress).click();
        if (page.getSearchedProducts().size() > 0) {
            test.pass("Products loaded for category.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17_VerifySelectCategoryLoadsProducts_pass"));
        } else {
            test.fail("Category products not loaded.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17_VerifySelectCategoryLoadsProducts_fail"));
        }
    }

    @Test
    public void TC18_VerifyFilterByBrand() throws IOException {
        ExtentTest test = extent.createTest("TC18 - Verify filtering by brand works");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        driver.findElement(page.brandPolo).click();
        if (page.getSearchedProducts().size() > 0) {
            test.pass("Brand filtering works.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC18_VerifyFilterByBrand_pass"));
        } else {
            test.fail("Brand filtering failed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC18_VerifyFilterByBrand_fail"));
        }
    }

    @Test
    public void TC19_VerifyBrandListVisible() throws IOException {
        ExtentTest test = extent.createTest("TC19 - Verify brand list visible");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        if (page.getBrandList().size() > 0) {
            test.pass("Brand list visible.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC19_VerifyBrandListVisible_pass"));
        } else {
            test.fail("Brand list not visible.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC19_VerifyBrandListVisible_fail"));
        }
    }

    @Test
    public void TC20_VerifyContactUsPageLoads() throws IOException {
        ExtentTest test = extent.createTest("TC20 - Verify Contact Us page loads");
        EcommercePage page = new EcommercePage(driver);
        driver.get("https://automationexercise.com");
        driver.findElement(page.btnContactUs).click();
        if (driver.getPageSource().contains("Get In Touch")) {
            test.pass("Contact Us page loaded.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC20_VerifyContactUsPageLoads_pass"));
        } else {
            test.fail("Contact Us page not loaded.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC20_VerifyContactUsPageLoads_fail"));
        }
    }
}
