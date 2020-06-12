Feature: Registration Form Scenarios

  Scenario Outline: Registration Happy path
    Given I open <page> page
    When I type <firstName> into First Name field
    And I type <lastName> into Last Name field
    And I type <email> into email field
    And I type <groupcode> into group code field
    And I type <password> into password field
    And I type <confirmpassword> into confirm password field
    Then I click <button> button
    And I wait for 2 sec
    Then text <verificationmessage> displayed

    Examples:
      | page           | firstName | lastName | email          | groupcode    | password   | confirmpassword    | button        | verificationmessage        | sec |
      | "registration" | "abc"     | "Ana"    | "email@abc.com" | "ABC123" | "password" | "password" | "Register Me" | "You have been Registered." | 2   |
      | "registration" | "@#$%&"   | "Ana"    | "email@abc.com" | "ABC123" | "password" | "password" | "Register Me" | "You have been Registered." | 2   |
      | "registration" | "A"       | "Ana"    | "email@abc.com"  | "ABC123" | "password" | "password" | "Register Me" | "You have been Registered." | 2   |
      | "registration" | "1234"    | "Ana"    | "email@abc.com" | "ABC123" | "password" | "password" | "Register Me" | "You have been Registered." | 2   |


  Scenario Outline: Registration First Name
  Given I open <page> page
    When I type <firstName> into First Name field
    And I type <lastName> into Last Name field
    And I type <email> into email field
    And I type <groupcode> into group code field
    And I type <password> into password field
    And I type <confirmpassword> into confirm password field
    Then I click <button> button
    And I wait for 2 sec
    Then error message <errormessage> displayed

    Examples:
    Examples:
      | page           | firstName | lastName | email          | groupcode    | password   | confirmpassword    | button        | errormessage        | sec |
      | "registration" | "ab c"     | "Ana"    | "email@abc.com" | "ABC123" | "password" | "password" | "Register Me" | "Whitespaces are not allowed" | 2   |


