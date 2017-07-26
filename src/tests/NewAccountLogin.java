package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class NewAccountLogin {
	WebDriver driver;
	String firstName = "Jane";
	String lastName = "Johns";
	String gender = "Female";
	
	@Before
	public void setUp() {
		driver = utilities.DriverFactory.get();
		driver.get("http://sdettraining.com/projects/");
	}
	
	@Test
	public void newAccountAndLoginTest() {
		// 1. Code to navigate to home + click Account Management System
		pages.AccountMangementSystemPage.clickAMS(driver);
		String title = pages.AccountMangementSystemPage.pageTitle(driver);
		
		// 2. Click create account
		pages.HomePage.clickCreateAccount(driver);
		
		// 3. Fill out form to create a new user
		/* Using option 1 - call each method explicitly
		pages.CreateAccountPage.firstName(driver, firstName);
		pages.CreateAccountPage.lastName(driver, lastName);
		pages.CreateAccountPage.gender(driver, gender);
		*/
		// Using option 2 - call one action method
		pages.CreateAccountPage.fillForm(driver, firstName, lastName, gender);
		
		// Assert new user was created
		
		// 4. Navigate to AMS Page + Login
		
		// 5. DashboardPage - confirmation
		
	}

}
