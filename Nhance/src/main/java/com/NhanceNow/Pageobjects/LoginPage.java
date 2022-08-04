/**
 * 
 */
package com.NhanceNow.Pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.NhanceNow.ActionDriver.ActionClass;
import com.NhanceNow.Base.BaseClass;

/**
 * @author IDS055
 *
 */
public class LoginPage extends BaseClass
{
	@FindBy(name="email")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//button[text()=' Sign In ']")
	WebElement signinbtn;
	
	@FindBy(id="kt_login_forgot")
	WebElement forgotpswd;
	
	@FindBy(xpath="//img[@class='max-h-70px']")
	WebElement logo;
	
	@FindBy(name="otp")
	WebElement twostepotp;
	
	@FindBy(xpath="//a[text()='Verify OTP']")
	WebElement verifyotp;
	
	@FindBy(xpath="//p[@class='notifier__notification-message'][text()='We cannot find an account with that username']")
	WebElement UnregisteredUserErrormsg;
	
	@FindBy(xpath="//div[text()=' Email is required ']")
	WebElement EmailErrormsg;
	
	@FindBy(xpath="//div[text()=' Password is required ']")
	WebElement PasswordErrormsg;
	
	@FindBy(xpath="//p[@class='notifier__notification-message']")
	WebElement InvalidPasswordErrormsg;
	
	@FindBy(xpath="//a[text()='Resend OTP']")
	WebElement ResendOtpBtn;
	
	@FindBy(xpath="//p[@class='notifier__notification-message'][text()='otp resent successfully']")
	WebElement OtpResentSuccessfully;
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	ActionClass action=new ActionClass();
	
	public void login (String un,String pw)
	{
		//action.pageLoadTimeOut(driver, 10);
		Username.sendKeys(un);
		Password.sendKeys(pw);
		action.JSClick(driver, signinbtn);
		
	}
	
	public HomePage twostepverification(String otp,HomePage homepage)
	{
		twostepotp.sendKeys(otp);
		action.JSClick(driver, verifyotp);
		action.pageLoadTimeOut(driver, 5);
		return homepage;
	
	}
	
	public boolean SigninBtnWithBlankUN(String pw)
	{
		
		Password.sendKeys(pw);
		return signinbtn.isEnabled();
	}
	
	public boolean SigninBtnWithBlankPswd(String un)
	{
		Username.sendKeys(un);
		return signinbtn.isEnabled();
	}
	
	public void forgotpassword()
	{
		action.JSClick(driver, forgotpswd);
	}	
	
	public boolean logo()
	{
		return logo.isDisplayed();
		
	}
	
	public boolean loginwithInvalidUN(String wrongun,String pw)
	{
		Username.sendKeys(wrongun);
		Password.sendKeys(pw);
		action.JSClick(driver, signinbtn);
		action.explicitWait(driver, UnregisteredUserErrormsg, 5);
		return UnregisteredUserErrormsg.isDisplayed();
	}
	
	public boolean loginwithInvalidpswd(String un,String wrongpswd)
	{
		Username.sendKeys(un);
		Password.sendKeys(wrongpswd);
		action.JSClick(driver, signinbtn);
		action.explicitWait(driver, InvalidPasswordErrormsg, 5);
		return InvalidPasswordErrormsg.isDisplayed();
	}
	
	public boolean usernametextbox(String un)
	{
		return action.type(Username, un);
	}
	
	public boolean passwordtextbox(String pw)
	{
		return action.type(Password, pw);
	}
	
	public String PageTitle()
	{
		return driver.getTitle();
	}
	
	public String BlankUsername(String pw) throws InterruptedException
	{
		Username.click();
		//action.JSClick(driver, Username);
		Password.click();
		Thread.sleep(2000);
		//action.JSClick(driver, Password);
		return EmailErrormsg.getText();
	}
	
	public String BlankPassword(String un)
	{
		Username.sendKeys(un);
		Password.click();
		Username.click();
		return PasswordErrormsg.getText();
	}
	
	public String ErrorMsgForInvalidLoginDetails(String un,String pw)
	{
		Username.sendKeys(un);
		Password.sendKeys(pw);
		action.JSClick(driver, signinbtn);
		action.explicitWait(driver, UnregisteredUserErrormsg, 5);
		return UnregisteredUserErrormsg.getText();

	}
	
	public String ResendOtpButton()
	{
		action.JSClick(driver, ResendOtpBtn);
		action.explicitWait(driver, OtpResentSuccessfully, 5);
		return OtpResentSuccessfully.getText();
		
	}

}
