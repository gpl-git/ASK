Feature: Settings scenarios

  Background:
    Given I open "login" page

  Scenario Outline: Settings - Change Your Name
    When I type <email> into email field
    And I type <password> into password field
    When I click SignIn button
    And I wait for <sec> sec
    Then name <name> is displayed
    When I click <item> menu item
    And I wait for <sec> sec
    When I click Change Your Name button
    And I wait for <sec> sec
    Then I clear Full Name input field
    And I type <newName> into Full Name input field
    And I click Change button
    And I wait for <sec> sec
    Then new User's Name <newName> is displayed
    Examples:
      | email               | password    | sec | name       | item       | newName    |
      | "oiunaan@gmail.com" | "12345"     | 1   | "Oiuna An" | "Settings" | "Oiuna AN" |
      | "oiunaan@gmail.com" | "12345"     | 1   | "Oiuna AN" | "Settings" | "Oiuna An" |




  Scenario Outline: Settings - Change Your Password
    When I type <email> into email field
    And I type <password> into password field
    And I click SignIn button
    And I wait for <sec> sec
    Then name <name> is displayed
    And I wait for <sec> sec
    When I click <item> menu item
    And I wait for <sec> sec
    And I click Change Your Password button
    And I wait for <sec> sec
    Then <txt> pop-up box is displayed
    And I wait for <sec> sec
    When I type <password> into Password input field
    And I type <newPassword> into New Password field
    And I type <newPassword> into Confirm New Password field
    And I click Change button
    Then <txt1> page is displayed
    And I wait for <sec> sec
    When I click <item1> menu item
    Then <txt2> pop-up box is displayed
    And I wait for <sec> sec
    When I click on Log out button
    And I wait for <sec1> sec
    Then <txt3> page is displayed
    And I wait for <sec> sec
    When I type <email> into email field
    And I type <password1> into password field
    And I click SignIn button
    And I wait for <sec> sec
    Then name <name> is displayed
    And I wait for <sec> sec
    Examples:
      | email               | password | sec | name       | item       | txt                 | newPassword | txt1       | item1     | txt2           | sec1 | txt3      | password1 |
      | "oiunaan@gmail.com" | "12345"  | 1   | "Oiuna An" | "Settings" | "Changing Password" | "123456"    | "Settings" | "Log Out" | "Confirmation" | 2    | "Sign In" | "123456"  |
      | "oiunaan@gmail.com" | "123456"  | 1  | "Oiuna An" | "Settings" | "Changing Password" | "12345"     | "Settings" | "Log Out" | "Confirmation" | 2    | "Sign In" | "12345"  |






