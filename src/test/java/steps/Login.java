package steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.actions.LoginPageActions;
import utils.SeleniumDriver;

public class Login {

	LoginPageActions login_page_actions_obj;

	@Given("I am on the homepage {string}")
	public void i_am_on_the_homepage(String url) {
		// SeleniumDriver.setUpDriver();
		SeleniumDriver.openPage(url);
		login_page_actions_obj = new LoginPageActions(SeleniumDriver.getDriver());
//	 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		// driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
		login_page_actions_obj.click_login_link();
	}

	@Then("Application should take me to the landing page")
	public void application_should_take_me_to_the_landing_page() throws InterruptedException {

		SeleniumDriver.webdriverwait(By.xpath("//*[@id=\"loginusername\"]"));
		SeleniumDriver.webdriverwait(By.xpath("//*[@id=\"loginpassword\"]"));
		SeleniumDriver.webdriverwait(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginusername\"]")));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginpassword\"]")));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")));

		// driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("balaji0410");
		// driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("balaji0410");
		// driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

		login_page_actions_obj.enter_username();
		login_page_actions_obj.enter_password();
		login_page_actions_obj.click_login_btn();
		Thread.sleep(3000);
	}

	/*
	 * @Then("menu options should be visible") public void
	 * menu_options_should_be_visible(io.cucumber.datatable.DataTable dataTable) {
	 * 
	 * 
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	 * "//*[@id=\"nameofuser\"]")));
	 * Assert.assertTrue(login_page_actions_obj.validate_user());
	 * 
	 * driver.close(); }
	 */

	@Then("menu options should be visible")
	public void menu_options_should_be_visible(List<String> list) {

		Assert.assertEquals("Log out", list.get(5));
		SeleniumDriver.webdriverwait(By.xpath("//*[@id=\"nameofuser\"]"));
		Assert.assertTrue(login_page_actions_obj.validate_user());

//driver.close();
	}

}
