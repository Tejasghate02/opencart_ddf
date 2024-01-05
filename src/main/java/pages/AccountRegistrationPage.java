package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class AccountRegistrationPage extends TestBase{

	public AccountRegistrationPage(){
		PageFactory.initElements(driver, this);
	}
	
	//objectRepository
	@FindBy(xpath="//input[@id='input-firstname']") private WebElement lastNameInput;
	@FindBy(xpath="//input[@id='input-lastname']") private WebElement firstNameInput;
	@FindBy(xpath="//input[@name='email']") private WebElement emailInputBox;
	@FindBy(xpath="//input[@id='input-password']") private WebElement passwordInput;
	@FindBy(xpath="//input[@id='input-confirm']") private WebElement confirmPasswordInput;
	@FindBy(xpath="//input[@type='radio' and @name='newsletter' and @value='1']") private WebElement newsLetterRadioBtn;
	@FindBy(xpath="//input[@type='checkbox']") private WebElement checkBox;
	@FindBy(xpath="//input[@type='submit' and @value='Continue']") private WebElement continueBtn;
	@FindBy(xpath="//input[@id='input-telephone']") private WebElement telephoneNoInput;
	
	
	//actionmethods
	public String accountRegistration() throws InterruptedException {
		firstNameInput.sendKeys(randomString());
		lastNameInput.sendKeys(randomString());
		emailInputBox.sendKeys(randomString() + "@gmail.com");
		telephoneNoInput.sendKeys(randomNumber());
		String password  = randomAlphaNumeric();
		passwordInput.sendKeys(password);
		confirmPasswordInput.sendKeys(password);
		newsLetterRadioBtn.click();
		checkBox.click();
		continueBtn.click();
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
	}
	
}
