Feature: Quiz creating and assigning end to end

  Scenario Outline: Teacher creates Quiz and assigns it for 5 individual students
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
    And I wait for <sec> sec
    And I click on Save button
    And I wait for <sec> sec
    Then I should see quiz <quizName> in the List of Quizzes
    When I open <menuLink1> link
    And I click Create New Assignment button
    And I click Select Quiz To Assign
    And I select desired quiz <quizName>
    When I click on a Group Filter
    And I select desired group <groupCode> from the drop down list
    And I select students to assign them a quiz
    And I wait for <sec> sec
    And I click on Give Assignment button
    And I wait for <sec> sec
    When I expand <quizName> on the List Of Assignments
    And I wait for <sec> sec
    Then I should see 5 new assignments for students from group <groupCode>
    And I wait for <sec> sec
    And I click on Assignment menu button for quiz <quizName>
    And I wait for <sec> sec
    And I click on Delete Assignment button
    And I wait for <sec> sec
    And I confirm deletion
    And I wait for <sec> sec
    When I open <menuLink> link
    And I wait for <sec> sec
    And I select <quizName> quiz
    And I delete existing quiz <quizName> by clicking delete button
    And I wait for <sec> sec
    And I confirm deletion of quiz <quizName>
    And I wait for <sec> sec
    Then I should not see quiz <quizName> in the list of quizzes



    Examples:
      | page    | email               | password | sec | menuLink  | quizName        | textualQuestion  | menuLink1     | groupCode|
      | "login" | "ask_instr@aol.com" | "12345"  |  2  | "Quizzes" | "textual1char"  | "a"              | "Assignments" |"F547"    |
