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
    Then I verify current page "login"

  Scenario: Login - Logout
    Given I navigate to "ask" page
    When I login as a "teacher"
    And I logout
    Then I verify current page "login"

  Scenario: Login - Authentication Verification
    Given I navigate to "ask" page
    When I login with "ask_instr@aol.com" and "12345" as "teacher"
    Then I verify user role as "TEACHER"


  Scenario Outline: Login - Error Messages Verification
    Given I navigate to <site> page
    When I login with <email> and <password>
    Then login error <message> should be displayed

     Examples:
      | site  | email               | password |  message                  |
      | "ask" | "ask_instr@aol.com" | ""       |  "This field is required" |
      | "ask" | "ask_instr@aol.com" | " "       |  "Whitespaces are not allowed" |
      | "ask" | "" | "12345"        |  "This field is required" |
      | "ask" | " " | "12345"       | "Should be a valid email address" |
      | "ask" | "ask_instr@aolcom"  | "12345"       |  "Should be a valid email address" |
      | "ask" | "ask_instraol.com"  | "12345"       |  "Should be a valid email address" |

  Scenario Outline: Login - Authentication Error Verification
    Given I navigate to <site> page
    When I login with <email> and <password>
    Then I verify authentication error message <message>
    Examples:
      | site  | email               | password   | message                                     |
      | "ask" | "ask_instr@aol.com" | "12345456" | "User not found or password does not match" |
      | "ask" | "ask_instryyyy@aol.com" | "12345" | "User not found or password does not match" |


