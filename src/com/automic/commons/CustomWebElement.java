package com.automic.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomWebElement {

	public String ElType;
	public String ElIdentifier;
	public WebDriver driver;
	
	public CustomWebElement(WebDriver driver, String Identifier, String Type){
		this.driver = driver;
		this.ElIdentifier = Identifier;
		this.ElType = Type;
		
	}
	
	public WebElement GetWebElement(){
		WebElement el = null;
		if(this.ElType.equalsIgnoreCase("xpath")){el = driver.findElement(By.xpath(this.ElIdentifier));}
		if(this.ElType.equalsIgnoreCase("id")){el = driver.findElement(By.id(this.ElIdentifier));}
		if(this.ElType.equalsIgnoreCase("name")){el = driver.findElement(By.name(this.ElIdentifier));}
		return el;
	}
}
