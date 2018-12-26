package com.website.ezmall.qa.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.website.ezmall.qa.base.TestBase;

public class CommonMethods extends TestBase{
	


	public static void mouseHoverToElemnet(WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();

	}

	public static void clickElementUsingJavascript(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	
	public static void enterTextInWebelement(WebElement element , String text){
		element.sendKeys(text);
		
	}
	
	
	public  static String getText(WebElement element){
		return element.getText();		
	}
	
	
	
	
	
	

}
