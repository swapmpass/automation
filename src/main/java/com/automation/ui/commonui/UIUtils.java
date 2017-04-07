package com.automation.ui.commonui;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIUtils {
	
	

	protected void click(WebElement elementToBeClicked, WebDriver driver, UIElementIdentifier... expectedIdentifier) {
		
		// http://toolsqa.com/selenium-webdriver/implicit-explicit-n-fluent-wait/
		
		elementToBeClicked.click();

		if (expectedIdentifier.length > 0) {
			fluentWait(driver, expectedIdentifier[0]);	
		}

	}

	protected void type(WebElement elementToBeClicked) {

	}

	public WebElement getWhenVisible(By locator, int timeout, WebDriver driver) {
		
		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return element;

	}

	public void clickWhenReady(By locator, int timeout, WebDriver driver) {
		
		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		element.click();

	}

	public void fluentWait(WebDriver driver, UIElementIdentifier element) {
		
		// Waiting 30 seconds for an element to be present on the page, checking

		// for its presence once every 5 seconds.

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(10, TimeUnit.SECONDS)

				.pollingEvery(2, TimeUnit.SECONDS)

				.ignoring(NoSuchElementException.class);
		
		  wait.until(new Function<Object, Object>() {

			@Override
			public Object apply(Object arg0) {
				
				return new UIElement().getWebElement(element.getElementString(), driver, element.getElementIndenType());
			}

		});
	}
	
	public void implicitWait() {
		
		 WebDriver driver = new FirefoxDriver();

		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		 driver.get("http://url_that_delays_loading");

		 WebElement myDynamicElement = driver.findElement(By.id("myDynamicElement"));
	}
	
	public void expilcitWait(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
	}
	
	protected void sleep(int seconds) {
		
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
