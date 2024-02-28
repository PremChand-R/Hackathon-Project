Feature: Emi Calculator
 
  Scenario: Car Loan Calculator
    Given User navigates to EmiCalculator Page
    When User selects car loan in the application
    Then Users enters the values to compute the emi
    Then The Emi is displayed is compared with the computed one
 
  Scenario: Home Loan Calculator
    Given The user navigates to the Home Loan Calculator page
    When The user enters the values
    Then Year on year table is displayed is saved in an excel
    
  Scenario: Checking UI Functionality
    Given The user navigates to Loan Calculator page
    Then User do all the neccessary UI Functionality
    And User selects Loan amount calculator to do all the neccessary UI Functionality
    And User selects Loan Tenure Calculator to do all the neccessary UI Functionality