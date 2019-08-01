package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import net.serenitybdd.core.pages.PageObject;

public class BaseClass extends PageObject {

	// Initialise the driver- POM format
public BaseClass(WebDriver driver) {
	super(driver);
	driver = getDriver();
	System.out.println("In the baseclass");
	PageFactory.initElements(driver, this);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
}

}
