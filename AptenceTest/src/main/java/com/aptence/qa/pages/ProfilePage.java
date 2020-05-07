package com.aptence.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aptence.qa.base.TestBase;

public class ProfilePage extends TestBase{
	
	@FindBy(xpath="//input[@id='editProfileImage']")
	WebElement editImage;
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyUploadImage() {
//		Actions action = new Actions(driver);
//		action.moveToElement(editImage).click();
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].setAttribute('class','')",editImage);
		//editImage.click();
		editImage.sendKeys("C:\\Users\\jasha\\Downloads\\mountfuji.jpg");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Profile Pic Updated Successfully')]")));
	}

}
