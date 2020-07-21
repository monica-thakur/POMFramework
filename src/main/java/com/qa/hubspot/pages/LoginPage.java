package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage {

	private WebDriver driver;

	ElementUtil elementUtil;

	// By locators
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");

	// constructor of page
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// page actions
	public String getLoginPageTitle() {
		// return driver.getTitle();
		return elementUtil.doGetPageTitleWithTitleIs(10, "HubSpot Login");
	}

	public boolean isSignUpLinkExist() {
		return elementUtil.isElementDisplayed(signUpLink, 10);
		// return driver.findElement(signUpLink).isDisplayed();
	}

	public HomePage doLogin(String un, String pwd) {
//		driver.findElement(username).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginButton).click();

		System.out.println("Login credentials-->" + un + ":" + pwd);
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new HomePage(driver);

	}
}
