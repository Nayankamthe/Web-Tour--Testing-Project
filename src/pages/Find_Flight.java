package pages;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import utilities.ExcelReader;

public class Find_Flight {

	WebDriver driver;
	
	// flight Button on page
	By flightBtn = By.xpath("//img[@alt='Search Flights Button']");
	
	// flight booking frame 
	
	By departureXpath = By.name("depart");
	By arrivalByXpath = By.name("arrive");
	By departureDateXpath = By.name("departDate");
	By returnDateXpath = By.name("returnDate");
	By passengerXpath = By.name("numPassengers");
	By roundTripcheckBox = By.name("roundtrip");
	By continueBtnXpath = By.name("findFlights");
	
	// seating preference radio btn
	By windowPath =  By.xpath("//input[@value='Window']");
	By aislePath = By.xpath("//input[@value='Aisle']");
	By nonePath = By.xpath("//input[@value='None']");
	
	// type of seat radion btn
	By firstPath = By.xpath("//input[@value='First']");
	By bussinessPath = By.xpath("//input[@value='Business']");
	By coachPath = By.xpath("//input[@value='Coach']");
	
	

	// find Flight Btn
	
	By ReserveFlightPath = By.name("reserveFlights");
	
	// payment page
	By address1Xpath = By.name("address1");
	By address2Xpath = By.name("address2");
	By creditCardPath = By.name("creditCard");
	By expiryDatePath = By.name("expDate");
	By buyflighPath = By.name("buyFlights");
	
	// make another booking 
	By makeAnotherPath = By.name("Book Another");
	
	ExcelReader  reader = new ExcelReader("D:\\java\\Web tours\\DataSource\\data1.xlsx");
	int rowCount = reader.getRowCount(0);
	
	public Find_Flight(WebDriver driver) throws IOException
	{
		this.driver = driver;
	}
	
	public void clickOnFlightBooking() 
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("body");
		driver.switchTo().frame("navbar");
		
		driver.findElement(flightBtn).click();
		
		
		Reporter.log("Click on Flight Working...");
		
	}
	public void bookFlighNtimes() {
		
		bookFlight();
		findFlight();
		paymentDetails();
		confirmationMessage();
		bookAnotherFlight();
	}
	public void bookFlight() 
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("body");
		driver.switchTo().frame("info");
		
		WebElement departure = driver.findElement(departureXpath);
		WebElement arrival = driver.findElement(arrivalByXpath);
		WebElement departureDate = driver.findElement(departureDateXpath);
		WebElement ReturnDate = driver.findElement(returnDateXpath);
		WebElement noOfPassenger = driver.findElement(passengerXpath);
		WebElement RoundTrip = driver.findElement(roundTripcheckBox);
		
		// seating preference
		
		WebElement AisleRadio = driver.findElement(aislePath);
		WebElement windowRadio = driver.findElement(windowPath);
		WebElement NoneRadio = driver.findElement(nonePath);
		
		// Type of seat
		WebElement firstRadio = driver.findElement(firstPath);
		WebElement BusinessRadio = driver.findElement(bussinessPath);
		WebElement coachRadio = driver.findElement(coachPath);
		// submit button
		WebElement continueBtn = driver.findElement(continueBtnXpath);
		
		String departureCity ="Frankfurt";
		String arrivalCity ="London";
	
		
		// date
		Calendar c = Calendar.getInstance();
		int data = c.get(Calendar.DATE);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		
		String deptDate = String.valueOf(month+1)+"/"+String.valueOf(data+2)+"/"+String.valueOf(year);
		String returnDate = String.valueOf(month+1)+"/"+String.valueOf(data+3)+"/"+String.valueOf(year);
		
		// listbox operation
		
		Select selectdeparture = new Select(departure);
		selectdeparture.selectByValue(departureCity);
		
		departureDate.clear();
		departureDate.sendKeys(deptDate);
		
		Select selectArrival = new Select(arrival);
		selectArrival.selectByValue(arrivalCity);
		
		ReturnDate.clear();
		ReturnDate.sendKeys(returnDate);
		
		noOfPassenger.clear();
		noOfPassenger.sendKeys("1");
		
//		RoundTrip.click();
		
		windowRadio.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		BusinessRadio.click();
		// click on flight
		continueBtn.click();
		driver.switchTo().defaultContent();
		
		
		
	}
	public void findFlight() 
	{	
		System.out.println(("Coming to findFlight"));
		
		driver.switchTo().frame("body");
        driver.switchTo().frame("info");
        System.out.println("present in flight select");
        
        Calendar c = Calendar.getInstance();
		int data = c.get(Calendar.DATE);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		
		String deptDate = String.valueOf(month+1)+"/"+String.valueOf(data+2)+"/"+String.valueOf(year);
		
        // find flight Radio btn path
		String xpathB1 = "//input[@value='120;385;"+deptDate+"']";
		String xpathB2 = "//input[@value='121;343;"+deptDate+"']";
		String xpathB3 = "//input[@value='122;364;"+deptDate+"']";
		String xpathB4 = "//input[@value='123;315;"+deptDate+"']";
		
		//121;343;3/22/2022
        WebElement blueSky0  = driver.findElement(By.xpath(xpathB1));
		WebElement blueSky1   = driver.findElement(By.xpath(xpathB2));
		WebElement blueSky2  = driver.findElement(By.xpath(xpathB3));
		WebElement blueSky3  = driver.findElement(By.xpath(xpathB4));
        WebElement reserveFlight = driver.findElement(ReserveFlightPath);
        
        //select the flight
        blueSky1.click();
        // submit or continue.
        reserveFlight.click();
		driver.switchTo().defaultContent();

		
	}
	
	public void paymentDetails() {
		
		driver.switchTo().frame("body");
		driver.switchTo().frame("info");
		
		WebElement streetAddress = driver.findElement(address1Xpath);
		WebElement city_State_Zip= driver.findElement(address2Xpath);
		WebElement creditCard = driver.findElement(creditCardPath);
		WebElement expiryDate = driver.findElement(expiryDatePath);
		WebElement paymentContinue = driver.findElement(buyflighPath);
		
		
		streetAddress.clear();
		streetAddress.sendKeys(reader.getData(0, 1,0));
		city_State_Zip.clear();
		city_State_Zip.sendKeys(reader.getData(0, 1,1));
		creditCard.clear();
		
		creditCard.sendKeys(String.valueOf(reader.getData(0, 1,2)));
		expiryDate.clear();
		expiryDate.sendKeys(String.valueOf(reader.getData(0, 1,3)));
		
		paymentContinue.click();
		driver.switchTo().defaultContent();
		
		Reporter.log("Payment Details verified");
		
	}
	public void confirmationMessage() 
	{
		
		driver.switchTo().frame("body");
        driver.switchTo().frame("info");
		
        String actMessage = "Thank you for booking through Web Tours.";
		String expMessage = driver.findElement(By.xpath("/html/body/blockquote/center/small/b")).getText();
		
		Assert.assertEquals(actMessage, expMessage);
		driver.switchTo().defaultContent();
		Reporter.log(" Confirmation Message Verified");
	}
	
	public void bookAnotherFlight() 
	{
		
		driver.switchTo().frame("body");
        driver.switchTo().frame("info");
		WebElement makeAnother = driver.findElement(makeAnotherPath);
		
		makeAnother.click();
		driver.switchTo().defaultContent();
	}
	
}
