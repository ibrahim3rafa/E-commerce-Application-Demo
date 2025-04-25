Feature: Purchase the order from E-Commerce website

  @Regression
  Background:
    Given I landed on ECommerce website

  Scenario Outline: Positive Test of submit order
    Given I login with <userMail> and <password>
    When I add product to Cart <productName>
    And Complete checkout and submit the order
    Then Verify "thankyou for the order." message appears

    Examples:
      | userMail                  | password      | productName   |
      | ibrahimarafa611@gmail.com | @I3rafa304852 | IPHONE 13 PRO |