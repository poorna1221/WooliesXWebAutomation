Feature: AddItemsToCart in automationpractice site

@smoketest 

Scenario: I want to be able to add 2 items to the cart and place an order

Given user navigated to automationpractice webpage homepage
When  user adds two items to cart and proceed to checkout
And user logged into application with valid emailid and password
And  user pays by check and click on confirm order
Then verify if the order is placed successfully






