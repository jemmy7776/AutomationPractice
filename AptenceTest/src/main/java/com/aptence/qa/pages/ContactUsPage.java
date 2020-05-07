package com.aptence.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aptence.qa.base.TestBase;

public class ContactUsPage extends TestBase{
	
	WebDriverWait wait;
	
	@FindBy(xpath="//h2[contains(text(),'Contact Us')]")
	WebElement ContactUsHeading;
	
	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactUsPageHeading() {
		return ContactUsHeading.isDisplayed();
	}
	
	public void enterMessage(String message) {
		driver.findElement(By.xpath("//textarea[@placeholder='Your Message']")).sendKeys(message);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Your Message Recieved']")));
		
	}

}
