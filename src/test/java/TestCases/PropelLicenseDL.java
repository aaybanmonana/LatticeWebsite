package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LicensingPage;
import PageObjects.PropelLicPage;
import PageObjects.SignInPage;
import TestBase.Base;

public class PropelLicenseDL extends Base {

	@Test
	public void checkPropelLicense() {
		
		logger.info("**********License Generation Test Started**********");
		
		LandingPage lp = new LandingPage(driver);
		lp.clickAccount();
		lp.clickSignIn();
		
		logger.info("**********Click on Sign In**********");
		SignInPage sip = new SignInPage(driver);
		sip.setEmail(credentials.getProperty("myEmail"));
		sip.setPassword(credentials.getProperty("myPassword"));
		sip.clickSignIn();
		clickHome();
		sip.clickSWLic();
		
		LicensingPage licPage = new LicensingPage(driver);
		licPage.selectFreePropel();
		
		logger.info("**********Click on Generate License**********");
		PropelLicPage PropLic = new PropelLicPage(driver);
		PropLic.inputNIC(getRandomString().toUpperCase());
		PropLic.checkVerify();
		PropLic.clickGenerate();
		String licMsg = PropLic.getLicMsg();
		if (licMsg.contains("receive an email")) {
			logger.info("License Generated");
			Assert.assertTrue(true);
		}
		
		logger.info("**********License Generation Test Finished**********");
		
	}
}
