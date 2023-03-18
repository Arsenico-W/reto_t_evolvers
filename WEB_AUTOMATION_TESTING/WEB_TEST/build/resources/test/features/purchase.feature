#Author: nicolas echeverri

Feature: I as a user I want to create a purchase on the page sauced emo

  Background: enter on the page and login
    Given the user enter on the page
    When the user enter the standard_user and secret_sauce

  @Purchase
  Scenario Outline: purchase of products of page
    When the user filter the page for low prices 3
    And the user add products to little car
    And the user remove a product of little car
    And the user enters the information for the purchase
      | firstname   | lastname   | zipCode   |
      | <firstname> | <lastname> | <zipCode> |
    Then the user check total items
    And the user check total price
    And the user see a message of correct purchase Thank you for your order!
    Examples:
      | firstname | lastname  | zipCode |
      | Logan     | Henderson | 43842   |

  @CheckProducts
  Scenario: to check that the page have products
    Then the user see products in the page


  @CheckButtonLittleCar
  Scenario: to check that the button of little car is enable
    Then the user can to use the button of little car

  @CheckButtonCheckOut
  Scenario: to check that the button for go to CheckOut of purchase is enable
    When the user go to little car
    Then the user can to user the button of CheckOut

