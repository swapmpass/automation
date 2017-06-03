package com.automation.designPatterns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTest {
	
	private static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sverma3616\\Downloads\\browser_drivers\\chromedriver.exe");

		driver = new ChromeDriver();		
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://www.ebay.in/sch/ebayadvsearch");
		
		WebElement fss = driver.findElement(By.id("_fss"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fss);
		
		fss.click();
		
		System.out.println("Is check box checked : " + fss.isSelected());
		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
	}
	

}
