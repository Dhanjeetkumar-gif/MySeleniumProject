package com.qa.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.TestBase.TestBase;

public class LoginpageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
		public void setup() {
		Initialization();	
		}
	
	@Test
	public void titleCheck() {
		String actual=loginPage.getTitle();
		String expected="home page";
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void getLoggedIn() {
		String userId=prop.getProperty("userId");
		String password=prop.getProperty("password");
		loginPage.getLoggedin(userId, password);
		//Assert.assertEquals(actual, expected, message);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	}


