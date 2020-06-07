Feature: Quiz Textual Question
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
    And enter "Test Textual" as quiz title
    When I click Add Question Button

  Scenario Outline: Textual Question text input field  positive-parameterized
    And I wait for 2 seconds
    When I select question type "Textual"
    And I wait for 2 seconds
    And I enter "<questionTitle>" as question title

    Examples:
    |  questionTitle      |
    |  Textual Question   |
    |  T                   |
    |  nbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnn                  |

  Scenario Outline: Textual Question text input field negative-parameterized
    And I wait for 1 seconds
    When I select question type "Textual"
    And I wait for 1 seconds
    And I enter "<questionTitle>" as question title
    And I click space in question title field
    When I clear the question title field
    And I wait for 1 seconds
    Then question title error message "<message>" is displayed

    Examples:
      |  questionTitle      |   message  |
      |         | This field is required.|
      |   a     |   This field is required |
      | 1+bnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnnnbnbnbnbnbnbnbnnmmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnmnn |  No more that 1000 characters     |

  Scenario: Textual Question - displayed on panel title
    And I wait for 2 seconds
    When I select question type "Textual"
    And I wait for 2 seconds
    And I enter "Test Question" as question title
    Then I verify "Test Question" is displayed  on panel title
    And I wait for 5 seconds

  Scenario: Textual Question show-stopper
    And I wait for 2 seconds
    When I select question type "Textual"
    And I wait for 2 seconds
    And I enter "Test Question" as question title
    When I verify "Show-Stopper" selected
    And I wait for 5 seconds