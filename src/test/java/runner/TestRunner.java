package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",   // ✅ path to your .feature files
        glue = "stepDefinitions",            // ✅ package of your step defs
        plugin = {"pretty", "html:target/cucumber-report.html"}, // optional, for report
        monochrome = true,tags = "@all")
public class TestRunner {


}
