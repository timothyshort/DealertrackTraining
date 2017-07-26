package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {
	
	// OPTION 1: 1 public method for each field
	public static void firstName(WebDriver driver, String firstName) {
		driver.findElement(By.id("MainContent_txtFirstName")).clear();
	    driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(firstName);
	}
	public static void lastName(WebDriver driver, String lastName) {
		driver.findElement(By.id("MainContent_txtLastName")).clear();
	    driver.findElement(By.id("MainContent_txtLastName")).sendKeys(lastName);
	}
	public static void gender(WebDriver driver, String gender) {
		if (gender.equalsIgnoreCase("Male")) {
	    	driver.findElement(By.id("MainContent_Male")).click();
	    } else {
	    	driver.findElement(By.id("MainContent_Female")).click();
	    }
	}
	
	// OPTION 2: one method to handle all the parameters
	public static void fillForm(WebDriver driver, String firstName, String lastName, String gender) {
		driver.findElement(By.id("MainContent_txtFirstName")).clear();
	    driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(firstName);
	    driver.findElement(By.id("MainContent_txtLastName")).clear();
	    driver.findElement(By.id("MainContent_txtLastName")).sendKeys(lastName);
	    if (gender.equalsIgnoreCase("Male")) {
	    	driver.findElement(By.id("MainContent_Male")).click();
	    } else {
	    	driver.findElement(By.id("MainContent_Female")).click();
	    }
	}
	
	// OPTION 3: one method that calls private methods
	public static void fill(WebDriver driver, String firstName, String lastName, String gender) {
		firstName(driver, firstName);
		lastName(driver, lastName);
		gender(driver, gender);
	}

}
