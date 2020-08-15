package testpage;


import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class BaseClass 
{
  public static WebDriver driver = null;
  
  @BeforeSuite
  public void beforeSuite() 
  {
	  System.setProperty("Webdriver.chrome.driver", "/MAKEMYTRIPDDT/Exefolder/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  

	  
  }

  @AfterSuite
  public void afterSuite()
  {
	  driver.close();
	  
  }

}
