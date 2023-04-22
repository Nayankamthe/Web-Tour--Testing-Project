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
import pages.WelcomePage;
import utilities.ObjectReader;
import utilities.Screenshot;

public class Verify_WelcomePage {

	WebDriver driver;
	LoginPage lp;
	WelcomePage wp;
	ObjectReader obj;
	ChooseBrowser  cb;
	
	@BeforeClass
	public void setup() throws IOException {
		// creating the instance of the ObjectReader()
		obj = new ObjectReader();
		// creating the instance of the ChooseBrowser
		cb =  new ChooseBrowser();
		// assinging the browserDriver() method value to the driver 
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
	
	@Test(dependsOnMethods ="verifyLogin")
	public void verify_Homepage_Testcase() {
		wp = new WelcomePage(driver);
		wp.clickOnHome();
		wp.verifyHomepage();
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
