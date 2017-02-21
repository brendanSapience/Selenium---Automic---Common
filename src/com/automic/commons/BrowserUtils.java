package com.automic.commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    
public static void WaitForElementClickable(WebDriver driver, String ElementID, int timeout){
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	wait.until(ExpectedConditions.elementToBeClickable(By.id(ElementID)));
}

public static void WaitForElementVisible(WebDriver driver, String ElementID, int timeout){
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ElementID)));
}

public static void ShowContent(WebElement element){
	 List<WebElement> allFormChildElements = element.findElements(By.cssSelector("*"));
       System.out.println("Size: "+ allFormChildElements.size());
       for(WebElement item : allFormChildElements ){
    	   String name = item.getAttribute("name");
    	   String id = item.getAttribute("id");
    	   String myclass = item.getAttribute("class");
    	   if(name != null){System.out.println("Element Name: " + name);}
    	   if(id != null){System.out.println("Element id: " + id);}
    	   if(myclass != null){System.out.println("Element class: " + myclass);}
       }
}

public static void ShutdownDriver(WebDriver driver){
	Msgs.showInfo("Shutting Down Driver.");
	driver.quit();
}
public static void Sleep(int seconds){
    try {
		Thread.sleep(seconds*1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
