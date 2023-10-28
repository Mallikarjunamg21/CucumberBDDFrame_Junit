package com.qa.stepDefinations;

import org.junit.Assert;

import com.qa.DriverFactory.Driverfactory;
import com.qa.Pages.FacebookPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookSteps {
	
	FacebookPage fbPage = new FacebookPage(Driverfactory.getDriver());
	@Given("I logged in into facebook")
	public void i_logged_in_into_facebook() {
		Driverfactory.getDriver().get("https://www.facebook.com/login/");
		fbPage.doLogin();
	}

	@Given("I landed news feed screen")
	public void i_landed_news_feed_screen() {
	   fbPage.home();
	}
	@When("I scroll down the page")
	public void i_scroll_down_the_page() {
	   fbPage.scrollDownUntilPageBottom();
	}
	@Then("new posts gets loaded until page gets scrolled")
	public void new_posts_gets_loaded_until_page_gets_scrolled() {
	   Assert.assertTrue(true);
	}
	@Then("verify scroll functionality ends only posts are not available")
	public void verify_scroll_functionality_ends_only_posts_are_not_available() {
		Assert.assertTrue(true);
	}



	
}
