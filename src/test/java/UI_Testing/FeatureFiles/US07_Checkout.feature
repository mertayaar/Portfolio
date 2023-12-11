Feature: Checking Added Items to the Cart
  As a user, I would like to order the products I added to the website
  and complete the payment process.
  This way, I can buy the products I want and pay safely.

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

  @Smoke @Regression @Product @Checkout @Payment
  Scenario: US07_Checkout
    Given Click on The Element
      | dresses |
    And Hover On The Element
      | product1 |
    And Click on The Element
      | addToCart1             |
      | continueShoppingButton |
    And Hover On The Element
      | shoppingCart |
    And Click on The Element
      | checkOutButton    |
      | proceedToCheckOut |
      | processTheAddress |
      | checkBox          |
      | checkOutButton2   |
      | paypalButton      |
    And Verification is performed and the previous page is returned.
      | paypalMessage | Things don't appear to be working at the moment. Please try again later. |
    And Click on The Element
      | creditCardButton |
    And Verification is performed and the previous page is returned.
      | creditCardMessage | Invalid request (1). |
    And Click on The Element
      | bankWireButton |
      | confirmButton  |
    When Verification Process
      | alertSuccess | Your order on Xu Clothing is complete. |
    Then Record Order Reference