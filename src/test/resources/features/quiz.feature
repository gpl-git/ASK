Feature: Quiz Scenarios

  Scenario: Create quiz - textual question - default settings
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Test Quiz" as the title
    And I add a textual question
    Then I set and verify points possible equal to 3
    And I wait for 3 sec
    And I delete the question

  Scenario: Create quiz - single choice question
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Test Quiz" as the title
    And I add a question
    And I select question type as "Single-Choice"
    And I wait for 3 sec
    And I delete the question

  Scenario: Create quiz - multiple choice question
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Test Quiz" as the title
    And I add a question
    And I select question type as "Multiple-Choice"
    And I wait for 3 sec
    And I delete the question

  Scenario: Verify Quiz Title Min and Max Length Input
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "T" as the title
    And I clean title field
    Then I validate quiz title error message "This field is required" is displayed
    When I type "wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewwew.wewewe" as the title
    And I clean title field
    When I type "wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewwew.wewewwew.weweweW" as the title
    When I validate quiz title error message "This field is required" is displayed
    Then I validate quiz title error message "Too long. Should be no more than 1000 characters." is displayed

  Scenario: Verify Quiz - Add Questions
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Test Quiz_Number of Questions" as the title
    And I add 10 textual questions
    When I click "Save" button
    And I wait for 1 sec
    When I select "Test Quiz_Number of Questions" from the list of quizzes
    Then I validate that quiz "Test Quiz_Number of Questions" has 10 questions
    And I delete quiz "Test Quiz_Number of Questions"



