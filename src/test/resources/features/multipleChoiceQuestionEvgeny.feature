Feature: Multiple Choice Question - Text Scenarios. Test Set 364, Test Cases TP-365, TP-366, TP-367, TP-368
  Background:
    Given I open "login" page
    And I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    And I click SignIn button
    And I wait for 1 sec
    And I click on the "Quizzes" menu item
    And I wait for 1 sec
    And I click on the "Create New Quiz" button
    And I wait for 1 sec
    And I input "AAA" in to the "Title Of The Quiz"
    And I click on the "Add Question" button
    And I wait for 1 sec
    And I choose "1" question as "Multiple-Choice"

  Scenario: Verify that Multiple Choice Question - Text field accepts 1000 Alphanumeric & Special characters TP-365
    And I wait for 1 sec
    And I input "1000signs$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" in to Question input field
    And I wait for 1 sec
    And I input "AAA" in to the answer Option "1" field
    And I input "BBB" in to the answer Option "2" field
    And I Include Other text area option in "1" question
    And I click on the element by xPath "//*/ac-question-body-form[1]/div[1]/div[2]/div[1]/div[1]"
    And I click on the "Save" button
    And I wait for 2 sec
    Then I verify that User is able to create a "AAA" Quiz and Message - You created new Quiz - appears

  Scenario: Verify that Multiple Choice Question - Text field accepts 1 character TP-366
    And I input "1" in to Question input field
    And I input "AAA" in to the answer Option "1" field
    And I input "BBB" in to the answer Option "2" field
    And I Include Other text area option in "1" question
    And I click on the element by xPath "//*/ac-question-body-form[1]/div[1]/div[2]/div[1]/div[1]"
    And I click on the "Save" button
    And I wait for 2 sec
    Then I verify that User is able to create a "AAA" Quiz and Message - You created new Quiz - appears

  Scenario: Multiple Choice Question - Text field can't be empty TP-367
    And I wait for 1 sec
    And I input "AAA" in to the answer Option "1" field
    And I input "BBB" in to the answer Option "2" field
    And I Include Other text area option in "1" question
    And I click on the element by xPath "//*/ac-question-body-form[1]/div[1]/div[2]/div[1]/div[1]"
    And I click on the "Save" button
    And I wait for 2 sec
    Then I verify that User is not able to create a Quiz

  Scenario: Verify that Multiple Choice Question - Text field doesn't accept space only TP-368
    And I wait for 1 sec
    And I input " " in to Question input field
    And I input "AAA" in to the answer Option "1" field
    And I input "BBB" in to the answer Option "2" field
    And I Include Other text area option in "1" question
    And I click on the element by xPath "//*/ac-question-body-form[1]/div[1]/div[2]/div[1]/div[1]"
    And I click on the "Save" button
    And I wait for 2 sec
    Then I verify that User is not able to create a Quiz

  Scenario: Multiple Choice Question - Text field doesn't accept 1001 Alphanumeric & Special characters TP-369
    And I wait for 1 sec
    And I input "1001signs$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" in to Question input field
    And I input "AAA" in to the answer Option "1" field
    And I input "BBB" in to the answer Option "2" field
    And I Include Other text area option in "1" question
    And I click on the element by xPath "//*/ac-question-body-form[1]/div[1]/div[2]/div[1]/div[1]"
    And I click on the "Save" button
    And I wait for 2 sec
    Then I verify that User is not able to create a Quiz