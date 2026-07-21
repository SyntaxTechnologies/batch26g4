Feature: Adding Employee to HRMS Application

  Background:
    When user login to HRMS application
    And user navigate to PIM page
    And user clicks on Add button

  @Khalid
  Scenario: Adding employee without the employee ID
    And user fill the fields except employee ID
    And user clicks on save button
    Then system should generate employee ID

  @Khalid
  Scenario: Adding employee with the employee ID
    And user fill the fields
    And user clicks on save button
    Then employee is saved successfully

  @Khalid
  Scenario: Incomplete employee information
    And a required field is empty
    And user clicks on save
    Then error message should be displayed