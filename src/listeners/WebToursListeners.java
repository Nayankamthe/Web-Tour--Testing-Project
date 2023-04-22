package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.Screenshot;

public class WebToursListeners implements ITestListener{

	public void onTestStart(ITestResult result) 
	{
		
		System.out.println("********** Test Started "+result.getName());
		Reporter.log("********** Test Started "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		// TODO Auto-generated method stub
		System.out.println("****** Test Success"+result.getName());		
		Reporter.log("****** Test Success"+result.getName());

	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test is failed*******"+ result.getName());
		Reporter.log("*** Test is failed*******"+ result.getName());
	}
	
	public void OnStart(ITestContext context) {
		
		System.out.println("********* On Start"+ context.getName());
		Reporter.log("********* On Start"+ context.getName());
	}
	
	public void OnFinish(ITestContext context) {
		System.out.println("********* Test Started"+ context.getName());
		Reporter.log("********* Test Started"+ context.getName());
	}
	
}
