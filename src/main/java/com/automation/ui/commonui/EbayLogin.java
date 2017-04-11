package com.automation.ui.commonui;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.ui.commonui.UIElement.SearchBy;

public class EbayLogin extends UIUtils {
	
	WebDriver driver = null;
	
	private String username = null;
	private String password = null;
	
	public EbayLogin(WebDriver driver) {
		
		this.driver = driver;
	}

	public void loginEbay() {

		String usernameTextBox = "//div[@id='pri_signin']//span//input[@placeholder='Email or username']";
		String passwordTextBox = "//div[@id='pri_signin']//span//input[@placeholder='Password']";

		WebElement usernameTB = new UIElement().getWebElement(usernameTextBox, driver, SearchBy.XPATH);

		WebElement passwordTB = new UIElement().getWebElement(passwordTextBox, driver, SearchBy.XPATH);
		
		WebElement signInBtn = new UIElement().getWebElement("sgnBt", driver, SearchBy.ID);
		
		UIElementIdentifier successfulSigninIden = new UIElementIdentifier("//li[@class='active']//p", SearchBy.XPATH);
		
		populateLoginCredentials();
		
		usernameTB.sendKeys(username);
		passwordTB.sendKeys(password);
		
		click(signInBtn, driver, successfulSigninIden);
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
