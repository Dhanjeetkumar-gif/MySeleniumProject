package com.qa.TestPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.TestBase.TestBase;
//@Listeners(com.qa.Utils.Listener.class)
public class LoginpageTest extends TestBase{
	Logger log=Logger.getLogger(LoginpageTest.class);
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
		public void setup() {
		Initialization();	
		}
	
	@Test(enabled=false)
	public void titleCheck() {
		String actual=loginPage.getTitle();
		String expected="opensourcecms — WordPress";
		Assert.assertEquals(actual, "hello");
	}
	
	@Test
	public void getLoggedIn() {
		
		String userId=prop.getProperty("userId");
		String password=prop.getProperty("password");
		loginPage.getLoggedin(userId, password);
		//Assert.assertEquals(actual, expected, message);
		log.info("logged in");
		String act_ttl=driver.getTitle();
		Assert.assertEquals(act_ttl, "Home page");
	}
	@Test
	public void currentURLCheck() {
		String exURL=driver.getCurrentUrl();
		String acURL="https://s1.demo.opensourcecms.com/wordpress/wp-login.php";
		Assert.assertEquals(acURL, exURL);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	}


