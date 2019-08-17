package com.vcentry.tnstc.reportgenerator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.tnstc.initializer.Initialization;

public class ScreenshotGenerator extends Initialization {

	public static void generateScreenshot(ITestResult it) throws IOException {
		 Object [] data=it.getParameters();  // this line for taking screenshot for excuted test cases multiple time with same test case(Data driven testing with multiple paramer)
		   	
	   	 if(it.isSuccess())
	   	 {
	   	 String path=takeScreenshot(data[0].toString());
	   	 
	   	 log.log(LogStatus.PASS, "testcase pass", log.addScreenCapture(path));
	   	 }else 
	   	 {
	       	 String path=takeScreenshot(data[0].toString());
	       	 log.log(LogStatus.FAIL, "testcase pass", log.addScreenCapture(path));
	         }
	   	 reports.endTest(log);
	   	 reports.flush();
	    }

	public static String takeScreenshot(String name) throws IOException{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dst=new File("G:\\WorkSpace\\DataDrivenTesting\\Screenshot\\"+name+".jpg");
		FileUtils.copyFile(src, dst);
		return dst.toString();	
	}
	
}
	
