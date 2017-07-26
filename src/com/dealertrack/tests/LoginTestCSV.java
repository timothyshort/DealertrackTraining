package com.dealertrack.tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class LoginTestCSV {
	static String filename = "C:\\DealerTrackTraining\\TestData\\LoginTestData.csv";
	String username, password, browserType;
	WebDriver driver;
	
	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.id("MainContent_txtUserName")).clear();
	    driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	    driver.findElement(By.id("MainContent_txtPassword")).clear();
	    driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	    
	    Thread.sleep(2500);
	    
	    driver.findElement(By.id("MainContent_btnLogin")).click();
	    String confirmation = driver.findElement(By.cssSelector("#MainContent_lblid > h1")).getText();
	    System.out.println("User: " + username + "\nMessage: " + confirmation);
	}
	
	// This function will fetch the data and return as a List<String[]>
	@Parameters
	public static List<String[]> getCSVData() {
		// Calling a function that returns data from CSV file (List<String[]>)
		// Returning that same value
		return utilities.CSV.read(filename);
	}
	
	public LoginTestCSV(String username, String password, String browserType) {
		this.username = username;
		this.password = password;
		this.browserType = browserType;
	}
	
	@Before
	public void setUp() {
		driver = utilities.DriverFactory.get(browserType);
		driver.get("http://sdettraining.com/trguitransactions/Account.aspx");
	}
	@After
	public void tearDown() {
		driver.quit();
	}

}