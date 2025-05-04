Feature: Sign Up
  Scenario: Verify that User Can Sign Up Successfully
    When User Click on the Sign up button in the Header.
    And Fill in the "username" and "password" in the signup form.
    And Click on the Sign Up button.
    Then A success message should be displayed: "Sign up successful."