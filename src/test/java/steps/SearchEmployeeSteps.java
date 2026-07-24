package steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CommonMethods;

public class SearchEmployeeSteps extends CommonMethods {


    @When("user enters valid employee full name {string} in Search Field")
    public void user_enters_valid_employee_full_name_in_search_field(String string) {
        waitForElementToBeClickAble(employeeSearchPage.empNameSearchField);
        sendText(string , employeeSearchPage.empNameSearchField);
    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        click(employeeSearchPage.searchButton);
    }
    @Then("user should see the matching employee record with name {string}")
    public void user_should_see_the_matching_employee_record_with_name(String expectedFullName) {
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(employeeSearchPage.firstNameCell)));
        String actualFirstName = employeeSearchPage.firstNameCell.getText();
        String actualLastName = employeeSearchPage.lastNameCell.getText();
        String actualFullName = actualFirstName + " " + actualLastName;
        System.out.println("Actual Full Name from Table: [" + actualFullName + "]");
        System.out.println("Expected Full Name from Feature: [" + expectedFullName + "]");

        Assert.assertTrue("Employee name does not match!",
                actualFullName.equalsIgnoreCase(expectedFullName.trim()) ||
                        expectedFullName.toLowerCase().contains(actualFirstName.toLowerCase()));
    }

    @When("user enters partial name {string} in employee name field")
    public void user_enters_partial_name_in_employee_name_field(String string) {
        sendText(string , employeeSearchPage.empNameSearchField);
    }

    @Then("user should see all matching employee records containing {string} in the table")
    public void user_should_see_all_matching_employee_records_containing_in_the_table(String string) {
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(employeeSearchPage.firstNameCell)));
        String actualPartialName = employeeSearchPage.firstNameCell.getText();
        Assert.assertTrue("Employee name does not match!", actualPartialName.toLowerCase().contains(string.toLowerCase()));
    }

    @When("user enters valid employee id {string} in employee id field")
    public void user_enters_valid_employee_id_in_employee_id_field(String string) {
        sendText(string , employeeSearchPage.empIdSearchField);
    }

    @Then("user should see the exact employee record associated with id {string}")
    public void user_should_see_the_exact_employee_record_associated_with_id(String string) {
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(employeeSearchPage.IDCell)));
        String actualID = employeeSearchPage.IDCell.getText().trim();
        Assert.assertTrue("Employee ID does not match!", actualID.contains(string.trim()));
    }


    @When("user enters non-existing employee name {string}")
    public void user_enters_non_existing_employee_name(String string) {
        sendText(string , employeeSearchPage.empNameSearchField);
    }
    @Then("user should see {string} message in the result table")
    public void user_should_see_message_in_the_result_table(String string) {
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(employeeSearchPage.ErrorMessageCell)));
        String errorMessage = employeeSearchPage.ErrorMessageCell.getText();
        Assert.assertTrue("Employee name does not match!", errorMessage.contains(string));
    }
}