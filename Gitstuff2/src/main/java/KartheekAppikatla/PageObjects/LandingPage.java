package KartheekAppikatla.PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KartheekAppikatla.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath=("//input[@id='userEmail']"))
			WebElement emailele;
	
	@FindBy (xpath=("//input[@id='userPassword']"))
	WebElement passwordele;
	
	@FindBy (xpath=("//input[@id='login']"))
	WebElement loginButton;
	
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	

	public void goTo() throws IOException
	{
		Properties prop1= new Properties();
		FileInputStream fis1= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\KartheekAppikatla\\Resources\\GlobalData.properties");
		prop1.load(fis1);
		String urlName=prop1.getProperty("url");
		driver.get(urlName);
	}
	
	
	public void loginToApplication(String email,String password)
	{
		emailele.sendKeys(email);
		passwordele.sendKeys(password);
		loginButton.click();
	}
	
	public String confirmationMessage()
	{
		String message= driver.findElement(By.xpath("//div[@id='toast-container']")).getText();
		return message;
	}
	
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
}
