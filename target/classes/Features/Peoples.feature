Feature: Using the people endpoint should return the correct details
  Scenario Outline: Using <name> return correct <gender>
    Given the people url
    When I run the peopleEndpoint and search name with <name>
    Then I should get the corresponding <gender>
    Examples:
    |name        |gender|
    |Ashitaka    |Male  |
    |Haku        |Male  |
    |Captain Dola|Female|


  Scenario: Inputting Female should return all the female characters
    Given the people url
    When I run the peopleEndpoint with Female
    Then I should get a list of all the Female characters

