package com.zeroda.GenericLibrary;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import io.appium.java_client.AppiumDriver;

@Listeners(ExtentReportListener.class)
public class Utility extends Base
{   
	 
	public void clickOnElement(WebElement Element)
	{
		String elename = Element.getAttribute("content-desc");
		try 
		{
			Element.click();
			test.pass("Clicked on " + elename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			test.fail(elename + " is not clcked");
		}
	}
	
	public void scrollDownPage(int NumberOfTimes) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement destElement = driver.findElement(By.cssSelector(".margin-05.row.sortable-list.ui-sortable"));
		jse.executeScript("arguments[0].scrollIntoView();", destElement);
		System.out.println("Scroll Down Page Succesfully....");
	}


	public void scrollUpPage(int NumberOfTimes) {
		for (int i = 0; i < NumberOfTimes; i++) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		}
	}


	public void scrollDown(int NumberOfTimes) {
		for (int i = 0; i < NumberOfTimes; i++) {
			WebElement element = driver.findElement(By.xpath("/html/body"));
			element.sendKeys(Keys.PAGE_DOWN);
		}
	}


	public void scrollToElement(WebElement Element) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		System.out.println("Scroll To Page Element Succesfully....");
	}
	
	public void adjustSlider(WebElement sliderElement, double percentage, AppiumDriver driver) {
		// Validate percentage value
	    if (percentage < 0 || percentage > 100) {
	        throw new IllegalArgumentException("Percentage must be between 0 and 100.");
	    }

	    // Get the slider's dimensions and position
	    int sliderStartX = sliderElement.getLocation().getX();
	    int sliderWidth = sliderElement.getSize().getWidth();
	    int sliderY = sliderElement.getLocation().getY();

	    // Calculate the target X-coordinate based on the percentage
	    int targetX = (int) (sliderStartX + (percentage / 100.0) * sliderWidth);

	    // Use W3C Actions to drag the slider
	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence dragAndDrop = new Sequence(finger, 1);

	    // Move to the starting position of the slider
	    dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), sliderStartX, sliderY));
	    dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), targetX, sliderY));
	    dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    // Perform the action
	    driver.perform(Collections.singletonList(dragAndDrop));
	}
	
	public void verify(WebElement Element, String Expected)
	{
		String Actual = Element.getAttribute("content-desc");
		try {
		Assert.assertEquals(Actual, Expected);
		test.pass(Expected + " Sentence is displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			test.fail(Actual + " and "+ Expected + " are not equal");
		}
	}
	
	public void enterInput(WebElement Element, String Input)
	{
		//Element.sendKeys(Input, Keys.RETURN);
		Element.sendKeys(Input);
		test.pass("Entered " + Input + " into the Element");
	}
}
