package com.dealertrack.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) throws InterruptedException {
		
		// We will test a new account
		
		// Declare variables
		String lastName;
		
		// 1. Create WebDriver object
		System.setProperty("webdriver.gecko.driver", "C:\\DealerTrackTraining\\Software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		// 2. Open the browser to base page --> .get() method
		driver.get("http://sdettraining.com/projects/");
		
		// 3. Navigate to AMS
		driver.findElement(By.linkText("Account Management System")).click();
		
		// Thread.sleep(3000);
		
		try {
		
			// 4. Click on New Account
			driver.findElement(By.id("createaccount")).click();
			
		} catch (NoSuchElementException e) {
			System.out.println("Element not on page. Maybe needs to load??");
		}
		
		// 4. Fill in the new account registration information
		
		String firstName = "Barry";
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys(firstName);
		
		// Relative XPath
		driver.findElement(By.xpath("//*[@id='MainContent_txtLastName']")).sendKeys("Williams");
		// Absolute XPath
		driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/div[2]/div[2]/input")).sendKeys("Williams");
		
		// Select Country
		new Select(driver.findElement(By.name("ctl00$MainContent$menuCountry"))).selectByVisibleText("Croatia");
				
		// Ensure that Monthly Subscription IS CHECKED
		// if NOT (monthlysubscription is checked)
		// then, click monthlysubscription
		if (!driver.findElement(By.id("MainContent_checkMonthlyEmail")).isSelected()) {
			driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
		}
		else {
		}
		
		
		/*
		 * Name >> SendKeys
		 * Gender >> Click
		 * Country >> new Select
		 * Subscriptions >> Click
		 * Register Button >> Click
		*/
	}

}
