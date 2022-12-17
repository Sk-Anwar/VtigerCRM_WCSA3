package testScripts;
import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;
import genericLibraries.BaseClass;

public class TestCase1 extends BaseClass {

	@Test
	public void CreateOrganization() {
		Map<String, String> m = excel.getDataBasedOnKey("TestData", "Create Organization");
		String organizationName = m.get("Organization Name") + jav.generateRandomNumber(100);

		l.Login(Username, Password);
		org.clickOnOrganizations();
		org.CreateOrganization();
		org.OrganizationName(organizationName);
		org.industryDropdown(m.get("Industry"));
		org.clickOnSave();
		org.clickOnOrganizations();
		String newOrganization = org.NewOrganization();
		assertEquals(newOrganization, organizationName);
		l.SignOut();
	}
}