package com.easemytrip.oneway;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;


public class InitEMT {
	public WebDriver driver; 
	String browser; 
	String URL;
	@BeforeTest	
	public void beforeTest() throws Exception
	{
		FileInputStream File = new FileInputStream("src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(File); 
		browser = prop.getProperty("browser"); 
	    URL = prop.getProperty("URL"); 
		File.close(); 
		switch(browser) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
			driver=new ChromeDriver();  
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver","src\\test\\resources\\geckodriver.exe");
			driver=new FirefoxDriver(); 
			break;  
		} 
		driver.manage().window().maximize();  //maximizing the window
		driver.get(URL); //get the URL 
	}
	 
	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	

	
}
