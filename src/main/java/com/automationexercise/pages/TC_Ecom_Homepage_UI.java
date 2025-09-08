package com.automationexercise.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Ecom_Homepage_UI {
	WebDriver driver;
	public TC_Ecom_Homepage_UI(WebDriver driver) {
		this.driver = driver;
	}

	By homeLogo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
	By homeButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
	By productButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
	By cartButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
	By  login_SignUp = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	By testcasesButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
	By apiTesting = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]/a");
	By videoTutorials = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[7]/a");
	By contactUs = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
	By sideBar = By.xpath("/html/body/section[2]/div/div/div[1]/div");
	By apiTestPractice = By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/a[2]/button");
	By category = By.xpath("/html/body/section[2]/div/div/div[1]/div/h2");
	By brandNames = By.xpath("/html/body/section[2]/div/div/div[1]/div/div[3]/h2");
	By featureItem = By.xpath("/html/body/section[2]/div/div/div[2]");
	By addCart = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a");
	By productCost = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/h2");
	By viewItem = By.xpath("//h2[text()='Blue Top']/following::a[contains(text(),'Add to cart')][1]");
	By recommendedItems = By.xpath("/html/body/section[2]/div/div/div[2]/div[2]/h2");
	By subscriptionSection = By.xpath("//div[@class='single-widget']//h2[contains(text(),'Subscription')]");
	By subscriptionEmailBox = By.xpath("//*[@id=\"susbscribe_email\"]");
	By subscriptionButton = By.id("subscribe");
	By subscriptionSuccess = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");
	By subscriptionError = By.xpath("//div[contains(text(),'Invalid email address!')]");
	By sliderDots = By.xpath("//*[@id=\"slider-carousel\"]/ol/li[1]");
	By firstCategory = By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a");
	By secondCategory = By.xpath("//*[@id='accordian']/div[2]/div[1]/h4/a"); 
	By thirdCategory = By.xpath("//*[@id='accordian']/div[3]/div[1]/h4/a");  
	By recommendedForwardButton = By.xpath("//*[@id=\"recommended-item-carousel\"]/a[2]");
	By recommendedBackwardButton = By.xpath("//*[@id=\"recommended-item-carousel\"]/a[1]");
	By scrollUpButton = By.xpath("//*[@id=\"scrollUp\"]");
	By recommendedAddCart = By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[1]/div/div/div/a");
	By copyright = By.xpath("//*[@id=\"footer\"]/div[2]/div/div/p");



	public boolean isLogoDisplayed() {
		return driver.findElement(homeLogo).isDisplayed();
	}

	public void clickHomeButton() {
		driver.findElement(homeButton).click();
	}

	public boolean isHomeButtonDisplayed() {
		// TODO Auto-generated method stub
		return driver.findElement(homeLogo).isDisplayed();
	}

	public void clickProductButton() {
		driver.findElement(productButton).click();
	}

	public void clickCartButton() {
		driver.findElement(cartButton).click();
	}
	public void clickLoginSignup() {
		driver.findElement(login_SignUp).click();
	}
	public void clickTestCases() {
		driver.findElement(testcasesButton).click();
	}
	public void clickAPITesting() {
		driver.findElement(apiTesting).click();
	}
	public void clickVideoTutorials() {
		driver.findElement(videoTutorials).click();
	}
	public void clickContactUs() {
		driver.findElement(contactUs).click();
	}
	public void clickSideBar(String categoryName) {
		//driver.findElement(sideBar).sendKeys(itemName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement sidebarElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'" + categoryName + "')]")));
	    sidebarElement.click();
	}
	public void clickAPITestPractice() {
		driver.findElement(apiTestPractice).click();
	}
	public void clickCategory(String categoryName) {
		try {
			WebElement category = driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a"));
			Actions actions = new Actions(driver);
			actions.moveToElement(category).click().perform();
		} catch (Exception e) {
			System.out.println("Failed to click category: " + categoryName + " -> " + e.getMessage());
		}

	}
	public void clickBrand(String brandName) {
		try {
			WebElement brand = driver.findElement(By.xpath("//div[@class='brands_products']//a[text()='H&M']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(brand).click().perform();
		} catch (Exception e) {
			System.out.println("Failed to click brand: " + brandName + " -> " + e.getMessage());
		}

	}
	public void clickFeaturedItem(int itemIndex) {
		try {
			List<WebElement> items = driver.findElements(By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']"));
			if (items.size() >= itemIndex) {
				items.get(itemIndex - 1).click();
			} else {
				System.out.println("Featured item index " + itemIndex + " not found. Total items: " + items.size());
			}
		} catch (Exception e) {
			System.out.println("Failed to click featured item index: " + itemIndex + " -> " + e.getMessage());
		}
	}

	public boolean isDisplayedAddCart() {
		return driver.findElement(addCart).isDisplayed();

	}
	public boolean isDisplayedProductCost() {
		return driver.findElement(productCost).isDisplayed();

	}
	public boolean isDisplayedViewItem() {
		return driver.findElement(viewItem).isDisplayed();
	}
	public void clickRecommendedItem() {
		driver.findElement(recommendedItems).click();
	}

	public void clickFeaturedItemByName(String itemName) {
		try {
			WebElement item = driver.findElement(By.xpath(
					"///div[@class='features_items']//div[@class='product-image-wrapper']//h2[text()='Blue Top']"
					));
			item.click();
		} catch (Exception e) {
			System.out.println("Failed to click featured item: " + itemName + " -> " + e.getMessage());
		}
	}


	public boolean hoverOnProductByName(String productName) {
		try {
			// Find all featured products
			List<WebElement> products = driver.findElements(By.cssSelector("div.features_items div.product-image-wrapper"));
			WebElement product = null;

			// Find the product matching the given name
			for (WebElement p : products) {
				String name = p.findElement(By.tagName("h2")).getText();
				if (name.equalsIgnoreCase(productName)) {
					product = p;
					break;
				}
			}

			if (product == null) {
				System.out.println("Product not found: " + productName);
				return false;
			}

			// Hover using Actions
			Actions actions = new Actions(driver);
			actions.moveToElement(product).perform();

			// Check if "View Product" button is visible
			WebElement viewButton = product.findElement(By.xpath(".//a[text()='View Product']"));
			return viewButton.isDisplayed();

		} catch (Exception e) {
			System.out.println("Hover failed for product: " + productName + " -> " + e.getMessage());
			return false;
		}
	}
	public boolean hoverOnProductByName1(String productName) {
		try {
			// Locate the product wrapper containing the product name
			WebElement product = driver.findElement(By.xpath(
					"/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/p" + productName + "']]"
					));

			// Hover using Actions
			new Actions(driver).moveToElement(product).perform();

			// Check if "View Product" button is visible
			WebElement viewButton = product.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a"));
			return viewButton.isDisplayed();

		} catch (Exception e) {
			System.out.println("Hover failed for product: " + productName + " -> " + e.getMessage());
			return false;
		}
	}
	public boolean isSubscriptionDisplayed() {
		return driver.findElement(subscriptionSection).isDisplayed();
	}

	public void enterSubscriptionEmail(String email) {
		driver.findElement(subscriptionEmailBox).clear();
		driver.findElement(subscriptionEmailBox).sendKeys(email);
		driver.findElement(subscriptionButton).click();
	}

	public boolean isSubscriptionSuccess() {
		return driver.findElement(subscriptionSuccess).isDisplayed();
	}

	public boolean isSubscriptionError() {
		return driver.findElement(subscriptionError).isDisplayed();
	}
	public boolean isSliderDotsVisible() {
		return driver.findElements(sliderDots).size() > 0;
	}
	public void clickFirstSliderDot() {
		driver.findElements(sliderDots).get(0).click();
	}
	public void clickWomenCategory() {
		driver.findElement(firstCategory).click();
	}
	public void clickMenCategory() {
		driver.findElement(secondCategory).click();
	}

	public void clickKidsCategory() {
		driver.findElement(thirdCategory).click();
	}
	public void clickViewProduct() {
		driver.findElement(viewItem).click();
	}
	public void clickRecommendedForward() {
		driver.findElement(recommendedForwardButton).click();
	}
	public void clickRecommendedBackward() {
		driver.findElement(recommendedForwardButton).click();
	}
	public void clickScrollUp() {
		driver.findElement(scrollUpButton).click();
	}
	public void clickRecommendedAddCart() {
		driver.findElement(recommendedAddCart).click();
	}
	public boolean isCopyrightDisplayed() {
		return driver.findElement(copyright).isDisplayed();
	}





}




