package com.zeroda.Tests;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.zeroda.GenericLibrary.Base;
import com.zeroda.GenericLibrary.Library;
import com.zeroda.GenericLibrary.Utility;
import com.zeroda.GenericLibrary.Base;
import com.zeroda.GenericLibrary.ExtentReportListener;

@Listeners(ExtentReportListener.class)

public class SearchPageTest extends Base {

Utility utility = new Utility();
Library library = new Library();

    @Test
    public void VerifyNoResultTest() throws InterruptedException 
    {
 //      test = ExtentReportListener.extentReports.createTest("VerifyNoResultTest)");
       utility.clickOnElement(hm.getSearchBox());
       utility.enterInput(sp.getSearchBox(), "Tata");
       utility.clickOnElement(sp.getFilterIcon());
       utility.clickOnElement(sp.getDropDownOne());
       utility.clickOnElement(sp.getAxisMutualFund());
       utility.adjustSlider(sp.getAumSildebar(), 20, driver);
       utility.clickOnElement(sp.getApplyButton());
       utility.verify(sp.getNoResultsFound(), "No resultsfound");
    }
}
