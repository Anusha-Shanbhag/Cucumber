package step_definition;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import dataProvider.ConfigReader;
import managers.WebDriverManager;

public class Hooks {
	public static WebDriver driver;
	WebDriverManager webDriverMgr;
	ConfigReader configReader;
	@Rule
	public TestName name = new TestName() {
		public String getMethodName() {
			return String.format("%s", super.getMethodName());
		}
	};
	
	@Before
	public void initializeBrowser(Scenario scenario) {
		System.out.println("Init Hooks");
		Reporter.assignAuthor("Testing practice");
		webDriverMgr = new WebDriverManager();
		configReader = new ConfigReader();
		driver = webDriverMgr.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configReader.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
	}
	
	@After
	public void afterTest(Scenario scenario) {
		System.out.println("After Hooks");
		if(scenario.isFailed()) {
			String scenarioName = scenario.getName().replaceAll(" ", "_");
			System.out.println("screenShotName : "+scenarioName);
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			scenario.write(scenarioName);
		}
	}
	
	public Hooks() {
		
	}

}
