package com.vcentry.tnstc.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vcentry.tnstc.reportgenerator.ReportOptimizer;

public class Initialization {
	/**
	 * @author VenkadeshkumarThanga
	 * declare environment variable
	 * 
	 */
	
	public static FileInputStream envfis=null;
	public static FileInputStream locatorfis=null;
	public static Properties envProp=null;
	public static Properties locatorProp=null;
	public static WebDriver driver=null;
	public static ExtentReports reports;
	public static ExtentTest log;
	public static boolean isReportExist =true;
public static void intialize() throws IOException {
	
	if(isReportExist) {
	ReportOptimizer.optimizeReport();
	reports=new ExtentReports("G:\\WorkSpace\\DataDrivenTesting\\Report\\reportfile.html");
	isReportExist=false; // here once it came to if it return false
	}
	envfis=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"com"+File.separator+"vcentry"+File.separator+"tnstc"+File.separator+"config"+File.separator+"env.properties"));
	envProp=new Properties();
	envProp.load(envfis);
	
	locatorfis=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"com"+File.separator+"vcentry"+File.separator+"tnstc"+File.separator+"config"+File.separator+"locator.properties"));
	locatorProp=new Properties();
	locatorProp.load(locatorfis);
	
	
	if(driver==null) { //without this line browser will be opened n time for n time of dataset while passing from dataprovider.//
						//so this line will help to open browser if it not null

	if(envProp.getProperty("browser").equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Browser"+File.separator+"chromedriver.exe");
	driver=new ChromeDriver();
	}
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.get(envProp.getProperty("url"));
	
}

public static WebElement getElementByName(String name) {
	return driver.findElement(By.name(locatorProp.getProperty(name)));
}

}
