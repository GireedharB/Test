package com.zoho.qa.base;


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



public class ZohoBasedata {
	public static WebDriver driver;
	public static Properties pr = new Properties();
	public static FileReader fr;
	
	
	@BeforeMethod
	public void Setup() throws IOException {
		
		if(driver == null) {
			
			 fr = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\zoho\\qa\\config\\zohoconfig.properties");
			 
			pr.load(fr);
			
			}if(pr.getProperty("browser").equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			
		}if(pr.getProperty("browser").equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		
	}
		if(pr.getProperty("browser").equalsIgnoreCase("edge")){
			driver = new EdgeDriver();

}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get(pr.getProperty("TestURL"));
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
	
}


