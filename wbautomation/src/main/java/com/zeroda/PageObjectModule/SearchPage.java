package com.zeroda.PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage 
{
	@FindBy(xpath="//android.widget.EditText")
	private WebElement SearchBox;
	
//	@FindBy(xpath="//android.widget.ImageView[@content-desc='Explore Filter results']/android.widget.Button[2]")
	@FindBy(xpath="//android.widget.Button[2]")
	private WebElement FilterIcon;
	
	@FindBy(xpath="(//android.widget.Button[@content-desc='Any'])[1]")
	private WebElement dropDownOne;
	
	@FindBy(xpath="//android.view.View[@content-desc='Axis Mutual Fund']")
	private WebElement axisMutualFund;
	
	@FindBy(xpath="//android.widget.SeekBar[@content-desc='100%']")
	private WebElement aumSildebar;
	
	@FindBy(xpath="//android.view.View[@content-desc='Apply']")
	private WebElement applyButton;
	
	@FindBy(xpath="//android.view.View[@content-desc='No results found']")
	private WebElement noResultsFound;
	
	@FindBy(xpath="//android.view.View[@content-desc='Sort']")
	private WebElement sort;
	
	@FindBy(xpath="//android.widget.Button[@content-desc='Exit load']")
    private WebElement ExitLoadOption;
	
	@FindBy(xpath="//android.widget.ImageView[contains(@content-desc,'Tata Ultra Short Term Fund \nGrowth')]")
	private WebElement FirstCard;
	
	@FindBy(xpath="//android.widget.Button[@content-desc='Login to invest']")
	private WebElement LoginCTA;

	public WebElement getSearchBox() {
		return SearchBox;
	}

	public WebElement getFilterIcon() {
		return FilterIcon;
	}

	public WebElement getDropDownOne() {
		return dropDownOne;
	}

	public WebElement getAxisMutualFund() {
		return axisMutualFund;
	}

	public WebElement getAumSildebar() {
		return aumSildebar;
	}

	public WebElement getApplyButton() {
		return applyButton;
	}

	public WebElement getNoResultsFound() {
		return noResultsFound;
	}
	
	public WebElement getSort() {
		return sort;
	}

	public WebElement getExitLoadOption() {
		return ExitLoadOption;
	}

	public WebElement getFirstCard() {
		return FirstCard;
	}

	public WebElement getLoginCTA() {
		return LoginCTA;
	}

}
