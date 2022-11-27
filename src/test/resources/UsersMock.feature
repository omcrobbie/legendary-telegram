Feature: users endpoints
  Background:
    Given userRepository has this data

      | 1 | Jimmy |
      | 2 | Jill  |

  Scenario Outline: client makes call to GET /users

    When I call GET "users/<userid>"
    Then I get status code <status>
    And I assert property "name" is "<name>"

    Examples:
      | userid | name  | status |
      | 1      | Jimmy | 200    |
      | 2      | Jill  | 200    |
      | 3      |       | 404    |

# Scenario Outline: client makes call to POST /users
#   When I call POST <userid>
#   And I get status code <status>
#   And I call GET "/users<userid>"
#   Then I assert <userid> exists

#   Examples:
#     | userid | name  | status |
#     | 4      | James | 201    |

