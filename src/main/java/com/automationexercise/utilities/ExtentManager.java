package com.automationexercise.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    // Project path
    private static final String projectPath = System.getProperty("user.dir");

    // Get ExtentReports instance (singleton)
    public static ExtentReports getInstance() {
        if (extent == null) {
            // Set report path
            ExtentSparkReporter spark = new ExtentSparkReporter(
                    projectPath + "\\src\\test\\resources\\automationexcercise_Reports\\ContactUs_UI_Test_Report1.html"
            );
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
