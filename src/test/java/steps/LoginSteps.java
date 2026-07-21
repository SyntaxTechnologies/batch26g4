package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import static utils.CommonMethods.driver;

public class LoginSteps extends CommonMethods {

    @Given("user is able to launch HRMS application")
    public void user_is_able_to_launch_hrms_application() {
        //creates driver
        openBrowserAndLaunchApplication();
        //creates LoginPage and WebElements
        initilizePageObjects();
        //Opens application
        driver.get(ConfigReader.read("url"));
    }
    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameLoc);
        sendText(ConfigReader.read("password"), loginPage.passwordLoc);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginBtn);
    }
    @Then("user is logged in successfully")
    public void user_is_able_to_logged_in_successfully()
    {
        Assert.assertTrue(loginPage.dashboardText.isDisplayed());
    }

    @When("user enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameLoc);
        sendText("Hrm123", loginPage.passwordLoc);
    }
    @Then("the system shows {string}")
    public void the_system_shows(String errorExpected) {
        String actual = loginPage.errorPasswordText.getText();
        Assert.assertEquals(errorExpected, actual);
    }
    @Then("the user remains on the login page")
    public void the_user_remains_on_the_login_page() {
        Assert.assertTrue(loginPage.loginBtn.isDisplayed());
    }
    @When("user enters the correct password")
    public void user_enters_the_correct_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameLoc);
        sendText(ConfigReader.read("password"), loginPage.passwordLoc);
    }

    @When("user enters valid username and leaves password empty")
    public void user_enters_valid_username_and_leaves_password_empty() {
        sendText(ConfigReader.read("userName"), loginPage.usernameLoc);
    }
    @Then("the system shows {string} for the password field")
    public void the_system_shows_for_the_password_field(String expectedText) {
        String actualText = loginPage.passwordRequiredText.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @When("user leaves username empty and enters a valid password")
    public void user_leaves_username_empty_and_enters_a_valid_password() {
        sendText(ConfigReader.read("password"), LoginPage.loginPage.passwordLoc);
    }
    @Then("the system shows {string} for the username field")
    public void the_system_shows_for_the_username_field(String expectedText) {
        String actualText = loginPage.usernameRequiredText.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @When("user leaves username and password empty")
    public void user_leaves_username_and_password_empty() {
        System.out.println("you can not login without username and password");
    }
    @Then("the system shows {string} for both username and password fields")
    public void the_system_shows_for_both_username_and_password_fields(String expected) {
        Assert.assertEquals(expected,
                loginPage.usernameRequiredText.getText());

        Assert.assertEquals(expected,
                loginPage.passwordRequiredText.getText());
    }

}
