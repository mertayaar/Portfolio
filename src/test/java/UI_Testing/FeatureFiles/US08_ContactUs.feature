Feature: Sending an e-mail to the website team as a user
  As a user, I would like to send a receipt email using the "Contact Us" section of the website.
  This way I can submit my payment receipt and contact the support team.

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

  @Regression @Contact @Support
  Scenario: US08_ContactUs
    When Click on The Element
      | contactUsButton       |
      | subjectHeading        |
      | customerServiceOption |
      | emailInput            |
    And Get Recorded Reference Number on Path "src/test/java/UI_Testing/Assets/Files/OrderRefFile.txt"
    And Select a Product
    And Adding Receipt Of Payment File with path "src/test/java/UI_Testing/Assets/Images/contactImage.png"
    And Enter Data in Text Box
      | contactMessageInput | The bank transfer has just been made, the payment receipt is attached. Mert Test |
    And Click on The Element
      | sendButton |
    And Verification Process
      | alertSuccess | Your message has been successfully sent to our team. |