package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoanCalculator extends basePage {
	String EMI;
	public LoanCalculator(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="menu-item-2423")
	WebElement loanCalc;
	
	@FindBy(id="loan-amount-calc")
	WebElement loanAmtCalc;
	@FindBy(id="loan-tenure-calc")
	WebElement loanTenureCalc;
	
	@FindBy(id="loanamount")
	WebElement LoanAmount;
	
	@FindBy(xpath="//*[@id='loanamountslider']/span")
	WebElement loanAmtSlider;
	
	@FindBy(id="loaninterest")
	WebElement LoanInterest;
	
	@FindBy(xpath="//*[@id='loaninterestslider']/span")
	WebElement loanIntrstSlider;
	
	@FindBy	(id="loanterm")
	WebElement loanTerm;
	
	@FindBy(xpath="//*[@id='loantermslider']/span")
	WebElement loanTermSlider;
	
	@FindBy(xpath ="//*[@id='ltermwrapper']/div[1]//div/label[2]")
	WebElement termMnth;
	
	@FindBy(id="loanfees")
	WebElement Fee;
	
	@FindBy(xpath="//*[@id='loanfeesslider']/span")
	WebElement FeeSlider;
	@FindBy(id="loanemi")
	WebElement loanEMI;
	@FindBy(xpath="//*[@id='loanemislider']/span")
	WebElement emiSlider;
	
	@FindBy(xpath="//*[@id='loansummary-emi']/p/span")
	WebElement emi;
	
	@FindBy(xpath="//*[@id='leschemewrapper']//div/label[1]")
	WebElement adv;
	@FindBy(xpath="//*[@id='leschemewrapper']//div/label[2]")
	WebElement arrears;
	
	//id="emiarrears"
	@FindBy(className = "highcharts-point")
	List<WebElement> hover;
	
	@FindBy(id="startmonthyear")
	WebElement date;
	
	@FindBy(xpath="//tr//td//span[@class='month'][4]")
	WebElement month;
	
	@FindBy(id="yearformat")
	WebElement dropdown; //financialyear
	
	@FindBy(xpath="//*[@id='ecalprintandshare']/a[1]")
	WebElement print;
	
	@FindBy(xpath="//*[@id='sidebar']//print-preview-button-strip//div/cr-button[2]")
	WebElement close;
	
	@FindBy(xpath="//*[@id='ecalprintandshare']/a[2]")
    WebElement share;
	
	@FindBy(xpath="/html/head/title")
	WebElement title;
	@FindBy(id="loansummary")
	WebElement result;
	
	
	public void clickLoanCalculator() {
		calcDropDown.click();
		loanCalc.click();
	}
	
	public void clickLoanAmtCalc() {
		loanAmtCalc.click();
	}
	public void clickLoanTenureCalc() {
		loanTenureCalc.click();
	}
	public void loanAMT() throws InterruptedException {
		
		Thread.sleep(3000);
		LoanAmount.sendKeys(Keys.CONTROL + "a");
		LoanAmount.sendKeys("200000");
	
		//To move the slider
		Thread.sleep(3000);
		Actions move1 = new Actions(driver);
		move1.dragAndDropBy(loanAmtSlider, 50, 0).build().perform();
	}
	public void loanInterest() throws InterruptedException {
		
		LoanInterest.sendKeys(Keys.CONTROL + "a");
		LoanInterest.sendKeys("8");
		//To move the slider
		Thread.sleep(3000);
		Actions move2 = new Actions(driver);
		move2.dragAndDropBy(loanIntrstSlider, 50, 0).build().perform();
	}
	public void loanTenure() throws InterruptedException {
		
		loanTerm.sendKeys(Keys.CONTROL + "a");
		loanTerm.sendKeys("3");
		//To move the slider
		Thread.sleep(3000);
		Actions move3 = new Actions(driver);
		move3.dragAndDropBy(loanTermSlider, 60, 0).build().perform();
	}
	public void feeCharges() throws InterruptedException {
		
		Fee.sendKeys(Keys.CONTROL + "a");
		Fee.sendKeys("12000");
		//To move the slider
		Thread.sleep(3000);
		Actions move4 = new Actions(driver);
		move4.dragAndDropBy(FeeSlider, 60, 0).build().perform();
	}
	public void loanEMI() throws Exception {
		loanEMI.sendKeys(Keys.CONTROL + "a");
		loanEMI.sendKeys("30000");
		//To move the slider
		Thread.sleep(3000);
		Actions move5 = new Actions(driver);
		move5.dragAndDropBy(emiSlider, 60, 0).build().perform();
	}
	public void getResults() {
		System.out.println(result.getText());
		System.out.println("-----------------------");
	}
	public void emi() {
		EMI=emi.getText();
	}
	public void adv() {
		adv.click();
	}
	public void arrears() {
		arrears.click();
	}
	
	public void date() {
		date.click();
	}
	public void month() {
		month.click();
	}
	public void Dropdn() {
		Select s=new Select(dropdown);
	    s.selectByIndex(1);
	}
	public void hover() throws InterruptedException {
		Actions Hover = new Actions(driver);
	    for(WebElement i:hover) {
	    	Thread.sleep(500);
	    	Hover.moveToElement(i).perform();
	    }
	}
	
	

}
