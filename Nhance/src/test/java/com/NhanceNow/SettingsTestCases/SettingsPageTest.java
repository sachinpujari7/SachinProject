/**
 * 
 */
package com.NhanceNow.SettingsTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.NhanceNow.Base.BaseClass;
import com.NhanceNow.Pageobjects.HomePage;
import com.NhanceNow.Pageobjects.LoginPage;
import com.NhanceNow.Settings.Settings;

/**
 * @author IDS055
 *
 */
public class SettingsPageTest extends BaseClass
{
	LoginPage signin=new LoginPage();
	HomePage homepage;
	Settings setting;
	
	
	@Test
	public void ValidateEditprofileBtn() throws InterruptedException
	{
		signin=new LoginPage();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage=new HomePage();
		homepage.settings();
		setting=new Settings();
		setting.EditProfileButton();
		Thread.sleep(5000);
		String acturl=driver.getCurrentUrl();
		String expturl="https://dev.nhancenow.com/nhance-web-admin/settings/profile/816b2f8e-c47c-4f78-b481-ad6916e35bf7";
		if(acturl.equals(expturl))
			test.pass("edit profile button is working and user is successfully landed on Edit profile page");
		Assert.assertEquals(acturl, expturl);
	}
}
