package browserimplementation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ObjectReader;

public class LaunchChrome {
	// creating the object of the ObjectReader.
	ObjectReader obj;
	
	public LaunchChrome() throws IOException
	{
		// Assigning value  value of the runtime object ObjectReader() to the instance obj. 
		obj = new ObjectReader();
		
		
		// chrome key
		String key = obj.getChromeKey();	
		// chrome Path
		String path = obj.getChromePath();
		
		// setting the system Property
		System.setProperty(key, path);
	}
	
	public WebDriver launchChrome() 
	{
		WebDriver driver = new ChromeDriver();
		return driver;
	}
}
