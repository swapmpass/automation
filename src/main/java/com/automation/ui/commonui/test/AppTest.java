package com.automation.ui.commonui.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.ui.commonui.EbayLogin;
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
			
			System.out.println("firstResultLinkText : " + firstResultLinkText);
			System.out.println("headingText : " + headingText);
			
			Assert.assertEquals(firstResultLinkText.trim(), headingText.trim());
			
			break;
		}
		
		WebElement buyItNowBtn = new UIElement().getWebElement("binBtn_btn", driver, SearchBy.ID);
		
		UIElementIdentifier loginBox = new UIElementIdentifier("pri_signin", SearchBy.ID);
		click(buyItNowBtn, driver, loginBox);
		
		EbayLogin login = new EbayLogin(driver);
		login.loginEbay();
	}
	
	@BeforeTest
	public void beforeTest() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sverma3616\\Downloads\\browser_drivers\\geckodriver.exe");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sverma3616\\Downloads\\browser_drivers\\chromedriver.exe");
		
		//Following link for gecko driver executable download:
		//https://github.com/mozilla/geckodriver/releases
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
