package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = false, tags = "@smoke", dryRun = false)
public class TestRunnerTestNg extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
