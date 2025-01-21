package com.zeroda.PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	@FindBy(xpath="//android.view.View[@content-desc='Login to the app']")
	private WebElement LoginpageHeader;

	public WebElement getLoginpageHeader() {
		return LoginpageHeader;
	}
	
	
}
