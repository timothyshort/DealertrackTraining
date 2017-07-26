package com.dealertrack.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Introduction {

	public static void main(String[] args) {
		// 0. Create the WebDriver object
		System.setProperty("webdriver.chrome.driver", "C:\\DealerTrackTraining\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// 1. Open the browser to a page
		driver.get("http://sdettraining.com/trguitransactions/Account.aspx");
		
		// 3. Enter email
			// 1. Tell Selenium to find the element
			// 2. Tell Selenium to action we want
			// 3. Pass any appropriate parameters
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		
		// 4. Enter password
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		
		// 5. Click login
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
		// 6. Confirmation
		String confirmation = driver.findElement(By.id("MainContent_lblid")).getText();
		System.out.println(confirmation);
		
		// 7. Test
		// .equals --> two values must be SAME
		// .contains --> one value must be within the other
		if (confirmation.contains("Welcome back")) {
			System.out.println("TEST PASSED");
		}
		else {
			System.out.println("TEST FAILED");
		}
		
		
		// 8. Close the browser
		driver.quit();
	}

}
