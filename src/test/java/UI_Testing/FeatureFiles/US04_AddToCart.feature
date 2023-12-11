Feature: Adding Product to Cart func
  As a user, I want to add a product to the cart using the web application.
  so that, I can add the products I want to the cart and then complete the shopping process.


  @Smoke @Regression @Cart
  Scenario: US04_AddToCart
    Given Navigate to Web Page
    And Hover On The Element
      | womenCategory |
    And Click on The Element
      | summerDresses |
    And Hover On The Element
      | product1 |
    When Click on The Element
      | addToCart1 |
    Then Verification Process
      | cartLayerTitle | successfully added to your shopping cart |



