package testScripts;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class TestCase2 extends BaseClass {

	@Test(dataProvider = "getContactData")
	public void CreateContactTest(String contactName, String firstNameSalutation, String organizationName,String contactImage) 
	{
		l.Login(Username, Password);
		contact.clickOnContact();
		contact.createContact();
		contact.salutationDropdown(firstNameSalutation);
		contact.lastName(contactName);
		contact.addOrganization(organizationName);
		contact.fileUpload(contactImage);
		contact.clickOnSave();
		contact.clickOnContact();
		String newContact = contact.newContact();
		assertEquals(newContact, contactName);
		l.SignOut();
	}
}