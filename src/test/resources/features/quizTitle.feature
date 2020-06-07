Feature: Quiz Title Scenarios

  Background:
    Given I open login page

    Scenario Outline: Quiz title positive input parameterized
      When I type email "ask_instr@aol.com"
      And I type password "12345"
      And I click SignIn button
      And I wait for 1 seconds
      Then text "TEACHER" is displayed
      When I click "Quizzes" link
      And I wait for 2 seconds
      Then I click Create New Quiz button
      And enter "<title>" as quiz title
      When I click Add Question Button
      And I wait for 1 seconds
      Then I click "Back To Quizzes List" button
      And I wait for 1 seconds
      Then I click "Discard" button
      Examples:

      |title |
      |T |
      |Test|
      |bnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnbnbnbnbnbnbnbnbnbnbbnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklklklklklklklklklklklkklkklkyyybnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnbnbnbnbnbnbnbnbnbnbbnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklklklklklklklklklklklkklkklkyyybnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnbnbnbnbnbnbnbnbnbnbbnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklklklklklklklklklklklkklkklkyyynbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklklklklklklklklklklklkklkklkyyynbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklk|




  Scenario Outline: Quiz title negative input parameterized
    When I type email "ask_instr@aol.com"
    And I type password "12345"
    And I click SignIn button
    And I wait for 1 seconds
    Then text "TEACHER" is displayed
    When I click "Quizzes" link
    And I wait for 2 seconds
    Then I click Create New Quiz button
    And enter "<title>" as quiz title
    When I click space in quiz title field
    When I click Add Question Button
    Then quiz title error message "<error>" is displayed
    Examples:

      |title | error |
      |      | Whitespace is not allowed|
      | 1bnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnbnbnbnbnbnbnbnbnbnbbnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklklklklklklklklklklklkklkklkyyybnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnbnbnbnbnbnbnbnbnbnbbnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklklklklklklklklklklklkklkklkyyybnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnbnbnbnbnbnbnbnbnbnbbnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklklklklklklklklklklklkklkklkyyynbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklklklklklklklklklklklkklkklkyyynbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklk     | No more than 1000 characters allowed|







