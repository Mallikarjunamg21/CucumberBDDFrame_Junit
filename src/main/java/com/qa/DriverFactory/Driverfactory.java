package com.qa.DriverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class Driverfactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public void init_driver(String browser) {
		System.out.println("Browser in Action : "+browser);
		if(browser.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("--start-maximized", "--window-size=2560,1440","--ignore-certificate-errors","--disable-extensions","--disable-dev-shm-usage");
		    options.addArguments("--log-level=3");
		    options.addArguments("--remote-allow-origins=*");
		    options.addArguments("disable notifications");
		    DesiredCapabilities cp= new DesiredCapabilities();
		    cp.setCapability(ChromeOptions.CAPABILITY,options );
		    options.merge(cp);
			tlDriver.set(new ChromeDriver(options));
			
		}else if(browser.equals("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}else if(browser.equals("edge")) {
			//WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}else {
			System.out.println("Browser not found : "+browser);
		}
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	}
	
	
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
}
