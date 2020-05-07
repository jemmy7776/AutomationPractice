package com.aptence.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aptence.qa.base.TestBase;

public class LeaderboardPage extends TestBase{
	
	@FindBy(xpath="(//td[@class='w-25 pt-3 pb-3']/following-sibling::td/following-sibling::td)[1]")
	WebElement weeklyTopper;
	
	public LeaderboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyWeeklyTopper() {
		 weeklyTopper.click();
		
	}
	

}
