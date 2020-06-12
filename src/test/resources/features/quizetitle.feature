Feature: Quiz-Title Scenario

  Scenario Outline: Quiz-Title allowable characters
    Given I open <page> page
    And I type <email> into email field
    And I type <password> into password field
    When I click SignIn button
    And I wait for <sec> sec
    Then I click Quizzes button
    And I wait for <sec> sec
    Then I click Create new Quiz  button
    And I wait for <sec> sec
    Then I Type <input> into input
    And I wait for <sec> sec
    And I click on Add Question button
    And I wait for <sec> sec
    Examples:
      | page    | email               | password | sec | input |
      | "login" | "ask_instr@aol.com" | "12345"  | 2   | "a1@" |
      | "login" | "ask_instr@aol.com" | "12345"  | 2   | "  " |
      | "login" | "ask_instr@aol.com" | "12345"  | 2   | " 1 " |








