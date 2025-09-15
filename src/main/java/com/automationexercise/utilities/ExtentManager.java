package com.automationexercise.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	static String projectpath=System.getProperty("user.dir");
	String className = this.getClass().getSimpleName();
	public static ExtentReports getinstance() {
	    if (extent == null) {
	        ExtentSparkReporter spark = new ExtentSparkReporter(projectpath + "\\src\\test\\resources\\automationexcercise_Reports\\HomePage_UI_Test_Report1.html");
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	    }
	    return extent;
	}

}