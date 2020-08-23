package com.qa.Utils;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.TestBase.TestBase;

public class ExtentReportNG extends TestBase implements ITestListener {
    
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void setExtent() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Output\\Screenshot\\myReport.html");
		htmlReporter.config().setDocumentTitle("Automation report");
		htmlReporter.config().setReportName("functional report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostNmae", "Localhost");
		extent.setSystemInfo("Tester", "Dhanjeet Kumar");
		extent.setSystemInfo("Browser",prop.getProperty("browser"));
		
		test = extent.createTest("");
		String fileSeperator = System.getProperty("file.separator");
		
	
	}
	
}
