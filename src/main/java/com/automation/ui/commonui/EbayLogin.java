package com.automation.ui.commonui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.ui.commonui.UIElement.SearchBy;

public class EbayLogin {
	
	WebDriver driver = null;
	
	public EbayLogin(WebDriver driver) {
		
		this.driver = driver;
	}

	public void loginEbay() {

		String usernameTextBox = "//div[@id='pri_signin']//span//input[@placeholder='Email or username']";
		String passwordTextBox = "//div[@id='pri_signin']//span//input[@placeholder='Password']";

		WebElement usernameTB = new UIElement().getWebElement(usernameTextBox, driver, SearchBy.XPATH);

		WebElement passwordTB = new UIElement().getWebElement(passwordTextBox, driver, SearchBy.XPATH);
		
		usernameTB.sendKeys("swapnilverma.vit@gmail.com");

	}

}
