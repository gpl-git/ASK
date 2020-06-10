Feature: Login Scenarios

  Background:
    Given I open "login" page

  Scenario Outline: Login - Happy Path
    When I type "<email>" into email field
    And I type "<password>" into password field
    When I click SignIn button
    And I wait for 1 sec
    Then text "<text>" is displayed
    Examples:
      | email             | password | text    |
      | ask_instr@aol.com | 12345    | TEACHER |
      | test8@test.com    | 12345    | STUDENT |

#    Automate test set User management - change Student name
#    Change options change Student name
  Scenario Outline: Change Student name
    When I type "<email>" into email field
    And I type "<password>" into password field
    When I click SignIn button
    And I wait for 1 sec
    Then text "<text>" is displayed
    And I navigate to the Settings page
    And I click Change Your Name button
    And I wait for 1 sec
    Then "Change Your Name" is displayed
    Then I clear the field
    Then I change Student name to "<name>"
    And I wait for 1 sec
    And I log out
    Examples:
      | email          | password | text    | name          |
      | test8@test.com | 12345    | STUDENT | OLEG IVANOV   |
      | test9@test.com | 12345    | STUDENT | IVAN IVANOV   |


    #    Automate test set "User management - change Student name
    #    Change options change Student name
  Scenario Outline: Teacher change Student name
    When I type "<email>" into email field
    And I type "<password>" into password field
    When I click SignIn button
    And I wait for 1 sec
    Then text "<text>" is displayed
    And I navigate to the User management page
    Then I click to "Students" from mat-card menu
    And I click to student "row number"
    And I click on options button
#
    And I click Change Your Name button
    And I wait for 1 sec
    Then "Change Name" is displayed
    Then I clear the field
    Then I change Student name to "<name>"
    And I wait for 1 sec
    And I log out
    Examples:
      | email            | password | text    | name        |
      |ask_instr@aol.com | 12345    | TEACHER | IVAN IVANOV |



#    Change options change Student group
  Scenario Outline: Change Student group
    When I type "<email>" into email field
    And I type "<password>" into password field
    When I click SignIn button
    And I wait for 1 sec
    Then text "<text>" is displayed
    Examples:
      | email | password | text |
      | test8@test.com    | 12345    | STUDENT |



