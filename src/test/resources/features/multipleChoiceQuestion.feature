Feature: Multiple Choice Question Scenarios

  Scenario: Multiple Choice Happy Path
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Test Quiz _MC" as the title
    And I add a question
    And I select question type as "Multiple-Choice"
    And I wait for 3 sec
    When I type "Question 1" as question "Q1" option "Question *"
    And I wait for 1 sec
    And I type "Option 1" as question "Q1" option "Option 1*"
    When I type "Option 2" as question "Q1" option "Option 2*"
    And I check checkbox "Option 1*" as correct answer in question "Q1"
    And I click "Save" button
    Then I select "Test Quiz _MC" from the list of quizzes
    And I delete quiz "Test Quiz _MC"

  Scenario: Multiple Choice - Choice Error message validation
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Test Quiz _MC" as the title
    And I add a question
    And I select question type as "Multiple-Choice"
    And I wait for 3 sec
    When I type "Question 1" as question "Q1" option "Question *"
    And I wait for 1 sec
    And I type "Option 1" as question "Q1" option "Option 1*"
    When I type "Option 2" as question "Q1" option "Option 2*"
    And I click "Save" button
    Then choice error message "*Choose at least one correct answer" should be displayed

  Scenario: Multiple Choice - max number of options
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Test Quiz _MC_MaxNo" as the title
    And I add a question
    And I select question type as "Multiple-Choice"
    And I wait for 3 sec
    When I type "Question 1" as question "Q1" option "Question *"
    And I wait for 1 sec
    And I type "Option 1" as question "Q1" option "Option 1*"
    When I type "Option 2" as question "Q1" option "Option 2*"
    And I check checkbox "Option 1*" as correct answer in question "Q1"
    Then I add 3 more options to "Q1"
    And I click "Save" button
    Then I select "Test Quiz _MC_MaxNo" from the list of quizzes
    And I delete quiz "Test Quiz _MC_MaxNo"
