/**
 * 
 */
package com.NhanceNow.LoginTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.NhanceNow.Base.BaseClass;
import com.NhanceNow.Pageobjects.HomePage;
import com.NhanceNow.Pageobjects.LoginPage;

/**
 * @author IDS055
 *
 */
public class HomePageTest extends BaseClass
{
	private LoginPage signin;
	private HomePage homepage;
	
	
	@Test
	public void clickonSettings() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		Thread.sleep(3000);
		String acturl=driver.getCurrentUrl();
		String expturl="https://dev.nhancenow.com/nhance-web-admin/settings";
		if(acturl.equals(expturl))
			test.pass("user is successfully navigated on settings page after clicking on setting btn");
		Assert.assertEquals(acturl, expturl);
	}
	

}
