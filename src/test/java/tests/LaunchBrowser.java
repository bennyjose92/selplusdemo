package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LaunchBrowser {
	
  
  public void chromelaunch() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\benny\\Automation\\feb12selenium\\Seleniumplusdem\\Driver\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
/*	  driver.get("http://newtours.demoaut.com/");
	  driver.findElement(By.name("userName")).sendKeys("jacktest");
	  driver.findElement(By.name("password")).sendKeys("jacktest");
	  driver.findElement(By.name("login")).click();*/
	  
	/*  driver.get("https://www.toolsqa.com/");
	  driver.manage().window().maximize();
	  
	  Actions act = new Actions(driver);
	  s
	  WebElement e1 = driver.findElement(By.xpath("//span[text()='Tutorial']"));
	  act.moveToElement(e1).perform();
	  
	  WebElement e2 = driver.findElement(By.xpath("//span[text()='Web Automation Tools']"));
	  act.moveToElement(e2).perform();
	  
	  WebElement e3 = driver.findElement(By.xpath("//span[text()='Selenium in Java']"));
	  act.moveToElement(e3).click().build().perform();*/
	  
	  
	 /* driver.get("https://www.cleartrip.com/");
	  driver.manage().window().maximize();
	  
	  Actions act = new Actions(driver);
	  
	  WebElement from = driver.findElement(By.id("FromTag"));
	  WebElement to = driver.findElement(By.id("ToTag"));
	  
	  from.sendKeys("HYD");
	  Thread.sleep(5000);
	  act.sendKeys(Keys.DOWN,Keys.ENTER).perform();
	//  act.sendKeys(Keys.ENTER).perform();;
*/	  
	   driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	  driver.manage().window().maximize();
	  
	  Actions act = new Actions(driver);
	  
	  WebElement from = driver.findElement(By.xpath("//*[text()='Maldives']/../../..//*[text()='Weekend Package']/../.."));
	  WebElement to = driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
	  
	  //method 1
	 // act.dragAndDrop(from, to).perform();
	  
	  //method 2
	  act.clickAndHold(from).release(to).build().perform();
  }
  @Test
  public void readwriteexcel() throws IOException
  {
	  
	  FileInputStream fis = new FileInputStream("C:\\Users\\benny\\Desktop\\test.xlsx");
	  
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  
	  XSSFSheet sheet1 = wb.getSheetAt(0);
	  
	  int rowcount = sheet1.getPhysicalNumberOfRows();
	  
	  for(int i=0 ;i<rowcount ;i++)
	  {
		 String uname = sheet1.getRow(i).getCell(0).getStringCellValue();
		 String pwd = sheet1.getRow(i).getCell(1).getStringCellValue();
		 System.out.println(uname+" "+pwd);
		 sheet1.getRow(i).createCell(2).setCellValue("hi test");
		 
	  }
	  
	  FileOutputStream fos = new FileOutputStream("C:\\Users\\benny\\Desktop\\test.xlsx");
	  wb.write(fos);
  }

}
