package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class Organizations {
	WebDriverUtility webDriverU;

	// Declaration

	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement clickOnorg;

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement clickOnPluseIcon;

	@FindBy(name = "accountname")
	private WebElement orgName;

	@FindBy(name = "industry")
	WebElement industryDropdown;

	@FindBy(xpath = "(//input[contains(@value,'Save')])[2]")
	private WebElement saveBtn;

	@FindBy(xpath = "//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")
	private WebElement newOrg;

	// Initialization
	public Organizations(WebDriver driver,WebDriverUtility webDriverU) {
		this.webDriverU =webDriverU;
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public void clickOnOrganizations() {
		clickOnorg.click();
	}

	public void CreateOrganization() {
		clickOnPluseIcon.click();

	}

	public void OrganizationName(String name) {
		orgName.sendKeys(name);
	}

	public void industryDropdown(String value) {
		webDriverU.dropdown( value ,industryDropdown);
	}

	public void clickOnSave() {
		saveBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String NewOrganization() {
		return newOrg.getText();
	}

}
