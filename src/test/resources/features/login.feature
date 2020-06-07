Feature: Login Scenarios
  Background:
    Given I open login page

  Scenario: Login - Happy Path
    When I type email "ask_instr@aol.com"
    And I type password "12345"
    And I wait for 5 seconds
    When I click SignIn button
    Then text "TEACHER" is displayed

  Scenario Outline: Verification of error messages
    When I type email "<email>"
    And I type password "<password>"
    When I click SignIn button
    Then email error message "<message>" is displayed
    Examples:
    | email             | password | message                           |
    |ask_instaol.com    |   12345  |  Should be a valid email address  |
    |                   |   12345  |  This field is required           |
    |ask_instr@aol.com  |   1234   |  Should be a valid email address  |
    |ask_instr@aol.com  |          |  This field is required           |



  Scenario: Login - empty email
    When I type email " "
    And I type password "12345"
    Then email error message "This field is required" is displayed

  Scenario: Login - invalid password
    When I type email "ask_instr@aol.com"
    And I type password "1234"
    And I wait for 3 seconds
    When I click SignIn button

  Scenario: Login - empty password
    When I type email "ask_instr@aol.com"
    And I type password ""
    And I wait for 3 seconds
    When I click SignIn button
    Then email error message "This field is required" is displayed

  Scenario: Login - password alphanumeric
    When I type email "ask_instr@aol.com"
    And I type password "12345ABC "
    And I wait for 3 seconds
    When I click SignIn button
    Then text "TEACHER" is displayed



