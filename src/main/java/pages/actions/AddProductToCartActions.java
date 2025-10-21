package pages.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pages.locators.AddProductToCart;
import pages.locators.HomePageLocators;
import utils.SeleniumDriver;

import org.testng.Assert;

public class AddProductToCartActions {
	
	WebDriver driver;
	
	AddProductToCart AddProductToCart_obj;
	
	Alert alert;
	
	Actions act;
	
	public AddProductToCartActions(WebDriver driver)
	{
		this.driver = SeleniumDriver.getDriver();
		this.AddProductToCart_obj = new AddProductToCart();		
		PageFactory.initElements(driver, AddProductToCart_obj);
	}
	
	public void click_on_samsung_S6_mobile()
	{
		AddProductToCart_obj.galaxy_S6.click();
	}
	
	public void add_to_cart()
	{
		AddProductToCart_obj.add_to_cart.click();
	}
	
	public boolean presence_of_dialog_box()
	{
		 return driver.getPageSource().contains("Product added.");

	}
	
	/*public void click_ok_in_dialog_box()
	{
		act =new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
	}
	*/
	
	public void click_on_cart_btn()
	{
		AddProductToCart_obj.cart_btn.click();
	}
	
	public String get_text_of_product_in_cart()
	{
		String text = AddProductToCart_obj.title_of_product_added.getText();
		return text;
	}
}
