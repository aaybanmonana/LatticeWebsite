package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BaseConstructor{
//	WebDriver driver;
//	//create a constructor
//	public LandingPage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	//Create locators
	
	@FindBy(xpath = "//div[@class='dropdown dropbtn']")
	WebElement accountBtn;
	
	@FindBy(id ="header_0_ctl06_SignInLink")
	WebElement signinBtn;
	
	// create actions methods
	
	public void clickAccount() {
		accountBtn.click();
	}
	
	public void clickSignIn() {
		signinBtn.click();
	}
}
