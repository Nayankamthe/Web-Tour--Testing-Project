package pages;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import utilities.ExcelReader;



public class SignUpPage{
	WebDriver driver;
	
	By signupLink = By.linkText("sign up now");
	By usernameXpath = By.name("username");
	By passwordXpath = By.name("password");
	By confirmPassXpath = By.name("passwordConfirm");
	By firstNameXpath = By.name("firstName");
	By lastNameXpath = By.name("lastName");
	By address1Xpath = By.name("address1");
	By address2Xpath = By.name("address2");
	By registerImgXpath = By.name("register");
	By continueImgXpath = By.xpath("//img");
	By signOffXpath = By.xpath("//img[@alt='SignOff Button']");
	ExcelReader  reader = new ExcelReader("D:\\java\\Web tours\\DataSource\\users.xlsx");
	int rowCount = reader.getRowCount(0);
	
	
	public SignUpPage(WebDriver driver) throws IOException {
		this.driver = driver;
		
	}
	public void signUpTest()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("body");
		driver.switchTo().frame("info");
		// find the sigup link text
		WebElement signup = driver.findElement(signupLink);
		// click on the signup link text.
		signup.click();		
		System.out.println("click on Signup Successfully...");
		Reporter.log("click on Signup Successfully...");
			
	}
	
	public void fill_SignUp_Form() {	
		
		try 
		{
			for (int i = 1; i<rowCount; i++) { 
				WebElement userName = driver.findElement(usernameXpath);
				WebElement password = driver.findElement(passwordXpath);
				WebElement confirmPass = driver.findElement(confirmPassXpath);
				WebElement firstName = driver.findElement(firstNameXpath);
				WebElement lastName = driver.findElement(lastNameXpath);
				WebElement streetAddress = driver.findElement(address1Xpath);
				WebElement city_State_Zip= driver.findElement(address2Xpath);
				WebElement register = driver.findElement(registerImgXpath);
				
				userName.sendKeys(reader.getData(0, i,0));
				password.sendKeys(reader.getData(0, i, 1));
				confirmPass.sendKeys(reader.getData(0, i, 2));
				firstName.sendKeys(reader.getData(0, i, 3));
				lastName.sendKeys(reader.getData(0, i, 4));
				streetAddress.sendKeys(reader.getData(0, i, 5));
				city_State_Zip.sendKeys(reader.getData(0, i, 6)); 
				register.click();
				System.out.println("Click on Register Successfully...");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				// verify Registration.
				verify_Registeration();
				// click continue button.
				continueTheSignUp();
				// click on signoff
				signOffPage();
				// switch to info frame and click on the sigup page.
				signUpTest();	
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				Reporter.log("User Name :"+reader.getData(0, i, 0)+"password :"+reader.getData(0, i, 1)+"login Successfully...");
						
				
			}
			System.out.println("All User Registration is completed");
			Reporter.log("All User Registration is completed");
		} 
		catch (Exception e) 
		{
			System.out.println("Error is Occur in User Registration "+ e);
			Reporter.log("Error is Occur in User Registration:"+ e);
		}						
		
		
			

		
	}
	public void verify_Registeration() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("body");
		driver.switchTo().frame("info");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean message= driver.getPageSource().contains("Thank you");
		
		Assert.assertTrue(message);
		System.out.println("SignUp Successfully.");
		Reporter.log("Sign up successfully");
	}
	
	public void continueTheSignUp() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("body");
		driver.switchTo().frame("info");
		WebElement continueBtn = driver.findElement(continueImgXpath);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		continueBtn.click();
		System.out.println("click on Continue Button Successfully..");
		Reporter.log("click on Continue Button Successfully..");
	}
	public void signOffPage() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("body");
		driver.switchTo().frame("navbar");
		WebElement signOff = driver.findElement(signOffXpath);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		signOff.click();
		System.out.println("Click on the Sign off Successfully");
		Reporter.log("Click on the Sign off Successfully");
		
		
	}
	
	
	
}
