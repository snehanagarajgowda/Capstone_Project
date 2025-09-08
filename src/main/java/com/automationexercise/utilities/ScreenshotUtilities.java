package com.automationexercise.utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtilities {
    
    static String projectPath = System.getProperty("user.dir");

    public static String capturescreenshot(WebDriver driver, String testName) {
        String screenPath = "";
        try {
            if (driver == null) {
                throw new IOException("WebDriver instance is null. Cannot take screenshot.");
            }

            // Take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create Screenshots folder if it doesn't exist
            String folderPath = projectPath + "\\Screenshots\\";
            File destFolder = new File(folderPath);
            if (!destFolder.exists()) {
                destFolder.mkdir();
            }

            // Make filename unique with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            screenPath = folderPath + testName + "_" + timestamp + ".png";
            File destFile = new File(screenPath);

            // Copy screenshot
            FileUtils.copyFile(srcFile, destFile);

        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception while capturing screenshot: " + e.getMessage());
        }

        return screenPath; // Return path even if empty
    }
}
