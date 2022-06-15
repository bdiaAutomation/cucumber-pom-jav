Feature: As a customer, I want to display loyalties challenge

  Scenario: As a customer, I want to open loyalty challenge list
    Given I am on loyalty summary page
    When I click to loyalty widget
    Then Loyalties list is displayed
