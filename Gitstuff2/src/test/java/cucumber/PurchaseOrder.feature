#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Purchase the order from Ecommerce Website
  


  @tag1
  Scenario: Login to application
    Given User is on Landing Page
   
    When User enters username <name> and password <password>
    And Click on submit button
    
    Then "Login Succesfully" Message is displayed
    

    Examples: 
      | name                          | password    |
      | appikatla.kartheek@gmail.com  | Kars4143*1  |
