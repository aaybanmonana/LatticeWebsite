package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.SignInPage;
import TestBase.Base;

public class AccountLogin extends Base {
	
	String email = "monanaivanvincent@gmail.com";
	
	@Test
	public void verify_login() {
		
		LandingPage lp = new LandingPage(driver);
		
		logger.info("**********Click on Sign In**********");
		lp.clickAccount();
		lp.clickSignIn();
		
		logger.info("**********Account credentials**********");
		SignInPage sip = new SignInPage(driver);
		sip.setEmail(email);
		sip.setPassword("Lattice123");
		sip.clickSignIn();
		
		logger.info("**********Verifying Account**********");
		AccountPage ap = new AccountPage(driver);
		String accountEmail = ap.getAccountEmail();
		Assert.assertEquals(email, accountEmail);
		
	}
}
