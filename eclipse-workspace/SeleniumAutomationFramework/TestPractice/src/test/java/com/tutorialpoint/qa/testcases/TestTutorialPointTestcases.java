/*
Author Name: Gireedhar Anil Birajdar[Practice test for automation learning]

*/
package com.tutorialpoint.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.tutorialpoint.qa.base.TutorialPointBaseData;
import com.tutorialpoint.qa.utlities.TutorialPointForm;
import com.tutorialpoint.qa.utlities.TutorialPointRe;
import com.tutorialpoint.qa.utlities.TutorialPointUtility;

public class TestTutorialPointTestcases extends TutorialPointBaseData {
 
	@Test(priority =1, dataProviderClass = TutorialPointUtility.class, dataProvider= "tutorialpointtestdata" )
	public void login(String Username, String Password) {
		driver.findElement(By.name(prop.getProperty("Username_name_loctator_value"))).sendKeys(Username);
		driver.findElement(By.name(prop.getProperty("Password_name_loctator_value"))).sendKeys(Password);
		driver.findElement(By.xpath(prop.getProperty("Login_button_Xpath_Value"))).click();
		
	}
	@Test(priority =2, dataProviderClass= TutorialPointRe.class, dataProvider ="tutorialpointdata")
	public void Register(String FirstName,String LastName, String UserName, String Password) throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("Form_Button_Xpath_value"))).click();
		driver.findElement(By.linkText(prop.getProperty("Reg_Option_linktext_Value"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(prop.getProperty("FirstName_id_Value"))).sendKeys(FirstName);
		driver.findElement(By.id(prop.getProperty("LastName_id_Value"))).sendKeys(LastName);
		driver.findElement(By.id(prop.getProperty("Username_id_Value"))).sendKeys(UserName);
		driver.findElement(By.xpath(prop.getProperty("Password_Xpath_Value"))).sendKeys(Password);
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Register_button_Xpath_Value"))).click();
		
	}
	@Test(priority =3,dataProviderClass=TutorialPointForm.class, dataProvider= "tutorialpointformtest")
	public void Form(String Name, String Email, String Mobile,String DOB, String Subjects, String CurrentAddress, String State, String City) throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("Form_Button_Xpath_value"))).click();
		driver.findElement(By.linkText(prop.getProperty("Practice_Form_Button_linktext_Value"))).click();	
		Thread.sleep(2000);
		driver.findElement(By.id(prop.getProperty("Name_id_Value"))).sendKeys(Name);
		driver.findElement(By.id(prop.getProperty("email_id_Value"))).sendKeys(Email);
		driver.findElement(By.id(prop.getProperty("gender_id_Value"))).click();
		driver.findElement(By.id(prop.getProperty("mobile_id_Value"))).sendKeys(Mobile);
		driver.findElement(By.id(prop.getProperty("dob_id_Value"))).sendKeys(DOB);
		driver.findElement(By.id(prop.getProperty("subjects_id_Value"))).sendKeys(Subjects);
		driver.findElement(By.id(prop.getProperty("hobbies_id_Value"))).click();
		driver.findElement(By.id(prop.getProperty("picture_id_Value"))).sendKeys(prop.getProperty("picture_Sendkeys_Value"));
		driver.findElement(By.xpath(prop.getProperty("currentaddress_Xpath_Value"))).sendKeys(CurrentAddress);
		Select stateselection =  new Select (driver.findElement(By.id(prop.getProperty("state_id_Value"))));
		stateselection.selectByVisibleText(State);
		Select cityselection =  new Select (driver.findElement(By.id(prop.getProperty("city_id_Value"))));
		cityselection.selectByVisibleText(City);
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Login_button_Xpath_Value"))).click();
		
		
	}	

}

