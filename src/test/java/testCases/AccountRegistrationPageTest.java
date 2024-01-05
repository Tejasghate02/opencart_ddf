package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AccountRegistrationPage;
import pages.HomePage;
import utility.ScreenShot;
public class AccountRegistrationPageTest extends TestBase{
	
	HomePage hp;
	AccountRegistrationPage p1;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		Initialization();
		hp = new HomePage();
		p1 = new AccountRegistrationPage();
	}
	
	@Test
	public void AccountRegistrationTest() throws InterruptedException{
		//to generate the logger file we use logger.info()
		hp.clickMyAccount();
		hp.clickRegisterBtn();
		Thread.sleep(2000);
		String expTxt = p1.accountRegistration();
		String actTxt = "Your Account Has Been Created!";
		Assert.assertEquals(expTxt, actTxt);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException {
		if(it.FAILURE==it.getStatus()) {
			ScreenShot.screenshot(it.getName());
		}
		driver.close();
	}
}
