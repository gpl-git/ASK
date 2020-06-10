Feature: Multiple Choice Question - Text Scenarios. Test Set 364, Test Case 365

  Scenario: Verify that Multiple Choice Question - Text field accepts 1000 Alphanumeric & special characters
    Given I open "login" page
    And I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    And I click SignIn button
    And I wait for 1 sec
    And I click on the element by xPath "//h5[contains(text(),'Quizzes')]"
    And I wait for 1 sec
    And I click on the element by xPath "//*[contains(text(),'New Quiz')]"
    And I wait for 1 sec
    And I input "AAA" in to field by xPath "//input[@id='mat-input-2']"
    And I click on the element by xPath "//mat-icon[@class='mat-icon material-icons']"
    And I click on the element by xPath "//div[contains(text(),'Multiple-Choice')]"
    And I input "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaa 23%" in to field by xPath "//textarea[@id='mat-input-3']"
    And I wait for 1 sec
    And I input "AAA" in to field by xPath "//textarea[@placeholder='Option 1*']"
    And I input "BBB" in to field by xPath "//textarea[@placeholder='Option 2*']"
    And I click on the element by xPath "//div[@class='mat-checkbox-inner-container']"
    And I click on the element by xPath "//mat-checkbox[@id='mat-checkbox-2']"
    And I click on the element by xPath "//div[@class='form-controls-container ng-star-inserted']//button[2]"
    Then I verify that User is able to create a "AAA" Quiz and Message - You created new Quiz - appears