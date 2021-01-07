package com.amazon.test;

import com.amazon.base.BaseClasAmazon;
import com.amazon.pages.LandingPage;
import com.amazon.pages.SignIn;
import com.amazon.testutils.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest extends BaseClasAmazon {
    LandingPage lp;
    Utils ut;
    SignIn si;

    public SignInTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {

        initializePage();
        lp = new LandingPage(driver);
        ut = new Utils(driver);
        si = new SignIn(driver);
    }

    @Test
    public void signInPageTest() {

        si.signPage(propFile.getProperty("username"), propFile.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

