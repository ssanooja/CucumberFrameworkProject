Feature: Login tests

  @smoke
  Scenario: Login to the application using valid user name and password
    Given Login page is displayed using "https://demo.guru99.com/test/login.html"
    When Enter username "sanooja" and password "san1234"
    And Click Login button
    Then Successful login page will display

  @smoke
  Scenario Outline: Login to the application using valid user name and password
    Given Login page is displayed using "https://demo.guru99.com/test/login.html"
    When Enter username "<username>" and password "<password>"
    And Click Login button
    Then Successful login page will display
    Examples:
    | username | password |
    | sanooja  | san1234  |