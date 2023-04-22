package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class WelcomePage {

	WebDriver driver;
	
	By homeBtnPath = By.xpath("//img[@alt='Home Button']");
	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickOnHome() 
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("body");
		driver.switchTo().frame("navbar");
		
		WebElement homeBtn = driver.findElement(homeBtnPath);
		homeBtn.click();
		Reporter.log("Click on Home Page Button...");
		driver.switchTo().defaultContent();
		
	}
	
	public void verifyHomepage() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("body");
		driver.switchTo().frame("info");
		
		boolean massage = driver.getPageSource().contains("Welcome");
		
		Assert.assertTrue(massage);
		
		Reporter.log("We are on Home Page...");
		
	}
	
}
