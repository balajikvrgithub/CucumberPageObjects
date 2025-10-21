package runner;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps"},
    tags = "@login or @addproduct",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-html-report.html",
        "json:target/cucumber-reports/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true
)
public class RunCuke extends AbstractTestNGCucumberTests {
}