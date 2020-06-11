Feature: User Management

  Background:
    Given I open the "login" page


  Scenario Outline: Login - Happy Path
    When I type the "<email>" into email field
    And I type the "<password>" into password field
    When I click the SignIn button
    And I wait 1 sec
    Then the text "<text>" is displayed
    Examples:
      | email             | password | text    |
      | ask_instr@aol.com | 12345    | TEACHER |
      | test8@test.com    | 12345    | STUDENT |


  Scenario Outline: Student Change Student name
    When I type the "<email>" into email field
    And I type the "<password>" into password field
    When I click the SignIn button
    And I wait 1 sec
    Then the text "<text>" is displayed
    And I navigate to the "Settings" page
    And I click Change Your "<name>" button
    And I wait 2 sec
    Then I clear the field
    And I wait 2 sec
    Then I change Student "name" to "<newName>"
    And I wait 2 sec
    And I log out
    Examples:
      | email          | password | text    |   newName      |
      | test8@test.com | 12345    | STUDENT |    OLEG IVANOV |
      | test9@test.com | 12345    | STUDENT |    IVAN IVANOV |





    #    Automate test set "User management - change Student name
    #    Change options change Student name
  Scenario Outline: Teacher change Student name
    When I type the "<email>" into email field
    And I type the "<password>" into password field
    When I click the SignIn button
    And I wait 1 sec
    Then the text "<text>" is displayed
    And I navigate from "<menu>" to User management page
    Then I click to "Students" from mat-card menu
    And I click to student "<StudentName>"
    And I click on "options" button
    And I wait 1 sec
    And I click "Change User's Name" link
    And I wait 1 sec
    Then I clear the field
    Then I change Student Name to the "<NewName>"
    And I wait 1 sec
    And I click "Change"
    And I wait 2 sec
    Then Student's name is changed
    And I log out
    Examples:
      | email            | password | text    |StudentName           |NewName               |menu              |
      |ask_instr@aol.com | 12345    | TEACHER | Krasimira QA-student  |Krasimira Student    |Users Management  |



#    Change options change Student group
  Scenario Outline: Change Student group
    When I type the "<email>" into email field
    And I type the "<password>" into password field
    When I click the SignIn button
    And I wait 1 sec
    Then the text "<text>" is displayed
    And I navigate from "<menu>" to User management page
    Then I click to "Students" from mat-card menu
    And I click to student "<StudentName>"
    And I click on "options" button
    And I wait 1 sec
    And I click the "Change User's group" link
    And I wait 1 sec
    Then I clear the field
    Then I change Student group to the "<NewGroup>"
    And I wait 1 sec
    And I click the "Change"
    And I wait for 1 sec
    Then User's group is changed
    Examples:
      | email            | password | text    |  StudentName         | NewGroup  |      menu        |
      |ask_instr@aol.com | 12345    | TEACHER |Krasimira Student     |  123!!      |Users Management  |




