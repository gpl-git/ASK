Feature: Quiz-Title Scenario
  Scenario: Quiz-Title allowable characters
    Given I open "login"page
    When I type"ask_instr@aol.com"into email
    And I type "12345" into password field
    When I click SignIn button
    And I wait for 2 sec
    Then I click Quizzes button
    And I wait for 2 sec
    Then I click Create new Quiz  button
    And I wait for 2 sec
    Then I Type "a1@" into input
    And I wait for 2 sec
    And I click on Add Question button
    And I wait for 2 sec

