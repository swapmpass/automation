package com.automation.ui.commonui;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIElement {
	
	private JavascriptExecutor js						  = null;
	private static WebElement  lastElem					  = null;
	private static String	   lastBorder				  = null;
	
	private static String	   SCRIPT_GET_ELEMENT_BORDER  = null;
	private static String	   SCRIPT_UNHIGHLIGHT_ELEMENT = null;
	
	static {
		
		try {
			
			File f = new File(".");
			
			System.out.println(f.getCanonicalPath());
			
			SCRIPT_GET_ELEMENT_BORDER = FileUtils.readFileToString(new File("./src/main/resource/element_highlight.js"),
																   "UTF-8");
			
			SCRIPT_UNHIGHLIGHT_ELEMENT = FileUtils.readFileToString(new File("./src/main/resource/element_unhighlight.js"),
																	"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public enum SearchBy {
						  
						  XPATH, CLASS, CSS, ID, LINK_TEXT, PARTIAL_LINK_TEXT, NAME, TAG_NAME;
	
	}
	
	public synchronized WebElement getWebElement(String elementIdentifier, WebDriver webDriver, SearchBy elementType) {
		
		WebElement webElement = null;
		
		js = (JavascriptExecutor) webDriver;
		
		switch (elementType) {
			
			case XPATH:
				
				webElement = webDriver.findElement(By.xpath(elementIdentifier));
				break;
			
			case CLASS:
				webElement = webDriver.findElement(By.className(elementIdentifier));
				break;
			
			case CSS:
				webElement = webDriver.findElement(By.cssSelector(elementIdentifier));
				break;
			
			case ID:
				webElement = webDriver.findElement(By.id(elementIdentifier));
				break;
			
			case LINK_TEXT:
				webElement = webDriver.findElement(By.linkText(elementIdentifier));
				break;
			
			case PARTIAL_LINK_TEXT:
				webElement = webDriver.findElement(By.partialLinkText(elementIdentifier));
				break;
			
			case NAME:
				webElement = webDriver.findElement(By.name(elementIdentifier));
				break;
			
			case TAG_NAME:
				webElement = webDriver.findElement(By.tagName(elementIdentifier));
				break;
			
			default:
				System.out.println("Un-Expected Element : " + elementType);
				
		}
		
		if (webElement != null) {
			highlightElement(webElement);
		}
		
		return webElement;
	}
	
	private void highlightElement(WebElement elem) {
		
		unhighlightLast();
		
		// remember the new element
		lastElem = elem;
		lastBorder = (String) (js.executeScript(SCRIPT_GET_ELEMENT_BORDER, elem));
	}
	
	private void unhighlightLast() {
		
		if (lastElem != null) {
			try {
				// if there already is a highlighted element, unhighlight it
				js.executeScript(SCRIPT_UNHIGHLIGHT_ELEMENT, lastElem, lastBorder);
			} catch (StaleElementReferenceException ignored) {
				// the page got reloaded, the element isn't there
			} finally {
				// element either restored or wasn't valid, nullify in both
				// cases
				lastElem = null;
			}
		}
	}
	
}
