/**
 * 
 */
package com.NhanceNow.Pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NhanceNow.ActionDriver.ActionClass;
import com.NhanceNow.Base.BaseClass;

/**
 * @author IDS055
 *
 */
public class ForgotPassword extends BaseClass
{
	@FindBy(name="email")
	WebElement forgotpswdemail;
	
	@FindBy(id="kt_login_forgot_cancel")
	WebElement loginbtnfromfrgtpswd;
	
	@FindBy(id="kt_login_forgot_submit")
	WebElement sendotpBtn;
	
	@FindBy(name="otp")
	WebElement enterotp;
	
	@FindBy(xpath="//button[text()=' Resend OTP ']")
	WebElement resendotpBtn;
	
	@FindBy(xpath="//button[text()=' Verify OTP ']")
	WebElement verifyotp;
	
	@FindBy(name="password")
	WebElement enterpswd;
	
	@FindBy(name="confirmPassword")
	WebElement confirmpswd;
	
	@FindBy(xpath="//button[text()=' Change Password ']")
	WebElement changepswdBtn;
	
	@FindBy(xpath="//h3[text()='Password Reset success']")
	WebElement Resetpasswordsucces;
	
	@FindBy(xpath="//p[text()='Otp re-sent successfully']")
	WebElement resentotpmsg;
	
	@FindBy(xpath="//p[@class='notifier__notification-message'][text()='User does not exist']")
	WebElement unregisteredErrormsg;
	
	@FindBy(xpath="//div[text()=' Email is invalid ']")
	WebElement InvalidEmailErrormsg;
	
	@FindBy(xpath="//div[text()=' Email is required ']")
	WebElement BlankEmailErrorMsg;
	
	@FindBy(xpath="//p[@class='notifier__notification-message'][text()='Otp sent successfully']")
	WebElement SentOtpMsg;
	
	@FindBy(xpath="//h3[text()=' One Time Password ']")
	WebElement OneTimePassword;
	
	@FindBy(xpath="//a[text()=' Back ']")
	WebElement BackBtn;
	
	@FindBy(xpath="//h3[text()=' Forgotten Password ']")
	WebElement ForgottenPasswordPage;
	
	@FindBy(xpath="//div[text()=' Otp is required ']")
	WebElement OtpErrorMsg;
	
	@FindBy(xpath="//p[@class='notifier__notification-message'][text()='Invalid OTP']")
	WebElement invalidotperrorMsg;
	
	@FindBy(xpath="//h3[text()=' Reset Password ']")
	WebElement resetpasswordpage;
	
	@FindBy(xpath="//a[@routerlink='/auth/login']")
	WebElement LoginBtnFromResetpswd;
	
	@FindBy(xpath="//div[text()=' Password is required ']")
	WebElement BlankPswdErrorMsg;
	
	@FindBy(xpath="//div[text()=' Confirm Password is required ']")
	WebElement BlankConfirmPswdErrorMsg;
	
	@FindBy(xpath="//p[@class='notifier__notification-message'][text()='Passwords do not match']")
	WebElement PasswordMismatchErrorMsg;
		
	ActionClass action=new ActionClass();
	
	public ForgotPassword() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginBtn()
	{
		action.JSClick(driver, loginbtnfromfrgtpswd);
	}
	
	public boolean Emailtextbox(String mail)
	{
		return action.type(forgotpswdemail, mail);
	}
	
	public String unregisteredUser(String mail)
	{
		forgotpswdemail.sendKeys(mail);
		action.JSClick(driver, sendotpBtn);
		action.explicitWait(driver, unregisteredErrormsg,5);
		return unregisteredErrormsg.getText();
	
	}
	
	public String InvalidEmail(String mail)
	{
		forgotpswdemail.sendKeys(mail);
		action.JSClick(driver, sendotpBtn);
		
		return InvalidEmailErrormsg.getText();
	
	}
	
	public void sendotp(String email)
	{
		forgotpswdemail.sendKeys(email);
		action.JSClick(driver, sendotpBtn);
		
	}
	
	public void enterotp(String otp)
	{
		enterotp.sendKeys(otp);
		action.JSClick(driver, verifyotp);
	}
	
	public String resentotp()
	{
		action.JSClick(driver, resendotpBtn);
		action.explicitWait(driver, resentotpmsg, 5);
		return resentotpmsg.getText();
						
	}
	
	public String Resetpasswordsucces(String pswd,String confmpswd)
	{
		enterpswd.sendKeys(pswd);
		confirmpswd.sendKeys(confmpswd);
		action.JSClick(driver, changepswdBtn);
		action.explicitWait(driver, Resetpasswordsucces, 5);
		return Resetpasswordsucces.getText();		
	}
	
	public String ErrorForBlankEmail()
	{
		forgotpswdemail.click();
		sendotpBtn.click();
		action.explicitWait(driver, BlankEmailErrorMsg, 5);
		return BlankEmailErrorMsg.getText();
	}
	
	public boolean SendOtpButton()
	{
		action.explicitWait(driver, OneTimePassword, 5);
		return OneTimePassword.isDisplayed();
		
	}
	
	public String OtpSentSuccessfully()
	{
		action.explicitWait(driver, SentOtpMsg, 5);
		return SentOtpMsg.getText();
	}
	
	public boolean BackButton()
	{
		action.JSClick(driver, BackBtn);
		return ForgottenPasswordPage.isDisplayed();
	}
	
	public boolean Otptextbox(String Otp)
	{
		return action.type(enterotp, Otp);
	}
	
	public String BlankOtpErrorMsg()
	{
		enterotp.sendKeys(Keys.ENTER);
		verifyotp.click();
		action.explicitWait(driver, OtpErrorMsg, 5);
		return OtpErrorMsg.getText();
		
	}
	
	public String InvalidOtpErrorMsg(String Otp)
	{
		enterotp.sendKeys(Otp);
		action.JSClick(driver, verifyotp);
		action.explicitWait(driver, invalidotperrorMsg, 10);
		return invalidotperrorMsg.getText();
		
	}
	
	public boolean verifyOtpBtn()
	{
		action.explicitWait(driver, resetpasswordpage, 5);
		return resetpasswordpage.isDisplayed();
	}
	
	public void loginBtnFromResetPswd()
	{
		action.JSClick(driver, LoginBtnFromResetpswd);
		
	}
	
	public boolean PasswordTextbox(String newpw)
	{
		return action.type(enterpswd, newpw);
	}
	
	public boolean ConfirmPasswordTextbox(String newpw)
	{
		return action.type(confirmpswd, newpw);
	}
	
	public String BlankPasswordErrorMsg()
	{
		enterpswd.click();
		confirmpswd.click();
		action.explicitWait(driver, BlankPswdErrorMsg, 5);
		return BlankPswdErrorMsg.getText();
		
	}
	
	public String BlankConfirmPasswordErrorMsg()
	{
		confirmpswd.click();
		enterpswd.click();
		action.explicitWait(driver, BlankConfirmPswdErrorMsg, 5);
		return BlankConfirmPswdErrorMsg.getText();
		
	}
	
	public String PasswordMismatchErrorMsg(String pswd,String confmpswd)
	{
		enterpswd.sendKeys(pswd);
		confirmpswd.sendKeys(confmpswd);
		action.JSClick(driver, changepswdBtn);
		action.explicitWait(driver, PasswordMismatchErrorMsg, 10);
		return PasswordMismatchErrorMsg.getText();		
	}

}
