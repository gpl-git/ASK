Feature: Registration Scenarios

  Scenario: Registration Happy Path
    Given I navigate to "ask" page
    And I go to Register page
    When I fill out the registration form
    And I wait for 2 sec
    Then I verify that registration is complete

  Scenario Outline: Registration First Name - Error Messages Verification
    Given I navigate to <site> page
    And I go to Register page
    When I type <firstName> into first name field
    And I type <lastName> into last name field
    When I type <email> into email field
    And I type <group> into group code field
    When I type <password> into password field
    And I type <password> into  confirm password field
    When I submit registration form
    Then error message <message> should be displayed
    And I wait for 3 sec

       Examples:
      | site  | firstName |  lastName | email          | group | password |  message                       |
      | "ask" | " "       |  "Last"   | "test@123.com" | "XYZ" | "12345"  |  "Whitespaces are not allowed" |
      | "ask" | "wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewwewwewewewewewewewewewewewewewwewewewewewewewewewwewewewewewewewewwewweweww"  |  "Last"   | "test@123.com" | "XYZ" | "12345"  |  "Too long. Should be no more than 254 characters" |
      | "ask" | ""       |  "Last"   | "test@123.com" | "XYZ" | "12345"  |  "This field is required" |

  Scenario Outline: Registration Last Name - Error Messages Verification
    Given I navigate to <site> page
    And I go to Register page
    When I type <firstName> into first name field
    And I type <lastName> into last name field
    When I type <email> into email field
    And I type <group> into group code field
    When I type <password> into password field
    And I type <password> into  confirm password field
    When I submit registration form
    Then error message <message> should be displayed
    And I wait for 3 sec
    Examples:
      | site  | firstName     | lastName | email          | group | password | message                                |
      | "ask" | "First" | ""   | "aga@test.com" | "123" | "12345"  | "This field is required"               |
      | "ask" | "First" | "La st"   | "aga@test.com" | "123" | "12345"  | "Whitespaces are not allowed"         |
      | "ask" | "First"  | "wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewewewewewewewewewewewewewewwewwewewewewewewewewewewewewewwewewewewewewewewewwewewewewewewewewwewweweww"   | "aga@test.com" | "123" | "12345"  | "Too long. Should be no more than 254 characters" |

  Scenario Outline: Registration Email - Error Messages Verification
    Given I navigate to <site> page
    And I go to Register page
    When I type <firstName> into first name field
    And I type <lastName> into last name field
    When I type <email> into email field
    And I wait for 3 sec
    And I type <group> into group code field
    When I type <password> into password field
    And I type <password> into  confirm password field
    When I submit registration form
    Then error message <message> should be displayed
    And I wait for 3 sec
    Examples:
      | site  | firstName  | lastName | email          | group | password | message      |
      | "ask" | "First"    | "Last"   | "" | "123" | "12345"  | "This field is required"               |
      | "ask" | "First"    | "Last"   | "aga@test. com" | "123" | "12345"  | "Should be a valid email address" |
      | "ask" | "First"    | "Last"   | "wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewewW@abc.com" | "123" | "12345"  | "Should be a valid email address" |
      | "ask" | "First"    | "Last"   | "wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewew@wewewewewewewewewewewewewewewewewewewewewewewweweweweweweweweweW.com" | "123" | "12345"  | "Should be a valid email address" |
      | "ask" | "First"    | "Last"   | "wewewewewewewewewewewewewewewewewewewewewewewwewewewewewewewewew@wew.wewewewewewewewewewewewewewewewewewewewewewewweweweweweweweweweW" | "123" | "12345"  | "Should be a valid email address" |
