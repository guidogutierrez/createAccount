Feature: create account

  Background:
    Given I click on create account button

  Scenario: Create account with empty email
    Given I enter an empty email and a valid password
    When I submit the user
    Then I get an error message saying Email is invalid

  Scenario: Create account with a wrong email
    Given I enter a wrong email and a valid password
    When I submit the user
    Then I get an error message saying Email is invalid

  Scenario: Create account with an empty password
    Given I enter an valid email but with an empty password
    When I submit the user
    Then I get an error message saying Password can't be blank

  Scenario: Create account with a shorter password
    Given I enter an valid email but with a shorter password
    When I submit the user
    Then I get an error message saying Password is too short (minimum is 6 characters)

  Scenario: Create account with a valid email and password but an invalid captcha
    Given I enter an valid email and password but with wrong captcha
    When I submit the user
    Then I get an error message saying You typed the CAPTCHA words incorrectly. Please try again.
