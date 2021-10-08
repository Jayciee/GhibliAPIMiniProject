Feature: The URL endpoint is working
  Scenario: Running the Base URL works
    Given the correct url
    When I run the endpoint
    Then I receive a 200 status
