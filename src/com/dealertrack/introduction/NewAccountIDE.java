package com.dealertrack.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewAccountIDE {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\DealerTrackTraining\\Software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://sdettraining.com/";
		
		driver.get(baseUrl + "/projects/");
	    driver.findElement(By.linkText("Account Management System")).click();
	    driver.findElement(By.id("createaccount")).click();
	    driver.findElement(By.id("MainContent_txtFirstName")).clear();
	    driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Tim");
	    driver.findElement(By.id("MainContent_txtLastName")).clear();
	    driver.findElement(By.id("MainContent_txtLastName")).sendKeys("Short");	    
	    driver.findElement(By.id("MainContent_Male")).click();
	    driver.findElement(By.id("MainContent_txtEmail")).clear();
	    driver.findElement(By.id("MainContent_txtEmail")).sendKeys("tim@trmail.com");
	    driver.findElement(By.id("MainContent_txtPassword")).clear();
	    driver.findElement(By.id("MainContent_txtPassword")).sendKeys("pass");
	    driver.findElement(By.id("MainContent_txtVerifyPassword")).clear();
	    driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("pass");
	    driver.findElement(By.id("MainContent_btnSubmit")).click();
	}

}
