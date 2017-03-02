package com.automic.logins;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automic.commons.CustomWebElement;
import com.automic.commons.Msgs;

public class StdLoginHandler {

	
	public StdLoginHandler(){

	}
	
	public void HandleLogin(String UsernameValue, CustomWebElement UsernameEl, String PasswordValue, CustomWebElement PasswordEl, CustomWebElement OKButton){
		 try {
    		 Msgs.showInfo("Looking For Login Screen.");
    		 //WebElement query =  Driver.findElement(By.id("ctl00_ContentPlaceHolder1_UsernameTextBox"));
    		 Msgs.showInfo("Login Screen Detected.");
    		 if(!UsernameValue.equals("")){UsernameEl.GetWebElement().clear();}
    		 if(UsernameEl!=null){UsernameEl.GetWebElement().sendKeys(UsernameValue);}
    		// query =  Driver.findElement(By.id("ctl00_ContentPlaceHolder1_PasswordTextBox"));
    		 if(!PasswordValue.equals("")){ PasswordEl.GetWebElement().clear();}
    		 if(PasswordEl!=null){PasswordEl.GetWebElement().sendKeys(PasswordValue);}
    		 //query =  Driver.findElement(By.id("ctl00_ContentPlaceHolder1_SubmitButton"));
    		 OKButton.GetWebElement().click();
    	    } catch (NoSuchElementException e) {
    	    	Msgs.showSuccess("No Login Screen Detected!");
    	    }
	}
}
