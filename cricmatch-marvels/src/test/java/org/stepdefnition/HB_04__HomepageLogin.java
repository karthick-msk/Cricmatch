package org.stepdefnition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


import org.alldrivers.drivers;
import org.apache.commons.lang3.RandomStringUtils;
import org.baseclass.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pojo.HB_04__HomepageLoginpojo;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HB_04__HomepageLogin {
	//Testcase 1
	
	@Given("open the browser and navigate to the URL")
	public void open_the_browser_and_navigate_to_the_url() throws Throwable {
		BaseClass.getInstance().openUrl();
	}
	@Given("enter the username and password")
	public void enter_the_username_and_password() {
		BaseClass.getInstance().sendkeyinput(HB_04__HomepageLoginpojo.getInstance().getusernamefield(), "rock");
		BaseClass.getInstance().sendkeyinput(HB_04__HomepageLoginpojo.getInstance().getpasswordfield(), "Eternals@12");
	}
	
	@When("click the login button")
	public void click_the_login_button() {
	HB_04__HomepageLoginpojo.getInstance().getsubmitbutton().click();
	}
	@Then("verify the login functionality")
	public void verify_the_login_functionality() throws InterruptedException {
		Thread.sleep(2000);
		String ActualResult = HB_04__HomepageLoginpojo.getInstance().getmyaccount().getText();
		
		String ExpectedResult = "My Account";
        Assert.assertEquals("Test failed: Actual Result does not match Expected Result", ExpectedResult, ActualResult);
	}
	//Testcase 2
	

	@Given("the user clicks the join now button and creates an account to get the password count")
	public void the_user_clicks_the_join_now_button_and_creates_an_account_to_get_the_password_count() throws InterruptedException {
		Thread.sleep(3000);

		HB_04__HomepageLoginpojo.getInstance().getJoinnowbutton().click();
		Thread.sleep(3000);

		String randomusername = RandomStringUtils.randomAlphabetic(10);

		Thread.sleep(3000);

		HB_04__HomepageLoginpojo.getInstance().getjoinusernamefield().sendKeys(randomusername);

		Thread.sleep(3000);

		String randomemail = RandomStringUtils.randomAlphanumeric(10);

		Thread.sleep(3000);

		HB_04__HomepageLoginpojo.getInstance().getjoinemailfield().sendKeys(randomemail + "@gmail.com");

		Thread.sleep(3000);
		

		HB_04__HomepageLoginpojo.getInstance().getjoinpasswordfield().sendKeys("Qwertyuiopasdfghjklzxcvbnm!@#$%^&*()12345678906767");

		Thread.sleep(3000);

		HB_04__HomepageLoginpojo.getInstance().getjoinpasswordeyeicon().click();
		Thread.sleep(2000);
		
		String randomnumber = RandomStringUtils.randomNumeric(14);

		Thread.sleep(3000);

		HB_04__HomepageLoginpojo.getInstance().getjoinMobilenumberfield().sendKeys(randomnumber);

		Thread.sleep(3000);
		
		HB_04__HomepageLoginpojo.getInstance().getjoinRegisterbutton().click();
		
		WebElement registerSuccessElement = BaseClass.getInstance().getToasterMessage(HB_04__HomepageLoginpojo.getInstance().getRegisterSucess(), 5);
		        
		String text = registerSuccessElement.getText();
		System.out.println(text);
		Thread.sleep(2000);
		HB_04__HomepageLoginpojo.getInstance().getskipbutton1().click();
		Thread.sleep(2000);
		HB_04__HomepageLoginpojo.getInstance().getskipbutton2().click();
		Thread.sleep(2000);
		HB_04__HomepageLoginpojo.getInstance().getmyaccount().click();
		Thread.sleep(2000);
		HB_04__HomepageLoginpojo.getInstance().getLogoutbutton().click();
		Thread.sleep(3000);
		
	}    

	@Given("the user clicks the exchange login button")
	public void the_user_clicks_the_exchange_login_button() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		HB_04__HomepageLoginpojo.getInstance().getEXCHANGE().click();
		Thread.sleep(3000);
		//drivers.getDriver().navigate().refresh();
		Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(5000);
		HB_04__HomepageLoginpojo.getInstance().getoddsbutton().click();
		Thread.sleep(3000);
		HB_04__HomepageLoginpojo.getInstance().getoddsbutton().click();
		Thread.sleep(3000);
		HB_04__HomepageLoginpojo.getInstance().getplacebet().click();
		Thread.sleep(3000);
	}

	@Given("the user enters the username and password to get the password count")
	public void the_user_enters_the_username_and_password_to_get_the_password_count() throws InterruptedException {
		Thread.sleep(4000);
		HB_04__HomepageLoginpojo.getInstance().getExchangeusernamefield().sendKeys("hardik");
		Thread.sleep(2000);
		HB_04__HomepageLoginpojo.getInstance().getExchangepasswordfield().sendKeys("Qwertyuiopasdfghjklzxcvbnm!@#$%^&*()12345678906767");
		Thread.sleep(2000);
		HB_04__HomepageLoginpojo.getInstance().getExchangeeyeicon().click();
		Thread.sleep(2000);
	}

	@Then("verify both password counts")
	public void verify_both_password_counts() throws InterruptedException {
		
		String ExpectedResult = "Qwertyuiopasdfghjklzxcvbnm!@#$%^&*()12345678906767";
				int RegisterletterCount = ExpectedResult.length();

				System.out.println("Letter count for the Register page password field : " + RegisterletterCount);
				WebElement x = HB_04__HomepageLoginpojo.getInstance().getpasswordcount();
				Thread.sleep(2000);		
				String ActualResult = x.getAttribute("value");

				int loginletterCount = ActualResult.length();

				System.out.println("Letter count for the Homepage login password field: " + loginletterCount);
				HB_04__HomepageLoginpojo.getInstance().getExchangeloginbutton().click();
				Thread.sleep(2000);
				WebElement errormessage = HB_04__HomepageLoginpojo.getInstance().getErrormessage();
				
				System.out.println(errormessage.getText());
				Thread.sleep(2000);
				
				if (RegisterletterCount == loginletterCount){
					Assert.assertTrue(true);
					
					System.out.println("Actual Result: " + ActualResult + " Expected result: " + ExpectedResult);
					System.out.println("Actual Result: " + loginletterCount + " Expected result: " + RegisterletterCount);

					
				} else {
					Assert.fail();
					System.out.println("Actual Result: " + ActualResult + " Expected result: " + ExpectedResult);
					System.out.println("Actual Result: " + loginletterCount + " Expected result: " + RegisterletterCount);

				}

				
	}
	//Testcase 3
	
	private String ActualResult;
    private String ExpectedResult;

    @Given("the user enters the username with spaces and retrieves the username")
    public void the_user_enters_the_username_with_spaces_and_retrieves_the_username() throws InterruptedException {
        Thread.sleep(3000);

        HB_04__HomepageLoginpojo.getInstance().getloginusernamefield().sendKeys("R O C K");
        WebElement getloginattribute = HB_04__HomepageLoginpojo.getInstance().getloginusernamefield();
        Thread.sleep(3000);
        
        ActualResult = getloginattribute.getAttribute("value");
        //System.out.println(ActualResult);
    }

    @Given("then redirect to the joinnow page and paste the usernmae get from the loginpage")
    public void then_redirect_to_the_joinnow_page_and_paste_the_usernmae_get_from_the_loginpage() throws InterruptedException {
        HB_04__HomepageLoginpojo.getInstance().getJoinnowbutton().click();
        Thread.sleep(3000);
        HB_04__HomepageLoginpojo.getInstance().getjoinusernamefield().sendKeys("R O C K");
        Thread.sleep(3000);
        WebElement getjoinusernamefield = HB_04__HomepageLoginpojo.getInstance().getjoinusernamefield();
        Thread.sleep(3000);
        
        ExpectedResult = getjoinusernamefield.getAttribute("value");
        //System.out.println(ExpectedResult);
    }
    
    @Then("verify the both username names entered into the username field")
    public void verify_the_both_username_names_entered_into_the_username_field() {
        if (ActualResult.equals(ExpectedResult)) {
            System.out.println("Actual Result: " + ActualResult + " Expected result: " + ExpectedResult);
            Assert.assertTrue(true);
        } else {
            System.out.println("Actual Result: " + ActualResult + " Expected result: " + ExpectedResult);
            Assert.fail();
        }
    }

//Testcase 4
    
@When("the user enters their username and password, logs out, and revisits the website")
public void the_user_enters_their_username_and_password_logs_out_and_revisits_the_website() throws InterruptedException {
	 Thread.sleep(3000);
	 BaseClass.getInstance().sendkeyinput(HB_04__HomepageLoginpojo.getInstance().getusernamefield(), "rock");
	 Thread.sleep(3000);
		BaseClass.getInstance().sendkeyinput(HB_04__HomepageLoginpojo.getInstance().getpasswordfield(), "Eternals@12");
		 Thread.sleep(3000);
		 HB_04__HomepageLoginpojo.getInstance().getsubmitbutton().click();
		 Thread.sleep(3000);
		 HB_04__HomepageLoginpojo.getInstance().getmyaccount().click();
			Thread.sleep(2000);
			HB_04__HomepageLoginpojo.getInstance().getLogoutbutton().click();
			Thread.sleep(3000);
}

@Then("the username field should display the previously entered credentials")
public void the_username_field_should_display_the_previously_entered_credentials() throws InterruptedException {
	Thread.sleep(3000);
	HB_04__HomepageLoginpojo.getInstance().getusernamefield().click();
	Thread.sleep(3000);
	String ActualResult = HB_04__HomepageLoginpojo.getInstance().getusernamefield().getAttribute("value");
	System.out.println(ActualResult);
	String ExpectedResult = "Rock";
	if (ActualResult.equals(ExpectedResult)) {
        System.out.println("Actual Result: " + ActualResult + " Expected result: " + ExpectedResult);
        Assert.assertTrue(true);
    } else {
        System.out.println("Actual Result: " + ActualResult + " Expected result: " + ExpectedResult);
        Assert.fail();
    }
}
}