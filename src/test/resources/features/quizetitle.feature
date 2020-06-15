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
      | "login" | "ask_instr@aol.com" | "12345"  | 2   | " 122345677890--0987654311134456678890-976543223456780987654323456789009876543234890987654323458909876543456789098765456789876545678987656789876545678909876543q3456790-09876543234567890987654 " |
      | "login" | "ask_instr@aol.com" | "12345"  | 2   | " 1 " |


  Scenario Outline: Quiz-Title  negative
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
    And I should see message <message>
    And I wait for <sec> sec
    Examples:
      | page    | email               | password | sec | input | message                  |
      | "login" | "ask_instr@aol.com" | "12345"  | 3   | " "   | "This field is required" |
     ## TEST FAIL!!!!BUG!!!!









