package com.automationexercise.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.EcommercePage;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Regression_Core_Business_part2  extends BaseTest {

    @Test
    public void TC21_QuantitySelectionBeforeAddToCart() throws IOException {
        ExtentTest test = extent.createTest("Verify quantity selection before adding to cart");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/product_details/1");
        page.setQuantity("3");
        page.clickAddToCart();

        if (page.verifyCartQuantity("3")) {
            test.pass("Quantity selection successful before add to cart.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC21_QuantitySelectionBeforeAddToCart_pass"));
        } else {
            test.fail("Quantity selection failed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC21_QuantitySelectionBeforeAddToCart_fail"));
        }
    }

    @Test
    public void TC22_FilterByCategory() throws IOException {
        ExtentTest test = extent.createTest("Verify filtering products by category");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");
        page.filterByCategory("Women");

        if (page.isCategoryFilterApplied("Women")) {
            test.pass("Category filter applied correctly.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC22_FilterByCategory_pass"));
        } else {
            test.fail("Category filter not working.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC22_FilterByCategory_fail"));
        }
    }

    @Test
    public void TC23_FilterByBrand() throws IOException {
        ExtentTest test = extent.createTest("Verify filtering products by brand");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");
        page.filterByBrand("H&M");

        if (page.isBrandFilterApplied("H&M")) {
            test.pass("Brand filter applied correctly.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC23_FilterByBrand_pass"));
        } else {
            test.fail("Brand filter not working.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC23_FilterByBrand_fail"));
        }
    }

    @Test
    public void TC24_SearchProductByExactName() throws IOException {
        ExtentTest test = extent.createTest("Verify search by full exact product name");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");
        page.searchProduct().sendKeys("Blue Top");
        page.clickSearchButton();

        if (page.isProductInResults("Blue Top")) {
            test.pass("Exact product found successfully.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC24_SearchProductByExactName_pass"));
        } else {
            test.fail("Exact product not found.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC24_SearchProductByExactName_fail"));
        }
    }

    @Test
    public void TC25_SpecialOfferVisibleOnProductsPage() throws IOException {
        ExtentTest test = extent.createTest("Verify special offer on products page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");

        if (page.isSpecialOfferVisible()) {
            test.pass("Special offer displayed correctly on products page.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC25_SpecialOfferVisibleOnProductsPage_pass"));
        } else {
            test.fail("Special offer missing.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC25_SpecialOfferVisibleOnProductsPage_fail"));
        }
    }

    @Test
    public void TC26_CategoriesOnProductsPage() throws IOException {
        ExtentTest test = extent.createTest("Verify categories (Women, Men, Kids) on products page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");

        if (page.areCategoriesVisible()) {
            test.pass("Categories visible on products page.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_CategoriesOnProductsPage_pass"));
        } else {
            test.fail("Categories missing on products page.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_CategoriesOnProductsPage_fail"));
        }
    }

    @Test
    public void TC27_BrandsOnProductsPage() throws IOException {
        ExtentTest test = extent.createTest("Verify brands on products page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");

        if (page.areBrandsVisible()) {
            test.pass("Brands displayed on products page.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_BrandsOnProductsPage_pass"));
        } else {
            test.fail("Brands missing on products page.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_BrandsOnProductsPage_fail"));
        }
    }

    @Test
    public void TC28_NumberOfItemsUnderEachBrand() throws IOException {
        ExtentTest test = extent.createTest("Verify number of items under each brand");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");

        if (page.isBrandCountDisplayedCorrectly()) {
            test.pass("Brand item counts displayed correctly.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_NumberOfItemsUnderEachBrand_pass"));
        } else {
            test.fail("Brand item counts incorrect.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_NumberOfItemsUnderEachBrand_fail"));
        }
    }

    @Test
    public void TC29_AllProductsDisplayedOnProductsPage() throws IOException {
        ExtentTest test = extent.createTest("Verify all products are displayed on products page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");

        if (page.areAllProductsVisible()) {
            test.pass("All products displayed successfully.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_AllProductsDisplayedOnProductsPage_pass"));
        } else {
            test.fail("Some products missing on products page.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_AllProductsDisplayedOnProductsPage_fail"));
        }
    }

    @Test
    public void TC30_ProductTypeDisplayedOnProductsPage() throws IOException {
        ExtentTest test = extent.createTest("Verify product type displayed on products page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");

        if (page.isProductTypeVisible()) {
            test.pass("Product type/name displayed correctly.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_ProductTypeDisplayedOnProductsPage_pass"));
        } else {
            test.fail("Product type/name missing.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_ProductTypeDisplayedOnProductsPage_fail"));
        }
    }

    @Test
    public void TC31_ProductHoverEffectOnProductsPage() throws IOException {
        ExtentTest test = extent.createTest("Verify hover effect on products page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");

        if (page.isHoverEffectWorking()) {
            test.pass("Hover effect working correctly on products.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_ProductHoverEffectOnProductsPage_pass"));
        } else {
            test.fail("Hover effect not working.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_ProductHoverEffectOnProductsPage_fail"));
        }
    }

    @Test
    public void TC32_ProductCostDisplayedOnProductsPage() throws IOException {
        ExtentTest test = extent.createTest("Verify product cost is displayed on products page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");

        if (page.isProductCostVisible()) {
            test.pass("Product cost displayed correctly.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_ProductCostDisplayedOnProductsPage_pass"));
        } else {
            test.fail("Product cost missing.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_ProductCostDisplayedOnProductsPage_fail"));
        }
    }

    @Test
    public void TC33_ProductNameDisplayedOnProductsPage() throws IOException {
        ExtentTest test = extent.createTest("Verify product name is displayed on products page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");

        if (page.isProductNameVisible()) {
            test.pass("Product name displayed correctly.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_ProductNameDisplayedOnProductsPage_pass"));
        } else {
            test.fail("Product name missing.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_ProductNameDisplayedOnProductsPage_fail"));
        }
    }

    @Test
    public void TC34_AddToCartIconOnProductsPage() throws IOException {
        ExtentTest test = extent.createTest("Verify add to cart icon on products page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");

        if (page.isAddToCartIconVisible()) {
            test.pass("Add to cart icon displayed successfully.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_AddToCartIconOnProductsPage_pass"));
        } else {
            test.fail("Add to cart icon missing.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_AddToCartIconOnProductsPage_fail"));
        }
    }

    @Test
    public void TC35_ViewProductButtonOnProductsPage() throws IOException {
        ExtentTest test = extent.createTest("Verify view product button on products page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");

        if (page.isViewProductButtonWorking()) {
            test.pass("View product button working correctly.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_ViewProductButtonOnProductsPage_pass"));
        } else {
            test.fail("View product button not working.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_ViewProductButtonOnProductsPage_fail"));
        }
    }

    @Test
    public void TC36_NavigationToCartFromHome() throws IOException {
        ExtentTest test = extent.createTest("Verify navigation to cart page from home page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com");
        page.clickCart();

        if (driver.getCurrentUrl().contains("view_cart")) {
            test.pass("Cart page opened successfully.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_NavigationToCartFromHome_pass"));
        } else {
            test.fail("Cart page navigation failed.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_NavigationToCartFromHome_fail"));
        }
    }

    @Test
    public void TC37_AddProductToCart() throws IOException {
        ExtentTest test = extent.createTest("Verify adding a product to cart and checking it in cart page");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");
        page.clickFirstProductAddToCart();
        page.clickCart();

        if (page.isProductInCart()) {
            test.pass("Product added to cart successfully.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_AddProductToCart_pass"));
        } else {
            test.fail("Product not added to cart.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_AddProductToCart_fail"));
        }
    }

    @Test
    public void TC38_ProductPriceInCart() throws IOException {
        ExtentTest test = extent.createTest("Verify product price in cart");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");
        page.clickFirstProductAddToCart();
        page.clickCart();

        if (page.isCartProductPriceCorrect()) {
            test.pass("Product price displayed correctly in cart.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_ProductPriceInCart_pass"));
        } else {
            test.fail("Product price incorrect in cart.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_ProductPriceInCart_fail"));
        }
    }

    @Test
    public void TC39_TotalPriceInCart() throws IOException {
        ExtentTest test = extent.createTest("Verify total price of products in cart");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");
        page.addMultipleProductsToCart();
        page.clickCart();

        if (page.isTotalPriceCorrect()) {
            test.pass("Total price calculated correctly in cart.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_TotalPriceInCart_pass"));
        } else {
            test.fail("Total price incorrect in cart.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_TotalPriceInCart_fail"));
        }
    }

    @Test
    public void TC40_RemoveItemFromCart() throws IOException {
        ExtentTest test = extent.createTest("Verify removing an item from the cart");
        EcommercePage page = new EcommercePage(driver);

        driver.get("https://automationexercise.com/products");
        page.clickFirstProductAddToCart();
        page.clickCart();
        page.removeFirstItemFromCart();

        if (!page.isProductInCart()) {
            test.pass("Item removed from cart successfully.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_RemoveItemFromCart_pass"));
        } else {
            test.fail("Item not removed from cart.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_RemoveItemFromCart_fail"));
        }
    }
}
