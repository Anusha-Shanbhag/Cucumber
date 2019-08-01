package runnerclass;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import dataProvider.ConfigReader;

@RunWith(ExtendedCucumberRunnerClass.class)
@CucumberOptions(features = "src/test/resources/featureFiles", glue = { "step_definition" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extentreport.html" })

public class RunnerClass {

	@AfterClass
	public static void writeExtentReport() {
		System.out.println("AfterClass print");
		ConfigReader con = new ConfigReader();
		Reporter.loadXMLConfig(con.getReportConfigPath());
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}
