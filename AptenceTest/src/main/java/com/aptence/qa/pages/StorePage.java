package com.aptence.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aptence.qa.base.TestBase;

public class StorePage extends TestBase{
	
	@FindBy(xpath="//div[@class='p-4']//button[contains(text(),'Redeem')]")
	WebElement nasatripredeem;
	
	
	@FindBy(xpath="//input[@placeholder='Enter Name']")
	WebElement entername;
	
	@FindBy(xpath="//textarea[@placeholder='Your Address']")
	WebElement enteraddress;
	
	@FindBy(xpath="//input[@placeholder='Your City']")
	WebElement entercity;
	
	@FindBy(xpath="//input[@placeholder='State']")
	WebElement enterstate;
	
	@FindBy(xpath="//input[@placeholder='Enter Zip/Postal']")
	WebElement enterzipcode;
	
	@FindBy(xpath="//button[@class='shadow text-uppercase bg-brand-color text-white btn p-2 pl-4 pr-4 border-25']")
	WebElement clickOnSubmit;
	
	
	public StorePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyItemRedeem(String name1, String address1, String city1, String state1, String zipcode1) {
		nasatripredeem.click();
		entername.sendKeys(name1);
		enteraddress.sendKeys(address1);
		entercity.sendKeys(city1);
		enterstate.sendKeys(state1);
		enterzipcode.sendKeys(zipcode1);
		clickOnSubmit.click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h5[contains(text(),'You have sucessfully Placed request')]")));
		
	}

}
