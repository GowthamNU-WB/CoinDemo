package com.zeroda.GenericLibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.MutableCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners(ExtentReportListener.class)
public class Base extends Library {
    public AppiumDriver driver;
    public static ExtentTest test;

    // Capabilities stored as class-level attributes
    private MutableCapabilities mc;

    @BeforeTest
    public void setupCapabilities(ITestContext context) {
        // Define shared capabilities
        mc = new MutableCapabilities();
        mc.setCapability("platformName", "Android");
        mc.setCapability("appium:deviceName", "Android Device");
        mc.setCapability("appium:platformVersion", "15.0.0");
        mc.setCapability("appium:automationName", "UIAutomator2");
        mc.setCapability("appium:ensureWebviewsHavePages", true);
        mc.setCapability("appium:nativeWebScreenshot", true);
        mc.setCapability("appium:newCommandTimeout", 3600);
        mc.setCapability("appium:connectHardwareKeyboard", true);
        mc.setCapability("appium:appPackage", "com.zerodha.coin");
        mc.setCapability("appium:appActivity", "com.zerodha.coin.MainActivity");
        mc.setCapability("appium:noReset", true);

        // Store capabilities in the context for reuse
        context.setAttribute("driverCapabilities", mc);
    }

    @BeforeClass
    public void setupDriver(ITestContext context) throws MalformedURLException, InterruptedException {
        // Retrieve capabilities from the context
        mc = (MutableCapabilities) context.getAttribute("driverCapabilities");

        // Initialize AppiumDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), mc);

        // Store driver in the context for reuse
        context.setAttribute("driver", driver);

        // Wait to stabilize the app
        Thread.sleep(5000);

        initializePages(driver); // Initialize page objects
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        // Create a test entry in Extent Report
        test = ExtentReportListener.extentReports.createTest(result.getMethod().getMethodName());
        test.info("Test Started");

        // Ensure the app is active before each method
        if (driver != null) {
            ((AndroidDriver) driver).activateApp("com.zerodha.coin");
        }
    }

    @AfterMethod
    public void afterMethod() {
        // Log test completion in Extent Report
        test.info("Test Ended");
    }

    @AfterClass
    public void tearDownDriver(ITestContext context) {
        // Terminate the driver and clean up
        if (driver != null) {
            ((AndroidDriver) driver).terminateApp("com.zerodha.coin");
            driver.quit();
        }
        driver = null;

        // Remove the driver from the context
        context.removeAttribute("driver");
    }

    @AfterTest
    public void teardown() {
        // Log teardown into Extent Report
        if (driver != null) {
            driver.quit();
        }
    }
}
