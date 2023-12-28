package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logoutLink = By.linkText("Logout");
	private By search = By.name("search");
	private By accHeaders = By.cssSelector("div#content > h2");
	private By searchIcon = By.cssSelector("div#search button");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForVisibilityOfElement(logoutLink, 5).isDisplayed();
	}
	
	public void logout() {
		if(isLogoutLinkExist()) {
			eleUtil.doClick(logoutLink);
		}
		
	}
	
	public boolean isSearchFieldExist() {
		return eleUtil.waitForVisibilityOfElement(search, 5).isDisplayed();
	}
	
	public List<String> getAccountHeadres() {
		List<WebElement> headersList = eleUtil.waitForVisibilityOfElements(accHeaders, 5);
		List<String> headersValList = new ArrayList<String>();
		for(WebElement e: headersList) {
			String text = e.getText();
			headersValList.add(text);
		}
		
		return headersValList;
	}

	public String getAccountPageTitle() {
		String title = eleUtil.waitForTitleIs("My Account", 5);
		System.out.println("Page title is :" + title);
		return title;
	}
	
	public SearchResultsPage doSearch(String searchKey) {
		eleUtil.waitForVisibilityOfElement(search, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(searchKey);
		eleUtil.doClick(searchIcon);
		
		return new SearchResultsPage(driver);
	}

}
