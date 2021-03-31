Feature: User get Error message after incorrect registration

  @regression
  Scenario Outline: Unsuccessful registration - response 400 with error
    Given I prepare request body with email: "<emailTest>" and password: "<passwordTest>"
    When I perform POST operation for postRegister endpoint
    Then  User get correct error message: "<messageTest>" and status code: "<statusCode>"
    Examples:
      | emailTest   | passwordTest | messageTest                                   | statusCode |
      | abc@abc.abc |              | Missing password                              | 400        |
      |             | challange    | Missing email or username                     | 400        |
      | abc@abc.abc | challange    | Note: Only defined users succeed registration | 400        |