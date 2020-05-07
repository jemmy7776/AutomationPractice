package com.aptence.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aptence.qa.base.TestBase;
import com.aptence.qa.pages.ContactUsPage;
import com.aptence.qa.pages.HomePage;
import com.aptence.qa.pages.LoginPage;

public class ContactUsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactUsPage contactus;
	
	public ContactUsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactus = homepage.clickOnContactUsPageLink();
	}
	
	@Test(priority=1)
	public void contactUsPageHeading() {
		Assert.assertTrue(contactus.verifyContactUsPageHeading());
	}
	
	@Test(priority=2)
	public void sendMessage() {
		contactus.enterMessage("Hello There");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
