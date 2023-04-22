package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class ItineraryPage {

	WebDriver driver;
	
	By itineraryXpath = By.xpath("//img[@alt='Itinerary Button']");
	By checkBoxPath = By.name("1");
	By chancelXpath = By.name("removeFlights");
	By chancelAllXpath = By.name("removeAllFlights");
	
	public ItineraryPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	public void click_Itinerary() {
		
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("body");
		driver.switchTo().frame("navbar");
		WebElement itinerary  = driver.findElement(itineraryXpath);
		itinerary.click();
		Reporter.log("click on itinerary btn.");
		driver.switchTo().defaultContent();
	}
	public void cancelTicket() {
		driver.switchTo().frame("body");
		driver.switchTo().frame("info");
		WebElement checkBox = driver.findElement(checkBoxPath);
		WebElement cancelTicket = driver.findElement(chancelXpath);
		checkBox.click();
		cancelTicket.click();
		Reporter.log("Cancel Ticket...");
		driver.switchTo().defaultContent();
		
	}
	public void cancelAllTicket() {
		driver.switchTo().frame("body");
		driver.switchTo().frame("info");
		WebElement cancelAllTicket = driver.findElement(chancelAllXpath);
		
		cancelAllTicket.click();
		Reporter.log("Cancel all Tickets....");
		driver.switchTo().defaultContent();
	}
	
	public void verify_NoFlight() {
		driver.switchTo().frame("body");
		driver.switchTo().frame("info");
//		boolean massage = driver.getPageSource().contains("No flights have been reserved.");
		String acMessage ="No flights have been reserved.";
		String exMessage = driver.findElement(By.xpath("/html/body/blockquote/form/center/h3")).getText();
		Assert.assertEquals(acMessage, exMessage);
		
		Reporter.log("No flights have been reserved....");
	}
	
	
}
