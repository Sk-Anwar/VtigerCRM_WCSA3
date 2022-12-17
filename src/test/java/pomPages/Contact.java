package pomPages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericLibraries.WebDriverUtility;

public class Contact {
	WebDriverUtility webDriverU;

	// Declaration

	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	private WebElement clickOnContact;

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement clickOnPluseIcon;

	@FindBy(name = "salutationtype")
	private WebElement salutationDropdown;

	@FindBy(name = "lastname")
	private WebElement LastName;

	@FindBy(xpath = "//img[contains(@onclick,'Accounts&action')]")
	WebElement clickOrgPluse;

	@FindBy(xpath = "//div[@id='ListViewContents']/descendant::table[@cellpadding='5']/descendant::tr/td[1]/a")
	private List<WebElement> orgList;

	@FindBy(name = "imagename")
	private WebElement ChooseFile;

	@FindBy(xpath = "//input[contains(@value,'Save')]")
	private WebElement saveBtn;

	@FindBy(xpath = "//table[@class='lvt small']/descendant::tr[last()]/td[4]/a")
	private WebElement newContact;

	// Initialization
	public Contact(WebDriver driver, WebDriverUtility webDriverU) {
		this.webDriverU = webDriverU;
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public void clickOnContact() {
		clickOnContact.click();
	}

	public void createContact() {
		clickOnPluseIcon.click();
	}

	public void salutationDropdown(String value) {
		webDriverU.dropdown(value, salutationDropdown);
	}

	public void lastName(String name) {
		LastName.sendKeys(name);
	}

	public void addOrganization(String organization) {
		clickOrgPluse.click();
		String parentWindow = webDriverU.getParentWindow();
		webDriverU.handeChildBrowser();

		for (WebElement org : orgList) {
			String name = org.getText();
			if (name.equalsIgnoreCase(organization)) {
				org.click();
				break;
			}
		}
		webDriverU.switchToWindow(parentWindow);
	}

	public void fileUpload(String filePath) {
		ChooseFile.sendKeys(filePath);
	}

	public void clickOnSave() {
		saveBtn.click();
	}

	public String newContact() {
		return newContact.getText();
	}

}