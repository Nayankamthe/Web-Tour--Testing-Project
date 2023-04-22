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
import pages.LoginPage;
import pages.Signoff;
import utilities.ObjectReader;
import utilities.Screenshot;

public class VerifySignOff {

	WebDriver driver;
	LoginPage lp;
	Signoff so;
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
	@Test(priority = 0)
	public void verifyLogin() {
		String url = obj.getBaseUrl();
		driver.get(url);		
		lp = new LoginPage(driver);
		// it is one time operation
		lp.loginToApp();
	}
	@Test(dependsOnMethods = "verifyLogin")
	public void SignOff_Testcase() {
		so = new Signoff(driver);
		so.singOffPage();
		so.verifySignoff();
		
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
