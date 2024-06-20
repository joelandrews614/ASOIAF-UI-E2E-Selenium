Feature: Home Page Functionalities
	
	Background:
		Given user is on homepage
	
	Scenario: Validate Header Section of Home Page 
		Given user can see the title of the page
		And user can see the title of the header section
		And user can see the authors link
		When user clicks on the authors link
		Then user should be able to land in the authors personal page
		