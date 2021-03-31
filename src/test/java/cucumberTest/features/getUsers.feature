Feature: User get Error message after incorrect registration

  @regression
  Scenario: Successful get response and not empty Users List
    Given I perform GET operation for getUsers endpoint
    Then Users required fields are not empty
