package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LicensingPage extends BaseConstructor{

	public LicensingPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(linkText = "Request a Free License")
	WebElement propelNL;
	
	
	//actions
	public void selectFreePropel() {
		propelNL.click();
	}
	

}
