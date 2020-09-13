Feature: Login Scenarios

  Scenario Outline: Login Happy Path
    Given I navigate to <site> page
    When I login as a <userRole>
    Then I verify user role as <userRole1>
    Examples:
      | site  | userRole  |  userRole1 |
      | "ask" | "teacher" |  "TEACHER" |
      | "ask" | "student" |  "STUDENT" |

  Scenario: New User Login - Return to Login Page
    Given I navigate to "ask" page
    When I go to Register page
    And I return to Login Page

  Scenario: Login - Logout
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I logout
    Then I verify current page "login"

