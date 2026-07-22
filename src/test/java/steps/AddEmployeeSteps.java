package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class AddEmployeeSteps extends CommonMethods {

    @When("user login to HRMS application")
    public void user_login_to_hrms_application() {

        driver.get(ConfigReader.read("url"));

        sendText(
                ConfigReader.read("userName"),
                loginPage.usernameLoc
        );

        sendText(
                ConfigReader.read("password"),
                loginPage.passwordLoc
        );

        click(loginPage.loginBtn);
    }

    @When("user navigate to PIM page")
    public void user_navigate_to_pim_page() {

        click(addEmployee.pimOption);
    }

    @When("user clicks on Add button")
    public void user_clicks_on_add_button() {

        click(addEmployee.addButton);
    }

    @When("user fill the fields")
    public void user_fill_the_fields() {

        sendText("Mohammad", addEmployee.firstNameLoc);
        sendText("Khalid", addEmployee.middleNameLoc);
        sendText("Shoaiby", addEmployee.lastNameLoc);
    }

    @When("user fill the fields except employee ID")
    public void user_fill_the_fields_except_employee_id() {

        sendText("Mohammad", addEmployee.firstNameLoc);
        sendText("Khalid", addEmployee.middleNameLoc);
        sendText("Shoaiby", addEmployee.lastNameLoc);
    }

    @When("a required field is empty")
    public void a_required_field_is_empty() {

        // Example: Leave first name empty
        sendText("", addEmployee.firstNameLoc);
        sendText("Khalid", addEmployee.middleNameLoc);
        sendText("Shoaiby", addEmployee.lastNameLoc);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {

        click(addEmployee.saveButton);
    }

    @When("user clicks on save")
    public void user_clicks_on_save() {

        click(addEmployee.saveButton);
    }

    @Then("system should generate employee ID")
    public void system_should_generate_employee_id() {

        Assert.assertTrue(addEmployee.employeeIdLoc.isDisplayed());
    }

    @Then("employee is saved successfully")
    public void employee_is_saved_successfully() {

        Assert.assertTrue(addEmployee.personalDetailsHeader.isDisplayed());
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        Assert.assertTrue(addEmployee.requiredText.isDisplayed());
    }

}
