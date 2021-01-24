@API
Feature: Search user through API
    In order to find an user
    As anyone
    I want to use the REST API to find an user

    Scenario Outline: Search by login
        Given the login "<login>"
        When the login is used to search for an user
        Then the user should be found
        And the user's login should match the expected one
        Examples:
            | login   |
            | amagyar |
            | java    |
        
