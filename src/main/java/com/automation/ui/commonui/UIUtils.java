package com.automation.ui.commonui;

import java.util.concurrent.TimeUnit;

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

	protected void click(final WebElement elementToBeClicked, final WebDriver driver,
			final UIElementIdentifier... expectedIdentifier) {

		// http://toolsqa.com/selenium-webdriver/implicit-explicit-n-fluent-wait/

		elementToBeClicked.click();

		if (expectedIdentifier.length > 0) {
			fluentWait(driver, expectedIdentifier[0]);
		}

		System.out.println("Current URL is : " + driver.getCurrentUrl());

	}

	protected void type(final WebElement elementToBeClicked) {

	}

	public WebElement getWhenVisible(final By locator, final int timeout, final WebDriver driver) {

		WebElement element = null;

		final WebDriverWait wait = new WebDriverWait(driver, timeout);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return element;

	}

	public void clickWhenReady(final By locator, final int timeout, final WebDriver driver) {

		WebElement element = null;

		final WebDriverWait wait = new WebDriverWait(driver, timeout);

		element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		element.click();

	}

	public void fluentWait(final WebDriver driver, final WebElement element) {

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.

		Wait<WebDriver> wait = null;

		try {

			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			wait.until(arg0 -> element);

		} catch (final Exception e) {

			System.out.println("Element not found : " + element.getTagName());

			System.out.println("Quit called...");

			driver.quit();

			System.exit(1);
		}
	}

	public void fluentWait(final WebDriver driver, final UIElementIdentifier element) {

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.

		Wait<WebDriver> wait = null;

		try {

			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);

			wait.until(arg0 -> new UIElement().getWebElement(element.getElementString(), driver,
					element.getElementIndenType()));

		} catch (final Exception e) {

			System.out.println("Element not found : " + element.getElementString());

			System.out.println("Quit called...");

			driver.quit();

			System.exit(1);
		}
	}

	public void implicitWait() {

		final WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("http://url_that_delays_loading");

		final WebElement myDynamicElement = driver.findElement(By.id("myDynamicElement"));
	}

	public void expilcitWait(final WebDriver driver) {

		final WebDriverWait wait = new WebDriverWait(driver, 10);

		final WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
	}

	protected void sleep(final int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

	}

}
