package com.simplilearn.docker_selenium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass2 extends driverUtility {

	@Test(priority = 1, groups = { "grp" })
	@Parameters({ "environment" })
	public void tc1(String environment) throws MalformedURLException, InterruptedException {
		if (environment.equalsIgnoreCase("local")) {
			threadSetup("firefox");
		}
		WebDriver driver = getDriver();
		driver.navigate().to("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		try {
			driver.findElement(By.id("username")).sendKeys("hiraanachwani007");

			// Enter the password
			driver.findElement(By.id("password")).sendKeys("Hiraa@90111");

			// Click the login button
			driver.findElement(By.id("login")).click();

			// Assert that the title of the page after login is as expected
			Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (getDriver() != null) {
			quitDriver();
		}
	}

}

