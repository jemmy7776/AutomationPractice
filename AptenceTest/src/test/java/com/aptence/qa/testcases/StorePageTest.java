package com.aptence.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aptence.qa.base.TestBase;
import com.aptence.qa.pages.HomePage;
import com.aptence.qa.pages.LoginPage;
import com.aptence.qa.pages.StorePage;
import com.aptence.qa.util.TestUtil;

public class StorePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	StorePage storepage;
	
	public StorePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		storepage = homepage.clickOnStorePageLink();
	}
	
	@DataProvider
	public Object[][] getAptenceTestData() {
		Object data[][] = TestUtil.getTestData("info");
		return data;
	}
	@Test(dataProvider = "getAptenceTestData")
	public void verifyItemRedeemTest(String name, String address, String state, String city, String zipcode) {
		//storepage.verifyItemRedeem("Tony", "234-B, Salisburyway", "Brampton", "Ontario", "224321");
		
		storepage.verifyItemRedeem(name, address, city, state, zipcode);
		
	}
	@AfterMethod
		public void tearDown() {
		driver.quit();	
		}
	

}
