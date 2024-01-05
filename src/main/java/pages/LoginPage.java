package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	
	//constructor
	public LoginPage () {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='input-email']") private WebElement emailInputBox;
	@FindBy(xpath="//input[@id='input-password']") private WebElement passInputBox;
	@FindBy(xpath="//input[@type='submit']") private WebElement loginBtn;
	
	//acttion methods
	public void enterEmail(String email) {
		emailInputBox.sendKeys("ghatetejas8@gmail.com");
	}
	
	public void enterPassword(String password) {
		passInputBox.sendKeys("Pass@123");
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
}
