package org.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\featurefiles", glue = {
		"org.stepdefnition" }, dryRun = false, monochrome = true, plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@login")
public class testrunner {

}
