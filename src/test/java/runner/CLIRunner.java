package runner;

import io.cucumber.core.cli.Main;

public class CLIRunner {

    public static void main(String[] args) {
        String tags = System.getProperty("cucumber.filter.tags", "@reg");
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
