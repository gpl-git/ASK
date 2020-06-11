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
    Then button Change Your Name is displayed
    When I click Change Your Name button
    And I wait for <sec> sec
    Then pop-up box Change Your Name is displayed
    Then I clear Full Name input field
    And I type <newName> into Full Name input field
    And I click Change button
    And I wait for <sec> sec
    Then new User's Name <newName> is displayed
    Examples:
      | email               | password    | sec | name       | item       | newName    |
      | "oiunaan@gmail.com" | "sas041326" | 1   | "Oiuna An" | "Settings" | "Oiuna AN" |


  Scenario Outline: Settings - Change Your Password
    When I type <email> into email field
    And I type <password> into password field
    When I click SignIn button
    And I wait for <sec> sec
    Then name <name> is displayed
    When I click <item> menu item
    And I wait for <sec> sec
    Then button Change Your Password is displayed
    When I click Change Your Password button
    And I wait for <sec> sec
    Then pop-up box Changing Password is displayed
    And I wait for <sec> sec
    When I type <password> into Password input field
    And I type <newPassword> into New Password field
    And I type <newPassword> into Confirm New Password field
    And I click Change button
    And I wait for <sec> sec
    Then Settings page is displayed
    When I click <item1> menu item
    Then Confirmation window is displayed
    When I click on Log out button
    Then Login page is displayed
    And I wait for <sec> sec
    When I type <email> into email field
    And I type <password1> into password field
    When I click SignIn button
    And I wait for <sec> sec
    Then name <name> is displayed
    Examples:
      | email               | password    | sec | name       | item       | newPassword | item1     | password1 |
      | "oiunaan@gmail.com" | "sas041326" | 1   | "Oiuna An" | "Settings" | "123456"    | "Log Out" | "123456"  |



      

