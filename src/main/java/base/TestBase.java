package base;

import java.io.IOException;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.ReadData;;

public class TestBase {

	public static WebDriver driver ;
	
	//initializing the webdriver method
	public void Initialization() throws InterruptedException, IOException {
		
		//initialize logger variable at starting
		//this.getClass() to get current class
		

		String browser = ReadData.readPropertyFile("browser");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("safari")) {
			driver = new SafariDriver();
		}
		if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(ReadData.readPropertyFile("url"));
		driver.manage().deleteAllCookies();
	}
	
	//random data methods created in base class because we need this methods for generating random data
	//method to generate random string
	public String randomString() {
		String ranString = RandomStringUtils.randomAlphabetic(5);
		return ranString;
	}
	
	//method to generate random number
	public String randomNumber() {
		String ranNumber = RandomStringUtils.randomNumeric(10);
		return ranNumber;
	}
	
	//method to generate random number
	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return (generatedString + generatedNumber);
	}
	
	
}
