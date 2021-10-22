package com.easemytrip.oneway;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import com.easemytrip.oneway.OneWayFlightPageClass;

	
	public class OneWayFlightTest extends InitEMT
	{
		OneWayFlightPageClass  ofp;
		String currentHandle;
		String actual;
		
			
		@Test(priority = 1)
		public void radbtncheck() throws Exception 
		{
			ofp=new OneWayFlightPageClass();
			WebElement onewayradbtn = driver.findElement(By
	                .xpath("//*[@id=\"frmHome\"]/div[5]/div[2]/div[1]/ul/li[1]"));
			if(onewayradbtn.isSelected())
			{	
				return;
			}
			else	
			{
				onewayradbtn.click();
			}
			ofp.screenshot("OneWayRadio",driver);
		}
		
		@Test(priority = 2)
		public void searchbtnclick() throws Exception {try {
			 driver.findElement(By.id("FromSector_show")).click();
		        driver.findElement(By.id("FromSector_show")).sendKeys("Mumbai");
		        Thread.sleep(1500);
		        driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]")).click();
		 
		        driver.findElement(By.id("Editbox13_show")).sendKeys("Delhi");
		        Thread.sleep(1500);
		        driver.findElement(By.xpath("//ul[@id='ui-id-2']/li[1]")).click();
		        Thread.sleep(1000);
		        driver.findElement(By.xpath("//li[text()='30']")).click();

		        driver.findElement(By.xpath("//input[@value='Search']")).click();
			Reporter.log("PASSED");
			}
			catch(Exception e) {	
			Reporter.log("FAIL");	
			Thread.sleep(3000);
			}
			ofp.screenshot("SearchButton",driver);
	  }
		@Test(priority = 3)
		public void booknowbtnclick() throws Exception{
			 currentHandle = driver.getWindowHandle();
			OneWayFlightPageClass.Booknowbtn(driver).click();
			ofp.screenshot("Booknow",driver);
		}
		
		@Test(priority = 4)
		public void yesradiobtnclick()throws Exception {
			//driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
				OneWayFlightPageClass.Insuradiobtn(driver).click();
				ofp.screenshot("Insuranceradiobutton",driver);
		}
		@Test(priority = 6)
		public void enteremail() throws Exception{
			driver.findElement(By.id("txtEmailId")).sendKeys("abc@gmail.com");
			String Err=driver.findElement(By.xpath("//*[@id=\"divReview\"]/form/div[1]/label")).getText();
			Assert.assertEquals("Please enter your email address *", Err);
			driver.findElement(By.id("spnVerifyEmail")).click();
			ofp.screenshot("Mailenter",driver);
		}
			
			
			
			
			@Test(priority = 7)
		public void adduserdetails() throws Exception {
			String url2 = driver.getCurrentUrl();
			
			if(url2.startsWith("https://www.easemytrip.com/flight/review/")) {
				Reporter.log("Review Booking Page Appeared");
				driver.quit();
			}
			else if(url2.startsWith("https://flight.easemytrip.com/Review/CheckOut?CSU=&SearchID=hzohlwyu0n&ft=7&Ift=7&bc=&ISWL=")){
				System.out.println("COntinue your booking page");

				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				driver.findElement(By.cssSelector("div[class='fd-h1'] span")).click();		
			
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				ofp.screenshot("Addadult",driver);
		}
}
			@Test(priority = 8)
			public void continuebtnclick() throws Exception {
				Thread.sleep(3000);
				//driver.findElement(By.id("chkAdult0")).click();
				//((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.id("chkAdult0")));


				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@id=\"txtFNAdult0\"]")).sendKeys("Sarthak");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"txtLNAdult0\"]")).sendKeys("Dubey");
				Select se=new Select(driver.findElement(By.name("TitleAdult")));
				Thread.sleep(3000);
				se.selectByIndex(1);
				driver.findElement(By.xpath("//input[@id='txtCountryCode']")).sendKeys("+91");
				driver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys("7057437970");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.xpath("(//span[@class='co1'])[1]")).click();
				ofp.screenshot("Continuebutton",driver);
}
}