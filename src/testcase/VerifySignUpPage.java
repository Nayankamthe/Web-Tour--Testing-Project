package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browserimplementation.ChooseBrowser;
import pages.SignUpPage;
import utilities.ObjectReader;
import utilities.Screenshot;

public class VerifySignUpPage {

	WebDriver driver;
	SignUpPage sp;
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
	public void verify_SingUpPageTestcase() throws IOException {
		String url = obj.getBaseUrl();
		driver.get(url);
		
		sp = new SignUpPage(driver);
		sp.signUpTest();
		sp.fill_SignUp_Form();
		
		
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
