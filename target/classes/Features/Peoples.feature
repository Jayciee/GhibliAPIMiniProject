Feature: Using the people endpoint should return the correct people
  Scenario Outline: Using <name> return correct <gender>
    Given the people url
    When I run the peopleEndpoint with <name>
    Then I should get the corresponding <gender>
    Examples:
    |name        |gender|
    |Ashitaka    |Male  |
    |Haku        |Male  |
    |Captain Dola|Female|


