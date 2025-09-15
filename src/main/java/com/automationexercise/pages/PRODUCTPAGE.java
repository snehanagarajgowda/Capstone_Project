package com.automationexercise.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PRODUCTPAGE {
	
	WebDriver driver;
	public PRODUCTPAGE(WebDriver driver) {
		this.driver = driver;
	}
	
	By btn_products = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
	By searchBox = By.xpath("//*[@id=\"search_product\"]");
	By searchButton = By.xpath("//*[@id=\"submit_search\"]");
	By first_view_product = By.xpath(("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a"));
	By productDetailTitle = By.xpath("//div[@class='product-information']/h2");
	By addToCart = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
	By firstviewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a");
	By All_Products = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
	By Quantity = By.xpath("//*[@id=\"product-1\"]/td[4]/button");
	By firstProductImg = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]");
	By productList = By.xpath("//div[@class='productinfo text-center']");
	By Product_details = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
	By quantity_input = By.xpath("//*[@id=\"quantity\"]");
	By second_view_product = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[2]/ul/li/a");
	By secondAddCart = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
	By secondviewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a");
	By second_quantity = By.xpath("//*[@id=\"product-2\"]/td[4]/button");
	By womenCategory = By.xpath("//a[@href='#Women']");
	By dressCategory = By.xpath("//a[@href='/category_products/1']");
	By categoryTitle = By.xpath("//h2[@class='title text-center']");
	By productListByCategory = By.xpath("//div[@class='productinfo text-center']");
	By poloBrand = By.xpath("//a[@href='/brand_products/Polo']");
	By brandTitle = By.xpath("//h2[@class='title text-center']");
	By brandProductList = By.xpath("//div[@class='productinfo text-center']");
	By allProductsList = By.xpath("//div[@class='productinfo text-center']");
	By here = By.xpath("//*[@id=\"empty_cart\"]/p/a");
	By btn_cart = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
	By continue_shopping = By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
	By second_product = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]");
	By second_hover_addTocart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a");
	By added = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a");
	
	public WebElement VerifyAddedText() {
		return driver.findElement(added);
	}
	
	public void hoverAddToCart() {
		driver.findElement(second_hover_addTocart).click();
	}
	
	public WebElement SecondProductHover() {
		return driver.findElement(second_product);
	}
	
	public void clickOnContinue() {
		driver.findElement(continue_shopping).click();
	}
	
	public void clickOnCartButton() {
		driver.findElement(btn_cart).click();
	}
	
	public void ClickOnhere() {
		driver.findElement(here).click();
	}
	
	public List<WebElement> getSearchedProducts() {
	    return driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
	}

	public void clickBreadcrumbWomen() {
	    driver.findElement(womenCategory).click();
	}

	public void clickBreadcrumbDress() {
	    driver.findElement(dressCategory).click();
	}

	public List<WebElement> getAllProducts() {
	    return driver.findElements(allProductsList);
	}

	public void clickPoloBrand() {
	    driver.findElement(poloBrand).click();
	}

	public WebElement getBrandTitle() {
	    return driver.findElement(brandTitle);
	}

	public List<WebElement> getBrandProducts() {
	    return driver.findElements(brandProductList);
	}


	public void clickWomenCategory() {
	    driver.findElement(womenCategory).click();
	}

	public void clickDressCategory() {
	    driver.findElement(dressCategory).click();
	}

	public WebElement getCategoryTitle() {
	    return driver.findElement(categoryTitle);
	}

	public List<WebElement> getCategoryProducts() {
	    return driver.findElements(productListByCategory);
	}

	
	public void SecondProductViewCart() {
		driver.findElement(secondviewCart).click();
	}
	
	public void SecondProductAddCart() {
		driver.findElement(secondAddCart).click();
	}
	
	public void SecondProductViewProduct() {
		driver.findElement(second_view_product).click();
	}
	
	public WebElement QuantityInput() {
		return driver.findElement(quantity_input);
	}
	
	public WebElement ProductDetails() {
		return driver.findElement(Product_details);
	}
	
	public List<WebElement> getProductsList() {
		return driver.findElements(productList);
	}
	
	public WebElement All_products() {
		return driver.findElement(All_Products);
	} 
	
	public void btn_Products() {
		driver.findElement(btn_products).click();
	}
	
	public WebElement searchProduct() {
		return driver.findElement(searchBox);
	}
	
	public void clickonSearch() {
		driver.findElement(searchButton).click();
	}
	
	public WebElement getFirstProductName() {
        return driver.findElement(first_view_product);
    }
	
	public WebElement productDetailTitle() {
	    return driver.findElement(productDetailTitle);
	}
	
	public void addFirstproductToCart() {
		driver.findElement(addToCart).click();
	}
	
	public void clickViewCart() {
		driver.findElement(firstviewCart).click();
		
	}
	
	public void FirstProductViewProduct() {
		driver.findElement(first_view_product).click();
	}
	
	public WebElement QuantityCheck() {
		return driver.findElement(Quantity);
	}
	
	public WebElement SecondQuantityCheck() {
		return driver.findElement(second_quantity);
	}
}