package com.zoho.qa.testcases;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.zoho.qa.base.ZohoBasedata;
import com.zoho.qa.utilities.ZohoFileReader;

public class TestZohoTC1 extends ZohoBasedata {
	@Test(dataProviderClass = ZohoFileReader.class, dataProvider = "logintestdata")
	public void ZohoLogin(String username, String password) {
		driver.findElement(By.linkText(pr.getProperty("SignIn_Linktext"))).click();
		driver.findElement(By.id(pr.getProperty("loginid_username_id"))).sendKeys(username);
		driver.findElement(By.id(pr.getProperty("nextbtn_button_id"))).click();
		driver.findElement(By.id(pr.getProperty("password_pass_id"))).sendKeys(password);
		driver.findElement(By.id(pr.getProperty("nextbtn_buttonaftpass_id"))).click();
		driver.findElement(By.xpath(pr.getProperty("Loginbutton_Xpath"))).click();
	}
		
	}


