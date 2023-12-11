Feature: Checking products match with database


  Scenario: Check All Dress
    Given Navigate to Web Page
    And Hover On The Element
      | womenCategory |
    And Click on The Element
      | summerDresses |
    When Send the query to get items on database
      | select Products.productName, Products.productPrice from Products left join Categories on Products.category_id = Categories.category_id where Categories.category_name='Summer Dresses'; |
    Then Check if the result match with UI
