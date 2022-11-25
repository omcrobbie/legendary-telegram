Feature: users can be retrieved
  Scenario Outline: client makes call to GET /users
    When I call GET <userid>
    Then I get status code <status>
    And I assert property "name" is "<name>"

    Examples:
      | userid | name  | status |
      | 1      | Jimmy | 200    |
      | 2      | Jill  | 200    |
      | 3      |       | 404    |