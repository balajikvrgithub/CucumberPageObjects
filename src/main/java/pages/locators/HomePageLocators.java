package pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageLocators {
	
	@FindBy(how=How.XPATH,using="//*[@id='login2']")
	@CacheLookup
	public WebElement login_lnk;
	
	@FindBy(how=How.XPATH,using="//*[@id='loginusername']")
	@CacheLookup
	public WebElement username_txt;

	@FindBy(how=How.XPATH,using="//*[@id='loginpassword']")
	@CacheLookup
	public WebElement password_txt;
	
	@FindBy(how=How.XPATH,using="//*[@id='logInModal']/div/div/div[3]/button[2]")
	@CacheLookup
	public WebElement login_btn;
	
	@FindBy(how=How.XPATH,using="//*[@id='nameofuser']")
	@CacheLookup
	public WebElement welcome_lnk;
	
	
	
	

}
