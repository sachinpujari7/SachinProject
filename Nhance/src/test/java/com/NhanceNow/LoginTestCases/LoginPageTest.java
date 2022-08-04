/**
 * 
 */
package com.NhanceNow.LoginTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.NhanceNow.Base.BaseClass;
import com.NhanceNow.Pageobjects.HomePage;
import com.NhanceNow.Pageobjects.LoginPage;
import com.NhanceNow.dataprovider.DataProviders;
import com.aventstack.extentreports.Status;



/**
 * @author IDS055
 *
 */
public class LoginPageTest extends BaseClass
{
	private LoginPage signin;
	private HomePage homepage;

	@Test
	public void usernametxtbxiseditable()
	{
		signin=new LoginPage();
		boolean b=signin.usernametextbox(prop.getProperty("username"));
		
		if(b)
		    test.pass("Username textbox is enable");
		else
			test.fail("Username textbox is not enable");
		Assert.assertTrue(b);
		
	}
	
	@Test
	public void pswdtxtbxiseditable()
	{
		signin=new LoginPage();
		boolean b=signin.passwordtextbox(prop.getProperty("password"));
		if(b)
		    test.pass("User is able to enter value in password textbox");
		else
			test.fail("password textbox is not enable");
		
	}
	
	@Test(dataProvider = "credentials",dataProviderClass = DataProviders.class)
	public void logintest(String Uname,String pswd) throws InterruptedException
	{
		signin=new LoginPage();
		signin.login(Uname, pswd);
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		
		Thread.sleep(2000);
		String actualurl=driver.getCurrentUrl();
		String expectedurl="https://dev.nhancenow.com/nhance-web-admin/dashboard";
		
		if(actualurl.equals(expectedurl))
			test.pass("user is succesfully loged in");
		else
			test.fail("user is not logged in");
		Assert.assertEquals(actualurl, expectedurl);
		
			
	}
	
	@Test
	public void logintestWithoutDataprovider() throws InterruptedException
	{
		signin=new LoginPage();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
        signin.twostepverification(prop.getProperty("OTP"), homepage);
		
		Thread.sleep(2000);
		String actualurl=driver.getCurrentUrl();
		String expectedurl="https://dev.nhancenow.com/nhance-web-admin/dashboard";
		
		if(actualurl.equals(expectedurl))
			test.pass("user is succesfully loged in");
		else
			test.fail("user is not logged in");
		Assert.assertEquals(actualurl, expectedurl);
	}
	@Test
	public void forgotpassword()
	{
		signin=new LoginPage();
		signin.forgotpassword();
		String acturl=driver.getCurrentUrl();
		String expturl="https://dev.nhancenow.com/nhance-web-admin/auth/forgot-password";
		
		if(acturl.equals(expturl))
			test.pass("user is succesfully navigated to forgot password page");
		Assert.assertEquals(acturl, expturl);
		
	}
	
	@Test
	public void logoisdisplayed()
	{
		signin=new LoginPage();
		boolean b=signin.logo();
		
		if(b)
			test.pass("Logo is Displayed");
	    else
			test.fail("Logo is not Displayed");
		Assert.assertTrue(b);
		
	}
	
	@Test
	public void LoginTestWithInvalidUN()
	{
		signin=new LoginPage();
		boolean actmsg=signin.loginwithInvalidUN(prop.getProperty("wrongusername"), prop.getProperty("password"));
		if(actmsg)
			test.log(Status.PASS, "User is not able to signin with invalid Username");
		Assert.assertTrue(actmsg);
				
	}
	
	@Test
	public void loginTestWithInvalidPswd()
	{
		signin=new LoginPage();
		boolean actmsg=signin.loginwithInvalidpswd(prop.getProperty("username"), prop.getProperty("wrongpassword"));
		if(actmsg)
			test.log(Status.PASS, "User is not able to signin with invalid password");
		Assert.assertTrue(actmsg);
				
	}
	
	@Test
	public void verifyPageTitle()
	{
		signin=new LoginPage();
		String actTitle=signin.PageTitle();
		String exptTitle="NHANCE NOW - Business";
		Assert.assertEquals(actTitle, exptTitle);
		if(actTitle.equals(exptTitle))
			test.log(Status.PASS, "Page Title verified successfully");
		Assert.assertEquals(actTitle, exptTitle);
		
	}	
	
	@Test
	public void verifySigninBtnWithBlankUN()
	{
		signin=new LoginPage();
		boolean b=signin.SigninBtnWithBlankUN(prop.getProperty("password"));
		System.out.println(b);
		if(b==false)
			test.log(Status.PASS, "SignInBtn is disabled for Blank Username field");
		Assert.assertFalse(b);
	}
	
	@Test
	public void verifySigninBtnWithBlankPswd()
	{
		signin=new LoginPage();
		boolean d=signin.SigninBtnWithBlankPswd(prop.getProperty("username"));
		if(d==false)
			test.log(Status.PASS, "SignInBtn is disabled for Blank password field");
		Assert.assertFalse(d);
	}
	
	@Test
	public void ErrorMsgForBlankUN() throws InterruptedException
	{
		signin=new LoginPage();
		String actmsg=signin.BlankUsername(prop.getProperty("password"));
		String exptmsg="Email is required";
		if(actmsg.equals(exptmsg))
			test.log(Status.PASS, "Error msg for blank username is verified");
		Assert.assertEquals(actmsg, exptmsg);
	}
	
	@Test
	public void ErrorMsgForBlankPswd()
	{
		signin=new LoginPage();
		String actmsg=signin.BlankPassword(prop.getProperty("username"));
		String exptmsg="Password is required";
		if(actmsg.equals(exptmsg))
			test.log(Status.PASS, "Error msg for blank password is verified");
		Assert.assertEquals(actmsg, exptmsg);
	}
	
	@Test
	public void VerifyErrorMsgForInvalidLoginDetails()
	{
		signin=new LoginPage();
		String actmsg=signin.ErrorMsgForInvalidLoginDetails(prop.getProperty("wrongusername"), prop.getProperty("wrongpassword"));
		String exptmsg="We cannot find an account with that username";
		if(actmsg.equals(exptmsg))
			test.log(Status.PASS, "Error message for invalid login details is verified succesfully");
		Assert.assertEquals(actmsg, exptmsg);
	}
	
	@Test
	public void VerifyResendOtpButtonOnTwoStepVerification()
	{
		signin=new LoginPage();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		String actmsg=signin.ResendOtpButton();
		String exptmsg="otp resent successfully";
		if(actmsg.equals(exptmsg))
			test.log(Status.PASS, "Resend Otp button is enabled and otp resent successfully");
		Assert.assertEquals(actmsg, exptmsg);
	}
	


}
