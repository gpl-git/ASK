Feature: Assignment Scenarios


  Scenario: Teacher creates a Quiz and assigns it to all students
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Assignment for all students" as the title
    And I add 2 textual questions
    When I click "Save" button
    Then I go to "Assignments"
    When I click Create New Assignment
    And I select "Assignment for all students" from the list of Assignments
    Then I select all students
    And I click Give Assignment
    And I wait for 2 sec

  Scenario: Teacher creates a Quiz and assigns it to 5 individual students
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I go to "Quizzes"
    And I create a quiz
    When I type "Assignment for 5 students" as the title
    And I add 2 textual questions
    When I click "Save" button
    Then I go to "Assignments"
    When I click Create New Assignment
    And I wait for 2 sec
    And I select "Assignment for 5 students" from the list of Assignments
    When I select "ABC" group
    Then I select 5 students
    And I wait for 2 sec
