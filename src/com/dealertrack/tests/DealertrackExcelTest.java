package com.dealertrack.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * DataProvider - TestNG FRAMEWORK!!:
 * 1. Define data provider function:
 *    MUST have @DataProvider annotation
 *    MUST return [][]
 * 2. Test method - use @Test(dataProvider="nameofdataproviderfunction")
 * 3. Variables get parsed into @Test function's arguments
 *    If the number of parameters != the number of fields in dataset >> Data provider mismatch error
 */

public class DealertrackExcelTest {
	WebDriver driver;
	String browserType = "chrome";
	String url = "https://vtmsdemoca.cms.dealer.com";
	static int testNumber = 0;
	
		// This test will simulate a user behavior from home page through finance page
		@Test(dataProvider="getExcelData")
		public void checkFinance(String carMake, String searchParam1, String searchParam2,
				String pymntDuration, String pymntFrequency, String downPayment,
				String expectedValue) throws InterruptedException {
			
			testNumber++;

			// 1. Navigate to home page >> Click on New Inventory >> Click on New Vehicles
			driver.findElement(By.linkText("New Inventory")).click();
			driver.findElement(By.partialLinkText("New Vehicles")).click();
			
			// 2. Search for a Car and hit ENTER >> use carMake
			driver.findElement(By.name("search")).sendKeys(carMake + Keys.ENTER);
			
			// 3. Modify search criteria >> use searchParam1 and searchParam2
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input" + searchParam1 + searchParam2)).click();
			
			// 4. Select car >> use carMake
			// driver.findElement(By.cssSelector("img[class='photo thumb']")).click();			// Using CSS Selector for image
			driver.findElement(By.partialLinkText(carMake)).click();							// Using Partial Link Text
			// driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/div/div[2]/form/div/div[2]/ul[1]/li[1]/div[1]/div/div[1]/a/img")).click();
			
			// 5. Assertion checkpoint: Take Screenshot. Print + Assert Car Type. Print Car Price
			utilities.Screenshot.snap(driver, testNumber + "-" + carMake + "-1-carPage");
			
			String carPageHeader = driver.findElement(By.cssSelector("h1[class=ddc-page-title]")).getText();
			System.out.println("Car: " + carPageHeader);
			Assert.assertTrue(carPageHeader.contains(carMake));
			
			String carPrice = driver.findElement(By.cssSelector("span[class='msrp final-price']")).getText();
			System.out.println("Car Price: " + carPrice);
			
			// 6. Click personalize payments
			driver.findElement(By.partialLinkText("Personalize Payments")).click();
			Thread.sleep(2000);
			
			// >>> SWITCH TO PAYMENT IFRAME
			driver.switchTo().frame(utilities.DriverFactory.switchFrames(browserType, 1));
			System.out.println(driver.findElement(By.xpath("//*[@id='PDcalculatorContainer']/div[4]/ul/li[1]/a")).getText());
			
			// 7. Modify our payment terms: duration, frequency, down-payment
			// >> use pymntFrequency, pymntDuration, downPayment
			driver.findElement(By.cssSelector("label[for=" + pymntDuration +  "]")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("label[for=" + pymntFrequency + "]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='loan']/div[2]/div[2]/div[3]/input")).click();
			driver.findElement(By.xpath("//*[@id='loan']/div[2]/div[2]/div[3]/input")).sendKeys(downPayment + Keys.TAB);
			Thread.sleep(1000);
			utilities.Screenshot.snap(driver,  testNumber + "-" + carMake + "-2-paymentTerms");
			
			// 8. Print finance summary
			driver.findElement(By.cssSelector("div[translate=FinancePaymentSummary]")).click();
			String financeSummary = driver.findElement(By.cssSelector("div[translate=FinancePaymentSummary]")).getText();
			System.out.println("SUMMARY: " + financeSummary);
			
			// 9. Get Pre-qualified
			driver.findElement(By.id("button_PREQ")).click();
			
			// 10. Assert Confirmation Page >> use expectedValue
			String confirmation = driver.findElement(By.xpath("//*[@id='applicantBasicInfo']/div[2]/h4")).getText();
			System.out.println("Confirmation: " + confirmation);
			Assert.assertTrue(confirmation.contains(expectedValue));
			utilities.Screenshot.snap(driver, testNumber + "-" + carMake + "-3-confirmation");
		}
		
		@DataProvider
		public String[][] getExcelData() {
			String filepath = "C:\\DealerTrackTraining\\TestData\\DealerTrackTestData.xls";
			return utilities.Excel.getXLS(filepath);
		}
		/*
		@DataProvider
		public String[][] getExcelDataFirstRow() {
			String filepath = "C:\\DealerTrackTraining\\TestData\\DealerTrackTestData.xls";
			// extract one element (an array) out of the double array
			// return that array
			return excelData[1][];
		}
		*/
		
		@BeforeMethod
		public void setUp() {
			driver = utilities.DriverFactory.get(browserType, url);
		}
		
		@AfterMethod
		public void tearDown() throws InterruptedException {
			Thread.sleep(3000);
			driver.quit();
		}

}
