Feature: Login tests

  Scenario: Login to the application using valid user name and password
    Given Login page is displayed using "https://ey-sandbox.alationcatalog.com/"
    When Enter username "maheshwari.p@gds.ey.com" and password "Junej-2023"
    And Click Login button
    #Then Successful login page will display

#  Scenario Outline: Login to the application using valid user name and password
#    Given Login page is displayed using "https://demo.guru99.com/test/login.html"
#    When Enter username "<username>" and password "<password>"
#    And Click Login button
#    Then Successful login page will display
#    Examples:
#    | username | password |
#    | sanooja  | san1234  |
#    | sanooja1  | san12341  |
#    | sanoojawe | san1234sd  |