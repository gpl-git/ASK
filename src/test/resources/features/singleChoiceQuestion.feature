@smoke1
Feature: Single choice question - Text - Happy Path

  Scenario: Quiz - Single Choice
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Test Quiz - Single Choice" as the title
    And I add a question
    And I select question type as "Single-Choice"
    When I type "Test Question Title" as question "Q1" option "Question *"
    When I type "Test Option 1" as question "Q1" option "Option 1*"
    And I type "Test Option 2" as question "Q1" option "Option 2*"
    When I select radio button "Option 1*" as correct answer in question "Q1"
    And I click "Save" button
    Then I select "Test Quiz - Single Choice" from the list of quizzes
    And I delete quiz "Test Quiz - Single Choice"

  Scenario Outline: Single choice question - Validation of mix/max input
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Quiz-Single Choice Text Min Input" as the title
    And I add a question
    And I select question type as "Single-Choice"
    When I type <textTitle> as question "Q1" option "Question *"
    When I type <textOption1> as question "Q1" option "Option 1*"
    And I type <textOption2> as question "Q1" option "Option 2*"
    When I select radio button "Option 1*" as correct answer in question "Q1"
    And I click "Save" button
    Then I validate question error message <errMessage> is displayed

    Examples:
      | textTitle             | textOption1    | textOption2    | errMessage               |
      | ""                    | "Test Option1" | "Test Option2" | "This field is required" |
      | "Test Question Title" | ""             | "Test Option2" | "This field is required" |
      | "Test Question Title" | "Test Option1" | ""             | "This field is required" |

  Scenario: Single choice question - max number of options
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    When I create a quiz
    And I type "Test SC - max No of questions" as the title
    Then I add a question
    And I select question type as "Single-Choice"
    When I type "Test Question Title" as question "Q1" option "Question *"
    And I type "Test Option 1" as question "Q1" option "Option 1*"
    When I type "Test Option 2" as question "Q1" option "Option 2*"
    And I select radio button "Option 1*" as correct answer in question "Q1"
    Then I add 3 more options to "Q1"
    And I click "Save" button
    Then I select "Test SC - max No of questions" from the list of quizzes
    And I delete quiz "Test SC - max No of questions"


  Scenario: Single choice question - show-stopper
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    When I create a quiz
    And I type "Test SC - ShowStopper" as the title
    Then I add a question
    And I select question type as "Single-Choice"
    When I type "Test Question Title" as question "Q1" option "Question *"
    And I type "Test Option 1" as question "Q1" option "Option 1*"
    When I type "Test Option 2" as question "Q1" option "Option 2*"
    And I select radio button "Option 1*" as correct answer in question "Q1"
    And I click Show-Stopper checkbox
    And I wait for 2 sec
    Then I verify that question is marked as Show_Stopper