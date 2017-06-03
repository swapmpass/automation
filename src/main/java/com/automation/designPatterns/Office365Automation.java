package com.automation.designPatterns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Office365Automation {

	private static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("");

		WebElement emailTB = driver.findElement(By.id("cred_userid_inputtext"));

		emailTB.sendKeys("");

		WebElement signInButtonForEmail = driver.findElement(By.id("cred_sign_in_button"));

		signInButtonForEmail.click();

		driver = driver.switchTo().defaultContent();

		final WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement passwordTB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordInput")));

		passwordTB.sendKeys("");

		WebElement signinButton = driver.findElement(By.id("submitButton"));

		signinButton.click();

		WebElement community = driver.findElement(By.id("flyimage2img"));
		community.click();

		WebElement outlook = driver.findElement(By.xpath("//img[@src=contains('Mail.png')]"));
		outlook.click();
	}

}
