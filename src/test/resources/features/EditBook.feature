Feature: Login
  As a user, I should be able to click "EditBook" icon and save changes

  @Edit_Book
  Scenario: Edit Book info as a librarian
    Given I am on the login page
    When I login as a librarian
    When I click on "Books" link
    #This is coming from Page Navigation
    And I click Edit Book link
    Then I should be able to edit the book information
      | Book Name     | Ask        |
      | ISBN          | NA2387271  |
      | Year          | 2009       |
      | Author        | Elif SAFAK |
      | Book Category | Story      |
      | Description   | I love it  |
    Then I should be able to save changes
    Then I should be able to close
