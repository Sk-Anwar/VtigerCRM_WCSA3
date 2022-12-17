package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class LoginAndLogOut {
	WebDriver driver;
	WebDriverUtility webDriverU;

	@FindBy(name = "user_name")
	WebElement Usename;

	@FindBy(name = "user_password")
	WebElement Password;

	@FindBy(id = "submitButton")
	WebElement LoginBtn;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	WebElement administrator;

	@FindBy(xpath = "//a[.='Sign Out']")
	WebElement logOut;

	public LoginAndLogOut(WebDriver driver,WebDriverUtility webDriverU) {
		this.driver=driver;
		this.webDriverU=webDriverU;
		PageFactory.initElements(driver, this);
	}

	public void Login(String username, String password) {
		Usename.sendKeys(username);
		Password.sendKeys(password);
		LoginBtn.click();
	}

	public void SignOut() {
		webDriverU.mouseHoverToElement(administrator);
		logOut.click();
	}
}
