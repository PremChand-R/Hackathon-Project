package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import pageObjects.CarLoanCalculator;
import pageObjects.HomeLoanCalculator;
import pageObjects.LoanCalculator;
import testBase.baseClass;

public class Tc001_EmiCalculator extends baseClass {
	public static CarLoanCalculator clc;
	public static HomeLoanCalculator hlc;
	public static LoanCalculator lc;
	
	@Test(priority=1)
	public void inputCalculator() throws Exception {
		clc=new CarLoanCalculator(driver);
		clc.clickCarLoan();
		clc.sendCarEmiData();
		captureScreenshot("CarLoan Details");
		
	}
	@Test(priority=2)
	public void printCarEmiData() throws Exception {
		clc.getTableData();
		captureScreenshot("CarLoan Table");
		clc.getFirstMonthData();
		clc.emiCalculation();
	}
	@Test(priority=3)
	public void homeLoanCalculator() {
		hlc=new HomeLoanCalculator(driver);
		hlc.clickHomeLoan();
	}
	@Test(priority=4)
	public void printHomeEmiData() throws IOException {
		hlc.fillDetails();
		captureScreenshot("HomeLoan Details");
		hlc.getYearTable();
		captureScreenshot("HomeLoan Year Table");
	}
	@Test(priority=5)
	public void loanCalculator(){
		lc= new LoanCalculator(driver);
		lc.clickLoanCalculator();
	}
	@Test(priority=6)
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
		lc.arrears();
		lc.hover();
	}
	@Test(priority=7)
	public void loanAmountCalcUICheck()throws Exception {
		lc.clickLoanAmtCalc();
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
		lc.adv();
		lc.hover();
	}
	@Test(priority=8)
	public void loanTenureCalcUICheck()throws Exception {
		lc.clickLoanTenureCalc();
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
		lc.arrears();
		lc.hover();
	}

}
