/**
 * 
 */
package com.NhanceNow.LoginTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.NhanceNow.Base.BaseClass;
import com.NhanceNow.Pageobjects.ForgotPassword;
import com.NhanceNow.Pageobjects.HomePage;
import com.NhanceNow.Pageobjects.LoginPage;

/**
 * @author IDS055
 *
 */
public class ForgotpasswordTest extends BaseClass
{
	LoginPage signin;
	ForgotPassword frgtpswd;
	HomePage homepage;
	
	
	@Test
	public void verifychangepswd() throws InterruptedException
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		frgtpswd.enterotp(prop.getProperty("OTP"));
		String acttext=frgtpswd.Resetpasswordsucces(prop.getProperty("newpassword"), prop.getProperty("newpassword"));
		String exptext="Password Reset success";
		if(acttext.equals(exptext))
			test.pass("password changed successfully");
		Assert.assertEquals(acttext, exptext);
	}
	
	@Test
	public void verifyloginbtnFromForgotPasswordPage()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.loginBtn();
		String acturl=driver.getCurrentUrl();
		String expturl="https://dev.nhancenow.com/nhance-web-admin/auth/login";
		if(acturl.equals(expturl))
			test.pass("Login button on forgot password page is enabled and user is succesfully navigated to login page");
		Assert.assertEquals(acturl, expturl);
	}
	
	@Test
	public void VerifyResendotpBtn() throws InterruptedException
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		
		String acttext=frgtpswd.resentotp();
		String expttext="Otp re-sent successfully";
		if(acttext.equals(expttext))
			test.pass("Resend otp button is enable and Otp resent succesfully");
		Assert.assertEquals(acttext, expttext);		
	}
	
	@Test
	public void verifyEmailTextbox()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		boolean b=frgtpswd.Emailtextbox(prop.getProperty("username"));
		if(b)
			test.pass("email textbox is enable");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifyErrormsgForUnregisteredUser()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		String acttext=frgtpswd.unregisteredUser(prop.getProperty("wrongusername"));
		String expttext="User does not exist";
		if(acttext.equals(expttext))
			test.pass("Error message for unregistered user is verified succesfully");
		Assert.assertEquals(acttext, expttext);
	}
	
	@Test
	public void VerifyErrormsgForInvalidEmail()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		String acttext=frgtpswd.InvalidEmail(prop.getProperty("invalidEmail"));
		String expttext="Email is invalid";
		if(acttext.equals(expttext))
			test.pass("Error message for Invalid email is verified succesfully");
		Assert.assertEquals(acttext, expttext);
	}
	
	@Test
	public void VerifyErrorMsgForBlankEmail()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		String acttext=frgtpswd.ErrorForBlankEmail();
		String expttext="Email is required";
		if(acttext.equals(expttext))
			test.pass("Error msg for blank email field is verified succesfully");
		Assert.assertEquals(acttext, expttext);
	}
	
	@Test
	public void VerifySendOtpBtn()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		boolean b=frgtpswd.SendOtpButton();
		if(b)
			test.pass("User is successfully navigated to One Time Password Page");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifyOtpSentSuccessfullyMsg()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		String actmsg=frgtpswd.OtpSentSuccessfully();
		String exptmsg="Otp sent successfully";
		if(actmsg.equals(exptmsg))
			test.pass("Otp Sent successfully msg is verified successfully");
		Assert.assertEquals(actmsg, exptmsg);
	}
	
	@Test
	public void VerifyBackButton()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		boolean b=frgtpswd.BackButton();
		if(b)
			test.pass("Back Button on one time password page is working and user is successfully navigated back to forgot password page");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifyOtpTextbox()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		boolean b=frgtpswd.Otptextbox(prop.getProperty("OTP"));
		if(b)
			test.pass("otp textbox is enable and otp entered successfully");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifyErrorMsgForBlankOtp()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		String actmsg=frgtpswd.BlankOtpErrorMsg();
		String exptmsg="Otp is required";
		if(actmsg.equals(exptmsg))
			test.pass("Error message for blank otp field is verified successfully");
		Assert.assertEquals(actmsg, exptmsg);
	}
	
	@Test
	public void VerifyInvalidOtpErrorMsg()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		String actmsg=frgtpswd.InvalidOtpErrorMsg(prop.getProperty("wrongOtp"));
		String exptmsg="Invalid OTP";
		if(actmsg.equals(exptmsg))
			test.pass("Error message for invalid otp field is verified successfully");
		Assert.assertEquals(actmsg, exptmsg);
	}
	
	@Test
	public void ValidateVerifyOtpButton()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		frgtpswd.enterotp(prop.getProperty("OTP"));
		boolean b=frgtpswd.verifyOtpBtn();
		if(b)
			test.pass("Verify otp button is enabled and user is successfully navigated to reset password page");
		Assert.assertTrue(b);
	}
	
	@Test
	public void verifyloginbtnFromResetPasswordPage() throws InterruptedException
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		Thread.sleep(5000);
		frgtpswd.sendotp(prop.getProperty("username"));
		Thread.sleep(5000);
		frgtpswd.enterotp(prop.getProperty("OTP"));
		Thread.sleep(5000);
		frgtpswd.loginBtnFromResetPswd();
		Thread.sleep(5000);
		String acturl=driver.getCurrentUrl();
		String expturl="https://dev.nhancenow.com/nhance-web-admin/auth/login";
		if(acturl.equals(expturl))
			test.pass("Login button on Reset password page is enabled and user is succesfully navigated to login page");
		Assert.assertEquals(acturl, expturl);
	}
	
	@Test
	public void VerifyPasswordTextbox()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		frgtpswd.enterotp(prop.getProperty("OTP"));
		boolean b=frgtpswd.PasswordTextbox(prop.getProperty("newpassword"));
		if(b)
			test.pass("Password textbox from reset password page is enable and user is able to enter value in it");
		Assert.assertTrue(b);
		
	}
	
	@Test
	public void VerifyConfirmPasswordTextbox()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		frgtpswd.enterotp(prop.getProperty("OTP"));
		boolean b=frgtpswd.ConfirmPasswordTextbox(prop.getProperty("newpassword"));
		if(b)
			test.pass("confirm Password textbox from reset password page is enable and user is able to enter value in it");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifyBlankPswdErrorMsg()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		frgtpswd.enterotp(prop.getProperty("OTP"));
		String acttext=frgtpswd.BlankPasswordErrorMsg();
		String exptmsg="Password is required";
		if(acttext.equals(exptmsg))
			test.pass("Error msg for blank password textbox is verified successfully");
		Assert.assertEquals(acttext, exptmsg);
	}
	
	@Test
	public void VerifyBlankConfirmPswdErrorMsg()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		frgtpswd.enterotp(prop.getProperty("OTP"));
		String acttext=frgtpswd.BlankConfirmPasswordErrorMsg();
		String exptmsg="Confirm Password is required";
		if(acttext.equals(exptmsg))
			test.pass("Error msg for confirm blank password textbox is verified successfully");
		Assert.assertEquals(acttext, exptmsg);
	}
	
	@Test
	public void VerifyPasswordMismatchErrorMsg()
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.forgotpassword();
		frgtpswd.sendotp(prop.getProperty("username"));
		frgtpswd.enterotp(prop.getProperty("OTP"));
		String acttext=frgtpswd.PasswordMismatchErrorMsg(prop.getProperty("password"), prop.getProperty("wrongpassword"));
		String exptmsg="Passwords do not match";
		if(acttext.equals(exptmsg))
			test.pass("Error msg for Password and confirm password mismatch is verified successfully");
		Assert.assertEquals(acttext, exptmsg);
	}
	
	@Test
	public void VerifyLoginWithNewPassword() throws InterruptedException
	{
		signin=new LoginPage();
		frgtpswd=new ForgotPassword();
		signin.login(prop.getProperty("username"), prop.getProperty("newpassword"));
        signin.twostepverification(prop.getProperty("OTP"), homepage);
		
		Thread.sleep(2000);
		String actualurl=driver.getCurrentUrl();
		String expectedurl="https://dev.nhancenow.com/nhance-web-admin/dashboard";
		
		if(actualurl.equals(expectedurl))
			test.pass("user is succesfully loged in with changed password");
		else
			test.fail("user is not logged in");
		Assert.assertEquals(actualurl, expectedurl);
	}

}
