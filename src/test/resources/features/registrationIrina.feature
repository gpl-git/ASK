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
    Then text <verificationmessage> displayed
    And I wait for <sec> sec
    Examples:
      | page           | firstName | lastName | email   | groupcode    | password   | confirmpassword    | button        | verificationmessage        | sec |
      | "registration" | "abc"     | "Ana"    | "email" | "group code" | "password" | "confirm password" | "register me" | "You have been registered" | 2   |
      | "registration" | "123"     | "Ana"    | "email" | "group code" | "password" | "confirm password" | "register me" | "You have been registered" | 2   |
      | "registration" | "A"   | "Ana"    | "email" | "group code" | "password" | "confirm password" | "register me"   | "You have been registered" | 2   |

