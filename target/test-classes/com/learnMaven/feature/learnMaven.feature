@tag
Feature: Orange HRL Demo 

  @Login
  Scenario: Login scenario
    Given Launch application    
    When Enter username "Admin" and password "admin123"    
    Then click the login button

	@AddUserScenario
  Scenario: Add Userscenario
  	When User mouse move to admin menu
  	And User mouse move to user management 
  	And User mouse move to user link
  	And User click the user link
		And User move the mouse Add button and click the button
		And User select user role "2" as "value" from dropdown
		And User enter employee name "Al" and choose Alice Duval
		And User enter username "abirami7"
		And User select status "1" as "value" from dropdown
		And user enter password "@asd123456" and confirm password "@asd123456"
		And User click the save button
	
	@CheckAddedUser	
	Scenario: Check the user added status
		#When User enter username "abirami7" to the below system user box
		When User click the search button
		Then User verify the username "abirami7" in the search box

	