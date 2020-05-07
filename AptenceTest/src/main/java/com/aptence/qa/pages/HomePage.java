package com.aptence.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aptence.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath="//h4[contains(text(),'Tony')]")
	WebElement name;
	
	@FindBy(xpath="//a[@href='/dashboard/support']")
	WebElement contactUs;
	
	@FindBy(xpath="(//a[@href='/dashboard/profile'])[1]")
	WebElement profile;
	
	@FindBy(xpath="//h4[contains(text(),'Logical Reasoning Challenge')]")
	WebElement homePageOpened;
	
	@FindBy(xpath="//a[@href='/dashboard/store']")
	WebElement store;
	
	@FindBy(xpath="//a[@href='/dashboard/leaderboard']")
	WebElement leaderboard;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactUsPage clickOnContactUsPageLink() {
		contactUs.click();
		return new ContactUsPage();
	}
	
	public ProfilePage clickOnProfilePageLink() {
		profile.click();
		return new ProfilePage();
	}
	public String verifyProfileName() {
		return name.getText();
	}
	
	public boolean verifyHomePageOpened() {
		return homePageOpened.isDisplayed();	
		}
	
	public StorePage clickOnStorePageLink() {
		store.click();
		return new StorePage();
	}
	
	public LeaderboardPage clickOnleaderboardPage() {
		leaderboard.click();
		return new LeaderboardPage();
	}
}
