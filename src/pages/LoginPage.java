package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
	public WebDriver driver;
	

	// acessing locators.
	By usernamexpath = By.name("username");
	By passwordxpath = By.name("password");
	By lognBtn = By.name("login");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getTitle() {

		String actTitle = "Web Tours";
		String expTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log("Title Matched.....");

	}

	public void getCurrentUrl() {
		String actTitle = "http://192.168.139.1:1080/WebTours/index.htm";
		String title = driver.getCurrentUrl();
		Assert.assertEquals(actTitle, title);
		Reporter.log("URL Matched.....");
		
	}
	
	public void loginToApp() {
		driver.switchTo().frame("body");
		driver.switchTo().frame("navbar");
		
		WebElement username = driver.findElement(usernamexpath);
		WebElement password = driver.findElement(passwordxpath);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		username.sendKeys("Nayan1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		password.sendKeys("Nayan1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		WebElement login = driver.findElement(lognBtn);
		
		login.click();
		Reporter.log("Login Successfully done...");
		
	}
}
