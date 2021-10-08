Feature: The URL endpoint is working
  Scenario: Running the Base URL works
    Given I have the baseURL
    When I run the endpoint
    Then I receive a 200 status
