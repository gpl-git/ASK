Feature: Registration form Scenario

  Scenario Outline: Registration Happy path
    Given I open <page> page
    When I type <firstName> into First Name field
    And I type <lastName> into Last Name field
    And I type <email> into email field
    And I type <groupcode> into group code field
    And I type <password> into password field
    And I type <confirmpassword> into confirm password field
    Then I click <button> button
    Then text <verificationmessage> displayed
    And I wait for <sec> sec
    Examples:
      | page           | firstName | lastName | email   | groupcode    | password   | confirmpassword    | button        | verificationmessage        | sec |
      | "registration" | "abc"     | "Ana"    | "email" | "group code" | "password" | "confirm password" | "register me" | "You have been registered" | 2   |
#    My question: This is the new data to check how to put it into the Scenario outline this data I dont want to hard code (or write the same code again )"@#$"
#    My second scenario passed but how can I prove it that it passed if I wont write it down the scenario outloine
#    The 3th test case passed with 123 firsName field and I still dont know what should I do with scenario outline
#    The 4th case said leave the empty space and I shoulf verify error message should I write different Scenario

# When I type <firstName> into First Name field

#Scenario: Verify empty firstName field  (ask Galina)
#  Given I open "page" page
#  When I do not type into First Name field
