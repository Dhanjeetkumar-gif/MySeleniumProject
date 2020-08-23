package com.qa.Utils;


import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.xdgf.util.Util;
//import org.apache.logging.log4j.util.PropertySource.Util;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {
	Logger log = Logger.getLogger(TestListener.class);//getLogger(TestListener.class); 

	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailure(ITestResult result) {
		log.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		log.info((result.getMethod().getMethodName() + " failed!"));
		//.resulExtentTest test=startTest(result.getMethod().getMethodName());
		ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());

		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");

		String targetLocation = null;

		//String testClassName = getTestClassName(result.getInstanceName()).trim();
		//String timeStamp = Util.getCurrentTimeStamp(); // get timestamp
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + timeStamp + ".png";
		String fileSeperator = System.getProperty("file.separator");
		String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator
				+ "screenshots";
		log.info("Screen shots reports path - " + reportsPath);
		try {
			File file = new File(reportsPath + fileSeperator ); // Set
																				// screenshots
																				// folder
			if (!file.exists()) {
				if (file.mkdirs()) {
					log.info("Directory: " + file.getAbsolutePath() + " is created!");
				} else {
					log.info("Failed to create directory: " + file.getAbsolutePath());
				}

			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			targetLocation = reportsPath + fileSeperator  + fileSeperator + screenShotName;// define
																											// location
			File targetFile = new File(targetLocation);
			log.info("Screen shot file location - " + screenshotFile.getAbsolutePath());
			log.info("Target File location - " + targetFile.getAbsolutePath());
			FileUtils.copyFile(screenshotFile, targetFile);
			
		} catch (FileNotFoundException e) {
			log.info("File not found exception occurred while taking screenshot " + e.getMessage());
		} catch (Exception e) {
			log.info("An exception occurred while taking screenshot " + e.getCause());
		}

		// attach screenshots to report
		try {
			ExtentTestManager.getTest().fail("Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
		} catch (IOException e) {
			log.info("An exception occured while taking screenshot " + e.getCause());
		}
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

}