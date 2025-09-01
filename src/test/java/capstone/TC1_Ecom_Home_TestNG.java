package capstone;


import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC1_Ecom_Home_TestNG {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://automationexercise.com/");
  }
  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(String browser) {
	  System.out.println("This is before method");
		if(browser.equalsIgnoreCase("chrome"))
		  {
		   WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		  }
		  if(browser.equalsIgnoreCase("edge"))
		  {
		  WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		  }
		  if(browser.equalsIgnoreCase("firefox"))
		  {
		  WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		  }

	  WebDriverManager.chromedriver().setup();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
