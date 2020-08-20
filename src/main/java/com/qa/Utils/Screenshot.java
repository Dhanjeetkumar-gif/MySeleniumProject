package com.qa.Utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.TestBase.TestBase;



public class Screenshot extends TestBase{
static String dest;
	
	public static String takeScreenshot() {
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String dest=System.getProperty("user.dir")+"\\Output\\Screenshot"+".png";
			FileUtils.copyFile(src, new File(dest));
		}
		catch(Exception e) {
			
		}
		return dest;
	}

}
