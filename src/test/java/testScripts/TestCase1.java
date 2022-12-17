package testScripts;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import genericLibraries.BaseClass;

public class TestCase1 extends BaseClass {

	@Test(dataProvider = "getOrganizationData")
	public void CreateOrganization(String organizationName, String industryName) 
	{
		l.Login(Username, Password);
		org.clickOnOrganizations();
		org.CreateOrganization();
		org.OrganizationName(organizationName);
		org.industryDropdown(industryName);
		org.clickOnSave();
		org.clickOnOrganizations();
		String newOrganization = org.NewOrganization();
		assertEquals(newOrganization, organizationName);
		l.SignOut();
	}
}
