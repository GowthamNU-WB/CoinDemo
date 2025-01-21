package com.zeroda.GenericLibrary;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ExtentReportListener extends Base implements ITestListener {
    
    public static ExtentReports extentReports;
    private AppiumDriver driver; // Now using AppiumDriver specifically
  

    static {
        // Initialize the ExtentReports instance
    	String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReport"+ timestamp + ".html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
    	
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed successfully");
        System.out.println("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test failed: " + result.getThrowable());
        System.out.println("Test failed: " + result.getMethod().getMethodName());
        test.fail(result.getThrowable());
        
     // Take screenshot on failure
        takeScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped: " + result.getMethod().getMethodName());
        System.out.println("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        System.out.println("Test suite finished: " + context.getName());
    }

    private void takeScreenshot(ITestResult result) {
        // Get the WebDriver instance
        driver = (AppiumDriver) result.getTestContext().getAttribute("driver");

        // Generate a unique screenshot file name based on the current time
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String screenshotName = result.getMethod().getMethodName() + "_" + timestamp + ".png";
        
        // Take screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        // Define the path where the screenshot will be saved
        File destination = new File("screenshots/" + screenshotName);

        try {
            // Copy the screenshot to the desired location
            FileUtils.copyFile(screenshotFile, destination);

            // Attach the screenshot to the report
            test.addScreenCaptureFromPath(destination.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
