package com.automationexercises.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtilities {

    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String SCREENSHOT_FOLDER = PROJECT_PATH + File.separator + "Screenshots";

    /**
     * Captures a screenshot of the current browser window.
     *
     * @param driver   WebDriver instance
     * @param testName Name of the test (used in the screenshot filename)
     * @return Absolute path of the screenshot file, or null if failed
     */
    public static String captureScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            System.err.println("❌ WebDriver instance is null. Cannot take screenshot.");
            return null;
        }

        try {
            // Ensure the screenshots folder exists
            File folder = new File(SCREENSHOT_FOLDER);
            if (!folder.exists() && !folder.mkdirs()) {
                System.err.println("❌ Failed to create screenshots folder: " + SCREENSHOT_FOLDER);
                return null;
            }

            // Take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create unique filename with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = SCREENSHOT_FOLDER + File.separator + testName + "_" + timestamp + ".png";
            File destFile = new File(filePath);

            // Copy file to destination
            FileUtils.copyFile(srcFile, destFile);

            System.out.println("✅ Screenshot saved: " + filePath);
            return filePath;

        } catch (IOException e) {
            System.err.println("❌ IOException while capturing screenshot: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("❌ Unexpected exception while capturing screenshot: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
