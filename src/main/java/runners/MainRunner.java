package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/features"}, glue = {"stepDefinitions"},tags="@contact_Us", monochrome = true, dryRun = false
, plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
   // in parallel test (memory consumable)
     @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
