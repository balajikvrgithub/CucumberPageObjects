package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddProductToCart {
	
	@FindBy(how=How.XPATH,using="//a[@class=\"hrefch\"][@href=\"prod.html?idp_=1\"]")
	@CacheLookup
	public WebElement galaxy_S6;
	
	@FindBy(how=How.XPATH,using="//a[@onclick=\"addToCart(1)\"]")
	@CacheLookup
	public WebElement add_to_cart;
	
	@FindBy(how=How.XPATH,using="//a[@id='cartur']")
	@CacheLookup
	public WebElement cart_btn;
	
	@FindBy(how=How.XPATH,using="//td[normalize-space()='Samsung galaxy s6']")
	@CacheLookup
	public WebElement title_of_product_added;


}
