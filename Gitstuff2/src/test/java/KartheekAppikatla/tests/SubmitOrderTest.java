package KartheekAppikatla.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import KartheekAppikatla.PageObjects.LandingPage;
import KartheekAppikatla.testcomponents.BaseTest;
import junit.framework.Assert;

public class SubmitOrderTest extends BaseTest {

	@Test
	public void SubmitOrder() throws IOException
	{
		 LandingPage landingPage= launchApplication();
		 landingPage.loginToApplication("appikatla.kartheek@gmail.com", "Kars4143*1");
		 String Confirmation=landingPage.confirmationMessage();
		 Assert.assertEquals("Login Successfully", Confirmation);
		 
	}
	
}
