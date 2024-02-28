package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.baseClass;

public class basePage {
	 static WebDriver driver=baseClass.driver;
	 
	 public basePage(WebDriver driver){
		 //initialize WebElements
		 PageFactory.initElements(driver,this);
	 }   
	 @FindBy(id="menu-item-dropdown-2696")
	 WebElement calcDropDown;
	 

	 @FindBy(xpath="//*[@id=\"loanamountslider\"]//span")
	 WebElement loanAmountSlider;
	 @FindBy(xpath="//*[@id=\"loaninterestslider\"]//span")
	 WebElement loanInterestSlider;
	 @FindBy(xpath="//*[@id=\"loantermslider\"]//span")
	 WebElement loanTermSlider;	
	@FindBy(xpath="//*[@id='loanintereststeps']/span[@style='left: 100%;'']/span")
	WebElement interestMax;
	
	
	
	public static void clear() {
		Actions act=new Actions(driver);
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
	}
	public static void set() {
		Actions act=new Actions(driver);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
		
}