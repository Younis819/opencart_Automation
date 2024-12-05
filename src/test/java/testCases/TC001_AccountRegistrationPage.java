package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationPage extends BaseClass {

	
	@Test
	public void verify_account_registration()
	{
		try {
		logger.info("*****Starting  TC001_AccountRegistrationPage*****");
		HomePage hp=new HomePage(driver);
		logger.info("*****Clicked on MyAccount Link*****");
		hp.clickMyAccount();
		logger.info("*****Clicked on Register Link*****");
		hp.clickRegister();
		
		AccountRegistrationPage repage=new AccountRegistrationPage(driver);
		logger.info("*****Providing customer details*****");
		repage.setFirstName(randomString().toUpperCase());
		repage.setLastName(randomString().toUpperCase());
		repage.setEmail(randomString()+"@gmail.com");
		repage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		repage.setPassword(password);
		repage.setConfirmPassword(password);
		
		repage.setPrivacyPolicy();
		repage.clickContinue();
		
		logger.info("*****Validating expected message*****");
		String confmsg=repage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true); //passes the test
		}
		else 
		{
			logger.error("Test Failed...");
			logger.debug("Debug.logs");
			Assert.assertTrue(false); //fails the test
		}
		
		}
		catch(Exception e) {
			
			Assert.fail(); // Optional: Mark the test as failed due to an exception
		} 
		
		logger.info("*******Finished TC001_AccountRegistrationPage******");
		
	}
	
	
	
}
