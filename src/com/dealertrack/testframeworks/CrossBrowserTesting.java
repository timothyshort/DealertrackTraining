package com.dealertrack.testframeworks;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	WebDriver driver;
	
	@Test
	public void testBrowser() {
		
		
		/*
		driver = utilities.DriverFactory.get();
		System.out.println("Opening Firefox browser");
		System.setProperty("webdriver.gecko.driver", "C:\\DealerTrackTraining\\Software\\gecko.exe");
		driver.get("http://www.dealertrack.ca");
		*/
		
		
		/*
		driver = utilities.DriverFactory.get("Firefox");
		driver.get("http://www.dealertrack.ca");
		*/
		
		driver = utilities.DriverFactory.get("Firefox","http://www.dealertrack.ca");
		utilities.Screenshot.snap(driver, "Dealertrack_HomePageView");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		
	}

}
