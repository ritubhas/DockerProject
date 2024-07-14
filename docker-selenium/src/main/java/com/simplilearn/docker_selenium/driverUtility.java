package com.simplilearn.docker_selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class driverUtility {
	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static String chrome_remote_url="http://localhost:4444/";
	public static String firefox_remote_url="http://localhost:4442/";
	
	public void threadSetup(String browserName) throws MalformedURLException {
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			driver.set(new RemoteWebDriver(new URL(chrome_remote_url),options));
		}else if(browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			driver.set(new RemoteWebDriver(new URL(firefox_remote_url),options));
		}
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	public void quitDriver() {
		getDriver().quit();
	}
	
}
