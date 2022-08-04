/**
 * 
 */
package com.NhanceNow.Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.NhanceNow.Utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author IDS055
 *
 */
public class BaseClass extends ExtentManager
{
	public static Properties prop;
	public static WebDriver driver;

	
	//loadConfig method is to load the configuration
	@BeforeSuite
	public void loadConfig() {
		ExtentManager.setExtent();

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
    
	public void launchApp(String browserName) {
		// String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver=new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-gpu");
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		//Implicit TimeOuts
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//PageLoad TimeOuts
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		//Launching the URL
		driver.get(prop.getProperty("url"));
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
	@BeforeMethod
	public void setup() 
	{
		launchApp(prop.getProperty("browser")); 
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}

}
