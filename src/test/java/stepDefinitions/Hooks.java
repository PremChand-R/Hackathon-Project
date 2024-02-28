package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import testBase.baseClass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;
	static Properties p;
	static baseClass bc=new baseClass();
	
	@BeforeAll
	public void before_or_after_all() throws Exception
	{	//create driver
		p=baseClass.getProperties();
		// navigate to emicalculator page
		String browser=p.getProperty("browser");
		bc.setUp(browser);
		driver=bc.getDriver();
	}

     
	@AfterStep
    public void addScreenshot(Scenario scenario) {
  	// this is for cucumber junit report
       if(!scenario.isFailed()) {
    	   TakesScreenshot ts=(TakesScreenshot) driver;
    	   byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
    	   scenario.attach(screenshot, "image/png",scenario.getName());
       }
	}

}
