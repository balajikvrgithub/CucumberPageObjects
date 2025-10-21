Feature: Add products to Demoblaze application cart
	In order to purchase product
	As a user
	I should be able to add product to application's cart

@addproduct
Scenario: validate cart module  
	Given I am on the homepage "https://www.demoblaze.com/index.html"
	When I click on the login button
	Then Application should take me to the landing page
	And click on samsung galaxy s6 product
	And click on add to cart button
	And click ok button
	And click on cart menu button
	And validate the presence of product in cart page