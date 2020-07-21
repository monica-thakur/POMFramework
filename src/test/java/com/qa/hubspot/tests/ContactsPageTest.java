package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class ContactsPageTest extends BaseTest{
	HomePage homePage;
	ContactsPage contactPage;
	
	@BeforeClass
	public void ContactsPageSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.goToContactsPage();
	}
	
	@Test
	public void verifyContactsPageTitle() {
		String title = contactPage.getContactsPageTitle();
		System.out.println("Contacts page title is:" + title);
		Assert.assertEquals(title, Constants.ContactPageTitle);
	}
	
	@Test(priority = 1)
	public void verifyContactsPageHeader() {
		String headerValue = contactPage.getContactsPageHeader();
		System.out.println("contacts page header is : " + headerValue);
		Assert.assertEquals(headerValue, Constants.CONTACTS_PAGE_HEADER);
	}
	
	@Test(priority=1)
	public void verifyCreateNewContact() {
		contactPage.createContact("test1234@gmail.com", "abc123", "xyz123");
	}
	

	@Test(priority=1)
	public void verifyDeleteContacts() {
		contactPage.deleteCreatedContacts();
	}
}
