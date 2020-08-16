package com.qa.Utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.TestBase.TestBase;



public class Screenshot extends TestBase{
	File src;
	
	public File takeScreenshot() {
		try {
			src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		}
		catch(Exception e) {
			
		}
		return src;
	}

}
