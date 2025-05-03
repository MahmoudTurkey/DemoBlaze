Feature: Add product to cart multiple times

  Scenario: Add the same product twice and verify quantity
    Given the user is on the Demoblaze homepage
    When the user adds "Samsung galaxy s6" to the cart twice
    And navigates to the cart page
    Then the cart should contain 1 entries for "Samsung galaxy s6"
