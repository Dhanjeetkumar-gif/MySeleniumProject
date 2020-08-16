package com.qa.Utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.TestBase.TestBase;



public class Screenshot extends TestBase{
	
	public static void main(String[] args) {
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		}
		catch(Exception e) {
			
		}
	}

}
