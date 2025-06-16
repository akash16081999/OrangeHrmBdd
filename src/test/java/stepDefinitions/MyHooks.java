package stepDefinitions;


import com.qa.base.DriverFactory;
import com.qa.pages.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {

    @Before
    public void setUp() {

        DriverFactory.initDriver();
        PageManager.intPageManager(DriverFactory.getDriver());


    }

    @After
    public void tearDown() {
        DriverFactory.getDriver().quit();

    }
}
