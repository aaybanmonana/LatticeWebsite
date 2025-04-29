package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BaseConstructor {

	
	//create constructor
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	// create locators
	@FindBy(id="body_0_content_0_SignInEmail")
	WebElement email;
	
	@FindBy(id ="body_0_content_0_SignInPassword")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='button']")
	WebElement signinBtn;
	
	//create actions methods
	
	public void setEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void setPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void clickSignIn() {
		signinBtn.click();
	}
}
