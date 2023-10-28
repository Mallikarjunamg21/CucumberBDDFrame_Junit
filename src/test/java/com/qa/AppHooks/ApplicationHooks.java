package com.qa.AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.DriverFactory.Driverfactory;
import com.qa.Util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private Driverfactory driverFactory;
	private WebDriver driver;
	public Properties prop;
	private ConfigReader configReader;
	
	@Before(order=0)
	public Properties getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		return prop;
	}
	
	@Before(order=1)
	public WebDriver launchBrowser() {
		String browserName = prop.getProperty("browser");
	    driverFactory = new Driverfactory();
		driverFactory.init_driver(browserName);
		driver = driverFactory.getDriver();
		return driver;
	}
	
	
	@After(order=0) 
	public void quitBrowser() {
		driver.quit();
		}
	
	@After(order=1)
	public void teardown(Scenario scenerio) {
		if(scenerio.isFailed()){
			//screenshot
			String screenshotName = scenerio.getName().replace(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenerio.attach(sourcePath, "image/png", screenshotName);
		}
	
	}
	
}
