/**
 * 
 */
package com.NhanceNow.Settings;

import java.awt.AWTException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.NhanceNow.ActionDriver.ActionClass;
import com.NhanceNow.Base.BaseClass;

/**
 * @author IDS055
 *
 */
public class EditProfile extends BaseClass
{
	@FindBy(id="formly_8_input_firstName_1")
	WebElement nametextbox;
	
	@FindBy(xpath="//span[text()='Browse']")
	WebElement BrowseBtn;
	
	@FindBy(xpath="//i[@class='flaticon-delete']")
	WebElement ProfileDelete;
	
	@FindBy(xpath="//div[@class='doc-icon']")
	WebElement ProfileIcon;
	
	@FindBy(xpath="(//div[@class='input-group-append cursor-pointer']//span)[1]")
	WebElement MobileEditBtn;
	
	@FindBy(xpath="(//div[@class='input-group-append cursor-pointer']//span)[2]")
	WebElement EmailEditBtn;
	
	@FindBy(id="example-modal-sizes-title-lg")
	WebElement ChangeMobilePageText;
	
	@FindBy(xpath="(//div[@class='iti__selected-flag dropdown-toggle'])[2]")
	WebElement CountryDropdown;
	
	@FindBy(xpath="//ul[@class='iti__country-list']")
	WebElement DropdownList;
	
	@FindBy(xpath="//ul[@class='iti__country-list']//li")
	List<WebElement> CountryList;
	
	@FindBy(xpath="(//input[@placeholder='Mobile Number'])[2]")
	WebElement MobileTextbox;
	
	@FindBy(xpath="//span[@class='display-block']")
	WebElement CloseBtn;
	
	@FindBy(xpath="//button[text()=' Send OTP ']")
	WebElement SendOtpBtn;
	
	@FindBy(xpath="//div[text()=' Change Email ']")
	WebElement ChangeEmailPageText;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement EmailTextbox;
	
	@FindBy(xpath="//input[@placeholder='Enter OTP']")
	WebElement EnterOtpTextbox;
	
	@FindBy(xpath="//button[text()=' Re-Send OTP ']")
	WebElement ResendOtpBtn;
	
	@FindBy(xpath="//button[text()=' Verify OTP ']")
	WebElement VerifyOtpBtn;
	
	@FindBy(xpath="//button[text()='Back']")
	WebElement BackBtn;
	
	@FindBy(xpath="//*[text()='Save']")
	WebElement SaveBtn;
	
	@FindBy(xpath="//*[text()='This field is required']")
	WebElement BlankNameErrorMsg;
	
	@FindBy(id="phone")
	WebElement PhoneLabel;
	
	@FindBy(xpath="//*[@class='notifier__notification-message'][text()='4.14MB Maximum file size is 1MB']")
	WebElement ErrorMsgForLargeFile;
	
	@FindBy(xpath="//*[text()='This field is required']")
	WebElement BlankMobileNumError;
	
	@FindBy(xpath="//div[text()='+1']")
	WebElement USCountryCode;
	
	@FindBy(xpath="//p[@class='notifier__notification-message'][text()='Otp sent successfully']")
	WebElement OtpSentMessage;
	
	@FindBy(xpath="//*[text()='This field is required']")
	WebElement ErrorMsgForMandatoryField;
	
	@FindBy(xpath="//*[@class='notifier__notification-message'][text()='Invalid OTP']")
	WebElement InvalidOtpError;
	
	@FindBy(xpath="//*[@class='notifier__notification-message'][text()='Otp re-sent successfully']")
	WebElement ResentOtpMsg;
	
	@FindBy(xpath="//*[@class='notifier__notification-message'][text()='Profile has been updated']")
	WebElement ProfileUpdatedMsg;
	
	@FindBy(xpath="//*[@class='notifier__notification-message'][text()='User already exist with this mobile']")
	WebElement ErrorMsgForExistedUser;
	
	public EditProfile()
	{
		PageFactory.initElements(driver, this);
	}
	
	ActionClass action=new ActionClass();
	
	public void BackButton()
	{
		action.JSClick(driver, BackBtn);
	}
	
	public boolean NameTextbox(String name)
	{
		nametextbox.clear();
		return action.type(nametextbox, name);
	}
	
	public String BlankNameTextboxErrorMsg() throws InterruptedException
	{
		Thread.sleep(2000);
		nametextbox.click();
		
		Thread.sleep(1000);
		nametextbox.clear();
		Thread.sleep(1000);
		nametextbox.click();
		action.JSClick(driver, SaveBtn);
		Thread.sleep(1000);
		return BlankNameErrorMsg.getText();
	}
	
	public boolean EditBtnForMobileNumber()
	{
		action.JSClick(driver, MobileEditBtn);
		action.explicitWait(driver, ChangeMobilePageText, 5);
		return ChangeMobilePageText.isDisplayed();
	}
	
	public boolean BrowseButton() throws InterruptedException, AWTException
	{
		ProfileDelete.click();
		Thread.sleep(1000);
        BrowseBtn.click();
		Thread.sleep(2000);
		action.RobotClass("C:\\Users\\IDS078\\Desktop\\NhanceTestData\\profile.jpg");
		action.explicitWait(driver, ProfileIcon, 10);
		return ProfileIcon.isDisplayed();
	}
	
	public boolean EditBtnForChangeEmail()
	{
		action.JSClick(driver, EmailEditBtn);
		action.explicitWait(driver, ChangeEmailPageText, 5);
		return ChangeEmailPageText.isDisplayed();
	}
	
	public String ErrorMsgForLargerFiles() throws InterruptedException, AWTException
	{
		ProfileDelete.click();
		Thread.sleep(1000);
        BrowseBtn.click();
		Thread.sleep(2000);
		action.RobotClass("C:\\Users\\IDS078\\Desktop\\NhanceTestData\\Big_Image.jpg");
		action.explicitWait(driver, ErrorMsgForLargeFile, 5);
		return ErrorMsgForLargeFile.getText();
	}
	
	public boolean CountryDropdownForMobileNumber()
	{
		CountryDropdown.click();
		action.explicitWait(driver, DropdownList, 5);
		return DropdownList.isDisplayed();
	}
	
	public boolean SelectDropdownValue()
	{
		CountryDropdown.click();
		List<WebElement> AllCountries=CountryList;
		for(WebElement ele:AllCountries)
		{
			if(ele.getText().contains(prop.getProperty("CountryValueText")))
			{
				ele.click();
				System.out.println("Country is selected");
				break;
			}
			
		}
		return USCountryCode.isDisplayed();
	}
	
	public String ErrorMsgForBlankMobileNum()
	{
		SendOtpBtn.click();
		return BlankMobileNumError.getText();
	}
	
	public boolean MobileNumberTextbox(String num)
	{
		return action.type(MobileTextbox, num);
	}
	
	public String SendOtpButton()
	{
		action.JSClick(driver, SendOtpBtn);
		action.explicitWait(driver, OtpSentMessage, 15);
		return OtpSentMessage.getText();
	}
	
	public boolean EnterOtpTextbox(String otp)
	{
		return action.type(EnterOtpTextbox, otp);
	}
	
	public String ErrorMsgForBlankEnterOtpForChangeMobile()
	{
		VerifyOtpBtn.click();
		return ErrorMsgForMandatoryField.getText();
	}
	
	public String InvalidOtpErrorMsg(String otp)
	{
		EnterOtpTextbox.sendKeys(otp);
		action.JSClick(driver, VerifyOtpBtn);
		action.explicitWait(driver, InvalidOtpError, 10);
		return InvalidOtpError.getText();
	}
	
	public String ResendOtpButton()
	{
		action.JSClick(driver, ResendOtpBtn);
		action.explicitWait(driver, ResentOtpMsg, 10);
		return ResentOtpMsg.getText();
	}
	
	public String VerifyOtpButton(String otp)
	{
		EnterOtpTextbox.sendKeys(otp);
		action.JSClick(driver, VerifyOtpBtn);
		action.explicitWait(driver, ProfileUpdatedMsg, 10);
		return ProfileUpdatedMsg.getText();
	}
	
	public String ExistedUserErrorMsg(String otp)
	{
		EnterOtpTextbox.sendKeys(otp);
		action.JSClick(driver, VerifyOtpBtn);
		action.explicitWait(driver, ErrorMsgForExistedUser, 10);
		return ErrorMsgForExistedUser.getText();
	}
	
	public boolean EmailTextbox(String email)
	{
		return action.type(EmailTextbox, email);
	}
	
	public String SendOtpBtnForChangeEmail(String email)
	{
		EmailTextbox.sendKeys(email);
		action.JSClick(driver, SendOtpBtn);
		action.explicitWait(driver, OtpSentMessage, 10);
		return OtpSentMessage.getText();
		
	}
	
	public String ErrorMsgForBlankEmailTextbox()
	{
		action.JSClick(driver, SendOtpBtn);
		action.explicitWait(driver, ErrorMsgForMandatoryField, 10);
		return ErrorMsgForMandatoryField.getText();
	}
	
	public boolean EnterOtpTextboxForChangeEmail(String email,String otp)
	{
		EmailTextbox.sendKeys(email);
		action.JSClick(driver, SendOtpBtn);
		return action.type(EnterOtpTextbox, otp);
		
	}
	
	public String ErrorMsgForBlankEnterOtpTxtbxForChangeEmail(String email)
	{
		EmailTextbox.sendKeys(email);
		action.JSClick(driver, SendOtpBtn);
		//action.JSClick(driver, VerifyOtpBtn);
		VerifyOtpBtn.click();
		action.explicitWait(driver, ErrorMsgForMandatoryField, 10);
		return ErrorMsgForMandatoryField.getText();
	}
	
	public String InvalidOtpErrorMsgForChangeEmail(String email,String otp)
	{
		EmailTextbox.sendKeys(email);
		action.JSClick(driver, SendOtpBtn);
		EnterOtpTextbox.sendKeys(otp);
		action.JSClick(driver, VerifyOtpBtn);
		action.explicitWait(driver, InvalidOtpError, 10);
		return InvalidOtpError.getText();
	}

}
