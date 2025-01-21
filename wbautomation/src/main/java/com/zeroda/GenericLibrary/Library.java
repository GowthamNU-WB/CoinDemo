package com.zeroda.GenericLibrary;

import org.openqa.selenium.support.PageFactory;

import com.zeroda.PageObjectModule.HomePage;
import com.zeroda.PageObjectModule.LoginPage;
import com.zeroda.PageObjectModule.SearchPage;

import io.appium.java_client.AppiumDriver;

public class Library
{
	public HomePage hm = new HomePage();
	public SearchPage sp = new SearchPage();
	public LoginPage lp = new LoginPage();
	
	public void initializePages(AppiumDriver driver) 
	{
		hm=PageFactory.initElements(driver, HomePage.class);
	    sp=PageFactory.initElements(driver, SearchPage.class);
	    lp=PageFactory.initElements(driver, LoginPage.class);
	    
	}
}
