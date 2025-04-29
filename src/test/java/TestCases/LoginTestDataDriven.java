package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.SignInPage;
import TestBase.Base;
import TestCase.Utilities.DataProviders;

public class LoginTestDataDriven extends Base {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void LoginDDT(String username, String password, String expResult) {

		LandingPage lp = new LandingPage(driver);
		lp.clickAccount();
		lp.clickSignIn();

		logger.info("**********Starting Data Driven Test***********");
		SignInPage sip = new SignInPage(driver);
		sip.setEmail(username);
		sip.setPassword(password);
		sip.clickSignIn();

		
		if (expResult.equalsIgnoreCase("invalid")) {
			logger.info("**********Test for Invalid Credentials***********");
			logger.info(sip.getSignInMessage());
			Assert.assertTrue(false);
		}
		logger.info("**********Test for Valid Credentials***********");
		if (expResult.equalsIgnoreCase("valid")) {
			AccountPage ap = new AccountPage(driver);
			assertEquals(ap.getAccountEmail(), username);
		}
		logger.info("**********Validation Finished***********");

	}
}
