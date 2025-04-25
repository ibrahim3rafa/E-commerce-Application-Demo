Feature: Error Validation

  @ErrorValidation
  Background:
    Given I landed on ECommerce website

  Scenario Outline: Error validation Scenario
    Given I login with <userMail> and <password>
    Then Verify "thankyou for the order." error message appears

    Examples:
      | userMail                  | password      |
      | ibrahimarafa611@gmail.com | @I3rafa304852 |

