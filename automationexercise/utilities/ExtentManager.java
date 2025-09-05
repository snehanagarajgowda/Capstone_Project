package com.automationexercise.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        sparkReporter.config().setDocumentTitle("AutomationExercise Test Report");
        sparkReporter.config().setReportName("UI Test Cases Execution");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Tester", "QA Team");
        extent.setSystemInfo("Browser", "Chrome");

        return extent;
    }

	public static ExtentReports getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
