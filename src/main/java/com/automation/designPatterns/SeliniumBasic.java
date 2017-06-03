package com.automation.designPatterns;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOError;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeliniumBasic {

	final static WebDriver driver = new FirefoxDriver();

	public static void main(final String[] args) throws IOError {
		
		String fdddd= "";
		

		SeliniumBasic sb = new SeliniumBasic();
		// sb.

		final String winHandleBefore = driver.getWindowHandle();
		for (final String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		HashSet<String> d = new HashSet<>();
		d.add("ft");
		d.add("ft");

		Hashtable<String, String> ht = new Hashtable<>();
		ht.put("", "");

		StringBuffer f = new StringBuffer();
		f.append("");

		TreeSet<String> dss = new TreeSet<>();

		StringBuilder ddd = new StringBuilder();
		ddd.append("");

		// Once action is performed, switch back to parent window.
		driver.switchTo().window(driver.getWindowHandle());

		// Select an item in Listbox using Selenium Webdriver
		final WebElement select = driver.findElement(By.id("selection"));
		final List<WebElement> options = select.findElements(By.tagName("option"));
		for (final WebElement option : options) {
			if ("Germany".equals(option.getText())) {
				option.click();
			}
		}
		// or
		final WebElement roleDropdown = driver.findElement(By.id(""));
		roleDropdown.click();

		// RIGHT CLICK
		final WebElement webelement = driver.findElement(By.xpath("*Xpath Locator*"));
		final Actions actions = new Actions(driver);
		final Action action = actions.contextClick(webelement).build();
		action.perform();

		// Double Click
		final Actions action1 = new Actions(driver);
		action1.doubleClick(webelement);
		action1.perform();

		// EXCEL READER
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(new FileInputStream(new File("")));
			final Sheet sheet = workbook.getSheetAt(0);
		} catch (final Exception e) {
			e.printStackTrace();
		}

		// To connect to Database using WebDriver with Java, we use JDBC(“Java
		// Database Connectivity) API.
		try {
			DriverManager.getConnection("", "username", "password");
		} catch (final SQLException e) {
		}

		// Implicit Waits
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// EXPLICIT WAITS
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		final WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));

		// Alert Box
		final Alert alert = driver.switchTo().alert();
		alert.accept();
		// or
		alert.dismiss();

		// NAVIGATION
		driver.navigate().to("http://www.google.com");
		driver.get("http://www.google.com");
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
		driver.manage().deleteAllCookies();
		driver.close();

		// scrollingToBottomofAPage
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// scrollingToElementofAPage
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("")));

		// scrollingByCoordinatesofAPage
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

		// TABLE COLUMNS
		final WebElement Table = driver.findElement(By.id(""));
		final List<WebElement> Row = Table.findElements(By.tagName("tr"));

		// DRAG AND DROP
		final WebElement element1 = driver.findElement(By.name("source"));
		final WebElement target = driver.findElement(By.name("target"));
		(new Actions(driver)).dragAndDrop(element1, target).perform();

		// MOUSE OVER
		final Actions actions1 = new Actions(driver);
		final WebElement mouseover = driver.findElement(By.id(""));
		actions1.moveToElement(mouseover);
		actions1.click().perform();

		// ISELEMENT/TEXTPRESENT
		if (driver.findElements(By.id("")).size() > 0) {
			// return true;
		} else {
			// return false;
		}
		// OR
		driver.getPageSource().contains("Sign out");
		// OR
		isElementPresent(driver, By.id(""));

		// Select multiple values in multi-select/list box
		String multipleVals = "something, something";

		String multipleSel[] = multipleVals.split(",");

		for (String valueToBeSelected : multipleSel) {

			new Select(driver.findElement(By.id(""))).selectByVisibleText(valueToBeSelected);

			driver.findElement(By.id("")).sendKeys(Keys.CONTROL);
		}
	}

	private final static boolean isElementPresent(final WebDriver driver, final By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (final NoSuchElementException e) {
			return false;
		}
	}

	public static void multiSelect() {

		WebElement element = driver.findElement(By.name("Mobdevices"));

		Select se = new Select(element);
		se.selectByVisibleText("Nokia");
		se.selectByVisibleText("HTC");

		// To get all the options that are selected in the dropdown.
		List<WebElement> allSelectedOptions = se.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			System.out.println("You have selected ::" + webElement.getText());
		}
	}

}
