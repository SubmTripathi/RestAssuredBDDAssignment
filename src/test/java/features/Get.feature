Feature: Application login

 @tag1
  Scenario: Home page default login
    Given User is on netbanking landing page 
    When User loging into app using credentials
    Then Home is poppulated    