Feature: Validate Track Orders

Scenario: Validating whether error message appears when wrong details are entered

Given user opens homepage for tracking order
When user clicks on Track Orders
And enters order number and phone number
And clicks on submit
Then user must be able to see error message