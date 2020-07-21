package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

	ElementUtil elementUtil;

	By header = By.xpath("//h1[@class='private-header__heading private-header__heading--solo']");
	By accountName = By.xpath("//div[@class='user-info-name']");
	By avatar = By.xpath("//img[@class=' nav-avatar ']");
	By contactsPrimary = By.id("nav-primary-contacts-branch");
	By contactsSecondary = By.id("nav-secondary-contacts");
	
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getHomePageTitle() {
		return elementUtil.doGetPageTitleWithTitleIs(10, "Dashboard Library");
		// river.getTitle();
	}

	public String getHomePageHeader() {
		if (elementUtil.doIsDisplayed(header))
			return elementUtil.doGetText(header);
		return null;

	}

	public String getLoggedInAccountName() {
		elementUtil.doClick(avatar);
		//driver.findElement(avatar).click();
		if(elementUtil.doIsDisplayed(accountName))
		//if (driver.findElement(accountName).isDisplayed())
			return elementUtil.doGetText(accountName);
		return null;
	}
	
	public void clickContacts() {
		
		elementUtil.clickWhenReady(5, contactsPrimary);
		elementUtil.clickWhenReady(5, contactsSecondary);
		
	}

	public ContactsPage goToContactsPage() {
		clickContacts();
		return new ContactsPage(driver);
	}
}
