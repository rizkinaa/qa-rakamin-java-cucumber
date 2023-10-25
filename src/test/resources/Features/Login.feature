Feature: Login
  # @Negative
  # @Regression
#  Background:
#      Given I Open browser
#      And Successfully login
  Scenario: Failed Login with empty username
    Given I Open browser
    And Open website saucedemo
    And Located on saucedemo website
    When I input empty username
    And I input valid password
    Then I should see an error message "Epic sadface: Username is required"

#    @Regression
#    @Positive
  Scenario: Successful login
    Given I Open browser
    And Open website saucedemo
    And Located on saucedemo website
    When I input valid username
    And I input valid password
    Then I go to homepage

  @Checkout
  Scenario: Successful check out product
    Given I Open browser
    And Open website saucedemo
    And Located on saucedemo website
    When I input valid username
    And I input valid password
    Then I'm in homepage

    And I click add to cart a product
    And I click cart icon
    And I click checkout button
    When I fill the form
    And I click continue button
    Then I click finish button
    Then I should see an success message "Thank you for your order!"

  @Filter
  Scenario: Successful using filter on product page
    Given I Open browser
    And Open website saucedemo
    And Located on saucedemo website
    When I input valid username
    And I input valid password
    Then I'm in homepage

    And I select Name Z-A
    Then I should see Z-A result
    When I click price high to low
    Then I should see filter result

#  Scenario: Successful check out product
#    Given I Open browser
#    And Successfully login
#    Given I success login to homepage
#    And I click cart icon
#    And I click checkout button
#    When I fill the form
#    And I click continue button
#    Then I click finish button

#  Scenario: Successful using filter on product page
#    Given I successful login to homepage
#    And I click icon filter
#    And I select Name Z-A
#    When I click price high to low
#    Then I should see filter result