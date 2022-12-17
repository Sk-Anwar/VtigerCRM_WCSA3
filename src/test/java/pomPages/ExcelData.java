package pomPages;

import java.util.Map;

import org.testng.annotations.DataProvider;

import genericLibraries.BaseClass;

public class ExcelData extends BaseClass {

	@DataProvider
	public Object[][] getOrganizationData() {
		Map<String, String> m = excel.getDataBasedOnKey("TestData", "Create Organization");
		String organizationName = m.get("Organization Name") + jav.generateRandomNumber(100);
		String industryName = m.get("Industry");
		return new Object[][] { { organizationName, industryName } };
	}

	@DataProvider
	public Object[][] getContactData() {
		Map<String, String> m1 = excel.getDataBasedOnKey("TestData", "Create Contact");
		String contactName = m1.get("Last Name") + jav.generateRandomNumber(100);
		String firstNameSalutation = m1.get("First Name Salutation");
		String organizationName = m1.get("Organization Name");
		String contactImage = m1.get("Contact Image");
		return new Object[][] { { contactName, firstNameSalutation, organizationName, contactImage } };
	}

	@DataProvider
	public Object[][] getLeadData() {
		Map<String, String> m2 = excel.getDataBasedOnKey("TestData", "Create Lead");
		String firstNameSalutation = m2.get("First Name Salutation");
		String compamyName = m2.get("Company");
		String lastName = m2.get("Last Name") + jav.generateRandomNumber(100);
		String newLastName = m2.get("Last Name") + jav.generateRandomNumber(100);
		return new Object[][] { { firstNameSalutation, compamyName, lastName, newLastName } };
	}
}
