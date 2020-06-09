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
      |  email            | password | text   |
      | ask_instr@aol.com | 12345   |TEACHER  |
      |  test8@test.com   | 12345   | STUDENT |



