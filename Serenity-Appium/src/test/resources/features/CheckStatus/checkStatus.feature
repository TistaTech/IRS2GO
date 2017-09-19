@CheckStatus
Feature: Check the status of the 2016 Tax Return
  As a user
  I want to input my information in IRS2Go
  So that I can check the status of the 2016 Tax Return.

  Scenario Outline: Successfull status check
    Given I use valid "<SSN>", valid "<filingStatus>", valid "<refundAmount>"
    When I input my inforamtion in IRS2Go
    Then I should be able to check the status of the 2016 Tax Return

    @prod
    Examples: Valid Data
      | SSN       | filingStatus            | refundAmount |
      | 012345678 | Single                  |          736 |
      | 012345678 | Married-Filing Joint    |          736 |
      | 012345678 | Married-Filing Separate |          736 |
      | 012345678 | Head of Household       |          736 |
      | 012345678 | Qualifying Widow        |          736 |
