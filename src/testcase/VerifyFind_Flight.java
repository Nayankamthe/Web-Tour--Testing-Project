package testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import pages.Find_Flight;
import pages.ItineraryPage;
import pages.LoginPage;
import pages.Signoff;
import utilities.ObjectReader;
import utilities.Screenshot;

public class VerifyFind_Flight {

	WebDriver driver;
	LoginPage lp;
	Find_Flight ff;
	ItineraryPage Ip;
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
		// createing instance of LoginPage
		lp = new LoginPage(driver);
		// it is one time operation
		lp.loginToApp();
	}
	
	@Test(dependsOnMethods = "verifyLogin")
	public void flightBooking() throws IOException {
		// creating instance Find_Flight .
		ff = new Find_Flight(driver);
		// it is one time operation
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ff.clickOnFlightBooking();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ff.bookFlight();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ff.findFlight();
		ff.paymentDetails();
		ff.confirmationMessage();
		
		
	}
	
	@Test(dependsOnMethods = "flightBooking")
	public void Itinerary_Cancel_Flight() {
		// creating instance of Itinerary page
		Ip = new ItineraryPage(driver);
		Ip.click_Itinerary();
		Ip.cancelAllTicket();
	}
	
	@Test(dependsOnMethods = "Itinerary_Cancel_Flight")
	public void SignOff_Testcase() {
		
		// creating the instance of sign of the page
		so = new Signoff(driver);
		so.singOffPage();
		so.verifySignoff();
		
	}
	@AfterMethod
	public void screenShot(ITestResult result) {
		// capture the screenshot when test is faild.
		if(ITestResult.FAILURE==result.getStatus())
		{
			Screenshot.captureScreenshot(driver, result.getName());
		}
	
	}	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
