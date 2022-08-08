/**
 * 
 */
package com.NhanceNow.SettingsTestCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.awt.AWTException;
import com.NhanceNow.Base.BaseClass;
import com.NhanceNow.Pageobjects.HomePage;
import com.NhanceNow.Pageobjects.LoginPage;
import com.NhanceNow.Settings.EditProfile;
import com.NhanceNow.Settings.Settings;

/**
 * @author IDS055
 *
 */
public class EditProfilePageTest extends BaseClass
{
	LoginPage signin;
	HomePage homepage;
	Settings setting;
	EditProfile edit;
	
	
	@Test
	public void VerifyBackButtonOnEditProfile()
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.BackButton();
		String acturl=driver.getCurrentUrl();
		String expturl="https://dev.nhancenow.com/nhance-web-admin/settings";
		if(acturl.equals(expturl))
			test.pass("Back Button on edit profile page is working and user is navigated back to settings page");
		Assert.assertEquals(acturl, expturl);
	}
	
	@Test
	public void VerifyNameTextBoxOnEditProfile()
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		boolean b=edit.NameTextbox(prop.getProperty("NameForEditProfile"));
		if(b)
			test.pass("Name textbox on edit profile page is enable and user is able to enter value in it");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifyErrorMsgForBlankNameTextbox() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		String acttext=edit.BlankNameTextboxErrorMsg();
		String expttext="This field is required";
		if(acttext.equals(expttext))
			test.pass("error message for blank name textbox is verified successfully");
		Assert.assertEquals(acttext, expttext);
	}
	
	@Test
	public void VerifyEditBtnForChangeMobileNumber()
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		boolean b=edit.EditBtnForMobileNumber();
		if(b)
			test.pass("Edit button for change mobile number is working and user is successfully navigated to Change Mobile Number page");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifyBrowseButton() throws InterruptedException, AWTException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		boolean b=edit.BrowseButton(prop.getProperty("ProfileImagePath"));
		if(b)
			test.pass("Browse button is working and profile image is uploaded");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifyErrorMsgForLargeImageFiles() throws InterruptedException, AWTException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		String acttext=edit.ErrorMsgForLargerFiles();
		String expttext="Maximum file size is 1MB";
		boolean b=false;
		if(acttext.contains(expttext))
		{
			b=true;
			test.pass("error message for File size exceeding 1MB is verified successfully");
			Assert.assertTrue(b);
		}
		else
			Assert.assertTrue(b);
		
	}
	
	@Test
	public void VerifyEditBtnForChangeEmail()
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		boolean b=edit.EditBtnForChangeEmail();
		if(b)
			test.pass("Edit button for change mobile number is working and user is successfully navigated to Change Mobile Number page");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifyCountryDropdownForMobileNumber()
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForMobileNumber();
		boolean b=edit.CountryDropdownForMobileNumber();
		if(b)
			test.pass("Edit button for change mobile number is working and user is successfully navigated to Change Mobile Number page");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifySelectCountryFromDropdown() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForMobileNumber();
		boolean b=edit.SelectDropdownValue();
		Thread.sleep(1000);
		if(b)
			test.pass("User is able to select country code from country dropdown and is verified");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifyErrorMsgForBlankMobileNumTextbox() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForMobileNumber();
		String acttext=edit.ErrorMsgForBlankMobileNum();
		String expttext="This field is required";
		if(acttext.equals(expttext))
			test.pass("error message for blank Mobile Number textbox is verified successfully");
		Assert.assertEquals(acttext, expttext);
	}
	
	@Test
	public void VerifyMobileNumberTextboxisEnable() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForMobileNumber();
		boolean b=edit.MobileNumberTextbox(prop.getProperty("ChangeMobileNumber"));
		if(b)
			test.pass("Mobile number textbox is enable and user is able to enter value in it");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifySendOtpButton() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForMobileNumber();
		edit.MobileNumberTextbox(prop.getProperty("ChangeMobileNumber"));
		String acttext=edit.SendOtpButton();
		String expttext="Otp sent successfully";
		if(acttext.equals(expttext))
			test.pass("Send otp button is working and otp sent successfully");
		Assert.assertEquals(acttext, expttext);
	}
	
	@Test
	public void VerifyEnterOtpTextboxisEnable() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForMobileNumber();
		edit.MobileNumberTextbox(prop.getProperty("ChangeMobileNumber"));
		edit.SendOtpButton();
		boolean b=edit.EnterOtpTextbox(prop.getProperty("OTP"));
	
		if(b)
			test.pass("Enter otp textbox is enable and user is able to enter OTP in it");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifyErrorMsgForBlankEnterOtpTextbox() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForMobileNumber();
		edit.MobileNumberTextbox(prop.getProperty("ChangeMobileNumber"));
		edit.SendOtpButton();
		String acttext=edit.ErrorMsgForBlankEnterOtpForChangeMobile();
	    String expttext="This field is required";
		if(acttext.equals(expttext))
			test.pass("Error message for blank Enter otp textbox is verified");
		Assert.assertEquals(acttext, expttext);
	
	}
	
	@Test
	public void VerifyErrorMsgForInvalidOtp() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForMobileNumber();
		edit.MobileNumberTextbox(prop.getProperty("ChangeMobileNumber"));
		edit.SendOtpButton();
		String acttext=edit.InvalidOtpErrorMsg(prop.getProperty("wrongOtp"));
	    String expttext="Invalid OTP";
		if(acttext.equals(expttext))
			test.pass("Error message for invalid otp is verified");
		Assert.assertEquals(acttext, expttext);
	
	}
	
	@Test
	public void VerifyResendOtpButton() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForMobileNumber();
		edit.MobileNumberTextbox(prop.getProperty("ChangeMobileNumber"));
		edit.SendOtpButton();
		String acttext=edit.ResendOtpButton();
	    String expttext="Otp re-sent successfully";
		if(acttext.equals(expttext))
			test.pass("Resend otp button is enabled and Otp Resent successfully message is verified");
		Assert.assertEquals(acttext, expttext);
	
	}
	
	@Test
	public void ValidateProfileUpdatedMsgForChangeMobile() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForMobileNumber();
		edit.MobileNumberTextbox(prop.getProperty("ChangeMobileNumber1"));
		edit.SendOtpButton();
		String acttext=edit.VerifyOtpButton(prop.getProperty("OTP"));
	    String expttext="Profile has been updated";
		if(acttext.equals(expttext))
			test.pass("Verify otp button is enabled and Profile has been updated message is verified");
		Assert.assertEquals(acttext, expttext);
	
	}
	
	@Test
	public void ValidateErrorMsgForAlreadyExistedUser() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForMobileNumber();
		edit.MobileNumberTextbox(prop.getProperty("ChangeMobileNumber"));
		edit.SendOtpButton();
		String acttext=edit.ExistedUserErrorMsg(prop.getProperty("OTP"));
	    String expttext="User already exist with this mobile";
		if(acttext.equals(expttext))
			test.pass("Error message for Already existed user is verified");
		Assert.assertEquals(acttext, expttext);
	
	}
	
	@Test
	public void VerifyChangeEmailTextBox()
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForChangeEmail();
		boolean b=edit.EmailTextbox(prop.getProperty("ChangeEmail"));
		if(b)
			test.pass("Email Textbox is enable and user is able to enter value in it");
		Assert.assertTrue(b);
	}
	
	@Test
	public void ValidateSendOtpButtonForChangeEmail()
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForChangeEmail();
		String acttext=edit.SendOtpBtnForChangeEmail(prop.getProperty("ChangeEmail"));
	    String expttext="Otp sent successfully";
		if(acttext.equals(expttext))
			test.pass("Send otp button is enabled and Otp sent successfully");
		Assert.assertEquals(acttext, expttext);
	}
	
	@Test
	public void ValidateErrorMsgForBlankEmailTextbox()
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForChangeEmail();
		String acttext=edit.ErrorMsgForBlankEmailTextbox();
	    String expttext="This field is required";
		if(acttext.equals(expttext))
			test.pass("Error message for blank email textbox is verified successfully");
		Assert.assertEquals(acttext, expttext);
	}
	
	@Test
	public void ValidateEnterOtpTextboxForChangeEmail()
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForChangeEmail();
		boolean b=edit.EnterOtpTextboxForChangeEmail(prop.getProperty("ChangeEmail"), prop.getProperty("OTP"));
		if(b)
			test.pass("Enter Otp textbox for change email is enabled and user is able to enter value in it");
		Assert.assertTrue(b);;
	}
	
	@Test
	public void ValidateErrorMsgForBlankEnterOtpTxtbxForChangeEmail()
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForChangeEmail();
		String actText=edit.ErrorMsgForBlankEnterOtpTxtbxForChangeEmail(prop.getProperty("ChangeEmail"));
		String expttext="This field is required";
		if(actText.equals(expttext))
			test.pass("Error message for blank enter otp textbox is verified successfully");
		Assert.assertEquals(actText, expttext);
	}
	
	@Test
	public void ValidateErrorMsgForInvalidOtpForChangeEmail()
	{
		signin=new LoginPage();
		homepage=new HomePage();
		setting=new Settings();
		edit=new EditProfile();
		signin.login(prop.getProperty("username"), prop.getProperty("password"));
		signin.twostepverification(prop.getProperty("OTP"), homepage);
		homepage.settings();
		setting.EditProfileButton();
		edit.EditBtnForChangeEmail();
		String actText=edit.InvalidOtpErrorMsgForChangeEmail(prop.getProperty("ChangeEmail"), prop.getProperty("wrongOtp"));
		String expttext="Invalid OTP";
		if(actText.equals(expttext))
			test.pass("Error message for Invalid otp textbox is verified successfully");
		Assert.assertEquals(actText, expttext);
	}
   
}
