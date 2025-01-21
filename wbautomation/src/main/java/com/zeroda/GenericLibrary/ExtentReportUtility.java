package com.zeroda.GenericLibrary;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

    private static ExtentReports extentReports;
    private static ExtentTest test;

    static {
        // Initialize the ExtentReports instance
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    public static void startTest(String testName) {
        test = extentReports.createTest(testName);
    }

    public static void logTestStatus(String status, String message) {
        switch (status.toLowerCase()) {
            case "pass":
                test.pass(message);
                break;
            case "fail":
                test.fail(message);
                break;
            case "skip":
                test.skip(message);
                break;
            default:
                test.info(message);
                break;
        }
    }

    public static void flushReport() {
        extentReports.flush();
    }
}

