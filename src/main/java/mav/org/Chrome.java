package mav.org;

import java.lang.ProcessHandle.Info;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
@Test
public class Chrome {
	static ExtentReports report;
	static ExtentTest test;
	static WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		 System.setProperty("webdriver.chrome.driver","C:\\BBD_WS\\EtherTestng\\lib\\chromedriver.exe");
         driver = new ChromeDriver();
         
        driver.get("https://adactinhotelapp.com/index.php");
        report = new ExtentReports(System.getProperty("C:\\BBD_WS\\EtherTestng")+"ExtentReportResults.html");
        test = report.startTest("Chrome");
	}
	
	@Test(priority = 1)
	public void login() {
		if(driver.findElement(By.xpath("//td[text()='Existing User Login - Build 1']")).getText().equals("Existing User Login - Build 1"))
		{
test.log(LogStatus.PASS, "sucsess");
System.out.println("pass");

	}
else
{
	test.log(LogStatus.FAIL, "Failed");
}
		driver.findElement(By.xpath("(//input[@ name='username'])[1]")).sendKeys("Ssabari99");
        driver.findElement(By.xpath("//input[@id='password'] ")).sendKeys("asdf1234");
        driver.findElement(By.xpath("//input[@id='login']")).click();
    }
	@Test(priority = 2)
	public void hotel() throws InterruptedException {
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//td[text()='Search Hotel '] ")).getText().equals("Search Hotel "))
		{
			test.log(LogStatus.PASS, "sucsess");
							}
		else
		{
			test.log(LogStatus.FAIL, "Failed");
			
		}
		WebElement loc = driver.findElement(By.xpath("//select[@name='location']"));
        Select s = new Select(loc);
        s.selectByValue("Sydney");
        
        WebElement hotel = driver.findElement(By.xpath("//select[@name='hotels']"));
        Select s1 = new Select( hotel);
        s1.selectByValue("Hotel Creek");
        
        WebElement type = driver.findElement(By.xpath("//select[@name='room_type']"));
        Select s2 = new Select(type);
        s2.selectByValue("Standard");
        
        WebElement noRoom = driver.findElement(By.id("room_nos"));
        Select s3= new Select(noRoom);
        s3.selectByVisibleText("1 - One");
        
        WebElement Adult = driver.findElement(By.id("adult_room"));    
        Select s4 = new Select(Adult);
        s4.selectByVisibleText("1 - One");
        
        
        WebElement child = driver.findElement(By.xpath("//select[@id='child_room']"));    
        Select s5 = new Select(child);
        s5.selectByVisibleText("1 - One");    
        
        driver.findElement(By.xpath("//input[@id='Submit']")).click();
    
        driver.findElement(By.id("radiobutton_0")).click();
        driver.findElement(By.id("continue")).click();


	}
	@Test(priority = 3)
	public void info() {
		if(	driver.findElement(By.xpath("//td[text()='Book A Hotel ']")).getText().equals("//td[text()='Book A Hotel ']"))
		{
			test.log(LogStatus.PASS, "sucsess");

		}
		else
		{
			test.log(LogStatus.FAIL, "Failed");
		}

		 driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("sabarish");
         driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Balachandran");
         driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("perumbur,chennai-97");
     
	}
	@Test(priority = 4)
	public void payment() {
		 driver.findElement(By.xpath("//input[@name='cc_num']")).sendKeys("4500248738291008");
         WebElement card= driver.findElement(By.xpath("//select[@name='cc_type']"));    
         Select s6 = new Select(card);
         s6.selectByVisibleText("American Express");    
         driver.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys("876");
         WebElement month= driver.findElement(By.xpath("//select[@name='cc_exp_month']"));    
         Select s7 = new Select(month);
         s7.selectByVisibleText("January");    
         WebElement year= driver.findElement(By.xpath("//select[@name='cc_exp_year']"));    
         Select s8 = new Select(year);
         s8.selectByVisibleText("2021");
         driver.findElement(By.xpath("//input[@type='button']")).click();
	}
	@AfterClass
	public void end() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}

	}

