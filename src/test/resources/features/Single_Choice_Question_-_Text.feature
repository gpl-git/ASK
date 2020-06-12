Feature: Single_Choice_Question_-_Text
  Background:
    Given I open "login" page
    And I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    Then I click SignIn button
    And I navigate to Quizzes page

  Scenario Outline: Question field - positive
    Then I push Create New Quiz button
    And I enter Quiz name "<quizName>"
    And I select Single-Choice question type for Q1: new empty question
    When I enter "<questionText>" into the Q1 question field
    And I fill out Option 1 field with "<option1Text>"
    And I fill out Option 2 field with "<option2Text>"
    And I select Option 1 as right answer
    And I push Quiz Save button
    And I wait for 2 sec
    Then I find created Quiz "<quizName>" in the List of Quizzes
    And I wait for 1 sec
    And I verify that Q1 of the Quiz "<quizName>" equals to "<questionText>"
    And I wait for 1 sec
    And I delete the quiz "<quizName>"
    And I wait for 2 sec
    Examples:
      | quizName   | option1Text   |   option2Text |  questionText  |
      | abc | abc | cba | qwe123!!! |
      | abc | abc | cba | q |
      | abc | abc | cba | qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!! |


  Scenario Outline: Question field - negative
    Then I push Create New Quiz button
    And I enter Quiz name "<quizName>"
    And I select Single-Choice question type for Q1: new empty question
    When I enter "<questionText>" into the Q1 question field
    And I fill out Option 1 field with "<option1Text>"
    And I fill out Option 2 field with "<option2Text>"
    And I select Option 1 as right answer
    And I push Quiz Save button
    Then I verify that question error message "<errorText>" appears
    Examples:
      | quizName   | option1Text   |   option2Text |  questionText  | errorText |
      | abc        | abc           | cba           |                | This field is required   |
      | abc        | abc           | cba           | qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!qwer123!!!1 | Text is too long |

  Scenario Outline: Option field - positive
    Then I push Create New Quiz button
    And I enter Quiz name "<quizName>"
    And I select Single-Choice question type for Q1: new empty question
    When I enter "<questionText>" into the Q1 question field
    And I fill out Option 1 field with "<option1Text>"
    And I fill out Option 2 field with "<option2Text>"
    And I select Option 2 as right answer
    And I wait for 1 sec
    And I push Quiz Save button
    And I wait for 2 sec
    Then I find created Quiz "<quizName>" in the List of Quizzes
    And I wait for 1 sec
    And I verify that option 2 of the Q1 of the Quiz "<quizName>" equals to "<option2Text>"
    And I wait for 1 sec
    And I delete the quiz "<quizName>"
    And I wait for 2 sec
    Examples:
      | quizName     | questionText     | option1Text      | option2Text     |
      |  abc         |  abc             |  abc             |  qwe123!!!      |
      |  abc         |  abc             |  abc             |  q              |
      |  abc         |  abc             |  abc             |  qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!! |

  Scenario Outline: Option field - negative
    Then I push Create New Quiz button
    And I enter Quiz name "<quizName>"
    And I select Single-Choice question type for Q1: new empty question
    When I enter "<questionText>" into the Q1 question field
    And I fill out Option 1 field with "<option1Text>"
    And I fill out Option 2 field with "<option2Text>"
    And I select Option 2 as right answer
    And I wait for 1 sec
    And I push Quiz Save button
    Then I verify that option error message "<errorText>" appears
    Examples:
      | quizName     | questionText     | option1Text      | option2Text     | errorText |
      |  abc         |  abc             |  abc             |                 | This field is required         |
      |  abc         |  abc             |  abc             |  qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!qwe123!!!!1 |  Text is too long |
