package testpage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;


public class IListener
{
 

@AfterMethod()
  public void takescreenshort() throws IOException 
  {
	 
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.softwaretestingmaterial.com/capture-screenshot-using-selenium-webdriver");
	  File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(screenshotFile, new File("/MAKEMYTRIPDDT/Screenshot"));
	  driver.close();
	  driver.quit();
  }
}
