Feature: friends mock
    Background:
        Given user has these friends
            | userId | f1    | f2   |
            | 1      | James | Jill |

    Scenario:
        When I call GET "/users/1/friends"
        Then I get status code 200
        And I assert 2 entities are returned