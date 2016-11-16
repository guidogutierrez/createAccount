Feature: create account test

Scenario: Create account with empty email
  Given I navigate to main page
  Given I click on create account button
  Given I send an empty email and a valid password
  When I submit the user
  Then I get an error message

  Scenario: Create account with a wrong email
    Given I navigate to main page
    Given I click on create account button
    Given I send a wrong email and a valid password
    When I submit the user
    Then I get an error message

Scenario: Create account with an empty password
  Given I navigate to main page
  Given I click on create account button
  Given I send an valid email but with an empty password
  When I submit the user
  Then I get an error message

Scenario: Create account with a shorter password
  Given I navigate to main page
  Given I click on create account button
  Given I send an valid email but with a shorter password
  When I submit the user
  Then I get an error message

Scenario: Create account with a valid email and password but an invalid captcha
  Given I navigate to main page
  Given I click on create account button
  Given I send an valid email and password but with wrong captcha
  When I submit the user
  Then I get an error message