package com.qa.stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import com.qa.AppHooks.ApplicationHooks;
import com.qa.DriverFactory.Driverfactory;
import com.qa.Pages.RadioCityPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RadioCitySteps {
	
	private RadioCityPage welcomePage = new RadioCityPage(Driverfactory.getDriver());
	
	@Given("I open url {string}")
	public void i_open_url(String url) {
		String a = url;
		String urls = "https://www.radiocity.in/";
	   Driverfactory.getDriver().get(urls);
	}

	@When("I click on dropdown")
	public void i_click_on_dropdown() {
		welcomePage.clickLocationDrop();
	}
	
	@Then("I get a the locations present in dropdown")
	public void i_get_a_the_locations_present_in_dropdown() {
	   System.out.println("Locations : "+welcomePage.locations());
	   System.out.println("Size : "+welcomePage.locations().size());
	   System.out.println("Selected Option: "+welcomePage.Selected_location());
	   System.out.println("Change_location : "+welcomePage.Change_location());
	   
	  Assert.assertNotNull("Objects are not null ", welcomePage.locations());
	}

}
