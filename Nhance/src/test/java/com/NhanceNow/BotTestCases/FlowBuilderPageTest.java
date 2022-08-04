/**
 * 
 */
package com.NhanceNow.BotTestCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.NhanceNow.Base.BaseClass;
import com.NhanceNow.Bot.FlowBuilder;
import com.NhanceNow.Pageobjects.HomePage;
import com.NhanceNow.Pageobjects.LoginPage;

/**
 * @author IDS055
 *
 */
public class FlowBuilderPageTest extends BaseClass
{
	LoginPage signin;
	HomePage homepage;
	FlowBuilder flowbuilder;
	
	
	@Test
	public void VerifyFlowBuilderBtn() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		flowbuilder=new FlowBuilder();
		signin.login(prop.getProperty("username2"), prop.getProperty("password2"));
		//signin.twostepverification(prop.getProperty("OTP"), homepage);
		Thread.sleep(5000);
        boolean b=flowbuilder.FlowBuilderButton();
        Thread.sleep(3000);
        if(b)
			test.pass("FlowBuilder button is enabled and user is succesfully navigated to flow builder page");
		Assert.assertTrue(b);
	}
	
	@Test
	public void VerifySearchByName() throws InterruptedException
	{
		signin=new LoginPage();
		homepage=new HomePage();
		flowbuilder=new FlowBuilder();
		signin.login(prop.getProperty("username2"), prop.getProperty("password2"));
		//signin.twostepverification(prop.getProperty("OTP"), homepage);
		Thread.sleep(5000);
        flowbuilder.FlowBuilderButton();
        boolean b=flowbuilder.SearchByNameOption();
        System.out.println(b);
        if(b)
			test.pass("search by name is working properly");
        else
        	test.fail("search by name is not working properly");
		Assert.assertTrue(b);
	}

}
