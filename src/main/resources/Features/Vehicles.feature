Feature: Studio Ghibli Vehicles Endpoint

  Scenario: User is able to validate the API Response
    Given The vehicles url
    When User sends the API request to get all vehicles
    Then User receives the correct response code

  Scenario Outline: User is able to find vehicles by name
    Given The vehicles url
    When User sends the API request using <vehicle> name
    Then User validates the response with <id>
    Examples:
      | vehicle               | id                                   |
      | Air Destroyer Goliath | 4e09b023-f650-4747-9ab9-eacf14540cfb |
      | Sosuke's Boat         | 923d70c9-8f15-4972-ad53-0128b261d628 |