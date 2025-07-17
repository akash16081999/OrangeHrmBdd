package runner;

import io.cucumber.core.cli.Main;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.Collections;

public class CLIRunner {

    public static void main(String[] args) {

        String runner = System.getProperty("runner", "junit");
        String parallel = System.getProperty("parallel", "true");
        String tags = System.getProperty("cucumber.filter.tags", "@reg");

        if (parallel.equalsIgnoreCase("true")) {
            System.out.println("Running with TestNG in parallel...");

            // Create Suite
            XmlSuite suite = new XmlSuite();
            suite.setName("ParallelCucumberSuite");
            suite.setParallel(XmlSuite.ParallelMode.METHODS);

            suite.setThreadCount(2);

            // Create Test
            XmlTest test = new XmlTest(suite);
            test.setName("Cucumber TestNG Runner");

            // Add your runner class here
            XmlClass testClass = new XmlClass("runner.TestRunnerTestNg");
            test.setXmlClasses(Collections.singletonList(testClass));

            // Set the suite
            TestNG testNG = new TestNG();
            testNG.setXmlSuites(Collections.singletonList(suite));
            testNG.run();

        } else {

            String[] cucumberOptions = new String[]{
                    "--plugin", "pretty",
                    "--plugin", "html:target/cucumber-html-report",
                    "--glue", "stepDefinitions",
                    "src/test/resources/features",
                    "--tags", tags
            };

            Main.main(cucumberOptions);
        }

    }
}
