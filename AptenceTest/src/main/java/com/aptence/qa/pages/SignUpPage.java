package com.aptence.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aptence.qa.base.TestBase;

public class SignUpPage extends TestBase {
	WebDriverWait wait;
	
	@FindBy(xpath = "//button[contains(text(),'REGISTER')]")
	WebElement registerbtn;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@placeholder='Phone Number']")
	WebElement phonenumber;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//select[@formcontrolname='student_group']")
	WebElement selectclass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//button[contains(text(),'Verify')]")
	WebElement verifybtn;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage verifyRegisteration() {
		registerbtn.click();
		firstname.sendKeys("Tony");
		lastname.sendKeys("Stark");
		phonenumber.sendKeys("8901495635");
		password.sendKeys("pass1234");
		selectclass.click();
		Select drpDown = new Select(selectclass);
		drpDown.selectByValue("X");
		submit.click();
		wait.until(ExpectedConditions.visibilityOf(verifybtn));
		
		return new LoginPage();
		
	}

}
