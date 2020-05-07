package com.aptence.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aptence.qa.base.TestBase;
import com.aptence.qa.pages.HomePage;
import com.aptence.qa.pages.LeaderboardPage;
import com.aptence.qa.pages.LoginPage;

public class LeaderboardPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	LeaderboardPage leaderboardpage;
	
	public LeaderboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		leaderboardpage = homepage.clickOnleaderboardPage();
	}
	
	@Test
	public void verifyWeeklyTopperTest() {
		homepage.clickOnleaderboardPage();
		leaderboardpage.verifyWeeklyTopper();
	}
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	

}
