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
public class HomePage extends BaseClass
{
	@FindBy(xpath="//span[text()='Settings']")
	WebElement Settings;
	
	/*@FindBy()
	WebElement
	
	@FindBy()
	WebElement
	
	@FindBy()
	WebElement
	
	@FindBy()
	WebElement
	
	@FindBy()
	WebElement
	*/
	ActionClass action;
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void settings()
	{
		action=new ActionClass();
		action.scrollByVisibilityOfElement(driver, Settings);
		action.JSClick(driver, Settings);
		action.pageLoadTimeOut(driver, 10);
		
	}

}
