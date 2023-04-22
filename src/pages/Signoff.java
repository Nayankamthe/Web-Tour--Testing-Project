package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class Signoff {

	WebDriver driver;
	
	By signOffbtnPath = By.xpath("//img[@alt='SignOff Button']");
	public Signoff(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void singOffPage() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("body");
		driver.switchTo().frame("navbar");
		
		WebElement signoff = driver.findElement(signOffbtnPath);
		signoff.click();
		Reporter.log("Sign off Successfully..");
		driver.switchTo().defaultContent();
		
	}
	
	public void verifySignoff() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("body");
		driver.switchTo().frame("info");
		
		boolean massage = driver.getPageSource().contains("Welcome to the Web Tours site.");
		
		Assert.assertTrue(massage);
		Reporter.log("Signoff from site Verify...");
	}
}
