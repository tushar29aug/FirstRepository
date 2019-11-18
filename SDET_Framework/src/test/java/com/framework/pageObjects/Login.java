package com.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;
	
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="uid")
	WebElement username;
	
	@FindBy (name="password")
	WebElement password;
	
	@FindBy (name="btnLogin")
	WebElement loginBtn;
	
	
	public void setUserName(String user){
		username.sendKeys(user);
	}
	
	public void setPassword(String pass){
		password.sendKeys(pass);
	}
	
	public void clickLoginBtn(){
		loginBtn.click();
	}
}
