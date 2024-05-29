package org.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HB_04__HomepageLoginpojo {
	private static HB_04__HomepageLoginpojo logininstance = null;
	private HB_04__HomepageLoginpojo() {
		
	}
	public static HB_04__HomepageLoginpojo getInstance() {
		if(logininstance == null) {
			logininstance = new HB_04__HomepageLoginpojo();
		}
	return logininstance;
	}
	@FindBy(xpath ="//input[@placeholder='Email/Username']")
	private WebElement usernamefield;
	public WebElement getusernamefield() {
		return usernamefield;
	}
	@FindBy(xpath ="//input[@id='password']")
	private WebElement passwordfield;
	public WebElement getpasswordfield() {
		return passwordfield;
	}
	
	@FindBy(xpath ="//input[@id='submitLogForm']")
	private WebElement submitbutton;
	public WebElement getsubmitbutton() {
		return submitbutton;
}
	@FindBy(xpath ="//a[@class='ssc-unc']")
	private WebElement myaccount;
	public WebElement getmyaccount() {
		return myaccount;
	


}
	@FindBy(xpath = "//span[text()='Join Now']")
	private WebElement joinnowbutton;
	public WebElement getJoinnowbutton() {
		return joinnowbutton;
	}


	@FindBy(xpath ="//input[@id='usr_name']")
	private WebElement joinusernamefield;
	public WebElement getjoinusernamefield() {
		return joinusernamefield;
	}
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailfield;
	public WebElement getjoinemailfield() {
		return emailfield;
	}
	@FindBy(xpath = "//input[@title='Enter your Password']")
	private WebElement joinpasswordfield;
	public WebElement getjoinpasswordfield() {
		return joinpasswordfield;
	}

	@FindBy(xpath = "//input[@title='Enter your Mobile Number']")
	private WebElement Mobilenumberfield;
	public WebElement getjoinMobilenumberfield() {
		return Mobilenumberfield;
	}
	@FindBy(xpath = "//button[text()='Register']") 
	private WebElement Registerbutton;
	public WebElement getjoinRegisterbutton() {
		return Registerbutton;
		
	}

	@FindBy(xpath = "//p[@style='margin: 0px; padding: 0px; color: rgb(255, 255, 255); font-size: 14px; font-weight: 300; line-height: 1em;']") 
	private WebElement RegisterSucess;
	public WebElement getRegisterSucess() {
		return RegisterSucess;
	 }
	
	@FindBy(xpath = "//div[@style='position:relative;z-index:20;']") 
	private WebElement joinpasswordeyeicon;
	public WebElement getjoinpasswordeyeicon() {
		return joinpasswordeyeicon;

}
	
	@FindBy(xpath = "//span[text()='Skip']") 
	private WebElement skipbutton1;
	public WebElement getskipbutton1() {
		return skipbutton1;
}
	@FindBy(xpath = "//a[text()='Skip']") 
	private WebElement skipbutton2;
	public WebElement getskipbutton2() {
		return skipbutton2;
}

	@FindBy(xpath = "//a[text()='Logout']") 
	private WebElement Logoutbutton;
	public WebElement getLogoutbutton() {
		return Logoutbutton;
		
}
	@FindBy(xpath = "//a[@id='EXCHANGE']") 
	private WebElement EXCHANGE;
	public WebElement getEXCHANGE() {
		return EXCHANGE;
		
}
	@FindBy(xpath = "(//button[@class='0_back bf-bet-button ng-isolate-scope back-button back back-selection-button tablinks_1'])[1]") 
	private WebElement oddsbutton;
	public WebElement getoddsbutton() {
		return oddsbutton;
}
	@FindBy(xpath = "//button[text()='Place bet']") 
	private WebElement placebet;
	public WebElement getplacebet() {
		return placebet;
	
	}
	
	@FindBy(xpath = "//input[@title='Enter your username/email']") 
	private WebElement Exchangeusernamefield;
	public WebElement getExchangeusernamefield() {
		return Exchangeusernamefield;
}
	
	@FindBy(xpath = "(//input[@title='Enter your password'])[2]") 
	private WebElement Exchangepasswordfield;
	public WebElement getExchangepasswordfield() {
		return Exchangepasswordfield;
	}	
	
	@FindBy(xpath = "(//span[@type='button'])[2]") 
	private WebElement Exchangeeyeicon;
	public WebElement getExchangeeyeicon() {
		return Exchangeeyeicon;
}
		@FindBy(xpath = "(//input[@type='text'])[8]") 
		private WebElement passwordcount;
		public WebElement getpasswordcount() {
			return passwordcount;	
	
}
		@FindBy(xpath = "(//input[@value='Log In'])[2]") 
		private WebElement Exchangeloginbutton;
		public WebElement getExchangeloginbutton() {
			return Exchangeloginbutton;		
		
}	
		@FindBy(xpath = "//span[text()='User not found.']") 
		private WebElement Errormessage;
		public WebElement getErrormessage() {
			return Errormessage;	
		}
		
		@FindBy(xpath = "//input[@title='Enter your Email/Username']") 
		private WebElement loginusernamefield;
		public WebElement getloginusernamefield() {
			return loginusernamefield;	
		}
}
	