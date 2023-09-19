Feature: Validating Search

Scenario: Validate whether count of items is displayed on search page 

Given user opens homepage for search
When user enters search query
And presses ENTER
Then user must be able to see the count of items displayed