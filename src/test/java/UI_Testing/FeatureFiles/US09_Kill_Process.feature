Feature: Kill Process
  It's a sample project that i found but
  there is no delete account option

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

  @Smoke @Regression
  Scenario: Change email
    And Click on The Element
      | personalInformation |
    And Enter Random Email
    And Enter Data in Text Box
      | currentPasswordInput | test12345 |
      | passwordInput        | test12345 |
      | confirmPassword      | test12345 |
    When Click on The Element
      | saveButton |
    Then Verification Process
      | alertSuccess | Your personal information has been successfully updated. |


