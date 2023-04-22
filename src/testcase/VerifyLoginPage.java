package testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browserimplementation.ChooseBrowser;
import pages.LoginPage;
import utilities.ObjectReader;
import utilities.Screenshot;

public class VerifyLoginPage {

	WebDriver driver;
	LoginPage lp;
	ObjectReader obj;
	ChooseBrowser  cb;
	
	@BeforeClass
	public void setup() throws IOException {
		// create the instance of the object reader
		obj = new ObjectReader();
		// create the instance of the ChooseseBroser
		cb =  new ChooseBrowser();
		// assing value to driver from browser Driver class
		driver = cb.browserDriver();
					
		
	}
	
	@Test
	public void verify_LoginPageTestcase() {
		String url = obj.getBaseUrl();
		driver.get(url);
		lp = new LoginPage(driver);
		
		lp.getTitle();
		lp.getCurrentUrl();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lp.loginToApp();					
	}
	@AfterMethod
	public void screenShot(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Screenshot.captureScreenshot(driver, result.getName());
		}
	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
