package com.automationexercise.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Register_page_func;
import com.automationexercise.utilities.ScreenshotUtilities;

public class Register_func_02 extends BaseTest {
    TC_Register_page_func registerPage;

    @BeforeMethod
    public void setupPage() {
        registerPage = new TC_Register_page_func(driver); // driver from BaseTest
    }

    // 17. Select Day from dropdown
    @Test
    public void TC17_dayDropdown() throws IOException {
        test = extent.createTest("TC17_dayDropdown");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();

            registerPage.select_day("15");
            test.pass("Day selected successfully");
        } catch (Exception e) {
            test.fail("Unable to select day: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17_DayDropdown_Fail"));
        }
    }

    // 18. Select Month from dropdown
    @Test
    public void TC18_monthDropdown() throws IOException {
        test = extent.createTest("TC18_monthDropdown");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();

            registerPage.select_month("5"); // May
            test.pass("Month selected successfully");
        } catch (Exception e) {
            test.fail("Unable to select month: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC18_MonthDropdown_Fail"));
        }
    }

    // 19. Select Year from dropdown
    @Test
    public void TC19_yearDropdown() throws IOException {
        test = extent.createTest("TC19_yearDropdown");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();

            registerPage.select_year("1995");
            test.pass("Year selected successfully");
        } catch (Exception e) {
            test.fail("Unable to select year: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC19_YearDropdown_Fail"));
        }
    }

    // 20. Newsletter checkbox
    @Test
    public void TC20_newsletterCheckbox() throws IOException {
        test = extent.createTest("TC20_newsletterCheckbox");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();

            registerPage.click_newsletter();
            test.pass("Newsletter checkbox selected");
        } catch (Exception e) {
            test.fail("Unable to select newsletter checkbox: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC20_Newsletter_Fail"));
        }
    }

    // 21. Offers checkbox
    @Test
    public void TC21_offersCheckbox() throws IOException {
        test = extent.createTest("TC21_offersCheckbox");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();

            registerPage.click_offers();
            test.pass("Offers checkbox selected");
        } catch (Exception e) {
            test.fail("Unable to select offers checkbox: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC21_Offers_Fail"));
        }
    }

    // 22. First Name with numbers
    @Test
    public void TC22_firstNameNumbers() throws IOException {
        test = extent.createTest("TC22_firstNameNumbers");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();

            registerPage.enter_firstname("John123");
            test.pass("First name with numbers entered");
        } catch (Exception e) {
            test.fail("Unable to enter first name with numbers: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC22_FirstNameNumbers_Fail"));
        }
    }

    // 23. First Name with letters
    @Test
    public void TC23_firstNameLetters() throws IOException {
        test = extent.createTest("TC23_firstNameLetters");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();

            registerPage.enter_firstname("John");
            test.pass("First name with letters entered");
        } catch (Exception e) {
            test.fail("Unable to enter first name with letters: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC23_FirstNameLetters_Fail"));
        }
    }

    // 24. Last Name with numbers
    @Test
    public void TC24_lastNameNumbers() throws IOException {
        test = extent.createTest("TC24_lastNameNumbers");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();

            registerPage.enter_lastname("Doe123");
            test.pass("Last name with numbers entered");
        } catch (Exception e) {
            test.fail("Unable to enter last name with numbers: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC24_LastNameNumbers_Fail"));
        }
    }

    // 25. Last Name with letters
    @Test
    public void TC25_lastNameLetters() throws IOException {
        test = extent.createTest("TC25_lastNameLetters");

        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("NewUser");
            registerPage.enteremail("thejaswarieee@gmail.com");
            registerPage.clicksignupbutton();

            registerPage.enter_lastname("Doe");
            test.pass("Last name with letters entered");
        } catch (Exception e) {
            test.fail("Unable to enter last name with letters: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC25_LastNameLetters_Fail"));
        }
    }
}