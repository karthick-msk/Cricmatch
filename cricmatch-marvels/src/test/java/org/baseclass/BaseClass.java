package org.baseclass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.alldrivers.drivers;
import org.apache.commons.lang3.RandomStringUtils;
import org.constants.constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import java.awt.Robot;
import org.pojo.HB_04__HomepageLoginpojo;



public class BaseClass {
	private static BaseClass baseclassinstance = null;

	private BaseClass() {
	}

	public static BaseClass getInstance() {
		if (baseclassinstance == null) {
			baseclassinstance = new BaseClass();
		}
		return baseclassinstance;
}

	public void loadproperties() {
		Properties propertie = new Properties();
		try {
			propertie.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		constants.APP_URL = propertie.getProperty("APP_URL");
		constants.BROWSER = propertie.getProperty("BROWSER");
		constants.UsernName = propertie.getProperty("UsernName");
		constants.Password = propertie.getProperty("Password");
	}

	public void initwebelemet() {



		PageFactory.initElements(drivers.getDriver(), HB_04__HomepageLoginpojo.getInstance());
		
	}

	public void haboomlogin() {
		try {
			BaseClass.getInstance().sendkeyinput(HB_04__HomepageLoginpojo.getInstance().getusernamefield(), constants.UsernName);
			BaseClass.getInstance().sendkeyinput(HB_04__HomepageLoginpojo.getInstance().getpasswordfield(),
					constants.Password);
			BaseClass.getInstance().elementClick(HB_04__HomepageLoginpojo.getInstance().getLogoutbutton());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public void openUrl() throws Throwable {
		try {
			drivers.getDriver().get(constants.APP_URL);
			drivers.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public String getTitle() {
		try {
			String title = drivers.getDriver().getTitle();
			return title;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public String getCurrentUrl() {
		try {
			String title = drivers.getDriver().getCurrentUrl();
			return title;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void sendkeyinput(WebElement elementlocator, String inputvalue) {
		try {
			elementlocator.sendKeys(inputvalue);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	// Actions
	public void dragAndDrop(WebElement dragelementlocator, WebElement dropelementlocator) {
		try {

			Actions ac = new Actions(drivers.getDriver());
			ac.dragAndDrop(dragelementlocator, dropelementlocator).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void dropdown(WebElement dropdownlocator, String dropdownmethod, String dropdownvalue) {
		try {
			Select sc = new Select(dropdownlocator);
			if (dropdownmethod.equalsIgnoreCase("value")) {
				sc.selectByValue(dropdownvalue);
			} else if (dropdownmethod.equalsIgnoreCase("visibletext")) {
				sc.selectByVisibleText(dropdownvalue);
			} else if (dropdownmethod.equalsIgnoreCase("index")) {
				sc.selectByIndex(Integer.parseInt(dropdownvalue));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public void droganddropwithoffset(WebElement dragandroporrezizelocator, int ofsetvalueX, int offsetvalueY) {
		try {

			Actions ac = new Actions(drivers.getDriver());
			ac.clickAndHold(dragandroporrezizelocator);
			Thread.sleep(2000);
			ac.moveByOffset(ofsetvalueX, ofsetvalueX).release().build().perform();

			// ac.perform();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}


	public void waitForElementToBeClickable(WebElement element, int sec) {
		try {
			WebDriverWait wait = new WebDriverWait(drivers.getDriver(), sec);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public void switchtoSecondWindow() {
		try {
			String parentwindow = drivers.getDriver().getWindowHandle();
			Set<String> allwindows = drivers.getDriver().getWindowHandles();
			for (String x : allwindows) {
				if (!x.equals(parentwindow)) {
					drivers.getDriver().switchTo().window(x);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void switchtoMultipleWindow(int index) {
		try {
			String cId = drivers.getDriver().getWindowHandle();
			Set<String> pId = drivers.getDriver().getWindowHandles();
			List<String> li = new ArrayList<String>();
			li.addAll(pId);
			drivers.getDriver().switchTo().window(li.get(index));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}

	}

	public void switchtoDefualtContent() {
		try {
			drivers.getDriver().switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String randomeString(int stringcount) {
		String generatedString = RandomStringUtils.randomAlphabetic(stringcount);
		return (generatedString);
	}

	public String randomNumber(int numcount) {
		String generatedString2 = RandomStringUtils.randomNumeric(numcount);
		return (generatedString2);
	}

	public String randomAlphaNumber(int numcount, int Stringcount) {
		String st = RandomStringUtils.randomAlphabetic(Stringcount);
		String num = RandomStringUtils.randomNumeric(numcount);
		return (st + "@" + num);
	}

	public String randomAlphaNumberswspcase(int numcount, int Stringcount) {
		String st = RandomStringUtils.randomAlphabetic(Stringcount);
		String num = RandomStringUtils.randomNumeric(numcount);
		return (st + num);
	}

	public String randomNumberbelowtend() {
		String generatedString2 = RandomStringUtils.randomNumeric(1);
		return (generatedString2);
	}

	public static void waitimplicit(int a) {
		drivers.getDriver().manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}

	public WebElement getToasterMessage(WebElement element, int sec) {

		try {
			WebDriverWait wait = new WebDriverWait(drivers.getDriver(), sec);
			WebElement text = wait.until(ExpectedConditions.visibilityOf(element)); // Changed to elementToBeVisible
			return text;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void elementClick(WebElement elementlocator) {
		try {

			elementlocator.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public String getElementText(WebElement elementlocator) {
		try {
			String text = elementlocator.getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public String getElementTextAttribute(WebElement element, String value) {
		try {
			String attribute = element.getAttribute(value);
			return attribute;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void scrollUpandScrollDownusingElement(WebElement elementlocator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) drivers.getDriver();
			js.executeScript("arguments[0].scrollIntoView();", elementlocator);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void scrollUpandDownusingCoordinates(int top, int height) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) drivers.getDriver();
			js.executeScript("window.scrollBy(" + top + "," + height + ")");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void scrolltoBottomPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) drivers.getDriver();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void movetoElement(WebElement elementlocator) {
		try {
			Actions ac = new Actions(drivers.getDriver());
			ac.moveToElement(elementlocator).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void doubleClick(WebElement element) {
		try {
			Actions ac = new Actions(drivers.getDriver());
			ac.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void contextClick(WebElement element) {
		try {
			Actions ac = new Actions(drivers.getDriver());
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void elementClickusingActions(WebElement element) {
		try {
			Actions ac = new Actions(drivers.getDriver());
			ac.click(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void performKeyboardAction(int keyCode) {
		try {
			Robot robot = new Robot();
			robot.keyPress(keyCode);
			robot.keyRelease(keyCode);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void highlightElement(WebElement element) {
		try {
			String originalStyle = element.getAttribute("style");
			JavascriptExecutor js = (JavascriptExecutor) drivers.getDriver();
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					element);

			Thread.sleep(1000);
			js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void performMouseHover(WebElement element) {
		try {
			Actions actions = new Actions(drivers.getDriver());
			actions.moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void performRightClick(WebElement element) {
		try {
			Actions actions = new Actions(drivers.getDriver());
			actions.contextClick(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToURL(String url) {
		try {
			drivers.getDriver().navigate().to(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchtoIframe(String options, Object value) {
		try {
			if (options.equalsIgnoreCase("index")) {
				drivers.getDriver().switchTo().frame(Integer.parseInt((String) value));
			} else if (options.equalsIgnoreCase("name")) {
				drivers.getDriver().switchTo().frame((String) value);
			} else if (options.equalsIgnoreCase("element")) {
				drivers.getDriver().switchTo().frame((WebElement) value);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void closeAndSwitchToFirstTab() {
	    // Close the current tab
		drivers.getDriver().close();
	
	    // Switch back to the first tab (index 0)
		drivers.getDriver().switchTo().window(drivers.getDriver().getWindowHandles().iterator().next());
	}
}

