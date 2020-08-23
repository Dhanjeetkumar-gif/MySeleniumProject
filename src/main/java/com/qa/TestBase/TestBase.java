package com.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	Logger log=Logger.getLogger(TestBase.class);
	
	public static WebDriver driver;
	public static Properties prop;
	public TestBase() {
    try 
    {
    	prop=new Properties();
    	FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\Config\\Config.properties"); 
        prop.load(ip);
    }
    catch(FileNotFoundException e)
    {
    	e.printStackTrace();
    }
    catch(IOException ex) {
    	ex.printStackTrace();
    }
}
public static void Initialization() {
	String browserName=prop.getProperty("browser");
	if(browserName.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rageaholic\\eclipse-workspace2\\MySeleniumProject\\src\\Drivers\\chromedriver.exe");
		
		driver=new ChromeDriver();
	}
	else if(browserName.equals("FF")) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\rageaholic\\eclipse-workspace2\\MySeleniumProject\\src\\Drivers\\geckodriver.exe" );
		driver=new FirefoxDriver();
    }
    else if(browserName.equals("IE")) {
	System.setProperty("webdriver.ie.driver",prop.getProperty("IEPath") );
	driver=new InternetExplorerDriver();
	}
	driver.get(prop.getProperty("URL"));
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	long pageloadtout=Integer.parseInt(prop.getProperty("PageloadTimeout"));
	long implicitlytout=Integer.parseInt(prop.getProperty("Implicitlywaittimeout"));
	driver.manage().timeouts().pageLoadTimeout(pageloadtout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(implicitlytout,TimeUnit.SECONDS );
	
}

}
