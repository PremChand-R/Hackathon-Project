Feature: Emi Calculator
	@sanity
  Scenario: Car Loan Calculator
    Given User navigates to EmiCalculator Page
    When User selects car loan in the application
    Then Users checks the textboxes and enters the values to compute the emi
    And The Emi is displayed is compared with the computed one
    And The total interest amount displayed should be greater than 0
    And The principal amount for the first month should be greater than 0
   @regression
   Scenario Outline: Calculate EMI for various loan amounts, interest rates, and tenures (Regression Test)
    Given User is on the Emi Calculator website
    When User enters loan amount of <loanAmount>, interest rate of <interestRate>, and tenure of <tenure> years
    Then Verify the calculated EMI amount with Result
    
	 Examples:
  	| loanAmount | interestRate | tenure |
  	| 1000000 | 8.5 | 4 |
  	| 2000000 | 9.0 | 3 |
  	| 500000 | 10.5 | 2 |
  @sanity
  Scenario: Home Loan Calculator
    Given The user navigates to the Home Loan Calculator page
    When The user checks textboxes and enters the values
    Then The Home Loan EMI table should be displayed
    Then Year on year table is displayed is saved in an excel
  @sanity
  Scenario: Checking UI Functionality
    Given The user navigates to Loan Calculator page
    Then User do all the neccessary UI Functionality
    And User selects Loan amount calculator to do all the neccessary UI Functionality
    And User selects Loan Tenure Calculator to do all the neccessary UI Functionality