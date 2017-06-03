package com.automation.ui.commonui;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.ui.commonui.UIElement.SearchBy;

public class EbayLogin extends UIUtils {
	
	WebDriver	   driver	= null;
	
	private String username	= null;
	private String password	= null;
	
	public EbayLogin(final WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void loginEbay() {
		
		final String usernameTextBox = "//div[@id='pri_signin']//span//input[@placeholder='Email or username']";
		final String passwordTextBox = "//div[@id='pri_signin']//span//input[@placeholder='Password']";
		
		final WebElement usernameTB = new UIElement().getWebElement(usernameTextBox, this.driver, SearchBy.XPATH);
		
		final WebElement passwordTB = new UIElement().getWebElement(passwordTextBox, this.driver, SearchBy.XPATH);
		
		final WebElement signInBtn = new UIElement().getWebElement("sgnBt", this.driver, SearchBy.ID);
		
		final UIElementIdentifier successfulSigninIden = new UIElementIdentifier("//li[@class='active']//p",
																				 SearchBy.XPATH);
		
		populateLoginCredentials();
		
		usernameTB.sendKeys(this.username);
		passwordTB.sendKeys(this.password);
		
		click(signInBtn, this.driver, successfulSigninIden);
	}
	
	private void populateLoginCredentials() {
		
		final Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resource/ebay_login.properties")));
			this.username = prop.getProperty("username");
			this.password = prop.getProperty("password");
		} catch (final Exception e) {
		}
	}
	
}
