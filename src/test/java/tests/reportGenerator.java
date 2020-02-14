package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reportGenerator {
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	  public void beforeTest() {
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/extentreport/report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		htmlreporter.config().setDocumentTitle("TestReport");
		htmlreporter.config().setReportName("HTMLREPORT");
		htmlreporter.config().setTheme(Theme.STANDARD);
		
		extent.setSystemInfo("Author", "Benny");
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\benny\\Automation\\feb12selenium\\Seleniumplusdem\\Driver\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
  @Test
  public void registertest() {
	  logger = extent.createTest("register test");
	  // code for registration
	  Assert.assertTrue(false);
  }
  @Test
  public void logintest() {
	  logger = extent.createTest("register test");
	  driver.get("http://newtours.demoaut.com/");
	  driver.findElement(By.name("userName")).sendKeys("jacktest");
	  driver.findElement(By.name("password")).sendKeys("jacktest");
	  driver.findElement(By.name("login")).click();
	  
	  String title = driver.getTitle();
	  Assert.assertEquals(title, "Find a Flight: Mercury Tours:");
	  
  }
  

  @AfterMethod
  public void getstatus(ITestResult result) throws IOException {
	  //check markup helper - Benny
	  if(result.getStatus()==ITestResult.SUCCESS)
	  {
		  logger.log(Status.PASS, MarkupHelper.createLabel("Test methods passed"+result.getTestName(),ExtentColor.BLUE));
	  }
	  else if(result.getStatus()==ITestResult.FAILURE)
	  {
		  logger.log(Status.FAIL, result.getTestName());
		  logger.addScreenCaptureFromPath("C:\\Users\\benny\\Pictures\\50JOE.png");
	  }
  }

  @AfterTest
  public void flushh() {
	  driver.close();
	  extent.flush();
  }

}
