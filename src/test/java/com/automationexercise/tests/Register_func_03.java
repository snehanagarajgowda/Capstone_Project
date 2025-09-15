package com.automationexercise.tests;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Register_page_func_02;
import com.automationexercise.utilities.ScreenshotUtilities;

public class Register_func_03 extends BaseTest {

    TC_Register_page_func_02 registerPage;

    @BeforeMethod
    public void setupPage() {
        registerPage = new TC_Register_page_func_02(driver);
    }

    @Test
    public void TC26_validCompany() throws IOException {
        test = extent.createTest("TC26_validCompany");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser26");
            registerPage.enteremail("validgghh@gmail.com");
            registerPage.clicksignupbutton();

            registerPage.enter_company("Valid Company");

            // Verify that the field actually contains the value
            String enteredValue = registerPage.get_company(); // create this method in page class
            if (enteredValue.equals("Valid Company")) {
                test.pass("Entered valid company name successfully");
            } else {
                test.fail("Failed to enter valid company name")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_validCompany_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC26 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC26_validCompany_Fail"));
        }
    }

    // 27. Invalid Company Name
    @Test
    public void TC27_invalidCompany() throws IOException {
        test = extent.createTest("TC27_invalidCompany");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser27");
            registerPage.enteremail("validhhu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_company("123!@#");
            if (!entered) {
                test.pass("Invalid company name rejected as expected");
            } else {
                test.fail("Invalid company name accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_invalidCompany_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC27 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC27_invalidCompany_Fail"));
        }
    }

    // 28. Without Company
    @Test
    public void TC28_withoutCompany() throws IOException {
        test = extent.createTest("TC28_withoutCompany");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser28");
            registerPage.enteremail("validgghh@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_company(""); // empty
            if (!entered) {
                test.pass("Company left empty and handled correctly");
            } else {
                test.fail("Company empty accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_withoutCompany_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC28 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC28_withoutCompany_Fail"));
        }
    }

    // 29. Valid Address1
    @Test
    public void TC29_validAddress1() throws IOException {
        test = extent.createTest("TC29_validAddress1");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser29");
            registerPage.enteremail("validghuu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_address1("123 Main Street");
            if (entered) {
                test.pass("Entered valid Address1");
            } else {
                test.fail("Failed to enter valid Address1")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_validAddress1_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC29 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC29_validAddress1_Fail"));
        }
    }

    // 30. Invalid Address1
    @Test
    public void TC30_invalidAddress1() throws IOException {
        test = extent.createTest("TC30_invalidAddress1");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser30");
            registerPage.enteremail("validghuu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_address1("!@#$%");
            if (!entered) {
                test.pass("Invalid Address1 rejected as expected");
            } else {
                test.fail("Invalid Address1 accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_invalidAddress1_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC30 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC30_invalidAddress1_Fail"));
        }
    }

    // 31. Without Address1
    @Test
    public void TC31_withoutAddress1() throws IOException {
        test = extent.createTest("TC31_withoutAddress1");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser31");
            registerPage.enteremail("validghuu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_address1("");
            if (!entered) {
                test.pass("Address1 left empty handled correctly");
            } else {
                test.fail("Empty Address1 accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_withoutAddress1_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC31 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC31_withoutAddress1_Fail"));
        }
    }

    // 32. Valid Address2
    @Test
    public void TC32_validAddress2() throws IOException {
        test = extent.createTest("TC32_validAddress2");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser32");
            registerPage.enteremail("validghuu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_address2("Apartment 101");
            if (entered) {
                test.pass("Entered valid Address2");
            } else {
                test.fail("Failed to enter valid Address2")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_validAddress2_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC32 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC32_validAddress2_Fail"));
        }
    }

    // 33. Invalid Address2
    @Test
    public void TC33_invalidAddress2() throws IOException {
        test = extent.createTest("TC33_invalidAddress2");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser33");
            registerPage.enteremail("validghuu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_address2("!@#$%");
            if (!entered) {
                test.pass("Invalid Address2 rejected as expected");
            } else {
                test.fail("Invalid Address2 accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_invalidAddress2_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC33 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC33_invalidAddress2_Fail"));
        }
    }

    // 34. Without Address2
    @Test
    public void TC34_withoutAddress2() throws IOException {
        test = extent.createTest("TC34_withoutAddress2");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser34");
            registerPage.enteremail("validghu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_address2("");
            if (!entered) {
                test.pass("Address2 left empty handled correctly");
            } else {
                test.fail("Empty Address2 accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_withoutAddress2_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC34 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC34_withoutAddress2_Fail"));
        }
    }

    // 35. Country Dropdown
    @Test
    public void TC35_countryDropdown() throws IOException {
        test = extent.createTest("TC35_countryDropdown");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser35");
            registerPage.enteremail("validghuu@gmail.com");
            registerPage.clicksignupbutton();
            boolean selected = registerPage.select_country("United States");
            if (selected) {
                test.pass("Country selected successfully");
            } else {
                test.fail("Country selection failed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_countryDropdown_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC35 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC35_countryDropdown_Fail"));
        }
    }

    // 36. Valid State
    @Test
    public void TC36_validState() throws IOException {
        test = extent.createTest("TC36_validState");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser36");
            registerPage.enteremail("validghuu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_state("California");
            if (entered) {
                test.pass("Entered valid state");
            } else {
                test.fail("Failed to enter valid state")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_validState_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC36 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC36_validState_Fail"));
        }
    }

    // 37. Invalid State
    @Test
    public void TC37_invalidState() throws IOException {
        test = extent.createTest("TC37_invalidState");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser37");
            registerPage.enteremail("validghuu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_state("123!@#");
            if (!entered) {
                test.pass("Invalid state rejected as expected");
            } else {
                test.fail("Invalid state accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_invalidState_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC37 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC37_invalidState_Fail"));
        }
    }

    // 38. Valid City
    @Test
    public void TC38_validCity() throws IOException {
        test = extent.createTest("TC38_validCity");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser38");
            registerPage.enteremail("validghuu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_city("Los Angeles");
            if (entered) {
                test.pass("Entered valid city");
            } else {
                test.fail("Failed to enter valid city")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_validCity_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC38 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC38_validCity_Fail"));
        }
    }

    // 39. Invalid City
    @Test
    public void TC39_invalidCity() throws IOException {
        test = extent.createTest("TC39_invalidCity");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser39");
            registerPage.enteremail("validghuu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_city("123!@#");
            if (!entered) {
                test.pass("Invalid city rejected as expected");
            } else {
                test.fail("Invalid city accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_invalidCity_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC39 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC39_invalidCity_Fail"));
        }
    }

    // 40. Without City
    @Test
    public void TC40_withoutCity() throws IOException {
        test = extent.createTest("TC40_withoutCity");
        try {
            registerPage.clickloginsignupbutton();
            registerPage.enterusername("TestUser40");
            registerPage.enteremail("validghuu@gmail.com");
            registerPage.clicksignupbutton();
            boolean entered = registerPage.enter_city("");
            if (!entered) {
                test.pass("City left empty handled correctly");
            } else {
                test.fail("Empty city accepted")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_withoutCity_Fail"));
            }
        } catch (Exception e) {
            test.fail("TC40 failed: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC40_withoutCity_Fail"));
        }
    }
}
