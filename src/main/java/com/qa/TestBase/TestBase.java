package com.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
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
		System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromePath") );
		driver=new ChromeDriver();
	}
	else if(browserName.equals("FF")) {
		System.setProperty("webdriver.gecko.driver",prop.getProperty("FFPath") );
		driver=new FirefoxDriver();
    }
    else if(browserName.equals("IE"))
	System.setProperty("webdriver.ie.driver",prop.getProperty("IEPath") );
	driver=new InternetExplorerDriver();
}

}