package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public static void clickCreateAccount(WebDriver driver) {
		driver.findElement(By.id("createaccount")).click();
	}

}
