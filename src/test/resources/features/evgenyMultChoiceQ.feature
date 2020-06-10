Feature: Multiple Choice Question - Text Scenarios. Test Set 364, Test Case 365

  Scenario: Verify that Multiple Choice Question - Text field accepts 1000 Alphanumeric & special characters
    Given I open "login" page
    And I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    And I click SignIn button
    And I click on the element by xPath "xPath"
    And I wait for 3 sec
