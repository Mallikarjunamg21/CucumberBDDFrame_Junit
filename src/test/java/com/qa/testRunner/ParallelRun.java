package com.qa.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/com/qa/features/"},
		glue = {"com.qa.stepDefinations","com.qa.AppHooks"},
		monochrome = true,
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				 "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber.html"}
		
		//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		
		)
public class ParallelRun {

}
