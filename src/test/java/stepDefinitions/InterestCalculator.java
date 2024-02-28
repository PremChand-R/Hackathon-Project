package stepDefinitions;

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

	@Given("User navigates to EmiCalculator Page")
	public void user_navigates_to_emicalculator_page() {
		clc=new CarLoanCalculator(bc.getDriver());
		
	}
	@When("User selects car loan in the application")
	public void user_selects_car_loan_in_the_application() throws Exception {
		clc.clickCarLoan();
	}

	@Then("Users enters the values to compute the emi")
	public void users_enters_the_values_to_compute_the_emi() throws Exception{
		clc.sendCarEmiData();
		bc.captureScreenshot("CarLoan Details");	
	}

	@Then("The Emi is displayed is compared with the computed one")
	public void the_emi_is_displayed_is_compared_with_the_computed_one() throws Exception{
		clc.getTableData();
		bc.captureScreenshot("CarLoan Table");
		clc.getFirstMonthData();
		clc.emiCalculation();
	}

	@Given("The user navigates to the Home Loan Calculator page")
	public void the_user_navigates_to_the_home_loan_calculator_page() {
		hlc=new HomeLoanCalculator(bc.getDriver());
		hlc.clickHomeLoan();
	}

	@When("The user enters the values")
	public void the_user_enters_the_values() throws Exception {
		hlc.fillDetails();
		bc.captureScreenshot("HomeLoan Details");
	}

	@Then("Year on year table is displayed is saved in an excel")
	public void year_on_year_table_is_displayed_is_saved_in_an_excel() throws Exception {
		hlc.getYearTable();
		bc.captureScreenshot("HomeLoan Year Table");
	}

	@Given("The user navigates to Loan Calculator page")
	public void the_user_navigates_to_loan_calculator_page() {
		lc= new LoanCalculator(bc.getDriver());
		lc.clickLoanCalculator();
	}

	@Then("User do all the neccessary UI Functionality")
	public void user_do_all_the_neccessary_ui_functionality() throws Exception {
		lc.loanAMT();
		lc.emi();
		lc.loanInterest();
		lc.loanTenure();
		lc.feeCharges();
		bc.captureScreenshot("LoanEmiCalc Details");
		lc.adv();
		lc.getResults();
		bc.captureScreenshot("LoanEmiCalc Results");
		lc.date();
		lc.month();
		lc.Dropdn();
		lc.hover();
		lc.arrears();
		lc.hover();
	}

	@Then("User selects Loan amount calculator to do all the neccessary UI Functionality")
	public void user_selects_loan_amount_calculator_to_do_all_the_neccessary_ui_functionality() throws Exception{
		lc.clickLoanAmtCalc();
		lc.loanEMI();
		lc.loanInterest();
		lc.loanTenure();
		lc.feeCharges();
		bc.captureScreenshot("LoanAmtCalc Details");
		lc.arrears();
		lc.getResults();
		bc.captureScreenshot("LoanAmtCalc Results");
		lc.date();
		lc.month();
		lc.Dropdn();
		lc.hover();
		
	}

	@Then("User selects Loan Tenure Calculator to do all the neccessary UI Functionality")
	public void user_selects_loan_tenure_calculator_to_do_all_the_neccessary_ui_functionality() throws Exception {
		lc.clickLoanTenureCalc();
		lc.loanAMT();
		lc.loanEMI();
		lc.loanInterest();
		lc.feeCharges();
		bc.captureScreenshot("LoanTenure Details");
		lc.adv();
		lc.getResults();
		bc.captureScreenshot("LoanTenure Results");
		lc.date();
		lc.month();
		lc.Dropdn();
		lc.hover();
		
	}

}
