package com.qa.TestPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.TestBase.TestBase;
import com.qa.Utils.ExtentTestManager;
//@Listeners(com.qa.Utils.TestListener.class)
public class LoginpageTest extends TestBase{
	Logger log=Logger.getLogger(LoginpageTest.class);
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
		public void setup() {
		Initialization();	
		}
	
	@Test
	public void titleCheck() {
		String actual=loginPage.getTitle();
		log.info("get title");
		String expected="opensourcecms — WordPress";
		Assert.assertEquals(actual, "hello");
	}
	
	@Test(enabled=false)
	public void getLoggedIn() {
		
		String userId=prop.getProperty("userId");
		log.info("fetched uid from config file");
		String password=prop.getProperty("password");
		log.info("fetched password from config file");
		loginPage.getLoggedin(userId, password);
		log.info("logged in");
		String act_ttl=driver.getTitle();
		Assert.assertEquals(act_ttl, "Home page");
	}
	@Test(enabled=false)
	public void currentURLCheck() {
		String exURL=driver.getCurrentUrl();
		String acURL="https://s1.demo.opensourcecms.com/wordpress/wp-login.php";
		Assert.assertEquals(acURL, exURL);
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	}


