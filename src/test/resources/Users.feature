Feature: users can be retrieved
  Scenario: client makes call to GET /users
    When I call GET "/users/1"
    Then I get status code 200
    And I assert the name is "John"