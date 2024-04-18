package KartheekAppikatla.stepDefinitions;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.gherkin.model.Scenario;

import KartheekAppikatla.testcomponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.*;

public class Hooks extends BaseTest {
	
	WebDriver driver;

public Hooks(WebDriver driver)
	
	{
		
		this.driver=driver;
		
	}


@Before

public void beforeScenario()
{
	System.out.println("Before Scenario");
}
	
	




	@After
	
	public void getScreenShotOnFailure(io.cucumber.java.Scenario scenario)
	{
		
		
		if (scenario.isFailed())
		{
			TakesScreenshot ts = (TakesScreenshot )(driver);
			byte[] ScreenShot= ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(ScreenShot, "image/png", "Login Scenario");	
			
		}
		
			
		
		
		
	}

}
