package org.stepdefnition;

import org.alldrivers.drivers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.baseclass.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class commonstepdefnition {
//launchbrowser
	public static WebDriver driver;
	public static final Logger LOG = LogManager.getLogger(commonstepdefnition.class);

	@Before
	public void BeforeScenario() {
		LOG.info("Initiating BaseClass");
		try {
			LOG.info("loading properties file");
			BaseClass.getInstance().loadproperties();
			LOG.info("check the driver is null");
			if (driver == null) {
				LOG.info("driver is null");
				drivers.launchbrowser();
				BaseClass.getInstance().initwebelemet();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterStep
	public void attachscreenshot(Scenario scenarioss) {
		if (scenarioss.isFailed()) {
			byte[] screenshotAs = ((TakesScreenshot) drivers.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenarioss.attach(screenshotAs, "image/png", "Screenshot Evidence:");
		}

	}

	@After
	public void teardown() {
		// drivers.getDriver().close();
	}

}
