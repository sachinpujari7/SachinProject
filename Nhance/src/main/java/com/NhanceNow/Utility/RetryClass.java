/**
 * 
 */
package com.NhanceNow.Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author IDS055
 *
 */
public class RetryClass implements IRetryAnalyzer
{
	 int initCount=0;
	    int maxCount=2;
		@Override
		public boolean retry(ITestResult result) {
			if(initCount<maxCount)
			{
				initCount++;
				return true;
			}
			
			return false;
		}

}
