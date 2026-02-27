Feature: Login tests

  @smoke
  Scenario: Login with valid user
    Given user logs in using data "validUser"
    Then Successful login page will display

  @smoke
  Scenario: Login with invalid user
    Given user logs in using data "invalidUser"
    Then Error message should be displayed
