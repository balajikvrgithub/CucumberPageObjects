package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.SeleniumDriver;

public class Hooks {

	@Before
	public void before()
	{
		SeleniumDriver.setUpDriver();
	}

	@After
	public void after(Scenario scenario) throws IOException {

		  WebDriver driver = SeleniumDriver.getDriver();

		  if (scenario.isFailed()) {
			    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    String screenshotName = scenario.getName().replaceAll(" ", "_") + ".png";

			    // Save under target/screenshots
			    File destination = new File("target/screenshots/" + screenshotName);
			    FileUtils.copyFile(screenshot, destination);

			    // Log message
			    ExtentCucumberAdapter.addTestStepLog("❌ Test failed at step: " + scenario.getName());

			    // IMPORTANT: Pass relative path (relative to report location)
			    ExtentCucumberAdapter.addTestStepScreenCaptureFromPath("../screenshots/" + screenshotName);
			}

		    SeleniumDriver.tearDown();
	}
	
}
