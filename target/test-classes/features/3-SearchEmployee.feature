Feature: Search Employee Functionality in HRMS application

  Background:
    When user enters valid username and valid password
    And user clicks on login button
    Then user is logged in successfully
    And user navigate to PIM page

  @Nermin
  Scenario: Search employee by  full name
    When user enters valid employee full name "aaa bbb" in Search Field
    And user clicks on search button
    Then user should see the matching employee record with name "aaa bbb"

  @Nermin
  Scenario: Search employee by partial name and case insensitivity
    When user enters partial name "aaa" in employee name field
    And user clicks on search button
    Then user should see all matching employee records containing "aaa" in the table

  @Nermin
  Scenario: Search employee by unique Employee ID
    When user enters valid employee id "1872" in employee id field
    And user clicks on search button
    Then user should see the exact employee record associated with id "1872"

  @Nermin
  Scenario: Search employee with non-existing credentials
    When user enters non-existing employee name "Monika"
    And user clicks on search button
    Then user should see "No Records Found" message in the result table