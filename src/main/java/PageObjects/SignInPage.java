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
	
	@FindBy(xpath = "//span[@id='body_0_content_0_MessageLbl']")
	WebElement signinMsg;
	
	@FindBy(linkText = "Software Licensing")
	WebElement swLic;
	
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
	
	public String getSignInMessage() {
		String message = signinMsg.getText();
		return message;
	}
	
	public void clickSWLic() {
		swLic.click();
	}
}
