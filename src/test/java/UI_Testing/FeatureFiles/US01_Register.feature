Feature:  Creating User Function
  As a user, I would like to register on the website by going to https://Cleverppc.com/Prestashop4/.
  So when I access the site, I can see personalized content and benefit from special offers and other benefits.

  @Smoke @Regression @Accounts
  Scenario: Creating User Registration
    Given Navigate to Web Page
    And Click on The Element
      | signInButton |
    And Enter Data in Text Box
      | emailCreateInput | merttester19@gmail.com |
    And Click on The Element
      | createAnAccountButton |
      | mrRadioButton         |
    And Enter Data in Text Box
      | firstNameInput | Mert                  |
      | lastNameInput  | Test                  |
      | emailInput     | merttester19@gmail.com |
      | passwordInput  | test12345             |
    When Click on The Element
      | registerButton |
    Then Verification Process
      | loginSuccess | Welcome to your account. |
