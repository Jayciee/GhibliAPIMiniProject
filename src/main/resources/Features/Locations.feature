Feature: Using the Studio Ghibli locations endpoint should return the correct details

  Scenario: The user calling on the locations endpoint should return a response
    Given The locations url
    When I run the standalone locations endpoint
    Then I should get a list of locations
    And This list should be of size 24

  Scenario: Using a filter should return results with only that filter appearing
    Given The locations url
    When I run the locations endpoint with climate filter "Continental"
    Then I should get a list of locations
    And This list should only contain "Continental"