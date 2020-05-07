package com.aptence.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aptence.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	
	//Page Factory
	@FindBy(xpath="//a[@class='btn get-started-btn mt-3']")
	WebElement getStarted;
	
	@FindBy(xpath="//input[@formcontrolname='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	@FindBy(id="logo")
	WebElement aptenceLogo;
	
	//Initializing Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPage() {
		return driver.getTitle();
	}
	
	public boolean validateAptenceLogo() {
		return aptenceLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pw) {
		getStarted.click();
		username.sendKeys(un);
		password.sendKeys(pw);
		login.click();
		
		return new HomePage();
	}
}
