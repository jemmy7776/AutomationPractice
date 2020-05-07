package com.aptence.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aptence.qa.base.TestBase;
import com.aptence.qa.pages.ContactUsPage;
import com.aptence.qa.pages.HomePage;
import com.aptence.qa.pages.LoginPage;
import com.aptence.qa.pages.StorePage;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactUsPage contactus;
	StorePage store;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactus = new ContactUsPage();
		store = new StorePage();
	}
	@Test(priority=1)
	public void verifyHomePageOpened() {
	Assert.assertTrue(homepage.verifyHomePageOpened());
	}
	
	@Test(priority=2)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Aptence | Adaptive, Gamified & Rewarding Learning Platform for School Students","HomePage Title not Matched");
	}
	@Test(priority=3)
	public void verifyProfileNameTest() {
		String profileName = homepage.verifyProfileName();
		Assert.assertEquals(profileName, prop.getProperty("name"), "Name not Matched");
	}
	@Test(priority=4)
	public void verifyContactUsLinkTest() {
		contactus = homepage.clickOnContactUsPageLink();
	}
	@Test(priority=5)
	public void verifyProfilePageLinkTest() {
		homepage.clickOnProfilePageLink();
	}
	@Test(priority=6)
	public void verifyStorePageTest() {
		homepage.clickOnStorePageLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
