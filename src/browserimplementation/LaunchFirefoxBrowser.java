package browserimplementation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.ObjectReader;



public class LaunchFirefoxBrowser {

	ObjectReader obj;
	
	public LaunchFirefoxBrowser() throws IOException
	{

		// it is assigning value  of runtime object ObjectReader() to instance obj.
		obj = new ObjectReader();
		
		// storeing firefoxkey and firefoxpath form the Object reader instance obj
		// and storing it in key and path pair.
		String key = obj.getFirefoxKey();
		String path = obj.getFirefoxPath();
		
		// set the System property by assigning key and path to it.
		// this is assigning choreme driver and  it path to the system.
		
		System.setProperty(key, path);
		
		
	}
	public WebDriver LaunchFirefox()
	{
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}
