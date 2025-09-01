package capstone;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC_Ecom_SignUp_TestNG {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		boolean displaystatus = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).isDisplayed();
		System.out.println("New signup user is displayed:"+displaystatus);
		
		driver.findElement(By.name("name")).sendKeys("Sneha");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("snehagowda123@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
		
		boolean displaystatus1 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2")).isDisplayed();
		System.out.println("Enter Account Information is displayed:"+displaystatus1);
		
		boolean labeldisplaystatus=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[1]/label")).isDisplayed();
		System.out.println("Label: Title display"+labeldisplaystatus);
		
		//To select male radio button
		WebElement male_radiobtn = driver.findElement(By.id("id_gender1"));
		male_radiobtn.click();
		if(male_radiobtn.isSelected()) {
			System.out.println("Male radio button is selected");
		}
		else {
			System.out.println("Male radio button is not selected");
		}
		
		//To select female radio button
		WebElement female_radiobtn = driver.findElement(By.id("id_gender2"));
		female_radiobtn.click();
		if(female_radiobtn.isSelected()) {
			System.out.println("Female radio button is selected");
		}
		else {
			System.out.println("Female radio button is not selected");
		}
		
		driver.findElement(By.id("password")).sendKeys("Sneha123");
		WebElement showdropdown1 = driver.findElement(By.id("days"));
		Select daySelect = new Select(showdropdown1);
		daySelect.selectByValue("7");
		
		WebElement showdropdown2 = driver.findElement(By.id("months"));
		showdropdown2.sendKeys("May");
		
		WebElement showdropdown3 = driver.findElement(By.id("years"));
		showdropdown3.sendKeys("2003");
		
		WebElement selectnewsletetr=driver.findElement(By.id("newsletter"));
		selectnewsletetr.click();
		
		WebElement selectspecialoffers=driver.findElement(By.id("optin"));
		selectspecialoffers.click();
		
		//Address Information
		driver.findElement(By.id("first_name")).sendKeys("Sneha");
		driver.findElement(By.id("last_name")).sendKeys("N");
		driver.findElement(By.id("company")).sendKeys("CGI");
		driver.findElement(By.id("address1")).sendKeys("Banglore, Karnataka");
		driver.findElement(By.id("address2")).sendKeys("Banglore, Karnataka");
		
		WebElement countrydropdown = driver.findElement(By.id("country"));
		countrydropdown.sendKeys("India");
		
		driver.findElement(By.id("state")).sendKeys("Karnataka");
		driver.findElement(By.id("city")).sendKeys("Banglore");
		driver.findElement(By.id("zipcode")).sendKeys("560001");
		driver.findElement(By.id("mobile_number")).sendKeys("9845673240");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
		
		
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is Before Method");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is Before Method");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is After Method");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is After Suite");
	  
  }

}