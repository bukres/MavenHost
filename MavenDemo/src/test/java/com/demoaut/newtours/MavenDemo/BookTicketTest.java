package com.demoaut.newtours.MavenDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demout.newtours.MavenDemo.BookAFlight;
import com.demout.newtours.MavenDemo.FlightConfirmation;
import com.demout.newtours.MavenDemo.FlightFinder;
import com.demout.newtours.MavenDemo.Login;
import com.demout.newtours.MavenDemo.SelectFlight;

public class BookTicketTest extends BaseTest {
	
WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://newtours.demoaut.com");
	}
	
	@Test
	public void ticketBookingTest() {
		Login lp = new Login(driver);
		FlightFinder ff = new FlightFinder(driver);
		SelectFlight sf = new SelectFlight(driver);
		BookAFlight bf = new BookAFlight(driver);
		FlightConfirmation fc = new FlightConfirmation(driver);
		
		
		
		
		lp.applicationLogin("mercury", "mercury");
		ff.findFlight();
		sf.flightSelection();
		bf.flightBooking("Amel", "Kuburovic", "123456789");
		
		String expectedMessage = "Your itinerary has been booked!";
		String actualMessage = fc.messageCss.getText();
		
		Assert.assertEquals(actualMessage, expectedMessage);
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	

}

	
	


