package com.dealertrack.testframeworks;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitTesting {
	
	WebDriver driver;
	
	@Test
	public void myFirstJUnitTest() {
		driver.get("http://www.google.com");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		// Does our page title contain "Google"?
		Assert.assertTrue(pageTitle.contains("Google"));
		snap(driver, "Google_HomePage");
		
	}
	
	@Test
	public void mySecondJUnitTest() {
		driver.get("http://www.trainingrite.com");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertTrue(pageTitle.contains("TrainingRite"));
		snap(driver, "TrainingRite_HomePage");
	}
	
	@Test
	public void myThirdUnitTest() {
		driver.get("http://www.dealertrack.ca");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertTrue(pageTitle.contains("Dealertrack"));
		// Assert.fail("This test failed");
		
		// Call the method and pass appropriate parameters
		snap(driver, "Dealertrack_HomePage");
	}
	
	@Before
	public void setUp() {
		// System.setProperty("webdriver.chrome.driver", "C:\\DealerTrackTraining\\Software\\chromedriver.exe");
		// driver = new ChromeDriver();
		driver = utilities.DriverFactory.get("IE");
		driver = utilities.DriverFactory.get();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	// This method takes a screenshot of the browser and saves as a file
	private static void snap(WebDriver driver, String filename) {
		File ScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Create file from the screenshot of driver
		try {
			FileUtils.copyFile(ScreenshotFile, new File ("C:\\DealerTrackTraining\\TestOutput\\" + filename + ".jpg"));
		} catch (IOException e) {
			System.out.println("Could not save the file");
			e.printStackTrace();
		}
	}
	
	

}
