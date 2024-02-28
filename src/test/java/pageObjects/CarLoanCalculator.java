package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utils.ExcelUtils;

public class CarLoanCalculator extends basePage {
	
	
	String yrCol1,yrCol2,yrCol3,yrCol4,yrCol5,yrCol6;
	String monthCol1,monthCol2,monthCol3,monthCol4,monthCol5,monthCol6;
	String[] data;
	public CarLoanCalculator(WebDriver driver) {
		super(driver);
	}
	//Elements
	@FindBy(id="car-loan")
    WebElement carLoan;
	@FindBy(id="loanamount")
	WebElement loanAmount;
	@FindBy(id="loaninterest")
	WebElement loanInterest;
	@FindBy(id="loanterm")
	WebElement loanTenure;
	@FindBy(xpath="//*[@id='emipaymenttable']/table")
	WebElement carEmitable;
	@FindBy(xpath="//*[@id='emipaymenttable']//tr/th")
	List<WebElement> tableHeading;
	@FindBy(xpath="//*[@class='row no-margin yearlypaymentdetails']/td")
	List<WebElement> yearRowCells;
	@FindBy(xpath="//*[@class='row no-margin']/td")
	List<WebElement> monthRowsCells;
	@FindBy(xpath="//*[@class='col-3 col-sm-2 currency']")
	List<WebElement> month1Data;
	@FindBy(xpath="//*[@id=\"emiamount\"]/p/span")
	WebElement loanEMI;
	
	//Actions
	public void clickCarLoan() throws Exception {
		Thread.sleep(3000);
		carLoan.click();
		data=ExcelUtils.readCarEmiData();
	}
	
	public void sendCarEmiData() {
		
		loanAmount.click();
		clear();
		loanAmount.sendKeys(data[0]);
		
		loanInterest.click();
		clear();
		loanInterest.sendKeys(data[1]);
		
		loanTenure.click();
		clear();
		loanTenure.sendKeys(data[2]);
		set();
	}
	
	public void getFirstMonthData() {
		System.out.println("First Month Principal = "+month1Data.get(2).getText()+"\n First Month Interest = "+month1Data.get(3).getText());
	}
	
	public void getTableData() throws Exception {
		int a=yearRowCells.size();
		System.out.println(a);
		System.out.println(monthRowsCells.size());
		int monthRowIndex=0;
		String[] heading= {"","","","","",""};
		int g=0;
		ExcelUtils.createSheet("Car Loan Emi Table Result");
		for(int s=0;s<tableHeading.size();s++) {
			if(!tableHeading.get(s).getText().equals("")) {
				heading[g]=tableHeading.get(s).getText();
				System.out.print(tableHeading.get(s).getText()+" | ");
				g++;
			}
		}
		System.out.println(" ");
		ExcelUtils.write(0, heading);
		int rowNum=1;
		for(int yrRow=0;yrRow<a;yrRow+=6) {
				//year Table Rows
				yrCol1=yearRowCells.get(yrRow).getText();
				yearRowCells.get(yrRow).click();
				yrCol2=yearRowCells.get(yrRow+1).getText();
				yrCol3=yearRowCells.get(yrRow+2).getText();
				yrCol4=yearRowCells.get(yrRow+3).getText();
				yrCol5=yearRowCells.get(yrRow+4).getText();
				yrCol6=yearRowCells.get(yrRow+5).getText();
				System.out.println(yrCol1+" | "+yrCol2+" | "+yrCol3+" | "+yrCol4+" | "+yrCol5+" | "+yrCol6);
				String[] yrValues= {yrCol1,yrCol2,yrCol3,yrCol4,yrCol5,yrCol6};
				ExcelUtils.write(rowNum, yrValues);
				rowNum++;
				Thread.sleep(2000);
				
				//Month Tables rows
				for(int monthRow=monthRowIndex;monthRow<monthRowsCells.size();monthRow+=6){
					int i=monthRow;
					monthCol1=monthRowsCells.get(i).getText();
					monthCol2=monthRowsCells.get(i+1).getText();
					monthCol3=monthRowsCells.get(i+2).getText();
					monthCol4=monthRowsCells.get(i+3).getText();
					monthCol5=monthRowsCells.get(i+4).getText();
					monthCol6=monthRowsCells.get(i+5).getText();
					System.out.println(monthCol1+" | "+monthCol2+" | "+monthCol3+" | "+monthCol4+" | "+monthCol5+" | "+monthCol6);
					String[] monthValues= {monthCol1,monthCol2,monthCol3,monthCol4,monthCol5,monthCol6};
					ExcelUtils.write(rowNum, monthValues);
					rowNum++;
					if("Dec".equals(monthCol1)){
						monthRowIndex=monthRow+6;
						break;
					}
				}
		}
		
	}
	
	public void emiCalculation() {
		String EMI=loanEMI.getText();
//		System.out.println(EMI);
		// Remove commas from the string
		EMI = EMI.replace(",", "");
		// Convert the modified string into an integer
		int intValue = Integer.parseInt(EMI);
		System.out.println("The Loan EMI "+intValue);
		// Calculation for finding the monthly Principle amount and Interest amount
		double e, principle_amount;
		double rate_of_interest;
		int tenture_in_month;
		principle_amount = Double.parseDouble(data[0]);
		rate_of_interest = (Double.parseDouble(data[1])/12)/100;
		tenture_in_month = (int)(Double.parseDouble(data[2]))*12 ;
		e = principle_amount * rate_of_interest;
		
		e = e * Math.pow(1+rate_of_interest, tenture_in_month);
		e = e/(Math.pow(1+rate_of_interest, tenture_in_month)-1);
		System.out.println("Monthly EMI to be paid "+e);
		double Month_Interest =  e*(rate_of_interest);
		System.out.println("Monthly interest to be paid "+Month_Interest);
		double Month_principle = e - Month_Interest ;
		System.out.println("Monthly interest to be paid "+Month_principle);
		if(((int)e)==intValue) {
			System.out.println(" Emi Result are Correct and Validated Successfully");
		}
	}
	
		
}
