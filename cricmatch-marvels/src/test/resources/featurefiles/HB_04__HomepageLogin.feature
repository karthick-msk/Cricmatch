
Feature: Checking login functionality
#Testcase:1

Scenario: The user enters the valid username and password, and the user should successfully log in to the homepage.
    Given open the browser and navigate to the URL
    And enter the username and password
    When click the login button
    Then verify the login functionality


  # Testcase:2 #HB -118 
 
  Scenario: Checking login exchange page password field functionality
   Given open the browser and navigate to the URL
    And the user clicks the join now button and creates an account to get the password count
    And the user clicks the exchange login button
    And the user enters the username and password to get the password count
    Then verify both password counts

# Testcase:3 #HB - 130 
 
  Scenario: The username/email field should not allow input with a single space.
   Given open the browser and navigate to the URL
    And the user enters the username with spaces and retrieves the username
    And then redirect to the joinnow page and paste the usernmae get from the loginpage
    Then verify the both username names entered into the username field

# Testcase:4 #HB - 20 
 
  Scenario: The username and password fields should automatically display the previously entered credentials, as the "Remember Me" feature is enabled.
   Given open the browser and navigate to the URL
   When the user enters their username and password, logs out, and revisits the website
    Then the username field should display the previously entered credentials
  
  