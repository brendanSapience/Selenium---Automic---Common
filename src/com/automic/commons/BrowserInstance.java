package com.automic.commons;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.os.WindowsRegistryException;
import org.openqa.selenium.os.WindowsUtils;

public class BrowserInstance {

	public String DriverFile;
	public String UserData;
	private WebDriver driver;
	public String BrowserName;
	private static String ChromeProperty = "webdriver.chrome.driver";
	
	public BrowserInstance(String DriverFile, String UserData){
		this.DriverFile = DriverFile;
		this.UserData = UserData;
		initiateWebDriver();
	}
	
	private void initiateWebDriver(){
		if(this.DriverFile.contains("chrome")){
			try{
				
				WindowsUtils.tryToKillByName("chrome.exe");  
				WindowsUtils.tryToKillByName("chromedriver.exe"); 
			}catch (WindowsRegistryException e){
				
			}catch (RuntimeException r){
				
			}

			BrowserName = "CHROME";
			File file = new File(this.DriverFile);
	    	System.setProperty(ChromeProperty, file.getAbsolutePath());
	    	ChromeOptions options = new ChromeOptions();
	        if(!this.UserData.equals("")){options.addArguments(this.UserData);}
	        //options.addArguments("--start-maximized"); // do we need this?	        
	        this.driver = new ChromeDriver(options);
	        this.driver.manage().window().maximize(); 
		}
		// Firefox Connection
    	//File file = new File("C:/temp/geckodriver.exe");
    	//System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
    	//ProfilesIni profile = new ProfilesIni();

    	//FirefoxProfile myprofile = profile.getProfile("infor");
    	//FirefoxProfile myprofile = profile.getProfile("C:/Users/brend/AppData/Local/Mozilla/Firefox/Profiles/mbyr0wpb.infor");
    	//WebDriver driver = new FirefoxDriver(myprofile);
		
		// support for other browsers / drivers here
	}
	
	public WebDriver getDriver(){
		return this.driver;
	}
}
