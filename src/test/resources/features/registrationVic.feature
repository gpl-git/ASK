Feature: Registration scenarios
  Scenario Outline: Group code verification Happy path
    Given I open "registration" page
    And I wait for 1 sec
    And I type "email@ghj.com" into email field
    Then I type "12345" into password field
    And I type "12345" into confirm password field
    And I type "John" into First Name field
    Then I type "Doe" into Last Name field
    And I type "<groupcode>" into group code field
    And I click "register me" button
    And I wait for 2 sec
    Then registration message "<registrationmessage>" is displayed

  #first i do groupcode

    Examples:
      | groupcode  | registrationmessage |
      |   123      |You have been Registered. |
      |   abc      |You have been Registered. |
      |  #$%       |You have been Registered. |
      | 1234567890 |You have been Registered. |
      |  123456789 |You have been Registered. |
      |  1         |You have been Registered. |
      |  @         |You have been Registered. |
      | !@#$%^&*() |You have been Registered. |


  Scenario Outline: Group code verification Negative testing
    Given I open "registration" page
    And I wait for 1 sec
    And I type "email@ghj.com" into email field
    Then I type "12345" into password field
    And I type "12345" into confirm password field
    And I type "John" into First Name field
    Then I type "Doe" into Last Name field
    And I type "<groupcode>" into group code field
    And I click "register me" button
    And I wait for 2 sec
    Then message "<errormessage>" is displayed
    Examples:
      | groupcode | errormessage   |
      || This field is required    |
      |12345678901| Should no more than 10 characters |
      |!@#$%^&*()_|Should no more than 10 characters |
      |!@#$%^&*()_+| Should no more than 10 characters |
      |@ 123456789| Should no more than 10 characters |
      |test@test.com| Should no more than 10 characters |


  Scenario Outline:TP 507 Password/confirm password field verification. Happy path
    Given I open "registration" page
    And I wait for 1 sec
    And I type "test@test.com" into email field
    Then I type <password> into password field
    And I type <confirmpassword> into confirm password field
    And I type "John" into First Name field
    Then I type "Doe" into Last Name field
    And I type "123" into group code field
    And I click "register me" button
    And I wait for 2 sec
    Then registration message "<registrationmessage>" is displayed

    Examples:
      | password | confirmpassword |  registrationmessage       |
      | "12345"  | "12345"         |  You have been Registered. |
      | "1234567890123456789012345678901"  | "1234567890123456789012345678901" |  You have been Registered. |
      | "v12345"  | "v12345"         |  You have been Registered. |
      | "#12345"  | "#12345"         |  You have been Registered. |
      | "!@#$%^&*()"  | "!@#$%^&*()"         |  You have been Registered. |
      | "1234567890123456789012345678!@#"  | "1234567890123456789012345678!@#" |  You have been Registered. |


  Scenario Outline: Password/confirm password field verification. Negative
    Given I open "registration" page
    And I wait for 1 sec
    And I type "test@test.com" into email field
    Then I type "<password>" into password field
    And I type "<confirmpassword>" into confirm password field
    And I type "John" into First Name field
    Then I type "Doe" into Last Name field
    And I type "123" into group code field
    And I click "register me" button
    And I wait for 2 sec
    Then password error message "<passworderrormessage>" is displayed

    Examples:
      | password | confirmpassword | passworderrormessage |
      |       |           |    This field is required    |
      |  1    |      1    | Should be at least 5 characters  |
      |  12   |     12    | Should be at least 5 characters  |
      |  @#   |     @#    | Should be at least 5 characters |
      |  @#$^  |    @#$^  | Should be at least 5 characters |
      |  123#  |    123#  | Should be at least 5 characters |
      |  1234 |    1234   | Should be at least 5 characters |
#      | 123456789012345678901234567890123| 123456789012345678901234567890123 |        |
 #     | 123456789012345678901234567890!@#| 123456789012345678901234567890!@# |        |
