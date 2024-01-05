package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage () {
		PageFactory.initElements(driver, this);
	}
	
	//objectRepository
	@FindBy(xpath="//h2[text()='My Account']") private WebElement myAccountTxt;
	
	//actionMethods
	public boolean myAccountPageExist() {
		return myAccountTxt.isDisplayed();
	}
}
