package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Feature",glue ="StepDefinition",plugin = {"pretty","html:target/cucumberReport","json:target/jsonCucumberReport/cumcumber.json","junit:target/junitxmReprt/cucumber.xml"},
dryRun = false,monochrome = true,strict = true)
public class TestRuuner {
}
