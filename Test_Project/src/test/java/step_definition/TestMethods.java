package step_definition;

import org.openqa.selenium.WebDriver;

import pageObjects.BaseClass;

public class TestMethods extends BaseClass {
	
	public TestMethods(WebDriver driver) {
		super(driver);
	}

	public void launchBrowser() {
		System.out.println("Inside Test Method");
		
	}

}
