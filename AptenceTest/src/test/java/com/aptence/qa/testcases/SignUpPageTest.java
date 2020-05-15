package com.aptence.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aptence.qa.base.TestBase;
import com.aptence.qa.pages.LoginPage;
import com.aptence.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase{
	
	SignUpPage signuppage;
	LoginPage loginpage;
	
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signuppage = new SignUpPage();
		
	}
	@Test
	public void verifySignUpTest() {
		loginpage = signuppage.verifyRegisteration();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
