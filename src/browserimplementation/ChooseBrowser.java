package browserimplementation;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

public class ChooseBrowser {
	WebDriver driver;
	LaunchChrome lc;
	LaunchFirefoxBrowser lf;
	LaunchEdge le;
	
	public WebDriver browserDriver() throws IOException {
		System.out.println("Please choose the browser");
		System.out.println("1. Chrome Browser");
		System.out.println("2. FirefoxBrowser");
		System.out.println("3. Edge Browser");
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		if(a==1)
		{
			lc = new LaunchChrome();
			driver = lc.launchChrome();
			return driver;
			
		}
		else if (a==2) {
			lf = new LaunchFirefoxBrowser();
			driver = lf.LaunchFirefox();
			return driver;
		}
		else
		{
			le = new LaunchEdge();
			driver = le.launchEdge();
			return driver;
		}
		
	}
	
	
}
