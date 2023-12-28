package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest{

	@BeforeClass
	public void accSetUp() {
		
		accPage = loginPage.doLogin("kiran@test.com", "Selenium@12345");
		
	}
	
	@Test
	public void accountPageTitleTest() {
		String actualTitle = accPage.getAccountPageTitle();
		Assert.assertEquals(actualTitle, "My Account");	
	}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void isSearchLinkExistTest() {
		Assert.assertTrue(accPage.isSearchFieldExist());
	}
	
	@Test
	public void accPageHeadertest() {
		List <String> actualAccPageHeaderList = accPage.getAccountHeadres();
		System.out.println(actualAccPageHeaderList);
		
		Assert.assertEquals(actualAccPageHeaderList, AppConstants.ACCOUNTS_PAGE_HEADER_LIST);
	}
	
	@Test
	public void searchTest() {
		searchResultPage = accPage.doSearch("MacBook");
		productInfoPage = searchResultPage.selectProduct("MacBook Pro");
		String actualProductHeader = productInfoPage.getProductHeaderName();
		Assert.assertEquals(actualProductHeader, "MacBook Pro");
	}
}
