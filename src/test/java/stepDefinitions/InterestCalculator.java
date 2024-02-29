package stepDefinitions;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.*;
import pageObjects.CarLoanCalculator;
import pageObjects.HomeLoanCalculator;
import pageObjects.LoanCalculator;
import testBase.baseClass;

public class InterestCalculator {
	public static CarLoanCalculator clc;
	public static HomeLoanCalculator hlc;
	public static LoanCalculator lc;
	public static baseClass bc=new baseClass();
	public static int emi;
	public static Logger logger=baseClass.getLogger();

	@Given("User navigates to EmiCalculator Page")
	public void user_navigates_to_emicalculator_page() {
		clc=new CarLoanCalculator(bc.getDriver());
		logger.info("User is navigated to Emi Calculator page.");
		
	}
	@When("User selects car loan in the application")
	public void user_selects_car_loan_in_the_application() throws Exception {
		clc.clickCarLoan();
		logger.info("User clicks car Loan.");
	}

	@Then("Users checks the textboxes and enters the values to compute the emi")
	public void users_checks_the_textboxes_and_enters_the_values_to_compute_the_emi() throws Exception{
		clc.verifyloanAMT();
		clc.sendloanAmount();
		clc.verifyloanInterest();
		clc.sendloanInterest();
		clc.verifyloanTenure();
		clc.sendloanTenure();
		bc.captureScreenshot("CarLoan Details");
		logger.info("User checks all text boxes and enters the values");
	}

	@Then("The Emi is displayed is compared with the computed one")
	public void the_emi_is_displayed_is_compared_with_the_computed_one() throws Exception{
		clc.getTableData();
		logger.info("User retrieves  full table Data");
		bc.captureScreenshot("CarLoan Table");
		clc.getFirstMonthData();
		logger.info("User retrieves first month principal and interest");
		clc.emiCalculation();
		logger.info("User verifies emi value in result");
	}
	
	@Then("The total interest amount displayed should be greater than {int}")
	public void the_total_interest_amount_displayed_should_be_greater_than(int int1) {
	    clc.verifyInterestResult(int1);
	}
	
	@Then("The principal amount for the first month should be greater than {int}")
	public void the_principal_amount_for_the_first_month_should_be_greater_than(int int2) {
	   clc.verifyPrincipalAmount(int2);
	}
	@Given("User is on the Emi Calculator website")
	public void user_is_on_the_emi_calculator_website() {
		clc.headerCheck();
		logger.info("User is on Emi Calculator page");
	}
	@When("User enters loan amount of {int}, interest rate of {double}, and tenure of {int} years")
	public void  user_enters_loan_amount_of_interest_rate_of_and_tenure_of_years(int amount,double interest,int years) throws Exception{
		clc.loanAMT(amount);
		clc.loanInterest(interest);
		clc.loanTenure(years);
		logger.info("User enters loan amount,interest rate and tenure");
		emi=clc.emiCalculation(amount, interest, years);
	}
	@Then("Verify the calculated EMI amount with Result")
	public void verify_the_calculated_emi_amount_with_result() {
		clc.verifyEmiResult(emi);
		logger.info("User verifies emi result value");
	}
	@Given("The user navigates to the Home Loan Calculator page")
	public void the_user_navigates_to_the_home_loan_calculator_page() {
		hlc=new HomeLoanCalculator(bc.getDriver());
		hlc.clickHomeLoan();
		logger.info("User clicks on Home Loan Calculator");
	}

	@When("The user checks textboxes and enters the values")
	public void the_user_checks_textboxes_and_enters_the_values() throws Exception {
		hlc.verifyhomePrice();
		hlc.verifydownPayment();
		hlc.verifyInsurance();
		hlc.verifyloanInterest();
		hlc.verifyloanTenure();
		hlc.verifyfeeCharges();
		logger.info("User checks each textbox .");
		hlc.fillDetails();
		bc.captureScreenshot("HomeLoan Details");
		logger.info("User enters relevant details.");
	}
	@Then("The Home Loan EMI table should be displayed")
	public void the_home_loan_emi_table_should_be_displayed() throws Exception {
		hlc.moveToTable();
		bc.captureScreenshot("HomeLoan Year Table");
		logger.info("User captures year on year table result.");
	}

	@Then("Year on year table is displayed is saved in an excel")
	public void year_on_year_table_is_displayed_is_saved_in_an_excel() throws IOException{
		hlc.getYearTable();
		logger.info("User writes table data to Excel.");
	}

	@Given("The user navigates to Loan Calculator page")
	public void the_user_navigates_to_loan_calculator_page() {
		lc= new LoanCalculator(bc.getDriver());
		lc.clickLoanCalculator();
		logger.info("User clicks on Loan Calculator.");
	}

	@Then("User do all the neccessary UI Functionality")
	public void user_do_all_the_neccessary_ui_functionality() throws Exception {
		lc.verifyloanAMT();
		lc.loanAMT();
		lc.verifyloanEMI();
		lc.emi();
		lc.verifyloanInterest();
		lc.loanInterest();
		lc.verifyloanTenure();
		lc.loanTenure();
		lc.verifyfeeCharges();
		lc.feeCharges();
		logger.info("User checks each textbox and enters the details .");
		bc.captureScreenshot("LoanEmiCalc Details");
		lc.adv();
		lc.getResults();
		bc.captureScreenshot("LoanEmiCalc Results");
		lc.date();
		lc.month();
		lc.Dropdn();
		lc.hover();
		
	}

	@Then("User selects Loan amount calculator to do all the neccessary UI Functionality")
	public void user_selects_loan_amount_calculator_to_do_all_the_neccessary_ui_functionality() throws Exception{
		lc.clickLoanAmtCalc();
		logger.info("User clicks on Loan Amount Calculator");
		lc.loanEMI();
		lc.loanInterest();
		lc.loanTenure();
		lc.feeCharges();
		logger.info("User enters the Details.");
		bc.captureScreenshot("LoanAmtCalc Details");
		lc.arrears();
		lc.getResults();
		bc.captureScreenshot("LoanAmtCalc Results");
		lc.date();
		lc.month();
		lc.Dropdn();
		lc.hover();
		logger.info("User checks each graphs By hovering on results.");
		
	}

	@Then("User selects Loan Tenure Calculator to do all the neccessary UI Functionality")
	public void user_selects_loan_tenure_calculator_to_do_all_the_neccessary_ui_functionality() throws Exception {
		lc.clickLoanTenureCalc();
		logger.info("User clicks on Loan Tenure Calculator");
		lc.loanAMT();
		lc.loanEMI();
		lc.loanInterest();
		lc.feeCharges();
		logger.info("User enters all relevant details");
		bc.captureScreenshot("LoanTenure Details");
		lc.adv();
		lc.getResults();
		bc.captureScreenshot("LoanTenure Results");
		lc.date();
		lc.month();
		lc.Dropdn();
		lc.hover();
		logger.info("User checks each graphs By hovering on results.");
	}

}
