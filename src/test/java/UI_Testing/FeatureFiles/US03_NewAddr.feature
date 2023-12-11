Feature: Adding Address Function
  As a user, I want to add a new address to my account after navigating the page
  So I can use different delivery addresses when shopping.

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

  @Smoke @Regression @Addresses
  Scenario: Adding a new address to the user account
    And Click on The Element
      | siteMap          |
      | addressesButton  |
      | addAddressButton |
    And Enter Data in Text Box
      | address1 | Central Park |
      | city     | New York     |
    And Click on The Element
      | state          |
      | virginiaOption |
    And Enter Data in Text Box
      | postCode    | 44000       |
      | phone       | 11111111111 |
      | phoneMobile | 19999999999 |
    When Click on The Element
      | addressSaveButton |
    Then Verification Process
      | addressTitle | MY ADDRESS |



