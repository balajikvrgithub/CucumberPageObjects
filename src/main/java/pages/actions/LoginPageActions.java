package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.locators.HomePageLocators;
import utils.SeleniumDriver;

public class LoginPageActions {
	
	WebDriver driver;
	
	HomePageLocators home_page_locators_obj;
	
	public LoginPageActions(WebDriver driver)
	{
		this.driver = SeleniumDriver.getDriver();
		this.home_page_locators_obj = new HomePageLocators();		
		PageFactory.initElements(driver, home_page_locators_obj);
	}
	
	public void click_login_link()
	{
		home_page_locators_obj.login_lnk.click();
	}
	
	public void enter_username()
	{
		home_page_locators_obj.username_txt.sendKeys("balaji0410");
	}
	
	public void enter_password()
	{
		home_page_locators_obj.password_txt.sendKeys("balaji0410");
	}
	
	public void click_login_btn()
	{
		home_page_locators_obj.login_btn.click();
	}
	
	public boolean validate_user()
	{
		return home_page_locators_obj.welcome_lnk.isDisplayed();
	}
	
	
	

}
