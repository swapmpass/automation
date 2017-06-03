package com.automation.designPatterns;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverAndClick {

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sverma3616\\Downloads\\browser_drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://cssdropdownmenu.github.io/dropdownlist-and-listbox-overlapping-the-submenu-css.html");

		WebElement cssMenu = driver.findElement(By.id("css3menu"));

		List<WebElement> allLinks = cssMenu.findElements(By.tagName("a"));
		
		hover(allLinks, "SAMPLES");

		Thread.sleep(3000);
		
		hover(allLinks, "Neon Template");
		
		Thread.sleep(3000);

		driver.close();
		driver.quit();
		
	}
	
	private static void hover(List<WebElement> allLinks, String hoverOverText) {
		
		WebElement LI_SAMPLE = null;

		for (WebElement singleLink : allLinks) {

			if (singleLink.getAttribute("title").trim().equals(hoverOverText)) {
				LI_SAMPLE = singleLink;
				break;
			}
		}

		final Actions actions = new Actions(driver);
		actions.moveToElement(LI_SAMPLE);
		actions.click().perform();
		
	}

}
