package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

}
