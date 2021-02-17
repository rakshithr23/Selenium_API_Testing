Feature: Verify ducks search in google

  Scenario: Search for Ducks in google
    Given Initiate webdriver
    And I open and navigate to google.com
    When I Search "Ducks" in google
    Then I Verify ducks results are showing - "Duck - Wikipedia"
