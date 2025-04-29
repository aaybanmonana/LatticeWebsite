package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropelLicPage extends BaseConstructor{

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	public PropelLicPage(WebDriver driver) {
		super(driver);
	}

	// locators
	
	@FindBy(name = "body_0$tbHostId")
	WebElement NICadd;
	@FindBy(id = "body_0_cbNonCompetitor")
	WebElement verifyBtn;
	@FindBy(name = "body_0$ButtonSubmit")
	WebElement generateLicBtn;
	@FindBy(xpath = "//p[contains(text(),'You should receive an email shortly at the address')]")
	WebElement licMsg;
	
	
	//actions
	public void inputNIC(String NIC) {
		NICadd.sendKeys(NIC);
	}
	
	public void checkVerify() {
		verifyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("body_0_cbNonCompetitor")));
		verifyBtn.click();
		if (verifyBtn.isSelected()) {
			System.out.println("Verify button is checked");
		}else {
			verifyBtn.click();
		}
	}
	
	
	public void clickGenerate() {
		generateLicBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("body_0$ButtonSubmit")));
		generateLicBtn.click();
	}
	
	public String getLicMsg() {
		String message = licMsg.getText();
		return message;
	}
	
}
