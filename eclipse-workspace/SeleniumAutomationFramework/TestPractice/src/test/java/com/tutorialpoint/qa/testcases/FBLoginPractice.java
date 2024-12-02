package com.tutorialpoint.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FBLoginPractice {
	WebDriver driver;
	Logger log = Logger.getLogger(FBLoginPractice.class);
	
	
	
	@BeforeMethod
	public void SetUp() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 driver.get("https://www.facebook.com/");
		 
		 
	}
	@Test
	public void facebooklogin() {
		driver.findElement(By.name("email")).sendKeys("rajeshkumar321@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Rajesh@21122023");
		driver.findElement(By.name("login")).click();
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
	

}
