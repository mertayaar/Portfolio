Feature: Checking the Number of Listed Items
  As a user, when I list a product line on the website,
  I want to verify the quantity of products created.
  So that, I can make sure that the products on the website are up-to-date and complete.

  @Regression @Products
  Scenario: US05_ProductList
    Given Navigate to Web Page
    And Click on The Element
      | dresses |
    When Verifying that is equal to "5"
      | headingCounter     |
      | bottomProductCount |
    Then Length of the "productList" list equal to "5"



