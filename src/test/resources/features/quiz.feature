Feature: Quiz Scenarios

  Scenario: Create quiz - textual question
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to Quizzes
    And I create a quiz
    When I provide "Test Quiz" as the title
    And I add a textual question
    Then I set and verify points possible equal to 8
    And I wait for 3 sec
    And I delete the question

  Scenario: Create quiz - single choice
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to Quizzes
    And I create a quiz
    When I provide "Test Quiz" as the title
    And I add a question
    And I select question type as "Single-Choice"
    And I wait for 3 sec
    And I delete the question

  Scenario: Create quiz - multiple choice
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to Quizzes
    And I create a quiz
    When I provide "Test Quiz" as the title
    And I add a question
    And I select question type as "Multiple-Choice"
    And I wait for 3 sec
    And I delete the question

  Scenario: Verify Quiz Title required field
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to Quizzes
    And I create a quiz
    When I provide "T" as the title
    When I clean title field
    Then I validate quiz title error message "This field is required" is displayed
    When I provide "T" as the title
    Then I verify that error message is not displayed