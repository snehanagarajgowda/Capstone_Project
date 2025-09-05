package com.automationexercise.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl = "https://automationexercise.com";

    @Parameters({"browser", "page"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser,
                      @Optional("") String page) {
        // ---------- Browser setup ----------
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("❌ Browser not supported: " + browser);
        }

        // ---------- Window + timeouts ----------
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ---------- Navigation ----------
        String targetUrl;
        if (page == null || page.trim().isEmpty()) {
            targetUrl = baseUrl;  // Homepage
        } else {
            // Always ensure it starts with a slash
            if (!page.startsWith("/")) {
                page = "/" + page;
            }
            targetUrl = baseUrl + page;
        }

        // Debug info
        System.out.println("===== Debug Info =====");
        Capabilities caps = ((HasCapabilities) driver).getCapabilities();
        System.out.println("Browser Name: " + caps.getBrowserName());
        System.out.println("Browser Version: " + caps.getBrowserVersion());
        System.out.println("🌍 Opening URL: " + targetUrl);
        System.out.println("======================");

        driver.get(targetUrl);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                takeScreenshot(result.getName());
            }
        } catch (Exception e) {
            System.out.println("⚠️ Failed to capture screenshot: " + e.getMessage());
        }

        if (driver != null) {
            driver.quit();
        }
    }

    // ✅ Method to take screenshot and save in reports/screenshots
    public void takeScreenshot(String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            // Create reports/screenshots folder if not exists
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";
            Files.createDirectories(Paths.get(folderPath));

            String filePath = folderPath + testName + "_" + timestamp + ".png";
            File dest = new File(filePath);

            Files.copy(src.toPath(), dest.toPath());
            System.out.println("📸 Screenshot saved at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
