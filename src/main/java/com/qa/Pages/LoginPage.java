package com.qa.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class LoginPage  extends TestBase{
	Logger log=Logger.getLogger("LoginPage");
	
	@FindBy(xpath="//input[@id='user_login']")
	WebElement userId;
	
	@FindBy(xpath="//input[@id='user_pass']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='wp-submit']")
	WebElement Loginbtn;
	
    public LoginPage() {
    	PageFactory.initElements(driver, this);
    }
    public HomePage getLoggedin(String uid,String pass) throws InterruptedException {
    	userId.sendKeys(uid);
    	log.info("user id entered");
    	password.sendKeys(pass);
    	log.info("password entered");
    	Thread.sleep(5000);
    	Loginbtn.click();
    	log.info("password entered");
    	return new HomePage();
    }
    public String getTitle() {
    	String title=driver.getTitle();
    	return title;
    }
	
}

