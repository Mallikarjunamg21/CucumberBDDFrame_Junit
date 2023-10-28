package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookPage {

	private WebDriver driver;

	public FacebookPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailIDTextFeild = By.xpath("//input[@name='email']");
	private By passwordTextFeild = By.xpath("//input[@name='pass']");
	private By LoginBtn = By.xpath("//button[@name='login']");
	private By homePage = By.xpath("//h1[text()='Home']");
	private By postsfrom = By.xpath("//h4//span[text()]");

	public void doLogin() {
		driver.findElement(emailIDTextFeild).sendKeys("mallikarjunamg21@gmail.com");
		driver.findElement(passwordTextFeild).sendKeys("Sudeepa@21");
		driver.findElement(LoginBtn).click();
	}
	
	public String home() {
		return driver.findElement(homePage).getText();
	}

	public void scrollDownUntilPageBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//JavascriptExecutor  End= (JavascriptExecutor) js.executeScript("window.scrollTo(document.body.scrollHeight)", "");
		  int scrollCount = 0;
	        int maxScrolls = 10; // You can adjust this number as needed

	        while (scrollCount < maxScrolls) {
	            js.executeScript("window.scrollBy(0, 2000);"); // Scroll down by 500 pixels
	            try {
	            	List<WebElement> names = driver.findElements(postsfrom);
	            	for(WebElement n:names) {
	            		System.out.println(n.getText());
	            	}
	                Thread.sleep(2000); // Adjust the wait time as needed
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            scrollCount++;
	            }
	}
}
