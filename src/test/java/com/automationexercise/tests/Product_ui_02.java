<<<<<<< HEAD
package com.automationexercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.Base.BaseTest;
import com.automationexercise.pages.TC_Products_page_ui_02;
import com.automationexercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Product_ui_02 extends BaseTest {

    TC_Products_page_ui_02 productsPage;

    @BeforeMethod
    public void setUpPage() {
        productsPage = new TC_Products_page_ui_02(driver);
        productsPage.clickproductsbutton();
    }
    @Test
    public void TC11_verifySpecialOfferDisplayed() {
        ExtentTest test = extent.createTest("TC11_verifySpecialOfferDisplayed");
        try {
        if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
            if (productsPage.isSpecialOfferDisplayed()) {
                test.pass("Special offer is displayed on Products page");
            } else {
                test.fail("Special offer is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC11_Fail"));
            }
        } else {
        	test.fail("products page not opened");
        }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC12_verifySearchBoxDisplayed() {
        ExtentTest test = extent.createTest("TC12_verifySearchBoxDisplayed");
        try {
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
            if (productsPage.isSearchBoxDisplayed() && productsPage.isSearchButtonDisplayed()) {
                test.pass("Search input box & button are displayed");
            } else {
                test.fail("Search box or button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC12_Fail"));
            }
        	} else {
            	test.fail("products page not opened");
            }
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC13_verifyCategorySectionDisplayed() {
        ExtentTest test = extent.createTest("TC13_verifyCategorySectionDisplayed");
        try {
          if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
            if (productsPage.isCategorySectionDisplayed()) {
                test.pass("Category section is displayed");
            } else {
                test.fail("Category section is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC13_Fail"));
            }
          } else {
          	test.fail("products page not opened");
          }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC14_verifyBrandsSectionDisplayed() {
        ExtentTest test = extent.createTest("TC14_verifyBrandsSectionDisplayed");
        try {
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
            if (productsPage.isBrandsSectionDisplayed()) {
                test.pass("Brands section is displayed");
            } else {
                test.fail("Brands section is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC14_Fail"));
            }
        	} else {
            	test.fail("products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC15_verifyAllProductsDisplayed() {
        ExtentTest test = extent.createTest("TC15_verifyAllProductsDisplayed");
        try {
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
   
            if (productsPage.areProductsDisplayed()) {
                test.pass("All products are displayed");
            } else {
                test.fail("Products are NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC15_Fail"));
            }
        	} else {
            	test.fail("products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC16_verifyProductNameDisplayed() {
        ExtentTest test = extent.createTest("TC16_verifyProductNameDisplayed");
        try {
        	
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
        		if (productsPage.isProductNameDisplayed()) {
        			test.pass("Product name is displayed");
        		} else {
        			test.fail("Product name is NOT displayed")
        				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC16_Fail"));
        		}
        	} else {
            	test.fail("products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC17_verifyProductPriceDisplayed() {
        ExtentTest test = extent.createTest("TC17_verifyProductPriceDisplayed");
        try {
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
        		if (productsPage.isProductPriceDisplayed()) {
        			test.pass("Product price is displayed");
                } else {
                	test.fail("Product price is NOT displayed")
                      .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC17_Fail"));
                }
        	} else {
            	test.fail("products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC18_verifyHoverEffectOnProduct() {
        ExtentTest test = extent.createTest("TC18_verifyHoverEffectOnProduct");
        try {
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
        		if(productsPage.firstproductvisible()) {
        			test.pass("product is visible");
        			if (productsPage.isHoverEffectWorking()) {
        				test.pass("Hover effect is working on product");
        			} else {
        				test.fail("Hover effect is NOT working")
                          .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC18_Fail"));
                    }
        	     } else {
        	    	 test.fail("product is not visible");
        	     }
        	} else {
            	test.fail("products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }
    @Test
    public void TC19_verifyProductCostDisplayed() {
        ExtentTest test = extent.createTest("TC19_verifyProductCostDisplayed");
        try {
            if (productsPage.isproductspageheadingdisplayed()) {
                test.pass("Clicked on products page");
                test.pass("Products page opened");

                if (productsPage.firstproductvisible()) {
                    test.pass("First product is visible");

                    if (productsPage.isProductPriceDisplayed()) {
                        test.pass("Product cost is displayed on products page");
                    } else {
                        test.fail("Product cost is NOT displayed on products page")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC19_Fail"));
                    }

                } else {
                    test.fail("First product is not visible");
                }

            } else {
                test.fail("Products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC20_verifyProductNameDisplayed() {
        ExtentTest test = extent.createTest("TC20_verifyProductNameDisplayed");
        try {
            if (productsPage.isproductspageheadingdisplayed()) {
                test.pass("Clicked on products page");
                test.pass("Products page opened");

                if (productsPage.firstproductvisible()) {
                    test.pass("First product is visible");

                    if (productsPage.isProductNameDisplayed()) {
                        test.pass("Product name/type is displayed on products page");
                    } else {
                        test.fail("Product name/type is NOT displayed on products page")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreenshot(driver, "TC20_Fail"));
                    }

                } else {
                    test.fail("First product is not visible");
                }

            } else {
                test.fail("Products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

}
=======
package com.automationexcercise.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexcercise.Base.BaseTest;
import com.automationexcercise.pages.TC_Products_page_ui_02;
import com.automationexcercise.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class Product_ui_02 extends BaseTest {

    TC_Products_page_ui_02 productsPage;

    @BeforeMethod
    public void setUpPage() {
        productsPage = new TC_Products_page_ui_02(driver);
        productsPage.clickproductsbutton();
    }
    @Test
    public void TC11_verifySpecialOfferDisplayed() {
        ExtentTest test = extent.createTest("TC11_verifySpecialOfferDisplayed");
        try {
        if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
            if (productsPage.isSpecialOfferDisplayed()) {
                test.pass("Special offer is displayed on Products page");
            } else {
                test.fail("Special offer is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC11_Fail"));
            }
        } else {
        	test.fail("products page not opened");
        }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC12_verifySearchBoxDisplayed() {
        ExtentTest test = extent.createTest("TC12_verifySearchBoxDisplayed");
        try {
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
            if (productsPage.isSearchBoxDisplayed() && productsPage.isSearchButtonDisplayed()) {
                test.pass("Search input box & button are displayed");
            } else {
                test.fail("Search box or button is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC12_Fail"));
            }
        	} else {
            	test.fail("products page not opened");
            }
            
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC13_verifyCategorySectionDisplayed() {
        ExtentTest test = extent.createTest("TC13_verifyCategorySectionDisplayed");
        try {
          if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
            if (productsPage.isCategorySectionDisplayed()) {
                test.pass("Category section is displayed");
            } else {
                test.fail("Category section is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC13_Fail"));
            }
          } else {
          	test.fail("products page not opened");
          }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC14_verifyBrandsSectionDisplayed() {
        ExtentTest test = extent.createTest("TC14_verifyBrandsSectionDisplayed");
        try {
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
            if (productsPage.isBrandsSectionDisplayed()) {
                test.pass("Brands section is displayed");
            } else {
                test.fail("Brands section is NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC14_Fail"));
            }
        	} else {
            	test.fail("products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC15_verifyAllProductsDisplayed() {
        ExtentTest test = extent.createTest("TC15_verifyAllProductsDisplayed");
        try {
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
   
            if (productsPage.areProductsDisplayed()) {
                test.pass("All products are displayed");
            } else {
                test.fail("Products are NOT displayed")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC15_Fail"));
            }
        	} else {
            	test.fail("products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC16_verifyProductNameDisplayed() {
        ExtentTest test = extent.createTest("TC16_verifyProductNameDisplayed");
        try {
        	
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
        		if (productsPage.isProductNameDisplayed()) {
        			test.pass("Product name is displayed");
        		} else {
        			test.fail("Product name is NOT displayed")
        				.addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC16_Fail"));
        		}
        	} else {
            	test.fail("products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC17_verifyProductPriceDisplayed() {
        ExtentTest test = extent.createTest("TC17_verifyProductPriceDisplayed");
        try {
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
        		if (productsPage.isProductPriceDisplayed()) {
        			test.pass("Product price is displayed");
                } else {
                	test.fail("Product price is NOT displayed")
                      .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC17_Fail"));
                }
        	} else {
            	test.fail("products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC18_verifyHoverEffectOnProduct() {
        ExtentTest test = extent.createTest("TC18_verifyHoverEffectOnProduct");
        try {
        	if(productsPage.isproductspageheadingdisplayed()) {
        		test.pass("clicked on products page");
        		test.pass("products page opened");
        		if(productsPage.firstproductvisible()) {
        			test.pass("product is visible");
        			if (productsPage.isHoverEffectWorking()) {
        				test.pass("Hover effect is working on product");
        			} else {
        				test.fail("Hover effect is NOT working")
                          .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC18_Fail"));
                    }
        	     } else {
        	    	 test.fail("product is not visible");
        	     }
        	} else {
            	test.fail("products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }
    @Test
    public void TC19_verifyProductCostDisplayed() {
        ExtentTest test = extent.createTest("TC19_verifyProductCostDisplayed");
        try {
            if (productsPage.isproductspageheadingdisplayed()) {
                test.pass("Clicked on products page");
                test.pass("Products page opened");

                if (productsPage.firstproductvisible()) {
                    test.pass("First product is visible");

                    if (productsPage.isProductPriceDisplayed()) {
                        test.pass("Product cost is displayed on products page");
                    } else {
                        test.fail("Product cost is NOT displayed on products page")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC19_Fail"));
                    }

                } else {
                    test.fail("First product is not visible");
                }

            } else {
                test.fail("Products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void TC20_verifyProductNameDisplayed() {
        ExtentTest test = extent.createTest("TC20_verifyProductNameDisplayed");
        try {
            if (productsPage.isproductspageheadingdisplayed()) {
                test.pass("Clicked on products page");
                test.pass("Products page opened");

                if (productsPage.firstproductvisible()) {
                    test.pass("First product is visible");

                    if (productsPage.isProductNameDisplayed()) {
                        test.pass("Product name/type is displayed on products page");
                    } else {
                        test.fail("Product name/type is NOT displayed on products page")
                            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC20_Fail"));
                    }

                } else {
                    test.fail("First product is not visible");
                }

            } else {
                test.fail("Products page not opened");
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        }
    }

}
>>>>>>> bfd624d6f67bc365de35f9d0fa5a381abc8c9718
