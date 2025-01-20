package com.zeroda.Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zeroda.GenericLibrary.Base;
import com.zeroda.GenericLibrary.Utility;
import com.zeroda.PageObjectModule.HomePage;
import com.zeroda.PageObjectModule.SearchPage;

/**
 * Unit test for simple App.
 */
public class SearchPageTest extends Base {

Utility utility = new Utility();
HomePage hm = new HomePage();
SearchPage sp = new SearchPage();

	@BeforeMethod
	public void initiatePages()
	{
		hm=PageFactory.initElements(driver, HomePage.class);
	    sp=PageFactory.initElements(driver, SearchPage.class);
	}

    @Test
    public void VerifyNoResultTest() throws InterruptedException 
    {
       utility.clickOnElement(hm.getSearchBox());
       utility.enterInput(sp.getSearchBox(), "Tata");
       utility.clickOnElement(sp.getFilterIcon());
       utility.clickOnElement(sp.getDropDownOne());
    // Thread.sleep(2000);
       utility.clickOnElement(sp.getAxisMutualFund());
       utility.adjustSlider(sp.getAumSildebar(), 20, driver);
       utility.clickOnElement(sp.getApplyButton());
       utility.verify(sp.getNoResultsFound(), "No results found");
    }
}
