Feature: ESS User Change contact details

  Background:
    When user logs in with created ESS user credentials
    And user clicks on MyInfo option
    And user clicks the Contact Details option

 @Nermin3
  Scenario: Verify all fields for updating contact details are displayed and enabled and update contact data
    Then the following contact fields are displayed and enabled
      | street1    |
      | street2    |
      | city       |
      | state      |
      | zipCode    |
      | country    |
      | Home       |
      | work       |
      | mobile     |
      | workEmail  |
      | OtherEmail |

    When the user updates the contact details with the following data
      | street1   | 123 Main St   |
      | street2   | Apt 4B        |
      | city      | New York      |
      | state     | NY            |
      | zipCode   | 10001         |
      | country   | United States |
      | Home      | 23516416513   |
      | work      | 69875523      |
      | mobile    | 1234567890    |
      | workEmail | Nermin256@gmail.com |
      | OtherEmail| hrm@gmail.com |
    And user clicks the save button
    Then contact details are saved successfully for employee ID "4802"