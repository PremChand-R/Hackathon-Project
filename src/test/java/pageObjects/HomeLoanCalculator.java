package pageObjects;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.ExcelUtils;

public class HomeLoanCalculator extends basePage {
	String yrCol1,yrCol2,yrCol3,yrCol4,yrCol5,yrCol6,yrCol7;
	String[] homeLoandata;
	public HomeLoanCalculator(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id="menu-item-3294")
	WebElement homeLoanCalc;
	
	@FindBy(id="homeprice")
	WebElement homePrice;
	@FindBy(id="downpayment")
	WebElement downPayment;
	@FindBy(id="homeloaninsuranceamount")
	WebElement insurance;
	@FindBy(id="homeloanamount")
	WebElement loanAmount;
	@FindBy(id="homeloaninterest")
	WebElement loanInterest;
	@FindBy(id="homeloanterm")
	WebElement loanTerm;
	@FindBy(id="loanfees")
	WebElement loanFees;
	@FindBy(xpath="//*[@id='paymentschedule']/table//th")
	List<WebElement> tableHead;
	@FindBy(xpath="//*[@class=\"row no-margin yearlypaymentdetails\"]/td")
	List<WebElement> tableData;
	public void clickHomeLoan() {
		calcDropDown.click();
		homeLoanCalc.click();
		
	}
	public void fillDetails() throws IOException {
		homeLoandata=ExcelUtils.readHomeEmiData();
		
		homePrice.click();
		clear();
		homePrice.sendKeys(homeLoandata[0]);
		
		downPayment.click();
		clear();
		downPayment.sendKeys(homeLoandata[1]);
		
		insurance.click();
		clear();
		insurance.sendKeys(homeLoandata[2]);
		
		loanInterest.click();
		clear();
		loanInterest.sendKeys(homeLoandata[3]);
		
		loanTerm.click();
		clear();
		loanTerm.sendKeys(homeLoandata[4]);
		
		loanFees.click();
		clear();
		loanFees.sendKeys(homeLoandata[5]);
		set();
		
		
	}
	
	public void getYearTable() throws IOException {
		String[] heading= {"","","","","","",""};
		System.out.println("\n Printing Year on Year Table for HomeLoan \n");
		ExcelUtils.createSheet("Home Loan Emi Year Table Result");
		for(int s=0;s<tableHead.size();s++) {
			heading[s]=tableHead.get(s).getText();
		}
		System.out.println(" ");
		ExcelUtils.write(0, heading);
		int rowNum=1;
		for(int yrRow=0;yrRow<tableData.size();yrRow+=7) {
				//year Table Rows
				yrCol1=tableData.get(yrRow).getText();
				yrCol2=tableData.get(yrRow+1).getText();
				yrCol3=tableData.get(yrRow+2).getText();
				yrCol4=tableData.get(yrRow+3).getText();
				yrCol5=tableData.get(yrRow+4).getText();
				yrCol6=tableData.get(yrRow+5).getText();
				yrCol7=tableData.get(yrRow+6).getText();
				System.out.println(yrCol1+" | "+yrCol2+" | "+yrCol3+" | "+yrCol4+" | "+yrCol5+" | "+yrCol6+" | "+yrCol7);
				String[] yrValues= {yrCol1,yrCol2,yrCol3,yrCol4,yrCol5,yrCol6,yrCol7};
				ExcelUtils.write(rowNum, yrValues);
				rowNum++;
		}
		ExcelUtils.closeBook();
	}

}
