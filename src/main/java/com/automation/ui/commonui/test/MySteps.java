package com.automation.ui.commonui.test;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.ebay.SearchPage;
import com.automation.ui.commonui.EbayLogin;
import com.automation.ui.commonui.MasterPassLogin;
import com.automation.ui.commonui.UIElement;
import com.automation.ui.commonui.UIElement.SearchBy;
import com.automation.ui.commonui.UIElementIdentifier;
import com.automation.ui.commonui.UIUtils;

public class MySteps extends UIUtils {
	
	private WebDriver driver;
	
	UIElement		  ele = new UIElement();
	
	@Given("on ebay page")
	public void givenOnEbayPage() {
		
		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\sverma3616\\Downloads\\browser_drivers\\geckodriver.exe");
		
		System.setProperty("webdriver.chrome.driver",
						   "C:\\Users\\sverma3616\\Downloads\\browser_drivers\\chromedriver.exe");
		
		// driver = new FirefoxDriver();
		this.driver = new ChromeDriver();
		this.driver.get("http://www.ebay.in/");
		final String title = this.driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Electronics, Cars, Fashion, Collectibles, Coupons and More"));
	}
	
	@When("i search for product")
	public void whenISearchForProduct() {
		
		final SearchPage sp = new SearchPage(this.driver);
		
		sp.search("Moto G4 Plus");
		
	}
	
	@Then("purchase it")
	public void thenPurchaseIt() {
		
		try {
			final WebElement firstResultLink = this.ele.getWebElement("//ul[@id='ListViewInner']/li[1]/h3/a",
																	  this.driver, SearchBy.XPATH);
			
			final List<WebElement> list = firstResultLink.findElements(By.xpath("//ul[@id='ListViewInner']//li//h3//*"));
			
			for (final WebElement item : list) {
				
				final String firstResultLinkText = item.getText();
				
				click(item, this.driver, new UIElementIdentifier("itemTitle", SearchBy.ID));
				
				final WebElement firstResultHeading = new UIElement().getWebElement("itemTitle", this.driver,
																					SearchBy.ID);
				
				final String headingText = firstResultHeading.getText();
				
				Assert.assertTrue(headingText.trim().contains(firstResultLinkText));
				
				break;
			}
			
			final WebElement buyItNowBtn = new UIElement().getWebElement("binBtn_btn", this.driver, SearchBy.ID);
			
			final UIElementIdentifier loginBox = new UIElementIdentifier("pri_signin", SearchBy.ID);
			click(buyItNowBtn, this.driver, loginBox);
			
			final EbayLogin login = new EbayLogin(this.driver);
			login.loginEbay();
			
			final WebElement proceedToPayButton = new UIElement().getWebElement("proceedtopay", this.driver,
																				SearchBy.ID);
			
			final UIElementIdentifier masterpassRadioBtn = new UIElementIdentifier("//img[@alt='MasterPass']//parent::span//parent::li",
																				   SearchBy.XPATH);
			
			click(proceedToPayButton, this.driver, masterpassRadioBtn);
			
			final WebElement payNowBtn = new UIElement().getWebElement("//button[@class='btn btn-prim' and text()='Pay now']",
																	   this.driver, SearchBy.XPATH);
			
			final UIElementIdentifier citibankLogo = new UIElementIdentifier("//button[@class='logo-button command' and @data-aliases='Citibank,Citi India,Citi Bank']",
																			 SearchBy.XPATH);
			
			click(payNowBtn, this.driver, citibankLogo);
			
			final WebElement citibankLogoIcon = new UIElement().getWebElement("//button[@class='logo-button command' and @data-aliases='Citibank,Citi India,Citi Bank']",
																			  this.driver, SearchBy.XPATH);
			
			click(citibankLogoIcon, this.driver);
			
			sleep(7);
			
			this.driver = this.driver.switchTo().frame("MasterPass_wallet_frame");
			
			final WebElement masterPassEmailTab = new UIElement().getWebElement("//div[@class='field halfwidth  active ' and @id='email-toggle']//input[@id='email']",
																				this.driver, SearchBy.XPATH);
			
			Assert.assertTrue(masterPassEmailTab.isDisplayed());
			
			final MasterPassLogin masterpassLogin = new MasterPassLogin(this.driver);
			masterpassLogin.loginMasterPass();
			
			final WebElement finishShoppingBtn = new UIElement().getWebElement("//button[@class='button command']",
																			   this.driver, SearchBy.XPATH);
			
			click(finishShoppingBtn, this.driver);
			
			sleep(15);
			
			this.driver = this.driver.switchTo().defaultContent();
			
			this.driver = this.driver.switchTo().frame(0);
			
			final List<WebElement> ss = this.driver.findElements(By.tagName("iframe"));
			
			for (final WebElement webEl1 : ss) {
				System.out.println(webEl1.getTagName());
				System.out.println(webEl1.getAttribute("id"));
				this.driver = this.driver.switchTo().frame(webEl1.getAttribute("id"));
			}
			
			final WebElement passwordBox = new UIElement().getWebElement("ipincode", this.driver, SearchBy.ID);
			
			passwordBox.sendKeys("123456789");
			
			final WebElement nextButton = new UIElement().getWebElement("next", this.driver, SearchBy.ID);
			
			sleep(10);
		} catch (final Exception e) {
			this.driver.quit();
			Assert.fail(e.getLocalizedMessage());
		}
		
		this.driver.quit();
	}
}