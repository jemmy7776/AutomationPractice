package com.aptence.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aptence.qa.base.TestBase;

public class LeaderboardPage extends TestBase{
	
	@FindBy(xpath="(//td[@class='w-25 pt-3 pb-3']/following-sibling::td/following-sibling::td)[1]")
	WebElement weeklyTopper;
	
	@FindBy(xpath="(//tbody//tr//td[@class='w-25 pt-2 pb-2'])[1]")
	WebElement userRank;
	
	public LeaderboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyWeeklyTopper() {
		System.out.println("Weekly Topper is "+weeklyTopper.getText());
	}
	
	public void verifyUsersRank() {
		System.out.println("Users own Rank is "+userRank.getText());
	}
	

}
