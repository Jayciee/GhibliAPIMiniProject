Feature: Studio Ghibli API Films Endpoint

  Scenario: User is able to validate the API Response
    Given The films url
    When User sends the API request to get all the films
    Then User validates the response status is 200


  Scenario Outline: User uses a filter on GET request
    Given The films url
    When User sends the API request with <film>
    Then User validates the response with <id>
    Examples:
      | film                 | id                                   |
      | Castle in the Sky    | 2baf70d1-42bb-4437-b551-e5fed5a87abe |
      | Howl's Moving Castle | cd3d059c-09f4-4ff3-8d63-bc765a5184fa |

  Scenario Outline: User sends an in incorrect film name on GET request
   Given The films url
   When User sends the API request with <film>
   Then User validates the response status is 200
   And User receives empty response
   Examples:
     | film         |
     | My Totoro    |
     | Drifted Away |
     |              |

   Scenario: User sends an invalid api request for getting all films
     Given Incorrect films URI
     When User sends the API request to get all the films
     Then User receives status code of 404

