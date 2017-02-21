package com.automic.commons;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;




public class ReusableRemoteWebDriver extends RemoteWebDriver{

	private String SessionID = "";
	Capabilities desiredCapabilities;

	public ReusableRemoteWebDriver(String SessionID, java.net.URL URL, DesiredCapabilities capabilities) {
		super(URL, capabilities);
		this.SessionID = SessionID;
		this.desiredCapabilities = capabilities;
	}
	
	public ReusableRemoteWebDriver(java.net.URL URL, DesiredCapabilities capabilities) {
		super(URL, capabilities);
		this.desiredCapabilities = capabilities;
	}
	
	 @Override
	  protected void startSession(Capabilities desiredCapabilities) {
	    String sid = getPreviousSessionIdFromSomeStorage();
	    if (sid != null) {
	      setSessionId(sid);
	      try {
	    	  System.out.println("Reusing Session ID!");
	        getCurrentUrl();
	      } catch (WebDriverException e) {
	        // session is not valid
	    	  System.out.println("hmm, session not valid.");
	        sid = null;
	      }
	    }
	    if (sid == null) {
	    	System.out.println("Starting new SessionID.");
	      super.startSession(desiredCapabilities);
	      saveSessionIdToSomeStorage(getSessionId().toString());
	    }
	  }
	
	private String getPreviousSessionIdFromSomeStorage(){
		return this.SessionID;
	}
	private void saveSessionIdToSomeStorage(String sessID){
		this.SessionID = sessID;
	}
	public void setSessionID(String sessID){
		this.SessionID = sessID;
	}
	public String getSessionID(){
		return getSessionId().toString();
	}
	
}
