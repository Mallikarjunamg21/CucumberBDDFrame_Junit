package com.qa.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RadioCityPage {

	private WebDriver driver;

	public RadioCityPage(WebDriver driver) {
		this.driver = driver;
	}



	private By shopMenu = By.xpath("//a[.='Shop']");
	private By HomeLink = By.xpath("//a[.='Home']");
	private By products = By.xpath("//h3");
	private By location = By.xpath("//select[@id='location']");
	private String city;

	public void clickShopBtn() {
		driver.findElement(shopMenu).click();
	}

	public void homePagebtn() throws InterruptedException {
		driver.findElement(HomeLink).click();
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");

		driver.findElement(HomeLink).click();
	}

	public int getNewArrivalcount() {
		return driver.findElements(products).size();
	}

	public void clickLocationDrop() {
		driver.findElement(location).click();
	}

	public List<String> locations() {
		Select locations = new Select(driver.findElement(location));
		List<String> lis = new ArrayList<String>();
		for (int i = 0; i < 3; i++) { // Retry up to 3 times
			try {
				locations = new Select(driver.findElement(location)); // Re-locate the element
				List<WebElement> locationDrop = locations.getOptions();
				for (WebElement l : locationDrop) {
					String names = l.getText();
					lis.add(names);
				}
				return lis;
			} catch (StaleElementReferenceException e) {
				// Handle the exception, e.g., log it, and retry
			}
		}
		throw new StaleElementReferenceException("Failed after 3 retries");
	}

	public String Selected_location() {
		Select locations = new Select(driver.findElement(location));
		WebElement locationDrop = locations.getFirstSelectedOption();
		String city = locationDrop.getText();
		return city;
	}

	public String Change_location() {
		Select locations = new Select(driver.findElement(location));
		
		for (int i = 0; i < 3; i++) {
			try {
				locations.selectByVisibleText("Bangalore");
				WebElement locationDrop = locations.getFirstSelectedOption();
				city = locationDrop.getText();
			} catch (StaleElementReferenceException e) {
				System.out.println("Reference stale man..check again");
			}
		}
		return city;
	}
}