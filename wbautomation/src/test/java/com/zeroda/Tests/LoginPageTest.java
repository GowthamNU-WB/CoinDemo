package com.zeroda.Tests;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.zeroda.GenericLibrary.Base;
import com.zeroda.GenericLibrary.Library;
import com.zeroda.GenericLibrary.Utility;
import com.zeroda.GenericLibrary.Base;
import com.zeroda.GenericLibrary.ExtentReportListener;

@Listeners(ExtentReportListener.class)

public class LoginPageTest extends Base {

Utility utility = new Utility();
Library library = new Library();

    @Test
    public void VerifyLoginPageHeader() throws InterruptedException 
    {
       utility.clickOnElement(hm.getSearchBox());
       utility.enterInput(sp.getSearchBox(), "Tata");
       Thread.sleep(2000);
       utility.clickOnElement(sp.getSort());
       utility.clickOnElement(sp.getExitLoadOption());
       utility.clickOnElement(sp.getFirstCard());
       utility.clickOnElement(sp.getLoginCTA());
       utility.verify(lp.getLoginpageHeader(), "Login to the app");
    }
}
