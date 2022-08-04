/**
 * 
 */
package com.NhanceNow.Bot;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.NhanceNow.ActionDriver.ActionClass;
import com.NhanceNow.Base.BaseClass;

/**
 * @author IDS055
 *
 */
public class FlowBuilder extends BaseClass
{
	@FindBy(xpath="//span[text()='Bot'][1]")
	WebElement Bot;
	
	@FindBy(xpath="//span[normalize-space()='Flow Builder']")
	WebElement FlowBuilderBtn;
	
	@FindBy(xpath="//h3[normalize-space()='Flow Builder']")
	WebElement FlowBuilderPage;
	
	@FindBy(xpath="//span[normalize-space()='Name']")
	WebElement name;
	
	@FindBy(xpath="//span[normalize-space()='Product Category']")
	WebElement ProductCategory;
	
	@FindBy(xpath="//span[normalize-space()='Trigger Point']")
	WebElement TriggerPoint;
	
	@FindBy(xpath="//span[normalize-space()='Description']")
	WebElement Description;
	
	@FindBy(xpath="//span[normalize-space()='Created By']")
	WebElement CreatedBy;
	
	@FindBy(xpath="//span[normalize-space()='Created On']")
	WebElement CreatedOn;
	
	@FindBy(xpath="//span[normalize-space()='Updated On']")
	WebElement UpdatedOn;
	
	@FindBy(xpath="//tbody/tr[1]/td[9]/div[1]/button[1]")
	WebElement CloneBtn;
	
	@FindBy(xpath="//tbody/tr[1]/td[9]/div[1]/button[2]")
	WebElement ExportBtn;
	
	@FindBy(xpath="//span[text()=' Name ']")
	WebElement SearchByName;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement SearchByNameTxtbx;
	
	@FindBy(xpath="(//span[contains(text(),'Bike Flow')])[1]")
	WebElement BikeFlow;
	
	@FindBy(tagName="tr")
	List<WebElement> flowCount;
	
	public FlowBuilder()
	{
		PageFactory.initElements(driver, this);
	}
	
	ActionClass action=new ActionClass();
	
	public boolean FlowBuilderButton() throws InterruptedException
	{
		action.JSClick(driver, Bot);
		action.JSClick(driver, FlowBuilderBtn);
		return FlowBuilderPage.isDisplayed();
	}
	
	public void cloneBtn()
	{
		action.JSClick(driver, CloneBtn);
	}
	
	public boolean SearchByNameOption() throws InterruptedException
	{
		action.explicitWait(driver, SearchByName, 10);
		action.JSClick(driver, SearchByName);
	    Thread.sleep(2000);
//		action.explicitWait(driver, SearchByNameTxtbx, 10);
		SearchByNameTxtbx.sendKeys("Bike Flow");
		Thread.sleep(2000);
		if(flowCount.size()==1)
		{
			if(BikeFlow.isDisplayed())
			   return true;
			else
				return false;
		}
		else
			return false;
		
	}
	

}
