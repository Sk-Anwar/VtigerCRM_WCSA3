package genericLibraries;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import pomPages.Contact;
import pomPages.Leads;
import pomPages.LoginAndLogOut;
import pomPages.Organizations;

public class BaseClass {
	public PropertyFileUtility property;
	public ExcelFileUtility excel;
	public DataBaseUtility db;
	public JavaUtility jav;
	public WebDriverUtility webDriverU;
	public WebDriver driver;
	public Contact contact;
	public Leads lead;
	public LoginAndLogOut l;
	public Organizations org;
	public String Username;
	public String Password;

	@BeforeClass
	public void classSetuUp() {

		property = new PropertyFileUtility();
		excel = new ExcelFileUtility();
		db = new DataBaseUtility();
		jav = new JavaUtility();
		webDriverU = new WebDriverUtility();

		property.propertyFileInitialization(IConstantPath.PROPERTYPATH);
		excel.excelInitialization(IConstantPath.EXCELFILE_PATH);
	}

	@BeforeMethod
	public void methodSetuUp() {
		String browser = property.getDataFromProperties("browser");
		String url = property.getDataFromProperties("url");
		String time = property.getDataFromProperties("timeouts");
		long timeouts = Long.parseLong(time);
		driver = webDriverU.openApplication(browser, url, timeouts);

		l = new LoginAndLogOut(driver, webDriverU);
		contact = new Contact(driver, webDriverU);
		lead = new Leads(driver, webDriverU);
		org = new Organizations(driver, webDriverU);

		Username = property.getDataFromProperties("username");
		Password = property.getDataFromProperties("password");
	}

	@AfterMethod
	public void methodTearDown() {
		webDriverU.closeBrowser();
	}

	@AfterClass
	public void classTearDown() {
		excel.closeExcel();
	}

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
