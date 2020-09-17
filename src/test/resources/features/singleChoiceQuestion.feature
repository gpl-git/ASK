@smoke1
Feature: Single choice question - Text
  Scenario: Quiz - Single Choice
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Test Quiz" as the title
    And I add a question
    And I select question type as "Single-Choice"