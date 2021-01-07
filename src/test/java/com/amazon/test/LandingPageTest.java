package com.amazon.test;

import com.amazon.base.BaseClasAmazon;
import com.amazon.pages.LandingPage;
import com.amazon.testutils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class LandingPageTest extends BaseClasAmazon {
    public LandingPage lp;
    public Utils ut;
    public String sheetName = "Search";
    public Object[][] data;
    public static Logger logger = LogManager.getLogger(LandingPageTest.class.getName());

    public LandingPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {

        initializePage();
        logger.info("initialized  the landing page");
        lp = new LandingPage(driver);
        ut = new Utils(driver);
    }

    @Test
    public void testValidateTitle() {
        logger.debug("Validating Title");
        String title = lp.validateTitle();
        Assert.assertEquals(title, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

    }

    @Test
    public void testValidateUrl() throws IOException {
        logger.debug("Validating the current url");
        Assert.assertEquals(lp.validateUrl(), "https://www.amazon.com/");
        ut.screenshotBag("testValidateUrl", driver);
    }

    @Test
    public void testMouseOver() {
        logger.debug("Mouse Over checking");
        Assert.assertEquals(lp.mouseOverChk(), "Hello, Sign inAccount & Lists");

    }

    @Test(dataProvider = "addTestData")
    public void testSearch(String textSearch) throws IOException {
        ut=new Utils(driver);
        lp.search(textSearch);
         ut.screenshotBag("testSearch",driver);
    }

    @Test
    public void testsignIn() {
        logger.debug("Sign in click");
        String[] actual = lp.signInClick().split("openid.");
        Assert.assertEquals(actual[0], "https://www.amazon.com/ap/ignin?");
    }

    @DataProvider
    public Object[][] addTestData()  {
        ut = new Utils(driver);
        data = ut.getTestData(sheetName);
        logger.info("return test data");
        return data;

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
