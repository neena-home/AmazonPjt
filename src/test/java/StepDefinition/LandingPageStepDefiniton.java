package StepDefinition;

import com.amazon.base.BaseClasAmazon;
import com.amazon.pages.LandingPage;
import com.amazon.testutils.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class LandingPageStepDefiniton extends BaseClasAmazon {
    LandingPage lp;
    Utils ut;
    String url,title;
    @Given("^:Landing page of Amazon website in chrome$")
    public void landing_page_of_Amazon_website_in_chrome() {
        // Write code here that turns the phrase above into concrete actions
        initializePage();
        lp = new LandingPage(driver);
    }

    @When("^:get the current url$")
    public void get_the_current_url()  {
        // Write code here that turns the phrase above into concrete actions
        url= lp.validateUrl();

    }

    @Then("^:validate the current \"([^\"]*)\" and actual url$")
    public void validate_the_current_and_actual_url(String arg1)   {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(url, arg1);
    }
    @When("^:get the title of the url$")
    public void get_the_title_of_the_url() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       title=lp.validateTitle();
    }

    @Then("^:validate the current \"([^\"]*)\" and actual title$")
    public void validate_the_current_and_actual_title(String arg1)  {
        System.out.println("hello");
        Assert.assertEquals(title, arg1);
    }
    @When("^:Enter serach data\"([^\"]*)\"$")
    public void enter_serach_data(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ut=new Utils(driver);
        lp.search(arg1);
    }

    @Then("^:take screenshot$")
    public void take_screenshot() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ut.screenshotBag("take_screenshot",driver);
    }
    @When("^:Mouseover in landing page$")
    public void mouseover_in_landing_page()  {
        // Write code here that turns the phrase above into concrete actions
       title= lp.mouseOverChk();
    }

    @Then("^:validate the text when mouseover \"([^\"]*)\"$")
    public void validate_the_text_when_mouseover(String arg1)  {

        Assert.assertEquals(title, arg1);
    }

    @Then("^:close the browser$")
    public void close_the_browser() {
        // Write code here that turns the phrase above into concrete actions
       driver.quit();
    }
}
