Feature: Login with parameters

  Background: Common steps
    Given I am on the login page

  @librarianParam
  Scenario: Login as librarian 12

    When I enter username "librarian16@library"
    And I enter password '8BzUhhaU'
    And click the sign in button
    And there should be 1446 users
    Then dashboard should be displayed

  @studentParam
  Scenario: Login as student 95

    When I enter username "student95@library"
    And I enter password 'Vu2BiIwB'
    And click the sign in button
    Then books should be displayed

  @WIP
  Scenario: Login as librarian entering username and password at the same line

    When I enter  "librarian16@library" and  "8BzUhhaU"
    And click the sign in button
    Then dashboard should be displayed
