@UI
Feature: Search user through UI
    In order to find an user
    As anyone
    I want to use the UI to find an user

    Scenario: Navigate to landing page
        Given browser is started
        When browser navigates to landing page
        Then the landing page is loaded
        When search for login "amagyar" on landing page is executed
        Then the search result page is loaded
        When the button Users is clicked on search result nav menu
        Then the search result should relate to search term