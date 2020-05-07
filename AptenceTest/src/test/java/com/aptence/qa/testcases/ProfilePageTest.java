package com.aptence.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aptence.qa.base.TestBase;
import com.aptence.qa.pages.HomePage;
import com.aptence.qa.pages.LoginPage;
import com.aptence.qa.pages.ProfilePage;

public class ProfilePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ProfilePage profile;
	public ProfilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
	initialization();
	loginpage = new LoginPage();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	profile = new ProfilePage();
	}
	
	@Test 
	public void verifyUploadImageTest() {
		homepage.clickOnProfilePageLink();
		profile.verifyUploadImage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
