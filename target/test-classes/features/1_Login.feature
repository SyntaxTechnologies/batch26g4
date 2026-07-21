Feature: Login Related Functionality

  Background:
    Given user is able to launch HRMS application

  @valid
  Scenario: Valid username and valid password
    When user enters valid username and valid password
    And user clicks on login button
    Then user is logged in successfully

  @error
  Scenario: Valid username and invalid password
    When user enters valid username and invalid password
    And user clicks on login button
    Then the system shows "Invalid credentials"
    And the user remains on the login page
    When user enters the correct password
    And user clicks on login button
    Then user is logged in successfully

  @emptyPassword
  Scenario: Valid username and empty password
    When user enters valid username and leaves password empty
    And user clicks on login button
    Then the system shows "Required" for the password field

  @emptyUserName
  Scenario: Empty username and valid password
    When user leaves username empty and enters a valid password
    And user clicks on login button
    Then the system shows "Required" for the username field

  @emptyUser&Password
  Scenario: Empty username and empty password
    When user leaves username and password empty
    And user clicks on login button
    Then the system shows "Required" for both username and password fields

