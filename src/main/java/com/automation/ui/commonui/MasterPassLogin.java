package com.automation.ui.commonui;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.ui.commonui.UIElement.SearchBy;

public class MasterPassLogin extends UIUtils {
	
	WebDriver	   driver	= null;
	
	private String username	= null;
	private String password	= null;
	
	public MasterPassLogin(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void loginMasterPass() {
		
		WebElement loginMasterpassTB = new UIElement().getWebElement("//div[@class='field halfwidth  active ' and @id='email-toggle']//input[@id='email']",
																	 driver, SearchBy.XPATH);
		WebElement passwordMasterPassTB = new UIElement().getWebElement("//div[@class='field halfwidth password']//input[@id='password']",
																		driver, SearchBy.XPATH);
		WebElement signInMasterPassBtn = new UIElement().getWebElement("//div[@class='field halfwidth sign-in-buttons']//button[@id='signInButton']",
																	   driver, SearchBy.XPATH);
		
		UIElementIdentifier successfulSigninIden = new UIElementIdentifier("//button[@class='button command']",
																		   SearchBy.XPATH);
		
		populateLoginCredentials();
		
		loginMasterpassTB.sendKeys(username);
		passwordMasterPassTB.sendKeys(password);
		
		click(signInMasterPassBtn, driver, successfulSigninIden);
	}
	
	private void populateLoginCredentials() {
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File("./src/main/resource/ebay_login.properties")));
			username = prop.getProperty("username");
			password = prop.getProperty("password");
		} catch (Exception e) {
		}
	}
	
}
