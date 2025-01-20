package com.zeroda.PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	@FindBy(xpath="//android.view.View[@content-desc='Hey there']")
	private WebElement homePageMessage;
	
	@FindBy(xpath="//android.widget.ImageView[contains(@content-desc,'Ongoing NFOs')]")
	private WebElement ongoingNFOs;
	
	@FindBy(xpath="//android.widget.ImageView[contains(@content-desc,'Funds by Zerodha AMC')]")
	private WebElement funds;
	
	@FindBy(xpath="//android.widget.ImageView[contains(@content-desc,'Save taxes')]")
	private WebElement saveTaxes;
	
	@FindBy(xpath="//android.widget.ImageView[contains(@content-desc,'Low-cost')]")
	private WebElement lowCost;
	
	@FindBy(xpath="//android.widget.ImageView[contains(@content-desc,'Smart beta')]")
	private WebElement smartBeta;
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc='Equity + Debt Stable growth']")
	private WebElement equityDebt;
	
	@FindBy(xpath="//android.widget.ImageView[contains(@content-desc,'Alternatives')]")
	private WebElement Alternative;
	
	@FindBy(xpath="//android.view.View[@content-desc='Search 3000+ mutual funds']")
	private WebElement searchBox;

	public WebElement getHomePageMessage() {
		return homePageMessage;
	}

	public WebElement getOngoingNFOs() {
		return ongoingNFOs;
	}

	public WebElement getFunds() {
		return funds;
	}

	public WebElement getSaveTaxes() {
		return saveTaxes;
	}

	public WebElement getLowCost() {
		return lowCost;
	}

	public WebElement getSmartBeta() {
		return smartBeta;
	}

	public WebElement getEquityDebt() {
		return equityDebt;
	}

	public WebElement getAlternative() {
		return Alternative;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

}
