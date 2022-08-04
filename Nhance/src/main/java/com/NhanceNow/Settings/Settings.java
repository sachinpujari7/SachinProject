/**
 * 
 */
package com.NhanceNow.Settings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NhanceNow.ActionDriver.ActionClass;
import com.NhanceNow.Base.BaseClass;

/**
 * @author IDS055
 *
 */
public class Settings extends BaseClass
{
	@FindBy(xpath="//button[text()='Edit Profile']")
	WebElement EditProfile;
	
	@FindBy(xpath="//button[text()='Change Password']")
	WebElement ChangePassword;
	
	@FindBy(xpath="//button[text()='Edit Customer']")
	WebElement EditCustomer;
	
	@FindBy(xpath="//button[text()='Users']")
	WebElement Users;
	
	public Settings()
	{
		PageFactory.initElements(driver, this);
	}
	ActionClass action=new ActionClass();
	public void EditProfileButton()
	{
		action.JSClick(driver, EditProfile);
		
	}
	
    

}
