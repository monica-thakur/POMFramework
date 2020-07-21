package com.qa.hubspot.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {

	ElementUtil elementUtil;

	By header = By.xpath("//i18n-string[contains(text(),'Contacts')]");

	// By header =
	// By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/section/header/div[1]/div/div/div/h1/i18n-string");

	By createContactButton = By.xpath("//span[text()='Create contact']");
	By email = By.name("textInput");
	By firstName = By.xpath("(//input[@type='text'])[position()=3]");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By createContactSecondarybutton = By.xpath("(//span[text()='Create contact'])[position()=2]");

	By contactsCheckBoxes = By.cssSelector(".private-checkbox__icon.private-checkbox__dash");
	By deleteButton = By.xpath("//span[text()='Delete']");
	By deleteTextArea = By.xpath("//textarea[@data-selenium-test='delete-dialog-match']");
	By deleteButtonSecondary = By.xpath("(//span[text()=\"Delete\"])[position()=2]");
	By contactsBackLink = By.xpath("(//*[text()='Contacts'])[position()=1]");

	By myTable = By.xpath("//table//tr");
	By deleteContactNumber = By.xpath("//textarea[@id='UIFormControl-56']");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getContactsPageTitle() {
		return elementUtil.doGetPageTitleWithTitleIs(10, "Contacts");
	}

	public String getContactsPageHeader() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;

	}

	public void createContact(String emailID, String firstName, String lastName) {
		elementUtil.clickWhenReady(15, createContactButton);

		elementUtil.waitForElementToBeVisible(email, 10);
		elementUtil.doSendKeys(email, emailID);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.waitForElementPresent(createContactSecondarybutton, 10);
		elementUtil.doActionsClick(createContactSecondarybutton);
		// elementUtil.clickWhenReady(10, createContactSecondarybutton);
		// elementUtil.doClick(createContactSecondarybutton);

		// elementUtil.clickWhenReady(10, contactsBackLink);

	}

	public void deleteCreatedContacts() {

		List<WebElement> checBoxList = driver.findElements(contactsCheckBoxes);
		System.out.println("total contacts : " + (checBoxList.size() - 1));
		int totalContacts = checBoxList.size() - 1; // -1 coz there is top check boc for all select..so excluding

		if (totalContacts > 0) {

			for (int i = 1; i < checBoxList.size(); i++) {
				checBoxList.get(i).click(); // we need to ignore 1st chckbox
			}

			elementUtil.waitForElementPresent(deleteButton, 5).click();
			elementUtil.doActionsSendKeys(deleteTextArea, Integer.toString(totalContacts));// so this is int..need to
																							// convert it to string
			elementUtil.waitForElementPresent(deleteButtonSecondary, 4);
			elementUtil.doActionsClick(deleteButtonSecondary);
		} else {
			System.out.println("no contacts found...");
		}

	}

}
