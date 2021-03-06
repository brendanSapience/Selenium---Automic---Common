package com.automic.commons;

import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.internal.WrapsDriver;
public class WebElementExtender {     
	public static void highlightElement(WebElement element) {      
		for (int i = 0; i < 5; i++) {        
			WrapsDriver wrappedElement = (WrapsDriver) element;        
			JavascriptExecutor driver = (JavascriptExecutor)          wrappedElement.getWrappedDriver();        
			driver.executeScript("arguments[0].setAttribute('style',          arguments[1]);",                  element, "color: green; border: 2px solid yellow;");        
			driver.executeScript("arguments[0].setAttribute('style',          arguments[1]);",                  element, "");      
		}  
	} 
}