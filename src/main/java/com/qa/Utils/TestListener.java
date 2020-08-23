package com.qa.Utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.TestBase.TestBase;

public class TestListener extends TestBase implements ITestListener {
	
	Logger log = Logger.getLogger(TestListener.class);

	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
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
		String screencastPath;
		try {
			screencastPath = getScreenshot(driver,result.getMethod().getMethodName());
		ExtentTestManager.getTest().fail("Screenshot",
				MediaEntityBuilder.createScreenCaptureFromPath(screencastPath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result){
		log.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		log.info((result.getMethod().getMethodName() + " failed!"));
		ExtentTestManager.getTest().log(Status.FAIL,result.getThrowable());
		String screencastPath;
		try {
			screencastPath = getScreenshot(driver,result.getMethod().getMethodName());
		ExtentTestManager.getTest().fail("Screenshot",
				MediaEntityBuilder.createScreenCaptureFromPath(screencastPath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static String getScreenshot(WebDriver driver,String ScreenshotName) throws IOException{
		String DateName=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\FailedTestScreenshot\\"+ScreenshotName+DateName+".png";
	    File finalDestination=new File(destination);
	    FileUtils.copyFile(source,finalDestination );
	    return destination;
	}
}