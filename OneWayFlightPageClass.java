package com.easemytrip.oneway;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class OneWayFlightPageClass 
{
	static WebElement webelem;
	WebDriver driver;
	
	
	static  By searchbtn = By.xpath("(//input[@class='src_btn'])[1]"); //search button
	static By onewayradbtn = By.xpath("//*[@id=\"frmHome\"]/div[5]/div[2]/div[1]/ul/li[1]"); //OneWayButton
	static By morepricesbtn= By.id("divMoreFare0"); //More Prices Button
	static By booknowbtn= By.xpath("/html/body/form/div[9]/div[4]/div/div[2]/div[2]/div/div/div[4]/div[1]/div[1]/div[1]/div[6]/button[1]"); //BookNow Button
	static By insuradbtn= By.xpath("//*[@id=\"divInsuranceTab\"]/div[3]/div[1]/label/span"); //insurance radio button
	static By EmailIDfield= By.id("txtEmailId");
	static By revcontbut= By.xpath("/html/body/form/div[11]/div[6]/div[1]/div[4]/div[2]/div[1]/form/div[3]/span"); //review continue button//
	////*[@id="spnVerifyEmail"]//
	static By addadult = By.xpath("//*[@id=\"divTravlerEntry\"]/div[2]/div/a");//add adult button
	static By firstnamepath = By.id("txtFNAdult0");// first name text box
	//*[@id="txtFNAdult0"]//
	static By lastnamepath = By.id("txtLNAdult0");// last name text box
	//*[@id="txtLNAdult0"]//
	static By titlechck= By.id("titleAdult0"); //title checkbox
	//*[@id="titleAdult0"//
	static By mobilenopath=By.id("txtCPhone");// mobile number check box
	//*[@id="txtCPhone"]
	static By yesinsurancebtn = By.xpath("/html/body/form/div[11]/div[6]/div[1]/div[4]/div[2]/form/div/div[7]/div[3]/div[1]/label");//  insurance yes button 
	static By travellercontinuebtn = By.xpath("//*[@id=\"spnTransaction\"]"); // continue button
	
	
	public static WebElement Searchbtn(WebDriver driver) 
	{
		webelem= driver.findElement(searchbtn);
		return webelem;
	
	}
	public static WebElement VeiwMorepricebtn(WebDriver driver) {
		webelem= driver.findElement(morepricesbtn);
		return webelem;
	}
	public static WebElement Booknowbtn(WebDriver driver) {
		webelem = driver.findElement(booknowbtn);
		return webelem;
	}
	public static WebElement onewayradbtn(WebDriver driver) {
		webelem = driver.findElement(onewayradbtn);
		return webelem;
	}
	public static WebElement Insuradiobtn(WebDriver driver) {
		webelem = driver.findElement(insuradbtn);
		return webelem;
	}
	public static WebElement Continuebtn(WebDriver driver) {//inside "review your booking" page after clicking radio btn
		webelem = driver.findElement(revcontbut);
		return webelem;
	}
	
	//Fill user details in Traveller and Addons section 
	
	public static WebElement Firstname(WebDriver driver) {
		webelem = driver.findElement(firstnamepath);
		return webelem;
	}
	
	public static WebElement Lastname(WebDriver driver) {
		webelem = driver.findElement(lastnamepath);
		return webelem;
	}
	
	public static WebElement Addadult(WebDriver driver) {
		webelem = driver.findElement(addadult);
		return webelem;
	}
	
	public static WebElement Title(WebDriver driver) {
		webelem = driver.findElement(titlechck);
		return webelem;
	}
	public static WebElement Mobileno(WebDriver driver) {
		webelem = driver.findElement(mobilenopath);
		return webelem;
	}
	
	public static WebElement Emailid(WebDriver driver) {
		webelem = driver.findElement(EmailIDfield);
		return webelem;
	}
	//^^User details Ends
	
	public static WebElement Travellercontinuebtn(WebDriver driver) {
		webelem = driver.findElement(travellercontinuebtn); //give explicit wait in testcase for review details page and then click confirm
			return webelem;
	}	
	public void screenshot(String Sname,WebDriver driver) throws IOException {//This method Takes Screenshot wherever called
		System.out.println();
		 TakesScreenshot screenshot = ((TakesScreenshot)driver); //creating an object
		 File src = screenshot.getScreenshotAs(OutputType.FILE); //Storing the source in src from where to take screenshot
		 File destnation = new File("src\\test\\resources\\screenshots\\"+Sname+".png"); //Giving destination folder "Sname is name of the image that will be provided while calling this function"
		 FileUtils.copyFile(src, destnation); //Copying the from source to destination
	}

	
}
