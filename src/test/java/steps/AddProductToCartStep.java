package steps;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.actions.AddProductToCartActions;
import pages.actions.LoginPageActions;
import pages.locators.AddProductToCart;
import utils.SeleniumDriver;

public class AddProductToCartStep {
	
	AddProductToCartActions obj = new AddProductToCartActions(SeleniumDriver.getDriver());
	AddProductToCart locator = new AddProductToCart();
	 Alert alert;
	
@Then("click on samsung galaxy s6 product")
public void click_on_samsung_galaxy_s6_product() throws InterruptedException {
	Thread.sleep(5000);
	obj.click_on_samsung_S6_mobile();
}

@Then("click on add to cart button")
public void click_on_add_to_cart_button() throws InterruptedException {
	Thread.sleep(3000);
	obj.add_to_cart();
	WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), Duration.ofSeconds(10));
    alert = wait.until(ExpectedConditions.alertIsPresent());

}

@Then("click ok button")
public void click_ok_button() {
// obj.click_ok_in_dialog_box();  
	alert.accept();
}

@Then("click on cart menu button")
public void click_on_cart_menu_button() throws InterruptedException {
	Thread.sleep(3000);
	obj.click_on_cart_btn();
}

@Then("validate the presence of product in cart page")
public void validate_the_presence_of_product_in_cart_page() {
   Assert.assertEquals(obj.get_text_of_product_in_cart(),"Samsung galaxy s6");
}




}
