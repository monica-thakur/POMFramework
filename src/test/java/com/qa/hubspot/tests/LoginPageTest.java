package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest extends BaseTest {

	// TestNG---> Unit testing framework
	// Launch browser, enter URL, test case steps, assertions(act vs exp), tear down


	@Test(priority = 1)
	public void verifySignUpLinkExistTest() {
		loginPage.isSignUpLinkExist();
		Assert.assertEquals(loginPage.isSignUpLinkExist(), true);

	}

	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.loginPageTitle);
	}

	@Test(priority = 3)
	public void verifyLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
