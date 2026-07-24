package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.ChangePersonalDetailsPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.DBReader;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ChangePersonalDetailsSteps extends CommonMethods {
    @When("user logs in with created ESS user credentials")
    public void user_logs_in_with_created_ess_user_credentials() {
        sendText(ConfigReader.read("ESSuserName"), loginPage.usernameLoc);
        sendText(ConfigReader.read("ESSpassword"), loginPage.passwordLoc);
        click(loginPage.loginBtn);
    }
    @When("user clicks on MyInfo option")
    public void user_clicks_on_my_info_option() {
        click(changePersonalDetailsPage.MyInfoOption);
    }

    @Then("The Following Fields are displayed and enabled")
    public void the_following_fields_are_displayed_and_enabled(io.cucumber.datatable.DataTable dataTable) {
        Assert.assertTrue(changePersonalDetailsPage.firstName.isDisplayed());
        Assert.assertTrue(changePersonalDetailsPage.middleName.isDisplayed());
        Assert.assertTrue(changePersonalDetailsPage.lastName.isDisplayed());
        Assert.assertTrue(changePersonalDetailsPage.genderFemale.isEnabled());
        Assert.assertTrue(changePersonalDetailsPage.nationalityDropdown.isDisplayed());
        Assert.assertTrue(changePersonalDetailsPage.maritalStatusDropdown.isDisplayed());
    }

    @When("the user updates the personal details with the following data")
    public void the_user_updates_the_personal_details_with_the_following_data(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        changePersonalDetailsPage.firstName.clear();
        sendText(data.get("firstName"),changePersonalDetailsPage.firstName);
        changePersonalDetailsPage.middleName.clear();
        sendText(data.get("middleName"),changePersonalDetailsPage.middleName);
        changePersonalDetailsPage.lastName.clear();
        sendText(data.get("lastName"),changePersonalDetailsPage.lastName);
        click(changePersonalDetailsPage.nationalityDropdown);
        click(driver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + data.get("nationality") + "']")));
        click(changePersonalDetailsPage.maritalStatusDropdown);
        click(driver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + data.get("maritalStatus") + "']")));
        click(changePersonalDetailsPage.genderFemale);

    }
    @When("user clicks the save button")
    public void user_clicks_the_save_button() {
        click(changePersonalDetailsPage.saveButton);
    }
    @Then("personal details should be saved successfully and should be verified in the Database for employee ID {string}")
    public void personal_details_should_be_saved_successfully_and_should_be_verified_in_the_database_for_employee_id(String empId) throws SQLException, InterruptedException {

        String query = "SELECT * FROM hs_hr_employee WHERE emp_number = '" + empId + "';";

        List<Map<String, String>> dbData = DBReader.fetch(query);


        Assert.assertFalse("Error: No data returned from Database for ID: " + empId, dbData.isEmpty());

        Map<String, String> firstRow = dbData.get(0);


        Assert.assertEquals("First Name Mismatch", "Maria", firstRow.get("emp_firstname"));
        Assert.assertEquals("Middle Name Mismatch", "M", firstRow.get("emp_middle_name"));
        Assert.assertEquals("Last Name Mismatch", "Doe", firstRow.get("emp_lastname"));
    }


    }
