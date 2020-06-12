Feature: Textual Question - Text
 Background:


  Scenario Outline: Textual Question  - Text / Positive
    Given I open <page> page
    When I type <email> into email field
    And I type <password> into password field
    When I click SignIn button
    And I wait for <sec> sec
    And I open <menuLink> link
    And I wait for <sec> sec
    And I click Create New Quiz button
    And I wait for <sec> sec
    And I type title of the quiz as <quizName>
    And I click add question button
    And I select Textual radio button
    And I wait for <sec> sec
    When I type <textualQuestion> into Question field
    And I click on Save button
    And I wait for <sec> sec
    Then I should see quiz <quizName> in the List of Quizzes
    When I open <quizName> quiz for preview
    And I wait for <sec> sec
    And I click on preview button
    Then I should see that the quiz <quizName> contains question <textualQuestion>
    And I close quiz <quizName> preview window
    And I delete existing quiz <quizName> by clicking delete button
    And I wait for <sec> sec
    And I confirm deletion of quiz <quizName>
    And I wait for <sec> sec
    Then I should not see quiz <quizName> in the list of quizzes
    Examples:
      | page    | email               | password | sec | menuLink  | quizName          | textualQuestion               |
      | "login" | "ask_instr@aol.com" | "12345"  | 1   | "Quizzes" | "textual1char"    | "a"                           |
      | "login" | "ask_instr@aol.com" | "12345"  | 1   | "Quizzes" | "textualAlphaNum" | "abc123"                      |
      | "login" | "ask_instr@aol.com" | "12345"  | 1   | "Quizzes" | "textualSpecChar" | "!#$%&()*+,-./:<=>?@\^_{"     |
      | "login" | "ask_instr@aol.com" | "12345"  | 1   | "Quizzes" | "textual50char"   |"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"|
      | "login" | "ask_instr@aol.com" | "12345"  | 1   | "Quizzes" | "textual1000char" |"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"|


  Scenario Outline: Textual Question  - Text / Negative
    Given I open <page> page
    When I type <email> into email field
    And I type <password> into password field
    When I click SignIn button
    And I wait for <sec> sec
    And I open <menuLink> link
    And I wait for <sec> sec
    And I click Create New Quiz button
    And I wait for <sec> sec
    And I type title of the quiz as <quizName>
    And I wait for <sec> sec
    And I click add question button
    And I select Textual radio button
    And I wait for <sec> sec
    When I type <textualQuestion> into Question field
    And I click on Save button
    And I wait for <sec> sec
    Then I should see error message <questionFieldError>
    Then I should not see quiz <quizName> in the list of quizzes


    Examples:
      | page   | email              | password   | sec | menuLink  | quizName            | textualQuestion   | questionFieldError                |
      | "login"| "ask_instr@aol.com"| "12345"    | 1   | "Quizzes" | "textualEmptyField" | ""                | "This field is required"    |
      | "login"| "ask_instr@aol.com"| "12345"    | 1   | "Quizzes" | "textual1001char"   | "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" | "1000 Characters" |


