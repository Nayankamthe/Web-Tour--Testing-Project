package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ObjectReader {

	Properties objpro;
	
	public ObjectReader() throws IOException
	{
		File fi= new File("D:\\java\\Web tours\\ObjectRepository\\object.properties");
		FileInputStream fis = new FileInputStream(fi);
		
		objpro = new Properties();
		objpro.load(fis);
		
		
	}
	// get chrome key method
	public String getChromeKey() {
		
		return objpro.getProperty("ChromeKey");
			
	}
	// get chorme key path
	public String getChromePath() {
		return objpro.getProperty("ChromePath");
	}
	// get  base url of web tour site
	public String getBaseUrl() {
		return objpro.getProperty("BaseUrl");
	}
	// get firefox key method
	public String getFirefoxKey() {
	
		return objpro.getProperty("FirefoxKey");
		
	}
	// get firefox path method
	public String getFirefoxPath() {
		return objpro.getProperty("FirefoxPath");
	}
	// get Edge key method
	public String getEdgeKey() {
		
		return objpro.getProperty("EdgeKey");
	}
	// get Edge path method.
	public String getEdgePath() {
		return objpro.getProperty("EdgePath");
	}
	
	
}
