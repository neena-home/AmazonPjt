package com.amazon.testutils;

import com.amazon.base.BaseClasAmazon;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import org.apache.commons.io.FileUtils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Utils extends BaseClasAmazon {
    FileInputStream fis;
    XSSFWorkbook book;
    XSSFSheet sheet;
    @FindBy(xpath = "//img[contains(@alt,'Midnight')]/parent::div")
    WebElement searchBagName;
    String testsheetName = System.getProperty("user.dir") + "/TestData/" + "SearchTestData.xlsx";
    public static ExtentReports extentReports;

    public Utils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String screenshotBag(String testMethodName, WebDriver driver) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir") + "/Screenshot/" + testMethodName + System.currentTimeMillis() + ".jpg";
      /*  BufferedImage img = null;
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
        }

        Point point = searchBagName.getLocation();
        System.out.println(point);


        int bagWidth = searchBagName.getSize().getWidth();
        int bagHeight = searchBagName.getSize().getHeight();


        BufferedImage bagScreenshot = img.getSubimage(point.getX(), point.getY(),
                bagWidth, bagHeight);
        ImageIO.write(bagScreenshot, "png", file);*/
        FileUtils.copyFile(file, new File(path));
        return path;

    }

    public Object[][] getTestData(String sheetName) {
        try {
            fis = new FileInputStream(testsheetName);
            book = new XSSFWorkbook(fis);
            sheet = book.getSheet(sheetName);
        } catch (IOException e) {

            e.printStackTrace();
        }
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {

            for (int j = 0; j < (sheet.getRow(0).getLastCellNum()); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();


            }
        }
        return data;
    }

    public static ExtentReports getReport() {
        String path = System.getProperty("user.dir") + "/report/MyReport.html";
        System.out.println(path);
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
        reporter.config().setReportName("Automation result for Amazon pjt");
        reporter.config().setDocumentTitle("Test results of Amazon pjt");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Neena");

        return extentReports;
    }

}
