package testScripts;
import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class TestCase2 extends BaseClass {

	@Test
	public void CreateContactTest() throws InterruptedException {
		Map<String, String> m1 = excel.getDataBasedOnKey("TestData", "Create Contact");
		String contactName = m1.get("Last Name") + jav.generateRandomNumber(100);

		l.Login(Username, Password);
		contact.clickOnContact();
		contact.createContact();
		contact.salutationDropdown(m1.get("First Name Salutation"));
		contact.lastName(contactName);
		contact.addOrganization(m1.get("Organization Name"));
		contact.fileUpload(m1.get("Contact Image"));
		contact.clickOnSave();
		contact.clickOnContact();
		String newContact = contact.newContact();
		assertEquals(newContact, contactName);
		l.SignOut();
	}
}