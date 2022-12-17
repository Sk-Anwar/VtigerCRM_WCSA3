package pomPages;

import java.util.Map;

import genericLibraries.BaseClass;

public class ExcelData extends BaseClass {

	public void contactData() {

		Map<String, String> m1 = excel.getDataBasedOnKey("TestData", "Create Contact");
		String contactName = m1.get("Last Name") + jav.generateRandomNumber(100);
	}

	public void leadData() {
		Map<String, String> m2 = excel.getDataBasedOnKey("TestData", "Create Lead");
		String lastName = m2.get("Last Name") + jav.generateRandomNumber(100);
		String newLastName = m2.get("Last Name") + jav.generateRandomNumber(100);

	}

	public void organizationData() {
		Map<String, String> m = excel.getDataBasedOnKey("TestData", "Create Organization");
		String organizationName= m.get("Organization Name")+jav.generateRandomNumber(100);	
	}

}
