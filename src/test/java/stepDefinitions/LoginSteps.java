package stepDefinitions;

import com.qa.base.DriverFactory;
import com.qa.pages.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    @Given("user open the application url")
    public void user_open_the_application_url() {
        System.out.println("url is opened ");
    }

    @When("user enter valid email {string} and password {string}")
    public void user_enter_valid_email_and_password(String email, String pass) {
        PageManager.getPageManagerObj().getLoginpageObject().login(email, pass);
    }

    @When("user clicks on the Login button")
    public void user_clicks_on_the_login_button() {
        PageManager.getPageManagerObj().getLoginpageObject().getLoginBtn().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Homepage should be displayed")
    public void homepage_should_be_displayed() {
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", DriverFactory.getDriver().getCurrentUrl());

    }

    @When("user enter Invalid email {string} and password {string}")
    public void user_enter_invalid_email_and_password(String email, String pass) {
        PageManager.getPageManagerObj().getLoginpageObject().login(email, pass);

    }


    @Then("Alert should display in the Login page.")
    public void alert_should_display_in_the_login_page() {
        Assert.assertTrue(PageManager.getPageManagerObj().getLoginpageObject().getInvalidAlertTxt().isDisplayed());
        Assert.assertEquals("Invalid credentials", PageManager.getPageManagerObj().getLoginpageObject().getInvalidAlertTxt().getText());

    }


    @Then("Alert should display in the Login page with required alert.")
    public void alert_should_display_in_the_login_page_with_required_alert() {
        Assert.assertTrue(PageManager.getPageManagerObj().getLoginpageObject().getAlertForEmptyUsername().isDisplayed());
        Assert.assertEquals("Required", PageManager.getPageManagerObj().getLoginpageObject().getAlertForEmptyUsername().getText());

    }


    @When("user enter empty email {string}{string}")
    public void user_enter_empty_email(String email, String pass) {
        PageManager.getPageManagerObj().getLoginpageObject().login(email, pass);
    }

    @When("user enter empty password {string}{string}")
    public void user_enter_empty_password(String email, String pass) {
        PageManager.getPageManagerObj().getLoginpageObject().login(email, pass);

    }

}
