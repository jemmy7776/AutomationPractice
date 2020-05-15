package com.aptence.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aptence.qa.util.TestUtil;
import com.aptence.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Jashandeep\\Documents\\GIT\\AutomationPractice\\AptenceTest"
					+ "\\src\\main\\java\\com\\aptence\\qa\\config\\config.properties");
			prop.load(fis);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jashandeep\\eclipse-workspace\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else {
			System.out.println("Chrome Browser not working");
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		wait = new WebDriverWait(driver,15);
	
	}

}
