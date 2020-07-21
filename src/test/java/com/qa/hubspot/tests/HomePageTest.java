package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest {

	HomePage homePage;

	
	@BeforeClass
	public void HomePageSetUp() {
//		homePage = new HomePage(driver);--> no need to create another object for homepage as login return home page reference
		homePage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Title is" + title);
		Assert.assertEquals(title, Constants.HomePageTitle);

	}

	@Test(priority = 2)
	public void verifyHomePageHeaderTest() {
		String header = homePage.getHomePageHeader();
		Assert.assertEquals(header, Constants.HomePageHeader);
	}

	@Test(priority = 3)
	public void verifyLoggedInAccountName() {
		String accountName = homePage.getLoggedInAccountName();
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
		int i =9/0;
	}

	

}
