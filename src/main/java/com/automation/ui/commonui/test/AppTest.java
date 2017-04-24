package com.automation.ui.commonui.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.ui.commonui.EbayLogin;
import com.automation.ui.commonui.MasterPassLogin;
import com.automation.ui.commonui.UIElement;
import com.automation.ui.commonui.UIElementIdentifier;
import com.automation.ui.commonui.UIUtils;
import com.automation.ui.commonui.UIElement.SearchBy;

/**
 * Unit test for simple App.
 */
public class AppTest extends UIUtils {

	private WebDriver driver;
	
	UIElement ele = new UIElement();

	@Test
	public void testMasterPass() {
		
		driver.get("http://www.ebay.in/");
		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Electronics, Cars, Fashion, Collectibles, Coupons and More"));
		
		WebElement searchTextBox = ele.getWebElement("gh-ac", driver, SearchBy.ID);
		searchTextBox.sendKeys("Moto G4 Plus");
		
		WebElement searchButton = ele.getWebElement("gh-btn", driver, SearchBy.ID);
		
		click(searchButton, driver, new UIElementIdentifier("//div[@id='LeftNavCategoryContainer']//div/h3", SearchBy.XPATH));
		
		WebElement firstResultLink = ele.getWebElement("//ul[@id='ListViewInner']/li[1]/h3/a", driver, SearchBy.XPATH);
		
		List<WebElement> list = firstResultLink.findElements(By.xpath("//ul[@id='ListViewInner']//li//h3//*"));
		
		for (WebElement item : list) {
			
			String firstResultLinkText = item.getText();
			
			click(item, driver, new UIElementIdentifier("itemTitle", SearchBy.ID));
			
			WebElement firstResultHeading = new UIElement().getWebElement("itemTitle", driver, SearchBy.ID);
			
			String headingText = firstResultHeading.getText();
			
			Assert.assertTrue(headingText.trim().contains(firstResultLinkText));
			
			break;
		}
		
		WebElement buyItNowBtn = new UIElement().getWebElement("binBtn_btn", driver, SearchBy.ID);
		
		UIElementIdentifier loginBox = new UIElementIdentifier("pri_signin", SearchBy.ID);
		click(buyItNowBtn, driver, loginBox);
		
		EbayLogin login = new EbayLogin(driver);
		login.loginEbay();
		
		WebElement proceedToPayButton = new UIElement().getWebElement("proceedtopay", driver, SearchBy.ID);
		
		UIElementIdentifier masterpassRadioBtn = new UIElementIdentifier("//img[@alt='MasterPass']//parent::span//parent::li", SearchBy.XPATH);
		
		click(proceedToPayButton, driver, masterpassRadioBtn);
		
		WebElement payNowBtn = new UIElement().getWebElement("//button[@class='btn btn-prim' and text()='Pay now']", driver, SearchBy.XPATH);
		
		UIElementIdentifier citibankLogo = new UIElementIdentifier("//button[@class='logo-button command' and @data-aliases='Citibank,Citi India,Citi Bank']", SearchBy.XPATH);
		
		click(payNowBtn, driver, citibankLogo);
		
		WebElement citibankLogoIcon = new UIElement().getWebElement("//button[@class='logo-button command' and @data-aliases='Citibank,Citi India,Citi Bank']", driver, SearchBy.XPATH);
		
		click(citibankLogoIcon, driver);
		
		sleep(7);
		
		driver = driver.switchTo().frame("MasterPass_wallet_frame");
		
		WebElement masterPassEmailTab = new UIElement().getWebElement("//div[@class='field halfwidth  active ' and @id='email-toggle']//input[@id='email']", driver, SearchBy.XPATH);
		
		Assert.assertTrue(masterPassEmailTab.isDisplayed());
		
		MasterPassLogin masterpassLogin = new MasterPassLogin(driver);
		masterpassLogin.loginMasterPass();
		
		WebElement finishShoppingBtn = new UIElement().getWebElement("//button[@class='button command']", driver, SearchBy.XPATH);
		
		UIElementIdentifier otpFrame = new UIElementIdentifier("//iframe[@id='CentinelGeneratedFrame']", SearchBy.XPATH);
		
		click(finishShoppingBtn, driver, otpFrame);
		
		sleep(15);
		
		driver = driver.switchTo().frame("CentinelGeneratedFrame");
<<<<<<< HEAD
		
		//WebElement optLink = new UIElement().getWebElement("//a[@title='OTP (One Time Password)']", driver, SearchBy.XPATH);
		
		//click(optLink, driver);
		
		//WebElement otpInput = new UIElement().getWebElement("//input[@id='otp']", driver, SearchBy.XPATH);
		
		//otpInput.sendKeys("1234567890");
		
		WebElement passwordBox = new UIElement().getWebElement("ipincode", driver, SearchBy.ID);
		
		passwordBox.sendKeys("123456789");
		
=======
		
		//WebElement optLink = new UIElement().getWebElement("//a[@title='OTP (One Time Password)']", driver, SearchBy.XPATH);
		
		//click(optLink, driver);
		
		//WebElement otpInput = new UIElement().getWebElement("//input[@id='otp']", driver, SearchBy.XPATH);
		
		//otpInput.sendKeys("1234567890");
		
		WebElement passwordBox = new UIElement().getWebElement("ipincode", driver, SearchBy.ID);
		
		passwordBox.sendKeys("123456789");
		
>>>>>>> 9b43c1e5e74f387b2f9fd8230eb2c778fe801a1a
		WebElement nextButton = new UIElement().getWebElement("next", driver, SearchBy.ID);
	}
	
	@Before
	public void beforeTest() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sverma3616\\Downloads\\browser_drivers\\geckodriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sverma3616\\Downloads\\browser_drivers\\chromedriver.exe");
		
		//Following link for gecko driver executable download:
		//https://github.com/mozilla/geckodriver/releases
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
	}

	@After
	public void afterTest() {
		driver.quit();
	}
}
