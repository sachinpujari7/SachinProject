/**
 * 
 */
package com.NhanceNow.Utility;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.NhanceNow.ActionDriver.ActionClass;
import com.NhanceNow.Base.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


/**
 * @author IDS055
 *
 */
public class ListenerClass extends BaseClass implements ITestListener
{
	ActionClass action= new ActionClass();
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Failed Test Case", ExtentColor.RED));
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				String imgPath = action.screenShot(driver, result.getName());
			
				test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
				} 
			        catch (IOException e) 
			       {
				     e.printStackTrace();
			       }
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
		
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		test = extent.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, "Pass Test case is: " + result.getName());
		
	    }
	}
	
   
}
