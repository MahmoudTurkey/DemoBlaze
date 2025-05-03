Feature: add products to the cart.
  Scenario: Verify that the user can add products to the cart.
    # LogIn
    When User Click on the Log in button in the Header.
    And Fill in the "username" and "password" in the login form and Click on the Log In button.
    Then The account should open successfully, and the user should be logged in.


    # Add First Product
    Given User click on Laptops under categories on the homepage
    And User select Product  Sony vaio i5
    And User click on the Add to Cart button
    Then User should see a confirmation message "Product added"

    #Step 3 : Add Second Product to Cart
    When User click on Laptops under categories on the homepage again
    And User select Product  MacBook air
    Then User click on the Add second to Cart button and see a confirmation message "Product added"


    #Step 4: Validate Cart
    Given User click on the cart button in the header
    Then User should see both products "Sony vaio i5" and "MacBook air" in the cart with their respective "titles" and "prices"


    #Step 5: Verify Total Amount Calculation
    Given User validate the total amount displayed in the cart
    Then The total amount should be calculated correctly based on the prices of both products


    # Step 6: Proceed to Checkout
    Given User click on the Place Order button
    When User fill in my purchase details:
    And  User click on the purchase button
    Then User should see a success message "Thank you for your purchase!"