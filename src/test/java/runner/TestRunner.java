package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import stepDefinitions.MyHooks;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = false, tags = "@smoke", dryRun = false)
public class TestRunner {


}
