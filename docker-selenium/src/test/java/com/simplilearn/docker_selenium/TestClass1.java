package com.simplilearn.docker_selenium;


import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestClass1 extends driverUtility{
	@Test(priority=1,groups= {"search"})
	@Parameters({ "environment" })
	public void tc1(String environment) throws MalformedURLException {
		String search_string="testing";
		String expected_title="testing - Google Search";
		
		if (environment.equalsIgnoreCase("local")) {
			threadSetup("chrome");
			
		}
		WebDriver driver = getDriver();
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		try {
		WebElement search_box = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		search_box.sendKeys("testing");
		search_box.submit();
		
		Thread.sleep(3000);
		
		WebElement firstLink = driver.findElement(By.xpath("(//a[@jsname='UWckNb'])[1]"));
		firstLink.click();
		Thread.sleep(5000);
		
		String currentTitle = driver.getTitle();
		Assert.assertEquals(currentTitle, expected_title);
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
		if(getDriver()!=null) {
			quitDriver();
		}
	}
	}

