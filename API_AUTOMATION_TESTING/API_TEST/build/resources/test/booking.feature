Feature: I as user i want to use api booking


  @PostBookingHappyCase
  Scenario Outline: create a booking
    When the user enter the information
      | contentType   | accept   | firstName   | lastName   | totalPrice   | depositPaid   | checkIn   | checkOut   | additionalNeeds   |
      | <contentType> | <accept> | <firstName> | <lastName> | <totalPrice> | <depositPaid> | <checkIn> | <checkOut> | <additionalNeeds> |
    Then the user see the status code 200
    And the user enter the information <firstName> and <lastName>
    Examples:
      | contentType      | accept           | firstName | lastName | totalPrice | depositPaid | checkIn    | checkOut   | additionalNeeds |
      | application/json | application/json | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |


  @PostBookingFailedCase
  Scenario Outline: create failed a booking
    When the user enter the information
      | contentType   | accept   | firstName   | lastName   | totalPrice   | depositPaid   | checkIn   | checkOut   | additionalNeeds   |
      | <contentType> | <accept> | <firstName> | <lastName> | <totalPrice> | <depositPaid> | <checkIn> | <checkOut> | <additionalNeeds> |
    Then the user see the status code <code>
    Examples:
      | contentType      | accept           | firstName | lastName | totalPrice | depositPaid | checkIn    | checkOut   | additionalNeeds | code |
      | application/json |                  | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       | 418  |
      | application/json | application/json | Jim       | Brown    |            | true        | 2018-01-01 | 2019-01-01 | Breakfast       | 500  |

  @PostBookingFailedCaseCheck
  Scenario Outline: create failed a booking without check
    When the user enter the information
      | contentType   | accept   | firstName   | lastName   | totalPrice   | depositPaid   | checkIn   | checkOut   | additionalNeeds   |
      | <contentType> | <accept> | <firstName> | <lastName> | <totalPrice> | <depositPaid> | <checkIn> | <checkOut> | <additionalNeeds> |
    Then the user see the status code <code>
    And the user see the response check <responseCheck>
    Examples:
      | contentType      | accept           | firstName | lastName | totalPrice | depositPaid | checkIn | checkOut | additionalNeeds | code | responseCheck |
      | application/json | application/json | Jim       | Brown    | 111        | true        |         |          | Breakfast       | 200  | 0NaN-aN-aN    |


  @GetBookingHappyCase
  Scenario Outline: search a booking
    When the user search by <id> and <accept>
    Then the user see the status code 200
    And the user see the information <additionalNeeds> in response
    Examples:
      | id | accept           | additionalNeeds |
      | 1  | application/json | Breakfast       |
      | 23 | application/json | super bowls     |


  @GetBookingFailedCase
  Scenario Outline: search a booking don´t existing
    When the user search by <id> and <accept>
    Then the user see the status code 404
    And the user see the response <response> for search

    Examples:
      | id         | accept           | response  |
      | 1000000000 | application/json | Not Found |
      | 60000000   |                  | Not Found |


  @UpdateBookingHappyCase
  Scenario Outline: update a booking
    When the user create a token
      | contentType   | username   | password   |
      | <contentType> | <username> | <password> |
    And the user update a booking with <id>
      | contentType   | accept   | firstName   | lastName   | totalPrice   | depositPaid   | checkIn   | checkOut   | additionalNeeds   |
      | <contentType> | <accept> | <firstName> | <lastName> | <totalPrice> | <depositPaid> | <checkIn> | <checkOut> | <additionalNeeds> |
    Then the user see the status code 200
    And the user enters the information <firstName> and <lastName> to update
    Examples:
      | id | firstName | lastName | totalPrice | depositPaid | checkIn    | checkOut   | additionalNeeds | contentType      | accept           | username | password    |
      | 1  | James     | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       | application/json | application/json | admin    | password123 |


  @UpdateBookingFailedCaseWithOutToken
  Scenario Outline: update bad a booking without token
    When the user update a booking with <id>
      | contentType   | accept   | firstName   | lastName   | totalPrice   | depositPaid   | checkIn   | checkOut   | additionalNeeds   |
      | <contentType> | <accept> | <firstName> | <lastName> | <totalPrice> | <depositPaid> | <checkIn> | <checkOut> | <additionalNeeds> |
    Then the user see the status code <code>
    And the user see the response <response> for search
    Examples:
      | id | firstName | lastName | totalPrice | depositPaid | checkIn    | checkOut   | additionalNeeds | contentType      | accept           | response  | code |
      | 1  | James     | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       | application/json | application/json | Forbidden | 403  |

