Feature: Single Choice Question Scenarios

  Background:
    Given I open login page
    When I type email "ask_instr@aol.com"
    And I type password "12345"
    And I click SignIn button
    And I wait for 1 seconds
    Then text "TEACHER" is displayed
    When I click "Quizzes" link
    And I wait for 2 seconds
    When I click Create New Quiz button
    And I wait for 1 seconds
    And I click quiz title field
    And enter "Test Single-Choice" as quiz title
    When I click Add Question Button

    Scenario: Single Choice Question
      When I select question type "Single-Choice"
      And I wait for 2 seconds
      When I enter "Max 15 Options" as question title
      And I type "Correct answer" into "Option 1" field
      And I type "Answer 2" into "Option 2" field
      When I click Add Option button 11 times
      And I type "Answer" into other 11 fields
      When I click on Option 1 radio button
      And I click "Save" button
      And I wait for 5 seconds
      Then text "List of Quizzes" is displayed
      Then text "Test Single-Choice" is displayed
