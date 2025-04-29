package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BaseConstructor{

	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath = "//span[normalize-space()='monanaivanvincent@gmail.com']")
	WebElement accountemail;
	
	@FindBy(linkText = "Software Licensing")
	WebElement softwarelicensingBtn;
	
	//actions methods
	
	public String getAccountEmail() {
		return accountemail.getText();
	}
	
	public void clickSoftwareLicensing() {
		softwarelicensingBtn.click();
	}

}
