package com.dealertrack.testframeworks;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class TestNGwithDataProvider {
  @Test(dataProvider = "dp")
  public void creditCarAppTest(String name, int creditScore, double annualSalary, double currentDebt) {
	  System.out.println("Applicant Name: " + name);
	  System.out.println("Applicant Credit Score: " + creditScore);
	  System.out.println("Applicant Annual Salary: " + annualSalary);
	  System.out.println("Applicant Current Debt: " + currentDebt);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Running before");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Running after\n");
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "John", 650, 85000, 35000 },
      new Object[] { "Rachel", 720, 80000, 20000 },
      new Object[] { "Will", 585, 75000, 65000 }
    };
  }
}
