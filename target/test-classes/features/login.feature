Feature: Login functionality

  Scenario: User logs into Advantage Online Shopping

    Given User launches the application
    When User clicks on login icon
    And User enters username "dinesh42dd" and password "Test@123"
    Then User should be logged in successfully