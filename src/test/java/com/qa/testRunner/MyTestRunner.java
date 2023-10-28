package com.qa.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/com/qa/features/Facebook.feature"},
		glue = {"com.qa.stepDefinations","com.qa.AppHooks"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		
		)

public class MyTestRunner {
	
	
	

}
