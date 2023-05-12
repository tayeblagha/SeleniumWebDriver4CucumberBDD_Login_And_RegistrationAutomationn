package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import static driver.DriverFactory.cleanupDriver;
import static driver.DriverFactory.getDriver;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;
import stepDefinitions.base.Hooks;

import java.io.IOException;

public class Login_Steps  extends Base_PO {
    private Login_PO login_po;

    public Login_Steps(Login_PO login_po) throws IOException {
        super();
        this.login_po = login_po;
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() throws IOException {
        login_po.navigateTo_WebDriverUniversity_Login_Page();
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) throws IOException {
        login_po.setUsername(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) throws IOException {
        login_po.setPassword(password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() throws IOException {
        login_po.clickOn_Login_Button();
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() throws IOException {
        login_po.validate_SuccessfulLogin_Message();
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() throws IOException {
        login_po.validate_UnsuccessfulLogin_Message();
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) throws IOException {
        waitForAlert_And_ValidateText(expectedMessage);
    }
}
