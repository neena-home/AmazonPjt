package com.amazon.pages;

import com.amazon.base.BaseClasAmazon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn extends BaseClasAmazon {
    @FindBy(css = "[id='ap_email']")
    WebElement email;
    @FindBy(css = "[id='continue']")
    WebElement continueCLick;
    LandingPage lp;
    public SignIn(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        lp=new LandingPage(driver);
    }

    public void signPage(String username, String password) {

        Actions mouse = new Actions(driver);
        System.out.println(mouse);
       mouse.moveToElement(lp.mouseOver).build().perform();
        lp.signin.click();
email.sendKeys(username);
continueCLick.click();


    }
}
