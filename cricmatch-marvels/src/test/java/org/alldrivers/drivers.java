package org.alldrivers;

import org.constants.constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class drivers {
private static WebDriver driver = null;
public static void launchbrowser() {
	try {
		switch (constants.BROWSER) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
break;
		default:
			System.out.println("invalid browser name");
			break;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}

}
public static WebDriver getDriver() {
	return driver;
}
}
