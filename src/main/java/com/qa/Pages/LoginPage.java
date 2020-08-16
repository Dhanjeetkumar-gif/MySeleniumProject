package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//input[@id='user_login']")
	WebElement userId;
	
	@FindBy(xpath="//input[@id='user_pass']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='wp-submit']")
	WebElement Loginbtn;
	
    public LoginPage() {
    	PageFactory.initElements(driver, this);
    }
    public HomePage getLoggedin(String uid,String pass) {
    	userId.sendKeys(uid);
    	password.sendKeys(pass);
    	Loginbtn.click();
    	return new HomePage();
    }
    public String getTitle() {
    	String title=driver.getTitle();
    	return title;
    }
	
}

