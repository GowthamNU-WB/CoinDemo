package com.zeroda.GenericLibrary;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {
   public AppiumDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException, InterruptedException {
        // Define capabilities
        MutableCapabilities mc = new MutableCapabilities();       
        mc.setCapability("platformName", "Android");
        mc.setCapability("appium:deviceName", "Android Device");
        mc.setCapability("appium:platformVersion", "15.0.0");
        mc.setCapability("appium:automationName", "UIAutomator2");
        mc.setCapability("appium:ensureWebviewsHavePages", true);
        mc.setCapability("appium:nativeWebScreenshot", true);
        mc.setCapability("appium:newCommandTimeout", 3600);
        mc.setCapability("appium:connectHardwareKeyboard", true);
        mc.setCapability("appium:appPackage", "com.zerodha.coin");
   		mc.setCapability("appium:appActivity","com.zerodha.coin.MainActivity");
   		mc.setCapability("appium:noReset", true);
        											
        // Initialize AppiumDriver
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), mc);
        

        // Wait to stabilize the setup
        Thread.sleep(5000);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit(); // Close driver after tests
        }
    }
}
