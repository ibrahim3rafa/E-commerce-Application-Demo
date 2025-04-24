

Feature: Purchase the order from E Commerse website

  Background:
    Given I landed on ECommerce website


    Scenario Outline: Positive Test of submit order
      Given I loggen with <userMail> and <password>
      When I add product to Cart <productName>
      And Complete checkout and submit the order
      Then Verify "THANKYOU FOR THE ORDER." message appears


      Examples:
        | userMail                  | password      | productName   |
        | ibrahimarafa611@gmail.com | @I3rafa304852 | IPHONE 13 PRO |
