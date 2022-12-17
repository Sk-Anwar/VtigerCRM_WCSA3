package testScripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class TestCase3 extends BaseClass {

	@Test(dataProvider = "getLeadData")
	public void CreateAndDuplicateLead(String firstNameSalutation, String compamyName, String lastName,String newLastName) {

		l.Login(Username, Password);
		lead.clickOnLeads();
		lead.createLead();
		lead.salutationDropdown(firstNameSalutation);
		lead.lastName(lastName);
		lead.companyName(compamyName);
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