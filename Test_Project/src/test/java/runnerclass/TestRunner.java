/*package runnerclass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import dataProvider.ConfigReader;
import cucumber.api.testng.CucumberFeatureWrapper;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vimalselvam.cucumber.listener.Reporter;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features = "src/test/resources/featureFiles", glue = { "step_definition" }, tags = {
		"~@Ignore" }, plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/extent_report.html"})
public class TestRunner {
	ConfigReader configReader = new ConfigReader();

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void writeExtentReport() {
		Reporter.loadXMLConfig(new File(configReader.getReportConfigPath()));
	}

	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}

}

// JUnit

 * @RunWith(Cucumber.class)
 * 
 * @CucumberOptions( features =
 * "src/test/resources/featureFiles/TestFeatures.feature", glue=
 * {"step_definition"} ) public class TestRunner { }
 
*/