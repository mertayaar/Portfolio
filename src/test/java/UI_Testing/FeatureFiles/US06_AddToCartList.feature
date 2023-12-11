Feature: Checking Added Items to the Cart
  As a user, I would like to verify the number of products I have added in the shopping cart by following certain steps on the website.
  So that, I can check whether my orders have been successfully added to the cart.

  Background: Login
    Given Navigate to Web Page
    And Click on The Element
      | signInButton |
    And Enter Data in Text Box
      | emailInput    | merttester19@gmail.com |
      | passwordInput | test12345              |
    And Click on The Element
      | loginButton |
    And Verification Process
      | loginSuccess | Welcome to your account. |

  @Regression @Product @Cart
  Scenario: US06_AddToCartList
    Given Click on The Element
      | dresses |
    And Hover On The Element
      | product1 |
    And Click on The Element
      | addToCart1             |
      | continueShoppingButton |
    And Hover On The Element
      | product2 |
    And Click on The Element
      | addToCart2 |
    And Click on The Element
      | closeWindow |
    And Hover On The Element
      | product3 |
    And Click on The Element
      | addToCart3  |
      | closeWindow |
    And Hover On The Element
      | shoppingCart |
    When Click on The Element
      | checkOutButton |
    Then Length of the "cartItemList" list equal to "3"
