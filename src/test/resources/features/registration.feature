Feature: Registration Scenarios

  Background:
    Given I navigate to "registration" page

  Scenario Outline: First Name positive parameterized
   When I type first name "<firstName>"
   And I type last name "<lastName>"
   And I type email "<email>" at registration
   And I type group code "<groupCode>"
   And I type password "<password>" at registration
   And  I type confirm password "<password>"
   And I click Register Me button
   And I wait for 2 seconds
   Then message "<confirmation>" should be displayed
    Examples:
    | firstName | lastName  | email         | groupCode | password | confirmation              |
    | first1234| Test      | test@test.com | ABC       | 12345    | You have been Registered.  |
    | f        | Test      | test@test.com | ABC       | 12345    | You have been Registered.  |
    | bnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnbnbnbnbnbnbnbnbnbnbbnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklklklklklklklklklklklkklkklkyyyy | Test       | test@test.com | ABC       | 12345    | You have been Registered. |



  Scenario Outline: First Name negative parameterized
    When I type first name "<firstName>"
    And I type last name "<lastName>"
    And I type email "<email>" at registration
    And I type group code "<groupCode>"
    And I type password "<password>" at registration
    And  I type confirm password "<password>"
    And I click Register Me button
    And I wait for 2 seconds
    Then error message "<errorMessage>" should be displayed
    Examples:
      | firstName | lastName  | email         | groupCode | password | errorMessage              |
      |           | Test      | test@test.com | ABC       | 12345    | This field is required  |
      | f r       | Test      | test@test.com | ABC       | 12345    | Whitespaces are not allowed  |
      | rbnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnbnbnbnbnbnbnbnbnbnbbnbbbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnbnnbnbnbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnlklklklklklklklklklklklkklkklkyyyy | Test       | test@test.com | ABC       | 12345    | No more than 254 characters allowed. |


