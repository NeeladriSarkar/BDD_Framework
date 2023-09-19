Feature: Title Validation

  Scenario: Validate whether page title is correct or not
    Given user opens website for title
    When user lands on website
    Then title is verified
