package com.demoaut.newtours.MavenDemo;


import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.demout.newtours.MavenDemo.Login;


public class ValidateUserTest  extends BaseTest {
	
	
	@Test
	public void userValidationTest() {
		Login lp = new Login(driver);
		lp.applicationLogin("mercury", "mercury");
		
		boolean signOfPresent = driver.findElement(By.linkText("SIGN-OFF")).isDisplayed();
		Assert.assertTrue(signOfPresent);
}
	
	
}
