package com.vcentry.tnstc.reportgenerator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ReportOptimizer {
// in same packge we have class "screenshotGenerator" in that class already tasken screnneshot will be over riding when ever
	//we running the applciation. so we moved this class
	
	public static void optimizeReport() throws IOException {
		
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-DD-hh-mm-ss--mmm");
		String name=df.format(date);
		
		File src=new File("G:\\WorkSpace\\DataDrivenTesting\\Screenshot\\");
		
		File dst=new File("G:\\WorkSpace\\DataDrivenTesting\\OldScreenshot\\"+name);
		
		FileUtils.copyDirectory(src, dst);
		FileUtils.cleanDirectory();
		
	}
	
}
