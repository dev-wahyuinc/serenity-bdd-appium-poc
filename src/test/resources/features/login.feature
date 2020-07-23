Feature: Login

  @login @regression @negative
  Scenario Outline: Invalid email format
    Given filled email with "<email>"
    When submit login
    Then should see alert error Valid Email
    Examples:
      |           email               |
      |           aaaa                |
      |           email.co            |
      |           email@gmail         |
      |           email#gmail.com     |
      |           @gmail.com          |

  @test @login @regression
  Scenario: Invalid login
    Given in login screen
    When user wrong password and email
    Then should see Error Login

  @test @login @regression
  Scenario: Authentication with unregister email
    Given in login screen
    When user using unregister email or account
    Then should see Error Login

  @test @login @regression @validlogin
  Scenario: Login succesful
    Given in login screen
    When log in using a valid email address and password
    Then should be access to his account
