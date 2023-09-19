Feature: Validating Cart

  Scenario: Validate whether empty cart and browse options are visible or not
    Given user opens homepage for cart
    When user clicks on Cart option
    Then user must be able to see Empty Cart and Browse in Cart page
