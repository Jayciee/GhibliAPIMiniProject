Feature: Using the species endpoint should return the correct details
  Scenario: User calls on species endpoint
    Given The species url
    When User sends the API request to get all species
    Then The first response should be "Human"
    And There should be 7 items in the response



