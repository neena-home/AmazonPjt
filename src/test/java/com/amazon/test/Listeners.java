package com.amazon.test;


import com.amazon.base.BaseClasAmazon;
import com.amazon.testutils.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.IOException;

public class Listeners extends BaseClasAmazon implements ITestListener {
    public Utils ut;

    public static Logger logger = LogManager.getLogger(Listeners.class.getName());
    public ExtentReports extent;
    public ExtentTest test;
    public ThreadLocal<ExtentTest> testThread;

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            logger.error(e);
        }
        ut = new Utils(driver);
        try {
            test.addScreenCaptureFromPath(ut.screenshotBag(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
            logger.info("When fail Captuering the screeshot");
        } catch (IOException e) {
            logger.error(e);
        }

    }

    @Override
    public void onTestStart(ITestResult result) {
        extent = Utils.getReport();
        //  testThread=new ThreadLocal();
        test = extent.createTest(result.getMethod().getMethodName());
        //testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //testThread.get().log(Status.PASS, "Test passed");
        test.log(Status.PASS, "Test passed");


    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }


}
