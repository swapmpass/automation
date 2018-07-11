package com.automation.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.ui.commonui.UIElement.SearchBy;
import com.automation.ui.commonui.UIElementIdentifier;
import com.automation.ui.commonui.UIUtils;

public class SearchPage extends UIUtils implements AutoCloseable {

	WebDriver driver;

	public SearchPage(final WebDriver driver) {

		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "gh-ac")
	private WebElement	 TXTBOX_Search;
	
	@FindBy(how = How.ID, using = "gh-btn")
	private WebElement	 BTN_Search;
	
	private final String IDEN_AfterSearch = "//div[@id='LeftNavCategoryContainer']//div/h3";

	public void search(final String stringToSearch) {
		
		try (SearchPage d = new SearchPage(new FirefoxDriver());) {
			System.out.println("");
		} catch (Exception e) {
		}
		
		this.TXTBOX_Search.sendKeys(stringToSearch);
		
		click(this.BTN_Search, this.driver, new UIElementIdentifier(this.IDEN_AfterSearch, SearchBy.XPATH));
	}

	@Override
	public void close() throws Exception {
		
	}

}
