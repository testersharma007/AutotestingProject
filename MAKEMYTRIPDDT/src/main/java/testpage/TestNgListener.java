package testpage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


//import com.ActiTime.generic.BaseLib;
// import testpage.CaseClass;
import com.google.common.io.Files;


public class TestNgListener implements ITestListener 
{
	public static int startCount, passedCount, failedCount, skippedCount=0;
 
	
	public void onTestStart(ITestResult result)
	{
		startCount++;
		Reporter.log(result.getName()+"  Script Execution start ", true);
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		passedCount++;
		Reporter.log(result.getName()+"  Script Passed : ) ", true);
		
	}

	public void onTestFailure(ITestResult result) 
	{
		failedCount++;
		Reporter.log(result.getName()+" Script is failled :( ", true);
		
		TakesScreenshot ts= (TakesScreenshot) BaseClass.driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/"+result.getName()+".png");
		try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		Reporter.log("ScreenShots Taken");
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		skippedCount++;
		Reporter.log(result.getName()+"  Script Skipped :(", true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) 
	{
		Reporter.log(" Suite Execution starts "+new java.util.Date(), true);
		
	}

	public void onFinish(ITestContext context)
	{
		Reporter.log(" Suite Execution Ends "+new java.util.Date(), true);
		System.out.println("Total Script Executed: "+startCount);
		System.out.println("Total Script passed: "+passedCount);
		System.out.println("Total Script Failed: "+failedCount);
		System.out.println("Total Script skipped : "+skippedCount);
		
	}


}
