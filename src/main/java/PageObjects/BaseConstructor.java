package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseConstructor {
	WebDriver driver;

	public BaseConstructor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
