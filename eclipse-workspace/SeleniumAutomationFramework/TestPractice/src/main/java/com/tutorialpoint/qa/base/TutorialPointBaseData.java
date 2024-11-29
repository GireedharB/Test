package com.tutorialpoint.qa.base;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class TutorialPointBaseData {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr ;
	  
	@BeforeMethod
	public void launch() throws IOException {
		
		if(driver==null) {
			fr = new FileReader (System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialpoint\\qa\\config\\tutorialpointconfig.properties");
			prop.load(fr);	
		}if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			
		}if(prop.getProperty("browser").equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
			
		}if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get(prop.getProperty("LoginTestURL"));			
		
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	

}
