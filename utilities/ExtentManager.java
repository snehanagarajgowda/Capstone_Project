package com.automationexercises.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static final String projectPath = System.getProperty("user.dir");

    // Thread-safe singleton pattern for ExtentReports
    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = projectPath + "\\src\\test\\resources\\automationexercise_Reports\\CART__Test_Report1.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Contact Us UI Test Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            // Optional metadata
            extent.setSystemInfo("Tester", "Rakesh");
            extent.setSystemInfo("Project", "Automation Exercise");
        }
        return extent;
    }
}
