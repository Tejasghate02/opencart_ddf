package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utility.ReadData;
import utility.ScreenShot;

public class LoginPageTest extends TestBase{

	HomePage home;
	LoginPage login;
	MyAccountPage account;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		Initialization();
		home= new HomePage();
		login = new LoginPage();
		account = new MyAccountPage();
	}
	
	@Test
	public void loginUserTest() throws IOException, InterruptedException {
		home.clickMyAccount();
		home.clickLoginBtn();
		Thread.sleep(1000);
		login.enterEmail(ReadData.readPropertyFile("email"));
		login.enterPassword(ReadData.readPropertyFile("password"));
		login.clickLoginBtn();
		Thread.sleep(1000);
		boolean target =  account.myAccountPageExist();
		Assert.assertEquals(target, true);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException {
		if(it.FAILURE==it.getStatus()) {
			ScreenShot.screenshot(it.getName());
		}
		driver.close();
	}
}
