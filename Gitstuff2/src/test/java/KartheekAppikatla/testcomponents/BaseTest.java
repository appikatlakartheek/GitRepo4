package KartheekAppikatla.testcomponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import KartheekAppikatla.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;

	
	public WebDriver initializeDriver() throws IOException 
	{
	Properties prop= new Properties();
	
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\KartheekAppikatla\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") :  prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			
			
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions options=new ChromeOptions();
		  options.addArguments("headless");
		    driver=new ChromeDriver(options);
		   
		  
		}
		
		
		else if (browserName.equalsIgnoreCase("edge"))
		{
			 WebDriverManager.edgedriver().setup();
			 WebDriver driver=new EdgeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("firefox"))	
		{
			
		}


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		LandingPage landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty(("user.dir")+"//reports"+testCaseName+".png"));
	FileUtils.copyFile(source, file);
	return System.getProperty(("user.dir")+"//reports"+testCaseName+".png");
	}

	
	}
	
	
	