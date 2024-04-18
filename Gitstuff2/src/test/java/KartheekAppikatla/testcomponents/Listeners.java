package KartheekAppikatla.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import KartheekAppikatla.Resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {

         ExtentTest test;
		 ExtentReports extent= ExtentReporterNG.getReportObject();
		 
		 @Override
		  public void onTestStart(ITestResult result) {
		    
			  test= extent.createTest(result.getMethod().getMethodName());
		  }

	@Override
		  public void onTestSuccess(ITestResult result) {
			  
		    test.log(Status.PASS, "Test is passed");
		  }

		
		 @Override
		  public void onTestFailure(ITestResult result) {
			
			  
			  test.log(Status.FAIL, "Test is failed");
			  test.fail(result.getThrowable());
			  
			  try {
				driver=((WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance()));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String filepath=null;
				try {
				filepath= getScreenshot(result.getMethod().getMethodName(),driver);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
			 test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
			  
		  }
		  
		
		  public void onStart(ITestContext context) {
			    // not implemented
			  }


			  public  void onFinish(ITestContext context) {
				  extent.flush();
			    // not implemented
			  }
			
			  
}


		



