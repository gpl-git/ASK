Feature: Registration scenarios
  Scenario Outline: Group code verification Happy path
    Given I open "registration" page
    And I wait for 1 sec
    And I type "email@ghj.com" into email field
    Then I type "12345" into password field
    And I type "12345" into confirm password field
    And I type "John" into First Name field
    Then I type "Doe" into Last Name field
    And I type "12345" into group code field
    And I click "register me" button
    And I wait for 2 sec
    Then registration message "You have been Registered." is displayed

    Examples:
      | groupcode | password | registrationmessage |
      |           |


  Scenario Outline: Group code verification
    Given I open "registration" page
    And I wait for 1 sec
    And I type "email@ghj.com" into email field
    Then I type "12345" into password field
    And I type "12345" into confirm password field
    And I type "John" into First Name field
    Then I type "Doe" into Last Name field
    And I type "12345" into group code field
    And I click "register me" button
    And I wait for 2 sec
    Then registration message "You have been Registered." is displayed
    Examples:
      |       |

