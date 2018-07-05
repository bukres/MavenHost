package com.demoaut.newtours.MavenDemo;


import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.demout.newtours.MavenDemo.Login;


public class InvalidUserTest  extends BaseTest {
	
	
 @Test
 public void invalidUserTest() {
	 Login lp = new Login(driver);
		lp.applicationLogin("abc@gmail.com", "password");
		boolean signOffPresent = driver.findElement(By.linkText("SIGN-ON")).isDisplayed();
		Assert.assertTrue(signOffPresent);
		
 }
 
 
}
