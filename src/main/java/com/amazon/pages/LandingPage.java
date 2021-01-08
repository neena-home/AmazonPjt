package com.amazon.pages;

import com.amazon.base.BaseClasAmazon;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage extends BaseClasAmazon {
    Actions mouse;
    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    public WebElement mouseOver;
    By mouseover = By.xpath("//a[@id='nav-link-accountList']");
    @FindBy(xpath = "//a[@id='nav-link-accountList']/div/span")
    WebElement mouseOverName;
    @FindBy(xpath = "//a[@id='nav-link-accountList']/span")
    WebElement mouseOverNameone;
    @FindBy(css = "input[id='twotabsearchtextbox']")
    WebElement search;
    @FindBy(css = "[class='nav-action-button']")
    public WebElement signin; //hi
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String validateTitle() {

        return driver.getTitle();
    }

    public String validateUrl() {

        return driver.getCurrentUrl();
    }

    public String mouseOverChk() {
        mouse = new Actions(driver);
        mouse.moveToElement(mouseOver).build().perform();
        return mouseOverName.getText() + mouseOverNameone.getText();
    }

    public void search(String textSearch) {
        search.sendKeys(textSearch, Keys.ENTER);

    }

    public String signInClick() {
        mouse = new Actions(driver);
        mouse.moveToElement(mouseOver).build().perform();
        signin.click();
        return driver.getCurrentUrl();
        // return new SignIn(driver);


    }
}
