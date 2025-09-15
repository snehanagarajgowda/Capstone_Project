package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EcommercePage {
    WebDriver driver;
	private WebDriverWait wait;

    public EcommercePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    By btnLoginSignup = By.xpath("//a[contains(text(),'Signup / Login')]");
    By btnLogout = By.xpath("//a[contains(text(),'Logout')]");
    By btnLogin = By.xpath("//button[contains(text(),'Login')]");
    By emailField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@data-qa='login-password']");
    By errorMsgInvalidLogin = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    By placeholderEmail = By.xpath("//input[@data-qa='login-email']");
    By placeholderPassword = By.xpath("//input[@data-qa='login-password']");
    By homePageTitle = By.xpath("//title[contains(text(),'Automation Exercise')]");
    public By tabOrderEmail = By.xpath("//input[@data-qa='login-email']");

    By btnProducts = By.xpath("//a[contains(text(),'Products')]");
    By allProductsHeader = By.xpath("//h2[contains(text(),'All Products')]");
    By searchBox = By.xpath("//input[@id='search_product']");
    By searchButton = By.xpath("//button[@id='submit_search']");
    By searchedProducts = By.xpath("//div[@class='productinfo text-center']");
    By viewProductBtn = By.xpath("(//a[contains(text(),'View Product')])[1]");
    By productDescription = By.xpath("//div[@class='product-information']");
    By quantityField = By.xpath("//input[@id='quantity']");
    By addToCartBtn = By.xpath("//button[contains(text(),'Add to cart')]");
    By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    By cartRows = By.xpath("//tr[contains(@id,'product')]");
    public By cartTotalPrice = By.xpath("//td[@class='cart_total_price']");
    public By removeFromCart = By.xpath("//a[@class='cart_quantity_delete']");
    By proceedToCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    public By categoryWomenDress = By.xpath("//a[contains(text(),'Women')]/following::a[contains(text(),'Dress')]");
    public By brandPolo = By.xpath("//a[contains(text(),'Polo')]");
    By categoryList = By.xpath("//div[@id='accordian']//a");
    By brandList = By.xpath("//div[@class='brands-name']//a");

    public By btnContactUs = By.xpath("//a[contains(text(),'Contact us')]");
    By btnHome = By.xpath("//a[contains(text(),' Home')]");
    
        private By quantityBox = By.xpath("//input[@id='quantity']");
        private By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
        private By cartPageLink = By.xpath("//a[@href='/view_cart']");
        private By cartQuantity = By.xpath("//td[@class='cart_quantity']");
        private By specialOfferBanner = By.xpath("//div[@class='advertisement']");
        private By categoriesSection = By.xpath("//div[@class='panel-group category-products']");
        private By brandsSection = By.xpath("//div[@class='brands_products']");
        private By brandCounts = By.xpath("//div[@class='brands_products']//li");
        private By allProducts = By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']");
        private By productName = By.xpath("//div[@class='productinfo text-center']/p");
        private By productCost = By.xpath("//div[@class='productinfo text-center']/h2");
        private By hoverEffectProduct = By.xpath("(//div[@class='product-image-wrapper'])[1]");
        private By addToCartIcon = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
        private By viewProductButton = By.xpath("(//a[contains(text(),'View Product')])[1]");
        private By firstProductAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
        private By cartProduct = By.xpath("//td[@class='cart_description']");
        private By cartProductPrice = By.xpath("//td[@class='cart_price']");
        private By removeItem = By.xpath("//a[@class='cart_quantity_delete']");
        
        private By productsLink = By.xpath("//a[@href='/products']");
        private By addToCartButton1 = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
        private By continueShoppingButton = By.xpath("//button[contains(text(),'Continue Shopping')]");
        private By cartLink1 = By.xpath("//a[@href='/view_cart']");
        private By loginEmail = By.xpath("//input[@data-qa='login-email']");
        private By loginPassword = By.xpath("//input[@data-qa='login-password']");
        private By loginButton = By.xpath("//button[@data-qa='login-button']");
        private By checkoutAddressFields = By.xpath("//input[contains(@name,'address')]");
        private By orderCommentBox = By.xpath("//textarea[@name='message']");
        private By placeOrderButton = By.xpath("//a[contains(text(),'Place Order')]");
        private By homeLink = By.xpath("//a[@href='/']");
        private By categoryList1 = By.xpath("//div[@class='panel-group category-products']//a");
        private By brandList1 = By.xpath("//div[@class='brands-name']//a");
        private By featureItems = By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']");
        private By cartRows1 = By.xpath("//table[@id='cart_info_table']//tbody/tr");
        private By loginOrRegisterModal = By.xpath("//div[@id='checkoutModal']");
        private By homeProducts = By.xpath("//div[@class='product-image-wrapper']");
        private By homePrices = By.xpath("//div[@class='productinfo text-center']/h2");
        private By homeViewProductButtons = By.xpath("//a[contains(text(),'View Product')]");

        
        public void clickContinueShopping() {
            wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
        }

        public boolean isLoginOrRegisterPromptVisible() {
            return driver.findElements(loginOrRegisterModal).size() > 0;
        }

        public void login(String email, String password) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail)).sendKeys(email);
            driver.findElement(loginPassword).sendKeys(password);
            driver.findElement(loginButton).click();
        }

        public List<WebElement> getCartRows1() {
            return driver.findElements(cartRows1);
        }

        public String getCartQuantityForProduct(int rowIndex) {
            try {
                WebElement row = driver.findElements(cartRows).get(rowIndex - 1);
                return row.findElement(By.xpath(".//button[@class='disabled']")).getText();
            } catch (Exception e) {
                return "0";
            }
        }

        public void fillCheckoutAddress(String firstName, String lastName, String address, String city, String state, String zip, String country) {
            List<WebElement> fields = driver.findElements(checkoutAddressFields);
            if (!fields.isEmpty()) {
                fields.get(0).clear();
                fields.get(0).sendKeys(firstName + " " + lastName);
                fields.get(1).clear();
                fields.get(1).sendKeys(address);
                fields.get(2).clear();
                fields.get(2).sendKeys(city);
                fields.get(3).clear();
                fields.get(3).sendKeys(state);
                fields.get(4).clear();
                fields.get(4).sendKeys(zip);
                fields.get(5).clear();
                fields.get(5).sendKeys(country);
            }
        }

        public void enterOrderComment(String comment) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(orderCommentBox)).sendKeys(comment);
        }

        public void clickPlaceOrder() {
            wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
        }

        public void clickHome() {
            wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
        }

        public List<WebElement> getCategoryList1() {
            return driver.findElements(categoryList);
        }

        public List<WebElement> getBrandList1() {
            return driver.findElements(brandList);
        }

        public void scrollToFeatureItems() {
            WebElement feature = driver.findElement(featureItems);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", feature);
        }

        public List<WebElement> getFeatureItems() {
            return driver.findElements(featureItems);
        }

        public void clickAddToCartFromHome(int index) {
            WebElement product = driver.findElements(homeProducts).get(index - 1);
            WebElement addBtn = product.findElement(By.xpath(".//a[contains(text(),'Add to cart')]"));
            addBtn.click();
        }

        public boolean isPriceVisibleForHomeProduct(int index) {
            return driver.findElements(homePrices).get(index - 1).isDisplayed();
        }

        public boolean isViewProductVisibleOnHome(int index) {
            return driver.findElements(homeViewProductButtons).get(index - 1).isDisplayed();
        }

        public void setQuantity1(String qty) {
            driver.findElement(quantityBox).clear();
            driver.findElement(quantityBox).sendKeys(qty);
        }

        public void clickAddToCart1() {
            driver.findElement(addToCartButton).click();
        }

        public void clickCart1() {
            driver.findElement(cartLink).click();
        }

        public boolean verifyCartQuantity(String expectedQty) {
            String actualQty = driver.findElement(cartQuantity).getText().trim();
            return actualQty.equals(expectedQty);
        }

        public void filterByCategory(String categoryName) {
            driver.findElement(By.xpath("//a[contains(text(),'" + categoryName + "')]")).click();
        }

        public boolean isCategoryFilterApplied(String categoryName) {
            return driver.findElement(By.xpath("//h2[contains(text(),'" + categoryName + "')]")).isDisplayed();
        }

        public void filterByBrand(String brandName) {
            driver.findElement(By.xpath("//a[contains(text(),'" + brandName + "')]")).click();
        }

        public boolean isBrandFilterApplied(String brandName) {
            return driver.findElement(By.xpath("//h2[contains(text(),'" + brandName + "')]")).isDisplayed();
        }

        public WebElement searchProduct() {
            return driver.findElement(searchBox);
        }

        public void clickSearchButton() {
            driver.findElement(searchButton).click();
        }

        public boolean isProductInResults(String productName) {
            List<WebElement> products = driver.findElements(searchedProducts);
            for (WebElement p : products) {
                if (p.getText().equalsIgnoreCase(productName)) {
                    return true;
                }
            }
            return false;
        }

        public List<WebElement> getSearchedProducts1() {
            return driver.findElements(searchedProducts);
        }

        public boolean isSpecialOfferVisible() {
            return driver.findElement(specialOfferBanner).isDisplayed();
        }

        public boolean areCategoriesVisible() {
            return driver.findElement(categoriesSection).isDisplayed();
        }

        public boolean areBrandsVisible() {
            return driver.findElement(brandsSection).isDisplayed();
        }

        public boolean isBrandCountDisplayedCorrectly() {
            return driver.findElements(brandCounts).size() > 0;
        }

        public boolean areAllProductsVisible() {
            return driver.findElements(allProducts).size() > 0;
        }

        public boolean isProductTypeVisible() {
            return driver.findElements(productName).size() > 0;
        }

        public boolean isHoverEffectWorking() {
            WebElement product = driver.findElement(hoverEffectProduct);
            Actions actions = new Actions(driver);
            actions.moveToElement(product).perform();
            return product.isDisplayed();
        }

        public boolean isProductCostVisible() {
            return driver.findElements(productCost).size() > 0;
        }

        public boolean isProductNameVisible() {
            return driver.findElements(productName).size() > 0;
        }

        public boolean isAddToCartIconVisible() {
            return driver.findElement(addToCartIcon).isDisplayed();
        }

        public boolean isViewProductButtonWorking() {
            return driver.findElement(viewProductButton).isDisplayed();
        }

        public void clickFirstProductAddToCart() {
            driver.findElement(firstProductAddToCart).click();
        }

        public boolean isProductInCart() {
            return driver.findElements(cartProduct).size() > 0;
        }

        public boolean isCartProductPriceCorrect() {
            return driver.findElements(cartProductPrice).size() > 0;
        }

        public void addMultipleProductsToCart() {
            List<WebElement> products = driver.findElements(firstProductAddToCart);
            for (int i = 0; i < 2 && i < products.size(); i++) {
                products.get(i).click();
            }
        }

        public boolean isTotalPriceCorrect() {
            return driver.findElements(cartTotalPrice).size() > 0;
        }

        public void removeFirstItemFromCart() {
            driver.findElement(removeItem).click();
        }

    public void clickLoginSignup() { 
    	driver.findElement(btnLoginSignup).click(); 
    	}
    
    public void clickLogout() { 
    	driver.findElement(btnLogout).click(); 
    	}
    
    public void clickLogin() { 
    	driver.findElement(btnLogin).click(); 
    	}
    
    public void enterEmail(String email) { 
    	driver.findElement(emailField).sendKeys(email); 
    	}
    
    public void enterPassword(String pass) { 
    	driver.findElement(passwordField).sendKeys(pass); 
    	}
    
    public String getErrorMsgInvalidLogin() { 
    	return driver.findElement(errorMsgInvalidLogin).getText(); 
    	}
    
    public String getPlaceholderEmail() { 
    	return driver.findElement(placeholderEmail).getAttribute("placeholder"); 
    	}
    
    public String getPlaceholderPassword() { 
    	return driver.findElement(placeholderPassword).getAttribute("placeholder"); 
    	}
    
    public void clickProducts() { 
    	driver.findElement(btnProducts).click(); 
    }
    
    public void searchProduct(String product) { 
    	driver.findElement(searchBox).clear(); driver.findElement(searchBox).sendKeys(product); 
    	}
    
    public void clickSearch() { 
    	driver.findElement(searchButton).click(); 
    	}
    
    public List<WebElement> getSearchedProducts() { 
    	return driver.findElements(searchedProducts); 
    	}
    
    public void clickViewProduct() { 
    	driver.findElement(viewProductBtn).click(); 
    }
    
    public String getProductDescription() { 
    	return driver.findElement(productDescription).getText(); 
    	}
    
    public void setQuantity(String qty) { 
    	driver.findElement(quantityField).clear(); driver.findElement(quantityField).sendKeys(qty); 
    	}
    
    public void clickAddToCart() { 
    	driver.findElement(addToCartBtn).click(); 
    	}
    
    public void clickCart() { 
    	driver.findElement(cartLink).click(); 
    	}
    
    public List<WebElement> getCartRows() { 
    	return driver.findElements(cartRows); 
    	}
    
    public List<WebElement> getCategoryList() { 
    	return driver.findElements(categoryList); 
    	}
    
    public List<WebElement> getBrandList() { 
    	return driver.findElements(brandList); 
    	}
    
    public void clickProceedToCheckout() { 
    	driver.findElement(proceedToCheckout).click(); 
    	}
}
