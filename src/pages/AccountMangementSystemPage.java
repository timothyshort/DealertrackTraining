package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountMangementSystemPage {
	
	public static void clickAMS(WebDriver driver) {
		driver.findElement(By.linkText("Account Management System")).click();
	}
	
	
	public static String pageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	
	
	// Other possible actions / elements on page
	
	public static void clickLoanDelivery(WebDriver driver) {
		driver.findElement(By.linkText("Loan Delivery Application")).click();
	}

}
