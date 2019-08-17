package com.vcentry.tnstc.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.tnstc.initializer.Initialization;
import com.vcentry.tnstc.inputreader.inputReader;
import com.vcentry.tnstc.reportgenerator.ScreenshotGenerator;
import com.vcenty.tnstc.pages.RegPage;

public class RegPageTest extends Initialization {
	
	@Test(dataProvider="RegPageTest")
	public void validateRegPage(String tcName,String username,String password,String confirmPassword,String secertquestion, String secertanswer) throws IOException {
		
		//above string tcName // getting the value of first heading from excel to identify which data set is getting failed.
		
		intialize();
//		WebElement userName=driver.findElement(By.name("txtUserLoginID"));
// 		userName.sendKeys("Vcentry");
//
//		WebElement userName=driver.findElement(By.name(locatorProp.getProperty("regpage_type_username_name")));
//		userName.sendKeys("Vcentry");
//		
// 		WebElement password=driver.findElement(By.name("txtPassword"));
//		password.sendKeys("Vcentry@123");
//
//		WebElement password=driver.findElement(By.name(locatorProp.getProperty("regpage_type_passsword_name")));
//		password.sendKeys("Vcentry@123");
//		
//		WebElement confirmPassword=driver.findElement(By.name("txtConfirmPassword"));
//		confirmPassword.sendKeys("Vcentry@123");
//		
//		WebElement confirmPassword=driver.findElement(By.name(locatorProp.getProperty("regpage_type_confirmpassword_name")));
//		confirmPassword.sendKeys("Vcentry@123");
//		
//		WebElement secertquestion=driver.findElement(By.name("txtSecretQuestion"));
//		Select s=new Select(secertquestion);
//		s.selectByVisibleText("High school name?");
//		
//		WebElement secertquestion=driver.findElement(By.name(locatorProp.getProperty("regpage_select_securityquestion_name")));
//		Select s=new Select(secertquestion);
//		s.selectByVisibleText("High school name?");
//		
//		WebElement secertAnswer=driver.findElement(By.name("txtSecretAnswer"));
//		secertAnswer.sendKeys("govt.hss");
//	
//		WebElement secertAnswer=driver.findElement(By.name(locatorProp.getProperty("regpage_type_securityanswer_name")));
//		secertAnswer.sendKeys("govt.hss");
//
	
		
		//2)Code optimition for (driver.findElement())
//		getElementByName("regpage_type_passsword_name").sendKeys("Vcentry");
//		getElementByName("regpage_type_passsword_name").sendKeys("Vcentry@123");
//		getElementByName("regpage_type_confirmpassword_name").sendKeys("Vcentry@123");
//		WebElement dropdown=getElementByName("regpage_select_securityquestion_name");
//		Select s=new Select(dropdown);
//		s.selectByVisibleText("High school name?");
		
		//3)getting data from dataprovider
		
//		RegPage.enterUseraname("vcentry");
//		RegPage.enterPassword("Vcentry@123");
//		RegPage.enterConfirmPassword("VCentry@123");
//		RegPage.enterSeceratQuestion("High school name?");
//		RegPage.enterSeceratAnswer("Govt HSS");
		
		
		RegPage.enterUseraname(username);
		RegPage.enterPassword(password);
		RegPage.enterConfirmPassword(confirmPassword);
		RegPage.enterSeceratQuestion(secertquestion);
		RegPage.enterSeceratAnswer(secertanswer);
		
	}
	
	@DataProvider(name="RegPageTest")
	public static Object[][] getData() throws Exception {
	
		if(inputReader.RunModeVerification("RegPageTest")) {
		Object[][] data=inputReader.selectSingleDataOrMulitiData("RegPageTest");
		
		return data;	
	}
		
return null;
	
	}
	@AfterMethod
    public void teardown(ITestResult it) throws IOException{
   	
		ScreenshotGenerator.generateScreenshot(it);
}

}