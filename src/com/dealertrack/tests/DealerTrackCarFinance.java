package com.dealertrack.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class DealerTrackCarFinance {
	
	// This test will simulate a user behavior from home page through finance page
	@Test
	public void checkFinance() throws InterruptedException {
		
		String browserType = "chrome";
		String url = "https://vtmsdemoca.cms.dealer.com";
		String carMake = "Dodge";
		
		// 1. Navigate to home page >> Click on New Inventory >> Click on New Vehicles
		WebDriver driver = utilities.DriverFactory.get(browserType, url);
		driver.findElement(By.linkText("New Inventory")).click();
		driver.findElement(By.partialLinkText("New Vehicles")).click();
		
		// 2. Search for a Car and hit ENTER
		driver.findElement(By.name("search")).sendKeys(carMake + Keys.ENTER);
		
		// 3. Modify search criteria
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input[type=radio][name=internetPrice]")).click();
			// add more criteria (Price) >> wait(3000), then do same as above)
		
		// 4. Select car
		// driver.findElement(By.cssSelector("img[class='photo thumb']")).click();			// Using CSS Selector for image
		driver.findElement(By.partialLinkText("Dodge")).click();							// Using Partial Link Text
		// driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/div/div[2]/form/div/div[2]/ul[1]/li[1]/div[1]/div/div[1]/a/img")).click();
		
		// 5. Assertion checkpoint: Take Screenshot. Print + Assert Car Type. Print Car Price
		utilities.Screenshot.snap(driver, carMake + "-1-carPage");
		
		String carPageHeader = driver.findElement(By.cssSelector("h1[class=ddc-page-title]")).getText();
		System.out.println("Car: " + carPageHeader);
		Assert.assertTrue(carPageHeader.contains(carMake));
		
		String carPrice = driver.findElement(By.cssSelector("span[class='msrp final-price']")).getText();
		System.out.println("Car Price: " + carPrice);
		
		// 6. Click personalize payments
		driver.findElement(By.partialLinkText("Personalize Payments")).click();
		Thread.sleep(2000);
		
		// >>> SWITCH TO PAYMENT IFRAME
		// driver.switchTo().frame(1);
		// Call switchFrame:
		driver.switchTo().frame(utilities.DriverFactory.switchFrames(browserType, 1));
		System.out.println(driver.findElement(By.xpath("//*[@id='PDcalculatorContainer']/div[4]/ul/li[1]/a")).getText());
		
		// TO SWTICH BACK TO PARENT
		// driver.switchTo().parentFrame();
		
		// 7. Modify our payment terms: duration, frequency, down-payment
		driver.findElement(By.cssSelector("label[for=Term48]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("label[for=frequency_2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='loan']/div[2]/div[2]/div[3]/input")).click();
		driver.findElement(By.xpath("//*[@id='loan']/div[2]/div[2]/div[3]/input")).sendKeys("5500" + Keys.TAB);
		Thread.sleep(1000);
		utilities.Screenshot.snap(driver, carMake + "-2-paymentTerms");
		
		// 8. Print finance summary
		driver.findElement(By.cssSelector("div[translate=FinancePaymentSummary]")).click();
		String financeSummary = driver.findElement(By.cssSelector("div[translate=FinancePaymentSummary]")).getText();
		System.out.println("SUMMARY: " + financeSummary);
		
		// 9. Get Pre-qualified
		driver.findElement(By.id("button_PREQ")).click();
		
		// 10. Assert Confirmation Page
		String confirmation = driver.findElement(By.xpath("//*[@id='applicantBasicInfo']/div[2]/h4")).getText();
		System.out.println("Confirmation: " + confirmation);
		Assert.assertTrue(confirmation.contains("Contact"));
		utilities.Screenshot.snap(driver, carMake + "-3-confirmation");
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
