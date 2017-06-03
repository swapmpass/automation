package com.automation.designPatterns;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxExample {
	
	private final static String	URL	= "http://demos.telerik.com/aspnet-ajax/ajax/examples/loadingpanel/explicitshowhide/defaultcs.aspx";
	
	static WebDriver			driver;
	WebDriverWait				wait;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver",
						   "C:\\Users\\sverma3616\\Downloads\\browser_drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}
	
	@Test
	public void test_AjaxExample() {
		
		/* Wait for grid to appear */
		final By container = By.cssSelector(".demo-container");
		this.wait = new WebDriverWait(this.driver, 5);
		this.wait.until(ExpectedConditions.presenceOfElementLocated(container));
		
		/* Get the text before performing an ajax call */
		final WebElement noDatesTextElement = this.driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
		final String textBeforeAjaxCall = noDatesTextElement.getText().trim();
		
		/* Click on the date */
		this.driver.findElement(By.linkText("1")).click();
		
		/* Wait for loader to disappear */
		final By loader = By.className("raDiv");
		this.wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		
		/* Get the text after ajax call */
		final WebElement selectedDatesTextElement = this.driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
		this.wait.until(ExpectedConditions.visibilityOf(selectedDatesTextElement));
		final String textAfterAjaxCall = selectedDatesTextElement.getText().trim();
		
		/* Verify both texts before ajax call and after ajax call text. */
		Assert.assertNotEquals(textBeforeAjaxCall, textAfterAjaxCall);
		
		final String expectedTextAfterAjaxCall = "Saturday, April 01, 2017";
		
		/* Verify expected text with text updated after ajax call */
		Assert.assertEquals(textAfterAjaxCall, expectedTextAfterAjaxCall);
	}
	
	/*
	 * @AfterClass public void afterClass() { driver.close(); driver.quit(); }
	 */
	
}
