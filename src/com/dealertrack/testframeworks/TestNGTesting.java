package com.dealertrack.testframeworks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTesting {
	
	@Test
	public void myTestNGTest() {
		System.out.println("Executing test");
	}
	@Test
	public void myTestNGTest2() {
		System.out.println("Executing second test");
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Set up");
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Tear down");
	}

}
