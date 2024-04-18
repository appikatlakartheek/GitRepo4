package KartheekAppikatla.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import KartheekAppikatla.PageObjects.LandingPage;
import KartheekAppikatla.testcomponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest
{
	public LandingPage landingPage;
	@Given("User is on LandingPage")
	
	public void User_is_on_Landing_Page() throws IOException
	{
		
		
		landingPage=launchApplication();
	}
	
	
	@When ("^User enters username (.+) and password (.+)$")
	public void  User_enters_username_and_password(String username, String password)
	{
		landingPage.loginToApplication(username, password);
		
	}
	
	@Then ("{string} Message is displayed")
	public void Login_Succesfully_Message_is_displayed(String string)
	{
		 String Confirmation=landingPage.confirmationMessage();
		 Assert.assertTrue(Confirmation.equalsIgnoreCase(string));
	}

}
