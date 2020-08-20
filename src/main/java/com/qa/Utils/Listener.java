package com.qa.Utils;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.qa.TestBase.TestBase;

public class Listener implements ITestListener  {
	//ExtentReports extent=ExtentReportNG.
	Screenshot scrnshot;
	

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String ssName=result.getTestName();
		String src2=scrnshot.takeScreenshot();
		File file=new File(src2);
		try {
			FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\MySeleniumProject\\Output\\"
					+ "Screenshot\\"+ssName+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
	}
	

}
