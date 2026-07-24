Feature: Edit Personal Details for ESS User

  Background:
    When user logs in with created ESS user credentials
    And user clicks on MyInfo option

@Nermin2
  Scenario: Verify all Fields are displayed and Update Personal Details
  Then The Following Fields are displayed and enabled
    | firstName     |
    | middleName    |
    | lastName      |
    | nationality   |
    | maritalStatus |
    | gender        |

    When the user updates the personal details with the following data

      | firstName     | Maria   |
      | middleName    | M       |
      | lastName      | Doe    |
      | nationality   | Egyptian |
      | maritalStatus | Single   |
      | gender        | Female   |
    And user clicks the save button
    Then personal details should be saved successfully and should be verified in the Database for employee ID "4802"