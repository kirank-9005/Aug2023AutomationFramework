package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//By locators
	private By userName = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By logo = By.cssSelector("img[title='naveenopencart']");
	
	
	//page constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Page title is :" +title); 
		return title;
	}
	public String getLoginPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Page url is :" +url); 
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public boolean isLogoExist() {
		return driver.findElement(logo).isDisplayed();
	}
	
	public boolean doLogin(String username, String pwd) {
		driver.findElement(userName).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		System.out.println("user is logged in");
		
		return true;
	}
}
