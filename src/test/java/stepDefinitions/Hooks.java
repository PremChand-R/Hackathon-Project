package stepDefinitions;

import java.util.Properties;

//import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import testBase.baseClass;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;
	static Properties p;
	static baseClass bc=new baseClass();
	
	@BeforeAll
	public static void before_or_after_all() throws Exception
	{	//create driver
		p=baseClass.getProperties();
		// navigate to emicalculator page
		String browser=p.getProperty("browser");
		bc.setUp(browser);
		driver=bc.getDriver();
	}
	
	@AfterAll
	public static void after_all() throws Exception
	{	driver.quit();
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
