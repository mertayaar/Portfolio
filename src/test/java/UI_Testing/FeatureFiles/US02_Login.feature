Feature: Login Function
  As a user, I want to log in to the website so I can access my account.

  Background: Navigate
    Given Navigate to Web Page
    And Click on The Element
      | signInButton |

  @Smoke @Regression @Accounts
  Scenario Outline: Login to the Website Positive and Negative
    And Enter Data in Text Box
      | emailInput    | <Email>    |
      | passwordInput | <Password> |
    And Click on The Element
      | loginButton |
    And Verification Process
      | <ElementName> | <Message> |
    Examples:
      | Email                  | Password  | ElementName  | Message                  |
      | merttester19@gmail.com | test12345 | loginSuccess | Welcome to your account. |
      | wsmith@gmail.com       | Ws1933    | loginError   | There is 1 error         |
      | w.Smith@gmail.com      | wS1933    | loginError   | There is 1 error         |
      | w.Smith@gmail.com      | Ws1930    | loginError   | There is 1 error         |
      | w.smith@gmail.cm       | Ws1933    | loginError   | There is 1 error         |

