Feature: users can be retrieved
  Scenario: client makes call to GET /users
    When the client call /users
    Then the client receives status code of 200