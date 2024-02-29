package TestCases;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CarLoanCalculator;
import pageObjects.HomeLoanCalculator;
import pageObjects.LoanCalculator;
import testBase.baseClass;

public class Tc001_EmiCalculator extends baseClass {
	public static CarLoanCalculator clc;
	public static HomeLoanCalculator hlc;
	public static LoanCalculator lc;
	
	@Test(priority=0,groups= {"smoke","sanity","regression"})
	@Parameters("browser")
	public void initiateDriver(String browser) throws Exception {
		setUp(browser);
	}
	@Test(priority=1,groups= {"smoke","sanity","regression"})
	public void carLoanCalculator() throws Exception {
		clc=new CarLoanCalculator(driver);
		clc.clickCarLoan();
	}
	@Test(priority=2,groups= {"smoke","sanity","regression"})
	public void inputCarLoanData() throws IOException{
		clc.sendloanAmount();
		clc.sendloanInterest();
		clc.sendloanTenure();
		captureScreenshot("CarLoan Details");
	}
	@Test(priority=3,groups= {"sanity"})
	public void verifyCarLoanElements() throws Exception {
		clc.verifyloanAMT();
		clc.verifyloanInterest();
		clc.verifyloanTenure();
	}
	@Test(priority=4,groups= {"smoke","sanity","regression"})
	public void printCarEmiData() throws Exception {
		clc.getTableData();
		captureScreenshot("CarLoan Table");
		clc.getFirstMonthData();
		clc.emiCalculation();
	}
	
	@Test(priority=5,groups= {"smoke"})
	public void verifyCarLoanResults() throws Exception {
		clc.verifyInterestResult(0);
		clc.verifyPrincipalAmount(0);
	}
	@Test(priority=6,groups= {"smoke","regression"})
	public void validateCarLoanResults() throws Exception {
		testCarLoanCalc(500000,9.0,2);
		testCarLoanCalc(300000,8.5,3);
		testCarLoanCalc(200000,9.5,2);
		testCarLoanCalc(2500000,10,4);
	}
	
	@Test(priority=7,groups= {"smoke","sanity","regression"})
	public void homeLoanCalculator() {
		hlc=new HomeLoanCalculator(driver);
		hlc.clickHomeLoan();
	}
	@Test(priority=8,groups= {"sanity"})
	public void verifyHomeLoanElements() {
		hlc.verifyhomePrice();
		hlc.verifydownPayment();
		hlc.verifyInsurance();
		hlc.verifyloanInterest();
		hlc.verifyloanTenure();
		hlc.verifyfeeCharges();
		
	}
	@Test(priority=9,groups= {"smoke","sanity","regression"})
	public void printHomeEmiData() throws IOException {
		hlc.fillDetails();
		captureScreenshot("HomeLoan Details");
		hlc.getYearTable();
		captureScreenshot("HomeLoan Year Table");
	}
	@Test(priority=10,groups= {"smoke","sanity","regression"})
	public void loanCalculator(){
		lc= new LoanCalculator(driver);
		lc.clickLoanCalculator();
	}
	@Test(priority=11,groups= {"sanity"})
	public void verifyLoanEmiCalcElements() {
		lc.verifyloanAMT();
		lc.verifyloanEMI();
		lc.verifyloanInterest();
		lc.verifyloanTenure();
		lc.verifyfeeCharges();
	}
	@Test(priority=12,groups= {"smoke","sanity","regression"})
	public void loanEmiCalcUICheck() throws Exception {
		lc.loanAMT();
		lc.emi();
		lc.loanInterest();
		lc.loanTenure();
		lc.feeCharges();
		captureScreenshot("LoanEmiCalc Details");
		lc.adv();
		lc.getResults();
		captureScreenshot("LoanEmiCalc Results");
		lc.date();
		lc.month();
		lc.Dropdn();
		lc.hover();
	}
	@Test(priority=13,groups= {"smoke","sanity","regression"})
	public void clickLoanAMTCalculator() {
		lc.clickLoanAmtCalc();
	}
	@Test(priority=14,groups= {"sanity"})
	public void verifyLoanAMTCalcElements() {
		lc.verifyloanEMI();
		lc.verifyloanInterest();
		lc.verifyloanTenure();
		lc.verifyfeeCharges();
	}
	
	@Test(priority=15,groups= {"smoke","sanity","regression"})
	public void loanAmountCalcUICheck()throws Exception {
		lc.loanEMI();
		lc.loanInterest();
		lc.loanTenure();
		lc.feeCharges();
		captureScreenshot("LoanAmtCalc Details");
		lc.arrears();
		lc.getResults();
		captureScreenshot("LoanAmtCalc Results");
		lc.date();
		lc.month();
		lc.Dropdn();
		lc.hover();
	}
	@Test(priority=16,groups= {"smoke","sanity","regression"})
	public void clickLoanTenureCalculator() {
		lc.clickLoanTenureCalc();
	}
	@Test(priority=17,groups= {"sanity"})
	public void verifyLoanTenureCalcElements() {
		lc.verifyloanAMT();
		lc.verifyloanEMI();
		lc.verifyloanInterest();
		lc.verifyfeeCharges();
	}
	@Test(priority=18,groups= {"sanity","regression"})
	public void loanTenureCalcUICheck()throws Exception {
		lc.loanAMT();
		lc.loanEMI();
		lc.loanInterest();
		lc.feeCharges();
		captureScreenshot("LoanTenure Details");
		lc.adv();
		lc.getResults();
		captureScreenshot("LoanTenure Results");
		lc.date();
		lc.month();
		lc.Dropdn();
		lc.hover();
	}
	@Test(priority=19,groups={"sanity","smoke","regression"})
	public void closeDriver() {
		tearDown();
	}
	public void testCarLoanCalc(int amount,double interest,int years ) throws Exception {
		clc.loanAMT(amount);
		clc.loanInterest(interest);
		clc.loanTenure(years);
		logger.info("User enters loan amount,interest rate and tenure");
		int emi=clc.emiCalculation(amount, interest, years);
		clc.verifyEmiResult(emi);
		
	}
}
