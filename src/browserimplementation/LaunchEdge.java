package browserimplementation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utilities.ObjectReader;

public class LaunchEdge {

	// creating instance of the objectReader.
	ObjectReader obj;
	public LaunchEdge() throws IOException 
	{
		
		obj  = new ObjectReader();
		
		// Edge key
		String key = obj.getEdgeKey();
		// Edge path
		String path = obj.getEdgePath();
		// setting the system property
		System.setProperty(key, path);
		
			
	}
	
	public WebDriver launchEdge()
	{
		WebDriver driver = new EdgeDriver();
		return driver;		
	}
}
