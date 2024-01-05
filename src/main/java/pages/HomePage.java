package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{

	//constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Object repository
	@FindBy(xpath="//span[text()='My Account']") private WebElement myAccount;
	@FindBy(linkText = "Register") private WebElement registerBtn;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']") private WebElement loginBtn;
	
	//action methods
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickRegisterBtn() {
		registerBtn.click();
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
}
