Feature: Login into Demoblaze application
	In order to use Demoblaze application
	As a user
	I should be able to log into the application

@login	
Scenario: validate login module  
	Given I am on the homepage "https://www.demoblaze.com/index.html"
	When I click on the login button
	Then Application should take me to the landing page
	And menu options should be visible
	| Menu |
	| Home |
	| Contact |
	| About us |
	| Cart |
	| Log out |
	 
	 
	 
