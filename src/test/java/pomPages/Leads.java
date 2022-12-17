package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class Leads {
	WebDriverUtility webDriverU;

	@FindBy(xpath = "//a[.='Leads']")
	private WebElement clickOnLeads;

	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement clickOnPluseIcon;

	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement salutationDropdown;

	@FindBy(name = "lastname")
	private WebElement LastName;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(xpath = "(//input[contains(@value,'Save')])[2]")
	private WebElement saveBtn;

	@FindBy(xpath = "(//input[@name='Duplicate'])[1]")
	private WebElement ClickonDuplicate;

	@FindBy(xpath = "//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")
	WebElement newLead;

	public Leads(WebDriver driver, WebDriverUtility webDriverU) {
		this.webDriverU = webDriverU;
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public void clickOnLeads() {
		clickOnLeads.click();
	}

	public void createLead() {
		clickOnPluseIcon.click();
	}

	public void salutationDropdown(String value) {
		webDriverU.dropdown(value, salutationDropdown);
	}

	public void lastName(String name) {
		LastName.sendKeys(name);
	}

	public void companyName(String name) {
		companyName.sendKeys(name);
	}

	public void clickOnSave() {
		saveBtn.click();
	}

	public void clickOnDuplicate() {
		ClickonDuplicate.click();
	}

	public void modifyLastName(String name) {
		LastName.clear();
		LastName.sendKeys(name);
	}

	public String newLead() {
		return newLead.getText();
	}

}
