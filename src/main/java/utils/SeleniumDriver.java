package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	
	private static SeleniumDriver SeleniumDriver;
	
	private static WebDriver driver;
	
	private static WebDriverWait waitDriver;
	
	public final static int TIMEOUT = 30;
	public final static int PAGE_LOAD_TIMEOUT = 50;
	
	private SeleniumDriver()
	{	
		ChromeOptions options = new ChromeOptions();
	    options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS); 
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		waitDriver = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
		
	}
	
	public static void openPage(String url)
	{
		driver.get(url);
	}
	
	public static WebDriver getDriver()
	{
		if (driver == null) {
            // Initialize driver here
            driver = new ChromeDriver(); // or FirefoxDriver, etc.
        }
        return driver;
	}
	
	public static void setUpDriver()
	{
		if(SeleniumDriver == null)
		{
			SeleniumDriver = new SeleniumDriver();
		}
	}
	
	public static void tearDown()
	{
		if(driver != null)
		{
			driver.close();
			driver.quit();
		}
		
		SeleniumDriver = null;
	}
	
	 public static void waitForPageToLoad()
	    {
	    	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	 
	 public static void webdriverwait(By by)
	 {
		 waitDriver.until(ExpectedConditions.visibilityOfElementLocated(by));
	 }
	 
	 public static void webdriverwaitByWebElement(WebElement element)
	 {
		 waitDriver.until(ExpectedConditions.visibilityOf(element));
	 }
}
