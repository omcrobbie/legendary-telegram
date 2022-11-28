Feature: create and validate users
    Scenario: client makes call to POST /users
        When I call POST "/users" with payload from "createUser"
        And I get status code 201
        And I call GET "/users"
        Then I assert entity with "name" "James" exists in response
