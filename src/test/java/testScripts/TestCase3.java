package testScripts;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class TestCase3 extends BaseClass {

	@Test
	public void CreateAndDuplicateLead() {

		Map<String, String> m2 = excel.getDataBasedOnKey("TestData", "Create Lead");
		String lastName = m2.get("Last Name") + jav.generateRandomNumber(100);
		String newLastName = m2.get("Last Name") + jav.generateRandomNumber(100);

		l.Login(Username, Password);
		lead.clickOnLeads();
		lead.createLead();
		lead.salutationDropdown(m2.get("First Name Salutation"));
		lead.lastName(lastName);
		lead.companyName(m2.get("Company"));
		lead.clickOnSave();
		lead.clickOnDuplicate();
		lead.modifyLastName(newLastName);
		lead.clickOnSave();
		lead.clickOnLeads();
		String newLead = lead.newLead();
		assertEquals(newLead, newLastName);
		l.SignOut();
	}
}