Feature: Settings scenarios

  Scenario Outline: Settings - change name
    Given I open <page> page
    When I type <email> into email field
    And I type <password> into password field
    When I click SignIn button
    And I wait for <sec> sec
    Then name <name> is displayed
    When I click Settings menu item
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
      | page    | email               | password    | sec | name       | newName    |
      | "login" | "oiunaan@gmail.com" | "sas041326" | 1   | "Oiuna AN" | "Oiuna An" |

