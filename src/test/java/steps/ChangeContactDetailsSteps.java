package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CommonMethods;
import utils.DBReader;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ChangeContactDetailsSteps extends CommonMethods {
    @When("user clicks the Contact Details option")
    public void user_clicks_the_contact_details_option() {
        click(changeContactDetailsPage.contactDetailsOption);

    }

    @Then("the following contact fields are displayed and enabled")
    public void the_following_contact_fields_are_displayed_and_enabled(io.cucumber.datatable.DataTable dataTable) {
        Assert.assertTrue(changeContactDetailsPage.street1.isDisplayed());
        Assert.assertTrue(changeContactDetailsPage.street2.isDisplayed());
        Assert.assertTrue(changeContactDetailsPage.cityLocator.isDisplayed());
        Assert.assertTrue(changeContactDetailsPage.stateLocator.isDisplayed());
        Assert.assertTrue(changeContactDetailsPage.zipCodeLocator.isDisplayed());
        Assert.assertTrue(changeContactDetailsPage.countryDropdown.isDisplayed());
        Assert.assertTrue(changeContactDetailsPage.homePhone.isDisplayed());
        Assert.assertTrue(changeContactDetailsPage.mobilePhone.isDisplayed());
        Assert.assertTrue(changeContactDetailsPage.workPhone.isDisplayed());
        Assert.assertTrue(changeContactDetailsPage.workEmail.isDisplayed());
        Assert.assertTrue(changeContactDetailsPage.otherEmail.isDisplayed());
    }

    @When("the user updates the contact details with the following data")
    public void the_user_updates_the_contact_details_with_the_following_data(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        sendText(data.get("street1"), changeContactDetailsPage.street1);
        sendText(data.get("street2"), changeContactDetailsPage.street2);
        sendText(data.get("city"), changeContactDetailsPage.cityLocator);
        sendText(data.get("state"), changeContactDetailsPage.stateLocator);
        sendText(data.get("zipCode"), changeContactDetailsPage.zipCodeLocator);
        click(changeContactDetailsPage.countryDropdown);
        click(driver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + data.get("country") + "']")));
        sendText(data.get("Home"), changeContactDetailsPage.homePhone);
        sendText(data.get("work"), changeContactDetailsPage.mobilePhone);
        sendText(data.get("mobile"), changeContactDetailsPage.workPhone);
        sendText(data.get("workEmail"), changeContactDetailsPage.workEmail);
        sendText(data.get("OtherEmail"), changeContactDetailsPage.otherEmail);
        click(changeContactDetailsPage.saveButton);
    }


    @Then("contact details are saved successfully for employee ID {string}")
    public void contact_details_are_saved_successfully_for_employee_id(String empId) throws SQLException {
        String query = "SELECT * FROM hs_hr_employee WHERE emp_number = '" + empId + "';";

        List<Map<String, String>> dbData = DBReader.fetch(query);


        Assert.assertFalse("Error: No data returned from Database for ID: " + empId, dbData.isEmpty());

        Map<String, String> firstRow = dbData.get(0);
        String actualStreet1 = firstRow.get("street1") != null ? firstRow.get("street1") : firstRow.get("emp_street1");

        Assert.assertEquals("Street 1 Mismatch in DB", "123 Main St", actualStreet1);
    }

    }