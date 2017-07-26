package com.dealertrack.tests;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReadCSVTest {
	
	@Test
	public void csvTest() {
		WebDriver driver;
		
		// Call a function to fetch the data
		// Get test data here: http://sdettraining.com/projects/dealertrack/
		List<String[]> dataSet = utilities.CSV.read("C:\\DealerTrackTraining\\TestData\\AccountTestData.csv");
		
		
		
		// Iterate through entire dataSet by element using a nested For-Each loop
		/*
		for (String[] record : dataSet) {
			System.out.print("[ ");
			for (String dataField : record) {
				System.out.print(dataField + " ");
			}
			System.out.println(" ]");
		}
		*/
		
		// Generate an array for each record in the dataSet list
		for (String[] record : dataSet) {
			driver = utilities.DriverFactory.get();
			System.out.println("*****NEW TEST****");
			// Parse array elements into local variables
			String firstName = record[0];
			String lastName = record[1];
			String gender = record[2];
			String email = record[3];
			String password = record[4];
			String homePhone = record[5];
			String cellPhone = record[6];
			String country = record[7];
			String weeklyEmail = record[8];
			String monthlyEmail = record[9];
			String occassionalEmail = record[10];
			
			String baseUrl = "http://sdettraining.com/trguitransactions/Register.aspx";
			driver.get(baseUrl);
			
		    driver.findElement(By.id("MainContent_txtFirstName")).clear();
		    driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(firstName);
		    driver.findElement(By.id("MainContent_txtLastName")).clear();
		    driver.findElement(By.id("MainContent_txtLastName")).sendKeys(lastName);
		    
		    // How to handle radio button >>  Gender?
		    if (gender.equalsIgnoreCase("Male")) {
		    	driver.findElement(By.id("MainContent_Male")).click();
		    } else {
		    	driver.findElement(By.id("MainContent_Female")).click();
		    }
		    
		    driver.findElement(By.id("MainContent_txtEmail")).clear();
		    driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);
		    driver.findElement(By.id("MainContent_txtPassword")).clear();
		    driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		    driver.findElement(By.id("MainContent_txtVerifyPassword")).clear();
		    driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys(password);
		    
		    // How to handle checkboxes >> email subscriptions?
		    if (weeklyEmail.equalsIgnoreCase("true")) {
		    	if (!driver.findElement(By.id("MainContent_checkWeeklyEmail")).isSelected()) {
		    		driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
		    	}
		    }
		    else {
		    	if (driver.findElement(By.id("MainContent_checkWeeklyEmail")).isSelected()) {
		    		driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
		    	}
		    }
		    
		    utilities.Screenshot.snap(driver, lastName);
		    
		    driver.findElement(By.id("MainContent_btnSubmit")).click();
		    
		    // code to get confirmation text
		    // print confirmation
			
			driver.close();
		}
		
	}

}
